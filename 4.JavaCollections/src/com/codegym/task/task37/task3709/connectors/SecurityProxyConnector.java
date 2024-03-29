package com.codegym.task.task37.task3709.connectors;

import com.codegym.task.task37.task3709.security.SecurityChecker;
import com.codegym.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker;
    private SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString) {
        this.simpleConnector = new SimpleConnector(resourceString);
        this.securityChecker = new SecurityCheckerImpl();
    }

    @Override
    public void connect() {
        if(this.securityChecker.performSecurityCheck())
            this.simpleConnector.connect();
    }
}
