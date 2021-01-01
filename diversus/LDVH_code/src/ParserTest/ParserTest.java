package ParserTest;
import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import composants.CParser.Parser;
import composants.Factory.CFactory;
import itf.*;

public class ParserTest {

	ILivre livre ;
	IParser parser;
	public void creation() {
		
	livre = CFactory.createLivre("Jungle");
	 parser=CFactory.createParser(livre);
		 
	}
	@Test
    public void parserTest(){

        
        assertEquals("Jungle", livre.getNom());
       String section1 = livre.createSection("sec1");
        assertTrue(livre.sectionExist("sec1"));

        livre.addObjet("obj1");
        assertEquals("obj1", livre.getObjets());
        
       String nom_fichier_pdf= parser.generateImprimable();
       assertEquals("Jungle.pdf", nom_fichier_pdf);
       
       
       String nom_fichier_html= parser.generateHTML();
       assertEquals("Jungle.html", nom_fichier_html);

}}
