package com.example.bollywoodlegal;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.CustomViewAbove;
import com.slidingmenu.lib.CustomViewBehind;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

public class MainActivity extends SlidingFragmentActivity {

	private SlidingMenu menu;
	private MenuFragment mFrag;
	private SherlockFragment cFrag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null){
			savedInstanceState.remove ("android:support:fragments");
			cFrag = (SherlockFragment) this.getSupportFragmentManager()
					.getFragment(savedInstanceState, "cFrag");

		}
		if (cFrag == null)
			cFrag = new HomeFragment();

		setContentView(R.layout.content_frame);
		this.getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, cFrag, "aboveView").commit();

		// set the Behind View
		setBehindContentView(R.layout.menu_frame);

		mFrag = new MenuFragment();
		this.getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, mFrag).commit();

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayUseLogoEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, "Pressed", Toast.LENGTH_SHORT).show();
			toggle();
		}
		return super.onOptionsItemSelected(item);
	}

	public void switchContent(SherlockFragment newFragment) {
		if (getSupportActionBar().getTabCount() > 0) {
			getSupportActionBar().removeAllTabs();
			getSupportActionBar().setNavigationMode(
					ActionBar.NAVIGATION_MODE_STANDARD);
		}
		String tag = "";

		SherlockFragment fragment = null;
		if (newFragment instanceof HomeFragment) {
			fragment = (HomeFragment) newFragment;
			tag = "home";
		} else if (newFragment instanceof StudiesFragment) {
			fragment = (StudiesFragment) newFragment;
			tag = "studies";
		} else if (newFragment instanceof QuizzesFragment) {
			fragment = (QuizzesFragment) newFragment;
			tag = "quizzes";
		} else if (newFragment instanceof FaqFragment) {
			fragment = (FaqFragment) newFragment;
			tag = "faq";
		} else if (newFragment instanceof ContactFragment) {
			fragment = (ContactFragment) newFragment;
			tag = "contact";
		}
		else if(newFragment instanceof TakeQuiz){
			fragment = (TakeQuiz) newFragment;
			tag = "takequiz";
		}

		if (fragment != null) {
			toggle();


			getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment, tag).commit();
			getSlidingMenu().showContent();


		}
	}
	
	


}
