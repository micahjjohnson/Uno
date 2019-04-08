package swing;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import interfaces.IUnoCard;
import resources.ImageFinder;

public class CardViewPanel extends JPanel {
	
	private boolean computer;
	private ActionListener listener;
	private MouseAdapter mouseListener;

	public CardViewPanel(){
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
	
	public void isComputer()
	{
		computer = true;
	}
	
	public void addCard(IUnoCard card)
	{
		ImageIcon icon = null;
		UnoCardButton b = new UnoCardButton();
		b.setUnoCard(card);	
		try 
		{
			if (computer)
			{
				icon = new ImageIcon(this.getClass().getResource(new ImageFinder().cardImagePath(card)));
				//icon = new ImageIcon(this.getClass().getResource("back.png");
			}
			else 
			{
				icon = new ImageIcon(this.getClass().getResource(new ImageFinder().cardImagePath(card)));
				b.addActionListener(listener);
				b.addMouseListener(mouseListener);
			}
		}
		catch (NullPointerException npe) 
		{
			System.out.println("COULN'T FIND PHOTO");
		}
		
		b.setIcon(icon);
		add(b);
		refresh();
	}
	
	public void enableAll(boolean enable)
	{
		for (Component b : getComponents() )
		{
			if (b instanceof JButton)
			{
				b.setEnabled(enable);
			}
		}
		
		refresh();
	}
	
	public void refresh()
	{
		repaint();
		//revalidate();
	}
	
	public void removeAllCards()
	{
		for (Component b : getComponents() )
		{
			remove(b);
		}
	}
	
	public void removeCard(IUnoCard card)
	{
		for (Component b : getComponents() )
		{
			if (((UnoCardButton) b).getUnoCard() == card)
			{
				remove(b);
				refresh();
			}
		}
	}
	
	public void setActionListener(ActionListener action)
	{
		this.listener = action;
	}
	
	public void setMouseListener(MouseAdapter listener)
	{
		this.mouseListener = listener;
	}
}
