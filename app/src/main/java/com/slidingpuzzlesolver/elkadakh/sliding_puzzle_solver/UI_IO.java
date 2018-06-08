package com.slidingpuzzlesolver.elkadakh.sliding_puzzle_solver;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


enum Algo {
    BFS, DFID, ASTAR, IDASTAR, DFBNB, ERROR
}

public class UI_IO {
    private MainActivity act;
    // The input data to pass to the solver
    ProblemIdentifier prob;
    String initialBoard;
    String costHalf;
    String cost2;
    int idxOfSelectedAlg;

    UI_IO(MainActivity act) {
        this.act = act;
        // Initialize all the string with the inputs from the UI
        initialBoard = ((EditText) act.findViewById(R.id.edittxtBoard)).getText().toString();
        costHalf = ((EditText) act.findViewById(R.id.edittxtHalf)).getText().toString();
        cost2 = ((EditText) act.findViewById(R.id.edittxtCost2)).getText().toString();

        // Get the index of the selected radio button
        RadioGroup rg = ((RadioGroup) act.findViewById(R.id.radioGroupAlgs));
        View selectedRadioButton = rg.findViewById(rg.getCheckedRadioButtonId());
        idxOfSelectedAlg = rg.indexOfChild(selectedRadioButton);
    }

    public void initOutput(){
        act.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                EditText editTextOutput = act.findViewById(R.id.edittxtOutput);
                editTextOutput.setText(R.string.solving);
            }
        });
    }

    public void showResult(final String output){
        act.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                EditText editTextOutput = act.findViewById(R.id.edittxtOutput);
                editTextOutput.setText(output);
            }
        });
    }
}
