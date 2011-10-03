package se.tyda.androidapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Tyda extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        String s = "none";
        String t = "Here we go:\n";
        Pattern pattern = Pattern.compile("a id=\"tyda_transR[0-9]+\" href=\"/search/[a-zA-Z_0-9]+");
        //Vector<String> v = new Vector<String>();

        try {
            s = TestHttpGet.executeHttpGet("http://tyda.se/search/stämning");
            Matcher matcher = pattern.matcher(s);

            while (matcher.find()) {
            	String match = matcher.group();
                t += match.substring(match.lastIndexOf('/') + 1) + "\n";
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tv.setText(t);
        setContentView(tv);
        //setContentView(R.layout.main);
    }
}
