package ihm.arbre; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */

import ihm.formulaire.MaListe;
import metier.genea.FicheGenealogique;
import metier.genea.FichierGenealogique;

import javax.swing.*;
import java.awt.*;

/**
 * Classe permettant la création graphique de l'arbre
 */
public class Arbre extends JPanel
{

    private int x;
    private int y;
    private FichierGenealogique fGene = MaListe.getFichierGenealogique();
    private int cible;

    /**
     * Cette méthode permet de créer la case "racine" de la getPersonne() séléctionnée avec son nom, prenom, date de
     * naissance et de décès
     * @param g
     */
    public void paint(Graphics g)
    {
        //x et y nous donne une position de base
        x = getWidth() / 2;
        y = getHeight()/ 2;
        //On regarde si la liste n'est pas vide et qu'une getPersonne() est sélectionnée
        if(fGene.getListeFiches().size() > 0 && MaListe.getPersonne().getSelectedIndex() != -1)
        {
            g.clearRect(0, 0, getWidth(), getHeight());

            //Dessine un rectange "racine" à la place x-y de taille 160/100
            g.drawRect(x, y, 160, 100);

            //On affecte deux lignes de String avec nom prénom et les dates, leur position est "calculée" sur celle des rectangles
            g.drawString(fGene.getListeFiches().get(MaListe.getPersonne().getSelectedIndex()).getNom() +
                    " " + fGene.getListeFiches().get(MaListe.getPersonne().getSelectedIndex()).getPrenom(),(x + 5), (y + 50));
            g.drawString(fGene.getListeFiches().get(MaListe.getPersonne().getSelectedIndex()).getDateDeNaissance() +
                    "-"+fGene.getListeFiches().get(MaListe.getPersonne().getSelectedIndex()).getDateDeDeces(),(x + 5), (y + 60));

            //Cible représente l'indice de la prochaine getPersonne() à afficher, ici c'est la racine pour apès atteindre le côté droit de l'arbre
            cible=fGene.getListeFiches().indexOf(fGene.getListeFiches().get(MaListe.getPersonne().getSelectedIndex()));
            dessinerPerePere(g);
            //On recommence pour le côté gauche, on repart de la racine
            cible=fGene.getListeFiches().indexOf(fGene.getListeFiches().get(MaListe.getPersonne().getSelectedIndex()));
            dessinerMerePere(g);
        }
    }

    /**
     * On dessine les parents de droites (pères)
     * La méthode est récurrente elle appelle le père qui appelera le père du père etc
     * @param g
     */
    public void  dessinerPerePere(Graphics g)
    {
        //On copie x et y pour ne pas changer leur valeur
        int xPere = x;
        int yPere = y;
        FicheGenealogique pere=null;
        //On parcours la taille de l'arbre
        for(int i= 0; i<2 ;i++)
        {
            //On regarde si le père est existant et si oui ...
            if(fGene.getListeFiches().get(cible).getPere() != null)
            {
                //...on associe une nouvelle racine
                pere = fGene.getListeFiches().get(cible).getPere();
                //On créer son rectangle et ses informations
                g.drawRect((xPere) += 110, (yPere) -= 110, 110, 100);
                g.drawString(pere.getNom() + " " + pere.getPrenom(), (xPere), (yPere + 50));
                g.drawString(pere.getDateDeNaissance()+"-"+pere.getDateDeDeces(),(xPere), (yPere + 60));
                //la prochaine cible devient le père du père précèdent
                cible = fGene.getListeFiches().indexOf(pere);
            }

        }
    }

    public void dessinerMerePere(Graphics g)
    {
        //On copie x et y pour ne pas changer leur valeur
        int xMere = x;
        int yMere = y;
        FicheGenealogique mere=null;
        //On parcours la taille de l'arbre
        for (int i = 0 ; i<2;i++)
        {
            //On regarde si la mère est existante et si oui ...
            if(fGene.getListeFiches().get(cible).getMere() != null)
            {
                //...on associe une nouvelle racine
                mere = fGene.getListeFiches().get(cible).getMere();
                //On créer son rectangle et ses informations
                g.drawRect((xMere) -= 80, (yMere) -= 110, 110, 100);
                g.drawString(mere.getNom() + " " + mere.getPrenom(), (xMere), (yMere + 50));
                g.drawString(mere.getDateDeNaissance() + "-" + mere.getDateDeDeces(), (xMere), (yMere + 60));
                //la prochaine cible devient la mère de la mère précèdente
                cible = fGene.getListeFiches().indexOf(mere);
            }
        }
    }

}
