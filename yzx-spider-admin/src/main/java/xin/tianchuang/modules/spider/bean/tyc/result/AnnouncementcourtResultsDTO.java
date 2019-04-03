package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.AnnouncementcourtDTO;

public class AnnouncementcourtResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 308879678223621682L;


	private List<AnnouncementcourtDTO> announcementcourtResults;

	public List<AnnouncementcourtDTO> getAnnouncementcourtResults() {
		return announcementcourtResults;
	}

	public void setAnnouncementcourtResults(List<AnnouncementcourtDTO> announcementcourtResults) {
		this.announcementcourtResults = announcementcourtResults;
	}

}
