package fr.uga.miage.pc.dilemme.front;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import fr.uga.miage.pc.dilemme.back.ApiDilemme;
import fr.uga.miage.pc.dilemme.back.ConstHelper;
import fr.uga.miage.pc.dilemme.back.interfaces.*;
import fr.uga.miage.pc.dilemme.front.helper.UIHelper;
import fr.uga.miage.pc.interfaces.IStrategie;
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

    private JDilemme() throws Exception {
        super(-1, -1, "Dilemme du prisonnier");
        paramFrame = JParamTournoi.getInstance();
        paramFrame.addObserver(this);
        initButtons();
        initTextArea();
        initListeners();
    }

    @Override
    protected void initButtons() {
        openJavaDoc = new JButton("Open Javadoc");
        openRepositorie = new JButton("Opent git repositorie");
        lauchTournoi = new JButton("Launch Tournament");
        exit = new JButton("Exit");
        lauchTournoi.setBounds(725, 20, 150, 25);
        openJavaDoc.setBounds(725, 50, 150, 25);
        openRepositorie.setBounds(725, 80, 150, 25);
        exit.setBounds(725, 110, 150, 25);
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
     * @throws Exception 
     */
    public static final JDilemme getInstance() throws Exception {
        if (JDilemme.instance == null) {
            synchronized (JDilemme.class) {
                if (JDilemme.instance == null) { JDilemme.instance = new JDilemme(); }
            }
        }
        return JDilemme.instance;
    }

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
                    try { UIHelper.openWebPage(ConstHelper.gitRepositorie); } 
                    catch (Exception e1) { UIHelper.showErrorFrame("An error append when the opening of the web page !", e1); }
                }
            }
        });

        openJavaDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    try { UIHelper.openWebPage(ConstHelper.javadoc); } 
                    catch (Exception e1) { UIHelper.showErrorFrame("An error append when the opening of the web page !", e1); }
                }
            }
        });
    }
    
    @Override
    public void notifier(){
        try {
            final int nbTours = paramFrame.getNbTours();
            List<IStrategie> strategies = ApiDilemme.createListStrategie(paramFrame.getListCheckSelected());
            ITournoi test = ApiDilemme.createTournoi(strategies, nbTours);
            paramFrame.closeWindow();
            String sumUp = ApiDilemme.tournoiHtml();
            for(int i = 1; test.hasMoreElements(); i++) {
            	IConfrontation current = test.nextElement();
                sumUp += ApiDilemme.confrontationHtml(i, current);
            }
            sumUp += "<p>Fin du Tournoi !<br/><b><u>Resume du Tournoi :</u></b></p>" + ApiDilemme.sumUpTournoiHtml();
            dataContainer.setText(sumUp);
        } 
        catch (Exception e1) { UIHelper.showErrorFrame("An error append during the launch of the tournament !", e1); }
    }
}
