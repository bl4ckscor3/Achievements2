package bl4ckscor3.plugin.achievements2.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.achievements2.core.AchievementsExecutor;
import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IProgressAchievement;
import bl4ckscor3.plugin.achievements2.util.Utilities;

public class PlayerJoinListener implements Listener
{
	private Plugin pl;

	public PlayerJoinListener(Plugin plugin)
	{
		pl = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws IOException
	{
		File folder = new File(pl.getDataFolder(), "playerStorage/");
		File f = Utilities.getPlayerFile(pl, event.getPlayer().getUniqueId().toString());
		YamlConfiguration yaml;

		if(!folder.exists())
			folder.mkdirs();

		if(!f.exists())
			f.createNewFile();

		yaml = YamlConfiguration.loadConfiguration(f);

		for(IAchievement a : AchievementsExecutor.achievements)
		{
			yaml.addDefault(a.getAchievementName() + ".obtained", false);

			if(a instanceof IProgressAchievement)
				yaml.addDefault(a.getAchievementName() + ".progress", 0);
		}

		yaml.options().copyDefaults(true);
		yaml.save(f);
	}
}
