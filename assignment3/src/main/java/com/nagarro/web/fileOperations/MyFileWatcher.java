package com.nagarro.web.fileOperations;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFileWatcher
{
    public static boolean watcher(String path) throws IOException, InterruptedException
    {
    	return FileWatcher.watcher(path);
    }


}
