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

   $Id: FrameMenu.java,v 1.4 2009/09/04 21:21:28 sgrossnw Exp $
 */
package de.evjnw.jlk.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;

/**
 * Diese Klasse bildet die Men&uuml;struktur der Anwendung. 
 * @author Stephan
 */
@SuppressWarnings("serial")
public class FrameMenu extends JMenuBar {

	private static final String SEP = "<<>>";
	
	static final Logger LOG = Logger.getLogger(FrameMenu.class);
	
	private JMenu fileMenu = new JMenu("Datei");
	private JMenu editMenu= new JMenu("Bearbeiten");
	private JMenu extraMenu= new JMenu("Extras");
	private JMenu helpMenu = new JMenu("Hilfe");

	/**
	 * Im ctor werden die Unterelemente aufgebaut.
	 * @deprecated über diesen ctor stoßen die Menüeinträge keine Aktionen an 
	 */
	public FrameMenu() {
		this(new MenuDebugListener());
	}
	
	/**
	 * Im ctor werden die Unterelemente aufgebaut. 
	 * @param menuLister wird für die Menü-Einträge registriert
	 */
	public FrameMenu(ActionListener menuListener) {
		String[] fileItems = new String[] { "Neu", SEP, "DB verbinden",
				"DB trennen", SEP, "Exportieren", "Synchronisieren", SEP,
				"Beenden" };
		addItemsToMenu(menuListener, fileItems, fileMenu);
		String[] editItems = new String[] { "Ausschneiden", "Kopieren",
				"Einf\u00fcgen", "L\u00f6schen" };
		addItemsToMenu(menuListener, editItems, editMenu);
		String[] extraItems = new String[] { "Suchen", SEP, "Einstellungen" };
		addItemsToMenu(menuListener, extraItems, extraMenu);
		String[] helpItems = new String[] { "Info" };
		addItemsToMenu(menuListener, helpItems, helpMenu);

		add(fileMenu);
		add(editMenu);
		add(extraMenu);
		add(helpMenu);
	}

	/**
	 * Baut die Men&uuml;struktur auf. 
	 * TODO: Die Eintr&auml;ge sind zun&auml;chst nur Platzhalter. 
	 * Wenn die aufgerufenen Aktionen implementiert sind, wird 
	 * das Menue anders aufgebaut. 
	 * @param listener wird über die Auswahl in den Menüs benachrichtigt
	 * @param fileItems
	 * @param menu
	 */
	private void addItemsToMenu(ActionListener listener, String[] fileItems, JMenu menu) {
		int idx = 0; // Index der Menue-Eintraege, fuer Separatoren
		for (String item : fileItems) {
			if (SEP.equals(item)) {
				menu.insertSeparator(idx++);
				continue;
			}
			JMenuItem menuItem = new JMenuItem(item);
			menuItem.addActionListener(listener);
			menu.add(menuItem);
			idx++;
		}
	}
	
	/**
	 * Horcht auf die Aktivierung der Men&uuml;eintr&auml;ge.
	 * Demo-Implementierung zum Debuggen. 
	 */
	private static class MenuDebugListener implements ActionListener {
	
		/**
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if (FrameMenu.LOG.isDebugEnabled()) {
				FrameMenu.LOG.debug("Menu Item selected!; "
				/* "ID:"+e.getID()+ */
				+ ", Command:" + e.getActionCommand()
				/* +", Source:"+e.getSource() */
				);
	
			}
		}
	}

}
