package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ai.ColorSelected;
import ai.DeckClick;
import ai.PassTurn;
import ai.PlayerLogic;
import frames.Frame;
import frames.GameOverFrame;
import interfaces.IUnoCard;
import main.Gameplay;
import main.UnoGame;
import resources.ImageFinder;
import resources.Player;
import swing.CardViewPanel;
import swing.UnoCardButton;

public class UnoGameView {

	private Gameplay gameplay;
	private Frame view;
	private GameOverFrame gameOverFrame;
		
	public UnoGameView(UnoGame game)
	{
		view = new Frame();	
		gameplay = new Gameplay(game, this);
		gameOverFrame = new GameOverFrame(view, gameplay, "Game Over");
		
		ColorSelected colorSelection = new ColorSelected(game, gameplay.view);
		view.setColorChooserActionListener(colorSelection);
		
		PlayerLogic playerLogic = new PlayerLogic(gameplay, game);
		view.bottomCardViewPanel().setActionListener(playerLogic);
		
		DeckClick deckClick = new DeckClick(gameplay, game);
		view.cardDeckPanel().setAction(deckClick);
		
		PassTurn passTurn = new PassTurn(gameplay, game);
		view.setActionListener(passTurn);
		
		view.setUnoButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.unoBtVisible(false);
				gameplay.playerHasUno = false;
      		  	gameplay.playerPressedUno = true;
      		  	gameplay.errorLog.newLine("Player pressed 'UNO' in time.");
			}
		});
		
		view.bottomCardViewPanel().setMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) { }
	
				@Override
				public void mousePressed(MouseEvent e) { }
	
				@Override
				public void mouseExited(MouseEvent e) 
				{
					UnoCardButton button = (UnoCardButton) e.getSource();

					if (game.playerTurn)
					{
						button.setPreferredSize(new Dimension(100, 144));
						view.bottomCardViewPanel().refresh();
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent e) 
				{		
					UnoCardButton button = (UnoCardButton) e.getSource();

					if (game.playerTurn)
					{
						button.setPreferredSize(new Dimension(120, 200));
						view.bottomCardViewPanel().refresh();
					}
				}
	
				@Override
				public void mouseClicked(MouseEvent e) { }
		});		
	}
	
	public Gameplay gameplay()
	{
		return gameplay;
	}
	
	public GameOverFrame getGameOverFrame()
	{
		return gameOverFrame;
	}
	
	public Frame getFrame()
	{
		return view;
	}
	
	public void visible(boolean x)
	{
		view.setVisible(x);
	}

	public CardViewPanel playerCardView(Player p)
	{
		if (p.isComputer())
		{
			return view.topCardViewPanel();
		}
		else
		{
			return view.bottomCardViewPanel();
		}
	}
	
	/*
	 * player values : 0 = computer, 1 = player
	 */
	public void updateCardView(Player p)
	{
		CardViewPanel panel = null;
		
		if (p.isComputer())
		{
			panel = view.topCardViewPanel();
			panel.enableAll(false);
		}
		else
		{
			panel = view.bottomCardViewPanel();
		}
		
		panel.removeAllCards();		
		for (IUnoCard card : p.cardCollection())
		{
			panel.addCard(card);
		}
	}
	
	public void updateDiscardDeck(IUnoCard card)
	{
		view.discardDeckPanel().updateTopImage(new ImageFinder().cardImagePath(card));
	}
}
