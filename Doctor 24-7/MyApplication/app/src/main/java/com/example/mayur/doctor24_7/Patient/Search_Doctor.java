package com.example.mayur.doctor24_7.Patient;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;
import com.example.mayur.doctor24_7.RestAPI.RestAPI;
import com.example.mayur.doctor24_7.Sharepreferance.AlertDialogManager;
import com.example.mayur.doctor24_7.Sharepreferance.SessionManager;
import com.example.mayur.doctor24_7.ViewEvent;

import org.json.JSONArray;
import org.json.JSONObject;

public class Search_Doctor extends AppCompatActivity {
    ImageView img_search;
    Context context;
    EditText et_doctor;
    AsyncSearchDoc searchDoc;
    String query;
    int size;
    int[] id;
    String[] name;
    String[] mail;
    String[] contactno;
    String[] address;
    String[] specility;
    AsyncBookAppointment asyncBookAppointment;
    ListView lv_doclist;
    private ProgressDialog progress;
    SessionManager session;
    AlertDialogManager alert = new AlertDialogManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_doctor);
        context=getApplicationContext();
        session = new SessionManager(getApplicationContext());
        progress= new ProgressDialog(this);
        progress.setIndeterminate(true);
        lv_doclist=(ListView)findViewById(R.id.lv_search_doctor);
        lv_doclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DisplayDialog(position);
            }
        });
        et_doctor=(EditText) findViewById(R.id.et_search_doc);
        img_search=(ImageView)findViewById(R.id.img_search_doc);
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query=et_doctor.getText().toString();
                if(query.length()==0)
                {
                    et_doctor.setError("Please Enter Valid Paramaters");
                }
                else
                {
                    searchDoc= (AsyncSearchDoc) new AsyncSearchDoc().execute();
                }
            }
        });
    }
    public class DatePickerFragment1 extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user

            TextView tv1= (TextView) getActivity().findViewById(R.id.tv_appointment_date);
            tv1.setText(view.getDayOfMonth()+"/"+(1+view.getMonth())+"/"+view.getYear());
        }
    }
    private void DisplayDialog(final int position) {
        final Dialog dialog = new Dialog(Search_Doctor.this);
        dialog.setContentView(R.layout.custom_appointment);
        dialog.setTitle(" Book Appointment ");
        TextView tv_sd_name=(TextView)dialog.findViewById(R.id.tv_sd_name);
        TextView tv_sd_specility=(TextView)dialog.findViewById(R.id.tv_sd_specility);
        TextView tv_sd_address=(TextView)dialog.findViewById(R.id.tv_sd_address);
        TextView tv_sd_contactno=(TextView)dialog.findViewById(R.id.tv_sd_contactno);
        TextView tv_sd_mail=(TextView)dialog.findViewById(R.id.tv_sd_mail);
        final TextView tv_appointment_date=(TextView)dialog.findViewById(R.id.tv_appointment_date);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_sd_ok);
        Button btn_action = (Button) dialog.findViewById(R.id.btn_book_appointment);
        tv_sd_name.setText(name[position]+"");
        tv_sd_specility.setText(""+specility[position]+"");
        tv_sd_address.setText(""+address[position]);
        tv_sd_mail.setText(mail[position]+"");
        tv_sd_contactno.setText(contactno[position]+"");
        tv_appointment_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
                asyncBookAppointment= (AsyncBookAppointment) new AsyncBookAppointment().execute(position);
            }
        });
        dialog.show();
    }

    private class CAdapter1 extends BaseAdapter {
        Context context;
        int[] id;
        String[] name;
        String[] mail;
        String[] contact;
        String[] address;
        String[] specility;
        LayoutInflater inflater=null;

        public CAdapter1(Context context, int[] id, String[] name, String[] mail, String[] contact, String[] address,String[] specility) {
            this.context = context;
            this.id = id;
            this.name = name;
            this.mail = mail;
            this.contact = contact;
            this.address = address;
            this.specility = specility;
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
            TextView tv_sd_name;
            TextView tv_sd_specility;
            TextView tv_sd_address;
            TextView tv_sd_mail;
            TextView tv_sd_contactno;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View rows = inflater.inflate(R.layout.custom_doctorlist, null);
            CAdapter1.Holder holder=new CAdapter1.Holder();
            holder.tv_sd_name = (TextView) rows.findViewById(R.id.tv_sd_name);
            holder.tv_sd_specility = (TextView) rows.findViewById(R.id.tv_sd_specility);
            holder.tv_sd_address = (TextView) rows.findViewById(R.id.tv_sd_address);
            holder.tv_sd_mail = (TextView) rows.findViewById(R.id.tv_sd_mail);
            holder.tv_sd_contactno = (TextView) rows.findViewById(R.id.tv_sd_contactno);

            holder.tv_sd_name.setText(name[position]);
            holder.tv_sd_specility.setText(specility[position]);
            holder.tv_sd_address.setText(address[position]);
            holder.tv_sd_mail.setText(mail[position]);
            holder.tv_sd_contactno.setText(contact[position]);
            rows.setTag(rows);
            return rows;
        }
    }
    private void setAdapter() {
        lv_doclist.setAdapter(new CAdapter1(context,id,name,mail,contactno,address,specility));
    }
    private class AsyncSearchDoc extends AsyncTask<Void,Void,Void>{
        RestAPI api =new RestAPI();
        @Override
        protected void onPreExecute() {
            progress.setMessage("Searching Doctor...");
            progress.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            JSONObject object=new JSONObject();

            try {
                object=api.SearchDoctor(query);

                JSONArray jsonArray=object.getJSONArray("Value");
                JSONObject jsonObj=null;
                size=jsonArray.length();
                id=new int[size];
                name=new String[size];
                mail=new String[size];
                contactno=new String[size];
                address=new String[size];
                specility=new String[size];

                for(int i=0;i<jsonArray.length();i++)
                {
                    jsonObj=jsonArray.getJSONObject(i);
                    id[i]=jsonObj.getInt("Doctor_ID");
                    name[i]=jsonObj.getString("Doc_Name");
                    mail[i]=jsonObj.getString("Doc_EmailID");
                    contactno[i]=jsonObj.getString("Doc_MobileNo");
                    address[i]=jsonObj.getString("Doc_Address");
                    specility[i]=jsonObj.getString("Doc_Speciality");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progress.dismiss();
            setAdapter();
        }
    }

    private class AsyncBookAppointment extends AsyncTask<Integer,Void,Void>{
        String title,msg;
        boolean icon;
        boolean result=false;
        RestAPI api=new RestAPI();

        @Override
        protected void onPreExecute() {
            progress.setMessage("Booking Appointment...");
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

        }
    }
}
