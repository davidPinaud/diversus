/**
 * 
 */
package composants.Factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import composants.CAnalyse.Analyse;
import composants.CIHM.GestIHM;
import composants.CLivre.GestLivres;
import composants.CLivre.Livre;
import composants.CLivre.Objets;
import composants.CLivre.Section;
import itf.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Main {

	/*IAffichageGraphique ag = CFactory.createAffichageGraphique();
	IAnalyse analyse = CFactory.createAnalyse();
	ILivre livre = CFactory.createLivre("livre");
	ILivreController controller = CFactory.createController();
	IParser parser = CFactory.createParser();
	GestIHM ihm = CFactory.createIHM();*/
	
	public static void main(String[] args) {
		demoA();
	}
	
	/**
	 * DemoA :
	 * Creer un livre
	 * Ajouter 3 sections
	 * 	Section A
	 * 	Section B
	 * 		Objet "épée"
	 * 	Section C
	 * 2 enchainements
	 * 	B-->C
	 * 		Objet "épée"
	 * 	A-->B
	 * 1 Objet
	 */
	public static void demoA() {
		GestLivres gestLivres=(GestLivres) CFactory.createGestLivre();
		gestLivres.addLivre("DemoA","Test");
		Livre livreDEMOA=(Livre) gestLivres.getLivre("DemoA");
		livreDEMOA.createSection("Entrée", "Section A");
		livreDEMOA.createSection("Milieu", "Section B");
		System.out.println(livreDEMOA.etatLivre());
		livreDEMOA.createSection("Sortie", "Section C");
		livreDEMOA.createObject("épée");
		livreDEMOA.getSection().get("Section B").addObjet(livreDEMOA.getObjets().get("épée"));
		List<IObjet> list=new ArrayList<>();
		list.add((IObjet)livreDEMOA.getObjets().get("épée"));
		livreDEMOA.createEnchainement("A-->B","Je vais au milieu",(ISection) livreDEMOA.getSection().get("Section A"),(ISection) livreDEMOA.getSection().get("Section B"),list);
		livreDEMOA.createEnchainement("B-->C","Je vais à la fin",(ISection) livreDEMOA.getSection().get("Section B"),(ISection) livreDEMOA.getSection().get("Section C"), new ArrayList<IObjet>());
		System.out.println("*****************************\n"+livreDEMOA.etatLivre());
		//System.out.println("Analyse : ");
	}
	public void demoB() {
		System.out.println();
	}
	public void demoC() {
		System.out.println();
	}
	public void demoD() {
		System.out.println();
	}
	public void demoE() {
		System.out.println();
	}
	public void demoF() {
		System.out.println();
	}
	
}