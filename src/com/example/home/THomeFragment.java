package com.example.home;


import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.bollywoodlegal.MainActivity;
import com.example.bollywoodlegal.R;
import com.example.bollywoodlegal.TakeQuiz;
import com.example.titleheaders.TabContent;
import com.example.titleheaders.TitlesAndContents;

public class THomeFragment extends SherlockFragment {
	private ArrayList<TabContent> data;
	private int pos;
	public THomeFragment(ArrayList<TabContent> data , int pos){
		this.data = data;
		this.pos = pos;
		setRetainInstance(true);
	}
	
	public THomeFragment(){
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
	/**
	 * @return the data
	 */
	public ArrayList<TabContent> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ArrayList<TabContent> data) {
		this.data = data;
	}

	/**
	 * @return the pos
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ScrollView sv = (ScrollView) inflater.inflate(R.layout.tab_home, container , false);
		
		data = getContents();
		if(pos <= 2){
			TextView title = (TextView) sv.findViewById(R.id.tab_home_title);
			title.setText(data.get(pos).get_tab());
			
			TextView dummy = (TextView) sv.findViewById(R.id.tab_home_subtitle);
			dummy.setVisibility(TextView.INVISIBLE);
			
			TextView content = (TextView) sv.findViewById(R.id.tab_home_content);
			content.setText(data.get(pos).get_strContent());

		}
		else{
			TextView title = (TextView) sv.findViewById(R.id.tab_home_title);
			title.setText(data.get(pos).get_tab());
			
			TextView dummy = (TextView) sv.findViewById(R.id.tab_home_subtitle);
			dummy.setVisibility(TextView.INVISIBLE);
			
			TextView content = (TextView) sv.findViewById(R.id.tab_home_content);
			content.setVisibility(TextView.GONE);
			

			LinearLayout lv = (LinearLayout) sv.findViewById(R.id.tab_holder);
			ArrayList<String> contents = data.get(pos).get_contents();
			for(int i =0;i<contents.size() ;i++){
				String[] dataToSplit = contents.get(i).split("[|]");
				
				TextView clonedSub = new TextView(sv.getContext());
				clonedSub.setTextAppearance(sv.getContext(), android.R.attr.textAppearanceMediumInverse);
				clonedSub.setTextColor(getResources().getColor(R.color.abs__holo_blue_light));
				clonedSub.setText(dataToSplit[0]);
				lv.addView(clonedSub);
				TextView clone = new TextView(sv.getContext());
				clone.setTextAppearance(sv.getContext(), android.R.attr.textAppearanceMedium);
				if(dataToSplit.length>1)
					clone.setText(dataToSplit[1]);
				lv.addView(clone);
			}
			
			
			
		}
		return sv;
	}

}
