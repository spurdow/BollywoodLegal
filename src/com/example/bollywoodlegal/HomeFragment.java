package com.example.bollywoodlegal;

import java.util.ArrayList;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.home.THomeFragment;
import com.example.titleheaders.TabContent;
import com.example.titleheaders.TitlesAndContents;

public class HomeFragment extends SherlockFragment {
	/*
	 * 
	 * Let The Parent Override the OnCreateOptionsMenu and OnOptionItemSelected
	 */
    private TitlesAndContents data;
	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;

	public HomeFragment(){
		this.data = new TitlesAndContents("Home");
	}
	public HomeFragment(TitlesAndContents data) {
		super();
		this.data = data;
		this.setRetainInstance(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		
		inflater.inflate(R.menu.quizzes, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		mViewPager = new ViewPager((MainActivity)this.getActivity());
        mViewPager.setId(R.id.pager1);
        
	        ActionBar bar =((MainActivity)this.getActivity()).getSupportActionBar();
	/*    int currentTab = 0;
	    if(savedInstanceState!=null){
	    	currentTab = savedInstanceState.getInt("last_tab");
	    	Log.v("c",currentTab+"");
	    }*/
	    if(bar.getTabCount() == 0 ){
	        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	        
	        
	
	        mTabsAdapter = new TabsAdapter(((MainActivity)this.getActivity()), mViewPager , "home_tab" , getContents());
	        
	        mTabsAdapter.addTab(bar.newTab().setText(R.string.home_how),
	                THomeFragment.class, null);
	        mTabsAdapter.addTab(bar.newTab().setText(R.string.home_what),
	        		THomeFragment.class, null);
	        mTabsAdapter.addTab(bar.newTab().setText(R.string.home_how_start),
	        		THomeFragment.class, null);
	        mTabsAdapter.addTab(bar.newTab().setText(R.string.home_benefits),
	        		THomeFragment.class, null);
	       // bar.setSelectedNavigationItem(currentTab);
	    }
	    
	   // bar.setSelectedNavigationItem(currentTab);
	    Log.v("selected",bar.getSelectedNavigationIndex()+"");
	}

	private ArrayList<TabContent> getContents(){
		ArrayList<TabContent> data = new ArrayList<TabContent>();
		
		data.add(new TabContent(getActivity().getResources().getString(R.string.home_how) , getActivity().getResources().getString(R.string.tab_home_how)));
		data.add(new TabContent(getActivity().getResources().getString(R.string.home_what) , getActivity().getResources().getString(R.string.tab_home_what)));
		data.add(new TabContent(getActivity().getResources().getString(R.string.home_how_start) , getActivity().getResources().getString(R.string.tab_home_how_start)));
		
		ArrayList<String> d = new ArrayList<String>();
		d.add(getActivity().getResources().getString(R.string.tab_home_benefits_contracts));
		d.add(getActivity().getResources().getString(R.string.tab_home_benefits_service));
		d.add(getActivity().getResources().getString(R.string.tab_home_benefits_hassle));
		d.add(getActivity().getResources().getString(R.string.tab_home_benefits_services));
		d.add(getActivity().getResources().getString(R.string.tab_home_benefits_cost));
		TabContent benefits = new TabContent(getActivity().getResources().getString(R.string.home_benefits) ,d ) ;
		
		data.add(benefits);
		
		return data;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		SherlockFragment fragment = null;
		switch(item.getItemId()){
		case R.id.quiz_take_study : break;
		case R.id.quiz_take_quiz : 
			fragment = new TakeQuiz();
			((MainActivity)getActivity()).switchContent(fragment);
			((MainActivity)getActivity()).toggle();
			break;
		}
		
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		this.setHasOptionsMenu(true);
		FrameLayout v = (FrameLayout) inflater.inflate(R.layout.content_frame,container,false);
		TextView tv = (TextView) v.findViewById(R.id.textView1);
		//tv.setText(getData().get_title());
		return v;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		if (outState==null)
			outState.putInt("last_tab", ((MainActivity)this.getActivity()).getSupportActionBar().getSelectedNavigationIndex());
		super.onSaveInstanceState(outState);
	}
	
	public void setTitlesAndContents(TitlesAndContents data){
		this.data = data;
	}
	
	public TitlesAndContents getData(){
		return data;
	}
	
	
	  
}
