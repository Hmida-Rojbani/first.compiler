package de.tekup.first.compiler.alex;

import java.util.ArrayList;
import java.util.List;

public class AnalyseLex {

	public static List<UnityLexical> analyse(String data) {
		data = data + '\n';
		// return list of UL
		List<UnityLexical> list = new ArrayList<UnityLexical>();
		int index = 0;
		int etat = 0;
		while (index < data.length()) {
			char c = data.charAt(index);
			switch (etat) {
			case 0:
				if (c == ' ' || c == '\n' || c == '\t') {
					etat = 0;
					index++;
				} else if (Character.isAlphabetic(c)) {

					UnityLexical ul = new UnityLexical();
					index = automate_id(data, index, etat, ul);
					list.add(ul);
				} else if (Character.isDigit(c)) {

					UnityLexical ul = new UnityLexical();
					index = automate_nb(data, index, etat, ul);
					list.add(ul);
				}
				else if (c == ':') {

					UnityLexical ul = new UnityLexical();
					index = automate_dp(data, index, etat, ul);
					list.add(ul);
				}
				else if (c == '>') {

					UnityLexical ul = new UnityLexical();
					index = automate_pg(data, index, etat, ul);
					list.add(ul);
				}

			}
		}
		return list;
	}

	private static int automate_pg(String data, int index, int etat, UnityLexical ul) {
		char c = data.charAt(index);
		StringBuilder lexem = new StringBuilder("");

		while (etat != 3 && index < data.length()) {
			c = data.charAt(index);
			switch (etat) {
			case 0:
				if (c == '>') {
					etat = 1;
					lexem.append(c);
				}

				break;
			case 1:
				if (c == '=') {
					etat = 2;
					lexem.append(c);
				} else {
					etat = 3;
					index--;
					ul.setLexeme("oprel");
					ul.setAttribut("PGQ");
				}
				break;
			case 2:
				etat = 3;
				index--;
				ul.setLexeme("oprel");
				ul.setAttribut("PGE");
				
				break;

			}
			index++;
		}

		return index;
	}

	private static int automate_dp(String data, int index, int etat, UnityLexical ul) {
		char c = data.charAt(index);
		StringBuilder lexem = new StringBuilder("");

		while (etat != 3 && index < data.length()) {
			c = data.charAt(index);
			switch (etat) {
			case 0:
				if (c == ':') {
					etat = 1;
					lexem.append(c);
				}

				break;
			case 1:
				if (c == '=') {
					etat = 2;
					lexem.append(c);
				} else {
					etat = 3;
					index--;
					ul.setLexeme("dp");
					ul.setAttribut(":");
				}
				break;
			case 2:
				etat = 3;
				index--;
				ul.setLexeme("affect");
				ul.setAttribut(":=");
				
				break;

			}
			index++;
		}

		return index;
	}

	private static int automate_nb(String data, int index, int etat, UnityLexical ul) {
		char c = data.charAt(index);
		StringBuilder lexem = new StringBuilder("");

		while (etat != 3 && index < data.length()) {
			c = data.charAt(index);
			switch (etat) {
			case 0:
				if (Character.isDigit(c)) {
					etat = 1;
					lexem.append(c);
				}

				break;
			case 1:
				if (c == '.') {
					etat = 2;
					lexem.append(c);
				} else if (!Character.isDigit(c)) {
					etat = 3;
					index--;
					ul.setLexeme("nb");
					ul.setVal(Integer.parseInt(lexem.toString()));
				} else
					lexem.append(c);
				break;
			case 2:
				if (!Character.isDigit(c)) {
					etat = 3;
					index--;
					ul.setLexeme("nbr");
					ul.setValRel(Double.parseDouble(lexem.toString()));
				} else
					lexem.append(c);
				break;

			}
			index++;
		}

		return index;
	}

	private static int automate_id(String data, int index, int etat, UnityLexical ul) {

		char c = data.charAt(index);
		StringBuilder lexem = new StringBuilder("");

		while (etat != 2 && index < data.length()) {
			c = data.charAt(index);
			// System.out.println("c : "+c);
			switch (etat) {
			case 0:
				if (Character.isAlphabetic(c)) {
					etat = 1;
					lexem.append(c);
				}

				break;
			case 1:
				if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != '_') {
					etat = 2;
					// TODO veréfier avec tableau de mots clés, veréfier et ajouter dans tableau les
					// ids lexem.toString()
					index--;
					ul.setLexeme("id");
				} else
					lexem.append(c);
				break;

			}
			index++;
		}

		return index;

	}

}
