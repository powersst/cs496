package com.powersst.triviatrouble.utils;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by powersst on 5/23/17.
 */

public class OpenTriviaUtils {

    //https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple
    private final static String OPEN_TRIVIA_BASE_URL = "https://opentdb.com/api.php?";
    private final static String OPEN_TRIVIA_AMOUNT_PARAM = "amount";
    private final static String OPEN_TRIVIA_CATEGORY_PARAM = "category";
    private final static String OPEN_TRIVIA_DIFFICULTY_PARAM = "difficulty";
    private final static String OPEN_TRIVIA_TYPE_PARAM = "type";


    private final static String qAmount = "10";
    private final static String qCategory = "9";
    private final static String qDifficulty = "easy";
    private final static String qType = "multiple";



//        "category": "General Knowledge",
//                "type": "multiple",
//                "difficulty": "easy",
//                "question": "Virgin Trains, Virgin Atlantic and Virgin Racing, are all companies owned by which famous entrepreneur?   ",
//                "correct_answer": "Richard Branson",
//                "incorrect_answers": [
//                "Alan Sugar",
//                "Donald Trump",
//                "Bill Gates"
//                ]

    public static class TriviaItem implements Serializable {
        public static final String EXTRA_TRIVIA_ITEM = "com.powersst.triviatrouble.utils.TriviaItem.SearchResult";
        public String category;
        public String type;
        public String difficulty;
        public String question;
        public String correct_answer;
        public String[] incorrect_answers;
    }

    public static String buildTriviaURL(String qAmount, String qCategory, String qDifficulty, String qType) {
        return Uri.parse(OPEN_TRIVIA_BASE_URL).buildUpon()
                .appendQueryParameter(OPEN_TRIVIA_AMOUNT_PARAM, qAmount)
                .appendQueryParameter(OPEN_TRIVIA_CATEGORY_PARAM, qCategory)
                .appendQueryParameter(OPEN_TRIVIA_DIFFICULTY_PARAM, qDifficulty)
                .appendQueryParameter(OPEN_TRIVIA_TYPE_PARAM, qType)
                .build()
                .toString();
    }

    public static ArrayList<TriviaItem> parseTriviaJSON(String triviaJSON) {
        try {
            JSONObject triviaObj = new JSONObject(triviaJSON);
            JSONArray triviaList = triviaObj.getJSONArray("results");

            ArrayList<TriviaItem> triviaItemsList = new ArrayList<TriviaItem>();
            for (int i = 0; i < triviaList.length(); i++) {
                TriviaItem triviaItem = new TriviaItem();
                JSONObject triviaListElem = triviaList.getJSONObject(i);

                triviaItem.category = triviaListElem.getString("category");
                triviaItem.type = triviaListElem.getString("type");
                triviaItem.difficulty = triviaListElem.getString("difficulty");
                triviaItem.question = triviaListElem.getString("question");
                triviaItem.correct_answer = triviaListElem.getString("correct_answer");

                JSONArray triviaIncorrect = triviaListElem.getJSONArray("incorrect_answers");

                for (int j = 0; i < triviaIncorrect.length(); j++) {
                    triviaItem.incorrect_answers[j] = triviaIncorrect.getString(j);
                }

                triviaItemsList.add(triviaItem);
            }
            return triviaItemsList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
