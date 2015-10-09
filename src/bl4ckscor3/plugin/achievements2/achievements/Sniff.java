package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class Sniff implements IAchievement,IRegionAchievement
{
	@Override
	public String getRegionName()
	{
		return "achievementSniff";
	}

	@Override
	public String getAchievementName()
	{
		return "Sniff";
	}

	@Override
	public String getAchievementTip()
	{
		return "How could you, bl4ckscor3!";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Visited the graveyard.";
	}

	@Override
	public int getReward()
	{
		return 250;
	}
}
