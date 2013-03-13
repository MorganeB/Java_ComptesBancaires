import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


//classe pour lancer les tests de la classe Test
public class Principale {

	// permet de lancer tous les tests
	// et de faire l'affichage correspondant
	public static void main(String[] args) throws Exception {

		// nombre d'erreurs
		int err = 0;
		// nombre de tests
		int num = 0;

		
		// cr�er un objet pour la reflexivit�
		Test t = new Test();

		// m�thodes  � lancer
		Method[] methodes = t.getClass().getMethods();

		System.out.println("lancement des tests");
		System.out.println("-----------------------------------------\n");

		// utilisation de la reflexivite pour lancer les tests
		for (int i = 0; i < methodes.length; i++) {

			// toutes les m�thodes
			Method m = methodes[i];

			// verifie que c'est bien une m�thode � lancer 
			// - nom commence par test
			if (m.getName().substring(0, 4).equals("test")) {
				// on ajoute un test au nombre de tests execut�
				num++;

				System.out.println("test" + num + " : " + m.getName());
				
				//stocke resultat du test
				boolean res;

				// on lance le test
				try {
					res = (Boolean) m.invoke(t, new Object[0]);
				} catch (Exception e) {
					//recupere toutes les exception dues au test (ex java.nullpointerException...)
					System.out.println("erreur � l'execution");
					e.printStackTrace();
					
					//le test est consid�r� comme �chou�
					res = false;
				}

				// test si le test a �chou�
				if (!res) {
					//augmente le nombre d'erreurs decouvertes
					err++;
					System.out.print("   *** erreur n" + err
							+ ") erreur au test " + m.getName());
					System.out.println("********************");

				}
				System.out.println("");

			}

		}

		//affiche un bilan
		System.out.println("----------------------------------------");
		System.out.println("resultat : " + err + " erreur(s) sur " + (num)
				+ " tests");

	}

}
