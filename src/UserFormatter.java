
/**
 * @author 李承骐-2021302959
 * 此接口用于实现各个{@link User}类转化为{@link String}
 * <p>转换格式有：</p>
 * <p>1.纯文本</p>
 * <p>2.XML</p>
 * <p>3.HTML</p>
 * @param <T> User类的子类
 * @see Student
 * @see Teacher
 */
public interface UserFormatter<T extends User> {
	/**
	 * 将User转化为纯文本
	 * @param user 要转化的User
	 * @return 转化成的纯文本格式字符串
	 */
	public String formatPlainText(T user);
	/**
	 * 将User转化为XML
	 * @param user 要转化的User
	 * @return 转化成的XML格式字符串
	 */
	public String formatXML(T user);
	/**
	 * 将User转化为XML
	 * @param user 要转化的User
	 * @return 转化成的HTML格式字符串
	 */
	public String formatHTML(T user);
}
