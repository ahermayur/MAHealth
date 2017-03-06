package com.example.mayur.doctor24_7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mayur.doctor24_7.Sharepreferance.SessionManager;

public class Doctor_Dashboard extends AppCompatActivity implements View.OnClickListener {
    TextView tv_menu_event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);

        TextView title = (TextView)findViewById(R.id.title);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        title.startAnimation(animation1);
        tv_menu_event=(TextView)findViewById(R.id.tv_menu_event);
        tv_menu_event.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_menu_event:
                Intent intent=new Intent(Doctor_Dashboard.this,Event.class);
                startActivity(intent);
                break;

        }
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
      /*          AlertDialog.Builder builder=new AlertDialog.Builder(Doctor_Dashboard.this);
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
                return true;
                */

                finish();
                new SessionManager(getApplicationContext()).logoutUser();
                Intent intent=new Intent(Doctor_Dashboard.this,Login.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
