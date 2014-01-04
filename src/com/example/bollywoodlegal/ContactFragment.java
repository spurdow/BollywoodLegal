package com.example.bollywoodlegal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.titleheaders.TitlesAndContents;

public class ContactFragment extends SherlockFragment {
	private TitlesAndContents data;

	public ContactFragment(TitlesAndContents data){
		super();
		this.data = data;
		this.setRetainInstance(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
	    inflater.inflate(R.menu.contact, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void setTitlesAndContents(TitlesAndContents data){
		this.data = data;
	}
	
	public TitlesAndContents getData(){
		return data;
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		this.setHasOptionsMenu(true);
		FrameLayout v = (FrameLayout) inflater.inflate(R.layout.content_frame,container,false);
		TextView tv = (TextView) v.findViewById(R.id.textView1);
		tv.setText(getData().get_title());
		return v;
	}


	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
}
