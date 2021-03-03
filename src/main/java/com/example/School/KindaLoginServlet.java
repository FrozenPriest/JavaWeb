package com.example.School;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@WebServlet(name = "KindaLoginServlet", value = "/login")
public class KindaLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        HttpSession session = request.getSession(true);
        System.out.println("Servlet session: " + session.getId());

        if (name != null && !name.trim().equals("")) {
            session.setAttribute("user", name);
            Cookie cookieUser = new Cookie("user", URLEncoder.encode(name, StandardCharsets.UTF_8));
            cookieUser.setMaxAge(100);
            response.addCookie(cookieUser);
        }



        String color = request.getParameter("color");
        if (color == null) color = Color.WHITE.toString();

        Cookie cookieColor = new Cookie("color", color);
        cookieColor.setMaxAge(100);
        response.addCookie(cookieColor);

        Object countObj = session.getAttribute("count");
        int count;
        if(countObj == null) count = 0;
        else count = (int) countObj;
        session.setAttribute("count", ++count);
        session.setAttribute("lastEnter", new Date().toString());

        System.out.println("LOL: " + session.getAttribute("user"));
        System.out.println("LOL: " + session.getAttribute("count"));
        System.out.println("LOL: " + session.getAttribute("lastEnter"));
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/song_library.jsp"));
    }
}
