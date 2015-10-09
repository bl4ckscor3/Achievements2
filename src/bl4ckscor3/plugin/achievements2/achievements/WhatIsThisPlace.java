package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class WhatIsThisPlace implements IAchievement,IRegionAchievement
{
	@Override
	public String getRegionName()
	{
		return "achievementWhatISThisPlace";
	}
	
	@Override
	public String getAchievementName()
	{
		return "What IS This Place?";
	}

	@Override
	public String getAchievementTip()
	{
		return "I didn't know there was anything under here... ";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Get to Vauff's evil lair!";
	}

	@Override
	public int getReward()
	{
		return 5000;
	}
}
