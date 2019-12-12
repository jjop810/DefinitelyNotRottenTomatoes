package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Shows;
import com.revature.data.ShowsDAO;

@Service
public class ShowsService {

	@Autowired
	private ShowsDAO sd;
	
	public Shows getShow(String name) {
		return sd.getShow(name);
	}
	
	public Shows getShow(Shows show) {
		return sd.getShow(show);
	}
	
	public Shows getShowById(Shows show) {
		return sd.getShowById(show);
	}
	
	public int addShow(Shows show) {
		return sd.addShow(show);
	}
	
	public void updateShow(Shows show) {
		sd.updateShow(show);
	}
	
	
}
