package com.example.ch06_listmenu2;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
	implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 取得 ListView 物件, 並設定按下動作的監聽器
        ListView lv = (ListView)findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
    }

    ArrayList<String> selected = new ArrayList<String>();
    // 儲存已選取的項目(餐點)名稱字串
    
    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int position,
    		long id) {
    	TextView txv = (TextView)v;		// 將被按下的 View 物件轉成 TextView 物件
    	
    	String item = txv.getText().toString();		// 取得項目中的文字
    	
    	if (selected.contains(item))	// 若 selected 中已有同名項目
    		selected.remove(item);		// 就將它移除
    	else							// 若 selected 沒有同名項目
    		selected.add(item);			// 就將它加到 selected 中,
    									// 成為已選取項目的一員
    	
    	String msg = "";
    	if (selected.size() > 0) {		// 若 selected 中的項目數大於 0
    		msg = "你點了:";
    		for (String str:selected)
    			msg += " " + str;
    		// 每個項目 (餐點) 名稱前空一格, 並附加到訊息字串後面 
    	} 
    	else 							// 若 selected 中的項目數等於 0
    		msg = "請點餐!";
    	
    	TextView msgTxv = (TextView)findViewById(R.id.msgTxv);
    	msgTxv.setText(msg);			// 顯示訊息字串
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
