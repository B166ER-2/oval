/*********************************************************************
 * Copyright 2005-2018 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.integration.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import net.sf.oval.internal.Log;

/**
 * Injects spring beans into unmanaged Java objects having {@link org.springframework.beans.factory.annotation.Autowired},
 * {@link org.springframework.beans.factory.annotation.Value} and {@link javax.inject.Inject} annotations
 * and executes {@link org.springframework.beans.factory.InitializingBean#afterPropertiesSet} and {@link javax.annotation.PostConstruct} callback methods.
 *
 * <pre>
 * &lt;bean class="net.sf.oval.integration.spring.SpringInjector" /&gt;
 * </pre>
 *
 * or
 *
 * <pre>
 * &lt;context:component-scan base-package="net.sf.oval.integration.spring" /&gt;
 * </pre>
 *
 * @author Sebastian Thomschke
 */
@Component
public class SpringInjector {
    private static final Log LOG = Log.getLog(SpringInjector.class);

    private static SpringInjector INSTANCE;

    public static SpringInjector get() {
        Assert.notNull(INSTANCE, "No SpringInjector instance created yet. Add  <bean class=\"" + SpringInjector.class.getName()
                + "\" /> to your spring configuration!");

        return INSTANCE;
    }

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    private SpringInjector() {
        LOG.info("Instantiated.");

        INSTANCE = this;
    }

    /**
     * processes @PostConstruct, InitializingBean#afterPropertiesSet
     */
    public void initialize(final Object unmanagedBean) {
        beanFactory.initializeBean(unmanagedBean, "bean");
    }

    /**
     * processes @Autowired, @Inject
     */
    public void inject(final Object unmanagedBean) {
        beanFactory.autowireBean(unmanagedBean);
    }
}
