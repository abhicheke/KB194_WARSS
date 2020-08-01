package com.example.rameshsih;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SigninActivity extends AsyncTask<String,Void,String> {
    private Context context;
    SharedPreferences pref;
    String u,p;
    public SigninActivity(Context context) {
        this.context = context;
    }
    @Override
    protected String doInBackground(String... arg0) {
        try {
            String Mobile = (String) arg0[0];
            this.u=Mobile;
            String Password = (String) arg0[1];
            this.p=Password;
            String login_url = "http://nickdom006.000webhostapp.com/Admin.php";
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("Mobile", "UTF-8") + "=" + URLEncoder.encode(Mobile, "UTF-8") + "&"
                    + URLEncoder.encode("Password", "UTF-8") + "=" + URLEncoder.encode(Password, "UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Login");
            builder.setMessage("Wrong user id or Password");
            builder.setPositiveButton("OK", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            login.passwordfeild.setBackgroundResource(R.drawable.error);
        } else {
            Intent x = new Intent(context, AdminDashbord.class);
            String[] str = result.split("%");
           // Toast.makeText(context,result,Toast.LENGTH_LONG).show();
            pref=context.getSharedPreferences("user_details",context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("username",u);
            editor.putString("password",p);
            editor.commit();
            context.startActivity(x);
        }
    }
}