package com.example.mayur.doctor24_7.Cancer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayur.doctor24_7.R;


public class frag_effect extends Fragment {
   TextView tv1,tv2,tv3,tv4,tv5,tv6;
   TextView tv11,tv12,tv13,tv14,tv15,tv16;
    String s1,s2,s3,s4,s5,s6;
    String s11,s12,s13,s14,s15,s16;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_cancer_effect, container, false);
        Toast.makeText(getContext(),"effects",Toast.LENGTH_LONG).show();

        tv1=(TextView)view.findViewById(R.id.txt2);
        tv2=(TextView)view.findViewById(R.id.txt4);
        tv3=(TextView)view.findViewById(R.id.txt6);
        tv4=(TextView)view.findViewById(R.id.txt8);
        tv5=(TextView)view.findViewById(R.id.txt10);
        tv6=(TextView)view.findViewById(R.id.txt12);

        tv11=(TextView)view.findViewById(R.id.txt1);
        tv12=(TextView)view.findViewById(R.id.txt3);
        tv13=(TextView)view.findViewById(R.id.txt5);
        tv14=(TextView)view.findViewById(R.id.txt7);
        tv15=(TextView)view.findViewById(R.id.txt9);
        tv16=(TextView)view.findViewById(R.id.txt11);

        s1="\n\t\t\nSome cancers and cancer treatments can change the number of blood cells circulating in the blood. Cancers can spread by shedding cells into the bloodstream that may then settle in another part of the body.\n";
        s2="\n\t\t\n The lymphatic system normally helps to trap and destroy cancer cells as well as bacteria and other harmful organisms.Sometimes cancer cells get trapped in lymph nodes close to the cancer and may then start to grow there.\n";
        s3="\n\t\t\nThe immune system protects the body against illness and infection. Cancer and its treatments can sometimes weaken the immune system. But some treatments can boost the immune system to fight cancer.\n";
        s4="\n\t\t\nDiagram showing the hormone system The hormone system is a network of glands and organs in the body that produce hormones. Cancer and its treatments can sometimes change hormone levels and cause side effects. But some treatments can help to control cancer or prevent it coming back by changing particular hormone levels.\n";
        s5="\n\t\t\nThe immune system regularly recognizes and destroys mutant cells. Some mutations give the cancer cell the ability to cripple the immune response and escape its control. The impaired immune system is also limited in its capacity to identify foreign organisms, such as viruses and bacteria. Infections may occur throughout the body, particularly in the skin and lungs. Pneumonia is the final complication in many people with cancer.";
        s6="\n\t\tNormal cells are inhibited in their growth rate by contact with each other. This has the beneficial effect of an orderly pattern of reproduction and cell replacement. All tumors -- cancerous and noncancerous -- lack that inhibition and grow exuberantly, piling up on one another and producing a swollen mass, or tumor. Tumors can press against normal structures, such as blood vessels and nerves, and produce pain or cause malfunctions.";

        s11="The blood and circulatory system and how cancer affects it ";
        s12="The lymphatic system and how cancer affects it";
        s13="The immune system and how cancer affects it";
        s14="The hormone system and how cancer affects it";
        s15="Decreased Resistance to Infection";
        s16="Local Overgrowth";

     /*  tv1.setText("\n"+s1);
        tv2.setText("\n"+s2);
        tv3.setText("\n"+s3);
        tv4.setText("\n"+s4);
        tv5.setText("\n"+s5);
        tv6.setText("\n"+s6);*/


        tv11.setText(""+s11);
        tv12.setText(""+s12);
        tv13.setText(""+s13);
        tv14.setText(""+s14);
        tv15.setText(""+s15);
        tv16.setText(""+s16);

        tv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv1.getText().toString().equals("")) {
                    tv1.setText("\n\n" + s1);
                    tv2.setText("");
                    tv3.setText("");
                    tv4.setText("");
                    tv5.setText("");
                    tv6.setText("");
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv15.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv16.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
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
                    tv5.setText("");
                    tv6.setText("");
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv15.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv16.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
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
                    tv5.setText("");
                    tv6.setText("");
                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv15.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv16.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

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
                    tv5.setText("");
                    tv6.setText("");
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

                    tv15.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv16.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }
                else
                {
                    tv4.setText("");
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }

            }
        });


        tv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv5.getText().toString().equals("")) {
                    tv1.setText("");
                    tv2.setText("");
                    tv3.setText("");
                    tv4.setText("");
                    tv5.setText("\n" + s5);
                    tv6.setText("");
                    tv15.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

                    tv16.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }
                else
                {
                    tv5.setText("");
                    tv15.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }

            }
        });


        tv16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv6.getText().toString().equals("")){
                    tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                tv4.setText("");
                tv5.setText("");
                tv6.setText("\n" + s6);
                    tv16.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.up,0);
                    tv11.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv12.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv13.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv14.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                    tv15.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);

            }
                else
                {
                    tv6.setText("");
                    tv16.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.down,0);
                }

            }
        });



        return view;
    }

}
