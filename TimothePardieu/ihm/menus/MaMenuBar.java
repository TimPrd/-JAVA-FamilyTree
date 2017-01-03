package ihm.menus; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */

import ihm.IHM;
import ihm.menus.JMenuApropos;
import ihm.menus.JMenuFiche;
import ihm.menus.JMenuFichier;
import ihm.menus.JMenuOutils;

import javax.swing.*;

/**
 * Pemet d'ajouter à la barre de menu tout les sous menus (fichiers, fiche, outils ..)
 */
public class MaMenuBar extends JMenuBar
{

    public MaMenuBar(IHM ihm)
    {

        this.add(new JMenuFichier(ihm) );
        this.add(new JMenuFiche(ihm) );
        this.add(new JMenuOutils(ihm) );
        this.add(new JMenuApropos() );

    }
}
