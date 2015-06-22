package com.example.ch06_ticketspinner2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	TextView txv;
	Spinner cinema;			// 顯示戲院清單的 Spinner 物件																																																			

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.txv);			// 取得 TextView 物件
        cinema = (Spinner)findViewById(R.id.cinema);	// 取得 Spinner 物件
    }

    public void order(View v) {
    	String[] cinemas = getResources().getStringArray(R.array.cinemas);
    	// 取得字串資源中的字串陣列
    	
    	int index = cinema.getSelectedItemPosition();
    	// 取得 Spinner 中被選取項目的位置
    	txv.setText("訂" + cinemas[index] + "的票");		// 顯示選取的項目 
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
