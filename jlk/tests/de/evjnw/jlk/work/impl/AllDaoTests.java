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

   $Id: AllDaoTests.java,v 1.2 2009/08/14 22:07:37 sgrossnw Exp $
 */
package de.evjnw.jlk.work.impl;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllDaoTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for DAO in de.evjnw.jlk.work.impl");
		//$JUnit-BEGIN$
//		suite.addTestSuite(SucheDaoImplTest.class);
		suite.addTestSuite(LiedDaoImplTest.class);
//		suite.addTestSuite(AnhangDaoImplTest.class);
		suite.addTestSuite(BenutzerDaoImplTest.class);
		//$JUnit-END$
		return suite;
	}

}
