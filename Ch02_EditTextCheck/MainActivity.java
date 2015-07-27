package com.example.ch02_edittextcheck;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
    
    public void sayHello(View v) {
    	// 取得代表佈局中EditText 及 TextView 的物件
    	EditText name = (EditText)findViewById(R.id.name);
    	TextView txv = (TextView)findViewById(R.id.txv);
    	// 設定 TextView 文字大小為35sp
    	txv.setTextSize(35);
    	// 取得 EditText 使用者輸入的文字, trim()去除空白字元
    	String str = name.getText().toString().trim();
    	
    	if (str.length() == 0)
    		txv.setText("名字不可為空白");
    	else
    		txv.setText(str + ", 您好!");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.txv) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
