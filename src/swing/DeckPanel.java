package swing;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DeckPanel extends JPanel {

	private Dimension d = new Dimension(120, 170);
	private JButton button;
	
	public DeckPanel()
	{	
        setOpaque(false);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		button = new JButton();
		
		add(button);
	}
	
	public void updateTopImage(String fullPathName)
	{	
		try
		{
			ImageIcon icon = new ImageIcon(this.getClass().getResource(fullPathName));
	        button.setIcon(icon);
	        repaint();
	        revalidate();
		}
		catch (NullPointerException npe)
		{
			System.out.println("Image not found.");
		}
	}
	
	public void setAction(ActionListener action)
	{
		button.addActionListener(action);
	}
}
