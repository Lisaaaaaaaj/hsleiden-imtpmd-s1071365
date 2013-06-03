package hsleiden.imtpmd.s1071365;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter
{
	//in deze klasse wordt een lijst bijgehouden met alle fragments
	private ArrayList<Fragment> fl;

	public PagerAdapter(FragmentManager fm, List<Fragment> fl)
	{
		super(fm);
		// TODO Auto-generated constructor stub
		//het aanmaken van een nieuwe ArrayList
		this.fl = (ArrayList<Fragment>) fl;
	}

	//wordt aangeroepen wanneer tabwidget fragment wil tonen vanuit index
	@Override
	public Fragment getItem(int arg0)
	{
		// TODO Auto-generated method stub
		//fragment wordt terug gegeven in de lijst op juiste index
		return fl.get(arg0);
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		//grootte lijst wordt terug gegeven
		return fl.size();
	}

}
