package MunchkinGame;

/** A driver to run a game of Munchkin.
 * @author Patrick Morgan
 * @version 20 September 2019
 */

// TODO Keep improving GUI
// TODO Make GUI display multiple players

import java.util.*; // import the Scanner class (input)
import java.util.ArrayList; // import the ArrayList class

// import classes for working with GUIs
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MunchkinDriver extends JFrame implements ActionListener
{
	private JButton buttons[] = new JButton[2];
	private String buttonCaptions[] = {
									"-",
									"+"
								};
	private JPanel buttonPanel = new JPanel(new GridLayout(2,1));
	private JTextField output = new JTextField(20);
	Container frame;
	
	/**
	 * The default constructor to create
	 * a MunchkinDriver object.
	 */
	public MunchkinDriver()
	{
		frame = getContentPane();
		
		for (int buttonIndex = 0; buttonIndex < 2; buttonIndex++) {
			buttons[buttonIndex] = new JButton(buttonCaptions[buttonIndex]);
			buttons[buttonIndex].setActionCommand(buttonCaptions[buttonIndex]);
			buttonPanel.add(buttons[buttonIndex]);
			buttons[buttonIndex].addActionListener(new MunchkinListener(output));
		}
		
		frame.setLayout(new FlowLayout());
		frame.setLayout(new BorderLayout());
		frame.add(output, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
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
	    	System.out.printf("Please enter the player's name: ");
		    String tempName = input.nextLine();
		    
		    // prompt for the character's initial gender
		    System.out.printf("Please enter your character's gender: ");
		    String tempGender = input.nextLine();
		    
		    // create the player object
		    MunchkinCharacter player = new MunchkinCharacter(tempName, tempGender);
		    
		    // add the player object to the ArrayList
		    players.add(i, player);
	    }
	    
	    input.close();
	
	    for (int i = 0; i < players.size(); i++) {
		    System.out.printf("\n%s\n%s\nMoney: %d\nLevel: %d\nPower Level: %d\n\n",
		                      players.get(i).getPlayerName(),
		                      players.get(i).getGender(),
		                      players.get(i).getMoney(),
		                      players.get(i).getCharacterLevel(),
		                      players.get(i).getPowerLevel());
		    
		    System.out.println("" + players.get(i).getPlayerName() + ": Adding two levels and adding 3 power levels.");
		    players.get(i).incrementCharacterLevel();
		    players.get(i).incrementCharacterLevel();
		    players.get(i).incrementPowerLevel();
		    players.get(i).incrementPowerLevel();
		    players.get(i).incrementPowerLevel();
		    
		    System.out.printf("\n%s\n%s\nMoney: %d\nLevel: %d\nPower Level: %d\n\n",
	                players.get(i).getPlayerName(),
	                players.get(i).getGender(),
	                players.get(i).getMoney(),
	                players.get(i).getCharacterLevel(),
	                players.get(i).getPowerLevel());
		    
		    /*System.out.println("Decrement power. add 250 gold. gender swap.");
		    players.get(i).decrementPowerLevel();
		    players.get(i).addGold(250);
		    players.get(i).genderSwap();
		    
		    System.out.printf("\n%s\n%s\nMoney: %d\nLevel: %d\nPower Level: %d\n\n",
	                players.get(i).getPlayerName(),
	                players.get(i).getGender(),
	                players.get(i).getMoney(),
	                players.get(i).getCharacterLevel(),
	                players.get(i).getPowerLevel());*/
		}
	    MunchkinDriver munchkins = new MunchkinDriver();
	}

	/**
	 * This method provides the definition for what happens
	 * when a particular button is pressed.
	 * 
	 * @param event the action event occurring
	 */
	//@Override
	/*public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
	}*/
}
