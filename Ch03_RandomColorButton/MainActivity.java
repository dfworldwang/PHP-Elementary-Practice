package com.example.ch03_randomcolorbutton;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	TextView txvR, txvG, txvB;
	Button btn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 取得 3 個 TextView 的物件, 及顯示顏色的 Button
        txvR = (TextView)findViewById(R.id.txvR);
        txvG = (TextView)findViewById(R.id.txvG);
        txvB = (TextView)findViewById(R.id.txvB);
        btn = (Button)findViewById(R.id.button1);
    }

    public void changeColor(View v) {
    	
    	// 取得亂數物件, 產生3個亂數值(rgb值)
    	Random x = new Random();
    	int red = x.nextInt(256);			// 取0 ~ 255之間的亂數
    	txvR.setText("紅: " + red);			// 顯示亂數值
    	txvR.setTextColor(Color.rgb(red, 0, 0));	// 將文字設為亂數顏(紅)色值
    	
    	int green = x.nextInt(256);
    	txvG.setText("綠: " + green);
    	txvG.setTextColor(Color.rgb(0, green, 0));	// 將文字設為亂數顏(綠)色值
    	
    	int blue = x.nextInt(256);
    	txvB.setText("藍: " + blue);
    	txvB.setTextColor(Color.rgb(0, 0, blue));	// 將文字設為亂數顏(藍)色值
    	
    	btn.setTextColor(Color.rgb(red, green, blue));		// 按鈕顏色 
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
        if (id == R.id.txvR) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
