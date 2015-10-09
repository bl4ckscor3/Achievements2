package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;

public class Millionaire implements IAchievement
{
	@Override
	public String getAchievementName()
	{
		return "Millionaire";
	}

	@Override
	public String getAchievementTip()
	{
		return "Richie rich!";
	}

	@Override
	public String getAchievementSolution()
	{
		return "You are a millionaire now! Wait, what? More money?";
	}

	@Override
	public int getReward()
	{
		return 1_000_000;
	}
}
