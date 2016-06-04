/**
 * Name - Sindhuja R Gundreddy
 * Project Name - Grade Calculator
 * This Project calculates the Grade for two courses CSCI240 & CSCI241 according to the grading criteria of the course.
 * The user has to enter all the points he secured in each individual quiz, assignment, exam.
 * Present Activity - This activity displays when the user selects the button done in Cscibe.
 * It contains the final result and the user need not enter anything in this activity.
 */
package edu.niu.cs.sindhujagundreddy.gradecalculator;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Cscibresult extends AppCompatActivity {
    //Data Members
    Double examResult,quizResult,assnResult,Finala,Finalb,Result;
    TextView aTV,calculateProgressTV;
    String Grade;
    ProgressBar calculatePB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cscibresult);


        //Connect to the screen
        calculatePB = (ProgressBar)findViewById(R.id.calculateProgressBar);
        calculateProgressTV = (TextView)findViewById(R.id.calculateTextView);
        aTV = (TextView)findViewById(R.id.aTextView);


        //Get intent and wrap to double.
        Intent eIntent = getIntent();
        quizResult = Double.valueOf(eIntent.getIntExtra("quiz2",0));
        assnResult = Double.valueOf(eIntent.getIntExtra("assn1",0));
        examResult = Double.valueOf(eIntent.getIntExtra("exam",0));

        calculate();

        new PerformAsyncTask().execute();

    }//end onCreate

     /*
    Function calculate - This function calculates the final grade of the particular course according to the points entered by the user in the previous three activities.
     */

    private void calculate()
    {
        //Quiz total - 200, Exam Total - 450
        Finala = ((quizResult+examResult)/650)*70;
        //Assignment Total - 800
        Finalb = (assnResult/800)*30;
        Result = Finala + Finalb;

        //Grading criteria according to percentage
        if (Result >= 90)
        {
            Grade = "A";
        }
        else if (Result < 90 && Result >= 80)
        {
            Grade = "B";
        }
        else if (Result < 80 && Result >= 70)
        {
            Grade = "C";
        }
        else if (Result < 70 && Result >= 60)
        {
            Grade = "D";
        }
        else
        {
            Grade = "F";
        }
        aTV.setText("Final Result " + Grade);
    }//end calculate

    /*
   Function PerformAsyncTask - This is called upon create and performs the updation of prograss bar.
    */
    private class PerformAsyncTask extends AsyncTask<Void,Integer,Void>
    {
        int progressStatus;
        /*
        Method doInBackground - It is the task that is done in background when the progress bar is working.
        */

        @Override
        protected Void doInBackground(Void... params) {
            while (progressStatus < 100)
            {
                progressStatus +=5;
                publishProgress(progressStatus);
                SystemClock.sleep(200);
            }
            return null;
        }

        /*
        Method onPreExecute - The status of the progress bar before the execution is started.
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressStatus = 0;
            calculateProgressTV.setText("Calculating your Grade   0%");

        }//end of onPreExecute

        /*
       Method onPostExecute - Works after the progressbar execution is complete.
        */
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            calculateProgressTV.setText("Grade Calculation Complete");
            calculateProgressTV.setEnabled(true);
            aTV.setVisibility(View.VISIBLE);

        }//end of onPostExecute

        /*
        Method onProgressUpdate - works every time the progress bar is updated.
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            calculatePB.setProgress(values[0]);
            calculateProgressTV.setText("Calculating your Grade" + values[0] + "%");
        }//end of onProgressUpdate
    }//end of PerformAsyncTask
}
