package com.example.ch04_ezcounterplus2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

// 事件發生的來源, 稱為該事件的來源物件. 如果想要處理這個事件,
// 必須準備一個能處理該事件的監聽物件(或稱為監聽器, Listener), 然後將之登錄到來源物件中,
// Android 已事先為各個常用的物件定義出許多登錄監聽物件的方法. 例如, 
// Button 就定義有 setOnClickListener() 方法, 可以用來登錄(set) [按一下]事件的監聽物件.
// 要處理長按事件, 必須準備一個實作 OnLongClickListener 介面的監聽物件, 
// 並且實作介面定義的 onLongClick() 方法:

// View 類別的物件, 可以使用 getId() 方法取得來源物件的資源 ID, 藉由資源 ID 就可以區別引發事件的元件

// 長按計數值將計數值減1, 長按按鈕將計數值加2

public class MainActivity extends ActionBarActivity 
		implements OnLongClickListener {	
	// 宣告要實作 OnClickListener 介面成為監聽物件
	// 實作 OnLongClickListener 介面

	TextView txv;		// 用來操作 textView1 元件的變數 
	Button btn;			// 用來操作 button1 元件的變數    
	int counter = 0;	// 用來儲存計數的值, 初值為 0
	
	
	@Override
	public boolean onLongClick(View v) {
		// 實作長按 (OnLongClickListener) 介面定義的方法
		if (v.getId() == R.id.textView1) {
		// 判斷來源物件是否為顯示計數值的 TextView, 若是就將計數減一
			counter--;
			txv.setText(String.valueOf(counter));
		}
		else {		// 來源物件為按鈕, 將計數值加 2
			counter += 2;
			txv.setText(String.valueOf(counter));
		}
		return true;	
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.textView1);	// 找出要操作的物件
        btn = (Button)findViewById(R.id.button1);		// 找出要操作的物件
        
        btn.setOnLongClickListener(this);
        // 將 MainActivity 物件登錄為按鈕的長按監聽器
        txv.setOnLongClickListener(this);
        // 將 MainActivity 物件登錄為顯示數字的長按監聽器
        
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
