package bl4ckscor3.plugin.achievements2.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.mewin.WGRegionEvents.events.RegionEnteredEvent;

import bl4ckscor3.plugin.achievements2.core.AchievementsExecutor;
import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IRegionAchievement;

public class RegionEnteredListener implements Listener
{
	@EventHandler
	public void onRegionEntered(RegionEnteredEvent event)
	{
		for(IAchievement a : AchievementsExecutor.achievements)
		{
			if(!(a instanceof IRegionAchievement))
				continue;

			if(event.getRegion().getId().equalsIgnoreCase(((IRegionAchievement)a).getRegionName()))
			{
				AchievementsExecutor.giveAchievement(event.getPlayer(), a);
				return;
			}
		}
	}
}
