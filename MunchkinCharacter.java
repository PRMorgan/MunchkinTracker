package MunchkinGame;

/** A class that holds and manipulates data
 * for a single Munchkin player.
 * @author Patrick Morgan
 * @version 09 September 2019
 */

public class MunchkinCharacter {
    private int level = 1;
    private String playerName;
    private int powerLevel = 1;
    //private String gender;
    private int money;

/*******************************************************************/

	/** Default constructor for a MunchkinCharacter object.
	 * @param playerName The name of the player
	 * @param tempGender The gender of the character
	 */
	public MunchkinCharacter(String name)//, String tempGender)
	{
	    playerName = name;
	    //gender = tempGender;
	    money = 0;
	}

/*******************************************************************/

	/** A method to return the current level of the character.
	 * @return the level of the character
	 */
	public int getCharacterLevel()
	{
	    return level;
	}
	
	/** A method that adds one to the character's level.
	 */
	public void incrementCharacterLevel()
	{
	    level++;
	    powerLevel++;
	}
	
	/** A method that subtracts one from the character's level.
	 */
	public void decrementCharacterLevel()
	{
	    // a character's level can not go below 1
	    if (level > 1){
	        level--;
	        powerLevel--;
	    }
	}

/*******************************************************************/

	/** A method to return the power level of the character.
	 * @return the power level of the character
	 */
	public int getPowerLevel()
	{
	    return powerLevel;
	}
	
	/** A method that adds one to the character's power level.
	 */
	public void incrementPowerLevel()
	{
	    powerLevel++;
	}
	
	/** A method that subtracts one from the character's power level.
	 */
	public void decrementPowerLevel()
	{
	    // a character's power level can not go below its actual level
	    if (powerLevel > level){
	        powerLevel--;
	    }
	}

/*******************************************************************/

	/** A method to return the name of the player.
	 * @return the name of the player
	 */
	public String getPlayerName()
	{
	    return playerName;
	}

/*******************************************************************/

	/** A method to return the character's current amount of money.
	 * @return the ammount of money carried by the character.
	 */
	public int getMoney()
	{
	    return money;
	}
	
	/** A method that increments the character's
	 * current amount of money by 100
	 */
	public void addGold(int gold)
	{
	    money += gold;
	
	    /* increase the character's level and
	     * power level if their gold exceeds 1000 */
	    if (money >= 1000){
	        level++;
	        powerLevel++;
	        money = money - 1000;
	    }
	}

	/** A method that decrements the character's
	 * current amount of money by 100
	 */
	public void subtractGold(int gold)
	{
	    // make sure the subtraction won't go below 0
	    if ((money - gold) >= 0){
	        money -= gold;
	    }
	}

/*******************************************************************/

	/** A method to return the gender of the character.
	 * @return the gender of the character
	 */
	/*public String getGender()
	{
	    return gender;
	}*/

	/** A method to switch the gender of the character.
	 */
	/*public void genderSwap()
	{*/
	    /* If the character is currently male, switch them to female.
	     * If the character is currently female, switch them to male.
	     */
	    //gender = (gender.equalsIgnoreCase("male")) ? "female" : "male";
	//}
}