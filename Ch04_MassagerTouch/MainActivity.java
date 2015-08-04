package com.example.ch04_massager2;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;


// 介面為 OnTouchListener, 當使用者按住螢幕時手機即會開始震動, 直到放開或是震動 5 秒為止
// OnTouchListener 介面中定義有 onTouch() 方法:
// 其中參數 v 是事件來源物件, 而 e 是儲存有觸控資訊的物件. 像是 e.getAction() 方法可以取得觸控的動作種類
// MotionEvent.ACTION_DOWN, 就表示為手指觸碰到螢幕, MotionEvent.ACTION_UP, 則為手指離開螢幕

// 要讓手機震動, 可執行 getSystemService(Context.VIBRATOR_SERVICE)來取得 Vibrator 震動物件

public class MainActivity extends ActionBarActivity 
		implements OnTouchListener {
	
	@Override
	public boolean onTouch(View v, MotionEvent e) {
	// 實作 OnTouchListener 觸控監聽器介面的方法
		Vibrator vb = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
										// 按下螢幕中間的文字
			vb.vibrate(5000);			// 震動 5 秒
		}
		else if (e.getAction() == MotionEvent.ACTION_UP) {
										// 放開螢幕中間的文字
			vb.cancel();				// 停止震動
		}
		return true;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView txv = (TextView)findViewById(R.id.textView1);
        txv.setOnTouchListener(this);		// 登錄觸控監聽物件
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
