package com.example.mayur.doctor24_7.Diabeties;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codesgood.views.JustifiedTextView;
import com.example.mayur.doctor24_7.R;


public class frag_effect extends Fragment {
    JustifiedTextView tv1,tv2,tv3,tv4,tv5,tv6;
    JustifiedTextView tv11,tv12,tv13,tv14,tv15,tv16;
    String s1,s2,s3,s4,s5,s6;
    String s11,s12,s13,s14,s15,s16;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_effect, container, false);
        Toast.makeText(getContext(),"effects",Toast.LENGTH_LONG).show();

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

        s1="\n\t\tDiabetes dramatically increases your risk of various cardiovascular problems, including coronary artery disease with chest pain (angina), heart attack, stroke, narrowing of the arteries (atherosclerosis) and high blood pressure.";
        s2="\n\t\tExcess sugar can injure the walls of the tiny blood vessels (capillaries) that nourish your nerves, especially in the legs. This can cause tingling, numbness, burning or pain that usually begins at the tips of the toes or fingers and gradually spreads upward. Poorly controlled blood sugar could cause you to eventually lose all sense of feeling in the affected limbs.";
        s3="\n\t\tDiabetes can damage the blood vessels of the retina (diabetic retinopathy), potentially leading to blindness. Diabetes also increases the risk of other serious vision conditions, such as cataracts and glaucoma.";
        s4="\n\t\tNerve damage in the feet or poor blood flow to the feet increases the risk of various foot complications. Left untreated, cuts and blisters can become serious infections, which often heal poorly and may ultimately require toe, foot or leg amputation.";
        s5="\n\t\tDiabetes may leave you more susceptible to skin problems, including bacterial and fungal infections.";
        s6="\n\t\tHigh blood sugar levels can be dangerous for both the mother and the baby. The risk of miscarriage, stillbirth and birth defects are increased when diabetes isn't well-controlled. For the mother, diabetes increases the risk of diabetic ketoacidosis, diabetic eye problems (retinopathy), pregnancy-induced high blood pressure and preeclampsia.";

        s11="Heart and blood vessel disease";
        s12="Nerve damage (neuropathy)";
        s13="Eye damage";
        s14="Foot damage";
        s15="Skin and mouth conditions";
        s16="Pregnancy complications";

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
