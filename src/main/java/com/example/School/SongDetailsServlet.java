package com.example.School;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "songInfoServlet", value = "/getSongInfo")
public class SongDetailsServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req, resp);
    }

    @Override
    public void destroy() {
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("id");
        int id = -1;
        try {
            id = Integer.parseInt(name);
        } catch (NumberFormatException ignored) {}

        response.setContentType("text/html;charset=UTF-8");

        Song song = SongRepository.getSong(id);

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Информация о песне</title></head>");
            out.println("<body>");
            out.println("<h1>Song: " + song.name + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>Name</b></td><td><b>Author</b ></td><td><b> Duration </b></td><td><b> Listen time </b></td></tr> ");
            out.println("<tr><td><b>" + song.name + "</b></td><td><b>" + song.author + "</b ></td><td><b> " + song.duration + " </b></td><td><b> " + song.listenTime + " </b></td></tr> ");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}