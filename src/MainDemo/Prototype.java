package MainDemo;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mdlaf.MaterialLookAndFeel;


import MainDemo.JsonReader;

public class Prototype {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menu1, menu2;
	private JMenuItem i11, i12, i3, i4, i5;  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototype window = new Prototype();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prototype() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel (new MaterialLookAndFeel ());
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Aceso");
		menuBar = new JMenuBar();
		menu1=new JMenu("Aceso");  
        menu2=new JMenu("File");  
        i11=new JMenuItem("About");  
        i12=new JMenuItem("Quit");  
        i3=new JMenuItem("Import Data");  
        i4=new JMenuItem("Output Data");  
        i5=new JMenuItem("Item 5");  
        menu1.add(i11); menu1.add(i12); 
        menu2.add(i3); menu2.add(i4); menu2.add(i5);  
        menuBar.add(menu1);
        menuBar.add(menu2);
        frame.setJMenuBar(menuBar);
		JsonReader j = new JsonReader();
		try {
			j.readJsonFromFile("JsonTest0.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
