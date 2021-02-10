package org.example.main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.resources.TestResource;
import org.example.server.ResourceServer;
import org.example.server.ResourceServerController;
import org.example.server.ResourceServerControllerMBean;
import org.example.server.ResourceServerI;
import org.example.servlets.UserServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        ResourceServerI resourceServer = new ResourceServer(new TestResource());

        ResourceServerControllerMBean m = new ResourceServerController(resourceServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(m, name);

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new UserServlet(resourceServer)), "/resources");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        server.setHandler(handlers);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}

        //TestResource resource = (TestResource) ReadXMLFileSAX.readXML("./data/MySqlTestResource.xdb");
        //System.out.println(resource);