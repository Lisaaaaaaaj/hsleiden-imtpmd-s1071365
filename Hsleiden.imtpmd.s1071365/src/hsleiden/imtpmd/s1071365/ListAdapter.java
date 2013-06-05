package hsleiden.imtpmd.s1071365;

import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Klasse ListAdapter
 * @author Lisa Uiterwijk
 * @version 1.0
 *
 */

public class ListAdapter extends BaseAdapter
{
	//de lijst met de items
	//wordt gevuld in een andere klasse, in deze klasse voor uitlezen
	
	private ArrayList<ListItem> al;
	
	/**
	 * constructor
	 * @param al  item uit ArrayList wordt eruit gehaald
	 */
	
	//constructor	
	public ListAdapter(ArrayList<ListItem> al)
	{
		//bestaande arraylist om data eruit te halen, uit de lijst
		this.al = al;
	}	
	
	/**
	 * @return  stuurt al.size() terug
	 */
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		//het aantal objecten dat in de itemArrayList staan wordt terug gegeven
		return al.size();
	}
	
	/**
	 * @return  stuurt al.get(arg0) terug
	 */

	@Override
	public Object getItem(int arg0)
	{
		// TODO Auto-generated method stub
		//item wordt teruggegeven naar de gevraagde positie in de ArrayList 
		//nu is het item 'arg0'
		return al.get(arg0);
	}

	
	/**
	 * @return  stuurt arg0 terug
	 */
	
	@Override
	public long getItemId(int arg0)
	{
		//index wordt teruggeven op de gevraagde positie in de ArrayList
		//'arg0' == index ArrayList
		return arg0;
	}

	/**
	 * @param arg0  positie van arg0 wordt doorgegeven
	 * @param arg1  positie van arg1 wordt doorgegeven
	 * @param arg2  positie van arg2 wordt doorgegeven
	 * de methode View getView regelt dat de juiste items op de juiste plek komen te staan, en gevuld 
	 * (text en check)
	 */
	
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2)
	{
		// TODO Auto-generated method stub
		//arg1 controleert of er al een bestaande listview is
		if (arg1 == null)
		{
			//nieuw item wordt aangemaakt als de listvieuw nog niet bestaat
			//de arg2.getContext wordt als inflater gebruikt
			LayoutInflater li = LayoutInflater.from(arg2.getContext());
			arg1 = li.inflate(R.layout.listview_items, arg2, false);
		}
		
		//item wordt aan de meegegeven positie getoond, d.m.v. het uit de lijst te halen
		ListItem item = (ListItem) getItem(arg0);
		
		//d.m.v. deze code worden de interface van de Checkbox en Textview gevonden
		//hierdoor is bekend waar de check en naam van item in moeten komen
		TextView tv = (TextView) arg1.findViewById(R.id.itemNaam);
		
		//textView wordt ingevuld met naam item
		tv.setText(item.getName());
		
		return arg1;
	}

}
