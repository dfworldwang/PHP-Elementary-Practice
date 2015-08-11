package com.example.ch07_brainteasertoast;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

// Toast 提供有便利的 makeText() 方法, 可以指定要顯示的訊息以及顯示的時間長短後直接建立一個 Toast 物件,
// 再呼叫這個物件的 show() 方法即可顯示訊息,

public class MainActivity extends ActionBarActivity 
		implements OnItemClickListener {

	String[] queArr = {"什麼門永遠關不上?", "什麼東西沒人愛吃?", "什麼瓜不能吃?",
			"什麼布切不斷?", "什麼鼠最愛乾淨?", "偷什麼不犯法?"};	// 建立問題陣列
	String[] ansArr = { "球門", "虧", "傻瓜", "瀑布", "環保署", "偷笑" };
	// 建立答案陣列
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ArrayAdapter<String> adapter = 
        		new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, queArr);
        // 建立供 ListView 使用的 ArrayAdapter 物件
        // 使用內建的佈局資源
        // 以 queArr 陣列當資料來源
        
        ListView lv = (ListView)findViewById(R.id.lv);		// 取得 ListView
        lv.setAdapter(adapter);			// 設定 ListView 使用的 Adapter
        lv.setOnItemClickListener(this);	
        // 設定 ListView 項目被按時的事件監聽器   
    }

    @Override
    public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
    	
    	Toast.makeText(this, "答案:" + ansArr[pos], Toast.LENGTH_SHORT).show();
    	// 由 ansArr 陣列取得答案
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
