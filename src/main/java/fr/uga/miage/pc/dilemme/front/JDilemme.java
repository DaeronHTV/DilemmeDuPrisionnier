package fr.uga.miage.pc.dilemme.front;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.BorderLayout;
import fr.uga.miage.pc.core.patterns.IObserver;
import fr.uga.miage.pc.dilemme.back.ConstHelper;
import fr.uga.miage.pc.dilemme.back.Tournoi;
import fr.uga.miage.pc.dilemme.back.interfaces.*;
import fr.uga.miage.pc.dilemme.back.helper.StringHelper;
import static fr.uga.miage.pc.dilemme.front.helper.UIHelper.openWebPage;
import static fr.uga.miage.pc.dilemme.front.helper.UIHelper.showErrorFrame;
import static fr.uga.miage.pc.core.ClassHelper.createListObject;

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
    protected final void initButtons() {
        openJavaDoc = new JButton(ConstUIHelper.OPENJAVADOCNAME);
        openRepositorie = new JButton(ConstUIHelper.OPENGIT);
        lauchTournoi = new JButton(ConstUIHelper.LAUNCH);
        exit = new JButton(ConstUIHelper.EXIT);
        lauchTournoi.setBounds(725, 20, 150, 25);
        openJavaDoc.setBounds(725, 50, 150, 25);
        openRepositorie.setBounds(725, 80, 150, 25);
        exit.setBounds(725, 110, 150, 25);
        add(openJavaDoc);add(openRepositorie);
        add(lauchTournoi);add(exit);
    }

    private final void initTextArea(){
        dataContainer = new JTextPane();
        dataContainer.setEditorKit(new HTMLEditorKit());
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(0,0,700,562);
        panel.add(new JScrollPane(dataContainer, javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        		javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
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
    protected final void initListeners() {
        lauchTournoi.addMouseListener(new java.awt.event.MouseAdapter() {
        	@Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                paramFrame.reset();
                dataContainer.setText(StringHelper.EMPTY);
                paramFrame.showFrame();
            }
        });

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
        	@Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    setVisible(false);
                    if (isDisplayable()) { dispose(); }
                    System.exit(0);
                }
            }
        });

        openRepositorie.addMouseListener(new java.awt.event.MouseAdapter() {
        	@Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            	leftClickOpenPage(e, ConstHelper.GITREPOSITORIE);
            }
        });

        openJavaDoc.addMouseListener(new java.awt.event.MouseAdapter() {
        	@Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                leftClickOpenPage(e, ConstHelper.JAVADOC);
            }
        });
    }
    
    private final void leftClickOpenPage(java.awt.event.MouseEvent e, final String page) {
    	if (SwingUtilities.isLeftMouseButton(e)) {
            try { openWebPage(page); } 
            catch (Exception e1) { showErrorFrame("An error append when the opening of the web page !", e1); }
        }
    }
    
    public final void notifier(){
        try {
            final int nbTours = paramFrame.getNbTours();
            ITournoi test = new Tournoi(nbTours, createListObject(paramFrame.getListCheckSelected()));
            paramFrame.closeWindow();
            StringBuilder builder = new StringBuilder();
            builder.append(StringHelper.tournoi(test));
            for(IConfrontation current: test.confrontations()) {
            	current.start(nbTours);
                builder.append(StringHelper.sumUpConfrontation(true, current));
            }
            builder.append("<p>Fin du Tournoi !<br/><b><u>Resume du Tournoi :</u></b></p>")
            .append(StringHelper.sumUpTournoiWithHtml(test));
            dataContainer.setText(builder.toString());
        } 
        catch (Exception e1) { showErrorFrame("An error append during the launch of the tournament !", e1); }
    }
}
