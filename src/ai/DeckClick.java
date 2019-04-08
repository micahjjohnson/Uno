package ai;

import java.awt.event.ActionEvent;

import main.Gameplay;
import main.UnoGame;

public class DeckClick extends BaseActionListener {

	public DeckClick(Gameplay gameplay, UnoGame game) {
		super(gameplay, game);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (!game.playerPulled)
		{
			if (game.playerTurn)
			{
				gameplay.draw(game.playerTwo(), 1);
				game.playerPulled = true;
	    		return;
			}
		}
		else
		{
			gameplay.errorLog.newLine("Player already drawed card. Must pass or drop card.");
		}
	}
}
