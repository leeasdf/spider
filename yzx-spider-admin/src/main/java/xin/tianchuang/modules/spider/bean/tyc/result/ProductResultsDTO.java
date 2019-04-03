package xin.tianchuang.modules.spider.bean.tyc.result;

import java.util.List;


import xin.tianchuang.modules.spider.bean.tyc.dto.ProductDTO;

public class ProductResultsDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3270021562051442551L;


	private List<ProductDTO> productResults;

	public List<ProductDTO> getProductResults() {
		return productResults;
	}

	public void setProductResults(List<ProductDTO> productResults) {
		this.productResults = productResults;
	}

}
