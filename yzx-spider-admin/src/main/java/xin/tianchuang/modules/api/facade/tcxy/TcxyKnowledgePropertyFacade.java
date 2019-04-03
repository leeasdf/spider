package xin.tianchuang.modules.api.facade.tcxy;

import java.util.List;

import xin.tianchuang.modules.api.bean.v1.RptTcxyCompanyCopyrightDTO;
import xin.tianchuang.modules.api.bean.v1.RptTcxyCompanySoftwareCopyrightDTO;
import xin.tianchuang.modules.api.bean.v1.RptTcxyPatentBaseDTO;

/**
 * 天床信用-知识产权
 * 
 * @author denghui
 *
 */
public interface TcxyKnowledgePropertyFacade {

	/**
	 * 专利信息
	 * 
	 * @param name
	 * @param creditCode
	 * @return
	 */
	List<RptTcxyPatentBaseDTO> getPatent(String name, String creditCode);

	/**
	 * 软件著作权
	 * 
	 * @param name
	 * @param creditCode
	 * @return
	 */
	List<RptTcxyCompanySoftwareCopyrightDTO> getCopyright(String name, String creditCode);

	/**
	 * 作品著作权
	 * 
	 * @param name
	 * @param creditCode
	 * @return
	 */
	List<RptTcxyCompanyCopyrightDTO> getCopyrightWorks(String name, String creditCode);

}
