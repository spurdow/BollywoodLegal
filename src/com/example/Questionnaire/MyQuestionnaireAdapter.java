package com.example.Questionnaire;

import java.util.ArrayList;

import com.example.bollywoodlegal.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyQuestionnaireAdapter extends BaseExpandableListAdapter {

	private Context _context;
	private LayoutInflater inflater;
	private ArrayList<QuestionHeader> questionnaire;
	
	/**
	 * @param _context
	 * @param questionnaire
	 */
	public MyQuestionnaireAdapter(Context _context,
			ArrayList<QuestionHeader> questionnaire) {
		super();
		this._context = _context;
		this.questionnaire = questionnaire;
		this.inflater = LayoutInflater.from(this._context);
	}
	
	public void addData(QuestionHeader qheader){
		questionnaire.add(qheader);
		notifyDataSetChanged();
	}
	

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		ArrayList<Questions> qDetails = questionnaire.get(arg0).getQuestions();
		return qDetails.get(arg1);
	}
	
	public final Object getChildAt(int arg0 , int arg1){
		return getChild(arg0 , arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return arg1;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		// TODO Auto-generated method stub
		ChildHolder cv = null;
		Questions q = (Questions) this.getChild(arg0, arg1);
		
		if(arg3 == null){
			arg3 = inflater.inflate(R.layout.child_row, null);
			cv = new ChildHolder();
			cv.childText = (TextView) arg3.findViewById(R.id.questionnaire01);
			cv.childRb = (RadioButton) arg3.findViewById(R.id.radio01);
			arg3.setTag(cv);
		}else{
			cv = (ChildHolder) arg3.getTag();
		}
		
		////TextView question = (TextView) arg3.findViewById(R.id.question);
		//RadioButton rb = (RadioButton) arg3.findViewById(R.id.radioButton1);
		
		cv.childText.setText(((char)(arg1 + 'a')+". ")+q.getQuestion());
		cv.childRb.setChecked(q.isChecked());

		final int index_header = arg0;
		final int index_questions = arg1;
		final Context mContext = this._context;

		
		cv.childRb.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, arg0.toString() + "=" + arg1, Toast.LENGTH_SHORT).show();
				Log.v("index of questions",index_questions+"");
				for(int i =0;i<4;i++){
					if(i==index_questions){
						((Questions)getChild(index_header , index_questions)).setChecked(arg1);
					}
					else
						((Questions)getChild(index_header , index_questions)).setChecked(false);
				}
				arg0.setChecked(arg1);
				
				//qNew.get(index_questions).setChecked(arg1);
			}
			
		});
	
		
		return arg3;
	}
	class ChildHolder{
		TextView childText;
		RadioButton childRb;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		ArrayList<Questions> q = questionnaire.get(arg0).getQuestions();
		return q.size();
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return questionnaire.get(arg0);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return questionnaire.size();
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		// TODO Auto-generated method stub
		QuestionHeader question = (QuestionHeader) getGroup(arg0);
		if (arg2==null){
			arg2 = inflater.inflate(R.layout.group_row, null);
			
		}
		
		TextView questions = (TextView) arg2.findViewById(R.id.heading_row);
		questions.setText((arg0+1)+". "+question.getHeader());
		
		
		
		return arg2;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}


}
