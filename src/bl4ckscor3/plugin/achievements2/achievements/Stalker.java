package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;

public class Stalker implements IAchievement
{
	@Override
	public String getAchievementName()
	{
		return "Stalker";
	}

	@Override
	public String getAchievementTip()
	{
		return "This block detects players :o";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Have a portable radar detect someone!";
	}

	@Override
	public int getReward()
	{
		return 5000;
	}
}
