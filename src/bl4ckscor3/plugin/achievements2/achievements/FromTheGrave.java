package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;

public class FromTheGrave implements IAchievement
{
	@Override
	public String getAchievementName()
	{
		return "From The Grave";
	}

	@Override
	public String getAchievementTip()
	{
		return "Too many deaths...";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Die 100 times!";
	}

	@Override
	public int getReward()
	{
		return 875;
	}
}
