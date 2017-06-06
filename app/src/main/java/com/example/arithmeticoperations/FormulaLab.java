package com.example.arithmeticoperations;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by MinaFujisawa on 2017/06/04.
 */

public class FormulaLab {
    private static FormulaLab sFormulaLab;
    private Formula[] mFormulaList;
    private String[] mOperationTypes = {"addition", "subtraction", "times", "division"};
    private final static int MAX_QUESTION = 20;
    Random random = new Random();

    public static FormulaLab get(Context context) {
        if (sFormulaLab == null) {
            sFormulaLab = new FormulaLab(context);
        }
        return sFormulaLab;
    }

    public FormulaLab(Context context) {
        mFormulaList = new Formula[MAX_QUESTION];
        for (int i = 0; i < MAX_QUESTION; i++) {
            makeFormula(i);
        }
    }

    private void makeFormula(int i) {
        Formula formula = new Formula();
        String operation = mOperationTypes[random.nextInt(3)];
        int left, right;

        switch (operation) {
            case "times":
                left = random.nextInt(9);
                right = random.nextInt(9);
                formula.setmNum_left(left);
                formula.setmNum_right(right);
                formula.setmOperation("times");
                formula.setmNum_answer(left * right);
                mFormulaList[i] = formula;
                break;

            case "addition":
                left = random.nextInt(30) + 1;
                right = random.nextInt(9) + 1;
                formula.setmNum_left(left);
                formula.setmNum_right(right);
                formula.setmOperation("plus");
                formula.setmNum_answer(left + right);
                mFormulaList[i] = formula;

            case "subtraction":
                do {
                    left = random.nextInt(30) + 1;
                    right = random.nextInt(9) + 1;
                } while (left < right);

                formula.setmNum_left(left);
                formula.setmNum_right(right);
                formula.setmOperation("subtraction");
                formula.setmNum_answer(left - right);
                mFormulaList[i] = formula;

            case "division":
                do {
                    left = random.nextInt(30) + 1;
                    right = random.nextInt(9) + 2;
                } while (left < right || left % right != 0);

                formula.setmNum_left(left);
                formula.setmNum_right(right);
                formula.setmOperation("division");
                formula.setmNum_answer(left / right);
                mFormulaList[i] = formula;
        }
    }

    public Formula[] getmFormulaList() {
        return mFormulaList;
    }
}
