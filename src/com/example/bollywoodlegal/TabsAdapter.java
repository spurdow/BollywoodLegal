package com.example.bollywoodlegal;

import java.util.ArrayList;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.example.home.THomeFragment;
import com.example.home.TQuizzesFragment;
import com.example.home.TStudiesFragment;
import com.example.titleheaders.TabContent;
import com.example.titleheaders.TitlesAndContents;
import com.example.bollywoodlegal.*;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

public class TabsAdapter extends FragmentPagerAdapter
implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
    private final Context mContext;
    private final ActionBar mActionBar;
    private final ViewPager mViewPager;
    private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();
    private ArrayList<TabContent> data;
    private SherlockFragment mFrag;
    private String mTag;

    static final class TabInfo {
        private final Class<?> clss;
        private final Bundle args;

        TabInfo(Class<?> _class, Bundle _args) {
            clss = _class;
            args = _args;
        }
    }
    

    public TabsAdapter(MainActivity activity, ViewPager pager , String mTag , ArrayList<TabContent> data) {
        super(activity.getSupportFragmentManager());
        mContext = activity;
        this.mTag = mTag;
        this.data = data;
        mActionBar = activity.getSupportActionBar();
        mViewPager = pager;
        mViewPager.setAdapter(this);
        mViewPager.setOnPageChangeListener(this);
        

    }

    public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
        TabInfo info = new TabInfo(clss, args);
        tab.setTag(info);
        tab.setTabListener(this);
        
        mTabs.add(info);
        mActionBar.addTab(tab);
        notifyDataSetChanged();
    }

    public int getCount() {
        return mTabs.size();
    }

    public SherlockFragment getItem(int position) {
        TabInfo info = mTabs.get(position);
        return (SherlockFragment)Fragment.instantiate(mContext, info.clss.getName(), info.args);
    }

    public void onPageSelected(int position) {
        mActionBar.setSelectedNavigationItem(position);
    }
    public void onPageScrollStateChanged(int state) {}
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}	
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
    	//	Toast.makeText(mContext, getCount()+"", Toast.LENGTH_SHORT).show();
    	
    	mFrag = (SherlockFragment) ((MainActivity) mContext).getSupportFragmentManager().findFragmentByTag(mTag);

    	
    	if (mFrag == null){
        	mFrag = getItem(tab.getPosition());
        	
        	if (mFrag instanceof THomeFragment){
        		ft.add(R.id.content_frame ,((THomeFragment) mFrag) , mTag);
        	}
        	else if(mFrag instanceof TStudiesFragment){
        		ft.add(R.id.content_frame ,((TStudiesFragment) mFrag) , mTag);  	
        	}
        	else if (mFrag instanceof TQuizzesFragment){
        		ft.add(R.id.content_frame , ((TQuizzesFragment) mFrag) , mTag);
        	}
        	
        	//((MainActivity)mContext).getSupportFragmentManager().beginTransaction().add(R.id.content_frame , mFrag , mTag).commit();
    	}else{
    		if(mFrag instanceof THomeFragment){
        		((THomeFragment) mFrag).setData(data);
        		((THomeFragment) mFrag).setPos(tab.getPosition());
        		Log.v(mTag,"data has been set");
        		ft.attach((THomeFragment)mFrag);
        		//((MainActivity)mContext).getSupportFragmentManager().beginTransaction().attach((THomeFragment)mFrag);
    		}
    		else if(mFrag instanceof TStudiesFragment){
        		((TStudiesFragment) mFrag).setData(data);
        		((TStudiesFragment) mFrag).setPos(tab.getPosition());
        		ft.attach(((TStudiesFragment) mFrag));
        		//((MainActivity)mContext).getSupportFragmentManager().beginTransaction().attach(((TStudiesFragment) mFrag));
    		}
    		else if(mFrag instanceof TQuizzesFragment){
    			((TQuizzesFragment) mFrag).setPos(tab.getPosition());
        		ft.attach(((TQuizzesFragment) mFrag));
    		}
    		//ft.show(mFrag);
    		Log.v(mTag, "Ft.ATTACH");
    		return;
    	}
    	

    	
    	   
    }

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		if(mFrag != null){
			//((MainActivity)mContext).getSupportFragmentManager().beginTransaction().remove(mFrag);
			//mFrag = null;
			//((MainActivity)mContext).getSupportFragmentManager().beginTransaction().detach(mFrag);
			ft.detach(mFrag);
			//ft.remove(mFrag);
		}
		Log.v("Tabs", "onTabunselectedPressed");
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}





}