package fr.uga.miage.pc.dilemme.front;

/*Javax Swing Import*/
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
/*Java Awt Import*/
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
/*Local import*/
import fr.uga.miage.pc.dilemme.back.ApiDilemme;
import fr.uga.miage.pc.dilemme.back.Confrontation;
import fr.uga.miage.pc.interfaces.IStrategie;

/*Java Util Import*/
import java.util.Enumeration;
import java.util.List;

/**
 * This class create an instance of <code>JFrame</code> used to show the
 * <code>Tournoi</code> and his datas to the user. Respect the Single Design
 * Pattern in order to not duplicate the Frame
 * 
 * @see FrameBase
 * @implSpec This class respect the Singleton Design pattern
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @serial 7596513329960155614L
 * @since 3.0
 * @version 1.0
 */

public final class JDilemme extends FrameBase implements IObserver{
    private static final long serialVersionUID = 7596513329960155614L;
    /* Links of the different web pages */
    private static final String gitRepositorie = "https://gitlab.com/AurelienAVZN/pc_dilemmeduprisonnier";
    private static final String javadoc = "https://pc-dilemmeprisonnier.netlify.app/";
    /* JArea to show information about the tournament */
    private JTextPane dataContainer;
    /* JButtons of the frame*/
    private JButton openJavaDoc;
    private JButton openRepositorie;
    private JButton lauchTournoi;
    private JButton exit;
    /* Instance of the frame in order to respect the Singleton Design Pattern */
    private static volatile JDilemme instance;
    private static JParamTournoi paramFrame;


    /**
     * 
     * @since 3.0
     * @see FrameBase#FrameBase(int, int, String)
     */
    private JDilemme() {
        super(-1, -1, "Dilemme du prisonnier");
        paramFrame = JParamTournoi.getInstance();
        paramFrame.addObserver(this);
        initButtons();
        initTextArea();
        initListeners();
    }

    @Override
    protected void initButtons() {
        Dimension taille = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        openJavaDoc = new JButton("Open Javadoc");
        openRepositorie = new JButton("Opent git repositorie");
        lauchTournoi = new JButton("Launch Tournament");
        exit = new JButton("Exit");
        lauchTournoi.setBounds(725, (taille.height - 380), 150, 25);
        openJavaDoc.setBounds(725, (taille.height - 345), 150, 25);
        openRepositorie.setBounds(725, (taille.height - 310), 150, 25);
        exit.setBounds(725, (taille.height - 275), 150, 25);
        add(openJavaDoc);add(openRepositorie);
        add(lauchTournoi);add(exit);
    }

    private void initTextArea(){
        dataContainer = new JTextPane();
        dataContainer.setContentType("text/html");
        javax.swing.JPanel panel = new javax.swing.JPanel();
        JScrollPane scrollPane = new JScrollPane(dataContainer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.setSize(new Dimension(725,600));
        panel.setLayout(new BorderLayout());
        panel.setBounds(0,0,700,562);
        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);
    }

    /**
     * @implSpec This method was impleted in order to respect the
     * <i><u>Singleton</u></i> design pattern
     * @return The instance of the <code>JDilemme</code> Frame
     */
    public static final JDilemme getInstance() {
        if (JDilemme.instance == null) {
            synchronized (JDilemme.class) {
                if (JDilemme.instance == null) { JDilemme.instance = new JDilemme(); }
            }
        }
        return JDilemme.instance;
    }

    /**
     * 
     * @since 3.0
     * @see java.awt.event.MouseAdapter
     * @see Component#addMouseListener
     */
    @Override
    protected void initListeners() {
        lauchTournoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                paramFrame.reset();
                dataContainer.setText("");
                paramFrame.showFrame();
            }
        });

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    setVisible(false);
                    if (isDisplayable()) { dispose(); }
                    System.exit(0);
                }
            }
        });

        openRepositorie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    try { openWebPage(gitRepositorie); } 
                    catch (Exception e1) { showErrorFrame("An error append when the opening of the web page !", e1); }
                }
            }
        });

        openJavaDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    try { openWebPage(javadoc); } 
                    catch (Exception e1) { showErrorFrame("An error append when the opening of the web page !", e1); }
                }
            }
        });
    }
    
    /**
     * Open a web page to the link given in parameter if the Desktop class is supported
     * @since 3.0
     * @param url - The link of the web page to open in the web browser
     * @throws ClassNotSupportedException Throw if the Desktop class is not supported on the user system
     */
    private static final void openWebPage(String url) throws Exception {
        if(Desktop.isDesktopSupported()){ Desktop.getDesktop().browse(new java.net.URI(url)); } 
        else { throw new Exception("The class used to open web pages isn't supported on your system !"); }
    }

    @Override
    public void notifier(){
        try {
            List<Integer> result = paramFrame.getListCheckSelected();
            int nbTours = paramFrame.getNbTours();
            int i = 1;
            List<IStrategie> strategies = ApiDilemme.createListStrategie(result);
            Enumeration<Confrontation> test = ApiDilemme.createTournoi(strategies, nbTours);
            paramFrame.closeWindow();
            String sumUp = ApiDilemme.tournoiHtml();
            while(test.hasMoreElements()) {
                Confrontation current = test.nextElement();
                sumUp += ApiDilemme.confrontationHtml(i, current);
                i++;
            }
            sumUp += "<p>Fin du Tournoi !<br/><b><u>Resume du Tournoi :</u></b></p>" + ApiDilemme.sumUpTournoiHtml();
            dataContainer.setText(sumUp);
        } 
        catch (Exception e1) { showErrorFrame("An error append during the launch of the tournament !", e1); }
    }
}
