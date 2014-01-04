package com.example.Questionnaire;

import java.util.ArrayList;

public class QuestionHeader {
	
	private String header; // this is the question
	public QuestionHeader(String header, String answer,
			ArrayList<Questions> questions) {
		super();
		this.header = header;
		this.answer = answer;
		this.questions = questions;
	}
	private String answer;
	private ArrayList<Questions> questions;
	/**
	 * @param header
	 * @param questions
	 */
	public QuestionHeader(String header, ArrayList<Questions> questions) {
		this(header,"",questions);
	}
	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	/**
	 * @return the questions
	 */
	public ArrayList<Questions> getQuestions() {
		return questions;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(ArrayList<Questions> questions) {
		this.questions = questions;
	}
	

	
}
