package com.example.ch07_dialogask;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

// Alert 交談窗中最多可以加入 3 個按鈕, 分別代表否(Negative), 中性(Neutral), 及是(Positive)
// 加入的方法則為 setXxxButton(), 
// 以上方法的第二個參數必須傳入實作 DialogInterface.OnClickListener 介面的物件, 
// 以做為按下該按鈕時的 onClick 監聽器. 若為 null 表示不處理這個按鈕事件.

// 要讓 MainActivity 監聽交談窗中按鈕的事件, 
// 就要先讓 MainActivity 實作 DialogInterface.OnClickListener 介面:

public class MainActivity extends ActionBarActivity 
		implements DialogInterface.OnClickListener {	// 實作監聽介面

	TextView txv;		// 記錄預設的 TextView 元件
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.answer);		// 找出預設的 TextView
        
        new AlertDialog.Builder(this)			// 建立 Builder 物件
        	.setMessage("你喜歡Android手機嗎?")		// 設定顯示訊息
        	.setCancelable(false)				// 禁用返回鍵關閉交談窗
        	.setIcon(android.R.drawable.ic_menu_edit)	// 採用內建的圖示
        	.setTitle("Android 問卷調查")			// 設定交談窗的標題
        	.setPositiveButton("喜歡", this)		// 加入肯定按鈕並監聽事件
        	.setNegativeButton("討厭", this)		// 加入否定按鈕並監聽事件
        	.setNeutralButton("沒意見", null)		// 不監聽中性按鈕
        	.show();							// 顯示交談窗
        
    }
    
    @Override
    public void onClick(DialogInterface dialog, int id) {	// 實作監聽介面定義的方法
    	
    	if (id == DialogInterface.BUTTON_POSITIVE) {	// 如果按下肯定的[喜歡]
    		
    		txv.setText("你喜歡Android手機");
    	}
    	else if (id == DialogInterface.BUTTON_NEGATIVE) {	// 如果按下否定的[討厭]
    		
    		txv.setText("你討厭Android手機");
    	}
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
