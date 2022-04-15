package uz.customs.customsprice.esad;

import com.ibm.as400.util.BASE64Encoder;
import sbs.beans.common.bnUserParam;
import uz.etranzitin.esad.Crypt.ISignerCli;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by SherZod on 07.04.2020.
 */
@WebServlet(name = "login_unicon", urlPatterns = "/login_unicon")
public class login_unicon extends HttpServlet {
    private static String SessionID = "";
    String errorMessage = "";

    public static String toDB2(Timestamp t) {
        String m = t.toString().substring(t.toString().indexOf(".") + 1, t.toString().length());
        Locale l = new Locale("ru", "");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.", l);
        return sdf.format(t) + m;
    }

    public static bnUserParam User(String login, HttpServletRequest request, Connection con) {
        String sql = "select * from ADMIN_VO.USERMAIN um, ADMIN_VO.ROLESETS rs where\n" +
                "um.ID=rs.USER_ID and um.LOGIN='" + login + "'";
        bnUserParam bnup = null;
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            bnup = new bnUserParam();
            bnup.setUId(rs.getString("ID"));
            bnup.setUUser_Id(rs.getString("ID"));
            bnup.setULogin(rs.getString("LOGIN"));
            bnup.setUName(rs.getString("NAME"));
            bnup.setUActionTypem(ActionTypem(login, con));
            bnup.setURoleSets(RoleSets(login, con));
            bnup.setUActionType(ActionType(login, con));
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bnup;
    }

    public static HashMap ActionTypem(String login, Connection con) {
        HashMap rights = new HashMap();
        String sql = "select am.ID ID, am.NAME Name from ADMIN_VO.USERMAIN um, ADMIN_VO.ROLESETS rs," +
                " ADMIN_VO.USERRIGHTSMAIN ur, ADMIN_VO.ACTIONTYPEMAIN am where" +
                " um.ID=rs.USER_ID and rs.ROLE_ID=ur.USERROLE_ID and ur.ACTION_ID=am.ID and um.LOGIN='" + login + "'";
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                rights.put(rs.getString("ID"), rs.getString("NAME"));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rights;
    }

    public static TreeMap RoleSets(String login, Connection con) {
        TreeMap roles = new TreeMap();
        String sql = "select ur.ID ID, ur.NAME Name from ADMIN_VO.USERMAIN um, ADMIN_VO.ROLESETS rs, ADMIN_VO.USERROLE ur \n" +
                "where um.ID=rs.USER_ID and rs.ROLE_ID=ur.ID and um.LOGIN='" + login + "'";
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                roles.put(rs.getString("ID"), rs.getString("NAME"));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    public static ArrayList ActionType(String login, Connection con) {
        ArrayList dobav = new ArrayList();
        HashMap dob = new HashMap();
        String sql = "select MFO, ORG_ID, REGION_ID from ADMIN_VO.USERMAIN where login='" + login + "'";
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dob.put("mfo", rs.getString("MFO"));
                dob.put("priznak", rs.getString("ORG_ID"));
                dob.put("region", rs.getString("REGION_ID"));
                dobav.add(dob);
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dobav;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().removeAttribute("error.exception");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Connection conLgot = null;
        String logon_jsp = "/logo.jsp";
        String uLogin = "";
        String param = "";
        request.getSession().removeAttribute("error.exception");
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("ikey") == null) {
            if (request.getParameter("eKalit") != null && request.getParameter("eKalit").equals("new")) {
                request.getSession().setAttribute("eKalit", "new");
                logon_jsp = "/eKalitU.jsp";
            } else
                request.getSession().removeAttribute("eKalit");
            String ikeysn = request.getParameter("ClientName");

            String serial_number = request.getParameter("serial_number");
            String data = request.getParameter("data");
            String data_hash = request.getParameter("data_hash");
            String signature = request.getParameter("signature");
            String certificate = "";
            boolean err1 = true;

            request.getSession().removeAttribute("SessionTimeout");
            String str_dt1 = Long.toHexString(System.currentTimeMillis()).toUpperCase();
            str_dt1 = System.currentTimeMillis() + "";
            str_dt1 = ikeysn + str_dt1.substring(0, str_dt1.length() - 5);// + request.getSession().getId();
            if (str_dt1.equals(data.substring(0, data.length() - 5))) {
                if (ikeysn == null) {
                    err1 = false;
                    request.getSession().setAttribute("error.exception", "Неверный USB ключ ! (no ikeysn)");
                } else if (serial_number == null) {
                    err1 = false;
                    request.getSession().setAttribute("error.exception", "Неверный USB пароль ключ ! (no serial_number)");
                } else if (data == null) {
                    err1 = false;
                    request.getSession().setAttribute("error.exception", "Неверный USB пароль ключ ! (no data)");
                } else if (signature == null) {
                    err1 = false;
                    request.getSession().setAttribute("error.exception", "Неверный USB пароль ключ ! (no signature)");
                }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.err.println("----------------тест---------------------------");
                Enumeration mp = request.getParameterNames();
                String keyf = "";
                while (mp.hasMoreElements()) {
                    keyf = (String) mp.nextElement();
                    System.err.println("> " + keyf + " --> " + request.getParameter(keyf));
                }
                System.err.println("----------------тест---------------------------");
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (err1)
                    try {
                        Connection coniKey = null;
//                        coniKey = dbCon.getConAdminVo(request);
                        Statement stmtiKey = coniKey.createStatement();
                        ResultSet rsltiKey = null;
                        request.getSession().setAttribute("ikeysn", ikeysn);
                        if (request.getParameter("new_LOGIN") != null && !request.getParameter("new_LOGIN").equals("")) {
                            String UN2 = "";
                            String CN2 = request.getParameter("CN");
                            String CN = CN2.toLowerCase();
                            CN = CN.replaceAll("қ", "к");
                            CN = CN.replaceAll("ғ", "г");
                            CN = CN.replaceAll("ў", "у");
                            CN = CN.replaceAll("ҳ", "х");
                            CN = CN.replaceAll("'", "");
                            if (CN.length() > 100) CN = CN.substring(100);

                            rsltiKey = stmtiKey.executeQuery("select um.id, um.name " +
                                    "from ADMIN_VO.usermain um " +
                                    "where um.login = '" + request.getParameter("new_LOGIN") + "' and um.isdeleted=0 and um.REGION_ID='" + request.getParameter("new_LOC") + "'");
                            if (rsltiKey.next()) {
                                UN2 = rsltiKey.getString("name");
                                String UN = UN2.toLowerCase();
                                UN = UN.replaceAll("ў", "у");
                                if (CN.equals(UN)) {
                                    err1 = true;
                                } else {
                                    err1 = false;
                                    request.getSession().setAttribute("error.exception", "Неверный пользователь (ЭЦП: " + CN2 + ", ЕАИС: " + UN2 + ")");
                                }
                            } else {
                                err1 = false;
                                request.getSession().setAttribute("error.exception", "Неверный LOGIN");
                            }
                            if (err1) {
                                PreparedStatement psql = coniKey.prepareStatement("insert into uniconvo.certificates " +
                                        "(serial_number, cn, c, o, sn, st, validfrom, validto, issuer_serial_number, state, user_login, user_location_id, ikeysn, inn, pnfl, certificate) values " +
                                        "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                                psql.clearParameters();
                                psql.setString(1, request.getParameter("SERIALNUMBER"));
                                psql.setString(2, request.getParameter("CN"));
                                psql.setString(3, request.getParameter("C"));
                                psql.setString(4, request.getParameter("O"));
                                psql.setString(5, request.getParameter("SN"));
                                psql.setString(6, request.getParameter("ST"));
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                                psql.setDate(7, new java.sql.Date(sdf.parse(request.getParameter("VALIDFROM")).getTime()));
                                psql.setDate(8, new java.sql.Date(sdf.parse(request.getParameter("VALIDTO")).getTime()));
                                psql.setString(9, request.getParameter("SERIALNUMBER"));
                                psql.setInt(10, 1);
                                psql.setString(11, request.getParameter("new_LOGIN"));
                                psql.setString(12, request.getParameter("new_LOC"));
                                psql.setString(13, request.getParameter("ClientName"));
                                psql.setString(14, request.getParameter("INN"));
                                psql.setString(15, request.getParameter("PNFL"));
                                byte[] buf = new org.apache.commons.codec.binary.Base64().decode(request.getParameter("cert").getBytes());
                                psql.setBytes(16, buf);
                                psql.executeUpdate();
                                psql.close();
                                psql = coniKey.prepareStatement("insert into uniconvo.eri_usr_log " +
                                        "(id, oper, docs, ins_usr) values " +
                                        "(?,  ?,    ?,    ?)");
                                psql.clearParameters();
                                psql.setString(1, request.getParameter("SERIALNUMBER"));
                                psql.setString(2, "crt_eri");
                                psql.setString(3, request.getParameter("new_Docs"));
                                psql.setString(4, request.getRemoteAddr());
                                psql.executeUpdate();
                                psql.close();
                            }
                        }
                        if (err1) {
                            rsltiKey = stmtiKey.executeQuery("select SERIAL_NUMBER, USER_LOGIN, " +
                                    "case when validto<'01.01.2011' then -1 else days(validto) - days(current date) end exp_days, " +
                                    "ikeysn, char(validto,eur) validto, certificate, INN " +
                                    "from uniconvo.certificates " +
                                    "where SERIAL_NUMBER = '" + request.getParameter("SERIALNUMBER") + "' and state=1");
                            if (!rsltiKey.next()) {
                                request.getSession().removeAttribute("go_user_id");
                                request.getSession().removeAttribute("user_eri_list");
                                request.getSession().removeAttribute("user_list_ps");
                                err1 = false;
                                request.getSession().setAttribute("error.exception", "Неверный USB ключ !");
                                rsltiKey.close();
                            } else {
                                request.getSession().setAttribute("SERIAL_NUMBER", rsltiKey.getString("SERIAL_NUMBER"));
                                uLogin = rsltiKey.getString("USER_LOGIN");

                                if (!ikeysn.equals(rsltiKey.getString("ikeysn"))) {
                                    err1 = false;
                                    request.getSession().setAttribute("error.exception", "Неверный USB ключ (bad serial_number)!");
                                }
                                request.getSession().setAttribute("exp_days", rsltiKey.getInt("exp_days"));
                                request.getSession().setAttribute("validto", rsltiKey.getString("validto"));
                                if (rsltiKey.getInt("exp_days") < 0) {
                                    request.getSession().setAttribute("error.exception", "<h2>Срок действия электронного ключа просрочен (срок до " + rsltiKey.getString("validto") + " г.)!</h2>");
                                    err1 = false;
                                }
                                serial_number = rsltiKey.getString("SERIAL_NUMBER");
                                certificate = new BASE64Encoder().encodeBuffer(rsltiKey.getBytes("certificate"));
                                certificate = certificate.replaceAll("\r\n", "");
                                rsltiKey.close();
                            }
                        }
                        stmtiKey.close();
                        coniKey.close();
                    } catch (Exception e) {
                        err1 = false;
                        request.getSession().setAttribute("error.exception", "Error 71: " + e.getMessage());
                        e.printStackTrace(System.out);
                    }
                if (err1) {
                    try {
                        String ERIerrorMessage = "";
//                        ERIerrorMessage = checkERI(certificate, data, signature);
                        ERIerrorMessage = checkERIexe(certificate, data, data_hash, signature);
                        if (!ERIerrorMessage.equals("")) {
                            err1 = false;
                            request.getSession().setAttribute("error.exception", "Error 7: " + ERIerrorMessage);
                        } else {
                            request.getSession().setAttribute("iKeyType", "new");
                            request.getSession().setAttribute("serialnumber", request.getParameter("SERIALNUMBER"));
                            System.out.println(this.getClass().getName() + " - ok - " + new java.util.Date().toString());
                        }
                    } catch (Exception e) {
                        err1 = false;
                        request.getSession().setAttribute("error.exception", "Error 8: Возникла неопределенная ошибка, попробуйте еще раз. " + e.getMessage());
                        System.out.println(this.getClass().getName() + " - " + e.getMessage() + " - " + new java.util.Date().toString());
                    }
                }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                int i = 0;
                Cookie[] Cookies = request.getCookies();
                for (i = 0; i < Cookies.length; i++) {
                    if (Cookies[i].getName().equals("iKeySerial")) {
                        ikeysn = Cookies[i].getValue();
                    }
                }
                if (err1) {
                    String sql = "select LOGIN, ISDELETED, CURRENT TIMESTAMP NNOW from ADMIN_VO.USERMAIN where LOGIN='" + uLogin + "'";
                    try {
                        Connection con = null; //dbCon.getConAdminVo(request);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        if (rs.next()) {
                            if (rs.getString("ISDELETED").equals("1")) {
                                request.getSession().setAttribute("error.exception", "Пользователь не активен !");
                            }
                            String login = rs.getString("LOGIN");
                            Timestamp UTstamp = rs.getTimestamp("NNOW");
                            request.getSession().setAttribute("LOGIN", login);
                            request.getSession().setAttribute("ULogin", login);
                            request.getSession().setAttribute("UTstamp", UTstamp);

                            String sqlStr110 = "select user_id, ipaddress, lastactiontime, ((lastactiontime + 30 minute - current_timestamp) / 100) as TimeForEnter  from ADMIN_VO.usersession  where    user_id = '" + login + "' and lastactiontime + 30 minute >= current_timestamp and isonline = 1 " + " order by " + "   lastactiontime desc " + " fetch first 1 rows only ";

                            rs.close();
                            rs = st.executeQuery(sqlStr110);
                            if ((rs.next()) &&
                                    (!rs.getString("ipaddress").equalsIgnoreCase(request.getRemoteAddr()))) {
                                err1 = false;
                                request.getSession().setAttribute("error.exception", "<br>Пользователь \"" + rs.getString("user_id") + "\" уже в системе. Вы сможете войти в систему через " + ((int) rs.getDouble("TimeForEnter") + 1) + " мин.");
                            }
                            rs.close();
                            if (err1)
                                try {
                                    String sqlStrNewSess = " insert into ADMIN_VO.usersession " +
                                            "(    USER_ID, ENTERTIME, LASTACTIONTIME, SESSIONID, IPADDRESS,    ISONLINE, ACTION_ID, IKEYSN  ) VALUES " +
                                            "(    '" + login + "', '" + toDB2(UTstamp) + "', '" + toDB2(UTstamp) + "', '" + request.getSession().getId() + "', '" + request.getRemoteAddr() + "', " + "   1, 0, '" + ikeysn + "' ) ";

                                    int iNewSess = st.executeUpdate(sqlStrNewSess);
                                    if (iNewSess != 1) {
                                        err1 = false;
                                        request.getSession().setAttribute("error.exception", "<br>Ошибка создания сессии пользователя (результат = " + iNewSess + ") !");
                                    }
                                } catch (Exception UserSessExp) {
                                    err1 = false;
                                    request.getSession().setAttribute("error.exception", "<br>UserSess TRY");
                                }

                            if (err1) {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                response.sendRedirect(request.getContextPath() + "/rights");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                bnUserParam bn = User(login, request, con);
                                if (bn != null) {
                                    request.getSession().setAttribute("user_id", bn.getUId());  // фойдаланувчи iD си
                                    request.getSession().setAttribute("user_name", bn.getUName());  /// ФОйдалаунвчи ФИО
                                    request.getSession().setAttribute("user_roleU", bn.getURoleSets());        /// ФОйдалаунвчи роли
                                    request.getSession().setAttribute("user_role_nameU", bn.getURoleName());        /// ФОйдалаунвчи роли
                                    request.getSession().setAttribute("action_role", bn.getUActionType());        /// ФОйдалаунвчи роли
                                    request.getSession().setAttribute("user_location", bn.getULocation()); /// ФОйдалаунвчи УГТК
                                    request.getSession().setAttribute("user_post", bn.getUPost());      /// ФОйдалаунвчи ПОСТ
                                    request.getSession().setAttribute("user_login", bn.getULogin());      /// ФОйдалаунвчи логини
                                    request.getSession().setAttribute("postNUMBER", bn.getUPNumber());   /// postNUMBER
                                    request.getSession().setAttribute("action_typem", bn.getUActionTypem());   /// postNUMBER

                                    Random rn = new Random();
                                    int maximum = 9999, minimum = 1000, randomNum = 0;
                                    int n = Math.abs(maximum - minimum + 1);
                                    int ii = rn.nextInt() % n;
                                    randomNum = minimum + ii;

                                    String user_id = ((String) request.getSession().getAttribute("user_id")).trim();
                                    SessionID = request.getSession().getId() + user_id + randomNum;
//                                    conLgot = dbCon.getconFirst(request);
                                    request.getSession().getServletContext().setAttribute("conLgot" + SessionID, conLgot);
                                    request.getSession().setAttribute("LOGTABLE_ID", SessionID);
                                    request.getSession().setAttribute("SessionID", SessionID);

                                    String IP = request.getRemoteAddr();
                                    String sqlstr = "insert into nlgot.log (ses_id, user_id, name, ip, enter, last) " +
                                            "values ('" + SessionID + "','" + bn.getUUser_Id().substring(2) + "','" + bn.getUName() + "','" + IP + "',current_timestamp,current_timestamp)";
                                    Statement sqlST = null;
                                    sqlST = conLgot.createStatement();
                                    sqlST.executeUpdate(sqlstr);
                                    request.getSession().setAttribute("LOGTABLE_ID", SessionID);
                                    request.getSession().setAttribute("SessionID", SessionID);
                                    sqlST.close();
//                                    if (bn.getURole() != 9 && bn.getURole() != 18) {
//                                        response.sendRedirect(request.getContextPath() + "/index12.jsp");
//                                    } else response.sendRedirect(request.getContextPath() + "/index12.jsp");
                                } else {
                                    request.getSession().setAttribute("error.exception", "Пользователь неактивен!");
                                    if (ikeysn != null && ikeysn.length() > 20)
                                        response.sendRedirect(request.getContextPath() + "/eKalitU.jsp" + param);
                                    else response.sendRedirect(request.getContextPath() + "/logo.jsp" + param);
                                }
                                request.getSession().setAttribute("UserBean", bn);


                                request.getSession().setAttribute("ULogin", bn.getULogin());
                                request.getSession().setAttribute("RemoteAddr", request.getRemoteAddr());

                                //System.out.println("/rights while 1 = " + new java.util.Date());
                                TreeMap role = bn.getURoleSets();
                                Set entr = role.entrySet();
                                Iterator it = entr.iterator();
                                while (it.hasNext()) {
                                    Map.Entry m = (Map.Entry) it.next();
                                    Object key = m.getKey();
                                    //System.out.println(key + " - " + role.get(key) + "\n");
                                }
                                HashMap rights = bn.getUActionTypem();
                                Set ent = rights.entrySet();
                                Iterator itr = ent.iterator();
                                //System.out.println("/rights while 2 = " + new java.util.Date());
                                while (itr.hasNext()) {
                                    Map.Entry m = (Map.Entry) itr.next();
                                    Object key = m.getKey();
                                    //System.out.println(key + " - " + rights.get(key) + "\n");
                                }
                                ArrayList dobav = bn.getUActionType();
                                i = 0;
                                //System.out.println("/rights while 3 = " + new java.util.Date());
                                while (i < dobav.size()) {
                                    HashMap dob = (HashMap) dobav.get(i);
                                    Set entd = dob.entrySet();
                                    Iterator itr1 = entd.iterator();
                                    //System.out.println("/rights while 4 = " + new java.util.Date());
                                    while (itr1.hasNext()) {
                                        Map.Entry m = (Map.Entry) itr1.next();
                                        Object key = m.getKey();
                                        //System.out.println(key + " - " + dob.get(key) + "\n");
                                    }
                                    i++;
                                }
                                //System.out.println("/common/general.jsp = " + new java.util.Date());
                                response.sendRedirect(request.getContextPath() + "/general_unicon.jsp");
//                                response.sendRedirect(request.getContextPath() + "/index12.jsp");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                response.sendRedirect(request.getContextPath() + "/rights");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            } else response.sendRedirect(request.getContextPath() + logon_jsp);
                        } else {
                            request.getSession().setAttribute("error.exception", "Данный пользователь не найден !");
                        }
                        st.close();
                        con.close();
                    } catch (Exception e) {
                        request.getSession().setAttribute("error.exception", "<br>" + e.getMessage());
                        response.sendRedirect(request.getContextPath() + logon_jsp);
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + logon_jsp + param);
                }
            } else {
                err1 = false;
                request.getSession().setAttribute("error.exception", "Ошибка сессий! Попробуйте войти ещё раз. " + str_dt1);
                request.getSession().setAttribute("SessionTimeout", "Yes");
                response.sendRedirect(request.getContextPath() + logon_jsp);
            }
        } else {
            request.getSession().setAttribute("error.exception", "Error 5: no USB !");
            response.sendRedirect(request.getContextPath() + logon_jsp + param);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("error.exception", "Error 404");
        response.sendRedirect(request.getContextPath() + "/logo.jsp");
    }

    public String checkERIexe(String userCerAlg1B64, String text, String textHash, String tsignData) throws Exception {
        String res = "";
        {
            ISignerCli isigner = new ISignerCli("C:\\ERI\\isignercli.exe");
            long huserCerAlg1 = 0; //user cer handle
            try {
                String digest = isigner.digest(text);
                String extractedSignatureAsBase64 = isigner.extractSignature(tsignData);
                if (!isigner.verifySignature(digest, userCerAlg1B64, extractedSignatureAsBase64))
                    res = "signature error";
            } catch (Exception e) {
                System.out.println(e.getMessage());
                res = e.getMessage();
                e.printStackTrace(System.out);
            } finally {
//                isigner.cerFree(huserCerAlg1);
            }
        }
        return res;
    }
}
