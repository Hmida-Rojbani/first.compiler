package de.tekup.first.compiler;

import de.tekup.first.compiler.alex.AnalyseLex;
import de.tekup.first.compiler.reader.ReadTextAsString;

public class App 
{
    public static void main( String[] args )
    {
    	String s = ReadTextAsString.readFileAsString("C:\\Users\\TekSliver\\Desktop\\test_compiler\\test.txt");
        System.out.println( s );
        System.out.println(AnalyseLex.analyse(s));
    }
}
