/**
 * This program uses MySQL databases do register and retrieve Movies information.
 * Name: Gustavo Lessa
 * Year: Second
 * College: CCT College Dublin* 
 * 
 */
package movies;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{

	//Declaring text fields here, in order to be available globally for the package
	JTextField title = null;
	JTextField actor = null;
	
	public Main() {
		//Declaring and instantiating controller, which is the class containing the ActionListener. 
		Controller controller = new Controller(this);
		
		//Set size, visibility and default close operation of the JFrame
		setSize(450,200);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Declaring and instantiating the bar to store the menu and adding it to the JFrame
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		//Declaring and instantiating "File" menu and adding it to the MenuBar
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		//Declaring and instantiating "Close" item, adding ActionListener and Command to it, and adding it to the File menu
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(controller);
		close.setActionCommand("cls");
		file.add(close);	
		
		//Setting the layout for the JFrame
		this.setLayout(new GridLayout(3,1));
		
		//Declaring, instantiating and adding to the Frame three panels, each using FlowLayout
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		
		JPanel middle = new JPanel();
		middle.setLayout(new FlowLayout());
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		
		this.add(top);
		this.add(middle);
		this.add(bottom);
		
		//Declaring, instantiating and adding to the top panel the "Title" label
		JLabel titleLabel = new JLabel(" Title:  ");
		top.add(titleLabel);
		
		//Instantiating and adding to the top panel the title Text Field.
		title = new JTextField(20);
		top.add(title);
		
		//Declaring, instantiating and adding to the top panel the "Actor/Actress" label
		JLabel actorLabel = new JLabel(" Actor/Actress:  ");
		middle.add(actorLabel);
		
		//Instantiating and adding to the top panel the title Text Field.
		actor = new JTextField(20);
		middle.add(actor);
		
		//Declaring, instantiating and adding to the bottom panel 2 different buttons
		JButton search = new JButton("Search");
		search.addActionListener(controller);
		search.setActionCommand("search");
		bottom.add(search);
		
		JButton save = new JButton("Save");
		save.addActionListener(controller);
		save.setActionCommand("save");
		bottom.add(save);

		
		validate();
		repaint();
	}

	
	public static void main(String[] args) {	
		new Main();
	}

}
