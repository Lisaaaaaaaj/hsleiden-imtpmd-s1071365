package hsleiden.imtpmd.s1071365;

/**
 * Klasse ListItem
 * @author Lisa Uiterwijk
 * @version 1.0
 *
 */

public class ListItem
{
	public int identity;
	private String name;
	
	/**
	 * constructor
	 * @param identity   positie van identity wordt doorgegeven
	 * @param name	positie van name wordt doorgegeven
	 */
	
	public ListItem(int identity, String name)
	{
		//de identiteit en de naam van het item (de week)
		this.identity = identity;
		this.name = name;
	}
	
	/**
	 * 
	 * @return	geeft de identity terug
	 */
	
	public int getIdentity()
	{
		return identity; //geeft de identiteit terug
	}
	
	/**
	 * 
	 * @return	geeft de naam terug
	 */
	
	public String getName()
	{
		return name; //geeft de naam terug
	}
	
	/**
	 * 
	 * @param identity	stelt de identiteit in
	 */
	
	public void setIdentity(int identity)
	{
		this.identity = identity; //bepaalt de identiteit
	}
	
	/**
	 * 
	 * @param name	stelt de naam in
	 */
	
	public void setName(String name)
	{
		this.name = name; //bepaalt de naam
	}
		
}
