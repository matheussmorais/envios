/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.projeto_01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manoel
 */
public class Juros_Simples extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros Simples</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<style type=\"text/css\">"
                    + "                                        fieldset{width: 200px; position: absolute; top:80px}"
                    + "                                        h1{position: absolute; left: 30px}"
                    + "                               </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Juros Simples </h1>");
            out.println("<form method=\"post\">\n"
                    + "		<fieldset>\n"
                    + "		<p> Capital:<br> <input type=\"number\" name=\"capital\" required=\"\"> </p>\n"
                    + "		<p>Taxa:<br> <input type=\"number\" name=\"taxa\" required=\"\"></p>\n"
                    + "		<p>Tempo:<br> <input type=\"number\" name=\"tempo\" required=\"\"></p>\n"
                    + "		<p><input type=\"submit\" value=\"Calcular\" name=\"botao\"></p>");
            out.println("<a href=Home>Voltar</a>");
            if (request.getParameter("botao") != null) {
                try {
                    double taxa = Double.parseDouble(request.getParameter("taxa"));
                    double capital = Double.parseDouble(request.getParameter("capital"));
                    double tempo = Double.parseDouble(request.getParameter("tempo"));
                    double montante = capital * taxa * tempo;
                    out.println("<h3>Montante:</h3>" + montante);
                } catch (Exception e) {
                    out.println("<h2>Erro ao inserir os valores!<h2>");
                }
            }

            out.println("</fieldset>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
