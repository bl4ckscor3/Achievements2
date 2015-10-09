package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class Citizen implements IAchievement,IRegionAchievement
{
	@Override
	public String getRegionName()
	{
		return "achievementCitizen";
	}

	@Override
	public String getAchievementName()
	{
		return "Citizen";
	}

	@Override
	public String getAchievementTip()
	{
		return "It's my first day here, where do I build?";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Entered the town!";
	}

	@Override
	public int getReward()
	{
		return 1000;
	}
}
