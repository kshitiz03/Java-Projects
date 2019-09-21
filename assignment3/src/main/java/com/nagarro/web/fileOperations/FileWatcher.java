package com.nagarro.web.fileOperations;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileWatcher {
	public static boolean watcher(String dir) throws IOException, InterruptedException {
		Path faxFolder = Paths.get(dir);
		WatchService watchService = FileSystems.getDefault().newWatchService();
		faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE);

		boolean valid = true;
		do {
			WatchKey watchKey = watchService.take();

			for (WatchEvent event : watchKey.pollEvents()) {
				WatchEvent.Kind kind = event.kind();
				if (StandardWatchEventKinds.ENTRY_MODIFY.equals(event.kind())
						|| StandardWatchEventKinds.ENTRY_DELETE.equals(event.kind())
						|| StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
					String fileName = event.context().toString();
					System.out.println(event.kind()+" "+fileName);
					return true;
				}
			}
			valid = watchKey.reset();
			System.out.println(valid);
		} while (valid);
		
		return false;
	}
}