package com.example.connectionDetector;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {
	
	private Context _mContext;
	
	public ConnectionDetector(Context _mContext){
		this._mContext = _mContext;
	}
	
	public boolean isConnectingorConnected(){
		ConnectivityManager con  = (ConnectivityManager) _mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		
		if(con!=null){
			NetworkInfo[] info = con.getAllNetworkInfo();
			if(info!=null){
				for(int i =0;i<info.length;i++){
					if(info[i].getState()==NetworkInfo.State.CONNECTED || info[i].getState()==NetworkInfo.State.CONNECTING){
						return true;
					}
					
				}
			}
		}
		return false;
	}
	
	
	public void showDialog(String title ,String message ,  boolean status){
        AlertDialog alertDialog = new AlertDialog.Builder(_mContext).create();
        
        // Setting Dialog Title
        alertDialog.setTitle(title);
 
        // Setting Dialog Message
        alertDialog.setMessage(message);
 
        // Setting alert dialog icon
        //alertDialog.setIcon((status) ? android.R.drawable. : R.drawable.fail);
 
        // Setting OK Button
        
 
        // Showing Alert Message
        alertDialog.show();
	}
	
}
