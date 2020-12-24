/*********************************************************************
 * Copyright 2005-2020 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.internal.util;

import java.util.Collection;
import java.util.List;

import net.sf.oval.Validator;

/**
 * @author Sebastian Thomschke
 */
public final class StringUtils {

   public static String implode(final Collection<?> values, final String delimiter) {
      return implode(values.toArray(), delimiter);
   }

   public static String implode(final Object[] values, final String delimiter) {
      if (values == null)
         return "";

      final StringBuilder out = new StringBuilder();

      for (int i = 0, l = values.length; i < l; i++) {
         if (i > 0) {
            out.append(delimiter);
         }
         out.append(values[i]);
      }
      return out.toString();
   }

   /**
    * high-performance case-sensitive string replacement
    */
   public static String replaceAll(final String searchIn, final String searchFor, final String replaceWith) {
      final StringBuilder out = new StringBuilder();

      int searchFrom = 0, foundAt = 0;
      final int searchForLength = searchFor.length();

      while ((foundAt = searchIn.indexOf(searchFor, searchFrom)) >= 0) {
         out.append(searchIn.substring(searchFrom, foundAt)).append(replaceWith);
         searchFrom = foundAt + searchForLength;
      }

      return out.append(searchIn.substring(searchFrom, searchIn.length())).toString();
   }

   public static List<String> split(final String str, final char separator, final int maxParts) {
      final List<String> result = Validator.getCollectionFactory().createList();
      int startAt = 0;
      while (true) {
         final int foundAt = str.indexOf(separator, startAt);
         if (foundAt == -1 || result.size() == maxParts - 1) {
            result.add(str.substring(startAt, str.length()));
            break;
         }
         result.add(str.substring(startAt, foundAt));
         startAt = foundAt + 1;
      }
      return result;
   }

   private StringUtils() {
   }
}
