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

   $Id: Controller.java,v 1.1 2008/12/01 18:50:00 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

import org.apache.log4j.Logger;

/**
 * Diese Klasse ist die Steuerzentrale der Anwendung. 
 * @author Stephan
 */
public class Controller implements Performer {

	private static Logger log = Logger.getLogger(Performer.class);
	
	/** 
	 * dient zum Anzeigen des Zustands;
	 * wird &uuml;ber ge&auml;nderte Daten informiert
	 */
	private Visualizer visualizer;

	/**
	 * @return the visualizer
	 */
	public Visualizer getVisualizer() {
		return visualizer;
	}

	/**
	 * @param visualizer the visualizer to set
	 */
	public void setVisualizer(Visualizer visualizer) {
		this.visualizer = visualizer;
	}

	/**
	 * @see de.evjnw.jlk.work.Performer#perform(de.evjnw.jlk.work.UiCommand)
	 */
	public void perform(UiCommand command) {
		if (command == null) {
			throw new IllegalArgumentException("command must not be null");
		}
		// TODO tu was
		log.info("verb:"+command.getVerb());
	}
	
	
}
