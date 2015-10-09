package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;

public class Advanced implements IAchievement
{
	@Override
	public String getAchievementName()
	{
		return "Advanced";
	}

	@Override
	public String getAchievementTip()
	{
		return "I didn't know that I can modify these blocks...";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Modified a SecurityCraft block with a Universal Block Modifier!";
	}

	@Override
	public int getReward()
	{
		return 500;
	}
}
