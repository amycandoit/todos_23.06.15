package com.playdata.todos.servlet;

import com.playdata.todos.config.History;
import com.playdata.todos.dao.TodoDao;
import com.playdata.todos.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object uname = (String) session.getAttribute("uname");
        req.setAttribute("uname", uname);
        String keyword = req.getParameter("keyword");
        if (keyword != null && !keyword.equals("")) {
            req.setAttribute("todolist", new TodoDao().findByKeyword(keyword));
        }else req.setAttribute("todolist", new TodoDao().findAll());
        req.getRequestDispatcher("views/main.jsp").forward(req, resp);

    }
//        History.setHistory(req, resp);
//        Cookie[] cookies = req.getCookies();
//        String uid = null;
//        String uname = null;
//        for (Cookie c: cookies) {
//            if (c.getName().equals("uid")) uid = c.getValue();
//            if (c.getName().equals("uname")) uname = c.getValue();
//        }
//        HttpSession session = req.getSession();
//        if (session.getAttribute("uname") != null){
//
//            resp.setContentType("text/html; charset = utf-8");
//            PrintWriter writer = resp.getWriter();
//            writer.println("<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>MAIN</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "  <h1>" + session.getAttribute("uname") + " 환영합니다!</h1>\n" +
////                "  <h1>" + UserDao.me.getCreateAt() + " 가입했습니다!</h1>\n" +
//                "  <img src=\"/img/ffsf.png\">\n" +
//                    "<a href=\"/back\">back</a>\n"+
////                    "<a href=\"/todos\">+</a>\n"+
//                    "<a href=\"/update\">user update</a>\n"+
//                "</body>\n" +
//                "</html>");
//        writer.close();
//        } else {
//            resp.sendRedirect("/login");
//        }
}


