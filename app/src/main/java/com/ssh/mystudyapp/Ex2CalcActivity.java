package com.ssh.mystudyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex2CalcActivity extends AppCompatActivity {
    ImageView ivNum1, ivNum2, ivNum3, ivNum4, ivNum5, ivNum6, ivNum7, ivNum8,
            ivNum9, ivNum0, ivPlu, ivMin, ivMul, ivDiv, ivClear, ivResult;

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnMin, btnMul, btnDiv, btnC, btnResult;
    EditText etResult;

    int number[] = new int[10];//계산용 수를 저장하기위한배열
    int idx = 0;//누른 순서를 카운팅 하기위한 변수
    int idxYon = 0;//연속연산을 위한 연산 구분자
    int iNum;//현재숫자
    String strNum = "";//표시용 현재숫자

    String yon[] = new String[9];//+ - * / 구분용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_calc);
        //id연동
        etResult = (EditText) findViewById(R.id.etResult);


        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMin = (Button) findViewById(R.id.btnMin);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnC = (Button) findViewById(R.id.btnC);

        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult = (Button) findViewById(R.id.btnResult);
        this.SetListener();
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn0:
                        strNum += "0";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn1:
                        strNum += "1";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn2:
                        strNum += "2";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn3:
                        strNum += "3";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn4:
                        strNum += "4";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn5:
                        strNum += "5";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn6:
                        strNum += "6";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn7:
                        strNum += "7";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn8:
                        strNum += "8";
                        etResult.setText(strNum);
                        break;
                    case R.id.btn9:
                        strNum += "9";
                        etResult.setText(strNum);
                        break;
                    case R.id.btnAdd:
                        yon[idxYon] = "+";
                        etResult.setText("");
                        iNum = Integer.parseInt(strNum);
                        calcProc(idx, iNum, "+");
                        idx++;//터치하자마자 증가.다음수지정...
                        idxYon++;//연속연산시 처리하기위해서..
                        break;
                    case R.id.btnMin:
                        yon[idxYon] = "-";
                        etResult.setText("");
                        iNum = Integer.parseInt(strNum);
                        calcProc(idx, iNum, "-");
                        idx++;//터치하자마자 증가.다음수지정...
                        idxYon++;//연속연산시 처리하기위해서..
                        break;
                    case R.id.btnMul:
                        yon[idxYon] = "*";
                        etResult.setText("");
                        iNum = Integer.parseInt(strNum);
                        calcProc(idx, iNum, "*");
                        idx++;//터치하자마자 증가.다음수지정...
                        idxYon++;//연속연산시 처리하기위해서..
                        break;
                    case R.id.btnDiv:
                        yon[idxYon] = "/";
                        etResult.setText("");
                        iNum = Integer.parseInt(strNum);
                        calcProc(idx, iNum, "/");
                        idx++;//터치하자마자 증가.다음수지정...
                        idxYon++;//연속연산시 처리하기위해서..
                        break;
                    case R.id.btnResult:
                        ;
                        etResult.setText("");
                        iNum = Integer.parseInt(strNum);
                        calcProc(idx, iNum, "=");
                        break;
                    case R.id.btnC:
                        ;
                        etResult.setText("");
                        strNum = "";
                        for (int i = 0; i < number.length; i++) {
                            number[i] = 0;
                        }
                        for (int i = 0; i < yon.length; i++) {
                            yon[i] = "";
                        }
                        idx = 0;
                        idxYon = 0;
                        break;
                }

            }
        };

        btn0.setOnClickListener(Listener);
        btn1.setOnClickListener(Listener);
        btn2.setOnClickListener(Listener);
        btn3.setOnClickListener(Listener);
        btn4.setOnClickListener(Listener);
        btn5.setOnClickListener(Listener);
        btn6.setOnClickListener(Listener);
        btn7.setOnClickListener(Listener);
        btn8.setOnClickListener(Listener);
        btn9.setOnClickListener(Listener);
        btnAdd.setOnClickListener(Listener);
        btnMin.setOnClickListener(Listener);
        btnMul.setOnClickListener(Listener);
        btnDiv.setOnClickListener(Listener);
        btnResult.setOnClickListener(Listener);
        btnC.setOnClickListener(Listener);
    }

    void calcProc(int idx, int num, String gubun) {
        number[idx] = num;
        //보여지는 문자열변수초기화
        strNum = "";
        if (gubun.equals("=")) {
            int result = 0;//결과값
            int cnt = 0;
            for (int i = 0; i < idx; i++) {
                if (yon[cnt].equals("+")) {
                    number[0] += number[i + 1];
                } else if (yon[cnt].equals("-")) {
                    number[0] -= number[i + 1];
                }
                if (yon[cnt].equals("*")) {
                    number[0] *= number[i + 1];
                }
                if (yon[cnt].equals("/")) {
                    number[0] /= number[i + 1];
                }
                cnt++;
            }

            etResult.setText(number[0] + "");
        }
    }
}