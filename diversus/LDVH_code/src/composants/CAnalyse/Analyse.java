/**
 * 
 */
package composants.CAnalyse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import composants.CLivre.Enchainement;
import composants.CLivre.GestLivres;
import composants.CLivre.Livre;
import composants.CLivre.Section;
import itf.IAnalyse;
import itf.ILivre;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Analyse implements IAnalyse{
	
	ILivre livre;
	
	public Analyse(ILivre livre) {
		this.livre=livre;
	}
	@Override
	public List<String> Analyser_graphe() {
		Section teteSection=((Livre) livre).getSection().get(livre.getTete());
		
		List<String> TouteSections=new ArrayList<>();
		for (Entry<String, Section> entry : ((Livre) livre).getSection().entrySet()) {
			TouteSections.add(entry.getValue().getNom());
		}
		TouteSections.remove(teteSection.getNom());
		
		/*
		List<String> atteignable=new ArrayList<>();
		atteignable =teteSection.getNextAtteignable();
		atteignable.add(teteSection.getNom());
		

		for(int i=0;i<1000;i++) {
			
		}*/
		
		int nb=1000;
		
		List<String> atteignable=new ArrayList<>();
		List<String> file=new ArrayList<>();
		atteignable.add(teteSection.getNom());
		file.add(teteSection.getNom());
		while(!file.isEmpty()) {
			String section=file.get(0);
			file.remove(0);
			TouteSections.remove(section);
			
			if(TouteSections.isEmpty()||nb<0) {
				break;
			}
			nb--;
			
			for(String nom:((Livre) livre).getSection().get(section).getNextAtteignable()) {
				if(!atteignable.contains(nom)) {
					atteignable.add(nom);
					file.add(nom);
				}
			}
		}
		
		return atteignable;
	}

	@Override
	public void updateAtteignabilite(String nomSection, String nomEnchainement, String nomObjet) {
		// TODO Auto-generated method stub

	}
}