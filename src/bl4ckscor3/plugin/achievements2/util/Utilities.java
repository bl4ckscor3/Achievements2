package bl4ckscor3.plugin.achievements2.util;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Utilities
{
	/**
	 * Checks if a player already obtained an achievements
	 * @param pl This plugin
	 * @param uuid The UUID of the player to check
	 * @param achievementName The name of the achievement
	 * @return Wether the achievement has already been obtained or not
	 */
	public static boolean hasAchievement(Plugin pl, String uuid, String achievementName)
	{
		return YamlConfiguration.loadConfiguration(new File(pl.getDataFolder() + "/playerStorage/" + uuid + ".yml")).getBoolean(achievementName + ".obtained");
	}
	
	/**
	 * Checks the progress on an achievement of a player
	 * @param pl This plugin
	 * @param uuid The UUID of the player to check
	 * @param achievementName The name of the achievement
	 * @return The progress of the achievement
	 */
	public static int getProgress(Plugin pl, String uuid, String achievementName)
	{
		return YamlConfiguration.loadConfiguration(new File(pl.getDataFolder() + "/playerStorage/" + uuid + ".yml")).getInt(achievementName + ".progress");
	}
	
	/**
	 * Gets the achievement progress file of a player.
	 * @param pl This plugin
	 * @param uuid The UUID of the player who's file should be retrieved
	 * @return The achievement file
	 */
	public static File getPlayerFile(Plugin pl, String uuid)
	{
		return new File(pl.getDataFolder() + "/playerStorage/" + uuid + ".yml");
	}

	/**
	 * Gets the achievement tracking file
	 * @return The tracking file
	 */
	public static File getTrackingFile(Plugin pl)
	{
		return new File(pl.getDataFolder(), "/tracking.yml");
	}
}
