package de.tekup.first.compiler.alex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symbole {
	
	private String unityLex;
	private int rangeId;
	private String attribut;
	private int val;
	private double valRel;
	private String lex;

}
