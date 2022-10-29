<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.pfs.mp3.dao.CourseMasterDao" %>
<%@ page import="com.pfs.mp3.entity.CourseMaster" %>

<%
   CourseMasterDao dao = new CourseMasterDao();
   CourseMaster cm = new CourseMaster();
   ResultSet rs = null;
%>

<%
try {
    rs = dao.fetch();
%>
    <h1>View Courses</h1>
    <table border = "1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Text</th>
            <th>Delete?</th>
            <th>Update</th>
        </tr>
    <%
        while(rs.next()) {
    %>

        <tr>
            <td><%=rs.getString("Course_Id")%></td>
            <td><%=rs.getString("Course_Name")%></td>
            <td><%=rs.getString("Course_Text")%></td>
            <td><a href="course_delete.jsp?id=<%=rs.getString("Course_Id")%>">Delete</a></td>

            <td><form action="course_update.jsp">
                    <input type=hidden name="course_id" id="course_id" value="<%=rs.getString("Course_Id")%>">
                    <label for="course_name">Course Name</label>
                    <input type="text" name="course_name" id="course_name" required><br>
                    <label for="course_text">Course Text</label>
                    <input type="text" name="course_text" id="course_text" required><br>

                     <button type="submit">Update</button>
                </form>
            </td>
        </tr>
    <%
    }
    %>
    </table>
<%
} catch (ClassNotFoundException ex) {
    out.println(ex.getMessage());
} catch (SQLException e) {
    out.println(e.getMessage());

}
%>

<h2>Delete Course</h2>
<form action="course_delete.jsp">
    <label for="id">Enter the Course Id to be deleted</label>
    <input type="text" name="id" id="id"><br>
    <button type="submit">Delete</button>
</form>


<a href="course.html">Back to Course Master</a>
<form action="course_view.jsp">
    <button type="submit">View Courses</button>
</form>