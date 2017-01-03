package metier;

import metier.genea.FichierGenealogique;

import java.util.ArrayList;

public class TestLecture {

    public static void main(String[] args) {
        FichierGenealogique fg = new FichierGenealogique();
        fg.chargerFichier("Genealogie.txt");

        ArrayList liste = fg.getListeFiches();
        for (int i=0;i<liste.size();i++)
            System.out.println(liste.get(i));
    }
}