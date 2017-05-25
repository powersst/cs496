package com.powersst.triviatrouble;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.powersst.triviatrouble.utils.NetworkUtils;
import com.powersst.triviatrouble.utils.OpenTriviaUtils;

import java.io.IOException;
import java.util.ArrayList;

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
        mSpnQuestionCount = (Spinner)findViewById(R.id.spn_GameSetup_QuestionCount);
        mSpnQuestionCategory = (Spinner)findViewById(R.id.spn_GameSetup_QuestionCategory);
        mSpnQuestionDifficulty = (Spinner)findViewById(R.id.spn_GameSetup_QuestionDifficulty);
        mSpnQuestionType = (Spinner)findViewById(R.id.spn_GameSetup_QuestionType);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_GameSetup_Loading);
        mBtnBegin = (Button) findViewById(R.id.btn_GameSetup_Begin);

        initializeActivityElements();
    }

    /**
     * Prepares the dropdown elements and loads the previous options the player
     * has chosen.
     *
     * Notes: ref[https://developer.android.com/guide/topics/ui/controls/spinner.html]
     *
     * @author  firstPersonToWriteIt
     */
    private void initializeActivityElements() {
        ArrayAdapter<CharSequence> adapter = null;

        //==== Load spinners ====
        // Load Question Count
        adapter = ArrayAdapter.createFromResource(this, R.array.gameSetup_QuestionCount_Entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnQuestionCount.setAdapter(adapter);

        // Load Question Categories
        adapter = ArrayAdapter.createFromResource(this, R.array.gameSetup_QuestionCategory_Entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnQuestionCategory.setAdapter(adapter);

        // Load Question Difficulties
        adapter = ArrayAdapter.createFromResource(this, R.array.gameSetup_QuestionDifficulty_Entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnQuestionDifficulty.setAdapter(adapter);

        // Load Question Types
        adapter = ArrayAdapter.createFromResource(this, R.array.gameSetup_QuestionType_Entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnQuestionType.setAdapter(adapter);

        //==== Load players previous selections ====
        // tba

        //==== Enable start button ====
        mBtnBegin.setVisibility(View.VISIBLE);
        mBtnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenTriviaSearch();
            }
        });
    }


    //Execute Search
    public void doOpenTriviaSearch() {
        Log.d("GameSetupActivity", "doOpenTriviaSearch");

        String qAmount = "10";
        String qCategory = "9";
        String qDifficulty = "easy";
        String qType = "multiple";

        String openTriviaSearchUrl = OpenTriviaUtils.buildTriviaURL(qAmount, qCategory, qDifficulty, qType);
        Log.d("GameSetupActivity", "got search url: " + openTriviaSearchUrl);
        new OpenTriviaSearchTask().execute(openTriviaSearchUrl);
    }


    private class OpenTriviaSearchTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mPbLoading.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            String openWeatherSearchUrl = params[0];
            String searchResults = null;
            try {
                searchResults = NetworkUtils.doHTTPGet(openWeatherSearchUrl);
                Log.d("GameSetupActivity", "searchResults " + searchResults);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return searchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            mPbLoading.setVisibility(View.INVISIBLE);
            if (s != null) {
//                mLoadingErrorMessageTV.setVisibility(View.INVISIBLE);
//                mForecastListRV.setVisibility(View.VISIBLE);
                ArrayList<OpenTriviaUtils.TriviaItem> searchResultsList = OpenTriviaUtils.parseTriviaJSON(s);
                Log.d("GameSetupActivity", "Search Results list = " + searchResultsList);
//                mForecastAdapter.updateForecastData(searchResultsList);
            } else {
//                mForecastListRV.setVisibility(View.INVISIBLE);
//                mLoadingErrorMessageTV.setVisibility(View.VISIBLE);
            }
        }
    }
}
