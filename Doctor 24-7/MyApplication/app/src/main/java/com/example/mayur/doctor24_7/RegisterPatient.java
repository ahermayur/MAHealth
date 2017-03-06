package com.example.mayur.doctor24_7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayur.doctor24_7.RestAPI.RestAPI;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPatient extends AppCompatActivity {
    EditText et_name,et_email,et_contact,et_address,et_password,et_password_con;
    Spinner sp_bloodgroup;
    RadioButton rg_male,rg_female;
    TextView tv_birthdate;
    Button btn_register;
    String name,mail,contact,address,pass,pass_conf;
    String bloodgroup;
    String gender;
    Date birthdate;
    String error="Internal server error";
    Boolean result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);
        getSupportActionBar().hide();
        et_name = (EditText) findViewById(R.id.et_p_name);
        et_email= (EditText) findViewById(R.id.et_p_email);
        et_contact= (EditText) findViewById(R.id.et_p_contact_no);
        et_address= (EditText) findViewById(R.id.et_p_address);
        et_password= (EditText) findViewById(R.id.et_p_password);
        et_password_con=(EditText) findViewById(R.id.et_p_password_conf);
        rg_male=(RadioButton) findViewById(R.id.radio_male);
        rg_female=(RadioButton)findViewById(R.id.radio_female);
        sp_bloodgroup=(Spinner)findViewById(R.id.sp_p_bloodgroup);
        tv_birthdate=(TextView)findViewById(R.id.tv_dob);
        btn_register = (Button) findViewById(R.id.btn_p_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                contact = et_contact.getText().toString();
                mail = et_email.getText().toString();
                bloodgroup=sp_bloodgroup.getSelectedItem().toString();
                if(rg_male.isChecked()) {
                    gender="Male";
                }
                else {
                    gender = "Female";
                }
                SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
                try {
                    birthdate = df.parse(tv_birthdate.getText().toString());
                    birthdate.setMonth(birthdate.getMonth()+1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                address=et_address.getText().toString();
                pass = et_password.getText().toString();
                pass_conf = et_password_con.getText().toString();


                if (name.length() <= 3) {
                    et_name.setError("Please Enter Vaild Name");
                } else if (mail.length() <= 3) {
                    et_email.setError("Please Enter Valid Email ID");
                }  else if (contact.length() < 10) {
                    et_contact.setError("Please Enter 10 Digit Contact Number");
                }else if(birthdate.equals("Select DOB"))
                {
                    Toast.makeText(getApplicationContext(),"Please Select Birth date",Toast.LENGTH_LONG).show();
                }
                else if(address.length()<=4){
                    et_address.setError("Please Enter valid address");
                }else if (pass.length() <= 3) {
                    et_password.setError("Please Enter Valid Password, Greater Than 3 Character");
                } else if(!pass.equals(pass_conf))
                {
                    et_password.setError("Password Not Match");
                    et_password_con.setError("Password Not Match");
                }
                else{
                    RegisterP_Cons register_cons = new RegisterP_Cons(name,mail,contact,gender,bloodgroup,birthdate,address,pass);
                    new RegisterPatient.AsyncCreateUser().execute(register_cons);
                    if(result!=null)
                    {
                        DisplayDialog(result);
                    }

                }
            }
        });

    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    private void DisplayDialog(boolean result) {
        if(result==true)
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(RegisterPatient.this);
            builder.setMessage("Registration Successful");
            builder.setPositiveButton("Login Now", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    finish();
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.setIcon(R.drawable.ok);
            alertDialog.setTitle("Success ");
            alertDialog.show();


        }
        else
        {
            try {

                AlertDialog.Builder builder=new AlertDialog.Builder(RegisterPatient.this);
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
            catch(Exception e)
            {
                Log.d("Register Error : ",e.getMessage());
            }
        }
    }

    private class RegisterP_Cons {
        String name,mail,contactno,gender,bloodgroup,address,password;
        Date dob;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getContactno() {
            return contactno;
        }

        public void setContactno(String contactno) {
            this.contactno = contactno;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBloodgroup() {
            return bloodgroup;
        }

        public void setBloodgroup(String bloodgroup) {
            this.bloodgroup = bloodgroup;
        }

        public Date getDob() {
            return dob;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public RegisterP_Cons(String name, String mail, String contactno, String gender, String bloodgroup, Date dob, String address, String password) {
            this.name = name;
            this.mail = mail;
            this.contactno = contactno;
            this.gender = gender;
            this.bloodgroup = bloodgroup;
            this.dob = dob;
            this.address = address;
            this.password = password;
        }
    }

    private class AsyncCreateUser extends AsyncTask<RegisterP_Cons,Void,Void>{

        @Override
        protected Void doInBackground(RegisterP_Cons... params) {
            RestAPI api=new RestAPI();
            try {
                JSONObject jsonObject=null;
                jsonObject =api.InsertPatientDetails(params[0].getName(), params[0].getMail(), params[0].getContactno(), params[0].getGender(), params[0].getBloodgroup(), params[0].getDob(),params[0].getAddress(),params[0].getPassword());
                result=jsonObject.getBoolean("Successful");
                Log.d("Registration Error ",result+"");
                if(result==false)
                {
                    error=jsonObject.getString("ErrorMessage");
                }
                DisplayDialog(result);

            } catch (Exception e) {
                error=e.getMessage();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("Post "," Method");
            DisplayDialog(result);
        }
    }

}
