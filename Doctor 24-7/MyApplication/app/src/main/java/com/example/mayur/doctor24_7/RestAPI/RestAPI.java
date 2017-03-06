 /* JSON API for android appliation */
package com.example.mayur.doctor24_7.RestAPI;

 import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

 public class RestAPI {
     private final String urlString = "http://192.168.1.106/Health/Health/Handler1.ashx";

     private static String convertStreamToUTF8String(InputStream stream) throws IOException {
         String result = "";
         StringBuilder sb = new StringBuilder();
         try {
             InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
             char[] buffer = new char[4096];
             int readedChars = 0;
             while (readedChars != -1) {
                 readedChars = reader.read(buffer);
                 if (readedChars > 0)
                     sb.append(buffer, 0, readedChars);
             }
             result = sb.toString();
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         }
         return result;
     }


     private String load(String contents) throws IOException {
         URL url = new URL(urlString);
         HttpURLConnection conn = (HttpURLConnection)url.openConnection();
         conn.setRequestMethod("POST");
         conn.setConnectTimeout(60000);
         conn.setDoOutput(true);
         conn.setDoInput(true);
         OutputStreamWriter w = new OutputStreamWriter(conn.getOutputStream());
         w.write(contents);
         w.flush();
         InputStream istream = conn.getInputStream();
         String result = convertStreamToUTF8String(istream);
         return result;
     }


     private Object mapObject(Object o) {
         Object finalValue = null;
         if (o.getClass() == String.class) {
             finalValue = o;
         }
         else if (Number.class.isInstance(o)) {
             finalValue = String.valueOf(o);
         } else if (Date.class.isInstance(o)) {
             SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss", new Locale("en", "USA"));
             finalValue = sdf.format((Date)o);
         }
         else if (Collection.class.isInstance(o)) {
             Collection<?> col = (Collection<?>) o;
             JSONArray jarray = new JSONArray();
             for (Object item : col) {
                 jarray.put(mapObject(item));
             }
             finalValue = jarray;
         } else {
             Map<String, Object> map = new HashMap<String, Object>();
             Method[] methods = o.getClass().getMethods();
             for (Method method : methods) {
                 if (method.getDeclaringClass() == o.getClass()
                         && method.getModifiers() == Modifier.PUBLIC
                         && method.getName().startsWith("get")) {
                     String key = method.getName().substring(3);
                     try {
                         Object obj = method.invoke(o, null);
                         Object value = mapObject(obj);
                         map.put(key, value);
                         finalValue = new JSONObject(map);
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                 }
             }

         }
         return finalValue;
     }

     public JSONObject InsertDoctorDetails(String name,String email,String pwd,String mobileno,String address,String speciality,String education) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "InsertDoctorDetails");
         p.put("name",mapObject(name));
         p.put("email",mapObject(email));
         p.put("pwd",mapObject(pwd));
         p.put("mobileno",mapObject(mobileno));
         p.put("address",mapObject(address));
         p.put("speciality",mapObject(speciality));
         p.put("education",mapObject(education));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject DoctorLogin(String username,String passsword) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "DoctorLogin");
         p.put("username",mapObject(username));
         p.put("passsword",mapObject(passsword));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject SearchDoctor(String username) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "SearchDoctor");
         p.put("username",mapObject(username));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject InsertPatientDetails(String fullname,String email,String mobno,String gender,String bloodgroup,Date birthdate,String addres,String pwd) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "InsertPatientDetails");
         p.put("fullname",mapObject(fullname));
         p.put("email",mapObject(email));
         p.put("mobno",mapObject(mobno));
         p.put("gender",mapObject(gender));
         p.put("bloodgroup",mapObject(bloodgroup));
         p.put("birthdate",mapObject(birthdate));
         p.put("addres",mapObject(addres));
         p.put("pwd",mapObject(pwd));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject PatientLogin(String username,String passsword) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "PatientLogin");
         p.put("username",mapObject(username));
         p.put("passsword",mapObject(passsword));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject InsertEvent(String title,String address,String startdate,String enddate,String description,int docid) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "InsertEvent");
         p.put("title",mapObject(title));
         p.put("address",mapObject(address));
         p.put("startdate",mapObject(startdate));
         p.put("enddate",mapObject(enddate));
         p.put("description",mapObject(description));
         p.put("docid",mapObject(docid));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject GetAllEvent1(int doctorid,String date1) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "GetAllEvent1");
         p.put("doctorid",mapObject(doctorid));
         p.put("date1",mapObject(date1));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject GetAllEvent(String date1) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "GetAllEvent");
         p.put("date1",mapObject(date1));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject GetEvent1(int doctorid,String date1) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "GetEvent1");
         p.put("doctorid",mapObject(doctorid));
         p.put("date1",mapObject(date1));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject GetEvent(String date1) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "GetEvent");
         p.put("date1",mapObject(date1));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject registerEvent(int eid,int pid) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "registerEvent");
         p.put("eid",mapObject(eid));
         p.put("pid",mapObject(pid));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject registerEventPatient(int eid) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "registerEventPatient");
         p.put("eid",mapObject(eid));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

     public JSONObject InsertAppointment(int DID,int PID,String appointmentdate) throws Exception {
         JSONObject result = null;
         JSONObject o = new JSONObject();
         JSONObject p = new JSONObject();
         o.put("interface","RestAPI");
         o.put("method", "InsertAppointment");
         p.put("DID",mapObject(DID));
         p.put("PID",mapObject(PID));
         p.put("appointmentdate",mapObject(appointmentdate));
         o.put("parameters", p);
         String s = o.toString();
         String r = load(s);
         result = new JSONObject(r);
         return result;
     }

 }