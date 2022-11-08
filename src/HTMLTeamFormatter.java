/**
 * @author 李承骐-2021302959
 * 实现了{@link TeamFormatter}接口，并运用了单例模式
 * <p>{@link Team}格式化为HTML</p>
 */
public class HTMLTeamFormatter implements TeamFormatter {
	private static HTMLTeamFormatter singletonInstance;
	/**
	 * 获取本类的单例，若无，则构造一个
	 * @return 本类的单例
	 */
	public static HTMLTeamFormatter getSingletonInstance() {
		if(singletonInstance==null)
		{
			singletonInstance=new HTMLTeamFormatter();
		}
		return singletonInstance;
	}
	/**
	 * private构造函数，防止被外部访问
	 */
	private HTMLTeamFormatter() {
		super();
	}
	/**
	 *将{@link Team}格式化为指定格式
	 */
	@Override
	public String formatTeam(Team team) {
		if(team==null)
		{
			return null;
		}
		StringBuilder result=new StringBuilder();
		result.append("<html>\n");
		result.append("	<body>\n");
		result.append("		<center><h2>Team Information</h2></center>\n");
		result.append("		").append(team.getTeamId()).append(" "+team.getTeamName()).append(" "+team.getDepartment()).append("<br>\n");
		result.append(new CreatorFormatter().formatHTML(team.getCreator()));
		result.append("		<h3>StudentList</h3>\n");
		result.append("		<blockquote>\n");
		for(Student student:team.getStudentList())
		{
			result.append(new StudentFormatter().formatHTML(student));
		}
		result.append("		</blockquote>\n");
		result.append("		<blockquote>\n");
		for(Teacher teacher:team.getTeacherList())
		{
			result.append(new TeacherFormatter().formatHTML(teacher));
		}
		result.append("		</blockquote>\n");
		result.append("	</body>\n");
		result.append("</html>\n");

		return result.toString();
	}
	
	
}
