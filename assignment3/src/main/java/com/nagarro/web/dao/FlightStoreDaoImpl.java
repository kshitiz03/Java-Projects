package com.nagarro.web.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nagarro.web.fileOperations.FileWatcher;
import com.nagarro.web.fileOperations.MyFileWatcher;
import com.nagarro.web.fileOperations.ReadFiles;
import com.nagarro.web.model.Flight;

@Repository("flightStoreDao")

public class FlightStoreDaoImpl extends AbstractDao<Integer, Flight> implements FlightStoreDao {

	@Override
	public void flightStore(String path) throws InterruptedException, IOException {
		File folder = new File(path);
		System.out.println(folder);
		File[] listoffiles = folder.listFiles();
//		if (MyFileWatcher.watcher(path)) {
			getSession().createQuery("delete from Flight").executeUpdate();
			for (int i = 0; i < listoffiles.length; i++) {
				ReadFiles r = new ReadFiles(listoffiles[i]);
				try {
					List<Flight> flights = r.fill();

					for (Flight flight : flights) {
						getSession().persist(flight);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
//	}

}
