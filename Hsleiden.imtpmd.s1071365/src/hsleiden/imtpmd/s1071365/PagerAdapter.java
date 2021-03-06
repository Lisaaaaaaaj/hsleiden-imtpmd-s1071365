package hsleiden.imtpmd.s1071365;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Klasse PagerAdapter
 * @author Lisa Uiterwijk
 * @version 1.0
 *
 */

public class PagerAdapter extends FragmentPagerAdapter
{
	//in deze klasse wordt een lijst bijgehouden met alle fragments
	private ArrayList<Fragment> fl;
	
	/**
	 * constructor
	 * @param fm  de positie van fm wordt doorgegeven
	 * @param fl  de positie van fl wordt doorgegeven
	 * het aanmaken van de ArrayList gebeurd hier
	 */

	public PagerAdapter(FragmentManager fm, List<Fragment> fl)
	{
		super(fm);
		// TODO Auto-generated constructor stub
		//het aanmaken van een nieuwe ArrayList
		this.fl = (ArrayList<Fragment>) fl;
	}
	
	/**
	 * @param arg0  de positie van arg0 wordt doorgegeven
	 * @return  fl.get(arg0) wordt teruggegeven
	 */

	//wordt aangeroepen wanneer tabwidget fragment wil tonen vanuit index
	@Override
	public Fragment getItem(int arg0)
	{
		// TODO Auto-generated method stub
		//fragment wordt terug gegeven in de lijst op juiste index
		return fl.get(arg0);
	}

	/**
	 * @return  fl.size() wordt teruggegeven
	 */
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		//grootte lijst wordt terug gegeven
		return fl.size();
	}

}
