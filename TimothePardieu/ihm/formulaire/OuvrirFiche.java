package ihm.formulaire; /**
 * Timothe PARDIEU - INFOG2  Copyright (c) 2016
 * @author timothe.pardieu@et.univ-lehavre.fr
 */
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe pour l'ouverture d'un fichier
 */
public class OuvrirFiche extends JFileChooser
{

    /**
     *Constructeur permettant d'ouvrir un fichier.
     * Ici on ajoute une restriction, seul les fichiers .txt peuvent être lus
     */
    public OuvrirFiche()
    {
        super();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        this.setFileFilter(filter);
        this.showOpenDialog(null);
    }
}

