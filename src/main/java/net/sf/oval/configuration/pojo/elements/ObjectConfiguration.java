/*********************************************************************
 * Copyright 2005-2018 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.configuration.pojo.elements;

import java.util.List;

import net.sf.oval.Check;

/**
 * @author Sebastian Thomschke
 */
public class ObjectConfiguration extends ConfigurationElement {
   private static final long serialVersionUID = 1L;

   /**
    * object level checks
    */
   public List<Check> checks;
}
