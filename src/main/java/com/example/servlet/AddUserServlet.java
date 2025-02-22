package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/add").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        User user = new User(req.getParameter("firstName"), req.getParameter("secondName"));
        Warehouse.getInstance().addUser(user);
        req.setAttribute("user", user);
        res.sendRedirect("/add");
    }
}