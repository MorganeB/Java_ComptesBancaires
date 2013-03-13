//Classe testant les resultats obtenus
public class Test {

	//test d'un constructeur de la classe Client: identifiant client et decouvert saisis en parametre
	public boolean testClient(){	
		Client c=new Client(1234, 500);
			if(c.getNbComptes()!=0 || c.getDecouvertMax()!=500){
				return false;
			}else{
				return true;
			}
		}
		
	//autre test du constructeur : la saisie d'une valeur negative doit mettre decouvertMax a 0 
	public boolean testClient2(){
		Client c2=new Client(1234, -500);
			if(c2.getNbComptes()!=0 || c2.getDecouvertMax()!=0){
				return false;
			}else{
				return true;
			}
		}
	
	
	//tests des methodes de la classe Client
	public boolean testIncrementerNbComptes(){
		Client c=new Client(1234);
		c.incrementerNbComptes();				//on incremente le nombre de comptes de 1 et ensuite on voit si le nombre de comptes retourne est juste.
		if(c.getNbComptes()!=1){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testGetDecouvertMax(){			//test avec 0 en parametre de decouvert autorise (parametre par defaut)
		Client c1=new Client(1234);
		if(c1.getDecouvertMax()!=0){
			return false;
		}else{
			return true;
		}
	}
		
	public boolean testGetDecouvertMax2(){			//test avec un decouvert autorise par le Client	
		Client c2=new Client(5678, 500);
		if(c2.getDecouvertMax()!=500){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testGetNbComptes(){			//test de GetNbComptes. Doit renvoyer 0 avec le constructeur par defaut 
		Client c1=new Client(1234);
		if(c1.getNbComptes()!=0){
			return false;
		}else{
			return true;
		}
	}
	
	//tests des methodes de la classe CompteBancaire
	
	public boolean testGetTitulaire(){					//selon le constructeur inital, aucun client n'est rattache au compte 
		CompteBancaire cb=new CompteBancaire(1234);
		if(cb.getTitulaire()!=null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testGetTitulaire2(){						//test si la methode retourne le client passe en parametre
		Client c2=new Client(1);
		CompteBancaire cb2=new CompteBancaire(1234, c2);
		if(cb2.getTitulaire()!=c2){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testGetSolde(){				//verifie si le 1er constructeur met bien 0 dans l'attribut solde
		CompteBancaire cb1=new CompteBancaire(1234);			
		if(cb1.getSolde()!=0){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testGetSolde2(){				//verifie si le 2eme constructeur met bien une valeur dans l'attribut solde
		Client c1=new Client(1);
		CompteBancaire cb2=new CompteBancaire(1234, c1, 500);			
		if(cb2.getSolde()!=500){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testGetDecouvert(){					//la methode doit renvoyer 0 pour un CompteBancaire avec seul un numero de compte renseigne
		CompteBancaire cb=new CompteBancaire(1234);
		if(cb.getDecouvert()!=0){
			return false;
		}else{
			return true;
		}
	}
	
	/* 2eme test => Client c: decouvertMax=1000 
	CompteBancaire cb2 : decouvert a 2000
	c'est donc 1000 (le decouvertMax) qui doit etre considere, et non pas un montant superieur
	Donc decouvert prendra la valeur 0 */
	public boolean testGetDecouvert2(){		
		Client c=new Client(1, 1000);
		CompteBancaire cb2=new CompteBancaire(1234, c, 500, 2000);
		if(cb2.getDecouvert()!=0){
			return false;
		}else{
			return true;
		}
	}
		
		
	public boolean testEstADecouvert(){
		Client c1=new Client(1);
		CompteBancaire cb1=new CompteBancaire(1234, c1, -100);		//on verifie que le booleen de la methode EstADecouvert retourne true si le solde est negatif
		if(cb1.estADecouvert()==false){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testEstADecouvert2(){
		Client c2=new Client(1);
		CompteBancaire cb2=new CompteBancaire(1234, c2, -100);		//on verifie maintenant que le booleen retourne false si le compte n'est pas a decouvert
		if(cb2.estADecouvert()==false){
			return false;
		}else{
			return true;
		}
	}
		
	
	public boolean testDepot(){
		Client c=new Client(1);
		CompteBancaire cb=new CompteBancaire(1234, c, 500, 100);		
		cb.depot(100);
		if(cb.getSolde()!=600){										//on verifie que le montant du depot s'ajoute bien au solde du compte
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testDepot2(){
		Client c2=new Client(1);
		CompteBancaire cb2=new CompteBancaire(1234, c2, 500, -800);		
		cb2.depot(-100);
		if(cb2.getSolde()!=500){										//on verifie que le solde reste identique si le montant du depot est invalide
			return false;
		}else{
			return true;
		}
	}
	public boolean testRetrait(){							//on test si le retrait s'effectue et si le retrait n'entraine pas de decouvert non autorise
		Client c=new Client(1, 0);
		CompteBancaire cb=new CompteBancaire(1234, c, 500, 0);
		if(cb.retrait(100)!=true || cb.estADecouvert()==true || cb.getSolde()!=400){		
			return false;
		}else{
			return true;
		}
	}
	
	public boolean testRetrait2(){					//on verifie que le booleen renvoie false lorsque le retrait est impossible (solde final < decouvertMax)
		Client c2=new Client(2, 200);
		CompteBancaire cb2=new CompteBancaire(1234, c2, 500, 200);
		if(cb2.retrait(1000)!=false || cb2.getSolde()!=500){		
			return false;
		}else{
			return true;
		}
	}
	
	
	/*on verifie que le booleen renvoie true et que le nombre de comptes s'est bien incremente de 1
	avec le constructeur d'un Client avec un identifiant et pas de compte*/ 
	public boolean testAssocieCompte(){
		Client c=new Client(1);
		CompteBancaire cb=new CompteBancaire(1234);
		if(cb.associeCompte(c)==false || c.getNbComptes()!=1){		
			return false;
		}else{
			return true;
		}
	}
	
	/*on verifie que le booleen renvoie false si on associe un compte qui a deja un titulaire et que le nombre de comptes ne s'incremente pas de 1
	avec un Client ayant un identifiant et un compte*/
	public boolean testAssocieCompte2(){						
		Client c2=new Client(2);
		CompteBancaire cb2=new CompteBancaire (4567, c2);
		if(cb2.associeCompte(c2)==true || c2.getNbComptes()==1){
			return false;
		}else{
			return true;
		}
	}
	
	/*on verifie que le booleen renvoie false si le decouvert du compte est superieur au decouvertMax du Client
	Le decouvert prend alors la meme valeur que DecouvertMax*/ 
	public boolean testAssocieCompte3(){
		Client c3=new Client(3);
		CompteBancaire cb3=new CompteBancaire(6789, c3, 200);
		if (cb3.associeCompte(c3)==true || c3.getDecouvertMax()<cb3.getDecouvert()){
			return false;
		}else{
			return true;
		}
	}
		
	

	
}
//fin des tests
