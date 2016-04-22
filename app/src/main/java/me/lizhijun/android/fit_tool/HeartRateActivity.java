package me.lizhijun.android.fit_tool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HeartRateActivity extends AppCompatActivity {
    private TextView tv_heart_rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);
        tv_heart_rate = (TextView) findViewById(R.id.tv_heart_rate);
    }

    public void calcHeartRate(View view){
        EditText et_age = (EditText) findViewById(R.id.edit_age);
        if(et_age.getText().toString().trim().equals("")){
            et_age.setError(getResources().getString(R.string.tv_input_age));
            tv_heart_rate.setText("");
            return;
        }
        RadioGroup rg_exercise = (RadioGroup) findViewById(R.id.rg_exercise);
        int rd_id = rg_exercise.getCheckedRadioButtonId();
        int age = Integer.parseInt(et_age.getText().toString().trim());

        tv_heart_rate.setText(getResult(age,rd_id));

    }


    public String getResult(int age,int rd_id){
        int heart1 = 0;
        int heart2 = 0;
        int temp = 220 - age;
        if(rd_id == R.id.rd_exercise1){
            heart1 = (int) (temp * 0.4);
            heart2 = (int) (temp * 0.5);
        }
        if(rd_id == R.id.rd_exercise2){
            heart1 = (int) (temp * 0.5);
            heart2 = (int) (temp * 0.6);
        }
        if(rd_id == R.id.rd_exercise3){
            heart1 = (int) (temp * 0.6);
            heart2 = (int) (temp * 0.8);
        }
        if(rd_id == R.id.rd_exercise4){
            heart1 = (int) (temp * 0.7);
            heart2 = (int) (temp * 0.9);
        }

        return String.format(getResources().getString(R.string.exercise_result),heart1,heart2);
    }
}
