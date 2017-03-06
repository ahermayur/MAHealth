package com.example.mayur.doctor24_7.Diabeties;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;


public class Diab_Information extends Fragment {
TextView txt_info,txt_info1;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.diab_info, container, false);
        txt_info=(TextView)view.findViewById(R.id.txt_info);

        txt_info1=(TextView)view.findViewById(R.id.txt_info1);
        String str="What is Diabetes? \n";

        String srt1="\tDiabetes can strike anyone, from any walk of life.\n \n " +
                "And it does in numbers that are dramatically increasing.In the last decade, the cases of people living with diabetes jumped almost 50 percent – to more than 29 million Americans. " +
                "\n";

        txt_info.setText(""+str);
        txt_info1.setText("\n\n"+srt1);

        return view;
    }


}
