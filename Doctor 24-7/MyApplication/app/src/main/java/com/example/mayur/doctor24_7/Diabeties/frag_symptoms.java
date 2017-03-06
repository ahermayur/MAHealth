package com.example.mayur.doctor24_7.Diabeties;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codesgood.views.JustifiedTextView;
import com.example.mayur.doctor24_7.R;


public class frag_symptoms extends Fragment {
    JustifiedTextView tv1,tv2,tv3,tv4,tv5,tv6;
    JustifiedTextView tv11,tv12,tv13,tv14,tv15,tv16;
    String s1,s2,s3,s4,s5,s6;
    String s11,s12,s13,s14,s15,s16;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_effect, container, false);
        Toast.makeText(getContext(),"symptoms",Toast.LENGTH_LONG).show();

        tv1=(JustifiedTextView)view.findViewById(R.id.txt2);
        tv2=(JustifiedTextView)view.findViewById(R.id.txt4);
        tv3=(JustifiedTextView)view.findViewById(R.id.txt6);
        tv4=(JustifiedTextView)view.findViewById(R.id.txt8);
        tv5=(JustifiedTextView)view.findViewById(R.id.txt10);
        tv6=(JustifiedTextView)view.findViewById(R.id.txt12);

        tv11=(JustifiedTextView)view.findViewById(R.id.txt1);
        tv12=(JustifiedTextView)view.findViewById(R.id.txt3);
        tv13=(JustifiedTextView)view.findViewById(R.id.txt5);
        tv14=(JustifiedTextView)view.findViewById(R.id.txt7);
        tv15=(JustifiedTextView)view.findViewById(R.id.txt9);
        tv16=(JustifiedTextView)view.findViewById(R.id.txt11);
        s2="\n\n\t\tExcessive thirst (also called polydipsia) and increased urination (also known as polyuria) are classic diabetes symptoms.\n" +
                "\n" +
                "\t\tWhen you have diabetes, excess sugar (glucose) builds up in your blood. Your kidneys are forced to work overtime to filter and absorb the excess sugar. If your kidneys can't keep up, the excess sugar is excreted into your urine, dragging along fluids from your tissues. This triggers more frequent urination, which may leave you dehydrated. As you drink more fluids to quench your thirst, you'll urinate even more. ";
        s3="\n\t\tExcess sugar in your blood can lead to nerve damage. You may notice tingling and loss of sensation in your hands and feet, as well as burning pain in your arms, hands, legs and feet.";
        s4="\n\t\tWeight fluctuations also fall under the umbrella of possible diabetes signs and symptoms. When you lose sugar through frequent urination, you also lose calories. At the same time, diabetes may keep the sugar from your food from reaching your cells — leading to constant hunger. The combined effect is potentially rapid weight loss, especially if you have type 1 diabetes. ";
        s5="\n\t\tDiabetes symptoms sometimes involve your vision. High levels of blood sugar pull fluid from your tissues, including the lenses of your eyes. This affects your ability to focus.\n" +
                "\n" +
                "\t\tLeft untreated, diabetes can cause new blood vessels to form in your retina — the back part of your eye — and damage established vessels. For most people, these early changes do not cause vision problems. However, if these changes progress undetected, they can lead to vision loss and blindness. ";
        s6="\n\n\t\tIf you notice any possible diabetes signs or symptoms, contact your doctor. The earlier the condition is diagnosed, the sooner treatment can begin. Diabetes is a serious condition. But with your active participation and the support of your health care team, you can manage diabetes while enjoying an active, healthy life. ";
        s1="\n\t\tDiabetes may weaken your ability to fight germs, which increases the risk of infection in your gums and in the bones that hold your teeth in place. Your gums may pull away from your teeth, your teeth may become loose, or you may develop sores or pockets of pus in your gums — especially if you have a gum infection before diabetes develops. ";

        s12="Excessive thirst and increased urination ";
        s13="Tingling hands and feet";
        s14="Weight loss";
        s15="Blurred vision  ";
        s16="Take your body's hints seriously";
        s11="Red, swollen, tender gums";

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
                    tv1.setText("\n" + s1);
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
