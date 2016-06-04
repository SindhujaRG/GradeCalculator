/**
 * Name - Sindhuja R Gundreddy
 * Project Name - Grade Calculator
 * This Project calculates the Grade for two courses CSCI240 & CSCI241 according to the grading criteria of the course.
 * The user has to enter all the points he secured in each individual quiz, assignment, exam.
 * Present Activity - This activity is the main activity that displays as the app is launched.
 * It contains two buttons and the user can select one amongst them to calculate the grade for that particular course.
 */

package edu.niu.cs.sindhujagundreddy.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Data Members
    private Button Btn240, Btn241;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connecting to Screen
        Btn240 = (Button)findViewById(R.id.csci240Button);
        Btn241 = (Button)findViewById(R.id.csci241Button);
    }//end onCreate


    /*
    Function Calca - This is called when the button CSCI 240 is selected/clicked. It contains code to move the next respective activity.
     */
    public void Calca(View view)
    {
        Intent Intenta = new Intent(MainActivity.this,Cscia.class);
        startActivity(Intenta);
    }//end Calca


    /*
    Function Calcb - This is called when the button CSCI 241 is selected/clicked. It contains code to move the next respective activity.
     */
    public void Calcb(View view)
    {
        Intent Intentb = new Intent(MainActivity.this,Cscib.class);
        startActivity(Intentb);
    }//end Calcb

}//end MainActivity
