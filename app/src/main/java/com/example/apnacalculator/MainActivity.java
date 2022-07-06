package com.example.apnacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    private TextView txtv;
    private TextView result;
    private TextView expression;
    private ImageView reset;
    private TextView zero;
    private TextView point;
    private TextView equal;
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView divide;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView minus;
    private TextView ac;
    private TextView mod;
    private TextView plus;
    private ImageView back;
    private TextView multiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.result);
        expression=findViewById(R.id.expression);
        reset=findViewById(R.id.reset);
        zero=findViewById(R.id.zero);
        point=findViewById(R.id.point);
        equal=findViewById(R.id.equal);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        divide=findViewById(R.id.divide);
        multiply=findViewById(R.id.multiply);
        minus=findViewById(R.id.minus);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        ac=findViewById(R.id.ac);
        back=findViewById(R.id.back);
        mod=findViewById(R.id.mod);
        plus=findViewById(R.id.plus);
        txtv=findViewById(R.id.textView);
//        txtv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Thanks For Using !!", Toast.LENGTH_SHORT).show();
//            }
//        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("1",true);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("0",true);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("2",true);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("3",true);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("4",true);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("5",true);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("6",true);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("7",true);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("8",true);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("9",true);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("+",false);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("-",false);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("*",false);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("/",false);
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("%",false);
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText(".",true);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                    Expression expr= new ExpressionBuilder(expression.getText().toString()).build();
                    double answer=expr.evaluate();
                    result.setText(" "+answer);
               }
               catch (Exception e){
                    result.setText(e.getMessage());
               }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    result.setHint(" ");
                    result.setText(" ");
                    if (expression.getText() != " ") {
                        String txt = expression.getText().toString();
                        expression.setText(txt.substring(0, txt.length() - 1));
                    }
                }
                catch (Exception e){

                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setHint(" ");
                result.setText(" ");
                expression.setText(" ");
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                result.setText(" ");
                result.setHint(" ");
                double  x=Double.parseDouble(expression.getText().toString());
                x= -x;
                expression.setText(""+x);
                }
                catch (Exception e){
                    result.setText(e.getMessage());
                }
            }
        });

    }
    void appendText(String value,boolean istrue){
        if(result.getText()!=" "){
            expression.setText(" ");
        }
        if(istrue){
            result.setText(" ");
            expression.append(value);
        }
        else{
            expression.append(result.getText());
            expression.append(value);
            result.setText(" ");
        }
        result.setHint(expression.getText().toString());
    }

}