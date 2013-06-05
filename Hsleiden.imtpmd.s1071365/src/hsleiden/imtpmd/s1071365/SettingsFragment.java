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
	
	/**
	 * constructor
	 */
	
	public SettingsFragment()
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
	 * @param ly  inhoud ly wordt doorgegeven
	 * @param vg  inhoud vg wordt doorgegeven
	 * @param sis  inhoud sis wordt doorgegeven
	 * @return  rv wordt teruggegeven 
	 */
	
	public View onCreateView(LayoutInflater ly, ViewGroup vg, Bundle sis)
	{
		rv = ly.inflate(R.layout.fragment_main_settings, vg, false);
		
		Button bt = (Button) rv.findViewById(R.id.buttonverzend);
		bt.setOnClickListener(this);
		
		return rv;
		
	}
	
	/**
	 * @param arg0  positie arg0 wordt doorgegeven
	 * methode die ervoor zorgt dat de juiste inhoud op de juiste plek komt te staan binnen het fragment
	 * en als er geklikt wordt, dit goed verwerkt word i.c.m. de ServerCommunicator 
	 */
	
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
	
	/**
	 * 
	 * @return  sc wordt terugggegeven
	 */

	public ServerCommunicator getSc()
	{
		return sc;
	}

	/**
	 * 
	 * @param sc  de sc wordt ingesteld
	 */
	
	public void setSc(ServerCommunicator sc)
	{
		this.sc = sc;
	}
	
	/**
	 * 
	 * @param reply  de ontvangen server message wordt ingesteld i.c.m. MainActivity
	 */

	public void setReceivedServerMessage(String reply)
	{
		// TODO Auto-generated method stub
		((MainActivity) getActivity()).shareData(reply);
	}

}
