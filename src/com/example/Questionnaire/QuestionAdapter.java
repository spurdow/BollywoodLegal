package com.example.Questionnaire;

import java.util.ArrayList;

import com.example.bollywoodlegal.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionAdapter extends BaseAdapter {
	
	private Context _context;
	private ArrayList<Questions> questions;
	private LayoutInflater inflater;

	
	public QuestionAdapter(Context _context, ArrayList<Questions> questions) {
		super();
		this._context = _context;
		this.questions = questions;
		this.inflater = LayoutInflater.from(_context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return questions.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return questions.get(position);
	}
	
	public void notifyData(){
		this.notifyDataSetChanged();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ViewHolder holder = null;
		if (convertView == null){
			convertView = inflater.inflate(R.layout.new_row , null);
			holder = new ViewHolder();
			holder.q = (TextView) convertView.findViewById(R.id.new_q);
			holder.rb = questions.get(position).getRb();
			holder.rb.setId(R.id.new_rb);
			
			
			convertView.setTag(holder);
			
		}else
			holder = (ViewHolder) convertView.getTag();
		
		holder.q.setText(this.questions.get(position).getQuestion());
		holder.rb.setChecked(this.questions.get(position).isChecked());
		
		final int pos = position;
		holder.rb.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				Log.v(arg0.getTag()+"",arg1+"");
				questions.get(pos).setChecked(arg1);
				notifyDataSetChanged();
			}
			
		});
		return convertView;
	}
	
	class ViewHolder{
		TextView q;
		RadioButton rb;
	}

}
