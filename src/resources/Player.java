package resources;

import java.util.ArrayList;

import interfaces.IUnoCard;

public class Player {
	
	protected ArrayList<IUnoCard> _cardCollection;
	protected int _rotationTurn;
	protected boolean _isComputer;
	
	public Player(int rotation, boolean computer)
	{
		_cardCollection = new ArrayList<>();
		_rotationTurn = rotation;
		_isComputer = computer;
	}
	
	public void addCard(IUnoCard card)
	{
		_cardCollection.add(card);
	}
	
	public ArrayList<IUnoCard> cardCollection()
	{
		return _cardCollection;
	}
	
	public int cardCollectionCount()
	{
		return _cardCollection.size();
	}
	
	public void setPlayerRotation(int rotation) 
	{
		_rotationTurn = rotation;
	}
	
	public int getPlayerRotation() 
	{ 
		return _rotationTurn; 
	}
	
	public boolean isComputer() 
	{ 
		return _isComputer; 
	}
	
	public void removeCard (IUnoCard card)
	{
		_cardCollection.remove(card);
	}
}