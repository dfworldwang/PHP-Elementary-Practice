package com.example.ch06_energycalculator2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
		implements OnItemSelectedListener {

	double[] energyRate = {3.1, 4.4, 13.2, 9.7, 5.1, 3.7};
	EditText weight, time;			// 體重及運動時間欄位
	TextView total, txvRate;		// 顯示能量消耗率, 計算結果的 TextView
	Spinner sports;					// 運動項目清單
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 設定變數初值
        weight = (EditText)findViewById(R.id.weight);
        time = (EditText)findViewById(R.id.timeSpan);
        total = (TextView)findViewById(R.id.total);
        txvRate = (TextView)findViewById(R.id.txvRate);
        sports = (Spinner)findViewById(R.id.sports);
        sports.setOnItemSelectedListener(this);			// 註冊監聽器
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, 
    		int position, long arg3) {
    	// 顯示選取的運動項目的基本能量消耗率
    	txvRate.setText(String.valueOf(energyRate[position]));
    }
    
    public void onNothingSelected(AdapterView<?> arg0) {
    	// 此事件方法不會用到, 但仍需定義一個沒有內容的方法
    }
    
    public void calc(View v) {
    	// 取得使用者輸入的體重
    	double w = Double.parseDouble(weight.getText().toString());
    	// 取得使用者輸入的運動時間長度
    	double t = Double.parseDouble(time.getText().toString());
    	
    	int selected = sports.getSelectedItemPosition();
    	// 取得目前選取項目的索引
    	
    	// 計算消耗能量 = 能量消耗率 * 體重 * 運動時間長度
    	long consumedEnergy = Math.round(energyRate[selected]*w*t);
    	
    	total.setText(String.format("消耗能量\n %d仟卡", consumedEnergy));
    	// 顯示計算結果
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
