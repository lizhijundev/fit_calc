package cn.studyjamscn.s1.sj32.lizhijun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    private ImageView bmiImg;
    private TextView bmiTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        bmiImg = (ImageView) findViewById(R.id.bmi_imageview);
        bmiTv = (TextView) findViewById(R.id.bmi_textview);

    }


    public void calculateBMI(View v){
        EditText et_weight = (EditText) findViewById(R.id.edit_weight);
        EditText et_height = (EditText) findViewById(R.id.edit_height);

        if(et_weight.getText().toString().trim().equals("")){
            et_weight.setError(getResources().getString(R.string.hint_bmi_weight));
            bmiTv.setText("");
            bmiImg.setImageResource(R.drawable.bmi0);
            return;
        }
        if(et_height.getText().toString().trim().equals("")){
            et_height.setError(getResources().getString(R.string.hint_bmi_height));
            bmiTv.setText("");
            bmiImg.setImageResource(R.drawable.bmi0);
            return;
        }
        double weight = Double.valueOf(et_weight.getText().toString().trim())/2.0;
        double height = Double.valueOf(et_height.getText().toString().trim())/100.0;
        double BMI =  calculateBMI(weight,height);
        displayResult(BMI);
    }

    public double calculateBMI(double weight,double height){
        return weight / ( height * height );
    }

    public void displayResult(double bmi){
        /*
        过轻：低于18.5
        正常：18.5-22.9
        过重：23-24.9
        肥胖：25-29.9
        非常肥胖, 高于30
        * */


        if (bmi<18.5){
            bmiTv.setText(String.format(getResources().getString(R.string.bmi_tip1),bmi));
            bmiImg.setImageResource(R.drawable.bmi1);
        }else if(bmi<23){
            bmiTv.setText(String.format(getResources().getString(R.string.bmi_tip2),bmi));
            bmiImg.setImageResource(R.drawable.bmi2);
        }else if(bmi<25){
            bmiTv.setText(String.format(getResources().getString(R.string.bmi_tip3),bmi));
            bmiImg.setImageResource(R.drawable.bmi3);
        }else if(bmi<30){
            bmiTv.setText(String.format(getResources().getString(R.string.bmi_tip4),bmi));
            bmiImg.setImageResource(R.drawable.bmi4);
        }else{
            bmiTv.setText(String.format(getResources().getString(R.string.bmi_tip5),bmi));
            bmiImg.setImageResource(R.drawable.bmi5);
        }
    }

}
