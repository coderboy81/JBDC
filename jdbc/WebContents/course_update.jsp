<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.pfs.mp3.dao.CourseMasterDao" %>
<%@ page import="com.pfs.mp3.entity.CourseMaster" %>


<%
    String id = request.getParameter("course_id");
    String courseName = request.getParameter("course_name");
    String courseText = request.getParameter("course_text");

%>

<h1>Course Updated</h1>

<%
    CourseMasterDao dao = new CourseMasterDao();
    CourseMaster cm =  new CourseMaster();
    int rowsUpdated;

    try {
        cm.setName(courseName);
        cm.setText(courseText);

        rowsUpdated = dao.update(cm, id);
        out.println("No. of rows updated: " + rowsUpdated +"<br>");

        if(rowsUpdated == 0) {
            out.println("Update failed.");
        } else {
            out.println("Updated Course: " + cm.getName() + " " + cm.getText());
        }
    } catch (ClassNotFoundException ex) {
        out.println(ex.getMessage());
    } catch (SQLException e) {
        out.println(e.getMessage());

    }
%>


<a href="course.html">Back to Course Master</a>
<form action="course_view.jsp">
    <button type="submit">View Courses</button>
</form>