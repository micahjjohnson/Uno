package main;

import java.util.ArrayList;

import interfaces.IUnoCard;
import resources.CardDeck;
import resources.Color;
import resources.Player;

public class UnoGame {
	
	public CardDeck cardDeck;
	public ArrayList<IUnoCard> discardDeck;
	private ArrayList<Player> players;
	public boolean gameOver;
	public boolean playerTurn;
	public boolean playerPulled;
	public boolean colorSelected;
	public boolean colorSpecific;
	private Color allowedColor;
	public boolean selectColorChoice;
	
	public UnoGame()
	{
		cardDeck = new CardDeck();
		discardDeck = new ArrayList<>();
		players = new ArrayList<>();
	}
	
	public void initGame()
	{
		players.add(new Player(1, true));
		players.add(new Player(2, false));
		
		cardDeck.shuffle();
		turnoverTopCard();
		
		//create new game timer object that stores winner and game details
	}
	
	public void setAllowedColor(Color c)
	{
		allowedColor = c;
	}
	 
	public Color allowedColor()
	{
		return allowedColor;
	}
	
	public ArrayList<Player> players()
	{
		return players;
	}
	
	public Player playerOne()
	{
		return players.get(0);
	}
	
	public Player playerTwo()
	{
		return players.get(1);
	}
	
	public void gameOver(){ }
		
	public IUnoCard discardDeckTopCard()
	{
		return discardDeck.get(discardDeck.size() - 1);
	}
	
	public void turnoverTopCard()
	{
		discardDeck.add(cardDeck.getTopCard());
		cardDeck.remove(cardDeck.getTopCard());
	}
}