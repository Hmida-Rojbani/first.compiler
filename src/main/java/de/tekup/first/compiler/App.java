package de.tekup.first.compiler;

import java.util.List;

import de.tekup.first.compiler.alesy.AnalyseSynt;
import de.tekup.first.compiler.alex.AnalyseLex;
import de.tekup.first.compiler.alex.Symbole;
import de.tekup.first.compiler.reader.ReadTextAsString;

public class App 
{
    public static void main( String[] args )
    {
    	String s = ReadTextAsString.readFileAsString("C:\\Users\\TekSliver\\Desktop\\test_compiler\\test.txt");
        /*List<Symbole> list = AnalyseLex.analyse(s);
    	System.out.println( list.size() );
    	System.out.println(list);*/
    	
    	AnalyseSynt.analyse(s);
    }
}
