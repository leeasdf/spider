package xin.tianchuang.common.utils.generator;



public class BizNoCreateUtil {


	private static final String SYSTEM_CODE = "P";
	
	/**
	 * 创建
	 * @param bizNoType
	 * @return
	 */
	public static String createBizNo(BizNoType bizNoType){
		return FlowNoGenerator.generate(SYSTEM_CODE,bizNoType.name());
	}
	
	public enum BizNoType{
		/**
		 * 企业
		 */
		ENT("企业");
		String value;

		private BizNoType(String value) {
			this.value = value;
		}
	}
}
