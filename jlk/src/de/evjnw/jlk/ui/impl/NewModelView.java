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

   $Id: NewModelView.java,v 1.3 2009/12/16 11:09:37 sgrossnw Exp $
 */
package de.evjnw.jlk.ui.impl;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import de.evjnw.jlk.data.DataModell;
import de.evjnw.jlk.ui.View;
import de.evjnw.jlk.work.Performer;
import de.evjnw.jlk.work.Visualizer;
import de.evjnw.jlk.work.Visualizer.InfoType;

/** 
 * Dieser View zeigt die Eingabemaske für neue Datenobjekte an.
 * @author Stephan Groß
 */
public class NewModelView implements View, ActionListener {

	private static final Logger LOG = Logger.getLogger(NewModelView.class);
	
	private JPanel actionPane;
	private JPanel detailPane;
	private Visualizer visualizer;
	private Performer performer;
		
	private JTextField nameField = new JTextField(16);
	private JRadioButton liedRadio = new JRadioButton("Lied");
	private JRadioButton materialRadio = new JRadioButton("Material");
	
	/** {@inheritDoc} */
	public void display(String verb, List<DataModell> models, List<Object> data) {
		this.LOG.info("Verb:"+verb);
		// wir arbeiten nur auf einem Verb und erwarten keine Modelle und keine Daten
		detailPane.removeAll();
		JPanel myAction = new JPanel();
		
		myAction.setLayout(new BoxLayout(myAction, BoxLayout.Y_AXIS));
		JLabel titleLabel = new JLabel("Neu");
		titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		myAction.add(titleLabel);

		JPanel textPane = new JPanel();
		textPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		textPane.setLayout(new BoxLayout(textPane, BoxLayout.X_AXIS));
		JLabel nameLabel = new JLabel("Name");
		textPane.add(nameLabel);
		nameField.setText("");
		textPane.add(nameField);
		nameLabel.setLabelFor(nameField);
		myAction.add(textPane);
		
		ButtonGroup typeGroup = new ButtonGroup();
		typeGroup.add(liedRadio);
		myAction.add(liedRadio);
		typeGroup.add(materialRadio);
		myAction.add(materialRadio);
		
		JButton createButton = new JButton("Anlegen");
		createButton.addActionListener(this);
		myAction.add(createButton);
		
		actionPane.removeAll();
		actionPane.add(myAction);
		actionPane.revalidate();
	}

	/** {@inheritDoc} */
	public void init(JPanel actionPane, JPanel detailPane, Visualizer visualizer, Performer performer) {
		this.actionPane = actionPane;
		this.detailPane = detailPane;
		this.visualizer = visualizer;
		this.performer = performer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		visualizer.presentInformation("Aktion", "Anlegen wurde gedrückt", InfoType.INFORMATION);
		// TODO: die Eingaben weiter verarbeiten
	}

}
