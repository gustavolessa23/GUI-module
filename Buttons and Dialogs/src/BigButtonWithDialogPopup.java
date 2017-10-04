import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BigButtonWithDialogPopup extends JFrame implements ActionListener {

	public BigButtonWithDialogPopup() {
		
		setSize(500,500);
		setVisible(true);
		
		JButton btn = new JButton();
		btn.addActionListener(this);
		
		this.add(btn);
		
		validate();
		repaint();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new BigButtonWithDialogPopup();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Object[] options = {"Yes, please",
                "No, thanks",
                "No eggs, no ham!"};
		
			int n = JOptionPane.showOptionDialog(this,
			"Would you like to save?"
			+ "",
			"An important question",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.INFORMATION_MESSAGE,
			null,
			options,
			options[2]);
			
			System.out.println("Button click:" + n);

		
	}

}
