package com.example.Questionnaire;

import android.widget.RadioButton;

public class Questions {

		private String question;
		private boolean isChecked;
		private RadioButton rb;

		/**
		 * @param question
		 */
		public Questions(String question , boolean isChecked , RadioButton rb) {
			super();
			this.question = question;
			this.isChecked = isChecked;
			this.rb = rb;
		}
		
		public Questions(String question , boolean isChecked){
			this(question , isChecked , null);
		}

		public RadioButton getRb() {
			return rb;
		}

		public void setRb(RadioButton rb) {
			this.rb = rb;
		}

		/**
		 * @return the isChecked
		 */
		public boolean isChecked() {
			return isChecked;
		}

		/**
		 * @param isChecked the isChecked to set
		 */
		public void setChecked(boolean isChecked) {
			this.isChecked = isChecked;
		}

		/**
		 * @return the question
		 */
		public String getQuestion() {
			return question;
		}

		/**
		 * @param question the question to set
		 */
		public void setQuestion(String question) {
			this.question = question;
		}
		
		
}
