/* 
   JLK - Java Lieder Katalog
   Copyright 2008-2009, Stephan Gross

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: Controller.java,v 1.3 2009/09/04 21:11:35 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

import org.apache.log4j.Logger;

import de.evjnw.jlk.work.dao.DaoFactory;
import de.evjnw.jlk.work.impl.DaoFactoryImpl;

/**
 * Diese Klasse ist die Steuerzentrale der Anwendung. 
 * @author Stephan
 */
public class Controller implements Performer {

	private static Logger log = Logger.getLogger(Performer.class);
	
	/** 
	 * dient zum Anzeigen des Zustands;
	 * wird &uuml;ber ge&auml;nderte Daten informiert.
	 */
	private Visualizer visualizer;

	/**
	 * die DAO Factory bietet den Zugriff auf die Datenhaltung
	 */
	private DaoFactory daoFactory;
	
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
		if (log.isInfoEnabled()) {
			log.info("verb:"+command.getVerb());
		}
		if ("quit".equals(command.getVerb())) {
			QuitAction action = new QuitAction();
			action.setHandle((DaoFactoryImpl)daoFactory);
			action.perform(command);
		}
	}

	/**
	 * @param daoFactory the daoFactory to set
	 */
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * @return the daoFactory
	 */
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
	
}
