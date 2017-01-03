package ihm; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */
import ihm.arbre.Arbre;
import ihm.barresOutils.MaJToolBar;
import ihm.formulaire.Formulaire;
import ihm.formulaire.MaListe;
import ihm.formulaire.OuvrirFiche;
import ihm.menus.MaMenuBar;
import metier.genea.FichierGenealogique;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Classe permettant de gérée l'IHM
 */
public class IHM extends JFrame 
{

    //Barre de menu
    private JMenuBar menuBar = new JMenuBar();
    //3 Panels pour chaque zone
    private JPanel panelOutil= new JPanel();
    private JPanel panelFiche= new JPanel();
    private JPanel panelAffi = new JPanel();
    private JPanel panelArbre = new Arbre();

    //Couleur
    private Color  rouge     = new Color(178,34,34);
    private Color  crimson   = new Color(217,85,85);


    /**
     * Constructeur de l'IHM il instancie les panels, les menus, la barre d'outils etc
     */
    public IHM()
    {
        this.setTitle("Arbre Généalogique");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //Modifie les Layout & Couleurs de fond. Le grid permet de mettre nom et prénom sur la même ligne
        panelOutil.setLayout(new GridLayout(1,1));
        panelFiche.setLayout(new FlowLayout());
        panelAffi .setLayout(new FlowLayout());
        panelArbre.setLayout(new FlowLayout());
        //L'arbre à une dimension par défaut
        panelArbre.setPreferredSize(new Dimension(900,800));
        //Affectation des couleurs au fonds des panels
        panelFiche.setBackground(rouge)  ;
        panelArbre.setBackground(crimson);
        panelAffi .setBackground(crimson);

        //Ajout des different JMenu dans la JMenuBar
        this.setJMenuBar( new MaMenuBar(this));
        //Ajout des outils dans le panel outils (haut)
        panelOutil.add(new MaJToolBar(this   ));
        //Ajout de la liste dans le panel liste (gauche)
        panelFiche.add(new MaListe(this   ));

        panelAffi.add(panelArbre);

        //On ajoute tout les panels à l'IHM principale
        this.add(panelOutil,"North"); //Affecte la barre d'outil en haut
        this.add(panelFiche,"West" ); //Affecte la liste à gauche
        this.add(panelAffi);          //Affecte l'affichage au milieu
        this.setVisible(true);
    }

    //MÉTHODES

    /**
     * Permet d'ajouter une nouvelle personne
     */
    public void ajouter()
    {
        //On déclare un formulaire qui permettra la saisie d'un nouveau membre
        Formulaire f;
        f = new Formulaire(this);
    }

    /**
     * Permet d'ouvrir un fichier .txt
     */
    public void ouvrir()
    {
        // "selectedFile" recoit le fichier selectionné
        File selectedFile = new OuvrirFiche().getSelectedFile();
        //si il est different de "null" on decoupe le fichier et on ajoute a une JList
        if (selectedFile != null)
        {
            this.getPanelFiche().removeAll();
            MaListe.getPersonneDefault().removeAllElements();
            MaListe.getFichierGenealogique().getListeFiches().clear();

            this.getPanelFiche().add(new MaListe(this, selectedFile.getAbsolutePath()));
            this.getPanelFiche().revalidate();
        }
    }

    /**
     * Permet d'effacer l'élèment selectionner
     */
    public void effacer()
    {
        int index = MaListe.getPersonne().getSelectedIndex();

        MaListe.getPersonneDefault().remove(MaListe.getPersonne().getSelectedIndex());
        MaListe.getFichierGenealogique().getListeFiches().remove(index);
    }

    /**
     * Permet de surpprimer toutes les fiches et de recommencer à partir de zéro
     */
    public void nouveau()
    {
        //Enlève l'ensemble des fiches
        MaListe.getPersonneDefault().removeAllElements();
        MaListe.getFichierGenealogique().getListeFiches().clear();
        //Enlève le contenu des panels
        this.getPanelFiche().removeAll();
        this.getPanelAffi ().removeAll();
        //Ajout au panel Fiche une nouvelle liste vide
        this.getPanelFiche().add(new MaListe(this));
        //Mise a jour des panels
        this.getPanelAffi ().revalidate();
        this.getPanelFiche().revalidate();
    }

    /**
     * Permet d'enregistrer sous un nom le fichier
     */
    public void enregistrerS()
    {
        FichierGenealogique fichier = MaListe.getFichierGenealogique();
        //On ouvre la boite de dialogue qui affiche les emplacement
        JFileChooser chooser = new JFileChooser();
        String endroit = "";
        int i = chooser.showSaveDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            try {
                //On enregistre le nom + l'emplacement directement suivie de .txt
                endroit = chooser.getSelectedFile() + ".txt";

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        fichier.enregistrerFichier(endroit);
    }

    /**
     * Enregistre par dessus le fichier si il est déjà existant
     */
    public void enregistrer()
    {
        //Si la liste n'est pas vide (inutile d'enregistrer du vide)
        if (MaListe.getFichierGenealogique().getListeFiches().size() != 0)
        {
            //Si le nom du fichier est égal à "" alors il est nouveau alors on l'envoie à enregistrer Sous
            if (MaListe.getFichierGenealogique().getNomDuFichier().equals(""))
                this.enregistrerS();
            //Sinon on enregistre par dessus
            else
                MaListe.getFichierGenealogique().enregistrerFichier(MaListe.getFichierGenealogique().getNomDuFichier());
        }
    }


    //GETTER
    /**
     * @return le panel des fiches (gauche)
     */
    public JPanel getPanelFiche()
    {
        return this.panelFiche;
    }

    /**
     * @return le panel de l'affichage de l'arbre (centre)
     */
    public JPanel getPanelAffi ()
    {
        return this.panelAffi ;
    }

    /**
     * @return le panel de l'arbre
     */
    public JPanel getPanelArbre()
    {
        return this.panelArbre;
    }

    public static void main(String[] args) {        new IHM(); }

}
