package bl4ckscor3.plugin.achievements2.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.achievements2.achievements.AchievementHunter;
import bl4ckscor3.plugin.achievements2.achievements.Advanced;
import bl4ckscor3.plugin.achievements2.achievements.Citizen;
import bl4ckscor3.plugin.achievements2.achievements.FromTheGrave;
import bl4ckscor3.plugin.achievements2.achievements.Millionaire;
import bl4ckscor3.plugin.achievements2.achievements.Oldschool;
import bl4ckscor3.plugin.achievements2.achievements.PvPBeginner;
import bl4ckscor3.plugin.achievements2.achievements.PvPBoss;
import bl4ckscor3.plugin.achievements2.achievements.PvPPro;
import bl4ckscor3.plugin.achievements2.achievements.Runaway;
import bl4ckscor3.plugin.achievements2.achievements.SecretAgent1;
import bl4ckscor3.plugin.achievements2.achievements.SecretAgent2;
import bl4ckscor3.plugin.achievements2.achievements.Sniff;
import bl4ckscor3.plugin.achievements2.achievements.Stalker;
import bl4ckscor3.plugin.achievements2.achievements.StoryTime;
import bl4ckscor3.plugin.achievements2.achievements.Stylish;
import bl4ckscor3.plugin.achievements2.achievements.Trapped;
import bl4ckscor3.plugin.achievements2.achievements.Trustworthy;
import bl4ckscor3.plugin.achievements2.achievements.WhatIsThisPlace;
import bl4ckscor3.plugin.achievements2.achievements.XPMadness;
import bl4ckscor3.plugin.achievements2.interfaces.IAchievement;
import bl4ckscor3.plugin.achievements2.interfaces.IProgressAchievement;
import bl4ckscor3.plugin.achievements2.util.Utilities;
import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles;

public class AchievementsExecutor implements CommandExecutor
{
	private static Plugin pl;
	public static final List<IAchievement> achievements = new ArrayList<IAchievement>();
	private static IAchievement hunter;
	
	public AchievementsExecutor(Plugin plugin)
	{
		pl = plugin;
		achievements.clear();
		achievements.add(new AchievementHunter());
		hunter = achievements.get(achievements.size() - 1);
		achievements.add(new Advanced());
		achievements.add(new Citizen());
		achievements.add(new FromTheGrave());
		achievements.add(new Millionaire());
		achievements.add(new Oldschool());
		achievements.add(new PvPBeginner());
		achievements.add(new PvPBoss());
		achievements.add(new PvPPro());
		achievements.add(new Runaway());
		achievements.add(new SecretAgent1());
		achievements.add(new SecretAgent2());
		achievements.add(new Sniff());
		achievements.add(new Stalker());
		achievements.add(new StoryTime());
		achievements.add(new Stylish());
		achievements.add(new Trapped());
		achievements.add(new Trustworthy());
		achievements.add(new WhatIsThisPlace());
		achievements.add(new XPMadness());
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

		if(args.length > 1)
		{
			bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "Too many arguments defined. Either use /a or /a <playername>!");
			return true;
		}

		if(args.length == 0) // /a
			openInventory(p, p.getName(), p.getUniqueId().toString());
		else // /a <player>
		{
			if(p.hasPermission("achievements.others.view"))
			{
				if(bl4ckkitCore.getPlayerManager().isPlayerOnline(args[0]))
					openInventory(p, args[0], Bukkit.getPlayer(args[0]).getUniqueId().toString());
				else
				{
					if(bl4ckkitCore.getPlayerManager().hasPlayedBefore(args[0]))
						openInventory(p, args[0], Bukkit.getOfflinePlayer(args[0]).getUniqueId().toString());
					else
						bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, args[0] + " has not visited this server yet.");
				}
			}
		}

		return true;
	}

	/**
	 * Opens the players achievement menu
	 * @param origin The player who issued the command
	 * @param name The name of the player to show the achievements of
	 * @param uuid The UUID of the player to show the achievements of
	 */
	private static void openInventory(Player origin, String name, String uuid)
	{
		Inventory inv = origin.getServer().createInventory(origin, 27, (origin.getName().equals(name) ? "Your Achievements" : "Achievements of " + name));

		for(IAchievement a : achievements)
		{
			boolean obtained = Utilities.hasAchievement(pl, uuid, a.getAchievementName());
			ItemStack stack = new ItemStack(obtained ? Material.getMaterial(pl.getConfig().getString("material.obtained")) : Material.getMaterial(pl.getConfig().getString("material.unobtained")));
			ItemMeta meta = stack.getItemMeta();
			List<String> lore = new ArrayList<String>();

			meta.setDisplayName(ChatColor.AQUA + a.getAchievementName());
			lore.add(ChatColor.GREEN + (obtained ? a.getAchievementSolution() : a.getAchievementTip()));

			if(a instanceof IProgressAchievement)
				lore.add(ChatColor.GREEN + "Progress: (" + Utilities.getProgress(pl, uuid, a.getAchievementName()) + "/" + ((IProgressAchievement)a).getRequiredProgress() + ")");

			meta.setLore(lore);
			stack.setItemMeta(meta);
			inv.addItem(stack);
		}

		origin.openInventory(inv);
	}

	/**
	 * Gives the achievement to the player
	 * @param p The player
	 * @param a The achievement
	 */
	public static void giveAchievement(Player p, IAchievement a)
	{
		if(Utilities.hasAchievement(pl, p.getUniqueId().toString(), a.getAchievementName()))
			return;

		File f = Utilities.getPlayerFile(pl, p.getUniqueId().toString());
		File t = Utilities.getTrackingFile(pl);
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		YamlConfiguration tracking = YamlConfiguration.loadConfiguration(t);
		int currentTrackingAmount = tracking.getInt(a.getAchievementName());
		
		yaml.set(a.getAchievementName() + ".obtained", true);
		tracking.set(a.getAchievementName(), ++currentTrackingAmount);
		
		try
		{
			yaml.save(f);
			tracking.save(t);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//particle type | x coord of particle | y coord | z coord | x offset (area of effect) | y offset | z offset | speed of particles (some particles move, some don't) | amount of particles (the bigger the offset the bigger this has to be)
		PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles("fireworksSpark", (float)p.getLocation().getX(), (float)p.getLocation().getY() + 2, (float)p.getLocation().getZ(), 0.5F, 0.5F, 0.5F, 0.0F, 50);

		for(Player player : Bukkit.getOnlinePlayers())
		{
			((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
			player.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 1.0F, 1.0F);
		}
		
		if(!a.getAchievementName().equals(hunter.getAchievementName()))
			giveProgress(p, hunter);
	}

	/**
	 * Increments progress of the achievement by one
	 * @param p The player
	 * @param a The achievement
	 */
	public static void giveProgress(Player p, IAchievement a)
	{
		if(Utilities.getProgress(pl, p.getUniqueId().toString(), a.getAchievementName()) == ((IProgressAchievement)a).getRequiredProgress())
			return;
		
		File f = Utilities.getPlayerFile(pl, p.getUniqueId().toString());
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		int current = yaml.getInt(a.getAchievementName() + ".progress");

		yaml.set(a.getAchievementName() + ".progress", ++current);

		try
		{
			yaml.save(f);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		if(yaml.getInt(a.getAchievementName() + ".progress") == ((IProgressAchievement)a).getRequiredProgress())
			giveAchievement(p, a);
	}
}
