package ai;

import java.util.ArrayList;

import interfaces.IUnoCard;
import resources.Color;

public class CalculatePopularColor {

	private final String BLUE = "BLUE";
	private final String YELLOW = "YELLOW";
	private final String RED = "RED";
	private final String GREEN = "GREEN";
	
	public Color mostAppeared(ArrayList<IUnoCard> cards)
	{
		int blueCount = 0;
		int greenCount = 0;
		int redCount = 0;
		int yellowCount = 0;
		
		for (IUnoCard card : cards)
		{
			switch (card.getColor().toString())
			{			
			case BLUE: 
				++blueCount;
				break;
			case YELLOW:
				++yellowCount;
				break;
			case GREEN:
				++greenCount;
				break;
			case RED:
				++redCount;
				break;
			}
		}
		
		int[] counts = {blueCount, yellowCount, greenCount, redCount};
        int largest = counts[0];
       
        for (int i= 1; i < counts.length; i++)
        {
            if(counts[i] > largest)
            {
                largest = counts[i];	
            }               
        }
     
        if (largest == blueCount)
        {
        	return Color.BLUE;
        }
        else if (largest == yellowCount)
        {
        	return Color.YELLOW;
        }
        else if (largest == greenCount)
        {
        	return Color.GREEN;
        }
        else if (largest == redCount)
        {
        	return Color.RED;
        }
        else
        {
    		return null;
        }
	}
}
