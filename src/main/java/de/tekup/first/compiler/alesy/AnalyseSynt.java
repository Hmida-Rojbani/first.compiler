package de.tekup.first.compiler.alesy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

import de.tekup.first.compiler.alex.AnalyseLex;

public class AnalyseSynt {
	
	public static void analyse(String data) {
		List<String> tmptampon = AnalyseLex.analyse(data).stream()
													   .map(s -> s.getLex())
													   .collect(Collectors.toList());
		tmptampon.add("$");
		
		Queue<String> tampon = new LinkedList<>(tmptampon);
		
			Stack<String> stack = new Stack<>();
			stack.push("$");
			stack.push("S");
			
			
			
			
			while (!stack.peek().equals("$") && !tampon.peek().equals("$")) {
				System.out.print(stack);
				System.out.print("     |     ");
				System.out.println(tampon);
				
				String tete_stack = stack.peek();
				String tete_tampon = tampon.peek();
						
				if(tete_stack.equals("S") || tete_stack.equals("E") || tete_stack.equals("E'")) {
					List<String> regle = TableAnalyse.production(tete_stack, tete_tampon);
					
					if (regle != null) {
						if(regle.get(0).equals("eps")) {
							stack.pop();
						} else if(regle.get(0).equals("sync")) {
							String tmp = stack.pop();;
							System.err.println(tmp + " mal formé");
						} else {
							stack.pop();
							for (int i = regle.size()-1; i >=0 ; i--) {
							stack.push(regle.get(i));
						}
						}

					} else {
						String tmp = tampon.poll();
						System.err.println(tmp + " mal inseré");
					}
					

					
				} 
				else {
					if(tete_stack.equals(tete_tampon)) {
						stack.pop();
						tampon.poll();
					}
					else {
						String tmp = stack.pop();;
						System.err.println(tmp + " manquant");
					}
				}
			}
			System.out.print(stack);
			System.out.print("     |     ");
			System.out.println(tampon);
		
	}

}
