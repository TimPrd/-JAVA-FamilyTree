package ihm.menus; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */

import ihm.IHM;
import ihm.formulaire.Formulaire;
import ihm.formulaire.MaListe;
import metier.genea.FicheGenealogique;
import metier.genea.FichierGenealogique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Classe permettant la création du menu fiche
 */
public class JMenuFiche extends JMenu implements ActionListener
{

    private IHM ihm;
    private Formulaire nvF ;

    private JMenuItem ajouter    ;
    private JMenuItem supprimer  ;
    private JMenuItem modifier   ;

    /**
     * Constructeur permettant de crée le menu fiche en ajoutant 3 items à ce menu
     * On y ajoute par la suite les raccourcis clavier
     * @param ihm
     */
    public JMenuFiche(IHM ihm)
    {
        super("Fiche");
        add(this.ajouter    = new JMenuItem("Ajouter une fiche"  )).addActionListener(this);
        add(this.supprimer  = new JMenuItem("Supprimer une fiche")).addActionListener(this);
        add(this.modifier   = new JMenuItem("Modifier une fiche" )).addActionListener(this);

        this.ajouter  .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A     , ActionEvent.CTRL_MASK));
        this.supprimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        this.modifier .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M     , ActionEvent.CTRL_MASK));
        this.ihm = ihm;
    }


    /**
     * Permet de connaitre la position d'une fiche
     * @param ficheGenealogique
     * @return l'index de la fiche soit, sa position dans la liste
     */
    public int getIndice(FicheGenealogique ficheGenealogique)
    {
        for(int i = 0; i< MaListe.getFichierGenealogique().getListeFiches().size(); i++)
            if (ficheGenealogique.equals(MaListe.getFichierGenealogique().getListeFiches().get(i)))
            {
                return i;
            }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {

        //Action sur fiche > Ajouter
        if (evt.getSource() == this.ajouter)
            ihm.ajouter();

        //Action sur fiche > Supprimer
        if (evt.getSource() == this.supprimer)
            ihm.effacer();

        //Action sur fiche > Modifier
        if (evt.getSource() == this.modifier)
        {
            int index = MaListe.getPersonne().getSelectedIndex();
            int posPere=0, posMere=0;

            //On assigne de nouvelles variables pour enregistrer une nouvelle fiche entièrement en récupérant les données déjà présentent

            String nom           =  MaListe.getFichierGenealogique().getListeFiches().get(index).getNom             ();
            String prenom        =  MaListe.getFichierGenealogique().getListeFiches().get(index).getPrenom          ();

            String dNaissance    =  MaListe.getFichierGenealogique().getListeFiches().get(index).getDateDeNaissance ();
            String dMariage      =  MaListe.getFichierGenealogique().getListeFiches().get(index).getDateDeMariage   ();
            String dDeces        =  MaListe.getFichierGenealogique().getListeFiches().get(index).getDateDeDeces     ();

            String vNaissance    =  MaListe.getFichierGenealogique().getListeFiches().get(index).getVilleDeNaissance();
            String vMariage      =  MaListe.getFichierGenealogique().getListeFiches().get(index).getVilleDeMariage  ();
            String vDeces        =  MaListe.getFichierGenealogique().getListeFiches().get(index).getVilleDeDeces    ();

            String deptNaissance =  MaListe.getFichierGenealogique().getListeFiches().get(index).getDeptDeNaissance ();
            String deptMariage   =  MaListe.getFichierGenealogique().getListeFiches().get(index).getDeptDeMariage   ();
            String deptDeces     =  MaListe.getFichierGenealogique().getListeFiches().get(index).getDeptDeDeces     ();

            if(MaListe.getFichierGenealogique().getListeFiches().get(index).getPere()!=null)
                posPere = getIndice(MaListe.getFichierGenealogique().getListeFiches().get(index).getPere());
            if(MaListe.getFichierGenealogique().getListeFiches().get(index).getMere()!=null)
                posMere = getIndice(MaListe.getFichierGenealogique().getListeFiches().get(index).getMere());


            //On supprime la fiche que l'on modifie pour éviter d'avoir deux fois la même personne
            MaListe.getPersonneDefault().remove(MaListe.getPersonne().getSelectedIndex());
            MaListe.getFichierGenealogique().getListeFiches().remove(index);

            //On crée la nouvelle fiche avec les nouveaux attributs
            nvF = new Formulaire(ihm,nom,prenom,dNaissance,dMariage,dDeces,vNaissance,vMariage,vDeces,
                                 deptNaissance,deptMariage,deptDeces, posPere, posMere);
        }
    }
}