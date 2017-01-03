package ihm.barresOutils; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */

import ihm.IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permettant la création de la barre d'outils en haut
 */
public class MaJToolBar extends JToolBar implements ActionListener
{
    private IHM ihm;
    //On définit les boutons avec leurs images associé sur le bouton
    private JButton  save          = new JButton(new ImageIcon("images/save.png"));
    private JButton  saveas        = new JButton(new ImageIcon("images/saveas.png"));
    private JButton  ouvrir        = new JButton(new ImageIcon("images/ouvrir.png"));
    private JButton  add           = new JButton(new ImageIcon("images/add.png"));
    private JButton  clear         = new JButton(new ImageIcon("images/clear.png"));
    private JButton  quit          = new JButton(new ImageIcon("images/quit.png"));

    /**
     * Constructeur de la barre d'outils. Initialise les boutons avec les images et associe un actionListener
     * @param ihm
     */
    public MaJToolBar(IHM ihm)
    {
        this.ihm = ihm;

        this.add(  save      );                              
        this.add(  saveas    );
        this.add(  ouvrir    );
        this.add(  add       );
        this.add(  clear     );
        this.add(  quit      );

        this.save      .addActionListener(this);
        this.saveas    .addActionListener(this);
        this.ouvrir    .addActionListener(this);
        this.add       .addActionListener(this);
        this.clear     .addActionListener(this);
        this.quit      .addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        //Chaque évènement redirige vers les méthodes définit dans l'IHM car elles sont utilisées plusieurs fois (barre outils, menu ..)
        //Enregister Sous | Bouton numero 1 (disquette)
        if (evt.getSource() == this.save)
            ihm.enregistrer();

        //Enregistrer | Bouton numero 2 (disquette + crayon)
        if (evt.getSource() == this.saveas)
            ihm.enregistrerS();

        //Ouvrir | Bouton numero 3 (dossier)
        if(evt.getSource() == this.ouvrir)
            ihm.ouvrir();

        //Ajouter | Bouton numero 4 (badge +)
        if(evt.getSource() == this.add)
            ihm.ajouter();

        //Supprimer une fiche | Bouton numero 5 (balais)
        if(evt.getSource() == this.clear)
            ihm.effacer();

        //Quitter | Bouton numero 6 (croix rouge)
        if(evt.getSource() == this.quit)
            System.exit(0);

    }


}
