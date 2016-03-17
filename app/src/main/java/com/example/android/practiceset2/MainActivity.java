package com.example.android.practiceset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int homeTeamScore = 0;
    public int guestTeamScore = 0;
    public String score = "00:00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        assert getSupportActionBar() != null;
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void incrementHomeThree(View view) {
        homeTeamScore += 3;
        displayScore();
    }
    public void incrementHomeTwo(View view) {
        homeTeamScore += 2;
        displayScore();
    }
    public void incrementHomeOne(View view) {
        homeTeamScore += 1;
        displayScore();
    }

    public void incrementGuestThree(View view) {
        guestTeamScore += 3;
        displayScore();
    }
    public void incrementGuestTwo(View view) {
        guestTeamScore += 2;
        displayScore();
    }
    public void incrementGuestOne(View view) {
        guestTeamScore += 1;
        displayScore();
    }

    public void decrementHomeOne(View view) {
        homeTeamScore -= 1;
        if (homeTeamScore <= 0) {
            homeTeamScore = 0;
        }
        displayScore();
    }
    public void decrementGuestOne(View view) {
        guestTeamScore -= 1;
        if (guestTeamScore <= 0) {
            guestTeamScore = 0;
        }
        displayScore();
    }

    public void displayScore() {
        TextView score = (TextView) findViewById(R.id.scoreBoard);
        if ((homeTeamScore == 0) && (guestTeamScore == 0)) {
                score.setText("00:00");
            } else {
                score.setText(homeTeamScore + ":" + guestTeamScore);
            }
        }

    //public void showMenu (View view) {
    //    TextView score = (TextView) findViewById(R.id.scoreBoard);
    //    score.setText("00:00");
    //    TextView menuBackground = (TextView) findViewById(R.id.menuBackground);
    //    menuBackground.setVisibility(View.GONE);
    //    TextView menu = (TextView) findViewById(R.id.menu);
    //    menu.setVisibility(View.VISIBLE);
    //}
    //public void hideMenu (View view) {
    //    displayScore();
    //    TextView menu = (TextView) findViewById(R.id.menu);
    //    menu.setVisibility(View.GONE);
    //    TextView menuBackground = (TextView) findViewById(R.id.menuBackground);
    //    menuBackground.setVisibility(View.GONE);
    //}
}

