/*********************************************************************
 * Copyright 2005-2020 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.test.validator;

import java.util.List;

import junit.framework.TestCase;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.Assert;

/**
 * @author Sebastian Thomschke
 */
public class AssertOGNLTest extends TestCase {
   @Assert(expr = "_this.firstName!=null && _this.lastName!=null && (_this.firstName.length() + _this.lastName.length() > 9)", lang = "ognl", message = "C0")
   public static class Person {
      @Assert(expr = "_value!=null", lang = "ognl", message = "C1")
      public String firstName;

      @Assert(expr = "_value!=null", lang = "ognl", message = "C2")
      public String lastName;

      @Assert(expr = "_value!=null && _value.length()>0 && _value.length()<7", lang = "ognl", message = "C3")
      public String zipCode;
   }

   public void testOGNLExpression() {
      final Validator validator = new Validator();

      // test not null
      final Person p = new Person();
      List<ConstraintViolation> violations = validator.validate(p);
      assertEquals(violations.size(), 4);

      // test max length
      p.firstName = "Mike";
      p.lastName = "Mahoney";
      p.zipCode = "1234567";
      violations = validator.validate(p);
      assertEquals(violations.size(), 1);
      assertEquals(violations.get(0).getMessage(), "C3");

      // test not empty
      p.zipCode = "";
      violations = validator.validate(p);
      assertEquals(violations.size(), 1);
      assertEquals(violations.get(0).getMessage(), "C3");

      // test ok
      p.zipCode = "wqeew";
      violations = validator.validate(p);
      assertEquals(violations.size(), 0);

      // test object-level constraint
      p.firstName = "12345";
      p.lastName = "1234";
      violations = validator.validate(p);
      assertEquals(violations.size(), 1);
      assertEquals(violations.get(0).getMessage(), "C0");
   }
}
