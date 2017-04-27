package com.kaishengit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Message;
import com.kaishengit.service.TimelineService;

@WebServlet("/timeline")
public class TimelineServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maxId = req.getParameter("maxId");
		
		int id = 0;
		if(StringUtils.isNumeric(maxId)){
			id = Integer.parseInt(maxId);
		}
		
		TimelineService timelineService = new TimelineService();
		
		List<Message> messageList = timelineService.findByMaxId(id);
		render(messageList,resp);
	}

}
