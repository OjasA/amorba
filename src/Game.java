
public class Game {
	private String name;
	public Game(String theName)
	{
		if (theName.matches(" *"))
		{
			name = "Amoeba";
		}
		else
		{
			name = theName;	
		}
		System.out.println(name);
	}
}
