package fr.uga.miage.pc.dilemme.front;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;

import fr.uga.miage.pc.core.ClassHelper;
import fr.uga.miage.pc.core.patterns.IObserver;
import fr.uga.miage.pc.dilemme.back.ConstHelper;
import fr.uga.miage.pc.dilemme.back.Tournoi;
import fr.uga.miage.pc.dilemme.back.helper.StringHelper;
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
    private JTextPane dataContainer;
    private JButton openJavaDoc;
    private JButton openRepositorie;
    private JButton lauchTournoi;
    private JButton exit;
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
            	LeftClickOpenPage(e, ConstHelper.gitRepositorie);
            }
        });

        openJavaDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                LeftClickOpenPage(e, ConstHelper.javadoc);
            }
        });
    }
    
    private void LeftClickOpenPage(java.awt.event.MouseEvent e, String page) {
    	if (SwingUtilities.isLeftMouseButton(e)) {
            try { UIHelper.openWebPage(page); } 
            catch (Exception e1) { UIHelper.showErrorFrame("An error append when the opening of the web page !", e1); }
        }
    }
    
    @Override
    public void notifier(){
        try {
            final int nbTours = paramFrame.getNbTours();
            List<IStrategie> strategies = ClassHelper.createListObject(paramFrame.getListCheckSelected());
            ITournoi test = new Tournoi(nbTours, strategies);
            paramFrame.closeWindow();
            String sumUp = StringHelper.tournoi(test);
            for(IConfrontation current: test.Confrontations()) {
                sumUp += StringHelper.sumUpConfrontation(true, current);
            }
            sumUp += "<p>Fin du Tournoi !<br/><b><u>Resume du Tournoi :</u></b></p>" + StringHelper.sumUpTournoiWithHtml(test);
            dataContainer.setText(sumUp);
        } 
        catch (Exception e1) { UIHelper.showErrorFrame("An error append during the launch of the tournament !", e1); }
    }
}
