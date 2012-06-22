package kr.or.kosta.moviesystem.movie;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import kr.or.kosta.moviesystem.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewMovieAdapter extends BaseAdapter{
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<Movie> arSrc;
	int layout;
	
	public ViewMovieAdapter(Context context, int alayout, 
			ArrayList<Movie> aarSrc) {
		maincon = context;
		Inflater = (LayoutInflater)context.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		arSrc = aarSrc;
		layout = alayout;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arSrc.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arSrc.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = Inflater.inflate(layout, parent, false);
		}
		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");	
		//String mdate = formatter.format(arSrc.get(position).getLaunchDate().toString());
		
		String posterUrl = "http://192.168.0.249/moviesystem/movieimg/"+arSrc.get(position).getPoster();
		System.out.println(arSrc.get(position).getPoster().trim().length());
		
		
		Drawable draw = loadDrawable(posterUrl);
		ImageView MImg = (ImageView)convertView.findViewById(R.id.MovieImg);
		MImg.setImageDrawable(draw);
		
		
		TextView MTitle = (TextView)convertView.findViewById(R.id.MovieTitle);
		MTitle.setText(arSrc.get(position).getMname().toString());
		
		TextView MGenre = (TextView)convertView.findViewById(R.id.MovieGenre);
		MGenre.setText(arSrc.get(position).getGenre());
		
		TextView MovieLaunchDate = (TextView)convertView.findViewById(R.id.MovieLaunchDate);
		MovieLaunchDate.setText(arSrc.get(position).getLaunchDate().toString());
		
		
		return convertView;
	}
	
	public Drawable loadDrawable(String strurl){
		Drawable drawable = null;
		
		try {
			URL url = new URL(strurl);
			InputStream is = url.openStream();
			drawable = Drawable.createFromStream(is, "none");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drawable;
	}
}
