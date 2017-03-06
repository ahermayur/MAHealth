package com.example.mayur.doctor24_7.Diabeties;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codesgood.views.JustifiedTextView;
import com.example.mayur.doctor24_7.R;


public class Frag_prevention extends Fragment {
    JustifiedTextView tv1,tv2,tv3,tv4;
    JustifiedTextView tv11,tv12,tv13,tv14;
    String s1,s2,s3,s4,s5,s6;
    String s11,s12,s13,s14,s15,s16;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_prevention, container, false);
        Toast.makeText(getContext(),"prevention",Toast.LENGTH_LONG).show();

        tv1=(JustifiedTextView)view.findViewById(R.id.txt2);
        tv2=(JustifiedTextView)view.findViewById(R.id.txt4);
        tv3=(JustifiedTextView)view.findViewById(R.id.txt6);
        tv4=(JustifiedTextView)view.findViewById(R.id.txt8);

        tv11=(JustifiedTextView)view.findViewById(R.id.txt1);
        tv12=(JustifiedTextView)view.findViewById(R.id.txt3);
        tv13=(JustifiedTextView)view.findViewById(R.id.txt5);
        tv14=(JustifiedTextView)view.findViewById(R.id.txt7);

        s1="\n\tThere are many benefits to regular physical activity. Exercise can help you:\n" +
                "\n" +
                "    Lose weight\n" +
                "    Lower your blood sugar\n" +
                "    Boost your sensitivity to insulin — which helps keep your blood sugar within a normal range\n" +
                "\n" +
                "Research shows that aerobic exercise and resistance training can help control diabetes. The greatest benefit comes from a fitness program that includes both.";
        s2="\n\tIt's rough, it's tough — and it may help you:\n" +
                "\n" +
                "    Reduce your risk of diabetes by improving your blood sugar control\n" +
                "    Lower your risk of heart disease\n" +
                "    Promote weight loss by helping you feel full\n" +
                "\n" +
                "Foods high in fiber include fruits, vegetables, beans, whole grains and nuts.";
        s3="\n\tIt's not clear why, but whole grains may reduce your risk of diabetes and help maintain blood sugar levels. Try to make at least half your grains whole grains. Many foods made from whole grains come ready to eat, including various breads, pasta products and cereals. Look for the word \"whole\" on the package and among the first few items in the ingredient list. ";
        s4="\n\t\tIf you're overweight, diabetes prevention may hinge on weight loss. Every pound you lose can improve your health, and you may be surprised by how much. Participants in one large study who lost a modest amount of weight — around 7 percent of initial body weight — and exercised regularly reduced the risk of developing diabetes by almost 60 percent.";


        s11="1.Get more physical activity";
        s12="2.Get plenty of fiber";
        s13="3.Go for whole grains";
        s14="4.Lose extra weight";

        tv11.setText(""+s11);
        tv12.setText(""+s12);
        tv13.setText(""+s13);
        tv14.setText(""+s14);

        tv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv1.getText().toString().equals("")) {
                    tv1.setText("\n\n" + s1);
                    tv2.setText("");
                    tv3.setText("");
                    tv4.setText("");

                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

                }
                else
                {
                    tv1.setText("");
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }

            }
        });


        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv2.getText().toString().equals("")) {
                    tv1.setText("");
                    tv2.setText("\n" + s2);
                    tv3.setText("");
                    tv4.setText("");

                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

                }
                else
                {
                    tv2.setText("");
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }

            }
        });


        tv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv3.getText().toString().equals("")) {
                    tv1.setText("");
                    tv2.setText("");
                    tv3.setText("\n" + s3);
                    tv4.setText("");

                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);


                }
                else
                {
                    tv3.setText("");
                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }
            }
        });


        tv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv4.getText().toString().equals("")) {
                    tv1.setText("");
                    tv2.setText("");
                    tv3.setText("");
                    tv4.setText("\n" + s4);

                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);


                }
                else
                {
                    tv4.setText("");
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }

            }
        });


        return view;
    }
}
