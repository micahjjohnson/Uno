package ai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Gameplay;
import main.UnoGame;

public class BaseActionListener implements ActionListener {

	protected UnoGame game;
	protected Gameplay gameplay;
	
	public BaseActionListener(Gameplay gameplay, UnoGame game){
		this.gameplay = gameplay;
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { }
}
