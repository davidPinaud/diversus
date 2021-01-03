package itf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IGestLivre {
	
	
	public void addLivre(String nom, String auteur) throws Exception;
	public ILivre getLivre(String titre);
	public void deleteLivre(String titre) throws Exception ;
	public List<ILivre> getLivres() ;
	public boolean contains(String titre);
}
