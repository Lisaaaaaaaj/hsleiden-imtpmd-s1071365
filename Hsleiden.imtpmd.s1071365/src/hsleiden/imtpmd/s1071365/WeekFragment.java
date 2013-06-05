package hsleiden.imtpmd.s1071365;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import android.app.LauncherActivity.ListItem; //importeerde hij mee, maar gaf foutmelding bij het aanmaken 
												//bij regel 41 t/m 49
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Klasse WeekFragment
 * @author Lisa Uiterwijk
 * @version 1.0
 *
 */

public class WeekFragment extends Fragment
{
	public JSONObject jsonO;
	
	/**
	 * constructor
	 */
	
	public WeekFragment()
	{
		//moet bestaan, maar wordt niet gebruikt
	}
	
	/**
	 * methode die ervoor zorgt dat de klasse gecreëerd kan worden ( gelijk aan main(String args[]) )
	 */
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	
	/**
	 * @param inhoud ly wordt doorgegeven
	 * @param vg  inhoud vg wordt doorgegeven
	 * @param sis  inhoud sis wordt doorgegeven
	 * @return  rv wordt teruggegeven
	 * de arraylist wordt hier aangemaakt en gevuld i.c.m de klasse ListItem en ListAdapter
	 */
	
	public View onCreateView(LayoutInflater ly, ViewGroup vg, Bundle sis)
	{
		View rv = ly.inflate(R.layout.fragment_main_week, vg, false);
		ListView lv = (ListView) rv.findViewById(R.id.listView01);
		
		//nieuwe ArrayList aanmaken en staat in connectie met de klasse ListItem
		ArrayList<ListItem> al = new ArrayList<ListItem>();
		
		// het vullen van de ArrayList
		
		al.add(new ListItem(1, "Week 1"));
		al.add(new ListItem(2, "Week 2"));
		al.add(new ListItem(3, "Week 3"));
		al.add(new ListItem(4, "Week 4"));
		al.add(new ListItem(5, "Week 5"));
		al.add(new ListItem(6, "Week 6"));
		al.add(new ListItem(7, "Week 7")); 
		
		ListAdapter la = new ListAdapter(al);
		lv.setAdapter(la);
		
		return rv;
	}
	
	/**
	 * 
	 * @param reply  de positie van reply wordt doorgegeven
	 * nieuw JSONObject i.c.m. de reply wordt aangemaakt
	 */

	public void shareData(String reply)
	{
		// TODO Auto-generated method stub
		jsonO = null;
		
		try
		{
			jsonO = new JSONObject(reply);
			JSONArray JSONopdracht = jsonO.getJSONArray("opdracht");
			Log.d("json", JSONopdracht.toString());
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
	}
}
