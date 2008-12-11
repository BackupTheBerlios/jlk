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

   $Id: Frame.java,v 1.2 2008/12/11 09:43:16 sgrossnw Exp $
 */
package de.evjnw.jlk.ui;

import javax.swing.JFrame;

import de.evjnw.jlk.work.Performer;
import de.evjnw.jlk.work.Visualizer;

/**
 * Diese Klasse steuert die Oberfl&auml;che der Anwendung.
 * Sie baut die UI Elemente auf und leitet Aktionen an den 
 * {@link Performer} weiter.
 * @author Stephan
 */
public class Frame implements Visualizer {

	/** 
	 * die Ausf&uuml;hrung der Logik wird an diese Klasse delegiert.
	 */
	private Performer performer;

	/** 
	 * die Hauptstruktur der Oberfl&auml;che
	 */
	private JFrame appFrame; 
	
	/**
	 * @param performer the performer to set
	 */
	public void setPerformer(Performer performer) {
		this.performer = performer;
	}

	/**
	 * @return the performer
	 */
	public Performer getPerformer() {
		return performer;
	}

	/**
	 * Startet die GUI und die Verarbeitung von Eingaben.
	 */
	public void presentUI() {
		appFrame.pack();
		appFrame.setVisible(true);
		
	}

	/**
	 * Baut die Struktur der GUI auf.
	 */
	public void buildUI() {
		appFrame = new JFrame("JLK");
		// TODO: selben Handler wie bei Datei > Beenden, ggf. abfragen
		appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		appFrame.setJMenuBar(new FrameMenu());
	}
	
}
