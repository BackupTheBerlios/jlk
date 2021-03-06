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

   $Id: LiedBrowserTest.java,v 1.2 2008/12/02 17:21:39 sgrossnw Exp $
 */
package de.evjnw.jlk;

import junit.framework.TestCase;

/**
 * This minimalistic unit test is needed by the build script.
 * It should test the correct setup of the application.  
 * 
 * @author Stephan
 */
public class LiedBrowserTest extends TestCase {

	/** component under test */
	private LiedBrowser component;
	
	protected void setUp() throws Exception {
		component = new LiedBrowser();
	}

	/** 
	 * testet die 'connectModules()' Methode, ob die Verbindungen zwischen 
	 * den Systemteilen hergestellt werden koennen
	 */
	public void testConnectModules() {
		component.connectModules();
	}
}
