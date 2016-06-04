/**
 * Name - Sindhuja R Gundreddy
 * Project Name - Grade Calculator
 * This Project calculates the Grade for two courses CSCI240 & CSCI241 according to the grading criteria of the course.
 * The user has to enter all the points he secured in each individual quiz, assignment, exam.
 * Present Activity - This activity displays when the user selects the button Next in Cscib activity.
 * It contains the Assignments 1-8 and the user can enter all the points they secured in each of the Assignment.
 */


package edu.niu.cs.sindhujagundreddy.gradecalculator;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.InputFilter;
        import android.text.Spanned;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class Cscibb extends AppCompatActivity {

    //DataMembers
    EditText assign1ET, assign2ET, assign3ET, assign4ET, assign5ET, assign6ET, assign7ET, assign8ET;
    Integer assnResult,quizResult;
    Integer n1, n2,n3, n4, n5, n6, n7, n8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cscibb);


        //Connecting to the screen and setting Minimum, Maximum values for each assignments
        assign1ET = (EditText)findViewById(R.id.assign1EditText);
        assign1ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});
        assign2ET = (EditText)findViewById(R.id.assign2EditText);
        assign2ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});
        assign3ET = (EditText)findViewById(R.id.assign3EditText);
        assign3ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});
        assign4ET = (EditText)findViewById(R.id.assign4EditText);
        assign4ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});
        assign5ET = (EditText)findViewById(R.id.assign5EditText);
        assign5ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});
        assign6ET = (EditText)findViewById(R.id.assign6EditText);
        assign6ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});
        assign7ET = (EditText)findViewById(R.id.assign7EditText);
        assign7ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});
        assign8ET = (EditText)findViewById(R.id.assign8EditText);
        assign8ET.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});


        Intent mIntent = getIntent();
        quizResult = mIntent.getIntExtra("quiz",0);
    }//end onCreate

    /*
    Function InputFilterMinMax - This function considers the Min,Max values for each of the Assignments and
    set a upper and lower boundary by not accepting any other values out of the boundaries.
     */
    public class InputFilterMinMax implements InputFilter {

        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }//end Constructor

        public InputFilterMinMax(String min, String max) {
            this.min = Integer.parseInt(min);
            this.max = Integer.parseInt(max);
        }//end Constructor

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
    Function gotoExam - This function is called when the next button is clicked on screen. It calculates the total of Assignments and moves to the next activity.
    */

    public void gotoExam(View view)
    {

        try {
            n1 = Integer.parseInt(assign1ET.getText().toString());
            n2 = Integer.parseInt(assign2ET.getText().toString());
            n3 = Integer.parseInt(assign3ET.getText().toString());
            n4 = Integer.parseInt(assign4ET.getText().toString());
            n5 = Integer.parseInt(assign5ET.getText().toString());
            n6 = Integer.parseInt(assign6ET.getText().toString());
            n7 = Integer.parseInt(assign7ET.getText().toString());
            n8 = Integer.parseInt(assign8ET.getText().toString());

            assnResult = n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Intent IntentExam = new Intent(Cscibb.this, Cscibe.class);
        IntentExam.putExtra("quiz1", quizResult);
        IntentExam.putExtra("assn",assnResult);
        startActivity(IntentExam);
    }//end of gotoAssn
}//end Cscibb
