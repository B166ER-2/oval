/*********************************************************************
 * Copyright 2005-2019 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.test.constraints;

import net.sf.oval.constraint.MinLengthCheck;

/**
 * @author Sebastian Thomschke
 */
public class MinLengthTest extends AbstractContraintsTest {
   public void testMinLength() {
      final MinLengthCheck check = new MinLengthCheck();
      super.testCheck(check);
      assertTrue(check.isSatisfied(null, null, null, null));

      check.setMin(3);
      assertEquals(3, check.getMin());

      assertTrue(check.isSatisfied(null, "1234", null, null));
      assertFalse(check.isSatisfied(null, "12", null, null));
      assertFalse(check.isSatisfied(null, "", null, null));
   }
}
