package cn.studyjamscn.s1.sj32.lizhijun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class HeatActivity extends AppCompatActivity {

    private TextView tv_heat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat);
        tv_heat = (TextView) findViewById(R.id.tv_heat);
    }

    public void calcHeat(View view){
        EditText et_weight = (EditText) findViewById(R.id.edit_heat_weight);
        RadioButton rd_age1 = (RadioButton) findViewById(R.id.rd_age1);
        RadioButton rd_age2 = (RadioButton) findViewById(R.id.rd_age2);
        if(et_weight.getText().toString().trim().equals("")){
            et_weight.setError(getResources().getString(R.string.hint_bmi_weight));
            tv_heat.setText("");
            return;
        }
        double weight = Double.valueOf(et_weight.getText().toString().trim());
        boolean age1 = rd_age1.isChecked();
        boolean age2 = rd_age2.isChecked();

        Log.d("HeatActivity", "weight:" + weight + ",age1:" + age1 + ",age2:" + age2);
        calc(weight,age1,age2);
    }

    public void calc(double weight,boolean age1,boolean age2){
        String heat = "";
        if (age1){
            double k = (weight*0.062+2.036)*240;
            heat += String.format(getResources().getString(R.string.everyday_heat_consumption),k,k-500);
        }
        if (age2){
            double k = (weight*0.034+3.538)*240;
            heat += String.format(getResources().getString(R.string.everyday_heat_consumption),k,k-500);;
        }
        tv_heat.setText(heat);
    }
}
