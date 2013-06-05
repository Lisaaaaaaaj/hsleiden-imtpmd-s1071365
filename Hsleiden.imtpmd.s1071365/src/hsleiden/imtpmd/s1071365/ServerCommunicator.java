package hsleiden.imtpmd.s1071365;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Klasse ServerCommunicator
 * @author Lisa Uiterwijk
 * @version 1.0
 *
 */

public class ServerCommunicator implements Runnable
{

	private SettingsFragment sf;
	private Thread draad;
	private String name;
	private String question;
	private String ip_adres;
	private int poort;
	private String reply = null;
	
	public ServerCommunicator(SettingsFragment sf, String name, String question, String ip_adres, int poort)
	{
		//updaten van userinterface door gebruik van activiteit
		this.sf = sf;
		
		//gegevens voor versturen message en verbinden naar server
		this.setNaam(name);
		this.question = question;
		this.ip_adres = ip_adres;
		this.poort = poort;
		
		//thread aanmaken en verzenden en ontvangen naar en door de server
		this.draad = new Thread(this);
		this.draad.start();
	}
	
	//run methode aangeroepen door eigen thread 
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		try
		{
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(this.ip_adres, this.poort), 4000);
			
			//bericht wordt verzonden naar server
			this.stuurBericht(this.question, socket);
			
			//wacht op reply
			this.reply = waitForResponse(socket);
		}
		catch (UnknownHostException e) //catch methode als host niet gevonden kan worden
		{
			Log.d("debug", "host kan niet gevonden worden");
		}
		catch (SocketTimeoutException e) //catch methode als er een time-out optreed
		{
			Log.d("debug", "time-out treedt op");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.sf.setReceivedServerMessage(reply);
	}
	
	public void stuurBericht(String bericht, Socket socket)
	{
		OutputStreamWriter osw = null;
		
		try
		{
			osw = new OutputStreamWriter(socket.getOutputStream());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (osw != null)
		{
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw, true);
			
			pw.println(bericht);
			
		}
	}
	
	//bericht server
	public String waitForResponse(Socket socket)
	{
		String bericht2 = null; // bericht van de server != verstuurde bericht, daarom variabele bericht2
		BufferedReader br = null;
		
		try
		{
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (br != null)
		{
			try
			{
				bericht2 = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return bericht2;
		
	}
	
	public void setNaam(String name)
	{
		this.name = name;
	}
	
	public String getNaam()
	{
		return name;
	}

	
}
