package fr.uga.miage.pc.dilemme.front;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class ParamFrame {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static volatile ParamFrame instance = null;
    /*List of Observer which need to change when JParam is modified*/
    private static List<IObserver> observers;
    private List<Integer> strategies;
    private int nbTours;

    private ParamFrame(){
        observers = new ArrayList<IObserver>();
        strategies = new ArrayList<Integer>();
        nbTours = 0;
    }

     /**
     * @implSpec This method was impleted in order to 
     * respect the <i><u>Singleton</u></i> design pattern
     * @return The instance of the <code>JDilemme</code> Frame
     */
    public static final ParamFrame getInstance() {
        if (ParamFrame.instance == null) {
            synchronized (ParamFrame.class) {
                if (ParamFrame.instance == null) { ParamFrame.instance = new ParamFrame(); }
            }
        }
        return ParamFrame.instance;
    }

    public void initParametres() throws Exception{
		System.out.println("Veuillez choisir les Strategies qui vont s'affronter :\n1. Gentille\n2. Mechante\n3. Donnant-Donant\n"
			+ "4. Donnant-Donnant Dur\n5. Mefiante\n6. Rancuni�re\n7. Periodique-Gentille\n8. Periodique-Mechante\n");
		System.out.print("Separe les numeros par un '-' : ");
		String[] result = br.readLine().split("-");
        for(int i = 0; i < result.length; i++){ strategies.add(Integer.parseInt(result[i]));}
        System.out.print("Veuillez maintenant indiquer le nombre de tours par Rencontre : ");
        nbTours = Integer.parseInt(br.readLine());
        notifierAll();
    }

    public int getNbTours(){ return nbTours;}

    public void reset(){ nbTours = 0; strategies.clear(); }

    public List<Integer> getList(){ return strategies; }

    public void addObserver(IObserver observer){observers.add(observer);}

    public void removeObserver(IObserver observer){observers.remove(observer);}

    public void notifierAll(){for(IObserver observer: observers){observer.notifier();}}
}