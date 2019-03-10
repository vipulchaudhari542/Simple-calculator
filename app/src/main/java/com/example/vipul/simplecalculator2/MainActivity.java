package com.example.vipul.simplecalculator2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    EditText edtNumber1;
    EditText edtNumber2;
    TextView txtResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //initialize Elements

        edtNumber1 = (EditText) findViewById(R.id.edtNumber1);
        edtNumber2 = (EditText) findViewById(R.id.edtNumber2);
        txtResult = (TextView) findViewById(R.id.txtResult);

    }

    public void compute(View v){

        //setup animation
        v.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_animation));


        //declare an input
        String firstInputAsText = edtNumber1.getText().toString();
        String secondInputAsText = edtNumber2.getText().toString();
        double firstNumber = 0;
        double secondNumber = 0;
        double resultAsNumber = 0;

        //validate input
        if(!firstInputAsText.isEmpty() && !secondInputAsText.isEmpty()){
            firstNumber  = Double.parseDouble(firstInputAsText);
            secondNumber = Double.parseDouble(secondInputAsText);
        }


        //get tag for the button was clicked

        String operation = v.getTag().toString();

        //setup result depending on operation

        if(operation.equals("addition")){

            resultAsNumber = firstNumber + secondNumber;
        }
        else if(operation.equals("subtraction")){
            resultAsNumber = firstNumber - secondNumber;
        }
        else if(operation.equals("multiplication")){
            resultAsNumber = firstNumber * secondNumber;
        }
        else if(operation.equals("division")){
            resultAsNumber = firstNumber / secondNumber;
        }
        else if(operation.equals("remainder")){
            resultAsNumber = firstNumber % secondNumber;
        }
        else if(operation.equals("exponent")){
            resultAsNumber = Math.pow(firstNumber, secondNumber);
        }

        //format and display the result on screen

        DecimalFormat formatter = new DecimalFormat("#,###,##");
        String resultAsText = formatter.format(resultAsNumber);
        txtResult.setText(resultAsText);
    }

}
