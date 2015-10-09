package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class SecretAgent2 implements IAchievement,IRegionAchievement
{
	@Override
	public String getRegionName()
	{
		return "achievementSecretAgent2";
	}

	@Override
	public String getAchievementName()
	{
		return "Secret Agent 2";
	}

	@Override
	public String getAchievementTip()
	{
		return "Sssssssssssearch under a bridge...";
	}

	@Override
	public String getAchievementSolution()
	{
		return "You found a sssssssssssecret!";
	}

	@Override
	public int getReward()
	{
		return 1000;
	}
}
