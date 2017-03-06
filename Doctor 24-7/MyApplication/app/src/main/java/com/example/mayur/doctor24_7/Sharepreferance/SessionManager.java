package com.example.mayur.doctor24_7.Sharepreferance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.mayur.doctor24_7.Login;

import java.util.HashMap;

/**
 * Created by mayur on 2/3/17.
 */
public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    //commonn data
    public static final String LOGINUSER = "user";
    public static final int ID=0;
    public static final String NAME = "name";
    public static final String EmailID="email";
    public static final String Address="address";
    public static final String MobileNo="0000000000";

    // docotor data
    public static final String Speciality="specility";
    public static final String Education="education";

    // patient data

    public static final String GENDER="Male";
    public static final String BLOODGROUP="AB+";
    public static final String DOB="";


    public int getID() {
        return pref.getInt(String.valueOf(ID),0);
    }

    public String getNAME() {
        return pref.getString(NAME, null);
    }

    public String getEmailID() {
        return pref.getString(EmailID, null);
    }

    public String getAddress() {
        return pref.getString(Address, null);
    }

    public String getMobileNo() {
        return pref.getString(MobileNo, null);
    }

    public String getSpeciality() {
        return pref.getString(Speciality, null);
    }

    public String getEducation() {
        return Education;
    }

    public String getGENDER() {
        return pref.getString(GENDER, null);
    }

    public String getBLOODGROUP() {
        return pref.getString(BLOODGROUP, null);
    }

    public String getDOB() {
        return pref.getString(DOB, null);
    }



    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public String getLoginuser() {
        return pref.getString(LOGINUSER, null);
    }

    public void createLoginSession(int id,String name, String email,String mobileno,String address,String specility,String education){
        // Storing login value as TRUE
        editor.putString(LOGINUSER,"doctor");
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(NAME, name);
        editor.putInt(String.valueOf(ID),id);
        editor.putString(Address, address);
        editor.putString(EmailID, email);
        editor.putString(MobileNo, mobileno);
        editor.putString(Speciality, specility);
        editor.putString(Education, education);

        editor.commit();
    }
    public void createLoginSession(int id,String name, String email,String mobileno,String gender,String bloodgroup,String dob,String address){
        // Storing login value as TRUE
        editor.putString(LOGINUSER,"patient");
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(NAME, name);
        editor.putInt(String.valueOf(ID),id);
        editor.putString(Address, address);
        editor.putString(EmailID, email);
        editor.putString(MobileNo, mobileno);
        editor.putString(GENDER, gender);
        editor.putString(BLOODGROUP, bloodgroup);
        editor.putString(Education, dob);
        editor.commit();
    }

    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Login.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }


    public void logoutUser(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
