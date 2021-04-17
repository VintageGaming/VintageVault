package me.VintageGaming.VintageVault;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class VintagePermission {
	
	VVault p = VVault.getPlugin(VVault.class);
	static HashMap<String, Method> FMethods = new HashMap<String, Method>();
	static Class permsClass;
	static Object permsInstance;
	
	
	public static String getName() {
		try {
			return (String) FMethods.get("getName").invoke(permsInstance);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static boolean addPlayerPermission(String player, String permission) {
		try {
			return (boolean) FMethods.get("addPlayerPermission").invoke(permsInstance, player, permission);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean removePlayerPermission(String player, String permission) {
		try {
			return (boolean) FMethods.get("removePlayerPermission").invoke(permsInstance, player, permission);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<String> getPlayersPermissions(String player) {
			try {
				return (List<String>) FMethods.get("getPlayersPermissions").invoke(permsInstance, player);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	public static boolean setPlayerGroup(String player, String group) {
			try {
				return (boolean) FMethods.get("setPlayerGroup").invoke(permsInstance, player, group);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
			
	}
	
	public static String getGroup(String player) {
			try {
				return (String) FMethods.get("getGroup").invoke(permsInstance, player);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	public static List<String> getGroups() {
		try {
			return (List<String>) FMethods.get("getGroups").invoke(permsInstance);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean createGroup(String group) {
			try {
				return (boolean) FMethods.get("createGroup").invoke(permsInstance, group);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public static boolean addGroupPermission(String group, String permission) {
			try {
				return (boolean) FMethods.get("addGroupPermission").invoke(permsInstance, group, permission);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public static boolean removeGroupPermission(String group, String permission) {
		try {
			return (boolean) FMethods.get("removeGroupPermission").invoke(permsInstance, group, permission);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
