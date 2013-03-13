public class Client{
	//attributs
	
	/*la classe Client a trois attributs : entier numero identifiant le client, 
	nb donnant le nombre de comptes du client, decouvertMax donnant la valeur maximal du decouvert pour tous les comptes. */
	int numero;					
	int nb;						
	double decouvertMax;
	
	//constructeurs
	public Client(int num){		//constructeur qui construit un client avec un identifiant mais qui ne possede aucun compte
		numero=num;
		nb=0;
		decouvertMax=0;
		}
	
	/*constructeur avec un parametre entier num et un parametre double decouv (numero de compte et le decouvertMax)
	le client ne dispose d'aucun compte initialement*/
	public Client(int num, double decouv){		
		numero=num;									
		nb=0;
		if(decouv<0){
			decouvertMax=0;
			}else{
				decouvertMax=decouv;
			}
	}
	
	//methodes 
	public void incrementerNbComptes(){		//methode qui incremente de 1 le nombre de comptes du client
		nb++;
	}
	
	public double getDecouvertMax(){		//methode qui retourne la valeur de l'attribut decouvertMax
		return decouvertMax;
	}
	
	public int getNbComptes(){			//methode qui retourne le nombre de comptes associes à un client
		return nb;
	}
	
}


	
	
	
	