package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.core.AchievementsExecutor;
import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IProgressAchievement;

public class AchievementHunter implements IAchievement,IProgressAchievement
{
	@Override
	public int getRequiredProgress()
	{
		return AchievementsExecutor.achievements.size() - 1; //-1 because we don't want to count this achievement
	}
	
	@Override
	public String getAchievementName()
	{
		return "Achievement Hunter";
	}

	@Override
	public String getAchievementTip()
	{
		return "Ignore this for now, you'll get there eventually...";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Obtained all achievements!";
	}

	@Override
	public int getReward()
	{
		return 100_000;
	}
}
