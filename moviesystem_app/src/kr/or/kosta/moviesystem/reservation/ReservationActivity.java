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
import kr.or.kosta.moviesystem.screentime.ScreenTimeAdapter;
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
	private ScreenTime screentime;
	private ScreenTimeAdapter scrtimeAdapter;
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
		scrtimeAdapter = new ScreenTimeAdapter(this,R.layout.screentime_item,screentimeList);
		spScreentimeList.setAdapter(scrtimeAdapter);
		
		scrtimeAdapter.notifyDataSetChanged();
		int equalScrtIndex=0;
		
		for(int i=0; i<screentimeList.size();i++){
			ScreenTime scr = screentimeList.get(i);
			String scrnum=movie.getMnum();
			if(scr.getMovie().getMnum().equals(scrnum)){
				equalScrtIndex = i;
				break;
			}
		}
		spScreentimeList.setSelection(equalScrtIndex);
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
	        		
	        		movie.setMnum(movieObject.getString("mnum"));
	        		movie.setMname(movieObject.getString("mname"));
	        		movie.setGenre(movieObject.getString("genre"));
	        		
	        		JSONArray screentimeJSONArray = jsonObject.getJSONArray("SCREENTIME_LIST");
	        		
	        		for(int i=0; i<screentimeJSONArray.length(); i++){
	        			JSONObject screentimeObject = screentimeJSONArray.getJSONObject(i);
	        			JSONObject movieInfoObject = screentimeObject.getJSONObject("movie");
	        			ScreenTime scrtime = new ScreenTime();
	        			scrtime.setScrnum(screentimeObject.getString("scrnum"));
	        			scrtime.setTime(screentimeObject.getString("time"));
	        			
	        			Movie movieInfo = new Movie();
	        			movieInfo.setMnum(movieInfoObject.getString("mnum"));
	        			movieInfo.setMname(movieInfoObject.getString("mname"));
	        			
	        			scrtime.setMovie(movieInfo);
	        			
	        			screentimeList.add(scrtime);
	        		}
	        	}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
}
