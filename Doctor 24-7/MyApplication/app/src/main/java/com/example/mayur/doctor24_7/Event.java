package com.example.mayur.doctor24_7;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mayur.doctor24_7.fragment.CreateEvent;
import com.example.mayur.doctor24_7.fragment.ViewEvent;

public class Event extends AppCompatActivity implements View.OnClickListener {

    TextView tv_event_home,tv_event_create,tv_event_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        tv_event_create=(TextView)findViewById(R.id.tv_event_create);
        tv_event_home=(TextView)findViewById(R.id.tv_event_home);
        tv_event_view=(TextView)findViewById(R.id.tv_event_view);
        tv_event_home.setOnClickListener(this);
        tv_event_create.setOnClickListener(this);
        tv_event_view.setOnClickListener(this);
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.container,new CreateEvent());
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_event_home:
                Intent intent=new Intent(Event.this,Doctor_Dashboard.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_event_create:
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.container,new CreateEvent());
                transaction.commit();
                break;
            case R.id.tv_event_view:
                FragmentManager manager1=getSupportFragmentManager();
                FragmentTransaction transaction1=manager1.beginTransaction();
                transaction1.replace(R.id.container,new ViewEvent());
                transaction1.commit();
                break;

        }
    }
}
