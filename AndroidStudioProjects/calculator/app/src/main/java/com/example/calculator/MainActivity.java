package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnMultiple,btnDivide,btnEqual,btnMinus,btnDot,btnClear,btnBracket,btnPercent;
    TextView tvinput,tvoutput;
    String process;
    boolean checkbracket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnAdd=findViewById(R.id.btnAdd);
        btnMultiple=findViewById(R.id.btnMultiply);
        btnDivide=findViewById(R.id.btnDivision);
        btnMinus=findViewById(R.id.btnMinus);

        btnEqual=findViewById(R.id.btnEqual);
        btnPercent=findViewById(R.id.btnPercent);
        btnDot=findViewById(R.id.btnDot);
        btnClear=findViewById(R.id.btnClear);
        btnBracket=findViewById(R.id.btnBracket);

        tvinput=findViewById(R.id.tvInput);
        tvoutput=findViewById(R.id.tvOutput);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvinput.setText("");
                tvoutput.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "9");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "÷");
            }
        });

        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "x");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "-");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "+");
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "%");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + ".");
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbracket)
                {
                    process = tvinput.getText().toString();
                    tvinput.setText(process + ")");
                    checkbracket=false;
                }else {
                    process = tvinput.getText().toString();
                    tvinput.setText(process + "(");
                    checkbracket=true;
                }

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                process = process.replaceAll("x","*");
                process = process.replaceAll("÷","/");
                process = process.replaceAll("%","/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalresult = "";
                try{
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalresult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalresult = "0";
                }
                tvoutput.setText(finalresult);

            }
        });


    }
}