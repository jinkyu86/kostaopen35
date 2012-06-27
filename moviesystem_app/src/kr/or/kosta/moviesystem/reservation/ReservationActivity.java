package kr.or.kosta.moviesystem.reservation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import kr.or.kosta.moviesystem.R;
import kr.or.kosta.moviesystem.movie.Movie;
import kr.or.kosta.moviesystem.screentime.ScreenTime;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class ReservationActivity extends Activity{
	private EditText mTitle;
	private EditText memId;
	private Spinner spScreentimeList;
	private String mnum;
	private Movie movie;
	private ArrayList<ScreenTime> screentimeList;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.res_movie);
		
		Intent intent = getIntent();
		movie = new Movie();
		screentimeList = new ArrayList<ScreenTime>();
		spScreentimeList = (Spinner)findViewById(R.id.ScreenTime);
		mTitle = (EditText)findViewById(R.id.mTitle);
		memId = (EditText)findViewById(R.id.MemId);
		
		mnum = intent.getStringExtra("MOVIE_NUM");
		
		viewMovie();	
		
		mTitle.setText(movie.getMname());
		
	}
	
	public void viewMovie(){
		URL url = null;
		try {
			url = new URL("http://192.168.0.249/moviesystem/AndroidMovieInfo.action?mnum="+mnum);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpURLConnection conn;
		System.out.println("#1");
		
		 try {
	        	conn = (HttpURLConnection) url.openConnection();
	        	if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
	        		InputStream is=conn.getInputStream();
	        		Reader reader=new InputStreamReader(is,"UTF-8");
	        		BufferedReader br=new BufferedReader(reader);
		    
	        		String strJson="";
	        		String read=null;
	        	
	        		while((read=br.readLine())!=null){
	        			strJson+=read;
	        		}
	        		br.close();
	        		reader.close();
	        		is.close();
	        		
	        		JSONObject jsonObject = new JSONObject(strJson);
	        		JSONObject movieObject = jsonObject.getJSONObject("MOVIE");
	        		System.out.println("movieObject : "+movieObject);
	        		JSONArray screentimeJSONArray = jsonObject.getJSONArray("SCREEN_TIME");
	        		System.out.println("screentimeJSONArray : "+screentimeJSONArray);
	        		
	        		for(int i=0; i<screentimeJSONArray.length(); i++){}
	        	}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
}
