package MunchkinGame;

/** A driver to run a game of Munchkin.
 * @author Patrick Morgan
 * @version 21 September 2019
 */

// TODO Keep improving GUI
// TODO Make GUI display multiple players

import java.util.*; // import the Scanner class (input)
import java.util.ArrayList; // import the ArrayList class

// import classes for working with GUIs
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MunchkinDriver extends JFrame
{
	private JButton buttons[] = new JButton[3];
	private String buttonCaptions[] = {
									"-", // subtract 1 power level
									"+", // add 1 power level
									"swap" // swap genders
								};
	private JPanel buttonPanel = new JPanel(new GridLayout(3,1));
	private JTextField powerLevel = new JTextField(20);
	private JTextField gender = new JTextField(20);
	Container frame;
	
	/**
	 * The default constructor to create
	 * a MunchkinDriver object.
	 */
	public MunchkinDriver()
	{
		frame = getContentPane();
		
		for (int buttonIndex = 0; buttonIndex < 3; buttonIndex++) {
			buttons[buttonIndex] = new JButton(buttonCaptions[buttonIndex]);
			buttons[buttonIndex].setActionCommand(buttonCaptions[buttonIndex]);
			buttonPanel.add(buttons[buttonIndex]);
			buttons[buttonIndex].addActionListener(new MunchkinListener(powerLevel, gender));
			
			//set background color of the buttons
			if (buttonIndex == 0) {
				buttons[buttonIndex].setBackground(Color.RED);
			} else if (buttonIndex == 1) {
				buttons[buttonIndex].setBackground(Color.BLUE);
			} else if (buttonIndex == 2) {
				buttons[buttonIndex].setBackground(new Color(128, 0, 128)); //Purple
			}
			//set text color to white
			buttons[buttonIndex].setForeground(Color.WHITE);
			buttons[buttonIndex].setFont(new Font("SansSerif", Font.BOLD, 18));
		}
		
		frame.setLayout(new FlowLayout());
		frame.setLayout(new BorderLayout());
		frame.add(powerLevel, BorderLayout.NORTH);
		frame.add(gender, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(350, 300));
		pack();
		setVisible(true);
		
		powerLevel.setText("1"); //This effectively sets starting level to 1
		gender.setText("Male"); //Set starting gender to male
	}
	
	/** The main method to run the program.
	 */
	public static void main(String[] args)
	{
	    Scanner input = new Scanner(System.in); //create a scanner
	    
	    System.out.println("How many players do you have? ");
	    int numPlayers = input.nextInt();
	    input.nextLine();
	    
	    // declare an array of players
	    ArrayList<MunchkinCharacter> players = new ArrayList<MunchkinCharacter>(numPlayers);
	    
	    for (int i = 0; i < numPlayers; i++) {
	    	// prompt for the player's name
	    	System.out.printf("Player %d, please enter your name: ", i+1);
		    String tempName = input.nextLine();
		    
		    // prompt for the character's initial gender
		    //System.out.printf("Player %d, please enter your character's gender: ", i+1);
		    //String tempGender = input.nextLine();
		    
		    // create the player object
		    MunchkinCharacter player = new MunchkinCharacter(tempName);//, tempGender);
		    
		    // add the player object to the ArrayList
		    players.add(i, player);
	    }
	    
	    input.close();
		
		for (int i = 0; i < numPlayers; i++) {
		    MunchkinDriver munchkin = new MunchkinDriver();
		    munchkin.setTitle(players.get(i).getPlayerName());
		}
	}
}
