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

public final class JParamTournoi extends FrameBase implements IObservable{
    private static final long serialVersionUID = 5056606608631535808L;
    /*List of Observer which need to change when JParam is modified*/
    List<IObserver> observers;
    /*We create an ArrayList of JCheckBox in order to get the value fastly*/
    List<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();
    /*Button to control choice of the user*/
    private JButton launch;
    private JButton reset;
    /*JTextField in order to get the number of turn per Confrontation*/
    private JTextField nbTours;
    /* Instance of the frame in order to respect the Singleton Design Pattern */
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
        JLabel label = new JLabel("Choose the strategies");
        JLabel titre = new JLabel("Strategies of software :");
        JLabel titre2 = new JLabel("Strategies from Mariia and Marie-Josée");
        label.setBounds(25, 10, 150, 25);
        titre.setBounds(25, 35, 150, 25);
        titre2.setBounds(250, 35, 250, 25);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        //One CheckBox per Strategie
        checkBoxs.add(new JCheckBox("Gentille"));
        checkBoxs.add(new JCheckBox("Mechante"));
        checkBoxs.add(new JCheckBox("Donnant-Donnant"));
        checkBoxs.add(new JCheckBox("Donnant-Donnant Dur"));
        checkBoxs.add(new JCheckBox("Mefiante"));
        checkBoxs.add(new JCheckBox("Rancuniére"));
        checkBoxs.add(new JCheckBox("Periodique-Gentille"));
        checkBoxs.add(new JCheckBox("Periodique-Mechante"));
        //Strategie de Mariia et Marie-Josï¿½e
        checkBoxs.add(new JCheckBox("Gentille"));
        checkBoxs.add(new JCheckBox("Mechante"));
        checkBoxs.add(new JCheckBox("Rancuniére"));
        panel.setLayout(new GridLayout(8,1));
        panel.setBounds(25, 60, 200, 25*8);
        panel2.setLayout(new GridLayout(3, 1));
        panel2.setBounds(250, 60, 130, 25*3);
        for(int i = 0; i < 8; i++){ panel.add(checkBoxs.get(i)); }
        for(int i = 8; i < 11; i++){ panel2.add(checkBoxs.get(i)); }
        add(label); add(titre); add(panel);add(titre2);add(panel2);
    }
    
    /**{@inheritDoc}**/
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
        label.setBounds(250, 175, 200, 25);
        nbTours.setBounds(250, 205, 150, 25);
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


    /**{@inheritDoc}**/
    @Override
    protected void initListeners() {
    	reset.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(MouseEvent e){ reset();}
        });
        launch.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(MouseEvent e){ closeWindow(); notifierAll(); }
        });
    } 

    /**{@inheritDoc}**/
    @Override
    public void addObserver(IObserver observer){ observers.add(observer);}

    /**{@inheritDoc}**/
    @Override
    public void removeObserver(IObserver observer){ observers.remove(observer);}

    /**{@inheritDoc}**/
    @Override
    public void notifierAll(){for(IObserver observer: observers){observer.notifier();}}
}
