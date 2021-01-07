package ParserTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

//import org.hamcrest.Factory;

import composants.CLivre.Livre;
import composants.CLivre.Objets;
import composants.CLivre.Section;
import itf.IEnchainement;
//import composants.Factory.CFactory;
import itf.ILivre;
import itf.IObjet;
import itf.ISection;

public class CLivreBouchon implements ILivre{
	

	public CLivreBouchon(String titre,String auteur)
	{
		this.auteur=auteur;
		this.titre=titre;
		
	}
	private HashMap<String,Section> sections=new HashMap<String,Section>() ;
	private HashMap<String,Objets> objets=new HashMap<String,Objets>();
	private List<IObjet> objetsection=new ArrayList<IObjet>();
	//private HashMap<String,Objets> objets=new HashMap<String,Objets>();
	private String titre,auteur;
	public Boolean SectionExist(String nom) throws Exception
	{
		
		return sections.containsKey(nom);
	}
	
	public String getTitre()
	{
		return "Jungle";
	}
	
	public String getAuteur() {
		return "Rudyard Kipling";
	}
	
	public String createSection(String nom, String texte) {
		try {
			if(!SectionExist(nom)) {
				
				Section sec=new Section(0,nom,texte ,
						new Livre("Jungle","Rudyard Kipling"), objetsection);
				sections.put(nom, sec);
				//System.out.println(sections.get("sec1")+"hhhhhhhhhhhhhh");
				return nom;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addObjet(String nom) {
		this.objets.put(nom, new Objets(nom));
		this.objetsection.add(new Objets(nom));
	}

	@Override
	public void createObject(String nom) {
		// TODO Module de remplacement de méthode auto-généré
		
	}

	@Override
	public void createEnchainement(String texte, String nom, ISection src, ISection dst, List<IObjet> objets) {
		// TODO Module de remplacement de méthode auto-généré
		
	}

	@Override
	public Set<String> getSections() {
		
		return null;
	}

	@Override
	public HashMap<String, Objets> getObjets() {
		
		return null;
	}

	@Override
	public Set<String> getEnchainements() {
		// TODO Module de remplacement de méthode auto-généré
		return null;
	}

	@Override
	public void AddEnchainement(String nom, String description, ISection src, ISection dst, List<String> objets) {
		// TODO Module de remplacement de méthode auto-généré
		
	}

	@Override
	public boolean EnchainementExists(ISection src, ISection dst) {
		// TODO Module de remplacement de méthode auto-généré
		return false;
	}

	@Override
	public void modifEnchainement(String id, String nom, String description, ISection src, ISection dst,
			List<String> objetsList) {
		// TODO Module de remplacement de méthode auto-généré
		
	}

	@Override
	public void deleteEnchainement(int id) {
		// TODO Module de remplacement de méthode auto-généré
		
	}

	@Override
	public Boolean checkEnchainementExists(String nom) {
		// TODO Module de remplacement de méthode auto-généré
		return null;
	}

	@Override
	public Boolean isTete(String nom) {
		// TODO Module de remplacement de méthode auto-généré
		return null;
	}

	@Override
	public String getTete() {
		// TODO Module de remplacement de méthode auto-généré
		return null;
	}

	@Override
	public boolean deleteSection(String nom) {
		// TODO Module de remplacement de méthode auto-généré
		return false;
	}

	@Override
	public boolean deleteObjet(String nom) {
		// TODO Module de remplacement de méthode auto-généré
		return false;
	}

	@Override
	public HashMap<String, Section> getSection() {
	//	List<IObjet> objets = new ArrayList<IObjet>();
//		objets.add(new Objets("obj1"));
//		objets.add(new Objets("obj2"));
//		sections.put("sec1",new Section(1,"sec1","texte...",new Livre("Jungle","Rudyard Kipling"),
//				objets) );
		
		return sections;
	}

	@Override
	public void setTete(ISection sec) {
		// TODO Module de remplacement de méthode auto-généré
		
	}

	@Override
	public IObjet getObjet(String nom) {
		// TODO Module de remplacement de méthode auto-généré
		return null;
	}

	@Override
	public ISection getSection(String nom) {
		// TODO Module de remplacement de méthode auto-généré
		return null;
	}

	@Override
	public IEnchainement getEnchainement(String nom) {
		// TODO Module de remplacement de méthode auto-généré
		return null;
	}

	@Override
	public Section getTetedesection() {
		
		return new Section(0,"sec1","sec1blablabla" ,
				new Livre("Jungle","Rudyard Kipling"), objetsection);
	}

	@Override
	public List<String> getSectionNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEnchainementNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getObjectNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}