package livreTests;
import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import composants.CLivre.Livre;
import composants.Factory.CFactory;
import itf.*;
public class EnchainementTest {
	ILivre livre ;
	@Before
	public void setUp() {
		 livre = CFactory.createLivre("Zèle");
		 
	}
    @Test
    public void editerLivreTest(){

        
        assertEquals("Zèle", livre.getNom());
        
        Section section = livre.createSection("Vilage");
        assertTrue(sectionExist("Vilage"));

        section.setNom("Village");
        assertEquals("Village", section.getNom);
        assertEquals("", section.getObjets());
        assertEquals(void, livre.getNextAtteignable());

        livre.setTeteSection(section);

        Objet obj1 = livre.createObjet("épée");
        assertEquals("épée", obj1.getNom);

        Objet obj2 = livre.createObjet("bouclier");
        Objet obj3 = livre.createObjet("arc");

        section.addObjet(obj1);
        section.addObjet(obj2);
        section.addObjet(obj3);
        String[] expected1 = {"épée", "bouclier", "arc"};
        assertEquals(expected1, section.getObjets());


        section.deleteObjet(obj1);
        string[] expected2 = {"bouclier", "arc"};
        assertEquals(expected2, section.getObjets());
        assertEquals(expected1, livre.getObjets());

        Section section2 = createSection("Donjon");
        //entrer enchainement village vers donjon


        obj2.deleteObjet();
        assertEquals({"arc"}, section.getObjets());
        assertEquals({"épée", "arc"}, livre.getObjets());

        assertEquals({"Donjon"}, section.getNextAtteignable());

        string[] expected3 = {"Village", "Donjon"};
        assertEquals(expected3, livre.listerSection());

        livre.supprimerSection("Donjon");
        assertEquals({"Village"}, livre.listerSection());

        assertTrue(supprimerLivre("Zèle"));


    }
	

	@Test
	public void testCreerEnchainement() {
		
		// test de getSection
		ArrayList<ISection> sections=livre.getSections();
		
		assertEquals("Village", sections.get(0).getNom() );
		assertEquals("Donjon", sections.get(1).getNom());
		assertEquals("Boutique", sections.get(2).getNom());
		

		// test getObjet
		ArrayList<IObjet> objets=livre.getObjets();
		assertEquals("épée", objets.get(0).getNom() );
		assertEquals("bouclier", objets.get(1).getNom());
		assertEquals("arc", objets.get(2).getNom());
		
		//test getEnchainements
		ArrayList<IEnchainement> enchainements= livre.getEnchainements();
		assertEquals(enchainements.isEmpty(), true);
		// creation d'un enchaînement
		ArrayList<IObjet> required=new ArrayList<IObjet>();
		required.add(objets.get(0));
		IEnchainement ench=livre.createEnchainement("passage dans le noir", "tunnel",sections.get(0).getNom(), sections.get(1).getNom(), required );
		livre.AddEnchainement("tunnel", "passage dans le noir",sections.get(0), sections.get(1), required );
		enchainements= livre.getEnchainements();
		// il faut définir une fonction equals dans enchainement
		assertEquals(enchainements.get(0), ench);
		
		
		// modifier l'enchaînement
	
		assertEquals(enchainements.get(0).getNom(), "tunnel");
		// modifier la source
		assertEquals(enchainements.get(0).getSource(), sections.get(0));
		livre.modifEnchainement("tunnel", "passage dans le noir",sections.get(2) , sections.get(1), required);
		assertEquals(enchainements.get(0).getSource(), sections.get(2));
		//modifier la destination
		assertEquals(enchainements.get(0).getDestination(), sections.get(1));
		livre.modifEnchainement("tunnel", "passage dans le noir",sections.get(2) , sections.get(0), required);
		assertEquals(enchainements.get(0).getDestination(), sections.get(0));
		//modifier l'objet
		assertEquals(enchainements.get(0).getObjets().get(0).getNom(),"épée" );
		required.remove(0);
		required.add(objets.get(1));
		livre.modifEnchainement("tunnel", "passage dans le noir",sections.get(2) , sections.get(0), required);
		assertEquals(enchainements.get(0).getObjets().get(0).getNom(),"bouclier" );
		
		
		// supprimer l'enchainement
		String nom="tunnel"
		livre.deleteEnchainement(nom);
		assertEquals(livre.getEnchainements().isEmpty(), true);
	}


	

}
