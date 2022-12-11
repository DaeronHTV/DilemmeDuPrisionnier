package fr.uga.miage.pc.dilemme.front.extensions;

import javax.swing.JCheckBox;

import fr.uga.miage.pc.interfaces.IStrategie;

public class ExtentedCheckBox extends JCheckBox implements ICouple<Class<? extends IStrategie>>{
	private static final long serialVersionUID = -1852112429556468366L;
	private Class<? extends IStrategie> associatedStrategie;

	public ExtentedCheckBox(String name, Class<? extends IStrategie> strategie) {
		super(name);
		associatedStrategie = strategie;
	}
	
	public Class<? extends IStrategie> getCoupledClass() {
		return associatedStrategie;
	}
}
