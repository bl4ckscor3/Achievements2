package bl4ckscor3.plugin.achievements2.achievements;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.ICommandAchievement;

public class Trustworthy implements IAchievement,ICommandAchievement
{
	@Override
	public String getCommand()
	{
		return "rules";
	}

	@Override
	public String getAchievementName()
	{
		return "Trustworthy";
	}

	@Override
	public String getAchievementTip()
	{
		return "Knowing how to behave on the server...";
	}

	@Override
	public String getAchievementSolution()
	{
		return "Thanks for reading the rules!";
	}

	@Override
	public int getReward()
	{
		return 100;
	}
}
