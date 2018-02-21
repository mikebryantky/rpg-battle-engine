package com.millcreeksoftware.battle.util;

public class Logger {

	public synchronized static void log(String msg) {
		System.out.println(msg);
	}
	
}
