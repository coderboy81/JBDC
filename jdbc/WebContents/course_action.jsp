<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.pfs.mp3.dao.CourseMasterDao"%>
<%@ page import="com.pfs.mp3.entity.CourseMaster"%>


<%
    String courseName = request.getParameter("course_name");
    String courseText = request.getParameter("course_text");
    out.println (courseName);
    out.println (courseText);
%>

<%
    CourseMasterDao dao = new CourseMasterDao();
    CourseMaster cm = new CourseMaster();
    int rowsAffected;
    try {
        cm.setName(courseName);
        cm.setText(courseText);

        rowsAffected = dao.insert(cm);
        out.println("No of rows affected - " + rowsAffected);
    } catch (ClassNotFoundException ex) {
        out.println( ex.getMessage());

    } catch (SQLException e){
        out.println(e.getMessage());

    }
%>