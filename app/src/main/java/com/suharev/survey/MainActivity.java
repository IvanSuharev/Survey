package com.suharev.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainMenu, question1, question2, result;
    Button buttonMenu, buttonQuestion1, buttonQuestion2;
    RadioButton radio1, radio2, radio3, radio4;
    CheckBox check1, check2, check3, check4, check5, check6;
    TextView totalText;
    StringBuilder total;
    int scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        setOnClickListeners();

    }
    private void initialization() {
        total = new StringBuilder();
        total.append("Наименование\t Правильный ответ\t Баллы\n");
        totalText = (TextView) findViewById(R.id.total);
        initLayout();
        initRadioButton();
        initCheckBox();
        initButton();
    }
    private void initRadioButton() {
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);
        radio4 = (RadioButton) findViewById(R.id.radio4);
    }
    private void initLayout(){
        mainMenu = (LinearLayout) findViewById(R.id.main_menu);
        question1 = (LinearLayout) findViewById(R.id.question1);
        question2 = (LinearLayout) findViewById(R.id.question2);
        result = (LinearLayout) findViewById(R.id.result);
    }
    private void initButton(){
        buttonMenu = (Button) findViewById(R.id.buttonMenu);
        buttonQuestion1 = (Button) findViewById(R.id.button_question1);
        buttonQuestion2 = (Button) findViewById(R.id.button_question2);
    }
    private void initCheckBox(){
        check1 = (CheckBox) findViewById(R.id.check1);
        check2 = (CheckBox) findViewById(R.id.check2);
        check3 = (CheckBox) findViewById(R.id.check3);
        check4 = (CheckBox) findViewById(R.id.check4);
        check5 = (CheckBox) findViewById(R.id.check5);
        check6 = (CheckBox) findViewById(R.id.check6);
    }
    private void swapLayout(View view1, View view2) {
        view1.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.VISIBLE);
    }
    private void setOnClickListeners(){
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapLayout(mainMenu, question1);
            }
        });
        buttonQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapLayout(question1, question2);
                if (radio1.isChecked()) {
                    scores++;
                    total.append("Вопрос 1\t Java \t 1\n");
                } else {
                    total.append("Вопрос 1\t Java \t 0\n");
                }
            }
        });
        buttonQuestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapLayout(question2, result);
                if (check1.isChecked() && check4.isChecked()) {
                    scores++;
                    total.append("Вопрос 2\t Java & c++ \t 1\n");
                } else {
                    total.append("Вопрос 2\t Java & c++ \t 0\n");
                }
                total.append(("Общий балл " + scores));
                totalText.setText(total.toString());
            }
        });
    }
}