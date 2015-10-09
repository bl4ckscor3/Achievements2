package bl4ckscor3.plugin.achievements2.core;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

public class Config
{
	public static void setup(Plugin pl)
	{
		pl.reloadConfig();
		pl.getConfig().addDefault("material.unobtained", Material.REDSTONE_BLOCK.toString());
		pl.getConfig().addDefault("material.obtained", Material.GLOWSTONE.toString());
		pl.getConfig().options().copyDefaults(true);
		pl.saveConfig();
	}
}
