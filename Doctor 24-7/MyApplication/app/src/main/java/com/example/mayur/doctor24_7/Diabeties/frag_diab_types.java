package com.example.mayur.doctor24_7.Diabeties;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;


public class frag_diab_types extends Fragment {
    TextView txt_type,txt_type1,txt_dec1,txt_dec2,txt,txt1;
    String s1,s2,s3,s4,s5,s6;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_diab_types, container, false);

        txt_type=(TextView)view.findViewById(R.id.txt_type);
        txt_type1=(TextView)view.findViewById(R.id.txt_typdec);
        txt_dec1=(TextView)view.findViewById(R.id.txt_type1);
        txt_dec2=(TextView)view.findViewById(R.id.txt_typdec1);
        txt=(TextView)view.findViewById(R.id.txt_typdec11);
        txt1=(TextView)view.findViewById(R.id.txt_typdec12);

        s1="Types of diabetes";
        s2="1)Type 1\n2)Type 2";
        s3="\tWhat is Type 1 diabetes?";
        s4="\t\tType 1 diabetes occurs when the immune system mistakenly attacks and kills the beta cells of the pancreas. No, or very little, insulin is released into the body. As a result, sugar builds up in the blood instead of being used as energy. About five to 10 per cent of people with diabetes have type 1 diabetes. Type 1 diabetes generally develops in childhood or adolescence, but can develop in adulthood." +
                "\n\t\tType 1 diabetes also includes latent autoimmune diabetes in adults (LADA), the term used to describe the small number of people with apparent type 2 diabetes who appear to have immune-mediated loss of pancreatic beta cells.";
        s5="What is Type 2 diabetes?";
        s6="\t\tType 2 diabetes occurs when the body can’t properly use the insulin that is released (called insulin insensitivity) or does not make enough insulin. As a result, sugar builds up in the blood instead of being used as energy. About 90 per cent of people with diabetes have type 2 diabetes. Type 2 diabetes more often develops in adults, but children can be affected." +
                "\n\t\tType 2 diabetes occurs when the body can’t properly use the insulin that is released (called insulin insensitivity) or does not make enough insulin. As a result, sugar builds up in the blood instead of being used as energy. About 90 per cent of people with diabetes have type 2 diabetes. Type 2 diabetes more often develops in adults, but children can be affected.";

       txt_type.setText("\n"+s1);
       txt_type1.setText("\n"+s2);
        txt_dec1.setText("\n"+s3);
       txt_dec2.setText("\n"+s4);
        txt.setText("\n"+s5);
       txt1.setText("\n"+s6);





        return view;
    }
}
