package com.example.ch03_linearlayout2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	// 宣告代表 UI 元件的變數
	EditText sname, fname, phone;
	TextView txv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 初始化變數
        sname = (EditText)findViewById(R.id.surName);
        fname = (EditText)findViewById(R.id.firstName);
        phone = (EditText)findViewById(R.id.phone);
        txv = (TextView)findViewById(R.id.txv);
    }

    public void onclick(View v) {
    	txv.setText(sname.getText().toString() +
    			fname.getText() + 
    			"的電話是 " + phone.getText());
    			
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
