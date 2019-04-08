package ai;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import main.Gameplay;
import main.Strings;
import main.UnoGame;

public class PassTurn extends BaseActionListener {

	public PassTurn(Gameplay gameplay, UnoGame game) {
		super(gameplay, game);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (game.playerTurn)
		{
			if (game.playerPulled)
			{
				game.playerTurn = false;
				game.playerPulled = false;
			}
			else
			{
				gameplay.view.getFrame().setPlayerDirectionLabel("Cannot pass right now.");
				try 
				{
					TimeUnit.SECONDS.sleep(3);
				} 
				catch (InterruptedException e1) 
				{					
					e1.printStackTrace();
				}
				//gameplay.view.getFrame().setPlayerDirectionLabel(Strings.PLAYER_TURN_TEXT);
			}
		}
	}
}
