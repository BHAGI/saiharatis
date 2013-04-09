package com.mycompany.myapp;
import java.lang.*;
import android.text.method.ScrollingMovementMethod;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
	String hello;
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	//	final TextView textView=(TextView)findViewById(R.id.textView1);
	//	txtView=(TextView)findViewById(R.id.txtView);
	//	txtwidth = (TextView)findViewById(R.id.viewwidth);
		
		final Button button1 =  (Button)findViewById(R.id.mybutton1);
		final Button button2 =  (Button)findViewById(R.id.mybutton2);
		final Button button3 =  (Button)findViewById(R.id.mybutton3);
		final Button button4 =  (Button)findViewById(R.id.mybutton4);
		//Implement listener for your button so that when you click the 
		//button, android will listen to it.             
		
		button1.setOnClickListener(new View.OnClickListener() {             
				public void onClick(View v) {                 
					// Perform action on click 
					Intent page = new Intent(getApplicationContext(), firstActivity.class);
        startActivity(page);
					//textView.setMovementMethod(new ScrollingMovementMethod());
					//textView.setText(hello);
					
					

				}         });
      	button2.setOnClickListener(new View.OnClickListener() {             
				public void onClick(View v) {                 
					// Perform action on click 
					Intent page = new Intent(getApplicationContext(), secondActivity.class);
					startActivity(page);

				}         });
		button3.setOnClickListener(new View.OnClickListener() {             
				public void onClick(View v) {                 
					// Perform action on click 
					Intent page = new Intent(getApplicationContext(), thirdActivity.class);
					startActivity(page);

				}         });
    	button4.setOnClickListener(new View.OnClickListener() {             
				public void onClick(View v) {                 
					// Perform action on click 
					Intent page = new Intent(getApplicationContext(), fourthActivity.class);
					startActivity(page);

				}         });
    }
}
