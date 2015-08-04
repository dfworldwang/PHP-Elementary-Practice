package com.example.ch06_tickettwospinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

// 建立 Spinner 元件時, 只需設定一項 Entries 屬性即可使用, 必須先在 values/strings.xml 中建立字串陣列
// 再將陣列名稱指定給 Entries 屬性,
// 可使用 getSelectedItemPosition() 方法取得 Spinner 元件中選取的項目索引編號   

public class MainActivity extends ActionBarActivity {
	
	TextView txv;
	Spinner cinema, time;		// 戲院, 場次清單物件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.txv);
        cinema = (Spinner)findViewById(R.id.cinema);
        time = (Spinner)findViewById(R.id.time);
    }

    public void order(View v) {
    	
    	String[] cinemas = getResources().getStringArray(R.array.cinemas);
    	// 取得字串資源中的字串陣列
    	// 取得戲院字串陣列
    	String[] times = getResources().getStringArray(R.array.times);
    	// 取得場次字串陣列
    	int idxCinema = cinema.getSelectedItemPosition();	// 選取的戲院
    	int idxTime = time.getSelectedItemPosition();		// 選取的場次
    	txv.setText("訂" + cinemas[idxCinema] + times[idxTime] + "的票");
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
