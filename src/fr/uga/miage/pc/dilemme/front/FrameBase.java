package fr.uga.miage.pc.dilemme.front;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.Dimension;

/**
 * Abstract class which set all the common parameters of the different frame
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @since 3.0
 * @version 1.0
 */
public abstract class FrameBase extends JFrame{
	private static final long serialVersionUID = -6492481484973934111L;
    private JLabel container;

    /**
     * Create a base of a frame with the default width and height
     * and without title
     * @since 3.0
     */
    protected FrameBase(){ this(-1, -1, ""); }

    /**
     * Create the base of the frame with the height and width given
     * in parameters
     * @param width The width of the frame
     * @param height The Height of the frame
     * @since 3.0
     */
    protected FrameBase(int width, int height){ this(width, height, "", WindowConstants.EXIT_ON_CLOSE); }

    /**
     * Create a base of a frame with the height, width and title
     * given in parameters
     * @param width
     * @param height
     * @param windowTile
     * @since 3.0
     */
    protected FrameBase(int width, int height, String windowTile){ this(width, height, windowTile, WindowConstants.EXIT_ON_CLOSE); }

    /**
     * Create a base of the frame with the different common parameters
     * @param width The width of the frame
     * @param height The Height of the frame
     * @param windowTitle the title of the frame
     * @param redCrossOption Default action did by the redcross of the frame
     * @since 3.0
     */
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

    /**
     * Show an error message when the frame have a problem
     * on an action
     * @param message The error to show
     * @param e Exception catch by the application
     * @since 3.0
     */
    protected void showErrorFrame(String message, Exception e){
        String error = message+"\n";
        for (int i = 0; i < 5; i++) { error += e.getStackTrace()[i] + "\n"; }
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE, null);
    }

    /**
     * Show an info frame with a message
     * @param message the message to show
     * @since 3.0
     */
    protected void showInfoFrame(String message){ JOptionPane.showMessageDialog(null, message, "Informations ComplÃ©mentaires", JOptionPane.INFORMATION_MESSAGE); }
    
    /**
     * Allows to show the frame on the screen
     * @since 3.0
     */
    public void showFrame(){ pack(); setVisible(true); }
    
    /**
     * Allows to remove the frame from the screen
     * @since 3.0
     */
    public void closeWindow(){ setVisible(false); }
    
    /**
     * Initialize the different button, title, heigh, etc...
     * @since 3.0
     */
    protected abstract void initButtons();
    
    /**
     * Initialize the different listeners of the different 
     * component of the frame
     * @since 3.0
     */
    protected abstract void initListeners();
}
