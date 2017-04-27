package com.kaishengit.service;

import java.util.List;

import com.kaishengit.dao.TimelineDao;
import com.kaishengit.entity.Message;

public class TimelineService {
	
	private TimelineDao timelineDao = new TimelineDao();

	public List<Message> findByMaxId(int maxId) {
		return timelineDao.findByMaxId(maxId);
	}

	public List<Message> findAll(){
		return timelineDao.findAll();
	}

}
