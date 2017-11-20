package com.rudra.aks.util.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceUtil {

	
	
	public static ExecutorService getThread() {
		 return  Executors.newSingleThreadExecutor();
	}

	
	
}
