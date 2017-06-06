package com.example.arithmeticoperations;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
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
    private ImageView mDialogImageView;


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

        settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.my_dialog
                , null));
        mDialogImageView = (ImageView) settingsDialog.findViewById(R.id.dialogIcon);

        loadActivity();
    }


    private void loadActivity() {

        settingsDialog.dismiss();

        if (index < mFormulaList.length) {
            mNum_left = (TextView) findViewById(R.id.num_left);
            mNum_left.setText(String.valueOf(mFormulaList[index].getmNum_left()));

            mNum_right = (TextView) findViewById(R.id.num_right);
            mNum_right.setText(String.valueOf(mFormulaList[index].getmNum_right()));

            mNum_answer = (TextView) findViewById(R.id.num_answer);
            mNum_answer.setText(String.valueOf(mFormulaList[index].getmNum_answer()));
        }

    }

    private void check(String operator) {
        if (mFormulaList[index].getmOperation().equals(operator)) {
            showImage(true);
            mPoint++;
        } else {
            showImage(false);
        }
        index++;
        new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                loadActivity();
            }
        }.start();
    }


    public void showImage(boolean isCorrect) {

        settingsDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        if (isCorrect) {
            mDialogImageView.setImageResource(R.drawable.correct);
        } else {
            mDialogImageView.setImageResource(R.drawable.incorrect);
        }
        settingsDialog.show();
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.addition:
                check("addition");
                break;

            case R.id.subtraction:
                check("subtraction");
                break;

            case R.id.times:
                check("times");
                break;

            case R.id.division:
                check("division");
                break;

            default:
                break;
        }
    }


}
