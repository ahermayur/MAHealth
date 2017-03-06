package com.example.mayur.doctor24_7.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayur.doctor24_7.R;
import com.example.mayur.doctor24_7.RegisterPatient;
import com.example.mayur.doctor24_7.RestAPI.RestAPI;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CreateEvent extends Fragment {
    EditText et_event_title,et_event_address,et_event_description;
    Spinner sp_start_day,sp_start_month,sp_start_year;
    Spinner sp_end_day,sp_end_month,sp_end_year;
    String title,addresss,startdate,enddate,description;
    Date start,end;
    Button btn_event_create;
    String error="Internal server error";
    Boolean result=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_create_event, container, false);

        et_event_title=(EditText)view.findViewById(R.id.et_event_title);
        et_event_address=(EditText)view.findViewById(R.id.et_event_address);
        et_event_description=(EditText)view.findViewById(R.id.et_event_description);
        sp_start_day=(Spinner)view.findViewById(R.id.sp_start_day);
        sp_start_month=(Spinner)view.findViewById(R.id.sp_start_month);
        sp_start_year=(Spinner)view.findViewById(R.id.sp_start_year);
        sp_end_day=(Spinner)view.findViewById(R.id.sp_end_day);
        sp_end_month=(Spinner)view.findViewById(R.id.sp_end_month);
        sp_end_year=(Spinner)view.findViewById(R.id.sp_end_year);
        btn_event_create=(Button)view.findViewById(R.id.btn_event_create);
        btn_event_create.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                title=et_event_title.getText().toString();
                addresss=et_event_address.getText().toString();
                description=et_event_description.getText().toString();
                startdate= sp_start_day.getSelectedItem()+"/"+sp_start_month.getSelectedItem()+"/"+sp_start_year.getSelectedItem();
                enddate=sp_end_day.getSelectedItem()+"/"+sp_end_month.getSelectedItem()+"/"+sp_end_year.getSelectedItem();

                SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
                try {
                    end=df.parse(enddate);
                    start = df.parse(startdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(title.length()<=3)
                {
                    et_event_title.setError("Please Enter Event Title");
                }
                else if(addresss.length()<=3)
                {
                    et_event_address.setError("Please Enter Event Address");
                }
                else if(description.length()<=10)
                {
                    et_event_description.setError("Please Enter Description");
                }
                else if(sp_start_day.getSelectedItem().toString().equals("1") && sp_start_month.getSelectedItem().toString().equals("1") && sp_start_year.getSelectedItem().toString().equals("2017"))
                {
                    Toast.makeText(getActivity(),"Please Seleact Event Start Date",Toast.LENGTH_LONG).show();
                }else if(sp_end_day.getSelectedItem().toString().equals("1") && sp_end_month.getSelectedItem().toString().equals("1") && sp_end_year.getSelectedItem().toString().equals("2017"))
                {
                    Toast.makeText(getActivity(),"Please Seleact Event End Date",Toast.LENGTH_LONG).show();
                }
                else
                {
                    CreateEvent_Cons createEvent_cons = new CreateEvent_Cons(title,addresss,startdate,enddate,description,1);
                    new AsyncCreateEvent().execute(createEvent_cons);
                    if(result!=null)
                    {
                        DisplayDialog(result);
                    }
                }
            }
        });

        return view;
    }
    private void DisplayDialog(boolean result) {
        if(result==true)
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            builder.setMessage("Event Create Successful");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction transaction=manager.beginTransaction();
                    transaction.replace(R.id.container,new ViewEvent());
                    transaction.commit();

                }
            });
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.setIcon(R.drawable.ok);
            alertDialog.setTitle("Success ");
            alertDialog.show();
        }
        else
        {
            try {

                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setMessage(error);
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.setIcon(R.drawable.error);
                alertDialog.setTitle("Connection Error !");

                alertDialog.show();

            }
            catch(Exception e)
            {
                Log.d("Register Error : ",e.getMessage());
            }
        }
    }
    private class CreateEvent_Cons {
        String title,addresss;
        String start;
        String end;
        String description;
        int drid;

        public CreateEvent_Cons(String title, String addresss, String start, String end, String description, int drid) {
            this.title = title;
            this.addresss = addresss;
            this.start = start;
            this.end = end;
            this.description = description;
            this.drid=drid;
        }

        public int getDrid() {
            return drid;
        }

        public void setDrid(int drid) {
            this.drid = drid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddresss() {
            return addresss;
        }

        public void setAddresss(String addresss) {
            this.addresss = addresss;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    private class AsyncCreateEvent extends AsyncTask<CreateEvent_Cons,Void,Void>{
        @Override
        protected Void doInBackground(CreateEvent_Cons... params) {
            RestAPI api=new RestAPI();
            try {
                JSONObject jsonObject=null;
                jsonObject =api.InsertEvent(params[0].getTitle(), params[0].getAddresss(), params[0].getStart(), params[0].getEnd(), params[0].getDescription(), params[0].getDrid());
                result=jsonObject.getBoolean("Successful");
                Log.d("Registration Error ",result+"");
                if(result==false)
                {
                    error=jsonObject.getString("ErrorMessage");
                }

            } catch (Exception e) {
                error=e.getMessage();
            }
            return null;
        }
    }
}