package com.example.rameshsih;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class new_born_and_death_changes extends AsyncTask<String,Void,String> {
    private Context context;
    public new_born_and_death_changes(Context context) {
        this.context = context;
    }
    @Override
    protected String doInBackground(String... arg0) {
        try {
            String type = (String) arg0[0];
            String count = (String) arg0[1];
            String mobile=arg0[2];
            String animal=arg0[3];
            String login_url = "http://nickdom006.000webhostapp.com/newdeathchanges.php";
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8") + "&"
                    + URLEncoder.encode("count", "UTF-8") + "=" + URLEncoder.encode(count, "UTF-8")+"&"
                    + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8")+"&"
                    + URLEncoder.encode("animal", "UTF-8") + "=" + URLEncoder.encode(animal, "UTF-8");
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
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Update Details");
        builder.setMessage(result);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
        Intent x=new Intent(context,dashboard.class);
        context.startActivity(x);
             }
    }
