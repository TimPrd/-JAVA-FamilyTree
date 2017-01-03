package ihm.menus; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */
import ihm.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Classe permettant la création du menu outil
 */
public class JMenuOutils extends JMenu implements ActionListener
{
    private IHM ihm;
    private JMenuItem  zoomP ;
    private JMenuItem  zoomM ;
    private JMenuItem  hautP ;
    private JMenuItem  hautM ;
    private int zoom = 1;

    /**
     * On crée le menu avec quatre items permettant de régler le zoom ou la hauteur
     * On y ajoute les raccourcis clavier
     * @param ihm
     */
    public JMenuOutils(IHM ihm) 
    {
        super("Outils");
        add(this.zoomP = new JMenuItem("Agrandir le zoom"    )).addActionListener(this);
        add(this.zoomM = new JMenuItem("Réduire le zoom"     )).addActionListener(this);
        add(this.hautP = new JMenuItem("Augmenter la hauteur")).addActionListener(this);
        add(this.hautM = new JMenuItem("Diminuer la hauteur" )).addActionListener(this);
        //On ajoute les raccourcis clavier lier aux boutons pour avoir ctrl++ ou ctrl+-
        this.zoomP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ActionEvent.CTRL_MASK));
        this.zoomM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
        this.ihm=ihm;
    }

    public void zoom()
    {
        ihm.getPanelArbre().setPreferredSize(new Dimension(20+zoom*150,20+zoom*100));
        ihm.getPanelAffi().revalidate();
        ihm.getPanelArbre().revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {

        //Action sur outils > Augmenter zoom
        if (evt.getSource() == zoomP)
            if (zoom<5) zoom++;
                zoom();


        //Action sur outils > Reduire zoom
        if (evt.getSource() == zoomM)
            if (zoom>1) zoom--;
                zoom();


    }
}

