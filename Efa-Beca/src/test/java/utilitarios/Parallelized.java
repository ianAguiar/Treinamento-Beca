package utilitarios;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.Parameterized;
import org.junit.runners.model.RunnerScheduler;

public class Parallelized extends Parameterized {
	private static class ThreadPoolScheduler implements RunnerScheduler {
		private ExecutorService executor;
		//Escolher quantos testes em paralelo pode rodar
		public ThreadPoolScheduler() {
			String threads;
			if (System.getProperty("feature") == null)
				threads = System.getProperty("junit.parallel.threads", "1");
			else
				threads = System.getProperty("junit.parallel.threads", "1");
			
			int numThreads = Integer.parseInt(threads);
			executor = Executors.newFixedThreadPool(numThreads);
		}

		@Override   
		public void finished() {
			executor.shutdown();
			try {
				executor.awaitTermination(10, TimeUnit.MINUTES);
			} catch (InterruptedException exc) {
				throw new RuntimeException(exc);
			}
		}

		@Override
		public void schedule(Runnable childStatement) {
			executor.submit(childStatement);
		}
	}

	public Parallelized(Class<?> klass) throws Throwable {
		super(klass);
		setScheduler(new ThreadPoolScheduler());
	}
}

