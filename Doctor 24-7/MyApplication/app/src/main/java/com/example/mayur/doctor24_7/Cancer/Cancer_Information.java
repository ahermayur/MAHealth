package com.example.mayur.doctor24_7.Cancer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;


public class Cancer_Information extends Fragment {
TextView txt_info,txt_info1,txt_info2,txt_info3,txt_info4,txt_info5;
    String s1,s2,s3,s4;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cancer_info, container, false);
        txt_info=(TextView)view.findViewById(R.id.txt_info);

        txt_info1=(TextView)view.findViewById(R.id.txt_info1);
        txt_info2=(TextView)view.findViewById(R.id.txt_info2);
        txt_info3=(TextView)view.findViewById(R.id.txt_info3);
        txt_info4=(TextView)view.findViewById(R.id.txt_info4);
        txt_info5=(TextView)view.findViewById(R.id.txt_info5);
        String str="What Is Cancer?\n";

        String srt1="Cancer can start any place in the body. It starts when cells grow out of control and crowd out normal cells. This makes it hard for the body to work the way it should.\n" +
                "\n" +
                "Cancer can be treated very well for many people. In fact, more people than ever before lead full lives after cancer treatment.\n" +
                "\n" +
                "Here we will explain what cancer is and how it’s treated. You’ll find a list of words about cancer and what they mean at the end of this booklet.";

        s1="Cancer basics";
        s2="\tancer is not just one disease.\n" +
                "\tThere are many types of cancer. It’s not just one disease. Cancer can start in the lungs, the breast, the colon, or even in the blood. Cancers are alike in some ways, but they are different in the ways they grow and spread.";
        s3="How are cancers alike?";
        s4="The cells in our bodies all have certain jobs to do. Normal cells divide in an orderly way. They die when they are worn out or damaged, and new cells take their place. Cancer is when the cells start to grow out of control. The cancer cells keep on growing and making new cells. They crowd out normal cells. This causes problems in the part of the body where the cancer started.";

        txt_info.setText(""+str);
        txt_info1.setText("\n\n"+srt1);
        txt_info2.setText("\n\n"+s1);
        txt_info3.setText("\n\n"+s2);
        txt_info4.setText("\n\n"+s3);
        txt_info5.setText("\n\n"+s4);


        return view;
    }


}
