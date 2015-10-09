package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;

public class Stylish implements IAchievement
{
	@Override
	public String getAchievementName()
	{
		return "Stylish";
	}

	@Override
	public String getAchievementTip()
	{
		return "This reinforced material is looking really nice!";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Placed down all reinforced wooden planks.";
	}

	@Override
	public int getReward()
	{
		return 300;
	}
}
