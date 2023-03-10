package org.asaezc.apiservlet.webapp.cdi.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;
import org.asaezc.apiservlet.webapp.cdi.interceptors.Logging;
import org.asaezc.apiservlet.webapp.cdi.interceptors.TransactionalJdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TransactionalJdbc
@Logging
@ApplicationScoped
@Stereotype
@Named
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
