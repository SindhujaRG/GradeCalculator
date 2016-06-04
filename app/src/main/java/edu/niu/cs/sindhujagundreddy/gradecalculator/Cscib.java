package edu.niu.cs.sindhujagundreddy.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.text.InputFilter;
import android.text.Spanned;

public class Cscib extends AppCompatActivity {

    //DataMembers
    EditText quiz1ET, quiz2ET, quiz3ET, quiz4ET, quiz5ET, quiz6ET, quiz7ET, quiz8ET, quiz9ET, quiz10ET, quiz11ET, quiz12ET;
    Integer quizResult;
    Integer num1, num2,num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, min1, min2,i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cscib);

        //Connecting to the screen and setting Minimum, Maximum values for each quiz
        quiz1ET = (EditText)findViewById(R.id.quiz1EditText);
        quiz1ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz2ET = (EditText)findViewById(R.id.quiz2EditText);
        quiz2ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz3ET = (EditText)findViewById(R.id.quiz3EditText);
        quiz3ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz4ET = (EditText)findViewById(R.id.quiz4EditText);
        quiz4ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz5ET = (EditText)findViewById(R.id.quiz5EditText);
        quiz5ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz6ET = (EditText)findViewById(R.id.quiz6EditText);
        quiz6ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz7ET = (EditText)findViewById(R.id.quiz7EditText);
        quiz7ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz8ET = (EditText)findViewById(R.id.quiz8EditText);
        quiz8ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz9ET = (EditText)findViewById(R.id.quiz9EditText);
        quiz9ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz10ET = (EditText)findViewById(R.id.quiz10EditText);
        quiz10ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz11ET = (EditText)findViewById(R.id.quiz11EditText);
        quiz11ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        quiz12ET = (EditText)findViewById(R.id.quiz12EditText);
        quiz12ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});

    }//end of onCreate


        /*
       Function InputFilterMinMax - This function considers the Min,Max values for each of the quizes and
       set a upper and lower boundary by not accepting any other values out of the boundaries.
        */
    public class InputFilterMinMax implements InputFilter {

        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }//end constructor

        public InputFilterMinMax(String min, String max) {
            this.min = Integer.parseInt(min);
            this.max = Integer.parseInt(max);
        }//end constructor

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (isInRange(min, max, input))
                    return null;
            } catch (NumberFormatException nfe) { }
            return "";
        }//end CharSequence

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }//end isInRange
    }//end InputFilterMinMax
/*
Function gotoAssn - This function is called when the next button is clicked on screen. It calculates the total of quizes and moves to the next activity.
*/
    public void gotoAssn(View view)
    {
        try
        {
            num1 = Integer.parseInt(quiz1ET.getText().toString());
            num2 = Integer.parseInt(quiz2ET.getText().toString());
            num3 = Integer.parseInt(quiz3ET.getText().toString());
            num4 = Integer.parseInt(quiz4ET.getText().toString());
            num5 = Integer.parseInt(quiz5ET.getText().toString());
            num6 = Integer.parseInt(quiz6ET.getText().toString());
            num7 = Integer.parseInt(quiz7ET.getText().toString());
            num8 = Integer.parseInt(quiz8ET.getText().toString());
            num9 = Integer.parseInt(quiz9ET.getText().toString());
            num10 = Integer.parseInt(quiz10ET.getText().toString());
            num11 = Integer.parseInt(quiz11ET.getText().toString());
            num12 = Integer.parseInt(quiz12ET.getText().toString());

            //array of user entered quiz values.
            Integer anum[] = {num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12};

            //Sorting out the least two quiz values to eliminate them.
            min1 = anum[0];
            min2 = anum[1];
            if (min2 < min1)
            {
                min1 = anum[1];
                min2 = anum[0];
            }

            for (i =2; i < anum.length; i++)
            {
                if (anum[i]< min1)
                {
                    min2 = min1;
                    min1 = anum[i];
                }
                else if (anum[i] < min2)
                {
                    min2 = anum[i];
                }

            }

            quizResult = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9 + num10 + num11 + num12 - min1 - min2;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Intent IntentAssn = new Intent(Cscib.this, Cscibb.class);
        IntentAssn.putExtra("quiz", quizResult);
        startActivity(IntentAssn);
    }//end of gotoAssn
}//end Cscib
