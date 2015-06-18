package com.example.ch05_foodmenu2;

import java.util.ArrayList;

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
        
        // 所有核取方塊 ID 的陣列
        int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4,
        		R.id.chk5, R.id.chk6, R.id.chk7, R.id.chk8};
        
        for (int id:chk_id) {		// 用迴圈替所有核取方塊註冊監聽物件																						
        	CheckBox chk = (CheckBox)findViewById(id);
        	chk.setOnCheckedChangeListener(this);
        }
    }
    
    // 用來儲存已選取項目的集合物件
    ArrayList<CompoundButton> selected = new ArrayList<CompoundButton>();
    
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    	
    	if (isChecked == true)				// 若項目被選取
    		selected.add(buttonView);		// 加到集合之中
    	else								// 若項目被取消
    		selected.remove(buttonView);	// 自集合中移除
    }
    
    public void takeOrder(View v) {
    	
    	String msg = "";			// 儲存訊息的字串
    	
    	for (CompoundButton chk:selected)		// 以迴圈逐一將換行字元及
    		msg += "\n" + chk.getText();		// 選項文字附加到 msg 字串後面
    	
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
