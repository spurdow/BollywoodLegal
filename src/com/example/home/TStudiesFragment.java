package com.example.home;

import java.util.ArrayList;

import android.os.Bundle;
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
import com.example.bollywoodlegal.R;
import com.example.titleheaders.TabContent;

public class TStudiesFragment extends SherlockFragment{
	private ArrayList<TabContent> data;
	private int pos;
	public TStudiesFragment(ArrayList<TabContent> data , int pos){
		this.data = data;
		this.pos = pos;
		setRetainInstance(true);
	}
	
	public TStudiesFragment(){}

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
		ScrollView v = (ScrollView) inflater.inflate(R.layout.tab_studies, container , false);
		LinearLayout l = (LinearLayout) v.findViewById(R.id.basic_c);
		data = getContents();
		if (pos < 3){
			
			
			TextView title = (TextView) v.findViewById(R.id.basic_c_title);
			TextView content = (TextView) v.findViewById(R.id.basic_c_content);
			
			title.setText(data.get(pos).get_tab());
			content.setText(data.get(pos).get_strContent().replace("percent", "%"));
			
			
		}else{
			
			l.setVisibility(LinearLayout.GONE);
		}
		
		return v;
	}
	private ArrayList<TabContent> getContents(){
		ArrayList<TabContent> data = new ArrayList<TabContent>();
		data.add(new TabContent(getActivity().getResources().getString(R.string.studies_basic_conveyancing), getActivity().getResources().getString(R.string.tab_basic_c_content)));
		data.add(new TabContent(getActivity().getResources().getString(R.string.studies_for_purchasers), getActivity().getResources().getString(R.string.tab_for_purchasers_content)));
		data.add(new TabContent(getActivity().getResources().getString(R.string.studies_for_vendors), getActivity().getResources().getString(R.string.tab_for_vendors_content)));
		
		
		return data;
	}

}
