package com.example.mayur.doctor24_7.Doctor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;

import java.util.ArrayList;

public class frag_setMedicine extends Fragment {

    Button btn_add;
    EditText et_medicine_name;
    Spinner quantity,time;
    LinearLayout container1;
    Context context;
    public static int count=0;
    ArrayList<String> medicine_name=new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view;
        context=getActivity();
        view=inflater.inflate(R.layout.fragment_frag_set_medicine, container, false);
        container1 = (LinearLayout)view.findViewById(R.id.container1);
        btn_add=(Button)view.findViewById(R.id.btn_addmedicine);
        et_medicine_name=(EditText) view.findViewById(R.id.et_medicine_name);
        quantity=(Spinner) view.findViewById(R.id.sp_medicine_quantity);
        time=(Spinner) view.findViewById(R.id.sp_medicine_time);

        btn_add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                count++;
                medicine_name.add(et_medicine_name.getText().toString());
                String quant=quantity.getSelectedItem().toString();
                String mtime=time.getSelectedItem().toString();
                et_medicine_name.setText("");
                quantity.setSelection(0);
                time.setSelection(0);

                LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.custom_set_medicine, null);
                TextView tv_medicine_name = (TextView)addView.findViewById(R.id.tv_cus_medicine_name);
                TextView tv_quantity=(TextView) addView.findViewById(R.id.tv_cust_medicine_quantity);
                TextView tv_time=(TextView) addView.findViewById(R.id.tv_cust_medicine_time);
                ImageView btnDelete = (ImageView)addView.findViewById(R.id.btn_cust_medicine_delete);
                tv_medicine_name.setText(et_medicine_name.getText().toString());
                tv_quantity.setText(quant);
                tv_time.setText(mtime);

                btnDelete.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        count--;
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});
                container1.addView(addView);
            }});

        return view;
    }
}
