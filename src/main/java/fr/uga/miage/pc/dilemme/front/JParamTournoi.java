package fr.uga.miage.pc.dilemme.front;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.lang.reflect.Modifier;

import fr.uga.miage.pc.core.ClassHelper;
import fr.uga.miage.pc.core.FileHelper;
import fr.uga.miage.pc.core.patterns.IObserver;
import fr.uga.miage.pc.dilemme.front.extensions.ExtentedCheckBox;
import fr.uga.miage.pc.interfaces.IStrategie;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;

public final class JParamTournoi extends FrameBase {
    private static final long serialVersionUID = 5056606608631535808L;
    /** List of Observer which need to change when JParam is modified*/
    private List<IObserver> observers = new ArrayList<>();
    /** We create an ArrayList of JCheckBox in order to get the value*/
    private List<ExtentedCheckBox> checkBoxs = new ArrayList<>();
    /** Button to control choice of the user*/
    private JButton launch;
    /** Button to control the reset of the parameters */
    private JButton reset;
    /** JTextField in order to get the number of turn per Confrontation*/
    private JTextField nbTours;
    /** Instance of the frame in order to respect the Singleton Design Pattern */
    private static volatile JParamTournoi instance;

    /**
     * 
     * @throws Exception 
     * @since 3.0
     * @see FrameBase#FrameBase(int, int, String)
     */
    private JParamTournoi() throws Exception {
        super(600, 400, "Tournament Parameters", WindowConstants.DISPOSE_ON_CLOSE);
        initButtons(); initJCheckBoxs(); initListeners(); initJTextPane();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void initJCheckBoxs() throws Exception{
        JLabel label = new JLabel("Choose the strategies");
        JLabel titre = new JLabel("Strategies of software :");
        JLabel titre2 = new JLabel("Strategies from Mariia and Marie-Jos�e");
        label.setBounds(25, 10, 150, 25);
        titre.setBounds(25, 35, 150, 25);
        titre2.setBounds(250, 35, 250, 25);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String path = loader.getDefinedPackages()[0].getName();
        List<Class> classes = ClassHelper.filterClass(FileHelper.getClasses(path, true), c -> {
        	try {
				return ClassHelper.haveInterface(c, IStrategie.class) && !Modifier.isAbstract(c.getModifiers());
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
        });
        for(Class strategie: classes) {
        	ExtentedCheckBox checkBox = new ExtentedCheckBox(strategie.getSimpleName(), strategie);
        	checkBoxs.add(checkBox);
        	panel.add(checkBox); 
        }
        //Strategy of the other group
        //checkBoxs.add(new ExtentedCheckBox("Gentille", fr.uga.miage.pc.strategies.Gentille.class));
        //checkBoxs.add(new ExtentedCheckBox("Mechante", fr.uga.miage.pc.strategies.Mechante.class));
        //checkBoxs.add(new ExtentedCheckBox("Rancuni�re", fr.uga.miage.pc.strategies.Rancuniere.class));
        panel.setLayout(new GridLayout(8,1));
        panel.setBounds(25, 60, 200, 25*8);
        panel2.setLayout(new GridLayout(3, 1));
        panel2.setBounds(250, 60, 130, 25*3);
        for(int i = 8; i < 11; i++){ panel2.add(checkBoxs.get(i)); }
        add(label); add(titre); add(panel);add(titre2);add(panel2);
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
        label.setBounds(250, 175, 200, 25);
        nbTours.setBounds(250, 205, 150, 25);
        add(label); add(nbTours);

    }

    /**
     * @implSpec This method was impleted in order to 
     * respect the <i><u>Singleton</u></i> design pattern
     * @return The instance of the <code>JDilemme</code> Frame
     * @throws Exception 
     */
    public static final JParamTournoi getInstance() throws Exception {
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
        for(ExtentedCheckBox checkBox : checkBoxs){
            if(checkBox.isSelected()) { checkBox.setSelected(false); }
        }
        if(nbTours.getText().equals("0")){nbTours.setText("0");}
    }

    public int getNbTours(){ return Integer.parseInt(nbTours.getText());}

    public List<Class<? extends IStrategie>> getListCheckSelected(){
    	List<Class<? extends IStrategie>> strategie = new ArrayList<>();
    	for(ExtentedCheckBox checkBox: checkBoxs){
    		if (checkBox.isSelected()) { 
    			strategie.add(checkBox.GetCoupledClass()); 
    		} 
    	}
    	return strategie;
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
    		@Override
            public void mousePressed(MouseEvent e){ reset();}
        });
        launch.addMouseListener(new java.awt.event.MouseAdapter(){
        	@Override
            public void mousePressed(MouseEvent e){ closeWindow(); notifierAll(); }
        });
    } 

    public void addObserver(IObserver observer){ observers.add(observer);}

    public void removeObserver(IObserver observer){ observers.remove(observer);}

    public void notifierAll(){for(IObserver observer: observers){observer.notifier();}}
}
