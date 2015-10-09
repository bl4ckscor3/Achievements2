package bl4ckscor3.plugin.achievements2.core;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.achievements2.listener.InventoryClickListener;
import bl4ckscor3.plugin.achievements2.listener.PlayerJoinListener;
import bl4ckscor3.plugin.achievements2.listener.RegionEnteredListener;
import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class Achievements2 extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		bl4ckkitCore.registerPlugin(this);
		Config.setup(this);
		getCommand("a").setExecutor(new AchievementsExecutor(this));
		getCommand("atrack").setExecutor(new TrackExecutor(this));
		
		try
		{
			TrackExecutor.setupTrackingFile();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		bl4ckkitCore.getPluginManager().registerEvents(this, 
				new PlayerJoinListener(this), 
				new RegionEnteredListener(),
				new InventoryClickListener(this));
		bl4ckkitCore.getMessageManager().sendEnabledMessage(this);
	}
	
	@Override
	public void onDisable()
	{
		bl4ckkitCore.unregisterPlugin(this);
		bl4ckkitCore.getMessageManager().sendDisabledMessage(this);
	}
}
