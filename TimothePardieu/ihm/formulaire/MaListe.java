package ihm.formulaire; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */
import ihm.IHM;
import metier.genea.FichierGenealogique;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe permettant de construire la liste stockant les fiches
 */
public class MaListe extends JList implements ListSelectionListener
{
    private static DefaultListModel    personneDefault     = new DefaultListModel();
    private static JList               personne            = new JList(personneDefault);
    private static FichierGenealogique fichierGenealogique = new FichierGenealogique();

    private JScrollPane listScrollPane  = new JScrollPane(personne);
    private IHM ihm;
    private String      fileName = "";

    /**
     *Constructeur, il initialise la liste à l'index 0 puis l'ajoute au panelFiche
     * Il ne contient que ihm car il sert essentiellement pour la création à vide (design)
     * @param ihm
     */
    public MaListe(IHM ihm)
    {
        personne.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        personne.setSelectedIndex(0);
        personne.setVisibleRowCount(10);
        //Ajoute la liste au panel de gauche(PanelFiche)
        this.ihm = ihm;
        ihm.getPanelFiche().add(listScrollPane);
        this.setVisible(true);
    }

    /**
     * Il se renvoi au constructeur ci-dessus mais ajoute un fichier à lire permettant d'avoir des fiches
     * @param ihm
     * @param fichier variable permettant de désigner le fichier à convertir en liste de fiches
     */
    public MaListe(IHM ihm, String fichier)
    {

        this(ihm);

        //on envoie le fichier(venant du fichier ouvert de JMenuFichier) a la lecture
        this.fileName = fichier;

        fichierGenealogique.chargerFichier(fichier);

        //Boucle pour ajouter tout les noms dans la liste
        for (int i = 0; i < fichierGenealogique.getListeFiches().size(); i++)
            personneDefault.add(i, fichierGenealogique.getListeFiches().get(i).getNom() + " " + fichierGenealogique.getListeFiches().get(i).getPrenom());
        //Ajout d'un écouteur d'évenement
        personne.addListSelectionListener(this);

    }


    //Getter

    /**
     * @return la liste
     */
    public static DefaultListModel getPersonneDefault()
    {
        return personneDefault;
    }

    /**
     * @return le fichier Genealogique courant
     */
    public static FichierGenealogique getFichierGenealogique()
    {
        return fichierGenealogique;
    }

    /**
     * @return les personnes dans la liste
     */
    public static JList getPersonne()
    {
        return personne;
    }


    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        ihm.getPanelAffi().revalidate();
        ihm.getPanelAffi().repaint();
    }
}