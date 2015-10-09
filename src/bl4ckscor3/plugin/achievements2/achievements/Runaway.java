package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;

public class Runaway implements IAchievement
{
	@Override
	public String getAchievementName()
	{
		return "Runaway";
	}

	@Override
	public String getAchievementTip()
	{
		return "AHAHA I SET OFF THE ALARM 'BY ACCIDENT'!!!";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Pushed a Panic Button (and ran away...)";
	}

	@Override
	public int getReward()
	{
		return 0;
	}
}
