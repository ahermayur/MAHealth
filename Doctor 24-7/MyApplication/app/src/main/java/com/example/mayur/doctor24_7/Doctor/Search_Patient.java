package com.example.mayur.doctor24_7.Doctor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;
import com.example.mayur.doctor24_7.RestAPI.RestAPI;
import com.example.mayur.doctor24_7.Sharepreferance.AlertDialogManager;
import com.example.mayur.doctor24_7.Sharepreferance.SessionManager;

import org.json.JSONArray;
import org.json.JSONObject;

public class Search_Patient extends AppCompatActivity {
    ImageView img_search;
    Context context;
    EditText et_patient;
    AsyncSearchPatient searchPatient;
    String query;
    int size;
    public static int[] id;
    public static int selected_patient;
    String[] name;
    String[] mail;
    String[] contactno;
    ListView lv_patientlist;
    private ProgressDialog progress;
    SessionManager session;
    AlertDialogManager alert = new AlertDialogManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);
        context=getApplicationContext();
        session = new SessionManager(getApplicationContext());
        progress= new ProgressDialog(this);
        progress.setIndeterminate(true);
        lv_patientlist=(ListView)findViewById(R.id.lv_search_patient);
        lv_patientlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setID();
                Intent intent=new Intent(Search_Patient.this, Patient_sub_Dashboard.class);
                startActivity(intent);
            }

            public void setID() {
                selected_patient=id[1];
            }
        });
        et_patient=(EditText) findViewById(R.id.et_search_patient);
        img_search=(ImageView)findViewById(R.id.img_search_patient);
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query=et_patient.getText().toString();
                if(query.length()==0)
                {
                    et_patient.setError("Please Enter Valid Paramaters");
                }
                else
                {
                    searchPatient= (AsyncSearchPatient) new AsyncSearchPatient().execute();
                }
            }
        });
    }
    private class CAdapter1 extends BaseAdapter {
        Context context;
        int[] id;
        String[] name;
        String[] mail;
        String[] contact;
        LayoutInflater inflater=null;

        public CAdapter1(Context context, int[] id, String[] name, String[] mail, String[] contact) {
            this.context = context;
            this.id = id;
            this.name = name;
            this.mail = mail;
            this.contact = contact;
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
            TextView tv_sp_name;
            TextView tv_sp_mail;
            TextView tv_sp_contactno;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View rows = inflater.inflate(R.layout.custom_patient_searchlist, null);
            CAdapter1.Holder holder=new CAdapter1.Holder();
            holder.tv_sp_name = (TextView) rows.findViewById(R.id.tv_sp_name);
            holder.tv_sp_mail = (TextView) rows.findViewById(R.id.tv_sp_mail);
            holder.tv_sp_contactno = (TextView) rows.findViewById(R.id.tv_sp_contactno);

            holder.tv_sp_name.setText(name[position]);
            holder.tv_sp_mail.setText(mail[position]);
            holder.tv_sp_contactno.setText(contact[position]);
            rows.setTag(rows);
            return rows;
        }
    }
    private void setAdapter() {
        lv_patientlist.setAdapter(new CAdapter1(context,id,name,mail,contactno));
    }
    private class AsyncSearchPatient extends AsyncTask<Void,Void,Void> {

        RestAPI api =new RestAPI();
        @Override
        protected void onPreExecute() {
            progress.setMessage("Searching Patient...");
            progress.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            JSONObject object=new JSONObject();

            try {
                object=api.SearchPatient(query);

                JSONArray jsonArray=object.getJSONArray("Value");
                JSONObject jsonObj=null;
                size=jsonArray.length();
                id=new int[size];
                name=new String[size];
                mail=new String[size];
                contactno=new String[size];

                for(int i=0;i<jsonArray.length();i++)
                {
                    jsonObj=jsonArray.getJSONObject(i);
                    id[i]=jsonObj.getInt("Patient_ID");
                    name[i]=jsonObj.getString("P_FullName");
                    mail[i]=jsonObj.getString("P_EmailID");
                    contactno[i]=jsonObj.getString("P_MobNo");
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
            if(size==0)
            {
                alert.showAlertDialog(Search_Patient.this,"Result Not Found","No any Single Result found for '"+query+"' please try again",false);
            }
        }
    }

}
