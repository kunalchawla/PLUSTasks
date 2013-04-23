package com.kunal.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;

public class MainActivity extends Activity {
	

	Button button;
	String[] ThreeDigNumsTest = new String[]{"100", "003", "020", "003", "020", "131", "331"};
	int count = 0;
	boolean trialRunning = false;
	long startTime = 0;
   	long currentTime = 0;
   	long estimatedTime = 0;
   	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void addListenerOnButton() {
    	 
		button = (Button) findViewById(R.id.button1);
 		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//System.out.println("Wohoo!");
				Log.i("info", "Just hit, hit me");
			   	TextView stimuliText = (TextView) findViewById(R.id.textView1);
			   
			   	
			   	if (!trialRunning) {
			   		 startTime = System.currentTimeMillis();
			   		Log.i("Original", String.valueOf(startTime));
			   		 trialRunning = true;
			   	} else {
			   		currentTime = System.currentTimeMillis();
			   		estimatedTime = currentTime - startTime;
			   		
			   		Log.i("One", String.valueOf(startTime));
			   		Log.i("two", String.valueOf(currentTime));
			   		Log.i("info", String.valueOf(estimatedTime));
			   		trialRunning = false;
			   	}
		    	
				
				if(count % 2 == 0){
					Log.i("info", "Even");
					stimuliText.setText(ThreeDigNumsTest[count]);
				}else{
					//Show +
					Log.i("info", "odd");
					stimuliText.setText("+");
				}
				count++;
			}
 
		});
 
	}    
    
}
