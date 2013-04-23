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
	String[] PracticeOne = new String[]{"100", "003", "020", "003", "020", "131", "331"};
	String[] PracticeTwo = new String[]{"100", "003", "020", "003", "020", "131", "331"};
	String[] ThreeDigitNumTest = new String[]{"100", "003", "020", "003", "020", "131", "331"};
	int trialArrayIndex = 0;
	int trial = 1;
	String buttonPressed;
	boolean isButtonPressed = false;
	
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
    protected void onStart(){ 
        super.onStart();
        //Practice 1
        while(trialArrayIndex<PracticeOne.length){
        	//Show Plus
        	//displayPlus();
        	
        	//Show Trial
        	
        	//Increment Counters
        	trial++;
        	trialArrayIndex++;
        }
        trialArrayIndex = 0;
        
        //Move to Practice 2
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
				Log.i("info", "Just hit, hit me");
			   	TextView stimuliText = (TextView) findViewById(R.id.textViewStimuli);
			   
			   	
			   	if (!trialRunning) {
			   		 startTime = System.currentTimeMillis();
			   		 trialRunning = true;
			   	} else {
			   		currentTime = System.currentTimeMillis();
			   		estimatedTime = currentTime - startTime;
			   		Log.i("info", String.valueOf(estimatedTime));
			   		trialRunning = false;
			   	}
		    	
				
				if(count % 2 == 0){
					Log.i("info", "Even");
					stimuliText.setText(ThreeDigitNumTest[count]);
				}else{
					//Show +
					Log.i("info", "odd");
					stimuliText.setText("+");
				}
				count++;
			}
 
		});
 
	}
   
    void displayPlus(){
    	
    	
    }
}
