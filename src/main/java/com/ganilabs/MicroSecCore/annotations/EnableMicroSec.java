package com.ganilabs.MicroSecCore.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableAspectJAutoProxy
public @interface EnableMicroSec {
}
