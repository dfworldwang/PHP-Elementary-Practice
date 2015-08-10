package com.example.ch06_arrayadapterdrink;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

// 要在程式執行的時候變動 Spinner 的顯示項目, 必須藉助 ArrayAdapter 物件,
// 它會從指定的資料來源中取出每一項資料, 再提供給 Spinner 元件顯示:

// 使用 ArrayAdapter 的第一個步驟就是建立 ArrayAdapter 的物件, 
// 第 2 個參數通常都是使用系統提供的 android.R.layout.simple_spinner_item 佈局

// Spinner 會在使用者點選後以選單顯示所有的項目, 必須為選單設定定義顯示樣式的佈局檔, 
// 必須呼叫 ArrayAdapter 類別的 setDropDownViewResource() 方法:   

// 還要將建好的 ArrayAdapter 物件當成參數, 呼叫 Spinner 類別的 setAdapter() 方法, 
// 設定 Spinner 要使用的 ArrayAdapter 物件.

public class MainActivity extends ActionBarActivity 
		implements OnItemSelectedListener {
	
	Spinner drink, temp;	// 顯示飲品項目與溫度選項的 Spinner
	TextView txv;			// 顯示訂單內容的 TextView
	String[] tempSet1 = { "冰", "去冰", "溫" };		// 三種溫度
	String[] tempSet2 = { "冰", "去冰" };			// 兩種溫度
	String[] drinks = {"珍珠奶茶", "波霸奶茶", "仙草凍奶茶", "檸檬汁"};		// 飲料

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.order);
        temp = (Spinner)findViewById(R.id.temp);	// 取得顯示溫度的 Spinner
        drink = (Spinner)findViewById(R.id.drink);	// 取得顯示飲品項目的 Spinner
        
        ArrayAdapter<String> drinkAd = 
        	new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, drinks);
        // 建立飲料品項的 ArrayAdapter
        drinkAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 選單項目的選項樣式
        drink.setAdapter(drinkAd);		// 設定使用 Adapter 物件
        
        drink.setOnItemSelectedListener(this);		// 設定監聽選取事件
    }
    
    public void onItemSelected(AdapterView<?> sv, View v, int pos, long id) {
    	
    	String[] tempSet;
    	if (pos == 3)				// 若選取檸檬汁 (清單中第 4 個項目)
    		tempSet = tempSet2;		// 溫度選項沒有[溫]
    	else
    		tempSet = tempSet1;
    	
    	ArrayAdapter<String> tempAd = 
    			new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tempSet);
    	// 依據溫度選項建立 ArrayAdapter
    	// 選單未打開時的顯示樣式
    	// 溫度選項
    	tempAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	// 設定下拉選單的選項樣式
    	temp.setAdapter(tempAd);		// 設定使用 Adapter 物件
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {	// 不處理
    	
    }
    
    public void showOrder(View v) {
    	// 將飲料名稱及溫度選擇組成一個字串
    	String msg = drink.getSelectedItem() + ", " + temp.getSelectedItem();
    	// 取得飲料名稱, 取得甜度選項
    	
    	// 將訂單內容顯示在文字方塊中
    	txv.setText(msg);
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
