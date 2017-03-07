package com.example.mayur.doctor24_7.Doctor;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;
import com.example.mayur.doctor24_7.RestAPI.RestAPI;
import com.example.mayur.doctor24_7.Sharepreferance.SessionManager;

import org.json.JSONArray;
import org.json.JSONObject;


public class frag_patient_info extends Fragment {
    int id=Search_Patient.selected_patient;
    String name,mail,contactno,gender,bloodgroup,dob,address;
    Context context;
    private ProgressDialog progress;
    SessionManager session;
    TextView tv_info_name,tv_info_mail,tv_info_contact,tv_info_blood,tv_info_gender,tv_info_address,tv_info_dob;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_frag_patient_info, container, false);
        context=getActivity();
        tv_info_name=(TextView)view.findViewById(R.id.tv_info_name);
        tv_info_mail=(TextView)view.findViewById(R.id.tv_info_mail);
        tv_info_contact=(TextView)view.findViewById(R.id.tv_info_contact);
        tv_info_blood=(TextView)view.findViewById(R.id.tv_info_blood);
        tv_info_gender=(TextView)view.findViewById(R.id.tv_info_gender);
        tv_info_address=(TextView)view.findViewById(R.id.tv_info_address);
        tv_info_dob=(TextView)view.findViewById(R.id.tv_info_dob);
        session = new SessionManager(context);
        progress= new ProgressDialog(context);
        progress.setIndeterminate(true);
        new AsyncUserInfo().execute();
        return view;
    }

    private class AsyncUserInfo extends AsyncTask<Void,Void,Void>{
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
                object=api.PatientInfo(id);
                JSONArray jsonArray=object.getJSONArray("Value");
                JSONObject jsonObj=null;
                    jsonObj=jsonArray.getJSONObject(0);
                    name=jsonObj.getString("P_FullName");
                    mail=jsonObj.getString("P_EmailID");
                    contactno=jsonObj.getString("P_MobNo");
                    gender=jsonObj.getString("P_Gender");
                    bloodgroup=jsonObj.getString("P_BloodGroup");
                    dob=jsonObj.getString("P_Birthdate");
                    address=jsonObj.getString("P_Address");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progress.dismiss();
            setdata();
        }
    }

    private void setdata() {
        tv_info_name.setText(tv_info_name.getText()+" "+name);
        tv_info_mail.setText(tv_info_mail.getText()+" "+mail);
        tv_info_contact.setText(tv_info_contact.getText()+" "+contactno);
        tv_info_blood.setText(tv_info_blood.getText()+" "+bloodgroup);
        tv_info_gender.setText(tv_info_gender.getText()+" "+gender);
        tv_info_address.setText(tv_info_address.getText()+" "+address);
        tv_info_dob.setText(tv_info_dob.getText()+" "+dob);

    }
}
