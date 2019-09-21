/**
 * 
 */
package MunchkinGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.text.JTextComponent;

/**
 * This class creates an object that will respond to the
 * press of a button for the MunchkinDriver class.
 * 
 * @author Patrick Morgan
 * @version 21 September 2019
 * 
 */
public class MunchkinListener implements ActionListener
{
	JTextField powerLevel;
	JTextField gender;
	
	private static int currentLevel, newLevel;
	private static String currentGender;
	
	/**
	 * The default constructor
	 * 
	 * @param powerLevelField the power level text field
	 */
	public MunchkinListener(JTextField powerLevelField, JTextField genderField)
	{
		Font font = new Font("SansSerif", Font.BOLD, 40);
		
		powerLevel = powerLevelField;
		powerLevel.setPreferredSize( new Dimension(100, 100)); // Change size of textbox
		powerLevel.setHorizontalAlignment(JTextField.CENTER); // Center align text
		powerLevel.setFont(font);
		
		gender = genderField;
		gender.setPreferredSize( new Dimension(100, 100)); // Change size of textbox
		gender.setHorizontalAlignment(JTextField.CENTER); // Center align text
		gender.setFont(font);
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
			currentLevel = Integer.parseInt(powerLevel.getText());
			newLevel = currentLevel + 1;
			powerLevel.setText("" + Integer.toString(newLevel));
		} else if(event.getActionCommand().equals("-")) {
			currentLevel = Integer.parseInt(powerLevel.getText());
			if (currentLevel > 1) {
				newLevel = currentLevel - 1;
				powerLevel.setText("" + Integer.toString(newLevel));
			}
		} else if(event.getActionCommand().equals("swap")) {
			currentGender = gender.getText();
			if (currentGender.equalsIgnoreCase("male")) {
				gender.setText("Female");
			} else {
				gender.setText("Male");
			}
		} 
	}
}
