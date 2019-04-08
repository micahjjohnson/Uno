package frames;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class BaseModalDialog extends JDialog {

	public BaseModalDialog(JFrame parent, String title){
		super(parent);
		setTitle(title);   
	    setResizable(false);
	    setModal(true);
        setUndecorated(true);
		//setLocationRelativeTo(parent);
	}
}
