package fr.uga.miage.pc.dilemme.front.helper;

import java.awt.Component;
import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class UIHelper {
	public static void showErrorFrame(String message, Exception e){
		StringBuilder builder = new StringBuilder();
		builder.append(message).append("\n");
        for (int i = 0; i < e.getStackTrace().length; i++) {
        	builder.append(e.getStackTrace()[i]).append("\n"); 
        }
        JOptionPane.showMessageDialog(null, builder.toString(), "Error", JOptionPane.ERROR_MESSAGE, null);
    }
	
	/**
     * Open a web page to the link given in parameter if the Desktop class is supported
     * @since 3.0
     * @param url - The link of the web page to open in the web browser
     * @throws ClassNotSupportedException Throw if the Desktop class is not supported on the user system
     */
    public static final void openWebPage(String url) throws Exception {
        if(Desktop.isDesktopSupported()){ Desktop.getDesktop().browse(new java.net.URI(url)); } 
        else { throw new Exception("The class used to open web pages isn't supported on your system !"); }
    }
    
    public static final void AddAll(JFrame frame, Component... comps) {
    	for(Component comp: comps) { frame.add(comp); }
    }

}
