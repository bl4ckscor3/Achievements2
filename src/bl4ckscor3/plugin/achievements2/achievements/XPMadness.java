package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class XPMadness implements IAchievement,IRegionAchievement
{
	@Override
	public String getRegionName()
	{
		return "achievementXPMadness";
	}

	@Override
	public String getAchievementName()
	{
		return "XP Madness";
	}

	@Override
	public String getAchievementTip()
	{
		return "So much XP! But those creatures look really creepy...";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Warped to the endfarm!";
	}

	@Override
	public int getReward()
	{
		return 250;
	}
}
