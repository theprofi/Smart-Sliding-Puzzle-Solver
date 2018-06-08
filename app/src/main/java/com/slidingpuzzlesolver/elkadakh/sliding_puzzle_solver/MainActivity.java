package com.slidingpuzzlesolver.elkadakh.sliding_puzzle_solver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Make the github text view a link
        TextView t2 = findViewById(R.id.txtGitLink);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void runBtnClick(View runBtn) {
        try {
            solve();
        }
        catch (InputException ie){
            showProblem(ie.prob);
        }

    }

    private void solve() throws InputException{
        UI_IO ips = new UI_IO(this);
        Solver s = new Solver(ips);
        s.solve();
    }

    private void showProblem(ProblemIdentifier prob){
        switch (prob) {
            case initBoard:
                Toast.makeText(getApplicationContext(),
                        "A problem in the input of the initial board",
                        Toast.LENGTH_LONG).show();
                break;
            case costHalf:
                Toast.makeText(getApplicationContext(),
                        "A problem in the input of blocks of cost 0.5",
                        Toast.LENGTH_LONG).show();
                break;
            case cost2:
                Toast.makeText(getApplicationContext(),
                        "A problem in the input of blocks of cost 2",
                        Toast.LENGTH_LONG).show();
                break;
            case someCost2cost05Same:
                Toast.makeText(getApplicationContext(),
                        "Some of the blocks in cost 2 blocks' " +
                                "list are in cost 0.5 blocks' list",
                        Toast.LENGTH_LONG).show();
                break;
        }
    }
}
