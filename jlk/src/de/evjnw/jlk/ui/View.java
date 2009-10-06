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

   $Id: View.java,v 1.2 2009/10/06 20:33:03 sgrossnw Exp $
 */
package de.evjnw.jlk.ui;

import java.util.List;

import javax.swing.JPanel;

import de.evjnw.jlk.data.DataModell;

/**
 * Dieses Interface bildet die gleichförmige Schnittstelle für alle Formen der Darstellungen.
 * @author Stephan Groß
 *
 */
public interface View {

	/** Initialisiert den View und übergibt die nutzbaren Anzeigebereiche.
	 * 
	 * @param actionPane hier sollen die Kontrollelemente (insbesondere Buttons) hinein
	 * @param detailPane der allgemeine Ein-/Ausgabebereich
	 */
	public void init(JPanel actionPane, JPanel detailPane);
	
	/**
	 * Übergibt die Objekte zur Anzeige an den konkreten View.
	 * @param verb bietet eine Unterscheidung, was zu tun ist, wenn die gleiche Klasse für mehrere Verben genutzt wird
	 * @param models die anzuzeigenden Datenmodelle (optional)
	 * @param data zusätzliche, anzuzeigende Daten, die nicht persistent sind (optional)
	 */
	public void display(String verb, List<DataModell> models, List<Object> data);
}
