package bl4ckscor3.plugin.achievements2.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.util.Utilities;
import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class TrackExecutor implements CommandExecutor
{
	private static Plugin pl;

	public TrackExecutor(Plugin plugin)
	{
		pl = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			bl4ckkitCore.getMessageManager().sendConsoleMessage(pl, "Achievements can only be used by players.");
			return true;
		}

		Player p = (Player)sender;

		if(p.hasPermission("achievements.atrack"))
		{
			if(args.length > 1)
			{
				bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "Too many arguments defined. Only use /atrack");
				return true;
			}

			Inventory inv = p.getServer().createInventory(p, 27, "Global Achievement Tracking");
			File f = Utilities.getTrackingFile(pl);
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

			for(IAchievement a : AchievementsExecutor.achievements)
			{
				int amount = yaml.getInt(a.getAchievementName());
				ItemStack stack = new ItemStack(amount > 0 ? Material.GLOWSTONE : Material.REDSTONE_BLOCK);
				ItemMeta meta = stack.getItemMeta();
				List<String> lore = new ArrayList<String>();

				meta.setDisplayName(ChatColor.AQUA + a.getAchievementName());
				lore.add(ChatColor.GREEN + (amount > 0 ? (amount == 1 ? "1 player obtained this achievement so far." : amount + " players obtained this achievement so far.") : "Noone obtained this achievement so far."));
				meta.setLore(lore);
				stack.setItemMeta(meta);
				inv.addItem(stack);
			}

			p.openInventory(inv);
		}

		return true;
	}

	/**
	 * Sets up the file in which all achievement progress gets tracked globally
	 */
	public static void setupTrackingFile() throws IOException
	{
		File f = new File(pl.getDataFolder(), "tracking.yml");
		YamlConfiguration yaml;

		if(!f.exists())
			f.createNewFile();

		yaml = YamlConfiguration.loadConfiguration(f);

		for(IAchievement a : AchievementsExecutor.achievements)
		{
			yaml.addDefault(a.getAchievementName(), 0);
		}

		yaml.options().copyDefaults(true);
		yaml.save(f);
	}
}
