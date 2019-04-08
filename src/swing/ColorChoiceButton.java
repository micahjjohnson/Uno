package swing;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import resources.Color;

public class ColorChoiceButton extends JButton {

	private Dimension d = new Dimension(30, 30);	
	private Color color;

	public ColorChoiceButton(){
		setBorderPainted(false);
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
		setMinimumSize(d);
        setPreferredSize(d);
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public Color getColor()
	{
		return color;
	}
}
