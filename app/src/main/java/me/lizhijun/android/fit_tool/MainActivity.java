package me.lizhijun.android.fit_tool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openBMI(View view){
        Intent intent = new Intent(this,BMIActivity.class);
        startActivity(intent);
    }

    public void openHeat(View view){
        Intent intent = new Intent(this,HeatActivity.class);
        startActivity(intent);
    }

    public void openWeightLoss(View view){
        Intent intent = new Intent(this,WeightLossActivity.class);
        startActivity(intent);
    }

    public void openHeartRate(View view){
        Intent intent = new Intent(this,HeartRateActivity.class);
        startActivity(intent);
    }

}
