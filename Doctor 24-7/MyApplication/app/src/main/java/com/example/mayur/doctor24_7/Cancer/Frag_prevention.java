package com.example.mayur.doctor24_7.Cancer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayur.doctor24_7.R;


public class Frag_prevention extends Fragment {
    TextView tv1,tv2,tv3,tv4;
    TextView tv11,tv12,tv13,tv14;
    String s1,s2,s3,s4,s5,s6;
    String s11,s12,s13,s14,s15,s16;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_cancer_prevention, container, false);
        Toast.makeText(getContext(),"prevention",Toast.LENGTH_LONG).show();

        tv1=(TextView)view.findViewById(R.id.txt2);
        tv2=(TextView)view.findViewById(R.id.txt4);
        tv3=(TextView)view.findViewById(R.id.txt6);
        tv4=(TextView)view.findViewById(R.id.txt8);

        tv11=(TextView)view.findViewById(R.id.txt1);
        tv12=(TextView)view.findViewById(R.id.txt3);
        tv13=(TextView)view.findViewById(R.id.txt5);
        tv14=(TextView)view.findViewById(R.id.txt7);

        s1="\n\t\tUsing any type of tobacco puts you on a collision course with cancer. Smoking has been linked to various types of cancer — including cancer of the lung, mouth, throat, larynx, pancreas, bladder, cervix and kidney. Xhewing tobacco has been linked to cancer of the oral cavity and pancreas. Even if you don't use tobacco, exposure to secondhand smoke might increase your risk of lung cancer.";
        s2="\n\t\tAlthough making healthy selections at the grocery store and at mealtime can't guarantee cancer prevention, it might help reduce your risk. Consider these guidelines:\n" +
                "\n" +
                "    Eat plenty of fruits and vegetables. Base your diet on fruits, vegetables and other foods from plant sources — such as whole grains and beans.\n" +
                "    Avoid obesity. Eat lighter and leaner by choosing fewer high-calorie foods, including refined sugars and fat from animal sources.";
        s3="\n\n\t\tMaintaining a healthy weight might lower the risk of various types of cancer, including cancer of the breast, prostate, lung, colon and kidney.\n" +
                "\n" +
                "Physical activity counts, too. In addition to helping you control your weight, physical activity on its own might lower the risk of breast cancer and colon cancer.\n" +
                "\n" +
                "Adults who participate in any amount of physical activity gain some health benefits. ";
        s4="\n\t\tCancer prevention includes protection from certain viral infections. Talk to your doctor about immunization against:\n" +
                "\n" +
                "    Hepatitis B:- Hepatitis B can increase the risk of developing liver cancer. The hepatitis B vaccine is recommended for certain high-risk adults — such as adults who are sexually active but not in a mutually monogamous relationship, people with sexually transmitted infections, intravenous drug users, men who have sex with men, and health care or public safety workers who might be exposed to infected blood or body fluids.\n" +
                "    Human papillomavirus (HPV):- HPV is a sexually transmitted virus that can lead to cervical and other genital cancers as well as squamous cell cancers of the head and neck. The HPV vaccine is recommended for girls and boys ages 11 and 12. It is also available to both men and women age 26 or younger who didn't have the vaccine as adolescents.\n";


        s11="1. Don't use tobacco";
        s12="2. Eat a healthy diet";
        s13="3. Maintain a healthy weight and be physically active";
        s14="4. Get immunized";

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
