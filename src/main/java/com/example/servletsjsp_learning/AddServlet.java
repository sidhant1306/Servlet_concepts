package com.example.servletsjsp_learning;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
       /* int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int result = i + j;*/

//        System.out.println("Result is : " +result);   // we can't just be printing it on the console we need to print it on the page
        // the httpServletResponse has a method called getWriter() which fetched the output so we will use it, and it returns a printWriter so we can just create an object of the printwriter and use it for further references
        PrintWriter out = res.getWriter();      // res is out HttpServletResponse object

//        out.println("Result : " +result);

        // what if we only want to take an input from the user then there are two more methods to replace this service method:
        // first one is doPost, and the second one is doGet, this way the user can't just inspect the page and change the type of service from get to post or vice versa

        // we are anyway going to pass the request object which is req in this case so why not just send the value of result in that:
        // we want to first add both the entered numbers by the user then square them.
        // code :
      /*  req.setAttribute("result", result);     // the result inside the string refers to the name we want to use to refer this in other servlets
        // now what if we want to call another servlet from this servlet:(2nd thing)
        RequestDispatcher rd = req.getRequestDispatcher("sq");
        rd.forward(req,res);*/

        // using URL rewriting to redirect the user to another servlet,
        // using requestDispatcher we can only work between servlets of the same page,
        // but using redirect we can also call servlets of any other web page.

        // code :

        /*res.sendRedirect("sq?result=" +result); // we changed the url that we send to the servlet because we are not passing any values in the req
*/
   /* // USING SESSION TO SEND ATTRIBUTE AND VALUES:

        // code :
        HttpSession session = req.getSession();
        session.setAttribute("result", result);

        res.sendRedirect("sq");*/


     /*   // USING COOKIES TO SEND VALUES
        // We can send multiple values at a single time using cookies,

        Cookie cookie = new Cookie("result", result + " "); // the first parameter is the value we want to get
        // the second parameter is the value, and we add an extra string because it requires both the parameters in string type
        // so appending an integer with quotes makes it a string.

        // now as we are responding with a cookie :
        res.addCookie(cookie);      // adding the cookie in the response this servlet is sending.

        res.sendRedirect("sq");*/

      /*
        // username and password validating:
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        Cookie cookie = new Cookie("username", username);
        Cookie cookie1 = new Cookie("password", password);
       res.addCookie(cookie);
       res.addCookie(cookie1);
        res.sendRedirect("sq");*/

        // SERVLET CONTEXTS AND SERVLET CONFIG :
        // Servlet context is what you define for all the servlets but Servlet config is different for each Servlet,
        // imagine we have a "name" parameter, and we define its value as "sidhant" in teh servlet context parameter,
        // it means all the servlet in which value of that name is fetched it will have sidhant as a value,
        // whereas imagine there are two servlets servlet1 and servlet2,
        // now in the servlet1 you assign a value "mahak" to a parameter "name", same as the context parameter name,
        // now when you will fetch the value of "name" in servlet1 it will print "mahak", because we have done config,
        // for that particular servlet.

        // Servlet context :

        ServletContext ctx = getServletContext();
        String name = ctx.getInitParameter("name");
        out.println("Hi " +name);


        // Servlet config :
        ServletConfig cg = getServletConfig();
        String userName = cg.getInitParameter("name");
        out.println("Hi " +userName);

    }
}