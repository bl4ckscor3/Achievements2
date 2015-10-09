package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IProgressAchievement;

public class PvPBoss implements IAchievement,IProgressAchievement
{
	@Override
	public int getRequiredProgress()
	{
		return 100;
	}

	@Override
	public String getAchievementName()
	{
		return "PvP Boss";
	}

	@Override
	public String getAchievementTip()
	{
		return "Keep the kills comin'!";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Killed 100 players.";
	}

	@Override
	public int getReward()
	{
		return 1000;
	}
}
