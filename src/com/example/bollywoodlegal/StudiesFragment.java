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
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.home.TStudiesFragment;
import com.example.titleheaders.TabContent;
import com.example.titleheaders.TitlesAndContents;



public class StudiesFragment extends SherlockFragment {
	private TitlesAndContents data;
	
	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;
	ActionBar bar;

	public StudiesFragment(TitlesAndContents data) {
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		this.setHasOptionsMenu(true);
		return inflater.inflate(R.layout.content_frame,container,false);
	}


	/* (non-Javadoc)
	 * @see com.actionbarsherlock.app.SherlockFragment#onCreateOptionsMenu(com.actionbarsherlock.view.Menu, com.actionbarsherlock.view.MenuInflater)
	 */
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		inflater.inflate(R.menu.quizzes, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}



	/* (non-Javadoc)
	 * @see com.actionbarsherlock.app.SherlockFragment#onOptionsItemSelected(com.actionbarsherlock.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}



	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		mViewPager = new ViewPager((MainActivity)this.getActivity());
        mViewPager.setId(R.id.pager1);
        ActionBar bar =((MainActivity)this.getActivity()).getSupportActionBar();
        if(bar.getTabCount() == 0){
	        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	
	        mTabsAdapter = new TabsAdapter(((MainActivity)this.getActivity()), mViewPager , "studies_tab" , getContents());
	        mTabsAdapter.addTab(bar.newTab().setText(R.string.studies_basic_conveyancing),
	                TStudiesFragment.class, null);
	        mTabsAdapter.addTab(bar.newTab().setText(R.string.studies_for_purchasers),
	        		TStudiesFragment.class, null);
	        mTabsAdapter.addTab(bar.newTab().setText(R.string.studies_for_vendors),
	        		TStudiesFragment.class, null);
	        mTabsAdapter.addTab(bar.newTab().setText(R.string.studies_advantages_disadvantages),
	        		TStudiesFragment.class, null);
        }
		
	}




	private ArrayList<TabContent> getContents(){
		ArrayList<TabContent> data = new ArrayList<TabContent>();
		data.add(new TabContent(getActivity().getResources().getString(R.string.studies_basic_conveyancing), getActivity().getResources().getString(R.string.tab_basic_c_content)));
		data.add(new TabContent(getActivity().getResources().getString(R.string.studies_for_purchasers), getActivity().getResources().getString(R.string.tab_for_purchasers_content)));
		data.add(new TabContent(getActivity().getResources().getString(R.string.studies_for_vendors), getActivity().getResources().getString(R.string.tab_for_vendors_content)));
		
		return data;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
	
}
