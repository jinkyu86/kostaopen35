package kr.or.kosta.moviesystem.screentime;

import java.util.ArrayList;

import kr.or.kosta.moviesystem.R;
import kr.or.kosta.moviesystem.movie.Movie;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ScreenTimeAdapter extends BaseAdapter{
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<ScreenTime> arSrc;
	int layout;
	
	public ScreenTimeAdapter(Context context, int alayout, 
			ArrayList<ScreenTime> aarSrc) {
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
		
		TextView txtScrTime = (TextView)convertView.findViewById(R.id.txtScrTime);
		txtScrTime.setText(arSrc.get(position).getTime());
		return convertView;
	}

}
