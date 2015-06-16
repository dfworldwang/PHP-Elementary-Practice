package com.example.ch05_foodmenu2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void takeOrder(View v) {
    	CheckBox chk;
    	String msg = "";			// 存放要顯示在畫面上的文字訊息
    	// 用陣列存放所有 CheckBox 元件的 ID
    	int[] id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4};
    	
    	for (int i:id) {	// 以迴圈逐一檢視各 CheckBox 是否被選取
    		chk = (CheckBox)findViewById(i);
    		if (chk.isChecked())		// 若有被選取
    			msg += "\n" + chk.getText();		// 將換行字元及選項文字
    												// 附加到 msg 字串後面 
    	}
    	
    	if (msg.length() > 0)		// 有點餐 (字串長度大於0)
    		msg = "你點購的餐點是: " + msg;
    	else
    		msg = "請點餐! ";
    	
    	// 在文字方塊中顯示點購的項目
    	((TextView)findViewById(R.id.showOrder)).setText(msg);
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
