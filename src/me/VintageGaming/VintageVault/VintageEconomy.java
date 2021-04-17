package me.VintageGaming.VintageVault;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class VintageEconomy {

	static Class ecoClass;
	static HashMap<String, Method> ecoMethods = new HashMap<String, Method>();
	VVault p = VVault.getPlugin(VVault.class);
	static Object ecoInstance;
	
	public static String getName() {
		try {
			return (String) ecoMethods.get("getName").invoke(ecoInstance);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static double getBalance(String player) {
		try {
			return (double) ecoMethods.get("getBalance").invoke(ecoInstance, player);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static double deposit(String player, double amount) {
		try {
			return (double) ecoMethods.get("addToBalance").invoke(ecoInstance, player, amount);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static double withdraw(String player, double amount) {
		try {
			return (double) ecoMethods.get("withdraw").invoke(ecoInstance, player, amount);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
