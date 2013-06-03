package hsleiden.imtpmd.s1071365;

import java.util.ArrayList;

import org.json.JSONObject;

import android.app.LauncherActivity.ListItem;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class WeekFragment extends Fragment
{
	public JSONObject jsonO;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	
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
		
		return rv;
	}
}
