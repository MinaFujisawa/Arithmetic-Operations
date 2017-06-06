package com.example.arithmeticoperations;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mNum_left;
    private TextView mNum_right;
    private TextView mNum_answer;
    private Button mBtn_addition;
    private Button mBtn_subtraction;
    private Button mBtn_times;
    private Button mBtn_division;
    private Formula formula;
    private FormulaLab formulaLab;
    private Formula[] mFormulaList;
    private int index = 0;
    private int mPoint = 0;
    Dialog settingsDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        formula = new Formula();
        formulaLab = FormulaLab.get(getApplicationContext());
        mFormulaList = formulaLab.getmFormulaList();

        mBtn_addition = (Button) findViewById(R.id.addition);
        mBtn_addition.setOnClickListener(this); // calling onClick() method
        mBtn_subtraction = (Button) findViewById(R.id.subtraction);
        mBtn_subtraction.setOnClickListener(this);
        mBtn_times = (Button) findViewById(R.id.times);
        mBtn_times.setOnClickListener(this);
        mBtn_division = (Button) findViewById(R.id.division);
        mBtn_division.setOnClickListener(this);

        settingsDialog = new Dialog(this, R.style.TransparentDialogTheme);

        loadActivity();
    }


    private void loadActivity() {
        if (index < mFormulaList.length) {
            mNum_left = (TextView) findViewById(R.id.num_left);
            mNum_left.setText(String.valueOf(mFormulaList[index].getmNum_left()));

            mNum_right = (TextView) findViewById(R.id.num_right);
            mNum_right.setText(String.valueOf(mFormulaList[index].getmNum_right()));

            mNum_answer = (TextView) findViewById(R.id.num_answer);
            mNum_answer.setText(String.valueOf(mFormulaList[index].getmNum_answer()));
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.addition:
                if (mFormulaList[index].getmOperation().equals("addition")) {
                    showImage(true);
                    mPoint++;
                } else {
                    showImage(false);
                }
                index++;
                loadActivity();
                break;

            case R.id.subtraction:
                if (mFormulaList[index].getmOperation().equals("subtraction")) {
                    showImage(true);
                    mPoint++;
                } else {
                    showImage(false);
                }
                index++;
                loadActivity();
                break;

            case R.id.times:
                if (mFormulaList[index].getmOperation().equals("times")) {
                    showImage(true);
                    mPoint++;
                } else {
                    showImage(false);
                }
                index++;
                loadActivity();
                break;

            case R.id.division:
                if (mFormulaList[index].getmOperation().equals("division")) {
                    showImage(true);
                    mPoint++;
                } else {
                    showImage(false);
                }
                index++;
                loadActivity();
                break;

            default:
                break;
        }
    }


    public void showImage(boolean isCorrect) {

        settingsDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));

        settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.my_dialog
                , null));
        ImageView imageView = (ImageView) settingsDialog.findViewById(R.id.dialogIcon);
        if (isCorrect) {
            imageView.setImageResource(R.drawable.correct);
        } else {
            imageView.setImageResource(R.drawable.incorrect);
        }
        settingsDialog.show();
    }


}
