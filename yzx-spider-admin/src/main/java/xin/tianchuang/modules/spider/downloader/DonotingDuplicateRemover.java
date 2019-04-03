package xin.tianchuang.modules.spider.downloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.Scheduler;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

public class DonotingDuplicateRemover implements Scheduler, DuplicateRemover {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean isDuplicate(Request request, Task task) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetDuplicateCheck(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalRequestsCount(Task task) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void push(Request request, Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Request poll(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

}
