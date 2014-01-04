package com.example.titleheaders;

import java.util.ArrayList;

import com.example.bollywoodlegal.R;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TitleHeader extends BaseAdapter {

	protected Context _context;
	protected ArrayList<TitlesAndContents> titles;
	protected LayoutInflater inflater;
	
	public TitleHeader(Context _context, ArrayList<TitlesAndContents> titles) {
		super();
		this._context = _context;
		this.titles = titles;
		this.inflater = LayoutInflater.from(_context);
	}

	public TitleHeader(Context _context) {
		// TODO Auto-generated constructor stub
		this(_context , new ArrayList<TitlesAndContents>());
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return titles.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return titles.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(arg1==null){
			arg1 = inflater.inflate(R.layout.headers_list, null);
			holder = new ViewHolder();
			holder.title = (TextView) arg1.findViewById(R.id.headers_text);
			holder.image = (ImageView) arg1.findViewById(R.id.imageView1);
			arg1.setTag(holder);
		}else{
			holder = (ViewHolder) arg1.getTag();
		}
		
		holder.title.setText(titles.get(arg0).get_title().toString());
		holder.image.setImageResource(titles.get(arg0).get_drawable());
		return arg1;
	}
	
	private class ViewHolder{
		protected TextView title ;
		protected ImageView image;
	}

}
