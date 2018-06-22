/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.sv.ane.slusaci;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

//import org.foi.nwtis.zorhrncic.konfiguracije.bp.BP_Konfiguracija;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.core.io.ClassPathResource;

public class SlusacAplikacije implements ServletContextListener {

    private ServletContext servletContext;
    private String datoteka;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.out.println("MyServletContextListener Context Initialized");
            ServletContext context = sce.getServletContext();
            this.servletContext = context;
            datoteka = context.getInitParameter("konfiguracija");
            System.out.println("Datoteka:_" + datoteka);
            //  String putanja = context.getRealPath("/WEB-INF") + java.io.File.separator;
            ClassPathResource res = new ClassPathResource(datoteka);
            File file = new File(res.getPath());
            System.out.println("file: " + file.getAbsolutePath());

            //
        //   context.setAttribute("All_Konfig", konfiguracijaSve);
        } catch (Exception ex) {
            Logger.getLogger(SlusacAplikacije.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    @Override
    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("MyServletContextListener Context Destroyed");
    }

}
