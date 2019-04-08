package resources;

import interfaces.IUnoCard;

public class UnoCard implements IUnoCard {

	protected String cardDescription;
	protected Color cardColor;
	
	public UnoCard(String c, Color color) 
	{
		this.cardDescription = c;
		this.cardColor = color;
	}

	@Override
	public Color getColor() 
	{
		return cardColor;
	}

	@Override
	public String getDescription() 
	{
		return cardDescription;
	}

	@Override
	public String cardLabel() 
	{
		try
		{
			return cardDescription + " " + cardColor.toString();
		}
		catch (NullPointerException n)
		{
			return cardDescription;
		}
	}
}