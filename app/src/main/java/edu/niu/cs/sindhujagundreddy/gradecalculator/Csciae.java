/**
 * Name - Sindhuja R Gundreddy
 * Project Name - Grade Calculator
 * This Project calculates the Grade for two courses CSCI240 & CSCI241 according to the grading criteria of the course.
 * The user has to enter all the points he secured in each individual quiz, assignment, exam.
 * Present Activity - This activity displays when the user selects the button Next in Csciaa.
 * It contains the exams 1-3 and the user can enter all the points they secured in each of the exams.
 */
package edu.niu.cs.sindhujagundreddy.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;

public class Csciae extends AppCompatActivity {

    //DataMembers
    EditText exam1ET, exam2ET, exam3ET;
    Integer examResult,quizResult,assnResult;
    Integer e1, e2, e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csciae);

        //Connecting to the screen and setting Minimum, Maximum values for each exam
        exam1ET = (EditText)findViewById(R.id.exam1EditText);
        exam1ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "150")});
        exam2ET = (EditText)findViewById(R.id.exam2EditText);
        exam2ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "150")});
        exam3ET = (EditText)findViewById(R.id.exam3EditText);
        exam3ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "150")});

        Intent aIntent = getIntent();
        quizResult = aIntent.getIntExtra("quiz1",0);
        assnResult = aIntent.getIntExtra("assn",0);

    }//end of onCreate

    /*
    Function InputFilterMinMax - This function considers the Min,Max values for each of the exams and
    set a upper and lower boundary by not accepting any other values out of the boundaries.
     */

    public class InputFilterMinMax implements InputFilter {

        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public InputFilterMinMax(String min, String max) {
            this.min = Integer.parseInt(min);
            this.max = Integer.parseInt(max);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (isInRange(min, max, input))
                    return null;
            } catch (NumberFormatException nfe) { }
            return "";
        }

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }//end isInRange
    }//end InputFilterMinMax
    /*
    Function gotoResult - This function is called when the done button is clicked on screen. It calculates the total of exams and moves to the next activity.
    */

    public void gotoResult(View view)
    {
        try {
            e1 = Integer.parseInt(exam1ET.getText().toString());
            e2 = Integer.parseInt(exam2ET.getText().toString());
            e3 = Integer.parseInt(exam3ET.getText().toString());
            examResult = e1 + e2 + e3;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Intent IntentResult = new Intent(Csciae.this, Csciaresult.class);
        IntentResult.putExtra("quiz2", quizResult);
        IntentResult.putExtra("assn1",assnResult);
        IntentResult.putExtra("exam",examResult);
        startActivity(IntentResult);
                
    }//end gotoResults

}//end Csciae
