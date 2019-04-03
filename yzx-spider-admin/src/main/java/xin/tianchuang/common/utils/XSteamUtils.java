package xin.tianchuang.common.utils;

import xin.tianchuang.modules.spider.bean.hnaic.HnaicCmsbResult;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class XSteamUtils {

	private static String XML_TAG = "<?xml version='1.0' encoding='UTF-8'?>";

	/**
	 * Description: 私有化构造
	 */
	private XSteamUtils() {
		super();
	}

	/**
	 * @Description 为每次调用生成一个XStream
	 * @Title getInstance
	 * @return
	 */
	private static XStream getInstance() {
		XStream xStream = new XStream(new DomDriver("UTF-8")) {
			/**
			 * 忽略xml中多余字段
			 */
			@Override
			protected MapperWrapper wrapMapper(MapperWrapper next) {
				return new MapperWrapper(next) {
					@SuppressWarnings("rawtypes")
					@Override
					public boolean shouldSerializeMember(Class definedIn, String fieldName) {
						if (definedIn == Object.class) {
							return false;
						}
						return super.shouldSerializeMember(definedIn, fieldName);
					}
				};
			}
		};

		// 设置默认的安全校验
		XStream.setupDefaultSecurity(xStream);
		// 使用本地的类加载器
		xStream.setClassLoader(XSteamUtils.class.getClassLoader());
		// 允许所有的类进行转换
		xStream.addPermission(AnyTypePermission.ANY);
		return xStream;
	}

	public static <T> T xmlToObj(String xml, Class<T> clazz) {
		XStream xstream = new XStream();
		xstream.setClassLoader(clazz.getClassLoader());
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypes(new Class[] { clazz });
		// xstream.autodetectAnnotations(true);
		xstream.processAnnotations(clazz);
		Object xmlObject = xstream.fromXML(xml);
		T obj = clazz.cast(xmlObject);
		return obj;
	}

	/**
	 * @Description 将java对象转化为xml字符串
	 * @Title beanToXml
	 * @param object
	 * @return
	 */
	public static String beanToXml(Object object) {
		XStream xStream = getInstance();
		xStream.processAnnotations(object.getClass());
		// 剔除所有tab、制表符、换行符
		String xml = xStream.toXML(object).replaceAll("\\s+", " ");
		return xml;
	}

	/**
	 * @Description 将java对象转化为xml字符串（包含xml头部信息）
	 * @Title beanToXml
	 * @param object
	 * @return
	 */
	public static String beanToXmlWithTag(Object object) {
		String xml = XML_TAG + beanToXml(object);
		return xml;
	}

}
