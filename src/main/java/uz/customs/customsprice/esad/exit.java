package uz.customs.customsprice.esad;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.customs.customsprice.entity.users.Role;
import uz.customs.customsprice.entity.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "exit", urlPatterns = "/exit.do")
public class exit extends HttpServlet {
    public static Connection getConCPID(HttpServletRequest request) throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        }
        String strDB = "192.168.212.231";
        String strUser = "rusram";
        String strPwd = "9061648";
        if ((ip.equals("192.168.224.224") || ip.equals("192.168.224.18") || ip.equals("localhost"))) {
            strDB = "192.168.212.231";
            strUser = "rustam";
            strPwd = "9061648";
        }
        String strUrl = "jdbc:as400:" + strDB + "/ESAD;date format=iso";
        Connection ConST = null;
        String classforName = "com.ibm.as400.access.AS400JDBCDriver";
        Class.forName(classforName).newInstance();
        ConST = DriverManager.getConnection(strUrl, strUser, strPwd);
        return ConST;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Set<Role> roles = user.getRoles();
        List<Role> roleList = new ArrayList<>(roles);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String S_id = (String) request.getSession().getAttribute("SessionID");
        if (roleList.size() == 0) {
            response.sendRedirect(request.getContextPath() + "/user/auth/E404");
        } else {
            Connection con = null;
            try {
                con = getConCPID(request);
                Statement sql = null;
                ResultSet rslt = null;
                sql = con.createStatement();
//                String sqlstr = "select ses_id from cpid.log_esad where ses_id = '" + S_id + "' order by ses_id desc fetch first 1 row only";
                String sqlstr = "select ses_id from cpid.log where ses_id = '" + S_id + "' order by ses_id desc fetch first 1 row only";
                rslt = sql.executeQuery(sqlstr);
                if (rslt.next()) {
//                    PreparedStatement psql = con.prepareStatement("update cpid.log_esad set exit=current_timestamp where ses_id=?  ");
                    PreparedStatement psql = con.prepareStatement("update cpid.log set exit=current_timestamp where ses_id=?  ");
                    psql.setString(1, S_id);
                    psql.executeUpdate();
                    psql.close();
                }
                rslt.close();
                sql.close();
                request.getSession().invalidate();
                con.close();

                out.println("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=charset=UTF-8\"></head>");
                out.println("<body onLoad=\"window.opener=window.location.href;self.close()\">");
                out.println("Exit !</body></html>");
            } catch (Exception e) {
                request.getSession().invalidate();
                try {
                    assert con != null;
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                out.println("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=charset=UTF-8\"></head>");
                out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
                out.println("function _go2(j){if (j==30){top.location = '" + request.getContextPath() + "/12.jsp';}");
                out.println("else{window.setTimeout(\"_go2('30')\", 1000);}}</script>");
                out.println("<body onLoad=\"_go26(0)\" bgcolor=\"#336699\" scroll=no  topmargin=6  leftmargin=0>");
                out.println("<form  name=Stt method=\"post\">");
                out.println("<div id=\"SSS\" align=\"left\"><b><font color=\"#FFFFFF\" face=\"Times New Roman\">");
                out.println(e.getMessage() + "</font></b></div></body></html>");
                e.printStackTrace(System.out);
                e.printStackTrace(System.err);
            }
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
