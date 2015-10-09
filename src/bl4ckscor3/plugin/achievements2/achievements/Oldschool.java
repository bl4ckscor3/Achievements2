package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class Oldschool implements IAchievement,IRegionAchievement
{
	@Override
	public String getRegionName()
	{
		return "achievementOldschool";
	}

	@Override
	public String getAchievementName()
	{
		return "Oldschool";
	}

	@Override
	public String getAchievementTip()
	{
		return "Oho, three enchantment tables, how fancy!";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Warped to the skeleton trap!";
	}

	@Override
	public int getReward()
	{
		return 250;
	}
}
