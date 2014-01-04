package com.example.bollywoodlegal;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.Questionnaire.MyQuestionnaireAdapter;
import com.example.Questionnaire.QuestionHeader;
import com.example.Questionnaire.Questions;
import com.example.titleheaders.TitlesAndContents;

public class TakeQuiz extends SherlockFragment {
	private TitlesAndContents data;
	private ExpandableListView expView;
	private MyQuestionnaireAdapter adapter;
	
	public TakeQuiz(TitlesAndContents data){
		super();
		this.data = data;
		this.setRetainInstance(true);
		
	}
	
	public TakeQuiz(){
		this(null);
		
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
		return inflater.inflate(R.layout.expandable_layout,container,false);

	}
	
	private ArrayList<QuestionHeader> getList(){
		ArrayList<QuestionHeader> q = new ArrayList<QuestionHeader>();
		
		for(int i =0;i<5;i++){
			
			ArrayList<Questions> mgaQ = new ArrayList<Questions>();
			for(int i2 = 0;i2<4;i2++){
				mgaQ.add(new Questions("Question " + i2 , false));
			}
			q.add(new QuestionHeader("What is No." + i, mgaQ));
			
		}
		return q;
	}
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		expView = (ExpandableListView) getView().findViewById(R.id.expandable_listview);
		expView.setChoiceMode(ExpandableListView.CHOICE_MODE_MULTIPLE);
		adapter = new MyQuestionnaireAdapter(getActivity() , getList());
		expView.setAdapter(adapter);
		
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
}
