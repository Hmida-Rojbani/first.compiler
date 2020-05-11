package de.tekup.first.compiler.alex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnityLexical {
	
	private String lexeme;
	private String attribut;
	private int val;
	private double valRel;

}
