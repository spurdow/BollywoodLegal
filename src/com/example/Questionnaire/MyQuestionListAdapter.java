package com.example.Questionnaire;

import java.util.ArrayList;

import com.example.bollywoodlegal.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyQuestionListAdapter extends BaseAdapter {

	private Context _context;
	private ArrayList<QuestionHeader> qHeader;
	private LayoutInflater inflater;
	
	
	
	public MyQuestionListAdapter(Context _context,
			ArrayList<QuestionHeader> qHeader) {
		super();
		this._context = _context;
		this.qHeader = qHeader;
		this.inflater = LayoutInflater.from(_context);
	}

	public void addData(QuestionHeader qH){
		qHeader.add(qH);
		this.notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return qHeader.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return qHeader.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		HeaderHolder holder = null;
		if(arg1==null){
			arg1 = inflater.inflate(R.layout.group_row, null); 
			holder = new HeaderHolder();
			holder.header = (TextView) arg1.findViewById(R.id.heading_row);
			arg1.setTag(holder);
		}else{
			holder = (HeaderHolder) arg1.getTag();
		}
		
		holder.header.setText((arg0+1)+". " + qHeader.get(arg0).getHeader());
		
		return arg1;
	}
	
	class HeaderHolder{
		TextView header;
	}

}
