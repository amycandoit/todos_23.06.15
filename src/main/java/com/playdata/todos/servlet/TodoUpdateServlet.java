package com.playdata.todos.servlet;

import com.playdata.todos.dao.TodoDao;
import com.playdata.todos.dao.UserDao;
import com.playdata.todos.dto.TodoJoinUser;
import com.playdata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TodoUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("todoid"));
        req.setAttribute("todoid", req.getParameter("todoid"));
        int id = Integer.parseInt(req.getParameter("todoid"));
        String content = new TodoDao().findById(id).getContent();
        req.setAttribute("content", content);
        req.getRequestDispatcher("/views/todoupdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");

        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        int uid = (Integer) session.getAttribute("uid"); // 이미 login에서 uid가 session에 set 되어있어서 get으로 꺼내 올 수 있었음

        new TodoDao().update(id,uid,content);
        resp.sendRedirect("/main");
        resp.setStatus(201);
    }
}
