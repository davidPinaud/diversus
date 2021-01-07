package livreTests;
import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import composants.Factory.CFactory;
import itf.*;
import java.util.Arrays;  
public class LivreTest {
	IGestLivre gest;
	ILivre livre ;
	ILivre livre2;
	ISection sectionVillage;
	ISection sectionDonjon;
	ISection sectionBoutique;
	List<ILivre> listeLivres;
	@Before
	
	public void setUp()  {
		gest=CFactory.createGestLivre();		
		
		 
	}
	@Test
	//test de gestLivre
	public void creerLivres() throws Exception{
		gest.addLivre("Dream" , "felina");
		livre =gest.getLivre("Dream");
		
		// tester que le livre a ete cree
		listeLivres=gest.getLivres();
		assertTrue(listeLivres.contains(livre));

		// ajout d'un deuxieme livre
		gest.addLivre("Corbeau" , "Lafontaine");
		livre2 =gest.getLivre("Corbeau");
		listeLivres=gest.getLivres();
		assertTrue(listeLivres.contains(livre2));
		assertTrue(gest.contains("Dream"));
		
		assertEquals(livre, gest.getLivre("Dream"));
		assertEquals(livre2, gest.getLivre("Corbeau"));
	}
	

	
	@Test(expected=Exception.class)
	
	// livre deja  present
	public void creerLivreExistant() throws Exception{
		gest.addLivre("Paradise" , "toto");
		gest.addLivre("Paradise" , "toto");
	}
	
	
	@Test
	public void supprimerLivre() throws Exception {
		gest.addLivre("Hell", "tata");
		gest.deleteLivre("Hell");
		assertFalse(gest.contains("Hell"));
	}
	
	@Test( expected=Exception.class)
	public void supprimerLivreNonExistant() throws Exception{
		gest.deleteLivre("Corbeau");
	}
	
	
	@Test
	// long test
	public void multipleBooksTest() throws Exception{
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
	
	// fonction qui initialise notre jeu de donnees pour le test d'integration
	public void initData(IGestLivre gest) throws Exception {
		gest.addLivre("Aventure", "Diversus");
		ILivre liv=gest.getLivre("Aventure");
		liv.createSection("Bienvenue dans l'aventure", "Village");
		liv.createSection("Ou est donc la potion magique", "Donjon");
		liv.createSection("L'occasion de vendre mes trouvailles", "Boutique");
		
		liv.setTete(liv.getSection("Village"));
		
		liv.createObject("epee");
		liv.createObject("bouclier");
		
		
	}
	
	
	// test d'integration Livre/Section/Enchainement
	@Test
	public void creerSections() throws Exception {
		IGestLivre gestTest=CFactory.createGestLivre();
		try {
			initData(gestTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ILivre book=gestTest.getLivre("Aventure");
		
		List<String> listSections = Arrays.asList("Village", "Boutique", "Donjon");
		assertEquals(listSections, book.getSectionNames());
		
	}
	
	@Test
	public void creerObjets() throws Exception {
		IGestLivre gestTest=CFactory.createGestLivre();
		try {
			initData(gestTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ILivre book=gestTest.getLivre("Aventure");
		
		List<String> listObjects = Arrays.asList("epee", "bouclier"); 
		assertEquals(listObjects, book.getObjectNames());
		
	}
	
	@Test
	public void ajouterObjetaSection() throws Exception {
		IGestLivre gestTest=CFactory.createGestLivre();
		try {
			initData(gestTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ILivre book=gestTest.getLivre("Aventure");
		ISection section = book.getSection("Village");
		IObjet ob = book.getObjet("epee");
		section.addObjet(ob);
		List<IObjet> listObjects = Arrays.asList(ob);
		assertEquals(listObjects, section.getObjets());
	}
	
	@Test
	public void ajouterEnchainement() throws Exception {
		IGestLivre gestTest=CFactory.createGestLivre();
		try {
			initData(gestTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ILivre book=gestTest.getLivre("Aventure");
		ISection src = book.getSection("Village");
		ISection dest = book.getSection("Donjon");
		IObjet objet = book.getObjet("epee");
		List<IObjet> listObjects = Arrays.asList(objet);
		
		
		assertFalse(book.EnchainementExists(src, dest));
		book.createEnchainement("Tunnel", "chemin périlleux vers le donjon", src, dest, listObjects);
		assertTrue(book.EnchainementExists(src, dest));

		IEnchainement enchainement = book.getEnchainement("Tunnel");
				
		
		assertEquals(enchainement.getObjets(), listObjects);
		assertEquals(enchainement.getSource(), src.getNom());
		assertEquals(enchainement.getDestination(), dest.getNom());
		assertEquals(enchainement.getNom(), "Tunnel");
	}
	
	@Test
	public void supprimerSection() throws Exception {
		IGestLivre gestTest=CFactory.createGestLivre();
		try {
			initData(gestTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ILivre book=gestTest.getLivre("Aventure");
		
		//ISection sec = book.getSection("Boutique");
		assertFalse(book.isTete("Boutique"));
		book.deleteSection("Boutique");
		List<String> listSections = Arrays.asList("Village", "Donjon");
		assertEquals(listSections, book.getSectionNames());
	}
	
	@Test
	public void atteignabilite() throws Exception {
		IGestLivre gestTest=CFactory.createGestLivre();
		try {
			initData(gestTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ILivre book=gestTest.getLivre("Aventure");
		ISection src = book.getSection("Village");
		ISection dest = book.getSection("Donjon");
		IObjet objet = book.getObjet("epee");
		List<IObjet> listObjects = Arrays.asList(objet);
		
		assertFalse(book.EnchainementExists(src, dest));
		book.createEnchainement("Tunnel", "chemin périlleux vers le donjon", src, dest, listObjects);
		
		List<String> nexts = src.getNextAtteignable();
		List<String> expected = new ArrayList<String>();
		assertEquals(expected, nexts);
		
		src.addObjet(objet);
		nexts = src.getNextAtteignable();
		List<String> expected2 =  Arrays.asList("Donjon");
		assertEquals(expected2, nexts);
	}
		
	
}