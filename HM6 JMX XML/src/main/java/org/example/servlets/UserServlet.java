package org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.example.resources.TestResource;
import org.example.server.ResourceServerI;
import org.example.sax.ReadXMLFileSAX;
import org.example.server.ResourceServer;

public class UserServlet extends HttpServlet {
    private final ResourceServerI ResourceServer;
    public UserServlet(ResourceServerI ResourceServer) {
        this.ResourceServer = ResourceServer;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Hello!");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String path = req.getParameter("path");
        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(path);
        //new ResourceServer(resource);
        ResourceServer.setRes(resource);

        response.getWriter().println("ok");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
