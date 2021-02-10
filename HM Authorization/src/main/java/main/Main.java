package main;

import accounts.AccountService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import  servlets.*;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService(); // 2 homework
        MirrorServlet mirrorServlet = new MirrorServlet(); // 1 homework

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorServlet), "/mirror"); //1hm
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        Logger.getGlobal().info("Server started");
        server.join();
    }
}
