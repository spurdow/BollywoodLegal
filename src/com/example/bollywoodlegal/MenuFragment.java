package com.example.bollywoodlegal;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.connectionDetector.ConnectionDetector;
import com.example.titleheaders.TabContent;
import com.example.titleheaders.TitleHeader;
import com.example.titleheaders.TitlesAndContents;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MenuFragment extends ListFragment {

	private TitleHeader title_adapter;
	private ListView listview;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LinearLayout v = (LinearLayout) inflater.inflate(R.layout.ll_header, null);
		
		return v; 
		 
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Toast.makeText(getActivity(),((TitlesAndContents) l.getAdapter().getItem(position)).get_title(), Toast.LENGTH_SHORT).show();
		TitlesAndContents ta = ((TitlesAndContents) l.getAdapter().getItem(position));
		SherlockFragment content = null;
		long layout = 0;
		switch(position){
		case 0 :
				 content = new HomeFragment(((TitlesAndContents) l.getAdapter().getItem(position))); 
				 break;
		case 1 : 			
			     content = new StudiesFragment(((TitlesAndContents) l.getAdapter().getItem(position)));
		         break;
		case 2 : 
				 ConnectionDetector cd = new ConnectionDetector(this.getActivity());
				 boolean status = cd.isConnectingorConnected();
				 if(!status){
					 cd.showDialog("No Internet Connection", "You don't have internet connection.",  status );
				 }
				 else
					 content = new QuizzesFragment(((TitlesAndContents) l.getAdapter().getItem(position)));
				 break;
		case 3 :
				 content = new FaqFragment(((TitlesAndContents) l.getAdapter().getItem(position)));
				 break;
		case 4 : 
				 content = new ContactFragment(((TitlesAndContents) l.getAdapter().getItem(position)));
				 break;
		}
		
		if(content!=null)
			switchContent(content);
		else 
			((MainActivity) getActivity()).toggle();
		
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		String[] s = {"Home","Studies","Quizzes","FAQ","Contact Us"};
		Integer[] img = {R.drawable.ic_menu_home, R.drawable.ic_menu_agenda,R.drawable.ic_menu_compose,R.drawable.ic_menu_notifications,R.drawable.ic_menu_call};
		
		ArrayList<TitlesAndContents> list = new ArrayList<TitlesAndContents>();
		
		for(int i =0;i<s.length;i++){
			list.add(new TitlesAndContents(s[i] , img[i]));
			
		}
		title_adapter = new TitleHeader(getActivity() , list);
		
		setListAdapter(title_adapter);
		
	}
	
	private void switchContent(SherlockFragment fragment ){
		if(getActivity() instanceof MainActivity){
			MainActivity ma = (MainActivity)getActivity();
			ma.switchContent(fragment);
		}
	}
		
}
