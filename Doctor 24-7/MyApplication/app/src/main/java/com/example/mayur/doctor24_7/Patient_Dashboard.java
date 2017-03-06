package com.example.mayur.doctor24_7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mayur.doctor24_7.Cancer.Starting;
import com.example.mayur.doctor24_7.Diabeties.diabetesinfo;
import com.example.mayur.doctor24_7.Patient.Search_Doctor;
import com.example.mayur.doctor24_7.Sharepreferance.SessionManager;

public class Patient_Dashboard extends AppCompatActivity {
    TextView cancer,diabeties,event,bmi,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__dashboard);
        cancer=(TextView)findViewById(R.id.tv_p_cancer);
        event=(TextView)findViewById(R.id.tv_menu_p_event);
        bmi=(TextView)findViewById(R.id.tv_menu_p_bmi);
        diabeties=(TextView)findViewById(R.id.tv_p_dia);
        search=(TextView)findViewById(R.id.tv_p_searchdoc);
        cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Patient_Dashboard.this, Starting.class);
                startActivity(intent);
            }
        });
        diabeties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Patient_Dashboard.this, diabetesinfo.class);
                startActivity(intent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Patient_Dashboard.this, ViewEvent.class);
                startActivity(intent);
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Patient_Dashboard.this, CalculateBMI.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Patient_Dashboard.this, Search_Doctor.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
      /*          AlertDialog.Builder builder=new AlertDialog.Builder(Patient_Dashboard.this);
                builder.setIcon(R.drawable.logout);
                builder.setMessage("Do you want to Exit from Application ?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.setIcon(R.drawable.logout);
                alertDialog.setTitle("Exit !");
                alertDialog.show();
       */
                finish();
                new SessionManager(getApplicationContext()).logoutUser();
                Intent intent=new Intent(Patient_Dashboard.this,Login.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
