package main;

import java.io.IOException;

import frames.GameOverFrame;
import view.UnoGameView;

public class Uno {
	
	public static void main(String[] args) throws IOException {
		
		/*
		GameOverFrame gameOverFrame = new GameOverFrame(view.getFrame(), "game");
		gameOverFrame.setVisible(true);
		*/
		
		UnoGame game = new UnoGame();
		UnoGameView view = new UnoGameView(game);
		
		try 
		{
			view.gameplay().initGame();
			view.gameplay().start();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			System.out.println("Cannot complete game logic.");
		}
		
		/*
		 * long tStart = System.currentTimeMillis();
					When the game ends:

					long tEnd = System.currentTimeMillis();
					long tDelta = tEnd - tStart;
					double elapsedSeconds = tDelta / 1000.0;
		 */
	}
}