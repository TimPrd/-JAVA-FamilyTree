package ihm.menus; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */
import ihm.IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class JMenuFichier extends JMenu implements ActionListener {

    private IHM ihm;
    private JMenuItem nouveau, enregistrer, enregistrerS, ouvrir, quitter;

    /**
     * Ce constructeur permet le sous menu fichier avec tout ses items
     * @param ihm permet de modifier l'ihm principale
     */
    public JMenuFichier(IHM ihm) 
    {
        super("Fichier");
        add(this.nouveau      = new JMenuItem("Nouveau"         )).addActionListener(this);
        add(this.enregistrer  = new JMenuItem("Enregistrer"     )).addActionListener(this);
        add(this.enregistrerS = new JMenuItem("Enregistrer sous")).addActionListener(this);
        add(this.ouvrir       = new JMenuItem("Ouvrir"          )).addActionListener(this);
        add(this.quitter      = new JMenuItem("Quitter"         )).addActionListener(this);

        //On ajoute les raccourcis clavier à chaque action (nouveau = ctrl+n, quitter = ctrl+q ..)
        this.nouveau      .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        this.enregistrer  .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        this.enregistrerS .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK+ ActionEvent.ALT_MASK));
        this.ouvrir       .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        this.quitter      .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        this.ihm = ihm;
    }

    @Override
    public void actionPerformed(ActionEvent evt) 
    {
        //Action sur fichier > Nouveau
        if (evt.getSource() == this.nouveau)
            ihm.nouveau();

        //Action sur fichier > Enregistrer
        if (evt.getSource() == this.enregistrer)
        {
            ihm.enregistrer();
        }

        //Action sur fichier > Enregistrer sous
        if (evt.getSource() == this.enregistrerS)
           ihm.enregistrerS();


        //Action sur fichier > Ouvrir
        if (evt.getSource() == this.ouvrir)
            ihm.ouvrir();


        //Action sur fichier > Quitter
        if (evt.getSource() == this.quitter)
            //Quitte le programme
            System.exit(0);
    }
}
