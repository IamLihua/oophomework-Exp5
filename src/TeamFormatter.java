
/**
 * 使用了策略模式
 * @author 李承骐-2021302959
 * 将{@link Team}转化为对应格式的字符串
 */
public interface TeamFormatter {
	/**
	 * @param team 要转化的team
	 * @return 对应格式的字符串
	 */
	public String formatTeam(Team team);
}
