package com.example.ch02_buttonsmaller;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    int size = 30;			// 字型大小, 初始值 30(sp)
    public void bigger(View v) {
    	
    	TextView txv2 = (TextView)findViewById(R.id.txv2);
    	txv2.setTextSize(++size);
    }
    
    public void smaller(View v) {
    	
    	if (size > 30) {		// 字型大於 30 (sp)時才會處理
    		TextView txv2 = (TextView)findViewById(R.id.txv2);
    		txv2.setTextSize(--size);			// 將字型大小遞減	
    	}
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.txv2) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
