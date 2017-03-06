package com.example.mayur.doctor24_7.Cancer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayur.doctor24_7.R;


public class frag_symptoms extends Fragment {
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    TextView tv11,tv12,tv13,tv14,tv15,tv16;
    String s1,s2,s3,s4,s5,s6;
    String s11,s12,s13,s14,s15,s16;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_cancer_effect, container, false);
        Toast.makeText(getContext(),"symptoms",Toast.LENGTH_LONG).show();

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
        s2="\n" +
                "The occasional bowel problem is normal, but changes in your bowels may indicate either colon or rectal cancer. These are collectively called colorectal cancers. Colon cancer can develop in any part of the colon, while rectal cancer affects the rectum, which connects the colon to the anus.\n" +
                "\n" +
                "Frequent diarrhea and constipation may be symptoms of cancer, particularly if these bowel changes come on suddenly. These problems also may occur with frequent gas and abdominal pain.\n" +
                "\n" +
                "A change in the caliber or size of your bowel movement may also be a symptom of cancer. ";
        s3="\n" +
                "Rectal bleeding may be an early sign of rectal cancer. This is especially concerning if the bleeding persists or if you are found to have iron deficiency anemia due to blood loss. You may also notice blood in your stools.\n" +
                "\n" +
                "Although there are other more common causes of rectal bleeding like hemorrhoids, you shouldn’t try to diagnose yourself if you’re having these symptoms. Talk to your doctor about your concerns. You should get regular colon cancer screenings starting at age 50.";
        s4="\nIncontinence and other urinary changes may develop as you age. However, certain symptoms may indicate prostate cancer. Prostate cancer is most common in men ages 60 and older.\n" +
                "\n" +
                "Common urinary symptoms include:\n" +
                "\n" +
                "    urinary leaks\n" +
                "    incontinence\n" +
                "    an inability to urinate despite urges to go\n" +
                "    delayed urination\n" +
                "    straining during urination\n";
        s5="\n" +
                "If you have blood in your urine, you shouldn’t ignore it. A common symptom of bladder cancer is blood in the urine. This type of cancer is more common in current and former smokers than in people who’ve never smoked. Prostatitis, prostate cancer, and urinary tract infections can also cause blood in the urine.\n" +
                "\n" +
                "Early prostate cancer can cause blood in the semen.";
        s6="\n" +
                "Back pain is the most common cause of disability, but few men realize that it may be a symptom of cancer. Symptoms of cancer may not show until it has spread to other parts of the body, such as the bones of the spine.\n" +
                "\n" +
                "Unlike occasional muscle pain, cancer of the bone causes tenderness and discomfort in the bones. Prostate cancer is especially prone to spread to the bones and may cause these symptoms within the hip bones and lower back.";
        s1="\n" +
                "It becomes more difficult to maintain your weight as you age, so you might consider weight loss as a positive thing. But, sudden and unexplained weight loss can indicate a serious health problem, including almost any type of cancer.\n" +
                "\n" +
                "If you rapidly lose weight without changing your diet or how much you exercise, discuss this with your doctor.";

        s12="Bowel changes ";
        s13="Rectal bleeding";
        s14="Urinary changes";
        s15="Blood in your urine";
        s16="Persistent back pain";
        s11="Unexplained weight loss";

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
