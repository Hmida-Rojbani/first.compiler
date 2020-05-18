package de.tekup.first.compiler.alex;

import java.util.ArrayList;
import java.util.List;

public class AnalyseLex {
	
	public static List<Symbole> analyse(String data) {
		List<Symbole> list = new ArrayList<Symbole>();
		int index = 0;
		Symbole sb = null;
		while (index < data.length()) {
			char c = data.charAt(index);
			if( c == ' ' || c == '\t' || c== '\n'){
				index ++;
			}else if (Character.isAlphabetic(c) ) {
				sb = new Symbole();
				index = automate_id(data, index, sb);
				list.add(sb);
			} else if(Character.isDigit(c)) {
				sb = new Symbole();
				index = automate_nb(data, index, sb);
				list.add(sb);
			} else if(c == '>') {
				sb = new Symbole();
				index = automate_pg(data, index, sb);
				list.add(sb);
			} else if(c == '<') {
				sb = new Symbole();
				index = automate_pp(data, index, sb);
				list.add(sb);
			} else if(c == '=') {
				sb = new Symbole();
				index = automate_eg(data, index, sb);
				list.add(sb);
			} else if(c == '+') {
				sb = new Symbole();
				index = automate_plus(data, index, sb);
				list.add(sb);
			} else if(c == '-') {
				sb = new Symbole();
				index = automate_moins(data, index, sb);
				list.add(sb);
			} else if(c == '*') {
				sb = new Symbole();
				index = automate_mul(data, index, sb);
				list.add(sb);
			} else if(c == '/') {
				sb = new Symbole();
				index = automate_div(data, index, sb);
				list.add(sb);
			} else if(c == ':') {
				sb = new Symbole();
				index = automate_dp(data, index, sb);
				list.add(sb);
			} else if(c == ';') {
				sb = new Symbole();
				index = automate_pv(data, index, sb);
				list.add(sb);
			} else if(c == '(') {
				sb = new Symbole();
				index = automate_po(data, index, sb);
				list.add(sb);
			} else if(c == ')') {
				sb = new Symbole();
				index = automate_pf(data, index, sb);
				list.add(sb);
			}
			
			else {
				index ++;
			}
			
		}
		
		return list;
	}
	
	private static int automate_dp(String data, int index, Symbole sb) {
		
		int etat =0;
		
		while (etat != 2 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == ':') {
					etat = 1;

				}
				break;
			
			case 1:
				if( c =='=') {
					etat =2;
					sb.setUnityLex("opaff");
					sb.setAttribut(":=");
					sb.setLex(":=");
					break;
				}
				else {
					etat = 2;
					
					sb.setUnityLex("sep");
					sb.setAttribut(":");
					sb.setLex(":");
					index --;
				}

				break;
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_plus(String data, int index, Symbole sb) {
		int etat =0;
		
		while (etat != 1 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == '+') {
					etat = 1;
					sb.setUnityLex("oparth");
					sb.setAttribut("add");
					sb.setLex("+");

				}
				break;
			
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_moins(String data, int index, Symbole sb) {
		int etat =0;
		
		while (etat != 1 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == '-') {
					etat = 1;
					sb.setUnityLex("oparth");
					sb.setAttribut("soustr");
					sb.setLex("-");

				}
				break;
			
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_mul(String data, int index, Symbole sb) {
		int etat =0;
		
		while (etat != 1 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == '*') {
					etat = 1;
					sb.setUnityLex("oparth");
					sb.setAttribut("mul");
					sb.setLex("*");


				}
				break;
			
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_div(String data, int index, Symbole sb) {
		int etat =0;
		
		while (etat != 1 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == '/') {
					etat = 1;
					sb.setUnityLex("oparth");
					sb.setAttribut("div");
					sb.setLex("/");


				}
				break;
			
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_eg(String data, int index, Symbole sb) {
		int etat =0;
		
		while (etat != 1 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == '=') {
					etat = 1;
					sb.setUnityLex("oprel");
					sb.setAttribut("EGA");
					sb.setLex("=");


				}
				break;
			
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_pv(String data, int index, Symbole sb) {
		int etat =0;
		
		while (etat != 1 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == ';') {
					etat = 1;
					sb.setUnityLex("sep");
					sb.setAttribut(";");
					sb.setLex(";");


				}
				break;
			
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_po(String data, int index, Symbole sb) {
		int etat =0;
		
		while (etat != 1 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == '(') {
					etat = 1;
					sb.setUnityLex("sep");
					sb.setAttribut("(");
					sb.setLex("(");


				}
				break;
			
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_pf(String data, int index, Symbole sb) {
		int etat =0;
		
		while (etat != 1 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == ')') {
					etat = 1;
					sb.setUnityLex("sep");
					sb.setAttribut(")");
					sb.setLex(")");


				}
				break;
			
			}
			index++;
		}
		
		return index;
	}
	private static int automate_pp(String data, int index, Symbole sb) {
		StringBuilder lexem = new StringBuilder("");
		int etat =0;
		
		while (etat != 4 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == '<') {
					etat = 1;
					lexem.append(c);

				}
				break;
			
			case 1:
				if( c =='=') {
					etat =2;
					lexem.append(c);
				}
				else if( c =='>') {
					etat = 3;
					lexem.append(c);
				}
				else {
					etat = 4;
					
					sb.setUnityLex("oprel");
					sb.setAttribut("PPQ");
					sb.setLex("<");
					index --;
				}

				break;
			case 2:
				etat = 4;
				
				sb.setUnityLex("oprel");
				sb.setAttribut("PPE");
				sb.setLex("<=");
				index --;
				break;
			case 3:
				etat = 4;
				
				sb.setUnityLex("oprel");
				sb.setAttribut("DIF");
				sb.setLex("<>");
				index --;
				break;
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_pg(String data, int index, Symbole sb) {
		StringBuilder lexem = new StringBuilder("");
		int etat =0;
		
		while (etat != 3 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(c  == '>') {
					etat = 1;
					lexem.append(c);

				}
				break;
			
			case 1:
				if( c =='=') {
					etat =2;
					lexem.append(c);
				}
				else {
					etat = 3;
					
					sb.setUnityLex("oprel");
					sb.setAttribut("PGQ");
					sb.setLex(">");
					index --;
				}

				break;
			case 2:
				etat = 3;
				
				sb.setUnityLex("oprel");
				sb.setLex(">=");
				sb.setAttribut("PGE");
				index --;
				break;
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_nb(String data, int index, Symbole sb) {
		StringBuilder lexem = new StringBuilder("");
		int etat =0;
		
		while (etat != 3 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(Character.isDigit(c)) {
					etat = 1;
					lexem.append(c);

				}
				break;
			
			case 1:
				if( c =='.') {
					etat =2;
					lexem.append(c);
				}
				else if(!Character.isDigit(c) ) {
					etat = 3;
					
					sb.setUnityLex("nb");
					sb.setLex("nb");
					sb.setVal(Integer.parseInt(lexem.toString()));
					index --;
				}
				else
				{
					lexem.append(c);

				}
				break;
			case 2:
				if(!Character.isDigit(c) ) {
					etat = 3;
					
					sb.setUnityLex("nbr");
					sb.setLex("nbr");
					sb.setValRel(Double.parseDouble(lexem.toString()));
					index --;
				}
				else
				{
					lexem.append(c);

				}
				break;
			}
			index++;
		}
		
		return index;
	}
	
	private static int automate_id(String data, int index, Symbole sb) {
		
		StringBuilder lexem = new StringBuilder("");
		int etat =0;
		
		while (etat != 2 && index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if(Character.isAlphabetic(c)) {
					etat = 1;
					lexem.append(c);

				}
				break;
			
			case 1:
				if(!Character.isAlphabetic(c) && !Character.isDigit(c)) {
					etat = 2;
					// TODO check with KeyWord Array, Ids Array
					if (KeyWord.in(lexem.toString())) {
						sb.setUnityLex("keyWord");
						sb.setAttribut(lexem.toString());
						sb.setLex(lexem.toString());
						sb.setRangeId(-1);
					} else {
						sb.setUnityLex("id");
						sb.setAttribut(lexem.toString());
						sb.setLex("id");
						sb.setRangeId(Ids.add(lexem.toString()));
					}
					
					
					index --;
				}
				else
				{
					lexem.append(c);

				}
				break;
			}
			index++;
		}
		
		
		return index;
	}

}
