package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    Button divideBTN,exponentBTN,multiplyBTN,subtractBTN,addBTN,equalsBTN;

    private EditText display;

    double x,y;
    char flag ='z';


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        divideBTN=findViewById(R.id.divideBTN);
        exponentBTN=findViewById(R.id.exponentBTN);
        multiplyBTN=findViewById(R.id.multiplyBTN);
        subtractBTN=findViewById(R.id.subtractBTN);
        addBTN=findViewById(R.id.addBTN);
        equalsBTN=findViewById(R.id.equalsBTN);


        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

        divideBTN.setOnClickListener(v-> {
            try {
                x=Double.valueOf(display.getText().toString());
                display.setText(null);
                flag='/';

            } catch (Exception e) {

            }
        });


        exponentBTN.setOnClickListener(v->{try {
            x=Double.valueOf(display.getText().toString());
            display.setText(null);
            flag='^';

        } catch (Exception e) {

        }
        });
        multiplyBTN.setOnClickListener(v->{try {
            x=Double.valueOf(display.getText().toString());
            display.setText(null);
            flag='*';

        } catch (Exception e) {

        }
        });
        subtractBTN.setOnClickListener(v->{try {
            x=Double.valueOf(display.getText().toString());
            display.setText(null);
            flag='-';

        } catch (Exception e) {

        }
        });
        addBTN.setOnClickListener(v->{try {
            x=Double.valueOf(display.getText().toString());
            display.setText(null);
            flag='+';

        } catch (Exception e) {

        }
        });


        equalsBTN.setOnClickListener(v->{
            try{
                double result=0;
                y=Double.valueOf(display.getText().toString());
                   switch (flag){
                       case '^':
                            result=Math.pow(x,y);
                            break;
                    case '*':
                            result=x*y;
                           break;
                    case '/':
                            result=x/y;
                           break;
                    case '+':
                            result=x+y;
                           break;
                    case '-':
                            result=x-y;
                           break;
                }
                display.setText(String.valueOf(result));


            }
            catch (Exception e){
                e.printStackTrace();
            }
        });


    }

    private void updateText(String strToAdd){

        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos + 1);

        }
    }


    /**
     * Zero btn.
     *
     * @param view the view
     */
    public void zeroBtn(View view){
        updateText("0");
    }

    /**
     * One btn.
     *
     * @param view the view
     */
    public void oneBtn(View view){
        updateText("1");
    }

    /**
     * Two btn.
     *
     * @param view the view
     */
    public void twoBtn(View view){
        updateText("2");
    }

    /**
     * Three btn.
     *
     * @param view the view
     */
    public void threeBtn(View view){
        updateText("3");
    }

    /**
     * Four btn.
     *
     * @param view the view
     */
    public void fourBtn(View view){
        updateText("4");
    }

    /**
     * Five btn.
     *
     * @param view the view
     */
    public void fiveBtn(View view){
        updateText("5");
    }

    /**
     * Six btn.
     *
     * @param view the view
     */
    public void sixBtn(View view){
        updateText("6");
    }

    /**
     * Seven btn.
     *
     * @param view the view
     */
    public void sevenBtn(View view){
        updateText("7");
    }

    /**
     * Eight btn.
     *
     * @param view the view
     */
    public void eightBtn(View view){
        updateText("8");
    }

    /**
     * Nine btn.
     *
     * @param view the view
     */
    public void nineBtn(View view){
        updateText("9");
    }


}