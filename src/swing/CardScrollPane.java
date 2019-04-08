package swing;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CardScrollPane extends JScrollPane {

	private Dimension d = new Dimension(800, 200);

	public CardScrollPane(Component c){
		setViewportView(c);
		getViewport().setOpaque(false);
		setBorder(null);
        setOpaque(false);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        setMinimumSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
	}
}
