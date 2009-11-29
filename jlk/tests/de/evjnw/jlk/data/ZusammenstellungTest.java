/* 
   JLK - Java Lieder Katalog
   Copyright 2009, Mario Aldag

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: ZusammenstellungTest.java,v 1.3 2009/11/29 14:04:20 ma08 Exp $
 */
/*
 * Dieser Unittest testet die Properties von Zusammenstellung.java mit Zugriff auf die Liste Anhang
 * 
 */
package de.evjnw.jlk.data;

import junit.framework.TestCase;

public class ZusammenstellungTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testZusammenstellungBasic(){
		Zusammenstellung zs=new Zusammenstellung();
		zs.setTitel("Testtitel1");
		zs.setBeschreibung("Beschreibung");
		assertNotNull("Titel konnte nicht gelesen werden",zs.getTitel());
		assertNotNull("Beschreibung konnte nicht gelesen werden",zs.getBeschreibung());
	}
	public void testZusammenstellung() {
		Zusammenstellung zs=new Zusammenstellung();
		Anhang anhang=new Anhang();
		anhang.setAkkordart("Test1");
		zs.addAnhang(anhang);
		assertNotNull("Hat keine Anhangsliste",zs.getAnhang());
	}

	public void testAddAnhang() {
		Zusammenstellung zs=new Zusammenstellung();
		zs.setBeschreibung("Test1");
		zs.setTitel("Titeltest");
		Anhang ang=new Anhang();
		ang.setAkkordart("DMoll");
		zs.addAnhang(ang);
	}
	public void testReadAnhang() {
		Zusammenstellung zs=new Zusammenstellung();
		assertNotNull("Anhänge konnten nicht gelesen werden.", zs.getAnhang());
	}
}
