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

import net.sf.oval.constraint.InstanceOfAnyCheck;

/**
 * @author Sebastian Thomschke
 */
public class InstanceOfAnyTest extends AbstractContraintsTest {
   public static class ClassA implements InterfaceA {
      //
   }

   public static class ClassB implements InterfaceA, InterfaceB {
      //
   }

   public interface InterfaceA {
      //
   }

   public interface InterfaceB {
      //
   }

   @Test
   public void testInstanceOf() {
      final InstanceOfAnyCheck check = new InstanceOfAnyCheck();
      super.testCheck(check);
      assertThat(check.isSatisfied(null, null, null, null)).isTrue();

      check.setTypes(InterfaceA.class);
      assertThat(check.getTypes()[0]).isEqualTo(InterfaceA.class);

      assertThat(check.isSatisfied(null, new ClassA(), null, null)).isTrue();
      assertThat(check.isSatisfied(null, new ClassB(), null, null)).isTrue();
      assertThat(check.isSatisfied(null, "bla", null, null)).isFalse();

      check.setTypes(InterfaceA.class, InterfaceB.class);
      assertThat(check.getTypes()[0]).isEqualTo(InterfaceA.class);
      assertThat(check.getTypes()[1]).isEqualTo(InterfaceB.class);

      assertThat(check.isSatisfied(null, new ClassA(), null, null)).isTrue();
      assertThat(check.isSatisfied(null, new ClassB(), null, null)).isTrue();
      assertThat(check.isSatisfied(null, "bla", null, null)).isFalse();
   }
}
