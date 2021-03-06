package com.kunal.myfirstapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.text.InputFilter;
import android.text.InputType;
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
	String taskName = "MSIT";
	//To be changed to user input
	String userId = "1234";

	int count = 0;
	boolean trialRunning = false;
	long startTime = 0;
   	long currentTime = 0;
   	long elapsedTime = 0;
   	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);        

        userIdAlert();
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
    
    @Override
    public void onBackPressed() {
    } 
    
    public void userIdAlert() {
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);
    	alert.setTitle("Enter User ID:");

    	// Set an EditText view to get user input 
    	final EditText input = new EditText(this);
    	input.setInputType(InputType.TYPE_CLASS_NUMBER);
    	InputFilter[] FilterArray = new InputFilter[1];
    	FilterArray[0] = new InputFilter.LengthFilter(4);
    	input.setFilters(FilterArray);
    	alert.setView(input);

    	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	public void onClick(DialogInterface dialog, int whichButton) {
    	  String value = input.getText().toString();
    	  userId = value;
    	  createCSV();
    	  }
    	});
    	alert.show();
    }
    
    public void createCSV(){
    	try {
        	Date date = Calendar.getInstance().getTime();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        	String fileNameDate = sdf.format(date);
        	
        	String fileName = taskName + "_" + userId  + "_" + fileNameDate + ".csv";
            FileOutputStream fos = openFileOutput(fileName,
                    Context.MODE_APPEND | Context.MODE_APPEND);
            String str = "ID, Date, Time, RA,";
            fos.write(str.getBytes("UTF-16"));
            fos.close();
            
            String storageState = Environment.getExternalStorageState();
            if (storageState.equals(Environment.MEDIA_MOUNTED)) {
              
            	File file = new File(getExternalFilesDir(null),
            			fileName);
                FileOutputStream fos2 = new FileOutputStream(file);
                fos2.write(str.getBytes("UTF-16"));
                String newLine = "\r\n"; 
                fos2.write(newLine.getBytes("UTF-16"));
                fos2.write(str.getBytes("UTF-16"));
                fos2.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    	//Calculate time duration for each trial
    	if(trial == 1){
    		startTime = System.nanoTime();
    	}else{
    		currentTime = System.nanoTime();
    		elapsedTime = currentTime - startTime;
    		startTime = currentTime;
    	}
    	Log.i(String.valueOf(trial), String.valueOf(TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)));
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
		} else if(testOneArrayIndex<TestOne.length){
			disableButtons();
			stimuliText.setText("+");
			button.postDelayed(new Runnable(){
				@Override
				public void run(){
					final int myTrial = trial;
					enableButtons();
					stimuliText.setText(TestOne[testOneArrayIndex]);
					Runnable r = new Runnable() {
						@Override
						public void run(){
							if (myTrial == trial - 1) {
								showStimuli(stimuliText, button);
							}
						}
					};
					button.postDelayed(r, 2500);
					testOneArrayIndex++;
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
