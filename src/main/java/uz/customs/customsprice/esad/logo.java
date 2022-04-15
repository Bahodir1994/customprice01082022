package uz.customs.customsprice.esad;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import sbs.beans.common.bnUserParam;
import uz.customs.customsprice.config.SpringSecurityAuditorAware;
import uz.customs.customsprice.entity.users.Role;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.*;

@WebServlet(name = "logo", urlPatterns = "/skvnksjdhfjksd.do")
public class logo extends HttpServlet {

    public static bnUserParam getObject(String host, int port, String address, String params) {
        URL dataURL;
        Object obj;
        try {
            String protocol = "http";
            dataURL = new URL(protocol, host, port, address + params + "&rm=" + Math.random());
            URLConnection connection = dataURL.openConnection();
            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
            obj = in.readObject();
            in.close();
            return (bnUserParam) obj;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public static Connection getConESAD(HttpServletRequest request) throws Exception {
        String strDB = "192.168.212.225";
        String strUser = "edouser";
        String strPwd = "RaSsWoRdS";
        String strUrl = "jdbc:as400:" + strDB + "/ESAD;date format=iso";
        Connection ConST = null;
        String classforName = "com.ibm.as400.access.AS400JDBCDriver";
        Class.forName(classforName).newInstance();
        ConST = DriverManager.getConnection(strUrl, strUser, strPwd);
        return ConST;
    }

    public static Connection getConCPID(HttpServletRequest request) throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        }
        String strDB = "192.168.212.231";
        String strUser = "rustam";
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        bnUserParam up = null;
        String uLogin = request.getParameter("ULogin"); //logonInfo.getULogin();
        String sysid = request.getParameter("sysid");
        String address = "/esad/common/user.jsp";
        String host = "192.168.12.151";
        if (request.getParameter("url") != null) {
            host = request.getParameter("url");
        }
        String portS = "9080";
        if (request.getParameter("port") != null) {
            portS = request.getParameter("port");
        }
        int port = Integer.parseInt(portS);
        try {
            up = getObject(host, port, address, "?ULogin=" + uLogin + "&sysid=" + sysid);
        } catch (Exception ignored) {
        }
        request.getSession().setAttribute("UserBean", up);
        assert up != null;
        String userLogin = up.getULogin();
        String UUser_Id = up.getUUser_Id();
        TreeMap rolSet = new TreeMap();
        rolSet = up.getURoleSets();
        String rol = "", rolName = "";
        String sql_text = "";
        String IP = "";
        for (Object o : rolSet.keySet()) {
            rol = (String) o;
            rolName = (String) rolSet.get(rol);
            if (!sql_text.equals("")) {
                sql_text += ", ";
            }
            sql_text += rol;
        }
        Connection conESAD = null;
        Connection conET = null;
        if (userLogin != null) {
            try {
                conESAD = getConESAD(request);
            } catch (Exception e) {
                e.printStackTrace();
            }

            session.setAttribute("user_login", userLogin);
            Map<String, String> ROLE = new HashMap<String, String>();
            Map<String, String> ROLEID = new HashMap<String, String>();
            Map<String, Integer> ROLECODE = new HashMap<String, Integer>();
            Map<String, String> ROLENAME = new HashMap<String, String>();
            Map<String, String> PNUMBER = new HashMap<String, String>();
            Map<String, String> NAME = new HashMap<String, String>();
            Map<String, String> LOGIN = new HashMap<String, String>();
            Map<String, String> PASSWORD = new HashMap<String, String>();
            Map<String, String> POST = new HashMap<String, String>();
            Map<String, String> POSTNAME = new HashMap<String, String>();
            Map<String, String> LOCATION = new HashMap<String, String>();
            Map<String, String> LOCATIONNAME = new HashMap<String, String>();
            Map<String, String> DEPARTMENT = new HashMap<String, String>();
            Map<String, String> DEPARTMENTNAME = new HashMap<String, String>();
            Map<String, String> USERROLE = new HashMap<String, String>();
            Map<String, String> USERID = new HashMap<String, String>();
            Map<String, String> IDROTATION = new HashMap<String, String>();
            Map<String, String> ACTIONID = new HashMap<String, String>();
            Map<String, String> ACTIONNAME = new HashMap<String, String>();
            boolean acces = true;
            if (up.getULocation() == null) {
                acces = false;
                response.sendRedirect("acden.jsp?no_post=0");
            }

            try {
                if (acces) {
                    Statement sql = null;
                    ResultSet rslt = null;
                    IP = request.getRemoteAddr();
                    assert conESAD != null;
                    sql = conESAD.createStatement();
                    int t = 0;
                    String zapros = " select\n" +
                            "    distinct rs.role_id role,\n" +
                            "    rs.idrotation       rs_idrotation,\n" +
                            "    rs.userid           rs_userid,\n" +
                            "    um.name             name,\n" +
                            "    um.login,\n" +
                            "    um.password,\n" +
                            "    um.ikeysn,\n" +
                            "    um.userid,\n" +
                            "    ur.idrotation,\n" +
                            "    ur.user_id ur_userid,\n" +
                            "    ur.pnumber,\n" +
                            "    ur.location_id   location,\n" +
                            "    loc.name_uzb     locationname,\n" +
                            "    ur.post_id       post,\n" +
                            "    pos.name         postname,\n" +
                            "    ur.department_id department,\n" +
                            "    dep.name         departmentname,\n" +
                            "    usr.id           userrole_id,\n" +
                            "    usr.sysid,\n" +
                            "    usr.name   rolename,\n" +
                            "    usr.userid usr_userid,\n" +
                            "    usr.ugtkvis,\n" +
                            "    urtm.userid urtm_userid\n" +
                            "from\n" +
                            "    esad.usermain um\n" +
                            "join\n" +
                            "    esad.userrotation ur\n" +
                            "on\n" +
                            "    um.id=ur.user_id\n" +
                            "and ur.isdeleted=0\n" +
                            "and ur.finishdate is null\n" +
                            "join\n" +
                            "    esad.rolesets rs\n" +
                            "on\n" +
                            "    rs.idrotation=ur.idrotation\n" +
                            "join\n" +
                            "    esad.userrole usr\n" +
                            "on\n" +
                            "    usr.id=rs.role_id\n" +
                            "and usr.sysid='S036' /*KADR test*/\n" +
                            "join\n" +
                            "    esad.userrightsmain urtm\n" +
                            "on\n" +
                            "    usr.id=urtm.userrole_id\n" +
                            "join\n" +
                            "    nlgot.location loc\n" +
                            "on\n" +
                            "    ur.location_id=loc.id\n" +
                            "left join\n" +
                            "    esad.post pos\n" +
                            "on\n" +
                            "    ur.post_id=pos.id\n" +
                            "and pos.isdeleted=0\n" +
                            "left join\n" +
                            "    esad.department dep\n" +
                            "on\n" +
                            "    ur.department_id=dep.id\n" +
                            "and dep.isdeleted=0\n" +
                            "where\n" +
                            "    um.isdeleted=0\n" +
                            " and lower(um.login) like lower('" + userLogin.trim() + "') \n " +
                            " and ur.idrotation='" + UUser_Id.trim() + "'    \n" +
//                            "and lower(um.login) like lower('RustamSh')\n" +
//                            "    and ur.idrotation='AB170110000064530'\n" +
                            "order by\n" +
                            "    usr.id ";
                    rslt = sql.executeQuery(zapros);
                    while (rslt.next()) {
                        t = t + 1;
                        ROLE.put(Integer.toString(t), (Utils.nullClear(rslt.getString("role"))));
                        ROLEID.put(Integer.toString(t), (Utils.nullClear(rslt.getString("userrole_id"))));
                        USERID.put(Integer.toString(t), (Utils.nullClear(rslt.getString("userid"))));
                        NAME.put(Integer.toString(t), (Utils.nullClear(rslt.getString("name"))));
                        LOGIN.put(Integer.toString(t), (Utils.nullClear(rslt.getString("login"))));
                        PASSWORD.put(Integer.toString(t), (Utils.nullClear(rslt.getString("password"))));
                        ROLENAME.put(Integer.toString(t), (Utils.nullClear(rslt.getString("rolename")).replaceAll("VIP", "")));
                        IDROTATION.put(Integer.toString(t), (Utils.nullClear(rslt.getString("idrotation"))));
                        LOCATION.put(Integer.toString(t), (Utils.nullClear(rslt.getString("location"))));
                        LOCATIONNAME.put(Integer.toString(t), (Utils.nullClear(rslt.getString("locationname"))));
                        DEPARTMENT.put(Integer.toString(t), (Utils.nullClear(rslt.getString("department"))));
                        DEPARTMENTNAME.put(Integer.toString(t), (Utils.nullClear(rslt.getString("departmentname"))));
                        POST.put(Integer.toString(t), (Utils.nullClear(rslt.getString("post"))));
                        POSTNAME.put(Integer.toString(t), (Utils.nullClear(rslt.getString("postname"))));
                        USERROLE.put(Integer.toString(t), (Utils.nullClear(rslt.getString("login"))));
                        PNUMBER.put(Integer.toString(t), (Utils.nullClear(rslt.getString("pnumber"))));
                    }
                    request.getSession().setAttribute("USERID", USERID.get("1"));  // фойдаланувчи iD си

                    Random rn = new Random();
                    int maximum = 9999, minimum = 1000, randomNum = 0;
                    int n = Math.abs(maximum - minimum + 1);
                    int i = rn.nextInt() % n;
                    randomNum = Math.abs(minimum + i);
                    String user_idS = ((String) request.getSession().getAttribute("USERID")).trim();

                    String sessionID = request.getSession().getId() + user_idS + randomNum;
                    request.getSession().getServletContext().setAttribute("conESAD" + sessionID, conESAD);
                    request.getSession().setAttribute("LOGTABLE_ID", sessionID);
                    request.getSession().setAttribute("SessionID", sessionID);

                    ////////////////////////////////////////////////////////////////////////////////////////////////////////
                    conET = getConCPID(request);
                    conET.setAutoCommit(false);
                    Statement sqlEt = conET.createStatement();
                    String sqlstr = "insert into cpid.log_esad(ses_id, USER_ID, name, ip, enter, last) " + "values ('" + sessionID + "','" + up.getUUser_Id().substring(2) + "','" + up.getUName() + "','" + IP + "',current_timestamp,current_timestamp)";
                    sqlEt.executeUpdate(sqlstr);

                    ///////////////////////////////////////////////////////////////////////////////////////////////////////
                    session.setAttribute("RowRole", Integer.toString(t));
                    sqlstr = "select r.id, r.code from cpid.urole r";
                    ResultSet rslt2 = null;
                    rslt2 = sqlEt.executeQuery(sqlstr);
                    while (rslt2.next()) {
                        ROLECODE.put(Utils.nullClear(rslt2.getString("id")), Utils.nullClearI0(rslt2.getString("code")));
                    }
                    rslt2.close();
                    sqlstr = "select\n" + "    u.*\n" + "from\n" + "    cpid.user_e u\n" + "where\n" + "    u.userid='" + user_idS + "'";

                    rslt2 = sqlEt.executeQuery(sqlstr);
                    String id = "";
                    String userid = user_idS;
                    String username = LOGIN.get("1");
                    String fullname = NAME.get("1");
                    String password = PASSWORD.get("1");
                    String location = LOCATION.get("1");
                    String locationname = LOCATIONNAME.get("1");
                    String post = POST.get("1");
                    String postname = POSTNAME.get("1");
                    if (post.equals("")) {
                        post = DEPARTMENT.get("1");
                        postname = DEPARTMENTNAME.get("1");
                    }
                    String lang = "UZ";
                    int notification = 0, role = ROLECODE.get(ROLE.get(String.valueOf(1)));
                    String insuser = user_idS;
                    Timestamp instime = new Timestamp(System.currentTimeMillis());
                    while (rslt2.next()) {
                        id = Utils.nullClear(rslt2.getString("id"));
                        userid = Utils.nullClear(rslt2.getString("userid"));
                        username = Utils.nullClear(rslt2.getString("username"));
                        password = Utils.nullClear(rslt2.getString("password"));
                        fullname = Utils.nullClear(rslt2.getString("fullname"));
                        location = Utils.nullClear(rslt2.getString("location"));
                        locationname = Utils.nullClear(rslt2.getString("locationname"));
                        post = Utils.nullClear(rslt2.getString("post"));
                        postname = Utils.nullClear(rslt2.getString("postname"));
                        lang = Utils.nullClear(rslt2.getString("lang"));
                        notification = Utils.nullClearI0(rslt2.getString("notification"));
                        role = Utils.nullClearI0(rslt2.getString("role"));
                        insuser = Utils.nullClear(rslt2.getString("insuser"));
                        instime = rslt2.getTimestamp("instime");
                    }
                    rslt2.close();
                    User user = new User();
                    if (id.equals("")) {
                        UUID uuid = UUID.randomUUID();
                        PreparedStatement USER = conET.prepareStatement("insert into cpid.user_e (id, userid, username, fullname, password, location, locationname, post, postname, lang, notification, insuser, isdeleted, role, instime) \n" + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        USER.clearParameters();
                        USER.setString(1, String.valueOf(uuid));
                        USER.setString(2, userid);
                        USER.setString(3, username);
                        USER.setString(4, fullname);
                        USER.setString(5, password);
                        USER.setString(6, location);
                        USER.setString(7, locationname);
                        USER.setString(8, post);
                        USER.setString(9, postname);
                        USER.setString(10, lang);
                        USER.setInt(11, notification);
                        USER.setString(12, insuser);
                        USER.setInt(13, 0);
                        USER.setInt(14, role);
                        USER.setTimestamp(15, instime);
                        USER.execute();
                        USER.close();

                        Set<Role> roles = new HashSet<>();
                        PreparedStatement ROLES = conET.prepareStatement("insert into cpid.user_e_urole (user_id, roles_id) values (?, ?)");
                        for (int j = 1; j <= ROLE.size(); j++) {
                            roles.add(new Role(ROLE.get(String.valueOf(j)), ROLENAME.get(String.valueOf(j)), ROLECODE.get(ROLE.get(String.valueOf(j)))));
                            ROLES.clearParameters();
                            ROLES.setString(1, String.valueOf(uuid));
                            ROLES.setString(2, ROLE.get(String.valueOf(j)));
                            ROLES.execute();
                        }
                        ROLES.close();

                        user.setId(String.valueOf(uuid));
                        user.setUserid(userid);
                        user.setUsername(username);
                        user.setFullname(fullname);
                        user.setPassword(password);
                        user.setPasswordConfirm(password);
                        user.setLocation(location);
                        user.setLocationname(locationname);
                        user.setPost(post);
                        user.setPostname(postname);
                        user.setLang(lang);
                        user.setNotification(notification);
                        user.setInsUser(userid);
                        user.setInsTime(instime);
                        user.setRoles(roles);
                        user.setRole(role);
                    } else {
                        PreparedStatement USER = conET.prepareStatement("update cpid.user_e set userid=?, username=?, fullname=?, password=?, location=?, locationname=?, post=?, postname=?, lang=?, notification=?, upduser=?, isdeleted=?, updtime=?, role=? where id=?");
                        USER.clearParameters();
                        USER.setString(1, userid);
                        USER.setString(2, username);
                        USER.setString(3, fullname);
                        USER.setString(4, password);
                        USER.setString(5, location);
                        USER.setString(6, locationname);
                        USER.setString(7, post);
                        USER.setString(8, postname);
                        USER.setString(9, lang);
                        USER.setInt(10, notification);
                        USER.setString(11, insuser);
                        USER.setInt(12, 0);
                        USER.setTimestamp(13, instime);
                        USER.setInt(14, role);
                        USER.setString(15, id);
                        USER.execute();
                        USER.close();

                        PreparedStatement DELETE = conET.prepareStatement("delete from cpid.user_e_urole where USER_ID = ?");
                        DELETE.clearParameters();
                        DELETE.setString(1, id);
                        DELETE.execute();
                        DELETE.close();

                        Set<Role> roles = new HashSet<>();
                        PreparedStatement ROLES = conET.prepareStatement("insert into cpid.user_e_urole (user_id, roles_id) values (?, ?)");
                        for (int j = 1; j <= ROLE.size(); j++) {
                            roles.add(new Role(ROLE.get(String.valueOf(j)), ROLENAME.get(String.valueOf(j)), ROLECODE.get(ROLE.get(String.valueOf(j)))));
                            ROLES.clearParameters();
                            ROLES.setString(1, id);
                            ROLES.setString(2, ROLE.get(String.valueOf(j)));
                            ROLES.execute();
                        }
                        ROLES.close();
                        user.setId(id);
                        user.setUserid(userid);
                        user.setUsername(username);
                        user.setFullname(fullname);
                        user.setPassword(password);
                        user.setPasswordConfirm(password);
                        user.setLocation(location);
                        user.setLocationname(locationname);
                        user.setPost(post);
                        user.setPost(postname);
                        user.setLang(lang);
                        user.setNotification(notification);
                        user.setInsUser(userid);
                        user.setUpdTime(instime);
                        user.setRoles(roles);
                        user.setRole(role);
                    }
                    session.setAttribute("role", role);
                    session.setAttribute("lang", lang);
                    SecurityContext securityContext = SecurityContextHolder.getContext();
                    Authentication authentication = new Authentication() {
                        @Override
                        public Collection<? extends GrantedAuthority> getAuthorities() {
                            return user.getAuthorities();
                        }

                        @Override
                        public Object getCredentials() {
                            return user;
                        }

                        @Override
                        public Object getDetails() {
                            return user;
                        }

                        @Override
                        public Object getPrincipal() {
                            return user;
                        }

                        @Override
                        public boolean isAuthenticated() {
                            return true;
                        }

                        @Override
                        public void setAuthenticated(boolean b) throws IllegalArgumentException {
                        }

                        @Override
                        public String getName() {
                            return user.getUsername();
                        }
                    };
                    securityContext.setAuthentication(authentication);
                    SpringSecurityAuditorAware springSecurityAuditorAware = new SpringSecurityAuditorAware();
                    springSecurityAuditorAware.getCurrentAuditor();
                    rslt.close();
                    sql.close();
                    sqlEt.close();
                    conET.setAutoCommit(true);
                    conET.commit();
                    conET.close();
                    conESAD.close();
                    response.sendRedirect(request.getContextPath() + "/");
                }
            } catch (Exception e) {
                try {
                    if (conET != null && !conET.isClosed()) {
                        conET.rollback();
                        conET.close();
                    }
                    conESAD.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace(System.out);
                request.getSession().setAttribute("err", e.getMessage());
                response.sendRedirect(request.getContextPath() + "/user/auth/E404");
            }
        }
    }
}
