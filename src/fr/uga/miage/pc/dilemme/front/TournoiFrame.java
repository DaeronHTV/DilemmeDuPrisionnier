package fr.uga.miage.pc.dilemme.front;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.awt.Desktop;

import fr.uga.miage.pc.dilemme.back.strategie.*;
import fr.uga.miage.pc.dilemme.back.ApiDilemme;
import fr.uga.miage.pc.dilemme.back.Confrontation;

/**
 * This class is used like a window, it shows the menu and the possibility for the
 * user on the console
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @version 1.0
 * @since 3.0
 */
public final class TournoiFrame implements IObserver{
	/* Links of the different web pages */
    private static final String gitRepositorie = "https://gitlab.com/AurelienAVZN/pc_dilemmeduprisonnier";
    private static final String javadoc = "https://pc-dilemmeprisonnier.netlify.app/";
	private static volatile TournoiFrame instance = null;
	private static ParamFrame parametres = null;

	/**
	 * Create a object that contains the object in order to give
	 * the parameter for the tournament and which function like
	 * a window but on the console
	 * @since 3.0
	 */
	private TournoiFrame(){
		parametres = ParamFrame.getInstance();
		parametres.addObserver(this);
	}

	/**
     * @implSpec This method was impleted in order to 
     * respect the <i><u>Singleton</u></i> design pattern
     * @return The instance of the <code>JDilemme</code> Frame
	 * @since 3.0
     */
    public static final TournoiFrame getInstance() {
        if (TournoiFrame.instance == null) {
            synchronized (TournoiFrame.class) {
                if (TournoiFrame.instance == null) { 
					TournoiFrame.instance = new TournoiFrame(); 
				}
            }
        }
        return TournoiFrame.instance;
    }

	/**
	 * Show the menu of the object in order to let the user choose
	 * what it wants to do
	 * @since 3.0
	 */
	public final void afficheMenu(){
		while(true){
			try{
				System.out.println("Menu principal :");
				System.out.println("1 - Launch Tournament\n2 - Open javadoc");
				System.out.println("3 - Open repositorie\n4 - Exit");
				System.out.print("\nVotre choix : ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				menu(Integer.parseInt(reader.readLine()));
			}catch(Exception e){e.printStackTrace();}
		}
	}

	/**
     * Open a web page to the link given in parameter if the Desktop class is supported
     * @since 3.0
     * @param url - The link of the web page to open in the web browser
     * @throws Exception Throw if the Desktop class is not supported on the user system
	 * @throws Exception If the url is null
     */
    protected final boolean openWebPage(String url) throws Exception {
		boolean opened = false;
        if(Desktop.isDesktopSupported()){ Desktop.getDesktop().browse(new java.net.URI(url)); opened = true;} 
        else { throw new Exception("The class used to open web pages isn't supported on your system !"); }
		return opened;
	}
	
	/**
	 * Launch the process ask by the user 
	 * @param choix choice made by the user
	 * @since 3.0
	 * @throws Exception Exception throw by the openWebPage funcion
	 */
	private void menu(int choix) throws Exception{
		switch(choix){
			case 1:parametres.reset();parametres.initParametres();break;
			case 2:openWebPage(javadoc);break;
			case 3:openWebPage(gitRepositorie);break;
			case 4:System.exit(0);break;
			default:break;
		}
	}

	/**{@inheritDoc} */
	@Override
	public void notifier() {
		List<Integer> result = parametres.getList();
        int nbTours = parametres.getNbTours();
        try {
            int i = 1;
            List<IStrategie> strategies = ApiDilemme.createListStrategie(result);
            Enumeration<Confrontation> test = ApiDilemme.createTournoi(strategies, nbTours);
            System.out.println(ApiDilemme.tournoiText());
            while(test.hasMoreElements()) {
                Confrontation current = test.nextElement();
                System.out.println(ApiDilemme.confrontationText(i, current)+"\n");
                i++;
            }
			System.out.println("Fin du Tournoi !\nResume du Tournoi :");
			System.out.println(ApiDilemme.sumUpTournoiText());
        } 
        catch (Exception e1) { 
			System.out.println("An error append during the launch of the tournament !"); 
			e1.printStackTrace(); 
		}
	}
}
