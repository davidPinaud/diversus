package composants.CLivre;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import itf.*;


public class GestLivres implements IGestLivre {
	private Map<String, ILivre> livres=new HashMap<String, ILivre>();
	public GestLivres() {
		
	}
	@Override
	public void addLivre(String nom, String auteur) throws Exception {
		// TODO Auto-generated method stub
		if (contains(nom)) {
			throw new Exception("Livre avec ce titre déjà existant ");
		}
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
	public void deleteLivre(String titre) throws Exception{
		// TODO Auto-generated method stub
		if(livres.remove(titre)==null) {
			throw new Exception("Le livre que vous essayez de supprimer n'existe pas:: ");
		}
		//System.out.println("Le livre "+titre+ " a été supprimé");
	}

	 @Override 
	 public List<ILivre> getLivres() {
		 List<ILivre> res=new ArrayList<ILivre>();
	     for (Entry<String, ILivre> entry: livres.entrySet()) {
	         res.add(entry.getValue());
	     }

	        //livres.entrySet()
	     return res;
	 }
	 @Override
	 public boolean contains(String titre) {
	     if(livres.get(titre)==null) {
	         return false;
	     }
	     return true;
	 }
	 
	 @Override
	public boolean equals(Object obj) {
		if(obj instanceof GestLivres) {
			return this.getLivres().equals(((GestLivres) obj).getLivres());
		}
		return false;
	}

}
