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

   $Id: AllTests.java,v 1.2 2008/12/09 09:26:11 ma08 Exp $
 */
package de.evjnw.jlk;

import junit.framework.Test;
import junit.framework.TestSuite;
import de.evjnw.jlk.data.LiedTest;

/**
 * Diese Test-Suite ruft alle UnitTests auf.  
 * 
 * @author Stephan
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for de.evjnw.jlk");
		//$JUnit-BEGIN$
		suite.addTestSuite(LiedBrowserTest.class);
		
		suite.addTestSuite(LiedTest.class);
		//$JUnit-END$
		return suite;
	}

}
