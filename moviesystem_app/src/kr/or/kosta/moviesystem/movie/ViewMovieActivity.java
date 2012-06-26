package kr.or.kosta.moviesystem.movie;

import java.io.InputStream;
import java.net.URL;

import kr.or.kosta.moviesystem.R;
import kr.or.kosta.moviesystem.reservation.ReservationActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewMovieActivity extends Activity{
	private Movie movie;
	private ImageView mImg;
	private TextView mTitle;
	private TextView mGenre;
	private TextView mLunDate;
	private TextView mContent;
	private TextView mPrice;
	private String mnum;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_movie);
		
		Intent intent = getIntent();
		mImg			= (ImageView)findViewById(R.id.mImg);
		mTitle			= (TextView)findViewById(R.id.mTitle);
		mGenre		= (TextView)findViewById(R.id.mGenre);
		mLunDate	= (TextView)findViewById(R.id.mLunDate);
		mContent	= (TextView)findViewById(R.id.mContent);
		mPrice		= (TextView)findViewById(R.id.mPrice);
		
		Movie movie = (Movie)intent.getSerializableExtra("MOVIE");
		
		mnum = movie.getMnum();
		mTitle.setText(movie.getMname());
		mGenre.setText(movie.getGenre());
		mLunDate.setText(movie.getLaunchDate().toString());
		mContent.setText(movie.getContent());
		String moviePrice = movie.getMprice()+" ¿ø";
		mPrice.setText(moviePrice);
		
		String posterUrl = "http://192.168.0.249/moviesystem/movieimg/"+movie.getPoster();
		Drawable draw = loadDrawable(posterUrl);
		mImg.setImageDrawable(draw);
		
	}
	
	public Drawable loadDrawable(String strurl){
		Drawable drawable = null;
		
		try {
			URL url = new URL(strurl);
			InputStream is = url.openStream();
			drawable = Drawable.createFromStream(is, "none");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drawable;
	}
	
	public void mOnClick(View view){
		switch(view.getId()){
		case R.id.reserv:
			Intent intent = new Intent(ViewMovieActivity.this, ReservationActivity.class);
			intent.putExtra("MOVIE_NUM", mnum);
			startActivity(intent);
			break;
		}
	}
}
