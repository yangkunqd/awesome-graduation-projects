/*
 * JSP generated by Resin-3.0.8 (built Tue, 08 Jun 2004 02:25:40 PDT)
 */

package _jsp._web._2;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class _index__jsp extends com.caucho.jsp.JavaPage{
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.Application _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = com.caucho.jsp.QJspFactory.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true);
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html;charset=gb2312");
    request.setCharacterEncoding("GB2312");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      Connection con;
Statement stmt;
ResultSet rs;
Class.forName("com.mysql.jdbc.Driver");
DriverManager.registerDriver(new com.mysql.jdbc.Driver());
String dbUrl="jdbc:mysql://localhost:3306/laba?useUnicode=true&characterEncoding=GB2312";
String dbUser="root";
String dbPwd="1982o7o9";
con=java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
stmt=con.createStatement();

      out.write(_jsp_string1, 0, _jsp_string1.length);
      
String webname="\u4f01\u5bcc\u7f51"                              ; 
String WebUrl="http://www.qifo.com"                  ;
String serverEmail="finaler@163.com"                 ;
String servetel="13543040545"                        ;
String webfax=" 0756-2000000"                        ;
String webCompany="\u4f01\u5bcc\u6709\u9650\u516c\u53f8"                     ;
String address="\u5e7f\u4e1c\u7701\u73e0\u6d77\u5e02\u91d1\u9f0e"        ;
String webpost="519000"                              ;
String pat="1000\u5143\u4eba\u6c11\u5e01"                            ;
String QQ="6955125"                                   ;
String adminname="\u6881\u5148\u751f"                            ;
String ver="V1.0\u7248"                                  ;
String banzu="finaler"                               ;
String banzuid="2"                               ;

      out.write(_jsp_string1, 0, _jsp_string1.length);
      String memid = (String)request.getParameter("id");
rs=stmt.executeQuery("SELECT * from qyml where id='"+memid+"'");
rs.next();

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print((rs.getString("qymc")));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print((rs.getString("qymc")));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print((rs.getString("id")));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print((rs.getString("id")));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print((rs.getString("id")));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print((rs.getString("id")));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((rs.getString("id")));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((rs.getString("qymc")));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print((rs.getString("address")));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print((rs.getString("email")));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print((rs.getString("email")));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print((rs.getString("tel")));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      out.print((rs.getString("username")));
      out.write(_jsp_string15, 0, _jsp_string15.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      com.caucho.jsp.QJspFactory.freePageContext(pageContext);
    }
  }

  private com.caucho.java.LineMap _caucho_line_map;
  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.make.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    _caucho_depends.add(depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.util.CauchoSystem.getVersionId() != 1174304630)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.make.Dependency depend;
      depend = (com.caucho.make.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public com.caucho.java.LineMap _caucho_getLineMap()
  {
    return _caucho_line_map;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.java.LineMap lineMap,
                   com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    _caucho_line_map = new com.caucho.java.LineMap("_index__jsp.java", "foo");
    _caucho_line_map.add("/web/2/../../conn/conn.jsp", 6, 32);
    _caucho_line_map.add("/web/2/../../config.jsp", 1, 44);
    _caucho_line_map.add("/web/2/index.jsp", 4, 61);
    _caucho_line_map.add(8, 66);
    _caucho_line_map.add(98, 68);
    _caucho_line_map.add(132, 70);
    _caucho_line_map.add(133, 72);
    _caucho_line_map.add(134, 74);
    _caucho_line_map.add(135, 76);
    _caucho_line_map.add(136, 78);
    _caucho_line_map.add(139, 80);
    _caucho_line_map.add(141, 82);
    _caucho_line_map.add(142, 84);
    _caucho_line_map.add(142, 86);
    _caucho_line_map.add(143, 88);
    _caucho_line_map.add(145, 90);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("web/2/index.jsp"), "r6qUOY5YJ/wNUvAjeHaRXA==", false);
    _caucho_depends.add(depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("conn/conn.jsp"), "Y8eOeqaPTEc4uE5RVs4RUg==", false);
    _caucho_depends.add(depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("config.jsp"), "uTjCkERpwQB6EB72/3S7Cg==", false);
    _caucho_depends.add(depend);
  }

  private final static char []_jsp_string15;
  private final static char []_jsp_string4;
  private final static char []_jsp_string1;
  private final static char []_jsp_string0;
  private final static char []_jsp_string7;
  private final static char []_jsp_string10;
  private final static char []_jsp_string11;
  private final static char []_jsp_string12;
  private final static char []_jsp_string14;
  private final static char []_jsp_string6;
  private final static char []_jsp_string13;
  private final static char []_jsp_string2;
  private final static char []_jsp_string9;
  private final static char []_jsp_string3;
  private final static char []_jsp_string5;
  private final static char []_jsp_string8;
  static {
    _jsp_string15 = "\")</script></DIV></BODY></HTML>\r\n".toCharArray();
    _jsp_string4 = "</font></B></P></TD></TR></TBODY></TABLE></CENTER></DIV>\r\n<DIV align=center>\r\n<CENTER>\r\n<TABLE height=386 cellSpacing=0 cellPadding=0 width=777 border=0>\r\n  <TBODY>\r\n  <TR>\r\n    <TD width=417 height=35><IMG height=109 src=\"images/76.gif\" width=419 \r\n      border=0></TD>\r\n    <TD width=360 height=35><IMG height=109 src=\"images/75.gif\" width=361 \r\n      border=0></TD></TR>\r\n  <TR>\r\n    <TD width=417 height=1>\r\n      <P align=center><IMG height=80 src=\"images/74.gif\" width=419 \r\n      border=0></P></TD>\r\n    <TD width=360 height=1><IMG height=80 src=\"images/73.gif\" width=361 \r\n      border=0></TD></TR>\r\n\r\n\r\n\r\n  <TR>\r\n    <TD width=417 height=1><IMG height=113 src=\"images/71.gif\" width=419 \r\n      border=0></TD>\r\n    <TD width=360 height=1><IMG height=113 src=\"images/70.gif\" width=361 \r\n      border=0></TD></TR>\r\n  <TR>\r\n    <TD width=775 colSpan=2 height=30>      <P align=left>\u3000\u3000\u3000\u3000\u3000\u3000<script language=\"javascript\"> \r\ndocument.write( \r\n\"<font color=#000000> \", \r\ntoday.getYear(),\"\u5e74\", \r\ntoday.getMonth()+1,\"\u6708\", \r\ntoday.getDate(),\"\u65e5 \", \r\nd[today.getDay()+1], \r\n\"</font>\" ); </script>\u3000\u3000\u3000\r\n      <span class=\"style1\"><B><A \r\n            href=\"corporation_web.jsp?id=".toCharArray();
    _jsp_string1 = "\r\n".toCharArray();
    _jsp_string0 = "\r\n\r\n<link rel=\"stylesheet\" href=\"../conn/laba.css\" type=\"text/css\">\r\n\r\n\r\n\r\n".toCharArray();
    _jsp_string7 = "\" class=\"style2\"><B>\u4f9b\u6c42\u4fe1\u606f</B></A>\u3000\u3000<A \r\n            href=\"job.jsp?id=".toCharArray();
    _jsp_string10 = "</font><SPAN style=\"FONT-SIZE: 12px\"><FONT \r\ncolor=#ffffff> </FONT></SPAN><SPAN style=\"FONT-SIZE: 12px\"><FONT \r\ncolor=#ffffff>-".toCharArray();
    _jsp_string11 = "</FONT></SPAN><SPAN style=\"FONT-SIZE: 12px\"><FONT \r\ncolor=#ffffff><BR>\u5ba2\u6237\u670d\u52a1:</FONT></SPAN><a href=\"mailto:".toCharArray();
    _jsp_string12 = "\"><font color=\"#FFFFFF\">".toCharArray();
    _jsp_string14 = "</font></P>   </TD></TR></TBODY></TABLE></CENTER>\r\n<script src=\"../../in.js\"></script>\r\n<script>showImg(\"".toCharArray();
    _jsp_string6 = "\" class=\"style2\"><B>\u4ea7\u54c1\u4ecb\u7ecd</B></A>\u3000\u3000<A \r\n            href=\"syjh.jsp?id=<".toCharArray();
    _jsp_string13 = "</a></font><SPAN style=\"FONT-SIZE: 12px\"><FONT \r\ncolor=#ffffff>&nbsp; \u8054\u7cfb\u7535\u8bdd:</FONT></SPAN><font face=\"Arial\" color=\"#FFFFFF\">".toCharArray();
    _jsp_string2 = "\r\n<HTML><HEAD><TITLE><".toCharArray();
    _jsp_string9 = "\" class=\"style2\"><B>\u8054\u7cfb\u6211\u4eec</B></A></B></span></P></TD></TR>\r\n  <TR>\r\n    <TD width=775 colSpan=2 height=54>\r\n    <P align=center><font color=\"#FFFFFF\">".toCharArray();
    _jsp_string3 = "</TITLE>\r\n<META http-equiv=Content-Type content=\"text/html; charset=gb2312\"><LINK \r\nhref=\"images/style.css\" type=text/css rel=stylesheet><BGSOUND src=\"\"><BGSOUND \r\nsrc=\"\">\r\n<META content=\"MSHTML 6.00.2800.1106\" name=GENERATOR>\r\n<style type=\"text/css\">\r\n<!--\r\n.style2 {color: #000000}\r\n.style3 {\r\n	color: #FFCC00;\r\n	font-weight: bold;\r\n}\r\n-->\r\n</style>\r\n<script language=JavaScript>\r\n<!--\r\ntoday=new Date();\r\nfunction initArray(){\r\nthis.length=initArray.arguments.length\r\nfor(var i=0;i<this.length;i++)\r\nthis[i+1]=initArray.arguments[i] }\r\nvar d=new initArray(\r\n\"\u661f\u671f\u65e5\",\r\n\"\u661f\u671f\u4e00\",\r\n\"\u661f\u671f\u4e8c\",\r\n\"\u661f\u671f\u4e09\",\r\n\"\u661f\u671f\u56db\",\r\n\"\u661f\u671f\u4e94\",\r\n\"\u661f\u671f\u516d\");\r\nfunction MM_preloadImages() { //v3.0\r\nvar d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();\r\nvar i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)\r\nif (a[i].indexOf(\"#\")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}\r\n}\r\nfunction MM_findObj(n, d) { //v4.01\r\nvar p,i,x; if(!d) d=document; if((p=n.indexOf(\"?\"))>0&&parent.frames.length) {\r\nd=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}\r\nif(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];\r\nfor(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);\r\nif(!x && d.getElementById) x=d.getElementById(n); return x;\r\n}\r\nfunction MM_nbGroup(event, grpName) { //v3.0\r\nvar i,img,nbArr,args=MM_nbGroup.arguments;\r\nif (event ==\"init\" && args.length > 2) {\r\nif ((img = MM_findObj(args[2])) != null && !img.MM_init) {\r\nimg.MM_init = true; img.MM_up = args[3]; img.MM_dn = img.src;\r\nif ((nbArr = document[grpName]) == null) nbArr = document[grpName] = new Array();\r\nnbArr[nbArr.length] = img;\r\nfor (i=4; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {\r\nif (!img.MM_up) img.MM_up = img.src;\r\nimg.src = img.MM_dn = args[i+1];\r\nnbArr[nbArr.length] = img;\r\n} }\r\n} else if (event ==\"over\") {\r\ndocument.MM_nbOver = nbArr = new Array();\r\nfor (i=1; i < args.length-1; i+=3) if ((img = MM_findObj(args[i])) != null) {\r\nif (!img.MM_up) img.MM_up = img.src;\r\nimg.src = (img.MM_dn && args[i+2]) ? args[i+2] : args[i+1];\r\nnbArr[nbArr.length] = img;\r\n}\r\n} else if (event ==\"out\" ) {\r\nfor (i=0; i < document.MM_nbOver.length; i++) {\r\nimg = document.MM_nbOver[i]; img.src = (img.MM_dn) ? img.MM_dn : img.MM_up; }\r\n} else if (event ==\"down\") {\r\nif ((nbArr = document[grpName]) != null)\r\nfor (i=0; i < nbArr.length; i++) { img=nbArr[i]; img.src = img.MM_up; img.MM_dn = 0; }\r\ndocument[grpName] = nbArr = new Array();\r\nfor (i=2; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {\r\nif (!img.MM_up) img.MM_up = img.src;\r\nimg.src = img.MM_dn = args[i+1];\r\nnbArr[nbArr.length] = img;\r\n} }\r\n}\r\n//-->\r\n</script>\r\n</HEAD>\r\n<BODY leftMargin=0 background=images/83.gif topMargin=10>\r\n<DIV id=Layer2 \r\nstyle=\"Z-INDEX: 2; LEFT: 126px; WIDTH: 391px; POSITION: absolute; TOP: 110px; HEIGHT: 148px\">\r\n<TABLE cellPadding=1 width=\"75%\" border=0>\r\n  <TBODY>\r\n  <TR>\r\n    <TD><EMBED src=images/937.swf width=486 height=215 wmode=\"transparent\"> \r\n  </TD></TR></TBODY></TABLE></DIV>\r\n<DIV align=center>\r\n<CENTER>\r\n<TABLE height=58 cellSpacing=0 cellPadding=0 width=777 border=0>\r\n  <TBODY>\r\n  <TR>\r\n    <TD width=\"100%\" height=58>\r\n      <P align=center><B><font style='width=100%; position: relative; filter: glow(color=#000000, strength=4); font-size:18pt; ' color=\"#FFFFFF\" face=\"\u96b6\u4e66\">".toCharArray();
    _jsp_string5 = "\" class=\"style3\">\u516c\u53f8\u7b80\u4ecb</A>\u3000\u3000<A \r\n            href=\"spzs.jsp?id=".toCharArray();
    _jsp_string8 = "\" class=\"style2\"><B>\u62db\u8058\u4fe1\u606f</B></A>\u3000\u3000<A \r\n            href=\"mail.jsp?id=".toCharArray();
  }
}
