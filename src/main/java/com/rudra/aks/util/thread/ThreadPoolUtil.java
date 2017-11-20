package com.rudra.aks.util.thread;

public abstract class ThreadPoolUtil implements Runnable {
	
	protected static ThreadLocal<Object>  local = new ThreadLocal<Object>() {

		@Override
		protected Object initialValue() {
			return "thread initial value";
		}
		
	};
	
	public ThreadPoolUtil() {
		super();
	}

	public ThreadPoolUtil(Object local) {
		super();
		ThreadPoolUtil.local.set(local);
	}
	
	
	@Override
	public void run() {
		doTask();
	}


	public abstract void doTask();
	
		
	public Object getLocal() {
		return local.get();
	}

	public void setLocal(Object local) {
		ThreadPoolUtil.local.set(local);
	}
	
}
