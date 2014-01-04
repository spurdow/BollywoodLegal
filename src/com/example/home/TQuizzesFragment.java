package com.example.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.Questionnaire.MyQuestionListAdapter;
import com.example.Questionnaire.MyQuestionnaireAdapter;
import com.example.Questionnaire.QuestionAdapter;
import com.example.Questionnaire.QuestionHeader;
import com.example.Questionnaire.Questions;
import com.example.bollywoodlegal.MainActivity;
import com.example.bollywoodlegal.R;
import com.example.titleheaders.TabContent;
import com.example.titleheaders.TitlesAndContents;

public class TQuizzesFragment extends SherlockFragment implements  OnItemClickListener {
 
	private TitlesAndContents data;
	
	//private ExpandableListView expView;
	private ListView expView;
	
	private MyQuestionListAdapter adapter;
	
	protected ArrayList<QuestionHeader> master_list;
	
	private int pos;
	
	private ProgressDialog pDialog;
	
	// if error is about nullpointer exception input stream then the problem would be the address or connection 
	protected static String URL = "http://192.168.0.100/aip/androidquiz/";
	
	protected final static String TAG_ID = "id";
	
	protected final static String TAG_QUESTION = "question";
	
	protected final static String TAG_ANSWER = "answer";

	protected final static String TAG_A = "selection_a";
	
	protected final static String TAG_B = "selection_b";
	
	protected final static String TAG_C = "selection_c";
	
	protected final static String TAG_D = "selection_d";
	
	public TQuizzesFragment(){}




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
		
		LinearLayout lv =  (LinearLayout) inflater.inflate(R.layout.list_view_layout,container,false);
		expView = (ListView) lv.findViewById(R.id.list);
		//expView.setGroupIndicator(null);
		//expView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		 master_list = new ArrayList<QuestionHeader>();
		adapter = new MyQuestionListAdapter(getActivity() , master_list);
		new GetQuestionnaire(pos).execute(URL);

		expView.setAdapter(adapter);
		//this.registerForContextMenu(expView);
		expView.setOnItemClickListener(this);
		return lv;
		
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		QuestionHeader header = ((QuestionHeader)adapter.getItem(arg2));
		ArrayList<Questions> questions =  header.getQuestions();
		AlertDialog.Builder builder = new AlertDialog.Builder((MainActivity)getActivity());/*
		LayoutInflater inflater = ((MainActivity)getActivity()).getLayoutInflater();
		ScrollView layout = (ScrollView) inflater.inflate(R.layout.child_row, null);

		//MyQuestionListAdapter mqa = ((MyQuestionListAdapter)arg0).getItem(arg2);
		
		
		TextView header_txtV = (TextView) layout.findViewById(R.id.header_txtView);
		header_txtV.setText(header.getHeader());
		
		TextView q1 = (TextView) layout.findViewById(R.id.questionnaire01);
		q1.setText(questions.get(0).getQuestion());
		TextView q2 = (TextView) layout.findViewById(R.id.questionnaire02);
		q2.setText(questions.get(1).getQuestion());
		TextView q3 = (TextView) layout.findViewById(R.id.questionnaire03);
		q3.setText(questions.get(2).getQuestion());
		TextView q4 = (TextView) layout.findViewById(R.id.questionnaire04);
		q4.setText(questions.get(3).getQuestion());*/
		//Log.v("arg2 - arg3" , arg2+ " " + arg3 );
		//q1.setText(adapter.getItem(arg2));
		
		//builder.setView(layout);
		builder.setTitle(header.getHeader());
		//SimpleAdapter sla = new SimpleAdapter(getActivity(),(List<? extends Map<String, ?>>) questions,0,new String[]{"",""},new int[]{0,1,2});
		
		//CharSequence[] cs = {questions.get(0).getQuestion() ,questions.get(1).getQuestion(),questions.get(2).getQuestion(),questions.get(3).getQuestion()};
		
		QuestionAdapter qAdapter = new QuestionAdapter(getActivity() , questions );
		ArrayAdapter<String> adapters = new ArrayAdapter<String>(getActivity() , android.R.layout.select_dialog_singlechoice);
		adapters.add(((Questions)qAdapter.getItem(0)).getQuestion());
		adapters.add(((Questions)qAdapter.getItem(1)).getQuestion());
		adapters.add(((Questions)qAdapter.getItem(2)).getQuestion());
		adapters.add(((Questions)qAdapter.getItem(3)).getQuestion());
		
		
		builder.setAdapter(adapters, new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Log.v("chose",which+"");
			}
			
			
		});
		
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // sign in the user ...
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //
            }
        }); 
		AlertDialog ad = builder.create();
		//TextView tv = ad.findViewById(android.R.id.te)
		
		
		ad.show();
	}

	
	
		
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onContextItemSelected(item);
	}




	private class GetQuestionnaire extends AsyncTask<String , String , String>{
		
		private JSONArray jsonArray;
		private int pos;
		private ArrayList<QuestionHeader> list;
		public GetQuestionnaire(int pos){
			this.pos = pos;
			this.list = new ArrayList<QuestionHeader>();
			this.jsonArray = null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
		    pDialog = new ProgressDialog(((MainActivity)getActivity()));
			pDialog.setMessage("Retrieving data...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			String result = "";
			InputStream is  = null;
			switch(pos){
			case 0 : arg0[0]+="basic"; break;
			case 1 : arg0[0]+="buying";break;
			case 2 : arg0[0]+="selling";break;
			case 3 : arg0[0]+="both";break;
			}
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(arg0[0]);
			
			Log.v("httpPost" , arg0[0].toString());
			try {
				post.setEntity(new UrlEncodedFormEntity(new ArrayList<NameValuePair>()));

			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			
			is = entity.getContent();
					
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is , "iso-8859-1") , 8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine())!=null){
					sb.append(line+"\n");
				}
				is.close();
				result = sb.toString();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parseStringBuilder(result);
			
			
			return result;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub

			pDialog.dismiss();
			for(int i = 0;i<list.size();i++ ){
				adapter.addData(list.get(i));
			}
			super.onPostExecute(result);
		}
		
		private void parseStringBuilder(String b){
			
				try {
					jsonArray = new JSONArray(b);
					JSONObject jsonObject = null;
					
					for(int i =0;i<jsonArray.length();i++){
						jsonObject = jsonArray.getJSONObject(i);
						int id = jsonObject.getInt(TAG_ID);
						String question = jsonObject.getString(TAG_QUESTION);
						String answer = jsonObject.getString(TAG_ANSWER);
						String s_a = jsonObject.getString(TAG_A);
						String s_b = jsonObject.getString(TAG_B);
						String s_c = jsonObject.getString(TAG_C);
						String s_d = jsonObject.getString(TAG_D);
						
						ArrayList<Questions> q = new ArrayList<Questions>();
						//RadioButton rb = new RadioButton(((MainActivity)getActivity()));
						q.add(new Questions(s_a , false , new RadioButton(((MainActivity)getActivity()))));
						q.add(new Questions(s_b , false , new RadioButton(((MainActivity)getActivity()))));
						q.add(new Questions(s_c , false , new RadioButton(((MainActivity)getActivity()))));
						q.add(new Questions(s_d , false , new RadioButton(((MainActivity)getActivity()))));
						
						
						QuestionHeader header = new QuestionHeader(question , q);
						
						list.add(header);
					}
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
	}




}
