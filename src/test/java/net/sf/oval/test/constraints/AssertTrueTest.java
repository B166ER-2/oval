/*********************************************************************
 * Copyright 2005-2020 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.test.constraints;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import net.sf.oval.constraint.AssertTrueCheck;

/**
 * @author Sebastian Thomschke
 */
public class AssertTrueTest extends AbstractContraintsTest {

   @Test
   public void testAssertTrue() {
      final AssertTrueCheck check = new AssertTrueCheck();
      super.testCheck(check);
      assertThat(check.isSatisfied(null, null, null, null)).isTrue();

      assertThat(check.isSatisfied(null, true, null, null)).isTrue();
      assertThat(check.isSatisfied(null, false, null, null)).isFalse();
      assertThat(check.isSatisfied(null, Boolean.TRUE, null, null)).isTrue();
      assertThat(check.isSatisfied(null, Boolean.FALSE, null, null)).isFalse();
      assertThat(check.isSatisfied(null, "true", null, null)).isTrue();
      assertThat(check.isSatisfied(null, "bla", null, null)).isFalse();
   }
}
