package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.ShareholdersDTO;

public class ShareholderResultsDTO extends BaseTycResultsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2595435661193590621L;


	private List<ShareholdersDTO> shareholderResults;

	public List<ShareholdersDTO> getShareholderResults() {
		return shareholderResults;
	}

	public void setShareholderResults(List<ShareholdersDTO> shareholderResults) {
		this.shareholderResults = shareholderResults;
	}

}
