/*********************************************************************
 * Copyright 2005-2019 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.localization.value;

/**
 * @author Sebastian Thomschke
 */
public interface MessageValueFormatter {
   /**
    * @return a string representation of the given value object
    */
   String format(Object value);
}
