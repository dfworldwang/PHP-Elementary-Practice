package com.example.ch07_dialogshow;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// [交談窗](Dialog) 可以用來顯示一段訊息, 並要求使用者輸入一些資訊
// 此時輸入焦點會集中在交談窗上, 必須等交談窗關閉後, 使用者才能進行其他的操作.

// AlertDialog 類別可以顯示出以下幾種項目: 
// 標題: 可包含文字及圖示(也可都沒有)
// 內容: 一段文字訊息, 或一個可選擇的清單方塊
// 按鈕: 可包含 0 ~ 3 個按鈕(也可都沒有)

// 要顯示 Alert 交談窗, 請先使用類別 AlertDialog.Builder 建立 AlertDialog.Builder 物件, 
// 然後用此物件來設定交談窗所需的元素及屬性後, 再產生實際的 AlertDialog 物件並顯示出來.

// AlertDialog.Builder 物件中 setCancelable() 方法: 設定可按返回鍵關閉交談窗
// 若傳入 true 呼叫此方法, 表示使用者可按手機的返回鍵關閉交談窗
// 若傳入 false, 交談窗上就必須提供取消按鈕, 否則使用者將無法關閉交談窗.

// 設定好交談窗所需的元素與屬性後, 即可呼叫 AlertDialog.Builder 的 show() 方法建立 AlertDialog 物件,
// 此方法會自動呼叫 AlertDialog 的 show() 方法顯示交談窗.      

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        bdr.setMessage("交談窗示範教學!\n" + "請按返回鍵關閉交談窗");			// 加入文字訊息
        bdr.setTitle("歡迎");			// 加入標題
        bdr.setIcon(android.R.drawable.presence_away);			// 加入圖示
        bdr.setCancelable(true);		// 允許按返回鍵關閉交談窗
        bdr.show();
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
