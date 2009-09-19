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

   $Id: Frame.java,v 1.9 2009/09/19 13:45:07 sgrossnw Exp $
 */
package de.evjnw.jlk.ui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import de.evjnw.jlk.data.DataModell;
import de.evjnw.jlk.work.Performer;
import de.evjnw.jlk.work.UiCommand;
import de.evjnw.jlk.work.Visualizer;
import de.evjnw.jlk.work.Visualizer.InfoType;
import de.evjnw.jlk.work.dao.DaoException;

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
	 * Dieser Listener horcht auf die Events des Hauptfensters (appFrame).
	 */
	private class FrameListener extends WindowAdapter {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void windowClosing(WindowEvent e) {
			userWantsToQuit();
		}
	}

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

		// verwendet denselben Handler wie bei Datei > Beenden, ggf. abfragen
		appFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		appFrame.addWindowListener(new FrameListener());
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
		if (choices.size() == 0) {
			LOG.error("askUser was called without choices");
			return null;
		}
		UserChoice result = null;
		if (choices.size() == 1) {
			if (choices.contains(UserChoice.OK)) {
				JOptionPane.showMessageDialog(appFrame, message, title, JOptionPane.QUESTION_MESSAGE);
				result = UserChoice.OK;
			} else {
				// TODO: alternativen Button-Text bestimmen
			}
			// TODO: confirmation dialog
		}
		if (choices.size() == 2) {
			// TODO: Yes/No dialog
		}
		if (choices.size() == 3) {
			// TODO: Yes/No/Cancel dialog
		}
		if (choices.size() > 3) {
			LOG.error("askUser was called with more than 3 options");
			// könnte per JDialog-Subklasse aufwändig implementiert werden, bleibt jetzt offen
			result = null;
		}
		return result;
	}

	/**
	 * @see de.evjnw.jlk.work.Visualizer#presentInformation(java.lang.String, java.lang.String, de.evjnw.jlk.work.Visualizer.InfoType)
	 */
	public void presentInformation(String title, String message, InfoType type) {
		int messageType;
		switch (type) {
		case INFORMATION:
			messageType = JOptionPane.INFORMATION_MESSAGE;
			break;
		case WARNING:
			messageType = JOptionPane.WARNING_MESSAGE;
			break;
		case ERROR:
			messageType = JOptionPane.ERROR_MESSAGE;
			break;
		default:
			// der Parameter type kann keinen anderen Wert annehmen
			messageType = JOptionPane.ERROR_MESSAGE;
			break;
		}
		JOptionPane.showMessageDialog(appFrame, message, title, messageType);
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
		try {
			if ("Beenden".equals(e.getActionCommand())) {
				userWantsToQuit();
			}
			if ("Info".equals(e.getActionCommand())) {
				presentInformation("Info", "JLK - Java Liede Katalog\nvon Mario Aldag und Stephan Groß\nhttp://developer.berlios.de/projects/jlk/\ndie Nutzung der Software unterliegt der Apache License v2.0", InfoType.INFORMATION);
			}
//			if ("Neu".equals(e.getActionCommand())) {
//				throw new DaoException("es gibt noch keine Implementierung für neue Datensätze");
//			}
			// TODO: die anderen Menü-Einträge 
			
		} catch (RuntimeException re) {
			LOG.error(re.getMessage(), re);
			presentInformation("Interner Fehler", "Bei der Verarbeitung ist ein interner Fehler aufgetreten: "+re.getMessage(), InfoType.ERROR);
		}
	}

	/**
	 * Diese Methode bündelt die Aktionen wenn der Benutzer die Anwendung beenden will.
	 */
	private void userWantsToQuit() {
		LOG.info("AppFrame is closing");
		// TODO ermitteln, ob AppFrame das letzte angezeigte Fenster ist
		// TODO ermitteln, ob lang laufende Hintergrundaktion läuft
		// TODO ermitteln, ob Eingaben verloren gehen können
		// TODO Sicherheitsabfrage
		UiCommand command = new UiCommand();
		command.setVerb("quit");
		getPerformer().perform(command);
		appFrame.setVisible(false);
		appFrame.dispose();
	}

}
