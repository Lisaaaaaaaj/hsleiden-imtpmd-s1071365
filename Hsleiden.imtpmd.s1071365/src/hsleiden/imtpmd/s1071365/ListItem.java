package hsleiden.imtpmd.s1071365;

public class ListItem
{
	public int identity;
	private String name;
	
	public ListItem(int identity, String name)
	{
		//de identiteit en de naam van het item (de week)
		this.identity = identity;
		this.name = name;
	}
	
	public int getIdentity()
	{
		return identity; //geeft de identiteit terug
	}
	
	public String getName()
	{
		return name; //geeft de naam terug
	}
	
	public void setIdentity(int identity)
	{
		this.identity = identity; //bepaalt de identiteit
	}
	
	public void setName(String name)
	{
		this.name = name; //bepaalt de naam
	}
		
}
