package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.londonappbrewery.destini.R.id.buttonTop;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mStoryView;
    int playerPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null){
            playerPosition = savedInstanceState.getInt("PlayerPosition");

        } else {
            playerPosition = 1;
        }





        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mStoryView = (TextView) findViewById(R.id.storyTextView);



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (playerPosition == 1) {
                    //if the story has just started and the top button is pressed, set all text to t3 options and playerPosition to t3.
                    mStoryView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    playerPosition = playerPosition + 2;
                } else if (playerPosition == 2) {
                    //if the player is on t2 and the top button is pressed, set all text to t3 options and playerPosition to t3.
                    mStoryView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    playerPosition++;
                } else if (playerPosition == 3) {
                    //If the player is on t3 and the top button is pressed, set the story text to the t6 end option and hide the bottom button
                    mStoryView.setText(R.string.T6_End);
                    mButtonBottom.setVisibility(View.GONE);

                    //sets the top button to a restart button
                    mButtonTop.setText(R.string.Restart_Button);

                    //sets position to the arbitrary 'end of game' value
                    playerPosition = 46;
                } else if (playerPosition == 44) {
                    //if the t4 end has been reached and the top (reset) button is pressed, the game will reset.
                    finish();
                    startActivity(getIntent());
                } else if (playerPosition == 45) {
                    //if the t5 end has been reached and the top (reset) button is pressed, the game will reset.
                    finish();
                    startActivity(getIntent());
                } else if (playerPosition == 46) {
                    //if the t6 end has been reached and the top (reset) button is pressed, the game will reset.
                    finish();
                    startActivity(getIntent());
                }

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (playerPosition == 1) {
                    //if the story has just started and the bottom button is pressed, set the text to t2 options and the playerPosition to t2.
                    mStoryView.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText((R.string.T2_Ans2));
                    playerPosition++;
                } else if (playerPosition == 2) {
                    //if the player is on t2 and the bottom button is pressed, set the text to t4 end option and hide the bottom button.
                    mStoryView.setText(R.string.T4_End);
                    mButtonBottom.setVisibility(View.GONE);

                    //sets the top button to a restart button
                    mButtonTop.setText(R.string.Restart_Button);

                    //sets position to the arbitrary 'end of game' value
                    playerPosition = 44;
                } else if (playerPosition == 3) {
                    //if the player is on t3 and the bottom button is pressed, set text to t5 end option and hide the bottom button.
                    mStoryView.setText(R.string.T5_End);
                    mButtonBottom.setVisibility(View.GONE);

                    //sets the top button to a restart button
                    mButtonTop.setText(R.string.Restart_Button);

                    //sets position to the arbitrary 'end of game' value
                    playerPosition = 45;
                }

            }
        });

        //setting restart states for rotation or application pause
        if (playerPosition == 1) {
            mStoryView.setText(R.string.T1_Story);
            mButtonTop.setText(R.string.T1_Ans1);
            mButtonBottom.setText(R.string.T1_Ans2);
        } else if (playerPosition == 2) {
            mStoryView.setText(R.string.T2_Story);
            mButtonTop.setText(R.string.T2_Ans1);
            mButtonBottom.setText(R.string.T2_Ans2);
        } else if (playerPosition == 3) {
            mStoryView.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonBottom.setText(R.string.T3_Ans2);
        } else if (playerPosition == 44){
            mStoryView.setText(R.string.T4_End);
            mButtonTop.setText(R.string.Restart_Button);
            mButtonBottom.setVisibility(View.GONE);
        } else if (playerPosition == 45){
            mStoryView.setText(R.string.T5_End);
            mButtonTop.setText(R.string.Restart_Button);
            mButtonBottom.setVisibility(View.GONE);
        } else if (playerPosition == 46){
            mStoryView.setText(R.string.T6_End);
            mButtonTop.setText(R.string.Restart_Button);
            mButtonBottom.setVisibility(View.GONE);
        }



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("PlayerPosition", playerPosition);


    }


}



