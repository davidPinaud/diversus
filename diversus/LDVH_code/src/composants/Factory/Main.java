/**
 * 
 */
package composants.Factory;


import java.util.ArrayList;
import java.util.List;

import composants.CAnalyse.Analyse;
import composants.CIHM.GestIHM;
import composants.CLivre.GestLivres;
import composants.CLivre.Livre;
import composants.CLivre.Objets;
import composants.CLivre.Section;
import composants.CParser.Parser;
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
	
	public static void main(String[] args) throws Exception {
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
	 * 	A-->D
	 * 		Objet "Bouclier"
	 * 1 Objet
	 * @throws Exception 
	 */
	public static void demoA() throws Exception {
		GestLivres gestLivres=(GestLivres) CFactory.createGestLivre();
		gestLivres.addLivre("DemoA","Test");
		Livre livreDEMOA=(Livre) gestLivres.getLivre("DemoA");
		livreDEMOA.createSection("Entrée", "Section A");
		livreDEMOA.createSection("Milieu", "Section B");
		livreDEMOA.createSection("Sortie", "Section C");
		livreDEMOA.createSection("a coté", "Section D");
		livreDEMOA.setTetedesection(livreDEMOA.getSection().get("Section A"));
		livreDEMOA.getSection().get("Section A").setTete(true);
		livreDEMOA.createObject("épée");
		livreDEMOA.createObject("Bouclier");
		livreDEMOA.getSection().get("Section B").addObjet(livreDEMOA.getObjets().get("épée"));
		livreDEMOA.getSection().get("Section A").addObjet(livreDEMOA.getObjets().get("Bouclier"));
		List<IObjet> list=new ArrayList<>();
		list.add((IObjet)livreDEMOA.getObjets().get("épée"));
		List<IObjet> list2=new ArrayList<>();
		list2.add((IObjet)livreDEMOA.getObjets().get("Bouclier"));
		livreDEMOA.createEnchainement("A-->B","Je vais au milieu",(ISection) livreDEMOA.getSection().get("Section A"),(ISection) livreDEMOA.getSection().get("Section B"),new ArrayList<IObjet>());
		livreDEMOA.createEnchainement("B-->C","Je vais à la fin",(ISection) livreDEMOA.getSection().get("Section B"),(ISection) livreDEMOA.getSection().get("Section C"), list);
		livreDEMOA.createEnchainement("A-->D","Je vais à coté",(ISection) livreDEMOA.getSection().get("Section A"),(ISection) livreDEMOA.getSection().get("Section D"),list2);
		System.out.println("*****************************\n"+livreDEMOA.etatLivre());
		Analyse analyse=(Analyse) CFactory.createAnalyse(livreDEMOA);
		List<String> atteignables=analyse.Analyser_graphe();
		System.out.println("\nSections atteignables :");
		for(String s:atteignables) {
			System.out.print(s+" ");
		}
		Parser p = new Parser();
		p.generateHTML(livreDEMOA);
		p.generateImprimable(livreDEMOA);
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