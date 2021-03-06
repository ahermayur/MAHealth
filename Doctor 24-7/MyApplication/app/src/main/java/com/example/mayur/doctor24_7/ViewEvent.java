package com.example.mayur.doctor24_7;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.mayur.doctor24_7.RestAPI.RestAPI;
import com.example.mayur.doctor24_7.Sharepreferance.AlertDialogManager;
import com.example.mayur.doctor24_7.Sharepreferance.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Date;

public class ViewEvent extends AppCompatActivity {

    Context context;
    ListView lv_event;
    String[] title;
    int size;
    String[] address;
    int id[];
    String[] startdate;
    String[] enddate;
    String[] description;
    RadioButton radio_all,radio_today;
    java.util.Calendar cal2;
    int day = 0;
    int month = 0;
    int year = 0;
    String temp_date;
    Date today;
    ImageView img_search;
    AsyncRegisterEvent asyncRegisterEvent;
    private ProgressDialog progress;
    SessionManager session;
    AlertDialogManager alert = new AlertDialogManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);
        context=getApplicationContext();
        session = new SessionManager(getApplicationContext());

        progress= new ProgressDialog(this);
        progress.setIndeterminate(true);
        progress.setMessage("Loading...");

        lv_event=(ListView)findViewById(R.id.lv_event1);
        radio_all=(RadioButton)findViewById(R.id.radio_all1);
        radio_today=(RadioButton)findViewById(R.id.radio_today1);
        img_search=(ImageView)findViewById(R.id.img_search1);

        java.util.Calendar cal= java.util.Calendar.getInstance();
        temp_date = cal.get(java.util.Calendar.DAY_OF_MONTH)+"/"+(cal.get(java.util.Calendar.MONTH)+1)+"/"+cal.get(java.util.Calendar.YEAR);


        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_today.isChecked()==true)
                {
                    new AsyncGetTodayEvent1().execute();
                }
                else
                {
                    new AsyncGetAllEvent1().execute();
                }
            }
        });

        lv_event.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DisplayDialog(position);
            }
        });
    }
    private void DisplayDialog(final int position) {
        final Dialog dialog = new Dialog(ViewEvent.this);
        dialog.setContentView(R.layout.custom_description);
        dialog.setTitle(" Event ");
        TextView tv_title=(TextView)dialog.findViewById(R.id.tv_d_event_title);
        TextView tv_address=(TextView)dialog.findViewById(R.id.tv_d_address);
        TextView tv_description=(TextView)dialog.findViewById(R.id.tv_d_discription);
        TextView tv_startdate=(TextView)dialog.findViewById(R.id.tv_d_event_startdate);
        TextView tv_enddate=(TextView)dialog.findViewById(R.id.tv_d_event_enddate);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_event_ok);
        Button btn_action = (Button) dialog.findViewById(R.id.btn_event_action);
        tv_description.setText(description[position]+"");
        tv_title.setText(""+title[position]+"");
        tv_address.setText(""+address[position]);
        tv_startdate.setText(startdate[position]+"");
        tv_enddate.setText(enddate[position]+"");
        btn_action.setText("Register Event");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncRegisterEvent= (AsyncRegisterEvent) new AsyncRegisterEvent().execute(position);
            }
        });
        dialog.show();
    }

    private class CAdapter1 extends BaseAdapter {
        Context context;
        String[] title;
        String[] address;
        String[] startdate;
        String[] enddate;
        String[] description;
        LayoutInflater inflater=null;

        public CAdapter1(Context context, String[] title, String[] address, String[] startdate, String[] enddate, String[] description) {
            this.context = context;
            this.title = title;
            this.address = address;
            this.startdate = startdate;
            this.enddate = enddate;
            this.description = description;
            inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class Holder
        {
            TextView tv_event_startdate;
            TextView tv_event_title;
            TextView tv_event_enddate;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View rows = inflater.inflate(R.layout.custom_event, null);
            CAdapter1.Holder holder=new CAdapter1.Holder();
            holder.tv_event_title = (TextView) rows.findViewById(R.id.tv_event_title);
            holder.tv_event_startdate = (TextView) rows.findViewById(R.id.tv_event_startdate);
            holder.tv_event_enddate = (TextView) rows.findViewById(R.id.tv_event_enddate);

            holder.tv_event_title.setText(title[position]);
            holder.tv_event_startdate.setText(startdate[position]);
            holder.tv_event_enddate.setText(enddate[position]);
            rows.setTag(rows);
            return rows;
        }
    }

    private class AsyncGetTodayEvent1 extends AsyncTask<Void,Void,Void> {
        RestAPI api=new RestAPI();
        @Override
        protected Void doInBackground(Void... params) {
            JSONObject object=new JSONObject();

            try {
                object=api.GetEvent1(session.getID(),temp_date);

                JSONArray jsonArray=object.getJSONArray("Value");
                JSONObject jsonObj=null;
                size=jsonArray.length();
                title=new String[size];
                id=new int[size];
                address=new String[size];
                startdate=new String[size];
                enddate=new String[size];
                description=new String[size];
                for(int i=0;i<jsonArray.length();i++)
                {

                    jsonObj=jsonArray.getJSONObject(i);
                    parse(jsonObj,i);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setAdapter();
        }
    }

    private void parse(JSONObject jsonObj, int i) throws JSONException {
        title[i]=jsonObj.getString("E_Title");
        id[i]=jsonObj.getInt("E_ID");
        address[i]=jsonObj.getString("E_Address");
        startdate[i]=jsonObj.getString("E_StartDate");
        enddate[i]=jsonObj.getString("E_EndDate");
        description[i]=jsonObj.getString("E_Description");
    }

    private void setAdapter() {
        lv_event.setAdapter(new CAdapter1(context,title,address,startdate,enddate,description));
    }

    private class AsyncGetAllEvent1 extends AsyncTask<Void,Void,Void>{
        RestAPI api=new RestAPI();
        @Override
        protected Void doInBackground(Void... params) {
            JSONObject object=new JSONObject();

            try {
                object=api.GetAllEvent1(session.getID(),temp_date);

                JSONArray jsonArray=object.getJSONArray("Value");
                JSONObject jsonObj=null;
                size=jsonArray.length();
                title=new String[size];
                id=new int[size];
                address=new String[size];
                startdate=new String[size];
                enddate=new String[size];
                description=new String[size];
                for(int i=0;i<jsonArray.length();i++)
                {
                    jsonObj=jsonArray.getJSONObject(i);
                    parse(jsonObj,i);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setAdapter();
        }
    }

    private class AsyncRegisterEvent extends AsyncTask<Integer,Void,Void>{
        String title,msg;
        boolean icon;
        boolean result=false;
        RestAPI api=new RestAPI();
        @Override
        protected void onPreExecute() {
            progress.setMessage("Applying for Event...");
            progress.show();
        }
        @Override
        protected Void doInBackground(Integer... params) {
            session.getID();
            JSONObject object;
            try
            {
                object=api.registerEvent(id[params[0]],session.getID());
                result=object.getBoolean("Successful");

                JSONArray jsonArray=object.getJSONArray("Value");
                JSONObject jsonObj=null;
                size=jsonArray.length();
               // title=new String[size];
                id=new int[size];
                address=new String[size];
                startdate=new String[size];
                enddate=new String[size];
                description=new String[size];
                for(int i=0;i<jsonArray.length();i++)
                {
                    jsonObj=jsonArray.getJSONObject(i);
                    parse(jsonObj,i);
                }

                msg=object.getString("Value");
                if(msg.equalsIgnoreCase("Event Registration Successfull..."))
                {
                    title="Registred";
                    icon=true;
                }
                else
                {
                    title="Allready Registered...";
                    icon=false;
                }
            }
            catch (Exception e)
            {
                e.getMessage();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            progress.dismiss();
            if(result==true) {
                alert.showAlertDialog(ViewEvent.this,title, msg, icon);
            }
        }
    }
}
