package com.pollsystem.soen387asg3pollsystem;

import com.pollsystem.daoimpl.PollDaoImpl;
import com.pollsystem.model.Poll;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/DownloadServlet")
public class downloadServlet extends HttpServlet {
    private static final int BYTES_DOWNLOAD = 1024;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String poll_id = (String) session.getAttribute("poll_id");
        PollDaoImpl pollDaoimpl = new PollDaoImpl();
        try{
            Poll cp = pollDaoimpl.getPoll(poll_id);
            String filename = cp.getTitle();
            //response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String new_filename = cp.download_Poll_Details(pw,filename);
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-disposition", "attachment;filename="+new_filename);
            pw.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}



