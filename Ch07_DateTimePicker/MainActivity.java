package com.example.ch07_datetimepicker;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

// 可以用 DatePickerDialog 及 TimePickerDialog 類別來建立日期, 時間交談窗
// (1) 傳入 this 表示要在 MainActivity 顯示交談窗 
// (2) 由 MainActivity 監聽選取日期(時間)完成時的事件

// 如果是 DatePickerDialog, 監聽物件必須實作 DatePickerDialog.OnDateSetListener 介面中定義的 onDateSet() 方法
// 如果是 TimePickerDialog, 監聽物件必須實作 TimePickerDialog.OnTimeSetListener 介面中定義的 onTimeSet() 方法       

public class MainActivity extends ActionBarActivity 
	implements OnClickListener, DatePickerDialog.OnDateSetListener, 
	TimePickerDialog.OnTimeSetListener {
	// 實作監聽日期交談窗事件的介面
	// 實作監聽時間交談窗事件的介面
	
	Calendar c = Calendar.getInstance();		// 建立日曆物件
	TextView txDate;		// 記錄日期文字的元件
	TextView txTime;		// 記錄時間文字的元件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txDate = (TextView)findViewById(R.id.textView1);	
        // 取得用來顯示日期的 TextView
        txTime = (TextView)findViewById(R.id.textView2);
        // 取得用來顯示時間的 TextView
        
        txDate.setOnClickListener(this);	// 設定按下日期文字時的監聽物件
        txTime.setOnClickListener(this);	// 設定按下時間文字時的監聽物件
    }

    public void onClick(View v) {
    	
    	if (v == txDate) {		// 按的是日期文字
    		// 建立日期選擇交談窗, 並傳入設定完成時的監聽物件
    		new DatePickerDialog(this, this, 		// 由 MainActivity 物件監聽事件
    				c.get(Calendar.YEAR),			// 由 Calendar 物件取得目前的西元年  
    				c.get(Calendar.MONTH),				// 取得目前月 (由 0 算起)
    				c.get(Calendar.DAY_OF_MONTH))		// 取得目前日
    				.show();		// 顯示交談窗
    	}
    	else if (v == txTime) {		// 按的是時間文字
    		// 建立時間選擇交談窗, 並傳入設定完成時的監聽物件
    		new TimePickerDialog(this, this, 			// 由 MainActivity 監聽事件
    				c.get(Calendar.HOUR_OF_DAY),		// 取得目前的時(24小時制)
    				c.get(Calendar.MINUTE),				// 取得目前的分
    				true)								// 使用 24 小時制  
    				.show();						// 顯示交談窗
    		
    	}
    }
    
    @Override
    public void onDateSet(DatePicker v, int y, int m, int d) {	// 選定日期後的處理方法
    	
    	txDate.setText("日期:" + y + "/" + (m+1) + "/" + d);
    	// 將選定日期顯示在螢幕上
    }
    
    @Override
    public void onTimeSet(TimePicker v, int h, int m) {		// 選定時間後的處理方法
    	
    	txTime.setText("時間:" + h + ":" + m);	// 將選定的時間顯示在螢幕上
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
