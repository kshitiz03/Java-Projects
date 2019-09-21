package com.nagarro.web.dao;

import java.io.IOException;

public interface FlightStoreDao {
	void flightStore(String path) throws InterruptedException, IOException;
}
