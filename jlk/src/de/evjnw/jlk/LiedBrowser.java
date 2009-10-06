/* 
   JLK - Java Lieder Katalog
   Copyright 2008, Stephan Gross

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: LiedBrowser.java,v 1.7 2009/10/06 20:31:45 sgrossnw Exp $
 */
package de.evjnw.jlk;

import org.apache.log4j.Logger;

import de.evjnw.jlk.ui.Frame;
import de.evjnw.jlk.work.Controller;
import de.evjnw.jlk.work.Visualizer.InfoType;
import de.evjnw.jlk.work.dao.DaoConfigurationException;
import de.evjnw.jlk.work.dao.DaoFactory;
import de.evjnw.jlk.work.impl.DaoFactoryImpl;


/**
 * This class is the entry point to the JLK application
 * 
 * @author Stephan
 */
public class LiedBrowser {

	private static final Logger log = Logger.getLogger(LiedBrowser.class);
	
	private Frame frame;
	private Controller controller;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("JLK Lied Browser startet");
		LiedBrowser lb = new LiedBrowser();
        try {
			lb.connectModules();
			lb.presentUI();
        } catch (DaoConfigurationException dce) {
        	lb.frame.presentInformation("Datenzugriffs-Fehler", "Die Konfiguration des Daten-Zugriffs enthält einen Fehler:\n"+dce.getMessage(), InfoType.ERROR);
        	System.exit(-1);
        }
	}

	/**
	 * Aktiviert das UI und wartet auf Eingaben des Benutzers.
	 */
	private void presentUI() {
		frame.buildUI();
		frame.presentUI();
	}

	/**
	 * Initialisiert die einzelnen Module. 
	 */
	void connectModules() {
		// TODO hier koennte Spring eingesetzt werden
		frame = new Frame();
		controller = new Controller();
		frame.setPerformer(controller);
		controller.setVisualizer(frame);
		
		DaoFactory df = new DaoFactoryImpl("foo", "bar");
		controller.setDaoFactory(df);
	}

}
