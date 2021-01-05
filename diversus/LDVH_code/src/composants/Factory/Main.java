/**
 * 
 */
package composants.Factory;


import java.io.IOException;
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
		demoB();
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
	public static void demoB() throws Exception {
		GestLivres gestLivres=(GestLivres) CFactory.createGestLivre();
		gestLivres.addLivre("Robinson Crusoé","Quentin");
		Livre livreDEMOB=(Livre) gestLivres.getLivre("Robinson Crusoé");
		livreDEMOB.createSection("Dans cette histoire, vous incarnez Robinson Crusoé. Vous vous réveillez sur une ile perdu en mer alors que vous aviez perdu connaissance et chercher maintenant a vous en echapper.\nfaites attention ou vous mettez les pieds, le chemin vers la liberté est semé d'embuche !", "Ile principale");
		livreDEMOB.createSection("Vous vous trouvez maintenant au bord de la mer, vous pouvez appercevoir l'ile principale ainsi qu'une ile secondaire qui a l'air habitée.", "Mer");
		livreDEMOB.createSection("vous venez d'arriver dans la jungle, un endroit très humide avez beaucoup de bruit d'animaux étrange.", "Jungle");
		livreDEMOB.createSection("vous venez d'arriver sur l'epave d'un bateau a moitié sous l'eau, elle regorge de petit trésor.", "Epave");
		livreDEMOB.createSection("vous arrivez dans un temple très sombre en ruine avec de nombreuses galerie et beaucoup d'objet abandonnées.", "Temple");
		livreDEMOB.createSection("vous arrivez dans un camp de pécheur ou se trouve une cabanne encore intacte, les autres ont été ravager par une tempete.", "Cabanne du pecheur");
		livreDEMOB.createSection("ENFIN vous parvenez a retrouver la civilisation, BRAVO a vous pour cette aventure", "Village");
		livreDEMOB.setTetedesection(livreDEMOB.getSection().get("Ile principale"));
		livreDEMOB.getSection().get("Ile principale").setTete(true);
		livreDEMOB.createObject("un radeau");
		livreDEMOB.createObject("une torche");
		livreDEMOB.createObject("une allumette");
		livreDEMOB.createObject("une bouteille de ruhm");
		livreDEMOB.createObject("une lance");
		livreDEMOB.createObject("une planche de bois");
		livreDEMOB.createObject("un collier en or");
		livreDEMOB.getSection().get("Ile principale").addObjet(livreDEMOB.getObjets().get("une allumette"));
		livreDEMOB.getSection().get("Ile principale").addObjet(livreDEMOB.getObjets().get("une bouteille de ruhm"));
		livreDEMOB.getSection().get("Epave").addObjet(livreDEMOB.getObjets().get("une planche de bois"));
		livreDEMOB.getSection().get("Epave").addObjet(livreDEMOB.getObjets().get("un collier en or"));
		livreDEMOB.getSection().get("Jungle").addObjet(livreDEMOB.getObjets().get("une lance"));
		livreDEMOB.getSection().get("Temple").addObjet(livreDEMOB.getObjets().get("un radeau"));
		livreDEMOB.getSection().get("Cabanne du pecheur").addObjet(livreDEMOB.getObjets().get("une torche"));
		List<IObjet> list1=new ArrayList<>();
		list1.add((IObjet)livreDEMOB.getObjets().get("un radeau"));
		List<IObjet> list2=new ArrayList<>();
		list2.add((IObjet)livreDEMOB.getObjets().get("une lance"));
		List<IObjet> list3=new ArrayList<>();
		list3.add((IObjet)livreDEMOB.getObjets().get("une torche"));
		list3.add((IObjet)livreDEMOB.getObjets().get("une allumette"));
		List<IObjet> list4=new ArrayList<>();
		list4.add((IObjet)livreDEMOB.getObjets().get("une planche de bois"));
		livreDEMOB.createEnchainement("Vous decidez de prendre le chemin de la securité vers la jungle mais guard a ce que vous trouverez là-bas !","Ile principale --> Jungle",(ISection) livreDEMOB.getSection().get("Ile principale"),(ISection) livreDEMOB.getSection().get("Jungle"),new ArrayList<IObjet>());
		livreDEMOB.createEnchainement("Vous voyez la mer et decider de vous y rendre, malheureusement il y a un requin vous ne pouvez donc pas nager...","Ile principale --> Mer",(ISection) livreDEMOB.getSection().get("Ile principale"),(ISection) livreDEMOB.getSection().get("Mer"),list1);
		livreDEMOB.createEnchainement("vous apercevez une epave aux loin au bord de l'eau mais il y a des etranges poissons carnivore qui rodent autours.","Ile principale --> Epave",(ISection) livreDEMOB.getSection().get("Ile principale"),(ISection) livreDEMOB.getSection().get("Epave"),list2);
		livreDEMOB.createEnchainement("vous decidez de revenir a l'ile principale où vous vous sentez plus en securité","Epave --> Ile principale",(ISection) livreDEMOB.getSection().get("Epave"),(ISection) livreDEMOB.getSection().get("Ile principale"),new ArrayList<IObjet>());
		livreDEMOB.createEnchainement("vous apercevez une cabanne au loin mais attention, vous risquez de ne pas pouvoir reprendre ce chemin dans l'autre sens, la pente est très raide.","Jungle --> Cabanne du pecheur",(ISection) livreDEMOB.getSection().get("Jungle"),(ISection) livreDEMOB.getSection().get("Cabanne du pecheur"),new ArrayList<IObjet>());
		livreDEMOB.createEnchainement("vous trouvez un chemin avec des lianes qui vous permet de revenir directement a l'ile principale","Cabanne du pecheur --> Ile principale",(ISection) livreDEMOB.getSection().get("Cabanne du pecheur"),(ISection) livreDEMOB.getSection().get("Ile principale"),new ArrayList<IObjet>());
		livreDEMOB.createEnchainement("vous appercevez un temple mais celui ci est tres sombre et si j'étais vous je n'oserai pas m'y aventurer dans le noir","Jungle --> Temple",(ISection) livreDEMOB.getSection().get("Jungle"),(ISection) livreDEMOB.getSection().get("Temple"),list3);
		livreDEMOB.createEnchainement("ce temple vous fait trop peur et decider dans sortir afin de retourner dans la jungle","Temple --> Jungle",(ISection) livreDEMOB.getSection().get("Temple"),(ISection) livreDEMOB.getSection().get("Jungle"),new ArrayList<IObjet>());
		livreDEMOB.createEnchainement("vous decidez de vous rendre sur l'ile principale","Mer --> Ile principale",(ISection) livreDEMOB.getSection().get("Mer"),(ISection) livreDEMOB.getSection().get("Ile principale"),list1);
		livreDEMOB.createEnchainement("vous decidez de vous rendre sur lile au village","Mer --> Village",(ISection) livreDEMOB.getSection().get("Mer"),(ISection) livreDEMOB.getSection().get("Village"),list4);
		livreDEMOB.createEnchainement("l'atmosphère de cette jungle pèse sur vous et choisissez de revenir à l'air libre sur l'ile principale","Jungle --> Ile principale",(ISection) livreDEMOB.getSection().get("Jungle"),(ISection) livreDEMOB.getSection().get("Ile principale"),new ArrayList<IObjet>());
		System.out.println("*****************************\n"+livreDEMOB.etatLivre());
		Analyse analyse=(Analyse) CFactory.createAnalyse(livreDEMOB);
		List<String> atteignables=analyse.Analyser_graphe();
		System.out.println("\nSections atteignables :");
		for(String s:atteignables) {
			System.out.print(s+" ");
		}
		Parser p = new Parser();
		p.generateHTML(livreDEMOB);
		p.generateImprimable(livreDEMOB);
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