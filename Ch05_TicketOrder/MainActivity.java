package com.example.ch05_ticketorder;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View v) {
    	TextView txv = (TextView)findViewById(R.id.txv);
    	RadioGroup ticketType = (RadioGroup)findViewById(R.id.ticketType);
    	
    	// ㄌ匡兜ヘ陪ボぃ癟
    	switch(ticketType.getCheckedRadioButtonId()) {
    		case R.id.adult:			// 匡布
    			txv.setText("禦布");
    			break;
    		case R.id.child:			// 匡布
    			txv.setText("禦布");
    			break;
    		case R.id.senior:			// 匡穛ρ布
    			txv.setText("禦穛ρ布");
    			break;
    	}
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
