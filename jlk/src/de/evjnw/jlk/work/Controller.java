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

   $Id: Controller.java,v 1.4 2009/10/06 20:26:49 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

import org.apache.log4j.Logger;

import de.evjnw.jlk.work.Visualizer.InfoType;
import de.evjnw.jlk.work.dao.DaoConfigurationException;
import de.evjnw.jlk.work.dao.DaoException;
import de.evjnw.jlk.work.dao.DaoFactory;
import de.evjnw.jlk.work.impl.DaoFactoryImpl;

/**
 * Diese Klasse ist die Steuerzentrale der Anwendung. 
 * @author Stephan
 */
public class Controller implements Performer {

	private static Logger LOG = Logger.getLogger(Performer.class);
	
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
	
	/**
	 * @see de.evjnw.jlk.work.Performer#perform(de.evjnw.jlk.work.UiCommand)
	 */
	public void perform(UiCommand command) {
		if (command == null) {
			throw new IllegalArgumentException("command must not be null");
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("verb:"+command.getVerb());
		}
		try {
			if ("quit".equals(command.getVerb())) {
				QuitAction action = new QuitAction();
				action.setHandle((DaoFactoryImpl)daoFactory);
				action.perform(command);
			}
			// TODO tu was
		} catch (DaoConfigurationException dce) {
			LOG.fatal(dce.getMessage(), dce);
			visualizer.presentInformation("Datenzugriffs-Fehler", "Die Konfiguration des Daten-Zugriffs enthält einen Fehler:\n"+dce.getMessage()+"\nSie sollten die Anwendung schnell beenden.", InfoType.ERROR);
		} catch (DaoException de) {
			LOG.error(de.getMessage(), de);
			visualizer.presentInformation("Datenzugriffs-Fehler", "Beim Zugriff auf die Daten ist ein Fehler aufgetreten: "+de.getMessage(), InfoType.ERROR);
		}
	}

}
