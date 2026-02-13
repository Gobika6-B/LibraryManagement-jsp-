package com.wipro.library.servlets;
import com.wipro.library.bean.LibraryBean;
import com.wipro.library.service.Administrator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    Administrator admin = new Administrator();
    public String addRecord(HttpServletRequest request) {
        try {
            LibraryBean bean = new LibraryBean();
            bean.setBookTitle(request.getParameter("bookTitle"));
            bean.setAuthor(request.getParameter("author"));
            bean.setCategory(request.getParameter("category"));
            bean.setPublishedYear(Integer.parseInt(request.getParameter("year")));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            bean.setAddedDate(sdf.parse(request.getParameter("addedDate")));
            bean.setRemarks(request.getParameter("remarks"));
            return admin.addRecord(bean);
        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        }
    }
    public LibraryBean viewRecord(HttpServletRequest request) {
        try {
            String title = request.getParameter("bookTitle");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return admin.viewRecord(title, sdf.parse(request.getParameter("addedDate")));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<LibraryBean> viewAllRecords() {
        return admin.viewAllRecords();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("operation");
        if (op.equals("newRecord")) {
            String result = addRecord(request);

            if (result.equals("FAIL") || result.equals("INVALID INPUT")) {
                response.sendRedirect("error.html");
            } else {
                response.sendRedirect("success.html");
            }
        }
        else if (op.equals("viewRecord")) {
            LibraryBean bean = viewRecord(request);

            if (bean == null) {
                request.setAttribute("msg", "No matching records exists! Please try again!");
            } else {
                request.setAttribute("bean", bean);
            }

            request.getRequestDispatcher("displayBook.jsp").forward(request, response);
        }
        else if (op.equals("viewAllRecords")) {
            List<LibraryBean> list = viewAllRecords();

            if (list.isEmpty()) {
                request.setAttribute("msg", "No records available!");
            } else {
                request.setAttribute("list", list);
            }
            request.getRequestDispatcher("displayAllBooks.jsp").forward(request, response);
        }
    }
}
