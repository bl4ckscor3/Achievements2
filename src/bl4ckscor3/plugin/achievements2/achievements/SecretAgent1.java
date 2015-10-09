package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class SecretAgent1 implements IAchievement,IRegionAchievement
{
	@Override
	public String getRegionName()
	{
		return "achievementSecretAgent1";
	}

	@Override
	public String getAchievementName()
	{
		return "Secret Agent 1";
	}

	@Override
	public String getAchievementTip()
	{
		return "Search under a bridge...";
	}

	@Override
	public String getAchievementSolution()
	{
		return "You found a secret!";
	}

	@Override
	public int getReward()
	{
		return 1000;
	}
}
