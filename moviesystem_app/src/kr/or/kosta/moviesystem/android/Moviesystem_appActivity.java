package kr.or.kosta.moviesystem.android;

import kr.or.kosta.moviesystem.R;
import android.app.Activity;
import android.os.Bundle;

public class Moviesystem_appActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}