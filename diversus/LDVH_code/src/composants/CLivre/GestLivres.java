package composants.CLivre;
import java.util.HashMap;
import java.util.Map;

import itf.*;


public class GestLivres implements IGestLivre {
	private Map<String, ILivre> livres=new HashMap<String, ILivre>();
	public GestLivres() {
		
	}
	@Override
	public void addLivre(String nom, String auteur) {
		// TODO Auto-generated method stub
		ILivre livre=new Livre(nom, auteur);
		livres.put(nom,livre);
		//System.out.println(livre.toString()+ " a été crée");
	}

	@Override
	public ILivre getLivre(String titre) {
		// TODO Auto-generated method stub
		
		return livres.get(titre);
	}

	@Override
	public void deleteLivre(String titre) {
		// TODO Auto-generated method stub
		livres.remove(titre);
		//System.out.println("Le livre "+titre+ " a été supprimé");
	}

}
