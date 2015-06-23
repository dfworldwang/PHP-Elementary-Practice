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
	Spinner cinema;			// ������|�M�檺 Spinner ����																																																			

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.txv);			// ���o TextView ����
        cinema = (Spinner)findViewById(R.id.cinema);	// ���o Spinner ����
    }

    public void order(View v) {
    	String[] cinemas = getResources().getStringArray(R.array.cinemas);
    	// ���o�r��귽�����r��}�C
    	
    	int index = cinema.getSelectedItemPosition();
    	// ���o Spinner ���Q������ت���m
    	txv.setText("�q" + cinemas[index] + "����");		// ��ܿ�������� 
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