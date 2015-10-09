package bl4ckscor3.plugin.achievements2.interfaces;

public interface IAchievement
{
	/**
	 * The name of the achievement
	 */
	public String getAchievementName();
	
	/**
	 * The tip which gets displayed when the achievement has not been obtained
	 */
	public String getAchievementTip();
	
	/**
	 * The solution which gets displayed when the achievement has been obtained
	 */
	public String getAchievementSolution();
	
	/**
	 * The reward to give to the player when he obtained the achievement
	 */
	public int getReward();
}
