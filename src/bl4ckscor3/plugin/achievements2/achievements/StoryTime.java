package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class StoryTime implements IAchievement,IRegionAchievement
{
	@Override
	public String getRegionName()
	{
		return "achievementStoryTime";
	}

	@Override
	public String getAchievementName()
	{
		return "Story Time";
	}

	@Override
	public String getAchievementTip()
	{
		return "C-A-M-P-F-I-R-E-S-O-N-G song";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Visited Vakonof's campfire!";
	}

	@Override
	public int getReward()
	{
		return 100;
	}
}
