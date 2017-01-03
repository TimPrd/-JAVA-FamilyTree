package ihm.formulaire; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */

import ihm.IHM;
import metier.genea.FicheGenealogique;
import metier.genea.FichierGenealogique;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Classe permettant la création d'une nouvelle fenêtre avec les champs à remplir pour la création/modification d'une personne
 */
public class Formulaire extends JFrame implements ActionListener
{

    //Déclaration d'un format de date pour remplir les champs "date" suivant le modèle xx/xx/xxxx
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    //Déclaration des panels qui permettent de séparer les informations
    private JPanel panelAntecedents   = new JPanel();
    private JPanel panelNomPrenom     = new JPanel();
    private JPanel panelNaissance     = new JPanel();
    private JPanel panelDeces         = new JPanel();
    private JPanel panelMariage       = new JPanel();

    private Container container = getContentPane();

    //Déclaration de TextFields formattés au type de la date déclarée ci-dessus
    private JFormattedTextField dateNaissance = new JFormattedTextField(dateFormat);
    private JFormattedTextField dateDeces     = new JFormattedTextField(dateFormat);
    private JFormattedTextField dateMariage   = new JFormattedTextField(dateFormat);

    //Déclarations des champs qui permettent la récolte des informations
    private JTextField nom, prenom;
    private JTextField vMariage, dMariage, depMariage,vDeces, dDeces, depDeces,vNaissance, dNaissance, depNaissance;
    private JComboBox cPere, cMere;

    private JButton valider = new JButton("Valider");

    //Couleur de l'arrière plan et dimension de la fenêtre
    private Color     rouge   = new Color(217, 80, 80);
    private Dimension dim     = new Dimension(150, 30);

    private IHM ihm;

    /**
     * Constructeur initialisant les labels et les differents TextFields
     * @param ihm permet de modifier l'ihm principale (panelFiche etc)
     */
    public Formulaire(IHM ihm)
    {

        this.setTitle("Formulaire d'identité");
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        //Pour garder l'aspect d'un formulaire on ne peut pas modifier la taille de la fenêtre
        this.setResizable(false);

        //On réparti les layout par groupe (nom+prénom puis par groupe de trois (ville/date/département))
        container       .setLayout(new FlowLayout());
        panelNomPrenom  .setLayout(new GridLayout(1,2));
        panelDeces      .setLayout(new GridLayout(3,1));
        panelMariage    .setLayout(new GridLayout(3,1));
        panelNaissance  .setLayout(new GridLayout(3,1));
        panelAntecedents.setLayout(new GridLayout(2,4));

        //Ajout d'une couleur en arrière plan
        container       .setBackground(rouge);
        panelNomPrenom  .setBackground(rouge);
        panelDeces      .setBackground(rouge);
        panelMariage    .setBackground(rouge);
        panelNaissance  .setBackground(rouge);
        panelAntecedents.setBackground(rouge);

        //On ajoute au premier panel un Label(text) renseignant le nom puis on ajoute le champs de saisie
        panelNomPrenom.add(new Label("Nom : "));
        panelNomPrenom.add(this.nom = new JTextField(9));

        //On ajoute au premier panel un Label/textfield pour le prénom
        panelNomPrenom.add(new Label("Prénom : "));
        panelNomPrenom.add(this.prenom=new JTextField(9));

        dateNaissance.setColumns(20);
        dateDeces    .setColumns(20);
        dateMariage  .setColumns(20);

        //On définit trois format pour que l'utilisateur ne puisse rentrer que des chiffres en xx/xx/xxxx
        MaskFormatter maskNaissance = null;
        MaskFormatter maskDeces     = null;
        MaskFormatter maskMariage   = null;

        //Applique aux textfields date un format de date spécifique
        try
        {
            maskNaissance =  new MaskFormatter("##/##/####");
            maskNaissance.install(dateNaissance);
            maskDeces     = new MaskFormatter("##/##/####");
            maskDeces.install(dateDeces);
            maskMariage   = new MaskFormatter("##/##/####");
            maskMariage.install(dateMariage);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //On ajoute au panel Naissance un Label/textfield pour la date de naissance
        panelNaissance.add(new Label("Date de naissance : "));
        panelNaissance.add(this.dNaissance=dateNaissance);

        //On ajoute au panel Naissance un Label/textfield pour la ville de naissance
        panelNaissance.add(new Label("Ville de naissance : "));
        panelNaissance.add(this.vNaissance=new JTextField());

        //On ajoute au panel Naissance un Label/textfield pour le département de naissance
        panelNaissance.add(new Label("Departement de naissance : "));
        panelNaissance.add(this.depNaissance=new JTextField());

        //On ajoute au panel Deces un Label/textfield pour la date de décès
        panelDeces.add(new Label("Date de décès : "));
        panelDeces.add(this.dDeces=dateDeces);

        //On ajoute au panel Deces un Label/textfield pour la ville de décès
        panelDeces.add(new Label("Ville de décès :"));
        panelDeces.add(this.vDeces = new JTextField());

        //On ajoute au panel Deces un Label/textfield pour le département de décès
        panelDeces.add(new Label("Departement du décès : "));
        panelDeces.add(this.depDeces=new JTextField());

        //On ajoute au panel Mariage un Label/textfield pour la date de mariage
        panelMariage.add(new Label("Date de mariage : "));
        panelMariage.add(this.dMariage=dateMariage);

        //On ajoute au panel Mariage un Label/textfield pour la ville de mariage
        panelMariage.add(new Label("Ville de mariage :"));
        panelMariage.add(this.vMariage = new JTextField());

        //On ajoute au panel Mariage un Label/textfield pour le département de mariage
        panelMariage.add(new Label("Departement du marriage : "));
        panelMariage.add(this.depMariage=new JTextField());

        //Deux comboBox pour avoir le choix des parents (reprend les fiches de la liste)
        cPere = new JComboBox();
        cMere = new JComboBox();

        //Ajout des items "?" au cas ou le père/la mère ne peut pas être déterminé
        cPere.addItem("?");
        cMere.addItem("?");

        //On ajoute les personnes de la liste aux comboBox
        for (int i = 0; i< MaListe.getPersonneDefault().size();i++)
        {
            cPere.addItem(MaListe.getPersonneDefault().get(i));
            cMere.addItem(MaListe.getPersonneDefault().get(i));
        }

        //Ajout au panel antecedents un label et la liste à choix pour le père
        panelAntecedents.add(new Label("Son père : "));
        panelAntecedents.add(cPere);
        //..puis pour la mère
        panelAntecedents.add(new Label("Sa mère :"));
        panelAntecedents.add(cMere);

        //On écoute sur le bouton valider pour créer l'entrée
        valider.addActionListener(this);


        //On définit la dimension et on ajoute tout les panels au container principal
        container.setPreferredSize(dim);

        container.add(panelNomPrenom   );
        container.add(panelNaissance   );
        container.add(panelDeces       );
        container.add(panelMariage     );
        container.add(panelAntecedents );
        container.add(this.valider);

        this.setVisible(true);

        this.ihm=ihm;

    }

    /**
     * Second constructeur permettant la modification d'une fiche elle prend en paramètre tout les champs et remplace
     * le text du TextField avec celui de la variable.
     * @param ihm Permet de passer à l'ihm la nouvelle list
     * @param nom donne le nom
     * @param prenom donne le prénom
     * @param dNaissance donne la date du mariage
     * @param dMariage donne la date du mariage
     * @param dDeces donne la date du décès
     * @param vNaissance donne la ville de la naissance
     * @param vMariage donne la ville du mariage
     * @param vDeces donne la ville du décès
     * @param deptNaissance donne le département de naissance
     * @param deptMariage donne le département de mariage
     * @param deptDeces donne le département de décès
     * @param posPere int donnant la position dans la liste du père
     * @param posMere int donnant la position dans la liste de la mere
     */
    public Formulaire(IHM ihm,String nom,String prenom,String dNaissance,String dMariage,String dDeces,String vNaissance
                      ,String vMariage,String vDeces,String deptNaissance,String deptMariage,String deptDeces
                      ,int posPere, int posMere)
    {
        this(ihm);
        this.nom   .setText(nom)   ;
        this.prenom.setText(prenom);

        this.dNaissance  .setText(dNaissance);
        this.dMariage    .setText(dMariage)  ;
        this.dDeces      .setText(dDeces)    ;

        this.vNaissance  .setText(vNaissance);
        this.vMariage    .setText(vMariage)  ;
        this.vDeces      .setText(vDeces)    ;

        this.depNaissance.setText(deptNaissance);
        this.depMariage  .setText(deptMariage)  ;
        this.depDeces    .setText(deptDeces)    ;
        this.cPere.setSelectedIndex(posPere);
        this.cMere.setSelectedIndex(posMere);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent x) 
    {
        Object source = x.getSource();
        //Si le bouton valider est pressé alors on déclare une nouvelle fiche avec les nouvelles informations saisie/modifiées
        if (source==valider)
        {
            FicheGenealogique nvPers = new FicheGenealogique(nom.getText(), prenom.getText(),dNaissance.getText(),
                                                             vNaissance.getText(),depNaissance.getText());
            //On ajoute à la fin de la liste
            int nbPers=MaListe.getFichierGenealogique().getListeFiches().size();
            FichierGenealogique f = MaListe.getFichierGenealogique();
            //On ajoute à la liste du panelFiche
            MaListe.getPersonneDefault().add(nbPers,nvPers.getNom()+" "+nvPers.getPrenom());
            f.getListeFiches().add(nbPers, nvPers);
            f.getListeFiches().get(nbPers).setDateDeMariage  (dMariage  .getText());
            f.getListeFiches().get(nbPers).setDateDeDeces    (dDeces    .getText());
            f.getListeFiches().get(nbPers).setVilleDeMariage (vMariage  .getText());
            f.getListeFiches().get(nbPers).setVilleDeDeces   (vDeces    .getText());
            f.getListeFiches().get(nbPers).setDeptDeMariage  (depMariage.getText());
            f.getListeFiches().get(nbPers).setDeptDeDeces    (depDeces  .getText());
            //Si un père ou une mère est inconnue alors on ne saisi pas le setPere/setMere
            if(cPere.getItemAt(cPere.getSelectedIndex()) != "?")
                f.getListeFiches().get(nbPers).setPere           (f.getListeFiches().get(cPere.getSelectedIndex()));
            if(cPere.getItemAt(cMere.getSelectedIndex()) != "?")
                f.getListeFiches().get(nbPers).setMere           (f.getListeFiches().get(cMere.getSelectedIndex()));

            ihm.getPanelFiche().revalidate();
            this.dispose();
        }
    }

}
