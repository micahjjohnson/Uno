package ai;

import interfaces.IUnoCard;
import main.Gameplay;
import main.Strings;
import resources.Color;
import resources.Player;

public class ComputerLogic {

	private Gameplay gameplay;
	
	public ComputerLogic(Gameplay game){
		this.gameplay = game;	
	}
	
	public void play(Player player)
	{
		IUnoCard compareCard = gameplay.game.discardDeckTopCard();
			
		if (compareCard.getDescription() != Strings.WILD_CARD && compareCard.getDescription() != Strings.DRAW_FOUR_CARD )
		{
			if (isColor(player, compareCard))
			{
				return;
			}
			else if (isDescription(player, compareCard))
			{
				return;
			}
			else if (!isNullColored(player))
			{
				gameplay.draw(player, 1);	 
				checkDrawCard(player, compareCard);
				return;
			}
		}
		else 
		{
			if (gameplay.game.colorSpecific)
			{
				if (!discardCertainColor(gameplay.game.allowedColor(), player))
				{
					gameplay.draw(player, 1);
					checkDrawCard(player, compareCard);
					return;
				}
				else
				{
					gameplay.view.getFrame().highlightColorButton(gameplay.game.allowedColor(), false);
					return;
				}
			}
			else
			{
				gameplay.errorLog.newLine("Computer pick a color and drop.");
				Color color = new CalculatePopularColor().mostAppeared(player.cardCollection());
				discardCertainColor(color, player);
				gameplay.view.getFrame().highlightColorButton(color, true);
				return;
			}
		}
	}
	
	private boolean checkDrawCard(Player p, IUnoCard compareCard)
	{
		IUnoCard c = p.cardCollection().get(p.cardCollectionCount() - 1);
		
		// if picked up card matches 
		if (c.getColor() == compareCard.getColor() || c.getDescription().equals(compareCard.getDescription())
				|| c.getDescription().equals(Strings.WILD_CARD) || c.getDescription().equals(Strings.DRAW_FOUR_CARD))
		{
			gameplay.errorLog.newLine("Picked up card matches!");
			gameplay.discard(p, c);
			return true;
		}
		
		return false;
	}
	
	private boolean discardCertainColor(Color color, Player player)
	{
		for (IUnoCard card : player.cardCollection())
		{
			if (card.getColor() == color)
			{
				gameplay.discard(player, card);
				return true;
			}
		}
		return false;
	}
	
	private boolean isColor(Player p, IUnoCard compareCard)
	{
		for (IUnoCard card : p.cardCollection())
		{
			if (card.getColor() == compareCard.getColor())
			{
				gameplay.discard(p, card);
				return true;
			}
		}
		return false;
	}
	
	private boolean isDescription(Player p, IUnoCard compareCard)
	{
		for (IUnoCard card : p.cardCollection())
		{
			if (card.getDescription().equals(compareCard.getDescription()))
			{
				gameplay.discard(p, card);
				return true;
			}
		}
		return false;
	}
	
	private boolean isNullColored(Player p)
	{
		for (IUnoCard card : p.cardCollection())
		{
			if (card.getColor() == Color.NULL)
			{
				gameplay.discard(p, card);
				return true;
			}
		}
		return false;
	}
}
