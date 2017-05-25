package com.powersst.triviatrouble;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.powersst.triviatrouble.utils.NetworkUtils;
import com.powersst.triviatrouble.utils.OpenTriviaUtils;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "ON CREATE METHOD");
    }
/*
        doOpenTriviaSearch();
    }

    //Execute Search
    public void doOpenTriviaSearch() {
        Log.d("MainActivity", "doOpenTriviaSearch");

        String qAmount = "10";
        String qCategory = "9";
        String qDifficulty = "easy";
        String qType = "multiple";

        String openTriviaSearchUrl = OpenTriviaUtils.buildTriviaURL(qAmount, qCategory, qDifficulty, qType);
        Log.d("MainActivity", "got search url: " + openTriviaSearchUrl);
        new OpenTriviaSearchTask().execute(openTriviaSearchUrl);
    }


    private class OpenTriviaSearchTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            mLoadingIndicatorPB.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            String openWeatherSearchUrl = params[0];
            String searchResults = null;
            try {
                searchResults = NetworkUtils.doHTTPGet(openWeatherSearchUrl);
                Log.d("Main Activity", "searchResults " + searchResults);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return searchResults;
        }

        @Override
        protected void onPostExecute(String s) {
//            mLoadingIndicatorPB.setVisibility(View.INVISIBLE);
            if (s != null) {
//                mLoadingErrorMessageTV.setVisibility(View.INVISIBLE);
//                mForecastListRV.setVisibility(View.VISIBLE);
                ArrayList<OpenTriviaUtils.TriviaItem> searchResultsList = OpenTriviaUtils.parseTriviaJSON(s);
                Log.d("Main Activity", "Search Results list = " + searchResultsList);
//                mForecastAdapter.updateForecastData(searchResultsList);
            } else {
//                mForecastListRV.setVisibility(View.INVISIBLE);
//                mLoadingErrorMessageTV.setVisibility(View.VISIBLE);
            }
        }
    }
*/
}
