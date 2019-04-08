package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.Strings;
import swing.CardScrollPane;
import swing.CardViewPanel;
import swing.ColorChoiceButton;
import swing.DeckPanel;
import swing.UnoMenuBar;

public class Frame extends JFrame {

	private DeckPanel _cardDeck;
	private DeckPanel _discardDeck;
	private CardViewPanel _topCardViewPanel;
	private CardViewPanel _bottomCardViewPanel;
	
    private JPanel playerLblPanel;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel passBtPanel;
	private JPanel westPanel;
	private ColorChoiceButton blueColorChoice;
	private ColorChoiceButton greenColorChoice;
	private ColorChoiceButton yellowColorChoice;
	private ColorChoiceButton redColorChoice;
	private JButton unoBt;
	private JButton passBt;
	private JLabel playerDirectionLbl;
			
	public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Strings.GAME_TITLE);   
        setSize(975, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setJMenuBar(new UnoMenuBar());
 
		setIconImage(new ImageIcon(getClass().getResource("/icons/frameIcon.png")).getImage());
        
        Container c = getContentPane(); 
        Color myNavy = new Color(82, 118, 142);
        c.setBackground(myNavy);
        
        _topCardViewPanel = new CardViewPanel();
        _topCardViewPanel.isComputer();     
        JScrollPane pane1 = new CardScrollPane(_topCardViewPanel);
		
        _bottomCardViewPanel = new CardViewPanel();     
        JScrollPane pane2 = new CardScrollPane(_bottomCardViewPanel);
        
        _discardDeck = new DeckPanel();
        _cardDeck = new DeckPanel();
        playerDirectionLbl = new JLabel(Strings.COMPUTER_TURN_TEXT);
        playerDirectionLbl.setFont(new Font("Bodoni MT Black", Font.BOLD, 15));
        
        Dimension dddd = new Dimension(120, 60);
        passBt = new JButton();
        passBt.setMinimumSize(dddd);
        passBt.setPreferredSize(dddd);
        passBt.setMaximumSize(dddd);
        passBt.setBorderPainted(false);
        passBt.setOpaque(false);
        passBt.setFocusPainted(false);
        passBt.setContentAreaFilled(false);
        ImageIcon redIcon = new ImageIcon(this.getClass().getResource("/buttons/pass.png"));
		passBt.setIcon(redIcon);
        
        Dimension ddddd = new Dimension(120, 60);
        unoBt = new JButton("UNO!");
		unoBt.setVisible(false);
        unoBt.setMinimumSize(ddddd);
        unoBt.setPreferredSize(ddddd);
        unoBt.setMaximumSize(ddddd);
      
    	Dimension d = new Dimension(200, 35);
        playerLblPanel = new JPanel();
        playerLblPanel.setOpaque(false);
        //playerLblPanel.setBorder(new LineBorder(Color.black, 2));
        playerLblPanel.setPreferredSize(d);
        playerLblPanel.setMinimumSize(d);
        playerLblPanel.add(playerDirectionLbl, BorderLayout.NORTH);
        
        Dimension dd = new Dimension(200, 20);
        passBtPanel = new JPanel();
        passBtPanel.setOpaque(false);
        passBtPanel.setMinimumSize(dd);
        passBtPanel.setPreferredSize(dd);
        passBtPanel.setMaximumSize(dd);
        passBtPanel.add(passBt);
        passBtPanel.add(unoBt);
        
        northPanel = new JPanel();
        northPanel.setOpaque(false);
        northPanel.add(pane1, BorderLayout.NORTH);
               
    	Dimension df = new Dimension(300, 250);
        southPanel = new JPanel();
        //southPanel.setBorder(new LineBorder(Color.blue, 2));
        southPanel.setOpaque(false);
        southPanel.setMinimumSize(df);
        southPanel.setPreferredSize(df);
        southPanel.setMaximumSize(df);
        southPanel.add(playerLblPanel, BorderLayout.NORTH);
        southPanel.add(pane2, BorderLayout.SOUTH);
                
        _cardDeck.updateTopImage("/back.png");
        _discardDeck.updateTopImage("/back.png");
        
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel(), BorderLayout.CENTER);
        add(westPanel(), BorderLayout.WEST);
        add(passBtPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
	}
	
	private JPanel centerPanel()
	{
		JPanel panel = new JPanel();
		Dimension ddd = new Dimension(20, 20);
        panel.setOpaque(false);
        panel.setMinimumSize(ddd);
        panel.setPreferredSize(ddd);
        panel.setMaximumSize(ddd);
		panel.add(_cardDeck, BorderLayout.WEST);
        panel.add(_discardDeck, BorderLayout.EAST);
		return panel;
	}
	
	private JPanel westPanel()
	{
		Dimension ddd = new Dimension(200, 5);
        westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.X_AXIS));
        //westPanel.setBorder(new LineBorder(Color.black, 2));
        westPanel.setOpaque(false);
        westPanel.setMinimumSize(ddd);
        westPanel.setPreferredSize(ddd);
        westPanel.setMaximumSize(ddd);
        
        blueColorChoice = new ColorChoiceButton();
		ImageIcon blueIcon = new ImageIcon(this.getClass().getResource("/buttons/blue.png"));
		blueColorChoice.setIcon(blueIcon);
		blueColorChoice.setColor(resources.Color.BLUE);
        
        greenColorChoice = new ColorChoiceButton();
		ImageIcon greenIcon = new ImageIcon(this.getClass().getResource("/buttons/green.png"));
		greenColorChoice.setIcon(greenIcon);
		greenColorChoice.setColor(resources.Color.GREEN);

        yellowColorChoice = new ColorChoiceButton();
		ImageIcon yellowIcon = new ImageIcon(this.getClass().getResource("/buttons/yellow.png"));
		yellowColorChoice.setIcon(yellowIcon);
		yellowColorChoice.setColor(resources.Color.YELLOW);

        redColorChoice = new ColorChoiceButton();
		ImageIcon redIcon = new ImageIcon(this.getClass().getResource("/buttons/red.png"));
		redColorChoice.setIcon(redIcon);
		redColorChoice.setColor(resources.Color.RED);
		
		westPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		westPanel.add(blueColorChoice);
		westPanel.add(greenColorChoice);
		westPanel.add(yellowColorChoice);
		westPanel.add(redColorChoice);	
        return westPanel;
	}
	
	public void highlightColorButton(resources.Color color, boolean increase)
	{
		JButton button = null;
		String littlePath = null;
		String bigPath = null;
		
		switch (color)
		{
		case RED:
			button = redColorChoice;
			littlePath = "/buttons/red.png";
			bigPath = "/buttons/bigred.png";
			break;
		case BLUE:
			button = blueColorChoice;
			littlePath = "/buttons/blue.png";
			bigPath = "/buttons/bigblue.png";
			break;
		case GREEN:
			button = greenColorChoice;
			littlePath = "/buttons/green.png";
			bigPath = "/buttons/biggreen.png";
			break;
		case YELLOW:
			button = yellowColorChoice;
			littlePath = "/buttons/yellow.png";
			bigPath = "/buttons/bigyellow.png";
			break;
		default:
			break;
		}
		
		ImageIcon icon = null;
		if (increase)
		{
	        icon = new ImageIcon(this.getClass().getResource(bigPath));
		}
		else
		{
	        icon = new ImageIcon(this.getClass().getResource(littlePath));
		}
		
		button.setIcon(icon);
        button.repaint();
        button.revalidate();
        westPanel.repaint();
        westPanel.revalidate();
	}
	
	public void setPlayerDirectionLabel(String text)
	{
		playerDirectionLbl.setText(text);
		playerLblPanel.repaint();
		playerLblPanel.revalidate();
	}
	
	public void unoBtVisible(boolean visibility)
	{
		unoBt.setVisible(visibility);
		//passBtPanel.repaint();
		//passBtPanel.revalidate();
	}
	
	public void setActionListener(ActionListener action)
	{
		passBt.addActionListener(action);
	}
	
	public void setUnoButtonActionListener(ActionListener action)
	{
		unoBt.addActionListener(action);
	}
	
	public void setColorChooserActionListener(ActionListener action)
	{
		blueColorChoice.addActionListener(action);
		greenColorChoice.addActionListener(action);
		yellowColorChoice.addActionListener(action);
		redColorChoice.addActionListener(action);
	}
	
	public CardViewPanel topCardViewPanel()
	{
		return _topCardViewPanel;
	}
	
	public CardViewPanel bottomCardViewPanel()
	{
		return _bottomCardViewPanel;
	}
	
	public DeckPanel discardDeckPanel()
	{
		return _discardDeck;
	}
	
	public DeckPanel cardDeckPanel()
	{
		return _cardDeck;
	}
}
