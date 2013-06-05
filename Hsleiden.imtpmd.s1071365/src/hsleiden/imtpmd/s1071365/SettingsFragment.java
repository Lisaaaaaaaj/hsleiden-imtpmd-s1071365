package hsleiden.imtpmd.s1071365;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment; // deze i.p.v. android.v4.app.Fragment anders  
// fl.add(settingsFragment); in de klasse SettingsFragment niet goed

/**
 * Klasse SettingsFragment
 * @author Lisa Uiterwijk
 * @version 1.0
 *
 */

public class SettingsFragment extends Fragment implements OnClickListener
{

	public View rv; 
	private ServerCommunicator sc;
	
	public SettingsFragment()
	{
		//moet bestaan, maar wordt niet gebruikt
	}
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater ly, ViewGroup vg, Bundle sis)
	{
		rv = ly.inflate(R.layout.fragment_main_settings, vg, false);
		
		Button bt = (Button) rv.findViewById(R.id.buttonverzend);
		bt.setOnClickListener(this);
		
		return rv;
		
	}
	
	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		//gegevens uit de UI halen
		EditText editTxtNaam = (EditText) rv.findViewById(R.id.edittxtnaam);
		String name = editTxtNaam.getText().toString();
		
		EditText editTxtVraag = (EditText) rv.findViewById(R.id.edittxtvraag);
		String question = editTxtVraag.getText().toString();
		
		EditText editTxtIp = (EditText) rv.findViewById(R.id.edittxtip);
		String ipAdres = editTxtIp.getText().toString();
		
		EditText editTxtPort = (EditText) rv.findViewById(R.id.edittxtport);
		int poort = Integer.parseInt(editTxtPort.getText().toString());
		
		//nieuwe verbinding maken met de server
		this.setSc(new ServerCommunicator(this, name, question, ipAdres, poort));		
		
	}

	public ServerCommunicator getSc()
	{
		return sc;
	}

	public void setSc(ServerCommunicator sc)
	{
		this.sc = sc;
	}

	public void setReceivedServerMessage(String reply)
	{
		// TODO Auto-generated method stub
		((MainActivity) getActivity()).shareData(reply);
	}

}
