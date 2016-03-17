package com.example.android.practiceset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    public void updateScore(View view) {
        ScoreButton thisButton = new ScoreButton();
        String tag = view.getTag().toString();
        String[] tags = tag.split("[ ]");
        thisButton.team = tags[0];
        thisButton.points = Integer.parseInt(tags[1]);

        switch (thisButton.team) {
            case "home":
                homeTeamScore += thisButton.points;
                if (homeTeamScore <= 0) {
                    homeTeamScore = 0;
                }
                break;
            case "guest":
                guestTeamScore += thisButton.points;
                if (guestTeamScore <= 0) {
                    guestTeamScore = 0;
                }
                break;
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

    public class ScoreButton {
        public String team;
        public int points;
    }
}

