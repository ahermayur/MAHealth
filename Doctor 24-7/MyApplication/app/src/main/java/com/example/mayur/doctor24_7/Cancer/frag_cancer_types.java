package com.example.mayur.doctor24_7.Cancer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mayur.doctor24_7.R;


public class frag_cancer_types extends Fragment {
    TextView txt_type,txt_type1,txt_dec1,txt_dec2,txt,txt1;
    String s1,s2,s3,s4,s5,s6;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_cancer_types, container, false);

        txt_type=(TextView)view.findViewById(R.id.txt_type);
        txt_type1=(TextView)view.findViewById(R.id.txt_typdec);
        txt_dec1=(TextView)view.findViewById(R.id.txt_type1);
        txt_dec2=(TextView)view.findViewById(R.id.txt_typdec1);
        txt=(TextView)view.findViewById(R.id.txt_typdec11);
        txt1=(TextView)view.findViewById(R.id.txt_typdec12);

        s1="Types of Cancer";
        s2="1)Brain Tumor\n2)Cervical Cancer\n3)Bladder Cancer\n4)Head and Neck Cancer";
        s3="\t1)BRAIN TUMOR\n\n" +
                "\tThe brain and spinal cord make up the central nervous system (CNS). Brain and spinal cord tumors are growths of abnormal cells in tissues of the brain or spinal cord. Tumors that start in the brain are called primary brain tumors. A tumor that starts in another part of the body and spreads to the brain is called a metastatic brain tumor.\n" +
                "\n" +
                "Brain and spinal cord tumors may be either benign (not cancer) or malignant (cancer).";
        s4="\t\t2)CERVICAL CANCER \n\n\tCervical cancer may require various treatment approaches, depending on its cause and whether it has metastasized beyond the cervix. Treatment options depend on an accurate diagnosis, making it important to work with experienced cancer doctors who employ state-of-the-art technology.";

        s5="\t3)BLADDER CANCER\n\n\tA bladder cancer diagnosis is life-changing. At Cancer Treatment Centers of America® (CTCA), we’re here to help you and your loved ones make a more informed treatment decision. We encourage you to explore this area to learn more about the disease, what lies ahead and your treatment options. ";
        s6="\t4)HEAD & NECK CANCER\n\n\tA ead and neck cancer diagnosis is life-changing. At Cancer Treatment Centers of America® (CTCA), we’re here to help you and your loved ones make a more informed treatment decision. We encourage you to explore this area to learn more about the disease, what lies ahead and your treatment options. ";

       txt_type.setText("\n"+s1);
       txt_type1.setText("\n"+s2);
        txt_dec1.setText("\n"+s3);
       txt_dec2.setText("\n"+s4);
        txt.setText("\n"+s5);
       txt1.setText("\n"+s6);





        return view;
    }
}
