package itf;

import java.util.HashMap;
import java.util.Map;

public interface IGestLivre {
	
	
	public void addLivre(String nom, String auteur);
	public ILivre getLivre(String titre);
	public void deleteLivre(String titre);
	
}
