package com.example.mayur.doctor24_7;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mayur.doctor24_7.fragment.*;
import com.example.mayur.doctor24_7.fragment.ViewEvent;

public class event_registered_patient extends AppCompatActivity {

    ListView listView;
    TextView tv_count;
    com.example.mayur.doctor24_7.fragment.ViewEvent viewEvent=new com.example.mayur.doctor24_7.fragment.ViewEvent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_registered_patient);
        listView=(ListView)findViewById(R.id.lv_event_registred);
        tv_count=(TextView)findViewById(R.id.rcount);
        tv_count.setText(tv_count.getText()+" : "+viewEvent.size1);
        listView.setAdapter(new CAdapter1(event_registered_patient.this,viewEvent.pid,viewEvent.pname,viewEvent.pmail,viewEvent.pcontact));
    }
    private class CAdapter1 extends BaseAdapter {
        Context context;
        int[] id;
        String[] name;
        String[] email;
        String[] contact;
        LayoutInflater inflater=null;

        public CAdapter1(Context context, int[] id, String[] name, String[] email, String[] contact) {
            this.context = context;
            this.id = id;
            this.name = name;
            this.email = email;
            this.contact = contact;
            inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return viewEvent.size1;
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
            TextView tv_reg_pid1;
            TextView tv_reg_pname1;
            TextView tv_reg_pemail1;
            TextView tv_reg_pmob1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View rows = inflater.inflate(R.layout.custom_patientlist, null);
            Holder holder=new Holder();
            holder.tv_reg_pid1 = (TextView) rows.findViewById(R.id.tv_reg_pid1);
            holder.tv_reg_pname1 = (TextView) rows.findViewById(R.id.tv_reg_pname1);
            holder.tv_reg_pemail1 = (TextView) rows.findViewById(R.id.tv_reg_pemail1);
            holder.tv_reg_pmob1 = (TextView) rows.findViewById(R.id.tv_reg_pmob1);

            holder.tv_reg_pid1.setText(id[position]+"");
            holder.tv_reg_pname1.setText(name[position]);
            holder.tv_reg_pemail1.setText(email[position]);
            holder.tv_reg_pmob1.setText(contact[position]);
            rows.setTag(rows);
            return rows;
        }
    }
}
