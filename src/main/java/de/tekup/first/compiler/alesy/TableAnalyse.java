package de.tekup.first.compiler.alesy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.tekup.first.compiler.alesy.Couple;

public class TableAnalyse {
	
	private static Map<Couple, List<String>> map = new HashMap<Couple, List<String>>();
	
	static {
		map.put(new Couple("S","id"), Arrays.asList("id",":=","E",";"));
		map.put(new Couple("E","id"), Arrays.asList("id","E'"));
		map.put(new Couple("E","nb"), Arrays.asList("nb","E'"));
		map.put(new Couple("E'","+"), Arrays.asList("+","E","E'"));
		map.put(new Couple("E'","-"), Arrays.asList("-","E","E'"));
		map.put(new Couple("E'","*"), Arrays.asList("*","E","E'"));
		map.put(new Couple("E'","/"), Arrays.asList("/","E","E'"));
		map.put(new Couple("E","("), Arrays.asList("(","E",")","E'"));
		map.put(new Couple("E'",";"), Arrays.asList("eps"));
		map.put(new Couple("E",";"), Arrays.asList("sync"));
		map.put(new Couple("E",")"), Arrays.asList("sync"));
		map.put(new Couple("E","+"), Arrays.asList("sync"));
		map.put(new Couple("E","-"), Arrays.asList("sync"));
		map.put(new Couple("E","*"), Arrays.asList("sync"));
		map.put(new Couple("E","/"), Arrays.asList("sync"));
		map.put(new Couple("S","$"), Arrays.asList("sync"));
		
	}
	
	public static List<String> production(String NT, String SE){
		
		return map.get(new Couple(NT,SE));
	}

}
