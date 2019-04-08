package main;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import ai.CalculatePopularColor;
import ai.ComputerLogic;
import interfaces.IUnoCard;
import resources.Color;
import resources.Player;
import resources.SpecialUnoCard;
import view.UnoGameView;

public class Gameplay {
	
	public UnoGame game;
	public UnoGameView view;
	public ErrorLog errorLog;
	private ComputerLogic computerLogic;
	
	public boolean playerHasUno;
	public boolean playerPressedUno;
		
	public Gameplay(UnoGame game, UnoGameView view)
	{
		this.game = game;
		this.view = view;
	}
	
	public void initGame() throws InterruptedException, FileNotFoundException
	{
	    computerLogic = new ComputerLogic(this);
	    errorLog = new ErrorLog();
	    game.initGame();  
	    view.visible(true);
	    TimeUnit.SECONDS.sleep(3);
		view.updateDiscardDeck(game.discardDeckTopCard());	
	}
	
	public void start() throws InterruptedException
	{	
		deal(5);
	    
	    do
	    {
	    	if (!game.playerTurn)
	    	{
				view.getFrame().setPlayerDirectionLabel(Strings.COMPUTER_TURN_TEXT);
		    	TimeUnit.SECONDS.sleep(1);
		    	computerLogic.play(game.playerOne());
		    	checkForWinner();
	    	}
	    	
	    	//player input
	    	if (!game.gameOver)
	    	{
	    		do
		    	{
	    			view.getFrame().setPlayerDirectionLabel(Strings.PLAYER_TURN_TEXT);
		    	}
		    	while (game.playerTurn);
		    	checkForWinner();
	    	}		  
	    }  
	    while (!game.gameOver);
	    
	    if (game.gameOver)
	    {
	    	view.getGameOverFrame().pack();
			view.getGameOverFrame().setLocationRelativeTo(view.getFrame());
	    	view.getGameOverFrame().setVisible(true);
	    }
	}

	private void deal(int count)
	{
		for (Player p : game.players())
		{	
			for (int i = 0; i < count; i++) 
			{		
				IUnoCard card = game.cardDeck.getTopCard();
            	p.addCard(card);
            	game.cardDeck.remove(card);
            }
			
			view.updateCardView(p);
		}
	}
		
	public void discard(Player player, IUnoCard card)
	{	
		/* Add card to discard pile */
		game.discardDeck.add(card);	
		game.playerPulled = false;
		view.updateDiscardDeck(card);
	 
		/* Remove card from player hand */
		player.removeCard(card);
		view.playerCardView(player).removeCard(card);
	 
		if (player.cardCollectionCount() == 1)
		{
			JOptionPane.showMessageDialog(null, "Uno!", "Uno Notification", JOptionPane.ERROR_MESSAGE);
		}
	 
		if (card instanceof SpecialUnoCard)
		{
			int drawCount = 0;
			switch (card.getDescription())
			{
				case "DRAW TWO":
					drawCount = 2;
					break;
				case "DRAW FOUR":
					drawCount = 4;
					break;
			}
		 
			if (!card.getDescription().equals(Strings.WILD_CARD))
			{
				if (player.isComputer())
				{
					draw(game.playerTwo(), drawCount);
					game.selectColorChoice = false;
					game.playerTurn = false;
					return;
				}
				else 
				{
					draw(game.playerOne(), drawCount);
					game.playerTurn = true;
					return;
				}
			}
			else
			{
				if (player.isComputer())
				{
					errorLog.newLine("Pick a color.");
					Color color = new CalculatePopularColor().mostAppeared(player.cardCollection());
					view.getFrame().highlightColorButton(color, true);
					game.setAllowedColor(color);
					game.colorSpecific = true;
					game.playerTurn = true;
					return;
				}
				else
				{
					game.selectColorChoice = true;
				}
			}
		}
		else
		{
			game.playerTurn = player.isComputer();
		}
	 
		errorLog.newLine("Discarded: " + card.getColor().toString() + " " + card.getDescription());
	}
	
	public void draw(Player player, int count)
	{		
		if (game.cardDeck.getDeck().size() == 0)
		{
			game.cardDeck.getDeck().equals(game.discardDeck);
			game.cardDeck.shuffle();
			game.discardDeck.clear();
			game.turnoverTopCard();
			view.updateDiscardDeck(game.discardDeckTopCard());
		}
		
		for (int i = 0; i < count; i++)
		{
			IUnoCard card = game.cardDeck.getTopCard();

			/* Add card to player hand */
			player.addCard(card);
			view.playerCardView(player).addCard(card);
		 			
			/* Remove card from deck */
			game.cardDeck.remove(card);	
		}
		
		if (!game.playerTurn)
		{
			game.playerTurn = true;
		}
	}
	
	private void checkForWinner()
	{
		for (Player p : game.players())
		{
			if (p.cardCollectionCount() == 0)
			{
				game.gameOver = true;			
				JOptionPane.showMessageDialog(null, "Uno Out!", "Uno Notification", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}