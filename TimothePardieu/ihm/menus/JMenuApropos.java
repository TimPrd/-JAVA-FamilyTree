package ihm.menus; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */


import ihm.IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cette classe permet de crée le menu "A propos"
 */
public class JMenuApropos extends JMenu implements ActionListener {
    private IHM ihm;
    private JOptionPane jop1 = new JOptionPane();

    /**
     * Constructeur, on crée A propos en l'envoyant à la classe dont il hérite (JMenu)
     * On ajoute un item permettant le clique pour avoir un paneau d'information
     */
    public JMenuApropos()
    {
        super("A propos");
        add(new JMenuItem("Condition"  )).addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        //Action sur A propos  >
        if (evt.getSource() == this.getItem(0))
            JOptionPane.showMessageDialog(null,"Ce logiciel vous permet de creer un arbre généalogique\nCopyright Timothé Pardieu ©","À propos",JOptionPane.INFORMATION_MESSAGE);

    }
}