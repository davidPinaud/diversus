/**
 * 
 */
package composants.Factory;

import composants.CIHM.GestIHM;
import itf.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Main {

	IAffichageGraphique ag = CFactory.createAffichageGraphique();
	IAnalyse analyse = CFactory.createAnalyse();
	ILivre livre = CFactory.createLivre("livre");
	ILivreController controller = CFactory.createController();
	IParser parser = CFactory.createParser();
	GestIHM ihm = CFactory.createIHM();
}