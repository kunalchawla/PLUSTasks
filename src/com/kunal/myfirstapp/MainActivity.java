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
	Button button1;
	Button button2;
	Button button3;
	String[] PracticeOne = new String[]{"100", "003", "020", "003", "020"};
	String[] PracticeTwo = new String[]{"131", "331", "212", "112", "212"};
	String[] PracticeThree = new String[]{"020", "003", "100"};
	String[] PracticeFour = new String[]{"322", "121", "211"};
	String[] TestOne = new String[]{"100", "003", "020", "003", "100", "003", "020", "100", "020", "003", "100", "020", "003", "003", "100", "100", "020", "003", "100", "020", "020", "003", "100", "020"};
	int practiceOneArrayIndex = 0;
	int practiceTwoArrayIndex = 0;
	int practiceThreeArrayIndex = 0;
	int practiceFourArrayIndex = 0;
	int testOneArrayIndex = 0;
	int testTwoArrayIndex = 0;
	int trial = 1;
	String buttonPressed;
	boolean isButtonPressed = false;
	
	
	int count = 0;
	boolean trialRunning = false;
	long startTime = 0;
   	long currentTime = 0;
   	long elapsedTime = 0;
   	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton(); 
    }
    
    @Override
    protected void onStart(){ 
        super.onStart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void addListenerOnButton() {
    	
    	button1 = (Button) findViewById(R.id.button1);
    	button2 = (Button) findViewById(R.id.button2);
    	button3 = (Button) findViewById(R.id.button3);
    	
    	button1.setOnClickListener(new OnClickListener() {
    		TextView stimuliText = (TextView) findViewById(R.id.textViewStimuli);    
    		@Override
    		public void onClick(View arg0) {
    			showStimuli(stimuliText, button1);
    		}
    	});
    	
    	button2.setOnClickListener(new OnClickListener() {
    		TextView stimuliText = (TextView) findViewById(R.id.textViewStimuli); 
    		@Override
    		public void onClick(View arg0) {
    			showStimuli(stimuliText, button2);
    		}
    	});
    	
    	button3.setOnClickListener(new OnClickListener() {
    		TextView stimuliText = (TextView) findViewById(R.id.textViewStimuli); 
    		@Override
    		public void onClick(View arg0) {
    			showStimuli(stimuliText, button3);
    		}
    	});
    	
	}
    
    void showStimuli(final TextView stimuliText, final Button button){
		if(practiceOneArrayIndex<PracticeOne.length){
			disableButtons();
			stimuliText.setText("+");
			button.postDelayed(new Runnable(){
				@Override
				public void run(){
					enableButtons();
					stimuliText.setText(PracticeOne[practiceOneArrayIndex]);    	    		
					practiceOneArrayIndex++;
    	    		trial++;
				}
			}, 250);
		} else if(practiceTwoArrayIndex<PracticeTwo.length){
			disableButtons();
			stimuliText.setText("+");
			button.postDelayed(new Runnable(){
				@Override
				public void run(){
					enableButtons();
					stimuliText.setText(PracticeTwo[practiceTwoArrayIndex]);    	    		
					practiceTwoArrayIndex++;
    	    		trial++;
				}
			}, 250);
		} else if(practiceThreeArrayIndex<PracticeThree.length){
			disableButtons();
			stimuliText.setText("+");
			button.postDelayed(new Runnable(){
				@Override
				public void run(){
					enableButtons();
					stimuliText.setText(PracticeThree[practiceThreeArrayIndex]);    	    		
					practiceThreeArrayIndex++;
    	    		trial++;
				}
			}, 250);
		} else if(practiceFourArrayIndex<PracticeFour.length){
			disableButtons();
			stimuliText.setText("+");
			button.postDelayed(new Runnable(){
				@Override
				public void run(){
					enableButtons();
					stimuliText.setText(PracticeFour[practiceFourArrayIndex]);    	    		
					practiceFourArrayIndex++;
    	    		trial++;
				}
			}, 250);
		}
    }
    
    void disableButtons(){
    	button1.setClickable(false);
		button2.setClickable(false);
		button3.setClickable(false);
    }
    void enableButtons(){
    	button1.setClickable(true);
		button2.setClickable(true);
		button3.setClickable(true);
    }
  
}
