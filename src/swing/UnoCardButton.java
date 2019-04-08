package swing;

import javax.swing.JButton;
import javax.swing.JPanel;
import interfaces.IUnoCard;

public class UnoCardButton extends JButton {

	private JPanel parent;
	private IUnoCard unoCard;

	public UnoCardButton(){
		setFocusPainted(false);
		setOpaque(false);
	}
	
	public void setUnoCard(IUnoCard card)
	{
		this.unoCard = card;
	}
	
	public IUnoCard getUnoCard()
	{
		return unoCard;
	}
	
	public void setParentContainer(JPanel parent)
	{
		this.parent = parent;
	}
	
	public JPanel getParentContainer()
	{
		return parent;
	}
}
