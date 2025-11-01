package com.example.servletsjsp_learning;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/sq")
public class SqServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();


        /*int ans = (int) req.getAttribute("result");     // req.getAttribute returns an object so we typecast it into an integer
        ans = ans * ans;    // performing the square on the addition result
        out.println("Square of sum of the entered numbers is : " +ans);
*/
      /*  // using send redirect :
        int sol = Integer.parseInt(req.getParameter("result"));
        sol = sol * sol;
        out.println("Square using redirection is : " +sol);
*/
       /* // USING SESSIONS :

        HttpSession session = req.getSession();
        int ans = (int) session.getAttribute("result");
        ans = ans * ans;
        out.println("square root using session is : " +ans);*/

    /*    // USING COOKIES :
        int ans = 0;    // global reach
        Cookie cookies[] = req.getCookies();        // we are getting an array of cookies because :
        // the addServlet sends the response back to the user after creating the cookie, but the user may have more than one cookie
        // and this servlet now asks the user to send the cookies, but the user does not know which cookie we need,
        // so we take all the cookies from the user.

        // finding the right cookie from the obtained cookies :
        for (Cookie c : cookies){
            if(c.getName().equals("result")) ans = Integer.parseInt(c.getValue());
        }

        ans = ans * ans;
        out.println(ans);
*/
      /*
        // USERNAME AND PASSWORD :
        String original_username = "root";
        String original_password = "Sonam@1108";
        String entered_username = "";
        String entered_password = "";
    Cookie[] cookies = req.getCookies();

    for (Cookie c : cookies){
        if(c.getName().equals("username")) entered_username = c.getValue();
        if(c.getName().equals("password")) entered_password = c.getValue();
    }

    if(entered_username.equals(original_username) && entered_password.equals(original_password)){
        out.println("Correct credentials entered for the account. Welcome back " +entered_username);
    }
    else {
        out.println("You entered wrong credentials.");
    }
*/


    }

}

