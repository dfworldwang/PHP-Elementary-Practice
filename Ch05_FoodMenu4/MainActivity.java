package com.example.ch05_foodmenu4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
	implements OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4};
        for (int id:chk_id)		// 為每個 CheckBox 註冊監聽物件
        	((CheckBox)findViewById(id)).setOnCheckedChangeListener(this);
    }

    int items = 0;		// 記錄目前選取餐點的數量
    public void onCheckedChanged(CompoundButton chk, boolean isChecked) {
    	int visible;		// CheckBox 顯示狀態
    	if (isChecked) {	// 被選取時
    		items++;		// 數量加 1
    		visible = View.VISIBLE;
    		// 應使用的 Visibility 屬性值為 VISIBLE (可見)
    	}
    	else {				// 被取消時
    		items--;		// 數量減 1
    		visible = View.GONE;
    		// 應使用的 Visibility 屬性值為 GONE (不可見)
    	}
    	
    	switch (chk.getId()) {
    	// 依選取項目的資源 ID, 決定要更改的 ImageView
    	
    	case R.id.chk1:
    		findViewById(R.id.output1).setVisibility(visible);
    		break;
    	case R.id.chk2:
    		findViewById(R.id.output2).setVisibility(visible);
    		break;
    	case R.id.chk3:
    		findViewById(R.id.output3).setVisibility(visible);
    		break;
    	case R.id.chk4:
    		findViewById(R.id.output4).setVisibility(visible);
    		break;
    	}
    	
    	String msg;
    	if (items > 0)		// 選取項目大於 0, 顯示有點餐的訊息
    		msg = "你點的餐點如下: ";
    	else				// 否則顯示請點餐的訊息
    		msg = "請點餐!";
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
