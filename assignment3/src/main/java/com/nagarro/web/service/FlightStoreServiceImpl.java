package com.nagarro.web.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.web.dao.FlightStoreDao;

@Service("flightStoreService")
@Transactional
public class FlightStoreServiceImpl implements FlightStoreService {

	@Autowired
	public FlightStoreDao flightStoreDao;

	public void flightStore(String path) throws InterruptedException, IOException {
		flightStoreDao.flightStore(path);
	}

}
