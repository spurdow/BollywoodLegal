package com.example.titleheaders;

import java.util.ArrayList;

import android.graphics.Bitmap;

public class TabContent {

		private String _tab;
		private Bitmap _image;
		private String _strContent;
		private ArrayList<String> _contents;
		public ArrayList<String> get_contents() {
			return _contents;
		}
		public void set_contents(ArrayList<String> _contents) {
			this._contents = _contents;
		}
		public Bitmap get_image() {
			return _image;
		}
		public void set_image(Bitmap _image) {
			this._image = _image;
		}
		public String get_tab() {
			return _tab;
		}
		public void set_tab(String _tab) {
			this._tab = _tab;
		}
		public String get_strContent() {
			return _strContent;
		}
		public void set_strContent(String _strContent) {
			this._strContent = _strContent;
		}
		public TabContent(String _tab, String _strContent) {
			super();
			this._tab = _tab;
			this._strContent = _strContent;
		}
		
		public TabContent(String _tab ,ArrayList<String> _contents){
			super();
			this._tab = _tab;
			this._contents = _contents;
		}
		

}
