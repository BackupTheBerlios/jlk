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

   $Id: Frame.java,v 1.7 2009/08/24 20:18:43 sgrossnw Exp $
 */
package de.evjnw.jlk.ui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import de.evjnw.jlk.data.DataModell;
import de.evjnw.jlk.work.Performer;
import de.evjnw.jlk.work.Visualizer;

/**
 * Diese Klasse steuert die Oberfl&auml;che der Anwendung.
 * Sie baut die UI Elemente auf und leitet Aktionen an den 
 * {@link Performer} weiter.
 * @author Stephan
 */
public class Frame implements Visualizer, ActionListener {

	private static final Logger LOG = Logger.getLogger(Frame.class);
	
	/**
	 * Der Titel des Anwendungsfensters.
	 */
	private static final String FRAME_TITLE = "JLK";

	/** 
	 * die Ausf&uuml;hrung der Logik wird an diese Klasse delegiert.
	 */
	private Performer performer;

	/** 
	 * die Hauptstruktur der Oberfl&auml;che
	 */
	private JFrame appFrame; 
	
	/** 
	 * in diesem Panel sind die Benutzer-Aktionen m&ouml;glich
	 */
	private final JPanel actionPane = new JPanel();
	
	/**
	 * in diesem Panel werden die Daten ausgegeben 
	 */
	private final JPanel detailPane = new JPanel();
	
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
		appFrame = new JFrame(FRAME_TITLE);
		
		final Container contentPane = appFrame.getContentPane();
		
		contentPane.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		// Insets sorgen fuer eine Einrueckung des Panels
		gbc.insets = new Insets(8, 8, 8, 8); // tlbr
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(actionPane, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0; 
		contentPane.add(detailPane, gbc);
		
		// diese kuenstlichen Komponenten definieren eine Mindestbreite 
		// und Mindesthoehe der anfangs leeren ActionPane und DetailPane
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 8, 0, 8);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(Box.createHorizontalStrut(200), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		contentPane.add(Box.createHorizontalStrut(300), gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.insets = new Insets(8, 0, 8, 0);
		gbc.fill = GridBagConstraints.VERTICAL;
		contentPane.add(Box.createVerticalStrut(300), gbc);

		
		
		// TODO: selben Handler wie bei Datei > Beenden, ggf. abfragen
		appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		appFrame.setJMenuBar(new FrameMenu(this));
	}

	/**
	 * @return the actionPane
	 */
	public JPanel getActionPane() {
		return actionPane;
	}

	/**
	 * @return the detailPane
	 */
	public JPanel getDetailPane() {
		return detailPane;
	}

	/**
	 * @see de.evjnw.jlk.work.Visualizer#askUser(java.lang.String, java.lang.String, java.util.Set)
	 */
	public UserChoice askUser(String title, String message,
			Set<UserChoice> choices) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see de.evjnw.jlk.work.Visualizer#presentInformation(java.lang.String, java.lang.String, de.evjnw.jlk.work.Visualizer.InfoType)
	 */
	public void presentInformation(String title, String message, InfoType type) {
		// TODO Auto-generated method stub
	}

	/** {@inheritDoc} */
	public void display(String view, List<DataModell> models, List<Object> data) {
		// TODO Auto-generated method stub
		
	}	

	/**
	 * Horcht auf die Aktivierung der Men&uuml;eintr&auml;ge.
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Menu Item selected!; "
			/* "ID:"+e.getID()+ */
			+ ", Command:" + e.getActionCommand()
			/* +", Source:"+e.getSource() */
			);

		}
	}
}
