package com.example.mayur.doctor24_7.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;
import com.example.mayur.doctor24_7.RestAPI.RestAPI;
import com.example.mayur.doctor24_7.Sharepreferance.AlertDialogManager;
import com.example.mayur.doctor24_7.Sharepreferance.SessionManager;
import com.example.mayur.doctor24_7.event_registered_patient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Date;

public class ViewEvent extends Fragment{

    Context context;
    ListView lv_event;
    String[] title;
    int[] id;
    int size;

    String[] address;
    String[] startdate;
    String[] enddate;
    String[] description;
    public static int[] pid;
    public static String[] pname;
    static Dialog dialog;
    public static int size1;
    public static String[] pmail;
    public static String[] pcontact;
    RadioButton radio_all,radio_today;
    java.util.Calendar cal2;
    int day = 0;
    int month = 0;
    int year = 0;
    String temp_date;
    Date today;
    ImageView img_search;
    AsyncGetRegistredPatient asyncGetRegistredPatient;
    private ProgressDialog progress;
    SessionManager session;
    AlertDialogManager alert = new AlertDialogManager();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view_event, container, false);
        context=getContext();
        session = new SessionManager(getActivity());
        progress= new ProgressDialog(getActivity());
        progress.setIndeterminate(true);
        lv_event=(ListView)view.findViewById(R.id.lv_event);
        radio_all=(RadioButton)view.findViewById(R.id.radio_all);
        radio_today=(RadioButton)view.findViewById(R.id.radio_today);
        img_search=(ImageView)view.findViewById(R.id.img_search);

        java.util.Calendar cal= java.util.Calendar.getInstance();
        temp_date = cal.get(java.util.Calendar.DAY_OF_MONTH)+"/"+(cal.get(java.util.Calendar.MONTH)+1)+"/"+cal.get(java.util.Calendar.YEAR);
        try {
            today=new SimpleDateFormat("dd/MM/yyyy").parse(temp_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_today.isChecked()==true)
                {
                    new AsyncGetTodayEvent().execute();
                }
                else
                {
                    new AsyncGetAllEvent().execute();
                }
            }
        });

        lv_event.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DisplayDialog(position);
            }
        });

        return view;
    }

    private void DisplayDialog(final int position) {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_description);
        dialog.setTitle(" Event ");
        TextView tv_title=(TextView)dialog.findViewById(R.id.tv_d_event_title);
        TextView tv_address=(TextView)dialog.findViewById(R.id.tv_d_address);
        TextView tv_description=(TextView)dialog.findViewById(R.id.tv_d_discription);
        TextView tv_startdate=(TextView)dialog.findViewById(R.id.tv_d_event_startdate);
        TextView tv_enddate=(TextView)dialog.findViewById(R.id.tv_d_event_enddate);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_event_ok);
        Button btn_action = (Button) dialog.findViewById(R.id.btn_event_action);
        btn_action.setText("Register People List");

        ScrollView scv_registered=(ScrollView)dialog.findViewById(R.id.scv_registered);
        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    asyncGetRegistredPatient= (AsyncGetRegistredPatient) new AsyncGetRegistredPatient().execute(position);
                    dialog.dismiss();
            }
        });
        tv_description.setText(description[position]+"");
        tv_title.setText(""+title[position]+"");
        tv_address.setText(""+address[position]);
        tv_startdate.setText(startdate[position]+"");
        tv_enddate.setText(enddate[position]+"");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }


    private class CAdapter extends BaseAdapter {
        Context context;
        String[] title;
        String[] address;
        String[] startdate;
        String[] enddate;
        String[] description;
        LayoutInflater inflater=null;

        public CAdapter(Context context, String[] title, String[] address, String[] startdate, String[] enddate, String[] description) {
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
            Holder holder=new Holder();
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


    private class AsyncGetTodayEvent extends AsyncTask<Void,Void,Void>{
        RestAPI api=new RestAPI();
        @Override
        protected Void doInBackground(Void... params) {
            JSONObject object=new JSONObject();

            try {
                object=api.GetEvent(temp_date);


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
        lv_event.setAdapter(new CAdapter(context,title,address,startdate,enddate,description));
    }

    private class AsyncGetAllEvent extends AsyncTask<Void,Void,Void>{
        RestAPI api=new RestAPI();
        @Override
        protected Void doInBackground(Void... params) {
            JSONObject object=new JSONObject();

            try {
                object=api.GetAllEvent(temp_date);


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

    private class AsyncGetRegistredPatient extends AsyncTask<Integer,Void,Void>{
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
            JSONObject object=null;
            try
            {
                object=api.registerEventPatient(id[params[0]]);
                result=object.getBoolean("Successful");
                msg=object.getString("Value");

                JSONArray jsonArray=object.getJSONArray("Value");
                JSONObject jsonObj=null;
                size1=jsonArray.length();

                pid=new int[size1];
                pmail=new String[size1];
                pname=new String[size1];
                pcontact=new String[size1];

                for(int i=0;i<size1;i++)
                {
                    jsonObj=jsonArray.getJSONObject(i);
                    pid[i]=jsonObj.getInt("Patient_ID");
                    pmail[i]=jsonObj.getString("P_EmailID");
                    pname[i]=jsonObj.getString("P_FullName");
                    pcontact[i]=jsonObj.getString("P_MobNo");
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
            Intent intent=new Intent(getContext(),event_registered_patient.class);
            getActivity().startActivity(intent);
        }

        
    }

}