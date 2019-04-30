/*********************************************************************
 * Copyright 2005-2019 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.exception;

import net.sf.oval.internal.MessageRenderer;

/**
 * @author Sebastian Thomschke
 */
public class ConstraintSetAlreadyDefinedException extends InvalidConfigurationException {
   private static final long serialVersionUID = 1L;

   public ConstraintSetAlreadyDefinedException(final String contraintSetId) {
      super(MessageRenderer.renderMessage("net.sf.oval.exception.ConstraintSetAlreadyDefinedException.message", "contraintSetId", contraintSetId));
   }
}
