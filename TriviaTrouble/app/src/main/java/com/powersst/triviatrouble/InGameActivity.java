package com.powersst.triviatrouble;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 5/30/2017.
 */

public class InGameActivity extends AppCompatActivity {

    private TextView mQuestionTV;
    private Button mBtnOptOne;
    private Button mBtnOptTwo;
    private Button mBtnOptThree;
    private Button mBtnOptFour;
    private Button mBtnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        mQuestionTV = (TextView)findViewById(R.layout.questionTV);
        mBtnOptOne = (Button)findViewById(R.layout.optionOneBtn);
        mBtnOptTwo = (Button)findViewById(R.layout.optionTwoBtn);
        mBtnOptThree = (Button)findViewById(R.layout.optionThreeBtn);
        mBtnOptFour = (Button)findViewById(R.layout.optionFourBtn);
        mBtnSubmit = (Button)findViewById(R.layout.submitBtn);

        Intent intent = getIntent();


    }


//need onCreate
    //--pull content from intent
    //--create recycler items for each question
    //---randomize correct and incorrect answers
    //set questions and answers
    //create onClickListener
    //show correct answers
    //recreate activity with new question, save results of previous

}
