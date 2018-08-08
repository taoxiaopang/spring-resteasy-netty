package com.taoxiaopang.rest.server;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.plugins.spring.SpringBeanProcessor;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class RestServer {

    private NettyJaxrsServer nettyServer;

    @Autowired
    ConfigurableApplicationContext context;

    public void setNettyServer(NettyJaxrsServer nettyServer) {
        this.nettyServer = nettyServer;
    }

    public void start() {
        ResteasyDeployment deployment = new ResteasyDeployment();

        ResteasyProviderFactory providerFactory = new ResteasyProviderFactory();
        deployment.setProviderFactory(providerFactory);

        nettyServer.setDeployment(deployment);
        nettyServer.setRootResourcePath("");
        nettyServer.setSecurityDomain(null);

        nettyServer.start();

        // added Spring beanFacotryProcessor to scan and register Provider/JAX-RS resources on bean class.
        SpringBeanProcessor processor = new SpringBeanProcessor(deployment);
        context.addBeanFactoryPostProcessor(processor);
        // ac.addApplicationListener(processor);
        context.refresh();
        processor.onApplicationEvent(null);

        System.out.println("========Success: starting server==========");
    }

    public void stop() throws InterruptedException {
        nettyServer.stop();
    }

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Assert.notNull(ac, "ConfigurableApplicationContext must not be null");

        RestServer server = ac.getBean(RestServer.class);

        server.start();

    }

}
