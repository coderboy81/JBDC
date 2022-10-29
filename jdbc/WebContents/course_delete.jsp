<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.pfs.mp3.dao.CourseMasterDao" %>
<%@ page import="com.pfs.mp3.entity.CourseMaster" %>


<%
    String id = request.getParameter("id");
%>
<%
    CourseMasterDao dao = new CourseMasterDao();
    int rowsDeleted;

    try{
        rowsDeleted = dao.remove(id);
        out.println("Rows Deleted: " + rowsDeleted + "</br>");

        if(rowsDeleted == 0) {
        } else {
            out.println("Course with ID" + id + "has been deleted");
        }
    } catch (ClassNotFoundException ex) {
         out.println(ex.getMessage());
    } catch (SQLException e) {
         out.println(e.getMessage());
    }
%>
<hr>
<a href="course.html">Back to Course Master</a>
<form action="course_view.jsp">
    <button type="submit">View Courses</button>
</form>