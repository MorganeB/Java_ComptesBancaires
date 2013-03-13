class CompteBancaire{		//la classe Client a 4 attributs: numero de compte, solde du compte, un objet titulaire de la classe Client et un reel decouvert 
	private int num;
	private double solde;
	public Client titulaire;
	private double decouvert;
	
	//constructeurs
	
	/*constructeur qui construit un client dont le numero est passe en parametre
	avec un solde initial et un decouvert autorise nuls et qui n'est attribue à aucun client*/
	public CompteBancaire(int numero){			
		num=numero;								
		solde=0;
		decouvert=0;
		titulaire=null;
	}
	
	/*constructeur qui construit un compte dont le numero et le client sont passes
	en parametres, avec un solde et un decouvert initialises nuls*/
	public CompteBancaire(int numero, Client c){ 		
		num=numero;										
		titulaire=c;
		solde=0;
		decouvert=0;
	}
	
	/*constructeur avec un parametre entier, un parametre Client
	et 2 parametres reels : le numero de compte, de client, de solde et de decouvert autorise*/
	public CompteBancaire(int numero, Client c, double s){				
		num=numero;														
		titulaire=c;
		solde=s;
		decouvert=0;
	}
	
	/*constructeur avec un parametre entier, un parametre Client, et des parametres reels : solde et decouvert. 
	Si DecouvertMax de la classe Client est non null, on met sa valeur dans l'attribut decouvert du compte sinon, on lui met 0 */ 
	public CompteBancaire(int numero, Client c, double s, double d){		
		num=numero;																
		titulaire=c;															
		solde=s;																
		double decouvert_client;
		decouvert_client=c.getDecouvertMax();
		if(decouvert_client >= d){
			decouvert=d;
		}else{ 
			decouvert=0;
		}
		}
		
	//methodes
	public Client getTitulaire(){					//methode qui retourne le client titulaire du compte
		return titulaire;
	}
	
	public double getSolde(){						//methode qui retourne le solde
		return solde;
	}
	
	public double getDecouvert(){					//methode qui retourne le decouvert 
		return decouvert;
	}
	
	public boolean estADecouvert(){						//methode qui retourne true si le compte est à decouvert (si son solde est inferieur à 0)
		if(solde<0){
			return true;
		}else{
			return false;
		}
	}
	
	public void depot (double d){							//methode pour deposer un montant passe en parametre 
		if(d>0){
			solde=solde+d;
		}else{
			solde=solde;
		}
	}
	
	/* methode pour retirer un montant passer en parametre. 
	Renvoie true si le solde reste superieur à 0 OU si le solde apres retrait reste superieur au decouvert autorise 
	On fait (0-decouvert) pour calculer l'oppose de decouvert (car le parametre n'indique pas une valeur negative)
	Exemple : solde = 100, decouvert=200 et on veut retirer 500 : 100-500= -400 donc il faut le comparer à -200 (et non à 200)*/
	public boolean retrait(double montant){													
		if(montant>0){																
			if(solde - montant >0 || solde - montant > (0-decouvert)){				
				solde=solde-montant;												
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/*methode qui prend en parametre un Client c et associe le compte au client. 
	Le booleen rennvoie true si l'association est possible: si le compte n'a pas de titulaire et que le decouvert est compatible avec le decouvertMax du client*/
	public boolean associeCompte(Client c){
		if(titulaire==null && decouvert<=c.getDecouvertMax()){
			titulaire=c;
			c.incrementerNbComptes();				//on incremente le nombre de compte du Client c de 1, vu qu'on vient de lui ajouter un compte. 
			return true;
		}else{
			decouvert=c.getDecouvertMax();
			return false;
		}
	}
	
	
	
	
}
	