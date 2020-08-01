package com.example.rameshsih;
import android.app.AlertDialog;
import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class owner extends AsyncTask<String,Void,String> {
    private Context context;
    public owner(Context context) {
        this.context = context;
    }
    @Override
    protected String doInBackground(String... arg0) {
        try {
            String f=arg0[0];
            String t=arg0[1];
            String changeani=arg0[2];
            String noanimal=arg0[3];
            String amount=arg0[4];
            String login_url = "http://nickdom006.000webhostapp.com/ownerchange.php";
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("from", "UTF-8") + "=" + URLEncoder.encode(f, "UTF-8") + "&"
                    + URLEncoder.encode("to", "UTF-8") + "=" + URLEncoder.encode(t, "UTF-8")+"&"
                    + URLEncoder.encode("changeAnimal", "UTF-8") + "=" + URLEncoder.encode(changeani, "UTF-8")+"&"
                    + URLEncoder.encode("noanimal", "UTF-8") + "=" + URLEncoder.encode(noanimal, "UTF-8")+"&"
                    + URLEncoder.encode("amount", "UTF-8") + "=" + URLEncoder.encode(amount, "UTF-8");
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
       transfer.toedit.setText("");
       transfer.fromedit.setText("");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Update Details");
        builder.setMessage(result);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
