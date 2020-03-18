package com.example.calculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    double lastNum = 0;
    String lastOperation;
    String lastClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView calcText = findViewById(R.id.calcTextView);


        //restore data from bundle savedinstancestate
        if(savedInstanceState!= null){
            lastOperation = savedInstanceState.getString("lastOperation");
            lastClicked = savedInstanceState.getString("lastClicked");
            lastNum = savedInstanceState.getDouble("lastNum");
            String lastCalcText = savedInstanceState.getString("calcTextViewContent");
            calcText.setText(lastCalcText);

        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String lastCalcText = calcText.getText().toString();
        outState.putDouble("lastNum",lastNum);
        outState.putString("lastOperation",lastOperation);
        outState.putString("lastClicked",lastClicked);
        outState.putString("calcTextViewContent",lastCalcText);
    }

    //Numbers clicked
    public void Clicked_1(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") || currentText.equals("")|| lastClicked.length()!=1){
            currentText = "1";
        }else{
            currentText += "1";
        }
        lastClicked = "1";
        calcText.setText(currentText);
    }
    public void Clicked_2(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") || currentText.equals("")||  lastClicked.length()>1){
            currentText = "2";
        }else{
            currentText += "2";
        }
        lastClicked = "2";
        calcText.setText(currentText);
    }
    public void Clicked_3(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") ||  lastClicked.length()>1){
            currentText = "3";
        }else{
            currentText += "3";
        }
        lastClicked = "3";
        calcText.setText(currentText);
    }
    public void Clicked_4(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") ||  lastClicked.length()>1){
            currentText = "4";
        }else{
            currentText += "4";
        }
        lastClicked = "4";
        calcText.setText(currentText);
    }
    public void Clicked_5(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") ||  lastClicked.length()>1){
            currentText = "5";
        }else{
            currentText += "5";
        }
        lastClicked = "5";
        calcText.setText(currentText);
    }
    public void Clicked_6(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") ||  lastClicked.length()>1){
            currentText = "6";
        }else{
            currentText += "6";
        }
        lastClicked = "6";
        calcText.setText(currentText);
    }
    public void Clicked_7(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") ||  lastClicked.length()>1){
            currentText = "7";
        }else{
            currentText += "7";
        }
        lastClicked = "7";
        calcText.setText(currentText);
    }
    public void Clicked_8(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") ||  lastClicked.length()>1){
            currentText = "8";
        }else{
            currentText += "8";
        }
        lastClicked = "8";
        calcText.setText(currentText);
    }
    public void Clicked_9(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") ||  lastClicked.length()>1){
            currentText = "9";
        }else{
            currentText += "9";
        }
        lastClicked = "9";
        calcText.setText(currentText);
    }
    public void Clicked_0(View View){

        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.equals("0") ||  lastClicked.length()>1){
            currentText = "0";
        }else{
            currentText += "0";
        }
        lastClicked = "0";
        calcText.setText(currentText);
    }


    //Equals
    public void Equals_Clicked(View View) {
        lastClicked = "Equals";
        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if (lastNum == 0 && lastOperation.equals("")) {

        } else if (lastOperation.equals("Add")) {
            //maybe use BigDecimal class instead for RoundingMode consistency
            double currentNum = Double.parseDouble(currentText);
            double CalcResult = currentNum + lastNum;
            lastNum = 0;
            lastOperation = "";
            calcText.setText(Double.toString(CalcResult));

        }else if(lastOperation.equals("Subtract")){
            //maybe use BigDecimal class instead for RoundingMode consistency
                double currentNum = Double.parseDouble(currentText);
                if(lastNum != 0){
                    double CalcResult = lastNum - currentNum;
                    lastNum = 0;
                    lastOperation = "";
                    calcText.setText(Double.toString(CalcResult));
                }

        }else if(lastOperation.equals("Divide")){
            if(currentText.equals(("0"))) {
                Toast.makeText(this,"Cannot divide by Zero",Toast.LENGTH_SHORT).show();
            }else{
                BigDecimal lastNumDec = new BigDecimal((lastNum));
                BigDecimal currentNum;
                double currentNumDouble = Double.parseDouble(currentText);
                currentNum = new BigDecimal(currentNumDouble);
                BigDecimal CalcResult = lastNumDec.divide(currentNum, 12, RoundingMode.HALF_UP);
                lastNum = 0;
                lastOperation = "";
                calcText.setText(CalcResult.stripTrailingZeros().toString());
                //calcText.setText(String.format("%.8f",CalcResult));
            }



        }else if(lastOperation.equals("Multiply")){
                //maybe use BigDecimal class instead for RoundingMode consistency
                double currentNum = Double.parseDouble(currentText);
                if(lastNum != 0) {
                    double CalcResult = lastNum * currentNum;
                    lastNum = 0;
                    lastOperation = "";
                    calcText.setText(Double.toString(CalcResult));
                }

        }else{

        }

    }
    //Cancel
    public void Clicked_Cancel(View View){
        lastClicked = "Cancel";
        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        calcText.setText("0");
    }
    //BackSpace
    public void BackSpace_Clicked(View view){
        lastClicked="BackSpace";
        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(currentText.length() <= 1){
            calcText.setText("0");
        }else{
            calcText.setText(currentText.substring(0,currentText.length()-1));
        }

    }

    //Positive-Negative
    public void Pos_Neg_Clicked(View View){
        lastClicked = "Positive/Negative";
        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(!currentText.equals("0")){
            if(currentText.charAt(0)=='-'){
                currentText = currentText.substring(1);
            }else{
                currentText = "-"+currentText;
            }
        }
        calcText.setText(currentText);
    }
    //Decimal
    public void Decimal_Clicked(View View){
        lastClicked = ".";
        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(!currentText.contains(".")){
            currentText += ".";
        }
        calcText.setText(currentText);
    }

    //calculations

        //Add
    public void Add_Clicked(View View){
        if(!lastClicked.equals("Add")) {
            lastClicked = "Add";
            TextView calcText = (TextView) findViewById(R.id.calcTextView);
            String currentText = calcText.getText().toString();
            if (lastNum == 0  || !lastOperation.equals("Add")) {
                if(currentText.length() == 0){
                    calcText.setText("");
                    lastOperation = "Add";
                }else{
                    lastNum = Double.parseDouble(currentText);
                    calcText.setText("");
                    lastOperation = "Add";
                }

            } else {
                double currentNum = Double.parseDouble(currentText);
                double CalcResult = currentNum + lastNum;
                lastNum = 0;
                lastOperation = "";
                calcText.setText(Double.toString(CalcResult));
            }
        }


    }

        //Subtract

    public void Subtract_Clicked(View view){
        if(!lastClicked.equals("Subtract")) {
            lastClicked = "Subtract";
            TextView calcText = (TextView) findViewById(R.id.calcTextView);
            String currentText = calcText.getText().toString();
            if (lastNum == 0   || !lastOperation.equals("Subtract")) {
                if(currentText.length()==0){
                    calcText.setText("");
                    lastOperation = "Subtract";
                }else{
                    lastNum = Double.parseDouble(currentText);
                    calcText.setText("");
                    lastOperation = "Subtract";
                }

            } else {
                double currentNum = Double.parseDouble(currentText);
                if (lastNum != 0) {
                    double CalcResult = lastNum - currentNum;
                    lastNum = 0;
                    lastOperation = "";
                    calcText.setText(Double.toString(CalcResult));
                }
            }
        }


    }

        //Multiply

    public void Multiply_Clicked(View view){
        if(!lastClicked.equals("Multiply")){
            lastClicked = "Multiply";
            TextView calcText = (TextView) findViewById(R.id.calcTextView);
            String currentText = calcText.getText().toString();
            if(lastNum == 0 || !lastOperation.equals("Multiply")){
                if(currentText.length()==0){
                    calcText.setText("");
                    lastOperation = "Multiply";
                }else{
                    lastNum = Double.parseDouble(currentText);
                    calcText.setText("");
                    lastOperation="Multiply";
                }

            }else{
                double currentNum = Double.parseDouble(currentText);
                if(lastNum != 0) {
                    double CalcResult = lastNum * currentNum;
                    lastNum = 0;
                    lastOperation = "";
                    calcText.setText(Double.toString(CalcResult));
                }

            }
        }



    }

        //Divide

    public void Divide_Clicked(View view){
        if(!lastClicked.equals("Divide")) {
            lastClicked = "Divide";
            TextView calcText = (TextView) findViewById(R.id.calcTextView);
            String currentText = calcText.getText().toString();
            if (lastNum == 0   || !lastOperation.equals("Divide")) {
                if(currentText.length()==0){
                    calcText.setText("");
                    lastOperation = "Divide";
                }else{
                    lastNum = Double.parseDouble(currentText);
                    calcText.setText("");
                    lastOperation = "Divide";
                }

            } else {
                BigDecimal lastNumDec = new BigDecimal((lastNum));
                BigDecimal currentNum;
                double currentNumDouble = Double.parseDouble(currentText);
                currentNum = new BigDecimal(currentNumDouble);
                BigDecimal CalcResult = lastNumDec.divide(currentNum, 12, RoundingMode.HALF_UP);
                lastNum = 0;
                lastOperation = "";
                calcText.setText(CalcResult.stripTrailingZeros().toString());
                //calcText.setText(String.format("%.8f",CalcResult));
            }
        }

    }

    //Percent

    public void Percent_Clicked(View view){
        lastClicked = "Percent";
        TextView calcText= (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        if(!currentText.equals("0")){
            BigDecimal currentNum;
            if(currentText.contains(".")){
                double currentNumDouble = Double.parseDouble(currentText);
                currentNum = new BigDecimal(currentNumDouble);
            }else{
                currentNum = new BigDecimal(currentText);
            }
            BigDecimal CalcResult = currentNum.divide(new BigDecimal(100), 12, RoundingMode.HALF_UP);
            calcText.setText(CalcResult.stripTrailingZeros().toString());
            //calcText.setText(String.format("%.8f",CalcResult));
        }
    }

    // 1/x

    public void One_By_X_Clicked(View view){
        lastClicked = "One By X";
        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        BigDecimal currentNum;
        if(currentText.equals("0")){
            Toast.makeText(this,"Cannot Divide By 0", Toast.LENGTH_SHORT).show();
        }else{
            if(!currentText.contains(".")){
                double currentNumDouble = Double.parseDouble(currentText);
                currentNum = new BigDecimal(currentNumDouble);
            }else{
                currentNum = new BigDecimal(currentText);
            }
            BigDecimal CalcResult = new BigDecimal(1).divide(currentNum, 12, RoundingMode.HALF_UP);
            calcText.setText(CalcResult.stripTrailingZeros().toString());
            //calcText.setText(String.format("%.8f",CalcResult));
        }
    }

    // square x^2

    public void Square_Clicked(View view){
        lastClicked = "Square";
        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        double currentNumDouble = Double.parseDouble(currentText);
        double CalcResult = currentNumDouble * currentNumDouble;
        calcText.setText(Double.toString(CalcResult));
    }

    // square root

    public void Sqrt_Clicked(View view){
        lastClicked = "Square";
        TextView calcText = (TextView) findViewById(R.id.calcTextView);
        String currentText = calcText.getText().toString();
        double currentNumDouble = Double.parseDouble(currentText);
        double CalcResult = Math.sqrt(currentNumDouble);
        calcText.setText(Double.toString(CalcResult));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this,"Landscape",Toast.LENGTH_SHORT).show();
            //setContentView(R.horizontalLayout);
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this,"Portrait",Toast.LENGTH_SHORT).show();
            //setContentView(R.verticalLayout);
        }
    }
}
