package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;

public class Trapped implements IAchievement
{
	@Override
	public String getAchievementName()
	{
		return "Trapped";
	}

	@Override
	public String getAchievementTip()
	{
		return "Claustrophobic";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Get trapped in a cage trap!";
	}

	@Override
	public int getReward()
	{
		return 500;
	}
}
