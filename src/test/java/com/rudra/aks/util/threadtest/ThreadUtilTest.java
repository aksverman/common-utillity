package com.rudra.aks.util.threadtest;

import org.junit.Test;

import com.rudra.aks.util.thread.ExecutorServiceUtil;
import com.rudra.aks.util.thread.ThreadPoolUtil;


public class ThreadUtilTest  {

	
	
	@Test
	public void runExecutorTest() {
		
		Runnable task1 = ()-> System.out.println("Thread : " + Thread.currentThread().getName());
		ExecutorServiceUtil.getThread().submit(task1);
	
	}
	
	@Test
	public static void	runThreadPoolTest() {
		
		class ThreadTest1 extends ThreadPoolUtil {

			@Override
			public void doTask() {
				System.out.println("--" + Thread.currentThread().getName() + " : " + ThreadPoolUtil.local.get().toString());
				ThreadPoolUtil.local.set("Thread 1 value");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					System.err.println("Exception : " + ie.getMessage());
				}
				
				System.out.println("--" + Thread.currentThread().getName() + " : " + ThreadPoolUtil.local.get().toString());

			}	
			
		}
		
		ThreadTest1 test1 = new ThreadTest1();
		ThreadTest1 test2 = new ThreadTest1();
		Thread t1 = new Thread(test1);
		Thread t2 = new Thread(test2);
		
		t1.start();
		t2.start();
		
		
	}
	
	
	
}






/*extends TaskExecutor {

	public static void main(String[] args) {
		TaskExecutor executor = new TaskExecutor();
		executor.runTask(executor);
		
	}

	@Override
	public void doTask() {
		// TODO Auto-generated method stub
		super.doTask();
	}

	class ThreadInnerClassTest extends ThreadPoolUtil{
			
			private ThreadLocal<Object> local = new ThreadLocal<Object>();
			public ThreadInnerClassTest(Object value) {
				super(value);
				local.set(value);
			}
			@Override
			public void doTask() {
				System.out.println(Thread.currentThread().getName());
				if("thread local Value".equals(local.get())) {
					System.out.println("Modifying---");
					local.set("new value");
				}
				
				System.out.println(local.get());
				
			}
		}

}*/
