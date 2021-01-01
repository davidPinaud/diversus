package livreTests;
import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import composants.CLivre.Livre;
import composants.Factory.CFactory;
import itf.*;
public class EnchainementTest {
	IGestLivre gest;
	ILivre livre ;
	ILivre livre2;
	ISection sectionVillage;
	ISection sectionDonjon;
	ISection sectionBoutique;
	List<ILivre> listeLivres;
	@Before
	
	public void setUp() {
		gest=CFactory.createGestLivre();
		
		
		 
	}
	@Test
	public void creerLivres() {
		gest.addLivre("Dream" , "felina");
		livre =gest.getLivre("Dream");
		// tester que le livre a été créé
		listeLivres=gest.getLivres();
		assertTrue(listeLivres.contains(livre));
		// ajout d'un deuxième livre
		gest.addLivre("Corbeau" , "Lafontaine");
		livre2 =gest.getLivre("Corbeau");
		listeLivres=gest.getLivres();
		assertTrue(listeLivres.contains(livre2));
		assertTrue(gest.contains("Dream"));
		
		assertEquals(livre, gest.getLivre("Dream"));
		assertEquals(livre2, gest.getLivre("Corbeau"));
		
	}
	
	

	
/*	@Test(expected=Exception.class)
	// livre déjà présent
	public void creerLivreExistant() {
		gest.addLivre("Dream", "Inas");
	}*/
	@Test
	public void modifierLivre() {
		ILivre livre3 =gest.getLivre("Dream");
		livre3.
		
	}
	

	@Test
	public void supprimerLivre() {
		gest.deleteLivre("Corbeau");
		assertFalse(gest.contains("Corbeau"));
	}
	
	@Test
	// long test
	public void AddDeleteLivre() {
		gest.addLivre("A" , "felina");
		gest.addLivre("B" , "felina");
		gest.addLivre("C" , "felina");
		gest.addLivre("D" , "felina");
		
		assertTrue(gest.contains("A"));
		assertTrue(gest.contains("B"));
		assertTrue(gest.contains("C"));
		assertTrue(gest.contains("D"));
		
		gest.deleteLivre("C");
		assertFalse(gest.contains("C"));
		assertTrue(gest.contains("A"));
		assertTrue(gest.contains("B"));
		assertTrue(gest.contains("D"));
		
		gest.deleteLivre("A");
		assertFalse(gest.contains("A"));
		gest.deleteLivre("B");
		gest.deleteLivre("D");
		assertFalse(gest.contains("B"));
		assertFalse(gest.contains("D"));
		
		
		
	}
	/*
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
        string[] expected1 = {"épée", "bouclier", "arc"};
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

*/
	

}
