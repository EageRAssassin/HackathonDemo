package MainDemo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mdlaf.*;
import MainDemo.JsonReader;

public class Prototype {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menu1, menu2;
	private JMenuItem i11, i12, i3, i4, i5;
	private JPanel cards;
	private JTextField searchField;
	private JLabel resultHead;
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
			UIManager.setLookAndFeel(new MaterialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Aceso");
		// setting up menu
		menuBar = new JMenuBar();
		menu1 = new JMenu("Aceso");
		menu2 = new JMenu("File");
		i11 = new JMenuItem("About");
		i12 = new JMenuItem("Quit");
		i3 = new JMenuItem("Import Data");
		i4 = new JMenuItem("Output Data");
		i5 = new JMenuItem("Item 5");
		menu1.add(i11);
		menu1.add(i12);
		menu2.add(i3);
		menu2.add(i4);
		menu2.add(i5);
		menuBar.add(menu1);
		menuBar.add(menu2);
		frame.setJMenuBar(menuBar);

		// setting up layout
		cards = new JPanel(new CardLayout());

		JButton searchButton = new JButton("Search");
		searchButton.setPreferredSize(new Dimension(130, 50));
		searchButton.setFont(new Font("Arial", Font.PLAIN, 30));
		
		// Setting up first Search Panel
		JPanel searchPanel = new JPanel();

		// add search field
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(300, 50));
		searchField.setFont(new Font("Arial", Font.PLAIN, 30));
		searchPanel.add(searchField);
		
		searchPanel.add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.next(cards);
				updateResultPanel();
			}
		});
		
		
		//setting up the result panel
		
		
		JPanel resultPanel = new JPanel();
		resultPanel.add(new JButton("Nothing"));
		cards.add(searchPanel);
		cards.add(resultPanel);
		
		
		// make all the things move!
		MaterialUIMovement animate = new MaterialUIMovement (new Color (230, 230, 230), 5, 1000 / 30);
		animate.add(searchButton);
		animate.add(searchField);
		
		frame.getContentPane().add(cards);
//		frame.EXIT_ON_CLOSE = 1; TODO
		JsonReader j = new JsonReader();
		try {
			j.readJsonFromFile("JsonTest0.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}



	public void updateResultPanel() {
		resultHead.setText("CHANGED");
		frame.repaint();
	}
	
}
