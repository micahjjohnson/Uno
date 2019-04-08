package swing;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UnoMenuBar extends JMenuBar {

	public UnoMenuBar(){
		 // File Menu, F - Mnemonic
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic(KeyEvent.VK_F);
	    add(fileMenu);

	    // File->New, N - Mnemonic
	    JMenuItem newMenuItem = new JMenuItem("New Game", KeyEvent.VK_N);
	    fileMenu.add(newMenuItem);
	}
}
