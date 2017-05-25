package com.powersst.triviatrouble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

/**
 * Created by Makiah Merritt on 5/25/2017.
 */

public class GameSetupActivity extends AppCompatActivity {
    // MEMBERS
    private Bundle mSavedInstanceState;
    private Spinner mSpnQuestionCount;
    private Spinner mSpnQuestionCategory;
    private Spinner mSpnQuestionDifficulty;
    private Spinner mSpnQuestionType;
    private ProgressBar mPbLoading;
    private Button mBtnBegin;

    // METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);

        // Capture member references
        mSavedInstanceState = savedInstanceState;
        mSpnQuestionCount = (Spinner)findViewById(R.id.spn_questionCount);
        mSpnQuestionCategory = (Spinner)findViewById(R.id.spn_questionCategory);
        mSpnQuestionDifficulty = (Spinner)findViewById(R.id.spn_questionDifficulty);
        mSpnQuestionType = (Spinner)findViewById(R.id.spn_questionType);

        initializeOptions();
    }

    /**
     * Loads the previous options the player has chosen.
     *
     * @author  firstPersonToWriteIt
     */
    private void initializeOptions() {
        // Load players previous
    }
}
