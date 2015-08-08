package com.example.ch06_movielistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

// ListView (清單方塊) 是以條列的方式顯示資料的元件
// ListView 的預設行為沒有選取事件. 使用者按下清單項目觸發的是按一下事件, 而非選取事件.
// 要監聽此事件, 必須用 setOnItemClickListener()
// 監聽物件參數需實作的介面為 OnItemClickListener, 
// 必須實作的方法只有: onItemClick(AdapterView<?> parent, View view, int position, long id)
// parent 代表 ListView 物件本身

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

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, 
    		int position, long id) {
    	
    	// 將被按下的 View 物件轉成 TextView
    	TextView txv = (TextView)v;
    	TextView msgTxv = (TextView)findViewById(R.id.msgTxv);
    	msgTxv.setText("訂" + txv.getText() + "的票");		// 顯示訊息字串
    	
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
