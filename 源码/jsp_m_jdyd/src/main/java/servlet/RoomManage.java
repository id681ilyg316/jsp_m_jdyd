package servlet;

import config.GCON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//@WebServlet(name = "RoomManage")
@WebServlet("/RoomManage")
public class RoomManage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String[] values = map.get("op");
        if (values[0].equals(GCON.SEARCH_ROOM)) {
            response.sendRedirect(request.getContextPath()+"/roomManagement/searchRoom.jsp");
        } else if (values[0].equals(GCON.ADD_ROOM)) {
            response.sendRedirect(request.getContextPath()+"/roomManagement/roomAdd.jsp?op=" + GCON.ADD_ROOM);
        } else if (values[0].equals(GCON.EDIT_ROOM)) {
            response.sendRedirect(request.getContextPath()+"/roomManagement/roomEdit.jsp?op=" + GCON.EDIT_ROOM);
        } else if (values[0].equals(GCON.DELETE_ROOM)) {
            response.sendRedirect(request.getContextPath()+"/roomManagement/roomDelete.jsp?op=" + GCON.DELETE_ROOM);
        }else if(values[0].equals(8)){
            System.out.println("要改变价格了");
            String newprice=map.get("newprice")[0];
            System.out.println(newprice);

        }
    }
}
