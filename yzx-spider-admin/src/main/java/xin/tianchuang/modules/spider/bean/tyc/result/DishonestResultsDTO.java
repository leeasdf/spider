package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.DishonestDTO;

public class DishonestResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1371544065919882572L;


	private List<DishonestDTO> dishonestResults;

	public List<DishonestDTO> getDishonestResults() {
		return dishonestResults;
	}

	public void setDishonestResults(List<DishonestDTO> dishonestResults) {
		this.dishonestResults = dishonestResults;
	}

}
