package de.tekup.first.compiler.alex;

import java.util.ArrayList;
import java.util.List;

public class Ids {
	
	private static List<String> ids = new ArrayList<>() ;
	
	public static int add(String s) {
		int index =ids.indexOf(s);
		if (index != -1) {
			return index;
		}
		ids.add(s);
		return ids.size()-1;
	}

}
