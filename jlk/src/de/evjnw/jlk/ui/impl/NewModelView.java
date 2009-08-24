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

   $Id: NewModelView.java,v 1.2 2009/08/24 20:17:38 sgrossnw Exp $
 */
package de.evjnw.jlk.ui.impl;

import java.util.List;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import de.evjnw.jlk.data.DataModell;
import de.evjnw.jlk.ui.View;

/** 
 * Dieser View zeigt die Eingabemaske für neue Datenobjekte an.
 * @author Stephan Groß
 *
 */
public class NewModelView implements View {

	private static final Logger LOG = Logger.getLogger(NewModelView.class);
	
	private JPanel actionPane;
	private JPanel detailPane;
	
	/** {@inheritDoc} */
	public void display(String verb, List<DataModell> models, List<Object> data) {
		// TODO Auto-generated method stub
		this.LOG.info("Verb:"+verb);
	}

	/** {@inheritDoc} */
	public void init(JPanel actionPane, JPanel detailPane) {
		this.actionPane = actionPane;
		this.detailPane = detailPane;
	}

}
