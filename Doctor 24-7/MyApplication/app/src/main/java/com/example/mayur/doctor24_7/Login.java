package com.example.mayur.doctor24_7;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayur.doctor24_7.RestAPI.RestAPI;
import com.example.mayur.doctor24_7.Sharepreferance.AlertDialogManager;
import com.example.mayur.doctor24_7.Sharepreferance.SessionManager;

import org.json.JSONArray;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    Button btn_login;
    EditText et_username,et_password;
    TextView tv_crnewcc,tv_createnewdoc;
    String username,pass,error=null;
    RadioButton doctor,patient;
    Boolean result=true;
    String loginas;
    AsyncLogin asynclogin;
    private ProgressDialog progress;


    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new SessionManager(getApplicationContext());

        if(session.isLoggedIn()==true)
        {
            String name=session.getLoginuser();
            Intent i = null;
            if(name.equalsIgnoreCase("doctor"))
            {
                i=new Intent(Login.this,Doctor_Dashboard.class);
            }
            if(name.equalsIgnoreCase("patient"))
            {
                i=new Intent(Login.this,Patient_Dashboard.class);
            }
            startActivity(i);
            finish();
        }

        progress= new ProgressDialog(this);
        progress.setIndeterminate(true);
        progress.setMessage("Loading...");

        doctor=(RadioButton)findViewById(R.id.radio_login_doctor);
        patient=(RadioButton)findViewById(R.id.radio_login_patient);
        et_username=(EditText)findViewById(R.id.et_username);
        et_password=(EditText)findViewById(R.id.et_pass);
        btn_login=(Button)findViewById(R.id.btn_login);
        tv_crnewcc= (TextView) findViewById(R.id.tv_createnewacc);
        tv_createnewdoc= (TextView) findViewById(R.id.tv_createnewdoc);
        //login customer
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=et_username.getText().toString();
                pass=et_password.getText().toString();
                if(patient.isChecked()==true)
                {
                    loginas="patient";
                }
                else
                {
                    loginas="doctor";
                }
                if(username.length()<4)
                {
                    et_username.setError("Please enter valid user name");
                }
                else if(pass.length()<4)
                {
                    et_password.setError("Please enter valid password");
                }
                else
                {
	//            Intent intent = new Intent(Login.this,Patient_Dashboard.class);
    //            startActivity(intent);
                    asynclogin= (AsyncLogin) new AsyncLogin().execute();
                }
            }
        });
        //register customer
        tv_crnewcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,RegisterPatient.class);
                startActivity(intent);
            }
        });
        tv_createnewdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,RegisterDoctor.class);
                startActivity(intent);
            }
        });

    }
    protected void onPause() {
        super.onPause();
        if (asynclogin != null) {asynclogin.cancel(true);}
        if (progress != null){progress.cancel();}
    }
    private class AsyncLogin extends AsyncTask<Void,Void,Void>
    {
        RestAPI api=new RestAPI();

        @Override
        protected void onPreExecute() {
            progress.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            JSONObject jsonObject=null;
            try {
                if(loginas.equals("doctor")) {
                    jsonObject = api.DoctorLogin(username, pass);
                }
                else
                {
                    jsonObject = api.PatientLogin(username, pass);
                }
                result=jsonObject.getBoolean("Successful");
                JSONArray jsonArray=jsonObject.getJSONArray("Value");

                JSONObject jsonObj=null;
                for(int i=0;i<jsonArray.length();i++)
                {
                    jsonObj=jsonArray.getJSONObject(i);
                    if(loginas.equalsIgnoreCase("doctor")==true)
                    {
                        session.createLoginSession(jsonObj.getInt("Doctor_ID"),jsonObj.getString("Doc_Name"),jsonObj.getString("Doc_EmailID"),jsonObj.getString("Doc_MobileNo"),jsonObj.getString("Doc_Address"),jsonObj.getString("Doc_Speciality"),jsonObj.getString("Doc_Education"));
                    }
                    else
                    {
                        session.createLoginSession(jsonObj.getInt("Patient_ID"),jsonObj.getString("P_FullName"),jsonObj.getString("P_EmailID"),jsonObj.getString("P_MobNo"),jsonObj.getString("P_Gender"),jsonObj.getString("P_BloodGroup"),jsonObj.getString("P_Birthdate"),jsonObj.getString("P_Address"));
                    }
                    Log.d("Share Preferance","Information added");
                }
                try {
                    error=jsonObject.getString("ErrorMessage");
                }
                catch (Exception e)
                {

                }

            } catch (Exception e) {
                error=e.getMessage();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progress.dismiss();
            showAlert();
        }

    }

    private void showAlert() {
        if(result.equals(true))
        {
            if(loginas.equals("doctor")==true) {
                Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Login.this, Doctor_Dashboard.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Login.this, Patient_Dashboard.class);
                startActivity(intent);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Login Failed, Check your email id - password and  Try Again", Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
            builder.setIcon(R.drawable.error);
            builder.setMessage(error);
            builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.setIcon(R.drawable.error);
            alertDialog.setTitle("Connection Error !");
            alertDialog.show();

        }
    }
}
