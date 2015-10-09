package bl4ckscor3.plugin.achievements2.listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.achievements2.core.AchievementsExecutor;
import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IProgressAchievement;
import bl4ckscor3.plugin.achievements2.util.Utilities;
import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class InventoryClickListener implements Listener
{
	private static Plugin pl;
	
	public InventoryClickListener(Plugin plugin)
	{
		pl = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if(event.getCurrentItem() == null)
			return;

		if(event.getInventory().getName().equals("Your Achievements") || event.getInventory().getName().startsWith("Achievements of ") || event.getInventory().getName().equals("Global Achievement Tracking"))
			event.setCancelled(true);

		if(event.getWhoClicked().hasPermission("achievements.others.manage"))
		if(event.getInventory().getName().equals("Your Achievements"))
			switchAchievement(event, event.getWhoClicked().getUniqueId().toString());
		else if(event.getInventory().getName().startsWith("Achievements of "))
		{
			if(bl4ckkitCore.getPlayerManager().isPlayerOnline(event.getInventory().getName().split(" ")[2]))
				switchAchievement(event, Bukkit.getPlayer(event.getInventory().getName().split(" ")[2]).getUniqueId().toString());
			else
				switchAchievement(event, Bukkit.getOfflinePlayer(event.getInventory().getName().split(" ")[2]).getUniqueId().toString());
		}
	}

	/**
	 * Switches the clicked achievement to obtained or unobtained
	 * @param event The event this method got called from
	 * @param uuid The UUID of the player who's achievement menu was opened
	 */
	private void switchAchievement(InventoryClickEvent event, String uuid)
	{
		int slot = event.getSlot();
		
		if(slot > AchievementsExecutor.achievements.size() - 1)
			return;

		IAchievement a =  AchievementsExecutor.achievements.get(slot);
		File f = Utilities.getPlayerFile(pl, uuid);
		File tracking = Utilities.getTrackingFile(pl);
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		YamlConfiguration t = YamlConfiguration.loadConfiguration(tracking);
		boolean obtained = yaml.getBoolean(a.getAchievementName() + ".obtained");
		int tracked = t.getInt(a.getAchievementName());
		ItemStack stack = new ItemStack(obtained ? Material.getMaterial(pl.getConfig().getString("material.unobtained")) : Material.getMaterial(pl.getConfig().getString("material.obtained")));
		ItemMeta meta = stack.getItemMeta();
		List<String> lore = new ArrayList<String>();

		yaml.set(a.getAchievementName() + ".obtained", !obtained);
		t.set(a.getAchievementName(), obtained ? --tracked : ++tracked);
		
		if(a instanceof IProgressAchievement)
		{
			if(obtained)
				yaml.set(a.getAchievementName() + ".progress", 0);
			else
				yaml.set(a.getAchievementName() + ".progress", ((IProgressAchievement)a).getRequiredProgress());
		}
		
		try
		{
			yaml.save(f);
			t.save(tracking);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		meta.setDisplayName(ChatColor.AQUA + a.getAchievementName());
		lore.add(ChatColor.GREEN + (obtained ? a.getAchievementTip() : a.getAchievementSolution()));

		if(a instanceof IProgressAchievement)
			lore.add(ChatColor.GREEN + "Progress: (" + Utilities.getProgress(pl, uuid, a.getAchievementName()) + "/" + ((IProgressAchievement)a).getRequiredProgress() + ")");

		meta.setLore(lore);
		stack.setItemMeta(meta);
		event.getInventory().setItem(slot, stack);
	}
}
