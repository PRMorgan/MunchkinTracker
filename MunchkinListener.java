/**
 * 
 */
package MunchkinGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

/**
 * This class creates an object that will respond to the
 * press of a button for the MunchkinDriver class.
 * 
 * @author Patrick Morgan
 * @version 20 September 2019
 * 
 */
public class MunchkinListener implements ActionListener
{
	JTextField textField; // I dont understand this variable lol
	
	private static int currentLevel, newLevel, operator, result;
	
	/**
	 * The default constructor
	 * 
	 * @param tf the text field
	 */
	public MunchkinListener(JTextField tf)
	{
		textField = tf;
	}
	
	/**
	 * This method provides the definition for what happens
	 * when a particular button is pressed.
	 * 
	 * @param event the action event occurring
	 */
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equals("+")) {
			currentLevel = Integer.parseInt(textField.getText());
			newLevel = currentLevel + 1;
			textField.setText("" + Integer.toString(newLevel));
		} else if(event.getActionCommand().equals("-")) {
			currentLevel = Integer.parseInt(textField.getText());
			newLevel = currentLevel - 1;
			textField.setText("" + Integer.toString(newLevel));
		} 
	}
}
