package hsleiden.imtpmd.s1071365;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

/**
 * Klasse MainActivity - Opstartklasse
 * @author Lisa Uiterwijk
 * @version 1.0
 *
 */

public class MainActivity extends FragmentActivity implements ActionBar.TabListener
{
	SettingsFragment settingsFragment;
	WeekFragment weekFragment;
	PagerAdapter pagerAdapter;
	ViewPager viewPager;
	
	public void onCreate(Bundle savedInstanceState) //van protected public gemaakt
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//opstellen van de actionbar
		final ActionBar ab = getActionBar();
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		//fragments worden hier aangemaakt a.d.h.v. een eigen adapter
		//data en interface worden aan elkaar gekoppeld door de klasse PagerAdapter
		List <Fragment> fl = new ArrayList<Fragment>();
		this.settingsFragment = new SettingsFragment();
		fl.add(settingsFragment);
		this.weekFragment = new WeekFragment();
		fl.add(weekFragment);
		
		pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fl);
		
		//viewpager toont fragments op scherm, gekoppeld aan PagerAdapter
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(pagerAdapter);
		
		/*//door de OnpageListener worden de tabs verwisseld d.m.v. swipe
		//de OnPageListener is een onderdeel van de viewPager
		viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
		{
			public void onPageSelected(int positie)
			{
				ab.setSelectedNavigationItem(positie);
			}
		}
		);*/ //code zou het balkje mee moeten verschuiven naar de tab waarnaar geswiped word, maar werkt niet
		
		//het instellen van de tabbladen, waartussen gewisseld kan worden
		Tab settingsFragment = ab.newTab();
		settingsFragment.setText("Settings Tab");
		settingsFragment.setTabListener(this);
		ab.addTab(settingsFragment);
		
		Tab weekFragment = ab.newTab();
		weekFragment.setText("Week Tab");
		weekFragment.setTabListener(this);
		ab.addTab(settingsFragment);
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		//voegt items toe aan de actionbar als het moet
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void shareData(String reply)
	{
		// TODO Auto-generated method stub
		weekFragment.shareData(reply);
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
	{
		// TODO Auto-generated method stub
		
	}

}
