package com.example.mayur.doctor24_7.Doctor;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mayur.doctor24_7.Doctor.frag_patient_info;
import com.example.mayur.doctor24_7.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class Patient_sub_Dashboard extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton info,setmedicine,setprecaution;
    FloatingActionMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_sub_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        menu = (FloatingActionMenu) findViewById(R.id.fab);

        info = (FloatingActionButton) findViewById(R.id.fab_info);
        info.setOnClickListener(this);
        setmedicine = (FloatingActionButton) findViewById(R.id.fab_set_medicine);
        setmedicine.setOnClickListener(this);
        setprecaution = (FloatingActionButton) findViewById(R.id.fab_set_precaution);
        setprecaution.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        switch (v.getId())
        {
            case R.id.fab_info:
                transaction.replace(R.id.cointner,new frag_patient_info());
                transaction.commit();
                break;
            case R.id.fab_set_medicine:

                transaction.replace(R.id.cointner,new frag_setMedicine());
                transaction.commit();
                break;
            case R.id.fab_set_precaution:
                transaction.replace(R.id.cointner,new frag_patient_info());
                transaction.commit();
                break;
        }
    }
}
