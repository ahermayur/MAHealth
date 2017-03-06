package com.example.mayur.doctor24_7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mayur.doctor24_7.RestAPI.RestAPI;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

public class RegisterDoctor extends AppCompatActivity {

    EditText et_name,et_address,et_contact, et_email, et_password,et_password_con,et_qualification;
    Button btn_register;
    Spinner et_speciality;
    String name,error="Internal server error";
    String contact;
    String mail;
    String pass;
    String qualification;
    String speciality;
    String address;
    String pass_conf;
    Boolean result=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);
        getSupportActionBar().hide();
        btn_register = (Button) findViewById(R.id.btn_register);

        et_name = (EditText) findViewById(R.id.et_name);
        et_speciality=(Spinner) findViewById(R.id.et_speciality);
        et_address = (EditText) findViewById(R.id.et_address);
        et_email = (EditText) findViewById(R.id.et_email);
        et_qualification= (EditText) findViewById(R.id.et_qualification);
        et_contact = (EditText) findViewById(R.id.et_contact_no);
        et_password_con = (EditText) findViewById(R.id.et_password_conf);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                contact = et_contact.getText().toString();
                mail = et_email.getText().toString();
                speciality=et_speciality.getSelectedItem().toString();
                address=et_address.getText().toString();
                pass = et_password.getText().toString();
                pass_conf = et_password_con.getText().toString();
                qualification=et_qualification.getText().toString();

                if (name.length() <= 3) {
                    et_name.setError("Please Enter Vaild Name");
                } else if (mail.length() <= 3) {
                    et_email.setError("Please Enter Valid Email ID");
                }  else if (contact.length() < 10) {
                    et_contact.setError("Please Enter 10 Digit Contact Number");
                }
                else if(address.length()<=4){
                    et_address.setError("Please Enter valid address");
                }else if(qualification.length()<=3)
                {
                    et_qualification.setError("Please Enter Qualification");
                }else if(speciality.length()<=3)
                {
                    et_qualification.setError("Please Enter Speciality");
                }else if (pass.length() <= 3) {
                    et_password.setError("Please Enter Valid Password, Greater Than 3 Character");
                } else if(!pass.equals(pass_conf))
                {
                    et_password.setError("Password Not Match");
                    et_password_con.setError("Password Not Match");
                }
                else{
                    btn_register.setEnabled(false);
                    Register_Cons register_cons = new Register_Cons(name,mail,pass,contact,address,speciality,qualification);
                    new AsyncCreateUser().execute(register_cons);
                    if(result!=null)
                    {
                        //      DisplayDialog(result);
                    }

                }
            }
        });
    }
    private class Register_Cons {
        String name, mail,pass,contact,address,speciality,education;

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

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public Register_Cons(String name, String mail, String pass, String contact, String address, String speciality, String education) {
            this.name = name;
            this.mail = mail;
            this.pass = pass;
            this.contact = contact;
            this.address = address;
            this.speciality = speciality;
            this.education = education;
        }
    }

    public class AsyncCreateUser extends AsyncTask<Register_Cons,Void,Void> {
        @Override
        protected Void doInBackground(Register_Cons... params) {

            RestAPI api=new RestAPI();
            try {
                JSONObject jsonObject=null;
                jsonObject =api.InsertDoctorDetails(params[0].getName(), params[0].getMail(), params[0].getPass(), params[0].getContact(), params[0].getAddress(), params[0].getSpeciality(), params[0].getEducation());
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


    private void DisplayDialog(boolean result) {
        if(result==true)
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(RegisterDoctor.this);
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

                AlertDialog.Builder builder=new AlertDialog.Builder(RegisterDoctor.this);
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
}
