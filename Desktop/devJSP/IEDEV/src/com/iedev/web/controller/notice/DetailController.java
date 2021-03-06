package com.iedev.web.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iedev.web.entity.Notice;
import com.iedev.web.service.NoticeService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));

		NoticeService service = new NoticeService();
		Notice notice = service.getInfo(no);
		
		Notice noticeNext = new Notice(); 
		noticeNext = service.getNextNotice(no);
		
		Notice noticePrev = new Notice();
		noticePrev = service.getPrevNotice(no);
		
		service.updateViews(no);
		
		req.setAttribute("n", notice);
		req.setAttribute("next", noticeNext);
		req.setAttribute("prev", noticePrev);
		
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
}
