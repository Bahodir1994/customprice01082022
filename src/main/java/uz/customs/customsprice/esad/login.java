package uz.customs.customsprice.esad;

import sbs.beans.common.bnUserParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class login extends HttpServlet {
    private static String SessionID = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("error.exception");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().setAttribute("boshqarma", "17010025");
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login").trim();
        System.out.println("login := " + login);
        String password = request.getParameter("password").trim();

        Integer rol = 0;
        String user_role_name = "";
        String user_id = "";
        String user_role = "";
        String user_name = "";
        String user_location = "";
        String user_post = "";
        String user_login = "";
        String ruk = "";
        bnUserParam up = null;
        try {
            Connection conEDO = null;
//            = dbCon.getconFirst(request);
            Statement sql = conEDO.createStatement();
            Statement sql1 = conEDO.createStatement();
            Statement sql2 = conEDO.createStatement();
            ResultSet rslt = null;
            ResultSet rslt1 = null;

            rslt = sql.executeQuery(" select login,passwd,t.name,t.role,t.location, p.ID  as post, t.id \n" + " from control.users t, control.LOCATION p \n" + " where lower(login) = lower('" + login.trim() + "') and passwd = '" + password.trim() + "' and t.LOCATION = p.ID AND t.ACTIVE = '1' ");
            if (!rslt.next()) {
                response.sendRedirect(request.getContextPath() + "/acden.jsp");
            } else {
                user_id = rslt.getString("id").trim();
                user_name = rslt.getString("name");
                user_location = rslt.getString("location");
                user_post = rslt.getString("post");
                user_login = rslt.getString("login");

                rslt1 = sql1.executeQuery("select id, name from control.role where id = " + rslt.getInt("role") + "");
                if (!rslt1.next()) {
                    response.sendRedirect(request.getContextPath() + "/acden.jsp");
                } else {
                    Random rn = new Random();
                    int maximum = 9999, minimum = 1000, randomNum = 0;
                    int n = Math.abs(maximum - minimum + 1);
                    int i = rn.nextInt() % n;
                    randomNum = Math.abs(minimum + i);

                    SessionID = request.getSession().getId() + user_id + randomNum;
                    request.getSession().getServletContext().setAttribute("conEDO" + SessionID, conEDO);
                    request.getSession().setAttribute("LOGTABLE_ID", SessionID);
                    request.getSession().setAttribute("SessionID", SessionID);

                    rol = rslt1.getInt("id");
                    user_role_name = rslt1.getString("name");
                    request.getSession().setAttribute("user_id", user_id);
                    request.getSession().setAttribute("user_role", rol.toString());
                    request.getSession().setAttribute("user_name", user_name);
                    request.getSession().setAttribute("user_role_name", user_role_name);
                    request.getSession().setAttribute("user_location", user_location);
                    request.getSession().setAttribute("user_post", user_post);
                    request.getSession().setAttribute("user_login", user_login);

//                    System.out.println("cSql := " + "insert into control.log (ses_id,user_id,name,ip,enter,last) values ('" + SessionID.trim() + "','" + rslt.getString("id").trim() + "','" + rslt.getString("name").trim() + "','" + request.getRemoteAddr() + "', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)");
                    sql2.execute("insert into control.log (ses_id, user_id, name, ip, enter, last) " + "values " + "('" + SessionID + "','" + rslt.getString("id").trim() + "','" + rslt.getString("name").trim() + "','" + request.getRemoteAddr() + "', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");

                    response.sendRedirect(request.getContextPath() + "/index12.jsp");
                }
            }
//            request.getSession().setAttribute("user_location", "1702");
//            request.getSession().setAttribute("user_post", "1702");
//            request.getSession().setAttribute("user_role", 3);
            rslt.close();
            rslt1.close();
            sql.close();
            sql1.close();
            sql2.close();
        } catch (Exception e) {
            PrintWriter out1 = response.getWriter();
            out1.print("<hr><font color=\"red\"><strong>Тизимга 1 та логин билан икки марта кирилди.</strong></font></hr><br><hr>Илтимос дастурни қайта ишга туширинг!</hr>");
            out1.close();
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
        request.getSession().setAttribute("error.exception", "Error 404");
        response.sendRedirect(request.getContextPath() + "/index12.jsp");
    }

}