package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero, one, two, three, four, five, six, seven, eight, nine;
    private Button ac, plus_minus, percent, divide, multiply, minus, plus, equal, point;
    TextView textview;
    double operand1, operand2;
    double result;
    boolean flagPoint = false, flagEqual = false;
    boolean add, sub, div, mul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        point = (Button) findViewById(R.id.point);
        ac = (Button) findViewById(R.id.ac);
        plus_minus = (Button) findViewById(R.id.plus_minus);
        percent = (Button) findViewById(R.id.percent);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);
        equal = (Button) findViewById(R.id.equal);
        textview = (TextView) findViewById(R.id.textview);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagEqual) {
                    textview.setText("");
                    flagEqual = false;
                }
                textview.append("9");
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flagPoint) {
                    if (textview.getText() == "") {
                        textview.setText("0.");
                        flagPoint = true;
                    } else {
                        textview.setText(textview.getText() + ".");
                        flagPoint = true;
                    }
                }
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText("");
                operand1 = 0;
                operand2 = 0;
                result = 0;
                flagPoint = false;
                flagEqual = false;
            }
        });

        plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textview.getText() == "") {
                    textview.setText("");
                } else {
                    operand1 = Double.parseDouble(textview.getText() + "");
                    textview.setText(operand1 * (-1) + "");
                }
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textview.getText() == "") {
                    textview.setText("");
                } else {
                    operand1 = Double.parseDouble(textview.getText() + "");
                    textview.setText(operand1 / 100 + "");
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textview.getText() == "") {
                    textview.setText("");
                } else {
                    operand1 = Double.parseDouble(textview.getText() + "");
                    div = true;
                    textview.setText(null);
                }
                flagPoint = false;
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textview.getText() == "") {
                    textview.setText("");
                } else {
                    operand1 = Double.parseDouble(textview.getText() + "");
                    mul = true;
                    textview.setText(null);
                }
                flagPoint = false;
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textview.getText() == "") {
                    textview.setText("");
                } else {
                    operand1 = Double.parseDouble(textview.getText() + "");
                    sub = true;
                    textview.setText(null);
                }
                flagPoint = false;
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textview.getText() == "") {
                    textview.setText("");
                } else {
                    operand1 = Double.parseDouble(textview.getText() + "");
                    add = true;
                    textview.setText(null);
                }
                flagPoint = false;
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textview.getText() == "") {
                    textview.setText("");
                } else {
                    flagEqual = true;
                    operand2 = Double.parseDouble(textview.getText() + "");
                    if (add) {
                        textview.setText(operand1 + operand2 + "");
                        add = false;
                    }
                    if (sub) {
                        textview.setText(operand1 - operand2 + "");
                        sub = false;
                    }
                    if (mul) {
                        textview.setText(operand1 * operand2 + "");
                        mul = false;
                    }
                    if (div) {
                        if (operand2 == 0) {
                            textview.setText("Error");
                        } else {
                            textview.setText(operand1 / operand2 + "");
                            div = false;
                        }
                    }
                }
            }
        });
    }
}

