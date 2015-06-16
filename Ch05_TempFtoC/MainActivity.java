package com.example.ch05_tempftoc;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
	implements OnCheckedChangeListener, TextWatcher {
	
	RadioGroup unit;		// 單選鈕群組欄位
	EditText value;			// 使用者輸入的溫度值欄位

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        unit = (RadioGroup)findViewById(R.id.unit);		// 取得單選鈕群組 																				
        unit.setOnCheckedChangeListener(this);			// 設定 this 為監聽器
        
        value = (EditText)findViewById(R.id.value);		// 取得輸入欄位
        value.addTextChangedListener(this);				// 設定 this 為監聽器
    }

    public void afterTextChanged(Editable arg0) {
    	calc();
    }
    
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, 
    		int arg3) {
    	// TextWatcher 介面的方法, 此處不會用到
    }
    
    public void onTextChanged(CharSequence arg0, int arg1, int arg2, 
    		int arg3) {
    	// TextWatcher 介面的方法, 此處不會用到
    }
    
    public void onCheckedChanged(RadioGroup arg0, int arg1) {
    	calc();
    }
    
    protected void calc() {
    	// 取得文字方塊
    	TextView degF = (TextView)findViewById(R.id.degF);
    	TextView degC = (TextView)findViewById(R.id.degC);
    	
    	double f = 0, c = 0;		// 儲存溫度值換算結果
    	
    	if (unit.getCheckedRadioButtonId() == R.id.unitF) {
    		// 若選擇輸入華氏溫度
    		
    		// 修正在這裡
    		try {
    			f = Double.parseDouble(value.getText().toString());
    		} catch (NumberFormatException e) {
    			f = 0;
    		}
    		
    		c = (f - 32) * 5 / 9;		// 華氏 => 攝氏
    	} else {						// 若選擇輸入攝氏溫度
    		
    		// 修正在這裡
    		try {
    			c = Double.parseDouble(value.getText().toString());
    		} catch (NumberFormatException e) {
    			c = 0;
    		}
    		
    		f = c * 9 / 5 + 32;			// 攝氏 => 華氏
    	}
    	
    	degC.setText(String.format("%.1f", c) + 
    			getResources().getString(R.string.charC));
    	// 只顯示到小數點後 1 位
    	// 從字串資源載入 .C 符號
    	
    	degF.setText(String.format("%.1f", f) + 
    			getResources().getString(R.string.charF));
    	// 只顯示到小數點後 1 位
    	// 從字串資源載入 .F 符號
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
