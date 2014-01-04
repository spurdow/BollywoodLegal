package com.example.titleheaders;

import java.util.ArrayList;

public class TitlesAndContents {

	private String _title;
	private int _drawable;
	private int _color;
	private ArrayList<TabContent> _tabs;
	public TitlesAndContents(String _title, int _color,
			ArrayList<TabContent> _tabs) {
		super();
		this._title = _title;
		this._color = _color;
		this._tabs = _tabs;
	}
	public String get_title() {
		return _title;
	}
	public void set_title(String _title) {
		this._title = _title;
	}
	public int get_color() {
		return _color;
	}
	public void set_color(int _color) {
		this._color = _color;
	}
	public ArrayList<TabContent> get_tabs() {
		return _tabs;
	}
	public void set_tabs(ArrayList<TabContent> _tabs) {
		this._tabs = _tabs;
	}
	
	public int getTabSize(){
		return _tabs.size();
	}
	public TitlesAndContents(String _title) {
		super();
		this._title = _title;
	}
	public TitlesAndContents(String _title , int drawable){
		super();
		this._title = _title;
		this._drawable = drawable;
	}
	public int get_drawable() {
		return _drawable;
	}
	public void set_drawable(int _drawable) {
		this._drawable = _drawable;
	}
	
	
	
}
