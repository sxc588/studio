import org.quartz.SchedulerConfigException;
import org.quartz.spi.ThreadPool;

public class MyThreadPool implements ThreadPool {

	@Override
	public int blockForAvailableThreads() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPoolSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void initialize() throws SchedulerConfigException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean runInThread(Runnable runnable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInstanceId(String schedInstId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInstanceName(String schedName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutdown(boolean waitForJobsToComplete) {
		// TODO Auto-generated method stub

	}

}
