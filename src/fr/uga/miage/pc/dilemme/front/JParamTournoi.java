package fr.uga.miage.pc.dilemme.front;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;

public final class JParamTournoi extends FrameBase {
    private static final long serialVersionUID = 5056606608631535808L;
    List<IObserver> observers;
    List<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();
    private JButton launch;
    private JButton reset;
    private JTextField nbTours;
    private static volatile JParamTournoi instance;

    /**
     * 
     * @since 3.0
     * @see FrameBase#FrameBase(int, int, String)
     */
    private JParamTournoi() {
        super(600, 400, "Tournament Parameters", WindowConstants.DISPOSE_ON_CLOSE);
        observers = new ArrayList<IObserver>();
        initButtons(); initJCheckBoxs(); initListeners(); initJTextPane();
    }

    private void initJCheckBoxs(){
        JLabel label = new JLabel("Choose the strategies : ");
        label.setBounds(25, 10, 150, 25);
        JPanel panel = new JPanel();
        checkBoxs.add(new JCheckBox("Gentille"));
        checkBoxs.add(new JCheckBox("Mechante"));
        checkBoxs.add(new JCheckBox("Donnant-Donnant"));
        checkBoxs.add(new JCheckBox("Donnant-Donnant Dur"));
        checkBoxs.add(new JCheckBox("Mefiante"));
        checkBoxs.add(new JCheckBox("Rancunière"));
        checkBoxs.add(new JCheckBox("Periodique-Gentille"));
        checkBoxs.add(new JCheckBox("Periodique-Mechante"));
        panel.setLayout(new GridLayout(checkBoxs.size(),1));
        panel.setBounds(25, 35, 130, 25*checkBoxs.size());
        for(JCheckBox checkBox: checkBoxs){ panel.add(checkBox); }
        add(label); add(panel);
    }
    
    @Override
    protected void initButtons() {
    	launch = new JButton("Start");
        reset = new JButton("Reset");
        launch.setBounds(365, 325, 100, 25);
        reset.setBounds(475, 325, 100, 25);
        add(launch); add(reset);
    }

    private void initJTextPane(){
        JLabel label = new JLabel("Nombre de tour par rencontre : ");
        nbTours = new JTextField("0");
        label.setBounds(265, 10, 200, 25);
        nbTours.setBounds(265, 40, 150, 25);
        add(label); add(nbTours);

    }

    /**
     * @implSpec This method was impleted in order to 
     * respect the <i><u>Singleton</u></i> design pattern
     * @return The instance of the <code>JDilemme</code> Frame
     */
    public static final JParamTournoi getInstance() {
        if (JParamTournoi.instance == null) {
            synchronized (JParamTournoi.class) {
                if (JParamTournoi.instance == null) {
                	JParamTournoi.instance = new JParamTournoi();
                }
            }
        }
        return JParamTournoi.instance;
    }

    public JButton getLaunchButton(){ return launch; }

    public void reset(){
        for(JCheckBox checkBox : checkBoxs){
            if(checkBox.isSelected()) { checkBox.setSelected(false); }
        }
        if(nbTours.getText() != "0"){nbTours.setText("0");}
    }

    public int getNbTours(){ return Integer.parseInt(nbTours.getText());}

    public List<Integer> getListCheckSelected(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 1;
        for(JCheckBox checkBox: checkBoxs){if (checkBox.isSelected()) { list.add(i); } i++;}
        return list;
    }


    /**
     * 
     * @since 3.0
     * @see java.awt.event.MouseAdapter
     * @see Component#addMouseListener
     */
    @Override
    protected void initListeners() {
    	reset.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(MouseEvent e){ reset();}
        });
        launch.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(MouseEvent e){ closeWindow(); notifierAll(); }
        });
    } 

    public void addObserver(IObserver observer){ observers.add(observer);}

    public void removeObserver(IObserver observer){ observers.remove(observer);}

    public void notifierAll(){for(IObserver observer: observers){observer.notifier();}}
}
