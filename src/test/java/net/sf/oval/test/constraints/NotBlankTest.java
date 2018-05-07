/*********************************************************************
 * Copyright 2005-2018 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.test.constraints;

import net.sf.oval.constraint.NotBlankCheck;

/**
 * @author Sebastian Thomschke
 */
public class NotBlankTest extends AbstractContraintsTest {
    public void testNotBlank() {
        final NotBlankCheck check = new NotBlankCheck();
        super.testCheck(check);
        assertTrue(check.isSatisfied(null, null, null, null));

        assertTrue(check.isSatisfied(null, "bla", null, null));
        assertTrue(check.isSatisfied(null, true, null, null));
        assertTrue(check.isSatisfied(null, 1, null, null));
        assertFalse(check.isSatisfied(null, "", null, null));
        assertFalse(check.isSatisfied(null, ' ', null, null));
        assertFalse(check.isSatisfied(null, " ", null, null));
        assertFalse(check.isSatisfied(null, "                  ", null, null));
    }
}
