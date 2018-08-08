package com.taoxiaopang.rest.server;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;

public class NettyServer extends NettyJaxrsServer {
    private int httpPort;
    private int backlog;
    private int executorThreadCount;

    public void setHttpPort(int httpPort) {
        this.httpPort = httpPort;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    public void setExecutorThreadCount(int executorThreadCount) {
        this.executorThreadCount = executorThreadCount;
    }

    @Override
    public void start() {
        // start resteasy http server
        super.setBacklog(backlog);
        super.setPort(httpPort);
        super.setExecutorThreadCount(executorThreadCount);
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

}
