package metier;

import metier.genea.FicheGenealogique;
import metier.genea.FichierGenealogique;

public class TestEcriture {

    public static void main(String[] args) {
        FichierGenealogique fg = new FichierGenealogique();
        FicheGenealogique p1 = new FicheGenealogique("Duvallet", "Christian", "05/07/1941", "Evreux" , "Eure");
        fg.addFicheGenealogique(p1);
        FicheGenealogique p2 = new FicheGenealogique("Juhel", "Claudine", "16/02/1947", "Vimoutiers" , "Orne");
        fg.addFicheGenealogique(p2);

        FicheGenealogique p3 = new FicheGenealogique("Duvallet", "Claude", "31/07/1973", "Evreux" , "Eure");
        p3.setPere(p1);
        p3.setMere(p2);
        fg.addFicheGenealogique(p3);

        FicheGenealogique p4 = new FicheGenealogique("Duvallet", "André");
        fg.addFicheGenealogique(p4);
        FicheGenealogique p5 = new FicheGenealogique("Marchand", "Marcelle");
        fg.addFicheGenealogique(p5);
        p1.setPere(p4);
        p1.setMere(p5);

        System.out.println(fg.getMere(p1));
        fg.enregistrerFichier("Genealogie.txt");
    }
}
			