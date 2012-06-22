package kr.or.kosta.moviesystem.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;

import kr.or.kosta.moviesystem.R;
import kr.or.kosta.moviesystem.screentime.ScreenTime;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ViewMovieListActivity extends Activity {
	private Movie movie;
	private ScreenTime screentime;
	private ArrayList<Movie> movieList;
	private int page;
	private int prepage;
	private int nextpage;
	private int minpage;
	private int maxpage;
	private ViewMovieAdapter vmAdapter;
	private TextView MovieTitle;
	private ImageView Mposter;
	private TextView MovieGenre;
	private TextView MovieLaunchDate;
	private ListView MovieList;
	
	@Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.movie_list);
	     
	     movieList = new ArrayList<Movie>();
	     vmAdapter = new ViewMovieAdapter(this, R.layout.movie_item, movieList);
	     MovieList = (ListView)findViewById(R.id.MovieList);
	     MovieTitle = (TextView)findViewById(R.id.MovieTitle);
	     Mposter = (ImageView)findViewById(R.id.MovieImg);
	     MovieGenre = (TextView)findViewById(R.id.MovieGenre);
	     MovieLaunchDate = (TextView)findViewById(R.id.MovieLaunchDate);
	     
	     MovieList.setAdapter(vmAdapter);
	     
	     selectMovieList();
	     
	     MovieList.setOnItemClickListener(mItemClickListener);
	}
	
	//영화 리스트 출력 메서드
	public void selectMovieList(){
		Date Sdate;
		Date Edate;
		movieList.clear();
		
		URL url = null;

		try {
			url = new URL("http://192.168.0.249/moviesystem/Androidmain.action?gubun=total");
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
        		JSONArray JsonMovieArray = jsonObject.getJSONArray("MOVIE_LIST");
        		
        		for(int i=0; i<JsonMovieArray.length();i++){
        			JSONObject movieObject = JsonMovieArray.getJSONObject(i);
        			//개봉일과 상영 종료일의 날짜를 JsonObject로 저장
        			JSONObject lunDateObject = movieObject.getJSONObject("launchDate");
        			JSONObject endDateObject = movieObject.getJSONObject("endDate");
        			
        			/* JsonObject로 저장된 개봉일과 상영 종료일의 정보 중 milli Time에 대한
        			 정보를 Long타입으로 변환*/
        			Long LTime = Long.parseLong(lunDateObject.getString("time"));
        			Long ETime = Long.parseLong(endDateObject.getString("time"));
        			
        			//Logn 타입의 milli Time 정보를 Date타입으로 변환
        			Sdate = new Date(LTime);
        			Edate = new Date(ETime);
        			//System.out.println(formatter.format(LunData));
        			
        			//movie객체 생성
        			Movie movie = new Movie();
        			//movie 객체에 영화정보 Set
        			movie.setMnum(movieObject.getString("mnum"));
        			movie.setMname(movieObject.getString("mname"));
        			movie.setGenre(movieObject.getString("genre"));
        			movie.setContent(movieObject.getString("content"));
        			movie.setMprice(movieObject.getLong("mprice"));
        			if(movieObject.getString("poster").trim().length()>0){
        				movie.setPoster(movieObject.getString("poster"));
        			}else{
        				movie.setPoster("x.jpg");
        			}
        			movie.setLaunchDate(Sdate);
        			movie.setEndDate(Edate);
        			
        			movieList.add(movie);
        		}
        		vmAdapter.notifyDataSetChanged();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ddd
		
	}
	
	OnItemClickListener mItemClickListener=new OnItemClickListener(){
		public void onItemClick(AdapterView parent,
    			View view,int position,long id){
    		Movie selectMovie=movieList.get(position);
    		System.out.println(selectMovie);
    		Intent intent=new Intent(ViewMovieListActivity.this,ViewMovieActivity.class);
    		intent.putExtra("Movie", selectMovie);
    		startActivity(intent);
    	}
	};
}
