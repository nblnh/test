package org.nn.sc.empty.jet.setups;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalisation {

	private Locale local;
	private ResourceBundle bundle;
	
	public Internationalisation(String lang)
	{
		if(lang == null){
			lang = System.getProperty("user.language");
		}
		
		local = new Locale(lang);
		bundle = ResourceBundle.getBundle("ressources", local);
	}
	
	public String getText(String key)
	{
		return bundle.getString(key)
;	}
}
