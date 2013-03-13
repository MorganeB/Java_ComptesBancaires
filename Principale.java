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

		
		// créer un objet pour la reflexivité
		Test t = new Test();

		// méthodes  à lancer
		Method[] methodes = t.getClass().getMethods();

		System.out.println("lancement des tests");
		System.out.println("-----------------------------------------\n");

		// utilisation de la reflexivite pour lancer les tests
		for (int i = 0; i < methodes.length; i++) {

			// toutes les méthodes
			Method m = methodes[i];

			// verifie que c'est bien une méthode à lancer 
			// - nom commence par test
			if (m.getName().substring(0, 4).equals("test")) {
				// on ajoute un test au nombre de tests executé
				num++;

				System.out.println("test" + num + " : " + m.getName());
				
				//stocke resultat du test
				boolean res;

				// on lance le test
				try {
					res = (Boolean) m.invoke(t, new Object[0]);
				} catch (Exception e) {
					//recupere toutes les exception dues au test (ex java.nullpointerException...)
					System.out.println("erreur à l'execution");
					e.printStackTrace();
					
					//le test est considéré comme échoué
					res = false;
				}

				// test si le test a échoué
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
