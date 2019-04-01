package me.yuruekis.binaryfulladder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Switch switchBD;

    private EditText inputOne;

    private EditText inputTwo;

    private Button buttonCalc;

    private TextView indicatorBD;

    private int isBinaryOrDecimal = 0; // 1 代表二进制模式，2 代表十进制模式

    private TextView resultText;

    private TextView inputOneBinary;

    private TextView inputTwoBinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resultText = (TextView) findViewById(R.id.result);

        inputOne = (EditText) findViewById(R.id.input_1);
        inputTwo = (EditText) findViewById(R.id.input_2);


        buttonCalc = (Button) findViewById(R.id.button_calc);
        indicatorBD = (TextView) findViewById(R.id.indicator_BD);
        switchBD = (Switch) findViewById(R.id.switch_BD);


        switchBD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == false) {
                    isBinaryOrDecimal = 1;
                    switchBD.setText("当前为二进制操作模式");
                } else if (isChecked == true) {
                    isBinaryOrDecimal = 2;
                    switchBD.setText("当前为十进制操作模式");
                }
            }
        });

        buttonCalc.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //inputOne.getText().toString();
        int inputOneInt = Integer.parseInt(inputOne.getText().toString());
        int inputTwoInt = Integer.parseInt(inputTwo.getText().toString());

        int [] result = new int[33];

        int [] tempResult = new int[32];

        result = BinaryFullAdderProgram.BinaryAdder(isBinaryOrDecimal, inputOneInt, inputTwoInt);
        int j = 0;
        for (int i = 32; i >= 0; i--) {
            tempResult[j] = result[i];
            j++;
        }
        String resultString = tempResult.toString();

        resultText.setText(resultString);

    }
}
