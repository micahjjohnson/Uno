package resources;

import java.util.ArrayList;
import java.util.Collections;

import interfaces.IUnoCard;

public class CardDeck {

	private ArrayList<IUnoCard> cardDeck;
	
	public CardDeck()
	{
		cardDeck = new ArrayList<>();	
		initDeck();
	}
	
	private void initDeck()
	{	
		ArrayList<Color> colorValues = new ArrayList<>();
		colorValues.add(Color.BLUE);
		colorValues.add(Color.YELLOW);
		colorValues.add(Color.RED);
		colorValues.add(Color.GREEN);
		
		for (Color color : colorValues)
		{
			for (int c = 0; c < 1; c++)
			{
				IUnoCard card = new UnoCard(Integer.toString(c), color);
				cardDeck.add(card);
			}
		}
		
		for (int x = 0; x < 2; x ++){
			for (Color color : colorValues)
			{
				for (int c = 1; c < 10; c++)
				{
					IUnoCard card = new UnoCard(Integer.toString(c), color);
					cardDeck.add(card);
				}
				
				String[] specialCardLbls = {"SKIP", "REVERSE", "DRAW TWO"};		

				for (String lbl : specialCardLbls)
				{
					IUnoCard card = new SpecialUnoCard(lbl, color);
					cardDeck.add(card);
				}
			}
		}
		
		String[] colorChangeCardLbls = {"WILD", "DRAW FOUR"};	
		for (String lbl : colorChangeCardLbls)
		{
			for (int s = 0; s < 4; s++)
			{
				IUnoCard card = new SpecialUnoCard(lbl, Color.NULL);
				cardDeck.add(card);
			}
		}
	}
	
	public IUnoCard getTopCard()
	{ 
		return cardDeck.get(0); 
	}
	
	public IUnoCard getBottomCard() 
	{
		return cardDeck.get(cardDeck.size() - 1); 
	} 
	
	public int getDeckCount()
	{
		return cardDeck.size();
	}
	
	public ArrayList<IUnoCard> getDeck()
	{ 
		return cardDeck; 
	}
		
	public void remove(IUnoCard card) 
	{
		cardDeck.remove(card);
	}
	
	public void shuffle()
	{
        Collections.shuffle(cardDeck);
	}
}