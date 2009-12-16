/* 
   JLK - Java Lieder Katalog
   Copyright 2009, Stephan Gross

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: View.java,v 1.3 2009/12/16 11:09:08 sgrossnw Exp $
 */
package de.evjnw.jlk.ui;

import java.util.List;

import javax.swing.JPanel;

import de.evjnw.jlk.data.DataModell;
import de.evjnw.jlk.work.Performer;
import de.evjnw.jlk.work.Visualizer;

/**
 * Dieses Interface bildet die gleichf�rmige Schnittstelle f�r alle Formen der Darstellungen.
 * @author Stephan Gro�
 *
 */
public interface View {

	/** Initialisiert den View und �bergibt die nutzbaren Anzeigebereiche.
	 * 
	 * @param actionPane hier sollen die Kontrollelemente (insbesondere Buttons) hinein
	 * @param detailPane der allgemeine Ein-/Ausgabebereich
	 * @param visualizer f�r weitere Darstellungen (Mitteilungen, R�ckfragen, Wechsel des Views)
	 * @param performer f�r Aktionen
	 */
	public void init(JPanel actionPane, JPanel detailPane, Visualizer visualizer, Performer performer);
	
	/**
	 * �bergibt die Objekte zur Anzeige an den konkreten View.
	 * @param verb bietet eine Unterscheidung, was zu tun ist, wenn die gleiche Klasse f�r mehrere Verben genutzt wird
	 * @param models die anzuzeigenden Datenmodelle (optional)
	 * @param data zus�tzliche, anzuzeigende Daten, die nicht persistent sind (optional)
	 */
	public void display(String verb, List<DataModell> models, List<Object> data);
}
