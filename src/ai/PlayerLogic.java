package ai;

import java.awt.event.ActionEvent;
import interfaces.IUnoCard;
import main.Gameplay;
import main.Strings;
import main.UnoGame;
import resources.SpecialUnoCard;
import swing.UnoCardButton;

public class PlayerLogic extends BaseActionListener {

	public PlayerLogic(Gameplay gameplay, UnoGame game) {
		super(gameplay, game);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (game.playerTurn)
		{
			UnoCardButton button = (UnoCardButton) e.getSource();
			IUnoCard compareCard = game.discardDeckTopCard();
			IUnoCard card = button.getUnoCard();

			if (game.colorSpecific)
			{
				if (cardIsColorOrSpecial(card))
				{
					return;
				}
				else
				{
					gameplay.errorLog.newLine("Color not allowed.");
				}
			}
			else 
			{
				if (card.getColor() == compareCard.getColor() || 
						card.getDescription().equals(compareCard.getDescription()) ||
						card instanceof SpecialUnoCard)
				{
					gameplay.discard(game.playerTwo(), button.getUnoCard());
					
				}
				else if (compareCard instanceof SpecialUnoCard)
				{
					if (compareCard.getDescription().equals(Strings.DRAW_FOUR_CARD))
					{
						gameplay.discard(game.playerTwo(), button.getUnoCard());
						return;
					}
				}
				else
				{
					gameplay.errorLog.newLine("Invalid selection.");
				}
				
				if (game.playerTwo().cardCollectionCount() == 1)
				{
					gameplay.view.getFrame().unoBtVisible(true);
					gameplay.playerHasUno = true;
				}
				else
				{
					if (gameplay.playerHasUno)
					{
						gameplay.draw(game.playerTwo(), 2);
						gameplay.view.getFrame().unoBtVisible(false);
						gameplay.playerHasUno = false;
					}
				}
			}
		}
	}
	
	private boolean cardIsColorOrSpecial(IUnoCard card)
	{
		if (card.getColor() == game.allowedColor() || card.getDescription().equals(Strings.WILD_CARD) 
				|| card.getDescription().equals(Strings.DRAW_FOUR_CARD))
		{
			gameplay.discard(game.playerTwo(), card);
			game.colorSpecific = false;
			gameplay.view.getFrame().highlightColorButton(gameplay.game.allowedColor(), false);
			return true;
		}
		
		return false;
	}
}
