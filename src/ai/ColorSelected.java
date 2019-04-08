package ai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.UnoGame;
import swing.ColorChoiceButton;
import view.UnoGameView;

public class ColorSelected implements ActionListener {
	
	private UnoGame game;
	private UnoGameView view;
	
	public ColorSelected(UnoGame game, UnoGameView view){
		this.game = game;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (game.playerTurn && game.selectColorChoice)
		{
			ColorChoiceButton b = ((ColorChoiceButton) e.getSource());
			
			game.setAllowedColor(b.getColor());
			game.selectColorChoice = false;
			game.playerTurn = false;
			game.colorSpecific = true;
			view.getFrame().highlightColorButton(b.getColor(), true);
		}
	}
}
