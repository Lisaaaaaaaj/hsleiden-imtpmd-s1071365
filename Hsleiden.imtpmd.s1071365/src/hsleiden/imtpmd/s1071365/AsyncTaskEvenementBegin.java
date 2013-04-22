package hsleiden.imtpmd.s1071365;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.AsyncTask;
import android.os.Bundle;
//import android.os.SystemClock;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.view.View.OnClickListener;


public class AsyncTaskEvenementBegin extends Activity 
{

	TextView txt;
//	Button btn_start;
//	ProgressBar progressBar;
//	TextView txt_percentage;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt = (TextView) findViewById(R.id.textView2);  

		new ShowDialogAsyncTask().execute();   	
	
    RelativeLayout relative = (RelativeLayout) findViewById(R.id.RL1);

//    RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
//    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f);

    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
    		(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
    
    
    Button[] btn = new Button[5];
    
    for (int i = 0; i < 5; i++) 
    {
    btn[i] = new Button(getApplicationContext());
    btn[i].setText("test");
    btn[i].setTextColor(Color.parseColor("#000000"));
    btn[i].setTextSize(20);
    btn[i].setHeight(100);
    btn[i].setLayoutParams(params);
    btn[i].setPadding(15, 5, 15, 5);
    relative.addView(btn[i]);

    btn[i].setOnClickListener(handleOnClick(btn[i]));

    }
	}	  
    
    View.OnClickListener handleOnClick(final Button button) 
    {
    return new View.OnClickListener()
    {
    	public void onClick(View v) 
    	{
    		Intent intent = new Intent();
    		intent.setClass(getApplicationContext(), Second_screen.class);
    		startActivity(intent); }
    	};
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
    }

	private class ShowDialogAsyncTask extends AsyncTask<Void, Void, String>
	{

		@Override
		protected void onPreExecute() {
			// update the UI immediately after the task is executed
			super.onPreExecute();

//			Toast.makeText(AsyncTaskEvenementBegin.this,
//					"Invoke onPreExecute()", Toast.LENGTH_SHORT).show();

			// Set the text and call the connect function.  
			txt.setText("Connecting..."); 

		}
		// public static final String KEY_121 = "http://api.evenementenmail.nl/act.php";

		@Override
		protected String doInBackground(Void... params) {

			//private String getServerData(String returnString) {

			InputStream is = null;

			String result = "";
			//data to send
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("naam","test"));


			//http post
			try{
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://api.evenementenmail.nl/act.php");
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				is = entity.getContent();


			}catch(Exception e){
				Log.e("log_tag", "Error in http connection "+e.toString());
			}


			//convert response to string
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				is.close();
				result=sb.toString();
			}catch(Exception e){
				Log.e("log_tag", "Error converting result "+e.toString());
			}
			//parse json data
			String returnString = "";
			  try{
			 JSONArray jArray = new JSONArray(result);
			 for(int i=0;i<jArray.length();i++){
			 JSONObject json_data = jArray.getJSONObject(i);
			 Log.i("log_tag"," name: "+json_data.getString("naam"));//Get an output to the screen
			 returnString += "Naam: Ê" + jArray.getJSONObject(i).getString("naam");
			 }
			}catch(JSONException e){
				Log.e("log_tag", "Error parsing data "+e.toString());
			}
			return returnString; 
		}  
	//
	//	@Override
	//	protected void onProgressUpdate(Integer... values) {
	//		super.onProgressUpdate(values);
	//
	//		progressBar.setProgress(values[0]);
	//		txt_percentage.setText("downloading " +values[0]+"%");
	//
	//	}
	
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
	
//			Toast.makeText(AsyncTaskEvenementBegin.this,
//					"Invoke onPostExecute()", Toast.LENGTH_SHORT).show();
	
			
			txt.setText(result); 

//			btn_start.setEnabled(true);
		}
	}
	}


