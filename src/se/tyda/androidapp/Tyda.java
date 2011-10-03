package se.tyda.androidapp;

import se.tyda.androidapp.TestHttpGet;
import android.app.Activity;

import android.os.Bundle;
import android.widget.TextView;

public class Tyda extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("Hello, Android 2");
        setContentView(tv);
        String s = "none";
        try {
			s = TestHttpGet.executeHttpGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tv.setText(s);
        setContentView(tv);
        //setContentView(R.layout.main);
    }
}