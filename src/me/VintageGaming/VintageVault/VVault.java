package me.VintageGaming.VintageVault;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;
import java.util.HashMap;

public class VVault extends JavaPlugin {
	
	Plugin vp;
	Method[] permMethods;
	String PermsName;
	public static HashMap<String, Method> FMethods = new HashMap<String, Method>();
	
	@Override
	public void onEnable() {
		vp = this;
		Search s = new Search();
		s.search();
	}
	
	@Override
	public void onDisable() {
		
	}
}
