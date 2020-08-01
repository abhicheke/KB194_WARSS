package com.example.rameshsih;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import java.io.*;
import java.net.*;
public class Enter extends AsyncTask<String,Void,String> {
    private Context context;
    String g;
    public Enter(Context context) {
        this.context = context;
   }
    @Override
    protected String doInBackground(String... arg0) {
        try{
            String na=arg0[0];
            String lna=arg0[1];
            String aathar=arg0[2];
            String dob=arg0[3];
            String mob=arg0[4];
            String honum=arg0[5];
            String ro=arg0[6];
            String lm=arg0[7];
            String pc=arg0[8];
            String villa=arg0[9];
            String talu=arg0[10];
            String dist=arg0[11];
            String co=arg0[12];
            String buf=arg0[13];
            String go=arg0[14];
            String she=arg0[15];
            String hor=arg0[16];
            String password=arg0[17];
            g=arg0[0]+arg0[1]+arg0[2]+arg0[3]+arg0[4]+arg0[5]+arg0[6]+arg0[7]+arg0[8]+arg0[9]+arg0[10]+arg0[11]+arg0[12]+arg0[13]+arg0[14]+arg0[15]+arg0[16]+arg0[17];
            String login_url = "https://nickdom006.000webhostapp.com/Reg.php";
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("na","UTF-8")+"="+URLEncoder.encode(na,"UTF-8")+"&"
                    +URLEncoder.encode("lna","UTF-8")+"="+URLEncoder.encode(lna,"UTF-8")+"&"
                    +URLEncoder.encode("aathar","UTF-8")+"="+URLEncoder.encode(aathar,"UTF-8")+"&"
                    +URLEncoder.encode("dob","UTF-8")+"="+URLEncoder.encode(dob,"UTF-8")+"&"
                    +URLEncoder.encode("mob","UTF-8")+"="+URLEncoder.encode(mob,"UTF-8")+"&"
                    +URLEncoder.encode("honum","UTF-8")+"="+URLEncoder.encode(honum,"UTF-8")+"&"
                    +URLEncoder.encode("ro","UTF-8")+"="+URLEncoder.encode(ro,"UTF-8")+"&"
                    +URLEncoder.encode("lm","UTF-8")+"="+URLEncoder.encode(lm,"UTF-8")+"&"
                    +URLEncoder.encode("pc","UTF-8")+"="+URLEncoder.encode(pc,"UTF-8")+"&"
                    +URLEncoder.encode("villa","UTF-8")+"="+URLEncoder.encode(villa,"UTF-8")+"&"
                    +URLEncoder.encode("talu","UTF-8")+"="+URLEncoder.encode(talu,"UTF-8")+"&"
                    +URLEncoder.encode("dist","UTF-8")+"="+URLEncoder.encode(dist,"UTF-8")+"&"
                    +URLEncoder.encode("co","UTF-8")+"="+URLEncoder.encode(co,"UTF-8")+"&"
                    +URLEncoder.encode("buf","UTF-8")+"="+URLEncoder.encode(buf,"UTF-8")+"&"
                    +URLEncoder.encode("go","UTF-8")+"="+URLEncoder.encode(go,"UTF-8")+"&"
                    +URLEncoder.encode("she","UTF-8")+"="+URLEncoder.encode(she,"UTF-8")+"&"
                    +URLEncoder.encode("hor","UTF-8")+"="+URLEncoder.encode(hor,"UTF-8")+"&"
                    +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line="";
            while((line = bufferedReader.readLine())!= null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }
    @Override
    protected void onPostExecute(String result){
       AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Registration");
        builder.setMessage(result);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i =new Intent(context,AdminDashbord.class);
                context.startActivity(i);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
       // Toast.makeText(context,result+g,Toast.LENGTH_LONG).show();
    }
}