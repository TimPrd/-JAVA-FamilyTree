package metier.genea;

/**
 * Cette classe permet de représenter la fiche généalogique d'une personne
 * @author Claude.Duvallet@gmail.com
 */
public class FicheGenealogique {

	private String nom;
	private String prenom;
	private String dateDeNaissance;
	private String dateDeMariage;
	private String dateDeDeces;
	private String villeDeNaissance;
	private String villeDeMariage;
	private String villeDeDeces;
	private String deptDeNaissance;
	private String deptDeMariage;
	private String deptDeDeces;
	private FicheGenealogique pere;
	private FicheGenealogique mere;
	
	/**
	 * Constructeur par défaut
	 * @param nom le nom de personne
	 * @param prenom le prénom de la personne
	 */
	public FicheGenealogique(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Constructeur avec les informations sur la date, le lieu et le département de naissance.
	 * @param nom le nom
	 * @param prenom le prénom
	 * @param dateDeNaissance la date de naissance
	 * @param villeDeNaissance la ville de naissance
	 * @param deptDeNaissance le département de naissance
	 */
	public FicheGenealogique(String nom, String prenom, String dateDeNaissance, 
							 String villeDeNaissance, String deptDeNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.villeDeNaissance = villeDeNaissance;
		this.deptDeNaissance = deptDeNaissance;
	}

	/**
	 * @return le nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom le nom à définir
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return le prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom le prénom à définir
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return la date de naissance
	 */
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * @param dateDeNaissance la date de naissance à définir
	 */
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * @return la date de mariage de la personne
	 */
	public String getDateDeMariage() {
		return dateDeMariage;
	}

	/**
	 * @param dateDeMariage la date de mariage à définir
	 */
	public void setDateDeMariage(String dateDeMariage) {
		this.dateDeMariage = dateDeMariage;
	}

	/**
	 * @return la date de décès
	 */
	public String getDateDeDeces() {
		return dateDeDeces;
	}

	/**
	 * @param dateDeDeces la date de décès à définir
	 */
	public void setDateDeDeces(String dateDeDeces) {
		this.dateDeDeces = dateDeDeces;
	}

	/**
	 * @return la ville de naissance
	 */
	public String getVilleDeNaissance() {
		return villeDeNaissance;
	}

	/**
	 * @param villeDeNaissance la ville de naissance à définir
	 */
	public void setVilleDeNaissance(String villeDeNaissance) {
		this.villeDeNaissance = villeDeNaissance;
	}

	/**
	 * @return la ville de mariage
	 */
	public String getVilleDeMariage() {
		return villeDeMariage;
	}

	/**
	 * @param villeDeMariage la ville de mariage à définir
	 */
	public void setVilleDeMariage(String villeDeMariage) {
		this.villeDeMariage = villeDeMariage;
	}

	/**
	 * @return la ville de décès
	 */
	public String getVilleDeDeces() {
		return villeDeDeces;
	}

	/**
	 * @param villeDeDeces la ville de décès à définir
	 */
	public void setVilleDeDeces(String villeDeDeces) {
		this.villeDeDeces = villeDeDeces;
	}

	/**
	 * @return le département de naissance
	 */
	public String getDeptDeNaissance() {
		return deptDeNaissance;
	}

	/**
	 * @param deptDeNaissance le département de naissance à définir
	 */
	public void setDeptDeNaissance(String deptDeNaissance) {
		this.deptDeNaissance = deptDeNaissance;
	}

	/**
	 * @return le département de mariage
	 */
	public String getDeptDeMariage() {
		return deptDeMariage;
	}

	/**
	 * @param deptDeMariage le département de mariage à définir
	 */
	public void setDeptDeMariage(String deptDeMariage) {
		this.deptDeMariage = deptDeMariage;
	}

	/**
	 * @return le département de décès
	 */
	public String getDeptDeDeces() {
		return deptDeDeces;
	}

	/**
	 * @param deptDeDeces le département de décès à définir
	 */
	public void setDeptDeDeces(String deptDeDeces) {
		this.deptDeDeces = deptDeDeces;
	}

	/**
	 * @return la fiche généalogique du père
	 */
	public FicheGenealogique getPere() {
		return pere;
	}

	/**
	 * @param pere la fiche généalogique du père à définir
	 */
	public void setPere(FicheGenealogique pere) {
		this.pere = pere;
	}

	/**
	 * @return la fiche généalogique de la mère
	 */
	public FicheGenealogique getMere() {
		return mere;
	}

	/**
	 * @param mere la fiche généalogique de la mère à définir
	 */
	public void setMere(FicheGenealogique mere) {
		this.mere = mere;
	}
	
	/**
	 * Méthode permettant de comparer la fiche généalogique courante 
	 * avec une autre fiche afin de vérifier que les deux fiches sont identiques.
	 * @param ficheGenealogique la fiche généalogique avec laquelle on compare la fiche courante
	 * @return un booléen représentant le résultat de la comparaison
	 */
	public boolean equals(FicheGenealogique ficheGenealogique){
		if (!nom.equals(ficheGenealogique.getNom())) return false;
		if (!prenom.equals(ficheGenealogique.getPrenom())) return false;
		if (dateDeNaissance!=null)
			if (!dateDeNaissance.equals(ficheGenealogique.getDateDeNaissance())) return false;
		return true;
	}
	

	/**
	 * Methode permettant de convertir une fiche généalogique 
	 * en une chaine de caractères prête à être enregistrée dans un fichier texte.
	 * @return une chaine de caractères
	 */
	public String convertToString() {
		String resultat="";
		if (nom!=null) resultat+=nom;
		resultat+=";";
		if (prenom!=null) resultat+=prenom;
		resultat+=";";
		if (dateDeNaissance!=null) resultat+=dateDeNaissance;
		resultat+=";";
		if (villeDeNaissance!=null) resultat+=villeDeNaissance;
		resultat+=";";
		if (deptDeNaissance!=null) resultat+=deptDeNaissance;
		resultat+=";";
		if (dateDeMariage!=null) resultat+=dateDeMariage;
		resultat+=";";
		if (villeDeMariage!=null) resultat+=villeDeMariage;
		resultat+=";";
		if (deptDeMariage!=null) resultat+=deptDeMariage;
		resultat+=";";
		if (dateDeDeces!=null) resultat+=dateDeDeces;
		resultat+=";";
		if (villeDeDeces!=null) resultat+=villeDeDeces;
		resultat+=";";
		if (deptDeDeces!=null) resultat+=deptDeDeces;
		resultat+=";";

		if (pere!=null){
			if (pere.getNom()!=null)
				resultat+= pere.getNom();
			resultat+=";";
			if (pere.getPrenom()!=null)
				resultat+= pere.getPrenom();
			resultat+=";";
		}
		else
			resultat+=";;";
		if (mere!=null) {
			if (mere.getNom()!=null)
				resultat+= mere.getNom();
			resultat+=";";
			if (mere.getPrenom()!=null)
				resultat+= mere.getPrenom();
			resultat+=";";
		}
		else
			resultat+=";;";
		resultat+="\n";
		return resultat;
	}
	
	/**
	 * Méthode permettant de représenter la fiche généalogique sous forme d'une chaine de caractères. 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String resultat= "Personne [nom=" + nom + ", prenom=" + prenom + ",\n  dateDeNaissance=" + dateDeNaissance + ", villeDeNaissance="+ villeDeNaissance + ", deptDeNaissance=" + deptDeNaissance 
				+ ",\n  dateDeMariage=" + dateDeMariage  + ", villeDeMariage="+ villeDeMariage + ", deptDeMariage=" + deptDeMariage
				+ ",\n  dateDeDeces=" + dateDeDeces+ ", villeDeDeces=" + villeDeDeces + ", deptDeDeces=" + deptDeDeces;
		if (pere!=null){
			if (pere.getNom()!=null)
				resultat+= ",\n  Père = "+pere.getNom();
			resultat+=" ";
			if (pere.getPrenom()!=null)
				resultat+= pere.getPrenom();
		}
		if (mere!=null) {
			if (mere.getNom()!=null)
				resultat+= ",\n  Mère = "+mere.getNom();
			resultat+=" ";
			if (mere.getPrenom()!=null)
				resultat+= mere.getPrenom();
		}
		
		resultat+="\n]";
		
		return resultat;
	}
}
