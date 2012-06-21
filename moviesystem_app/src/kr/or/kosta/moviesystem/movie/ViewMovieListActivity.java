package kr.or.kosta.moviesystem.movie;

import kr.or.kosta.moviesystem.R;
import android.app.Activity;
import android.os.Bundle;

public class ViewMovieListActivity extends Activity {
	@Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.movie_list);
	}
}
