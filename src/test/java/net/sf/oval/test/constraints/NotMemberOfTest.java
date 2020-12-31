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

import net.sf.oval.constraint.NotMemberOfCheck;

/**
 * @author Sebastian Thomschke
 */
public class NotMemberOfTest extends AbstractContraintsTest {

   @Test
   public void testNotMemberOf() {
      final NotMemberOfCheck check = new NotMemberOfCheck();
      super.testCheck(check);
      assertThat(check.isSatisfied(null, null, null)).isTrue();

      check.setMembers("10", "false", "TRUE");
      check.setIgnoreCase(false);
      assertThat(check.isSatisfied(null, 10, null)).isFalse();
      assertThat(check.isSatisfied(null, "10", null)).isFalse();
      assertThat(check.isSatisfied(null, 10.0, null)).isTrue();
      assertThat(check.isSatisfied(null, "false", null)).isFalse();
      assertThat(check.isSatisfied(null, false, null)).isFalse();
      assertThat(check.isSatisfied(null, "TRUE", null)).isFalse();
      assertThat(check.isSatisfied(null, true, null)).isTrue();

      check.setIgnoreCase(true);
      assertThat(check.isSatisfied(null, "FALSE", null)).isFalse();
      assertThat(check.isSatisfied(null, false, null)).isFalse();
      assertThat(check.isSatisfied(null, "true", null)).isFalse();
      assertThat(check.isSatisfied(null, true, null)).isFalse();
   }
}
