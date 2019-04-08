package resources;

import interfaces.IUnoCard;

public class ImageFinder {

	private final String BLUE = "BLUE";
	private final String YELLOW = "YELLOW";
	private final String RED = "RED";
	private final String GREEN = "GREEN";
	
	public String cardImagePath(IUnoCard card)
	{
		String imageFolderPath = null;
		
		if (!card.getColor().equals(Color.NULL))
		{
			switch (card.getColor().toString())
			{			
			case BLUE: 
				imageFolderPath = "/blue/";
				break;
			case YELLOW:
				imageFolderPath = "/yellow/";
				break;
			case GREEN:
				imageFolderPath = "/green/";
				break;
			case RED:
				imageFolderPath = "/red/";
				break;
			}
		}
		else
		{
			imageFolderPath = "/special/";
		}
		
		return imageFolderPath + card.getDescription() + ".png";
	}
}
