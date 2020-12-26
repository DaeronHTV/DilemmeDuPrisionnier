package fr.uga.miage.pc.dilemme.front;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public abstract class FrameBase extends JFrame{
	private static final long serialVersionUID = -6492481484973934111L;
    private JLabel container;

    protected FrameBase(){ this(-1, -1, ""); }

    protected FrameBase(int width, int height){ this(width, height, "", WindowConstants.EXIT_ON_CLOSE); }

    protected FrameBase(int width, int height, String windowTile){ this(width, height, windowTile, WindowConstants.EXIT_ON_CLOSE); }

    protected FrameBase(int width, int height, String windowTitle, int redCrossOption){
        super(windowTitle);
        Dimension taille = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(redCrossOption);
        if(width == -1 || height == -1){ setPreferredSize(new Dimension(900, 600)); } 
        else{ setPreferredSize(new Dimension(width, height));}
        container = new JLabel();setContentPane(container);
        setLocation(taille.width/5,taille.height/10);
        setResizable(false);
    }

    protected void showErrorFrame(String message, Exception e){
        String error = message+"\n";
        for (int i = 0; i < 5; i++) { error += e.getStackTrace()[i] + "\n"; }
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE, null);
    }

    protected void showInfoFrame(String message){ JOptionPane.showMessageDialog(null, message, "Informations Complémentaires", JOptionPane.INFORMATION_MESSAGE); }

    public void showFrame(){ pack(); setVisible(true); }

    public void closeWindow(){ setVisible(false); }

    protected abstract void initButtons();

    protected abstract void initListeners();
}
