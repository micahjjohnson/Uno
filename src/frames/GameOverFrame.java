package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Gameplay;

public class GameOverFrame extends BaseModalDialog {

	private Dimension d = new Dimension(350, 250);
	private JButton newGame;
	private JButton mainMenu;
	private JButton quit;
	
	private Gameplay gameplay;
	
	public GameOverFrame(JFrame parent, Gameplay gameplay, String title) {
		super(parent, title);
		this.gameplay = gameplay;
        setMinimumSize(d);
        setPreferredSize(d);
        //setMaximumSize(d);
       		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icons/gameover.png"));
		JLabel gameOver = new JLabel();
		gameOver.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		gameOver.setIcon(icon);
		
		JPanel buttons = new JPanel();
        newGame = new JButton("New Game");
        mainMenu = new JButton("Return to Menu");
        quit = new JButton("Quit");      
        buttons.add(newGame, BorderLayout.WEST);
        buttons.add(mainMenu, BorderLayout.CENTER);
        buttons.add(quit, BorderLayout.EAST);
        
        add(gameOver, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
        
        newGame.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					gameplay.initGame();
				} 
				catch (FileNotFoundException | InterruptedException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        
        quit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
			}
		});
   }
}
