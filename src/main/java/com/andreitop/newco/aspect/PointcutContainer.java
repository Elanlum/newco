package com.andreitop.newco.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutContainer {

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.find*())")
    public void repositoryFind() {
    }

    @Pointcut("execution(* com.andreitop.newco.repository.*Repo*.*save*())")
    public void repositorySave() {
    }

    @Pointcut("execution (* com.andreitop.newco.repository.*Repo*.*delete*())")
    public void repositoryDelete() {
    }
}
