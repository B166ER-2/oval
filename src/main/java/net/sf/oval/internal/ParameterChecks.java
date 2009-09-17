/********************************import java.util.Set;

import net.sf.oval.Check;
import net.sf.oval.CheckExclusion;
import net.sf.oval.internal.util.LinkedSet;
 Thomschke.
 * 
 * All Rights Reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sebastian Thomschke - initial implementation.
 *******************************************************************************/
package net.sf.oval.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

import net.sf.oval.Check;
import net.sf.oval.CheckExclusion;
import net.sf.oval.context.ConstructorParameterContext;
import net.sf.oval.context.MethodParameterContext;
import net.sf.oval.context.OValContext;
import net.sf.oval.internal.util.LinkedSet;

/**
 * @author Sebastian Thomschke
 */
public class ParameterChecks
{
	public final Set<Check> checks = new LinkedSet<Check>(2);
	public final Set<CheckExclusion> checkExclusions = new LinkedSet<CheckExclusion>(2);

	public final int parameterIndex;

	public final OValContext context;

	public ParameterChecks(Constructor< ? > ctor, int paramIndex)
	{
		//TODO
		context = new ConstructorParameterContext(ctor, paramIndex, "TODO");
		this.parameterIndex = paramIndex;
	}

	public ParameterChecks(Method method, int paramIndex)
	{
		//TODO
		context = new MethodParameterContext(method, paramIndex, "TODO");
		this.parameterIndex = paramIndex;
	}

	public boolean hasChecks()
	{
		return checks.size() > 0;
	}

	public boolean hasExclusions()
	{
		return checkExclusions.size() > 0;
	}

	public boolean isEmpty()
	{
		return checks.size() == 0 && checkExclusions.size() == 0;
	}
}
