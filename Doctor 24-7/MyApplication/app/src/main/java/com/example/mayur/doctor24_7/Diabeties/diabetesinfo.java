package com.example.mayur.doctor24_7.Diabeties;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;

public class diabetesinfo extends FragmentActivity {
    TextView tv_die_1, tv_die_2,tv_die_3, tv_die_4,tv_die_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetesinfo);

       tv_die_1=(TextView)findViewById(R.id.tv_die_1);
        tv_die_2=(TextView)findViewById(R.id.tv_die_2);
        tv_die_3=(TextView)findViewById(R.id.tv_die_3);
        tv_die_4=(TextView)findViewById(R.id.tv_die_4);
        tv_die_5=(TextView)findViewById(R.id.tv_die_5);

        tv_die_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment=new Fragment();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.cointner,new Diab_Information());
                transaction.commit();

            }
        });
        tv_die_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment=new Fragment();
                FragmentManager manager1=getSupportFragmentManager();
                FragmentTransaction transaction1=manager1.beginTransaction();
                transaction1.replace(R.id.cointner,new frag_diab_types());
                transaction1.commit();

            }
        });
        tv_die_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment=new Fragment();
                FragmentManager manager1=getSupportFragmentManager();
                FragmentTransaction transaction1=manager1.beginTransaction();
                transaction1.replace(R.id.cointner,new frag_effect());
                transaction1.commit();

            }
        });
        tv_die_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment=new Fragment();
                FragmentManager manager1=getSupportFragmentManager();
                FragmentTransaction transaction1=manager1.beginTransaction();
                transaction1.replace(R.id.cointner,new Frag_prevention());
                transaction1.commit();

            }
        });
        tv_die_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment=new Fragment();
                FragmentManager manager1=getSupportFragmentManager();
                FragmentTransaction transaction1=manager1.beginTransaction();
                transaction1.replace(R.id.cointner,new frag_symptoms());
                transaction1.commit();

            }
        });

    }


}
