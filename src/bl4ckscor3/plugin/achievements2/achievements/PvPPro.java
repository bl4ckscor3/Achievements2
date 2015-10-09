package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IProgressAchievement;

public class PvPPro implements IAchievement,IProgressAchievement
{
	@Override
	public int getRequiredProgress()
	{
		return 50;
	}

	@Override
	public String getAchievementName()
	{
		return "PvP Pro";
	}

	@Override
	public String getAchievementTip()
	{
		return "Keep the kills comin'!";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Killed 50 players.";
	}

	@Override
	public int getReward()
	{
		return 500;
	}
}
