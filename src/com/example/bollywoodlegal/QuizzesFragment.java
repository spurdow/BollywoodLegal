package com.example.bollywoodlegal;


import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.home.TQuizzesFragment;
import com.example.titleheaders.TabContent;
import com.example.titleheaders.TitlesAndContents;

public class QuizzesFragment extends SherlockFragment{
	private TitlesAndContents data;
	
	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;
	ActionBar bar;
	
	public QuizzesFragment(TitlesAndContents data) {
		super();
		this.data = data;
		this.setRetainInstance(true);

	    
	}
	
	public void setTitlesAndContents(TitlesAndContents data){
		this.data = data;
	}
	
	public TitlesAndContents getData(){
		return data;
	}
	

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		
	    inflater.inflate(R.menu.quizzes, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		item.setCheckable(true);
		switch (item.getItemId()) {

		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setHasOptionsMenu(true);
    
		FrameLayout v = (FrameLayout) inflater.inflate(R.layout.content_frame,container,false);
		return v;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		mViewPager = new ViewPager((MainActivity)this.getActivity());
        mViewPager.setId(R.id.pager1);
        ActionBar bar =((MainActivity)this.getActivity()).getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        mTabsAdapter = new TabsAdapter(((MainActivity)this.getActivity()), mViewPager , "quizzes_tab" , getContents());
        
        mTabsAdapter.addTab(bar.newTab().setText(R.string.quiz_basic_conveyancing),
                TQuizzesFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.quiz_buying),
        		TQuizzesFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.quiz_selling),
        		TQuizzesFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.quiz_buy_sell),
        		TQuizzesFragment.class, null);
	}
	//ang res sa above view maoy ipaslak sa temporary holder nga adapter para inig switchContent kabaw ka onsa nga layout ang tangtangon
	private ArrayList<TabContent> getContents(){
		ArrayList<TabContent> data = new ArrayList<TabContent>();

		return data;
	}
	
}
