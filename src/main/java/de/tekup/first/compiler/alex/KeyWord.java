package de.tekup.first.compiler.alex;

import java.util.Arrays;
import java.util.List;

public class KeyWord {
	
	private static List<String> keywrods;
	
	static {
		keywrods = Arrays.asList("var","integer","float");
	}
	
	public static boolean in(String s) {
		return keywrods.contains(s);
	}

}
