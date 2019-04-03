package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open421MortgageInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8438922659853873226L;
	private List<Open421MortgageInfoBaseInfoDTO> baseInfo;
	private List<Open421MortgageInfoChangeInfoListDTO> changeInfoList;
	private List<Open421MortgageInfoPawnInfoListDTO> pawnInfoList;
	private List<Open421MortgageInfoPeopleInfoDTO> peopleInfo;

	public List<Open421MortgageInfoBaseInfoDTO> getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(List<Open421MortgageInfoBaseInfoDTO> baseInfo) {
		this.baseInfo = baseInfo;
	}

	public List<Open421MortgageInfoChangeInfoListDTO> getChangeInfoList() {
		return changeInfoList;
	}

	public void setChangeInfoList(List<Open421MortgageInfoChangeInfoListDTO> changeInfoList) {
		this.changeInfoList = changeInfoList;
	}

	public List<Open421MortgageInfoPawnInfoListDTO> getPawnInfoList() {
		return pawnInfoList;
	}

	public void setPawnInfoList(List<Open421MortgageInfoPawnInfoListDTO> pawnInfoList) {
		this.pawnInfoList = pawnInfoList;
	}

	public List<Open421MortgageInfoPeopleInfoDTO> getPeopleInfo() {
		return peopleInfo;
	}

	public void setPeopleInfo(List<Open421MortgageInfoPeopleInfoDTO> peopleInfo) {
		this.peopleInfo = peopleInfo;
	}

}
