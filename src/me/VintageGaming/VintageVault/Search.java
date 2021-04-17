package me.VintageGaming.VintageVault;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.bukkit.plugin.Plugin;

public class Search {
	
	VVault p = VVault.getPlugin(VVault.class);
	
	public void search() {
		for (Plugin plugin : p.getServer().getPluginManager().getPlugins()) {
			String PName = plugin.getName();
			
			Method[] methods = plugin.getClass().getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName() == "VVPermission" && VintagePermission.permsClass == null) {
				VintagePermission.permsClass = (Class) m.getReturnType();
				try {
					VintagePermission.permsInstance = VintagePermission.permsClass.newInstance();
					p.getLogger().info("[Permission] " + PName + " Was Hooked for Permissions");
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
					continue;
				}
				formatMethods(VintagePermission.permsClass.getDeclaredMethods(), VintagePermission.FMethods);
				continue;
				}
				if (m.getName() == "VVEconomy" && VintageEconomy.ecoClass == null) {
				VintageEconomy.ecoClass = (Class) m.getReturnType();
				try {
					VintageEconomy.ecoInstance = VintageEconomy.ecoClass.newInstance();
					p.getLogger().info("[Economy] " + PName + " Was Hooked for Economy");
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
					continue;
				}
				formatMethods(VintageEconomy.ecoClass.getDeclaredMethods(), VintageEconomy.ecoMethods);
				}
			}
		}
		if (VintagePermission.permsClass != null || VintageEconomy.ecoClass != null) return;
		p.getServer().getLogger().info("Couldn't Find Anything to Hook on to. GoodBye!");
		p.getServer().getPluginManager().disablePlugin(p);
	}
	
	public void formatMethods(Method[] methods, HashMap<String, Method> hm) {
		for (Method m : methods) {
			hm.put(m.getName(), m);
		}
	}
}
