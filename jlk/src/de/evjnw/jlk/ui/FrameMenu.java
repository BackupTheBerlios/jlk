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

   $Id: FrameMenu.java,v 1.2 2008/12/16 15:57:39 ma08 Exp $
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
	
	private static Logger log = Logger.getLogger(FrameMenu.class);
	
	private JMenu fileMenu = new JMenu("Datei");
	private JMenu editMenu= new JMenu("Bearbeiten");
	private JMenu extraMenu= new JMenu("Extras");
	private JMenu helpMenu = new JMenu("Hilfe");

	/**
	 * Im ctor werden die Unterelemente aufgebaut. 
	 */
	public FrameMenu() {
		MenuDebugListener cl = new MenuDebugListener();
		String[] fileItems = new String[] { "Neu", SEP, "DB verbinden",
				"DB trennen", SEP, "Exportieren", "Synchronisieren", SEP,
				"Beenden" };
		addItemsToMenu(cl, fileItems, fileMenu);
		String[] editItems = new String[] { "Ausschneiden", "Kopieren",
				"Einf\u00fcgen", "L\u00f6schen" };
		addItemsToMenu(cl, editItems, editMenu);
		String[] extraItems = new String[] { "Suchen", SEP, "Einstellungen" };
		addItemsToMenu(cl, extraItems, extraMenu);
		String[] helpItems = new String[] { "Info" };
		addItemsToMenu(cl, helpItems, helpMenu);

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
	 * @param cl
	 * @param fileItems
	 * @param menu
	 */
	private void addItemsToMenu(MenuDebugListener cl, String[] fileItems, JMenu menu) {
		int idx = 0; // Index der Menue-Eintraege, fuer Separatoren
		for (String item : fileItems) {
			if (SEP.equals(item)) {
				menu.insertSeparator(idx++);
				continue;
			}
			JMenuItem menuItem = new JMenuItem(item);
			menuItem.addActionListener(cl);
			menu.add(menuItem);
			idx++;
		}
	}
	
	/**
	 * Horcht auf die Aktivierung der Men&uuml;eintr&auml;ge.
	 * Demo-Implementierung zum Debuggen. 
	 */
	private class MenuDebugListener implements ActionListener {

		/**
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if (log.isDebugEnabled()) {
				log.debug("Menu Item selected!; "
				/* "ID:"+e.getID()+ */
				+ ", Command:" + e.getActionCommand()
				/* +", Source:"+e.getSource() */
				);

			}
		}
	}
}
