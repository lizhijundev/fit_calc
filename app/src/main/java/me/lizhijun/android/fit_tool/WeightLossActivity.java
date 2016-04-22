package me.lizhijun.android.fit_tool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

public class WeightLossActivity extends AppCompatActivity {
    private SeekBar sb_rlcz;
    private TextView tv_rlcz,tv_heat_rs;
    private EditText edit_weight,edit_goal_weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss);

        sb_rlcz = (SeekBar) findViewById(R.id.sb_rlcz);
        tv_rlcz = (TextView) findViewById(R.id.tv_rlcz);
        tv_heat_rs = (TextView) findViewById(R.id.tv_heat_rs);
        edit_weight = (EditText) findViewById(R.id.edit_weight);
        edit_goal_weight = (EditText) findViewById(R.id.edit_goal_weight);

        sb_rlcz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress==0){
                    progress = 1;
                }
                tv_rlcz.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcWeightLoss(View view){
        if(edit_weight.getText().toString().trim().equals("")){
            edit_weight.setError(getResources().getString(R.string.hint_weight));
            return;
        }
        if(edit_goal_weight.getText().toString().trim().equals("")){
            edit_goal_weight.setError(getResources().getString(R.string.hint_gold_weight));
            return;
        }
        double weight = Double.valueOf(edit_weight.getText().toString().trim()) / 2.0;
        double goal_weight = Double.valueOf(edit_goal_weight.getText().toString().trim()) / 2.0;
        int cal_def = Integer.valueOf(tv_rlcz.getText().toString());

        double toLose = weight - goal_weight;

        //每减少1斤需要3500卡路里热量计算
        int days = (int) ((toLose * 3500) / cal_def);
        double weekAmount = toLose / ((toLose * 3500) / cal_def / 7);

        String rsMessage = String.format(getResources().getString(R.string.lose_weight_rs),
                (toLose * 2),
                (weekAmount * 2),
                calcDate(days)
                );

        tv_heat_rs.setText(rsMessage);
    }

    /**
     * 计算当前时间往后的几天的日期
     * @param day 往后的天数
     * @return
     */
    private String calcDate(int day){
        Calendar c = Calendar.getInstance();
        int date = c.get(Calendar.DAY_OF_MONTH) + day;
        c.set(Calendar.DAY_OF_MONTH, date);
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        String strForwardDate = String.format(getResources().getString(R.string.date_formate),mYear,(mMonth + 1),mDay);
        return strForwardDate;

    }


}
