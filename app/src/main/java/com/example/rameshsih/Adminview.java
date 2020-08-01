package com.example.rameshsih;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public class Adminview extends AsyncTask<String,Void,String> {
        private Context context;
        SharedPreferences pref;
        String u,p;
        public Adminview(Context context) {
            this.context = context;
        }
        @Override
        protected String doInBackground(String... arg0) {
            try {
                String Mobile = (String) arg0[0];
                this.u=Mobile;
                String login_url = "http://nickdom006.000webhostapp.com/Login.php";
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Mobile", "UTF-8") + "=" + URLEncoder.encode(Mobile, "UTF-8");
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
                builder.setTitle("Verification");
                builder.setMessage("There is no Profile");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                Intent x = new Intent(context, dashboard.class);
                String[] str = result.split("%");
                Globalclass Globalclass = com.example.rameshsih.Globalclass.getInstance();
                String name=str[0]+str[1];
                Globalclass.setData(str[0],str[1],str[2],str[3],str[4],str[5],str[6],str[7],str[8],str[9],str[10],str[11],str[12],str[13],str[14],str[15],str[16]);
                context.startActivity(x);
            }
        }
    }

