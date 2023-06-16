package com.playdata.todos.servlet;

import com.playdata.todos.dao.UserDao;
import com.playdata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("views/update.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        HttpSession session = req.getSession();
        Integer id = (Integer) session.getAttribute("id");

        User user = new User(id, null, password, name, null);
        UserDao userDao = new UserDao();
        userDao.update(user);
        resp.sendRedirect("/login");
        resp.setStatus(201);
    }
}
