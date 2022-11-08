/**
 * @author 李承骐-2021302959
 * 实现了{@link TeamFormatter}接口，并运用了单例模式
 * <p>{@link Team}格式化为XML</p>
 */
public class XMLTeamFormatter implements TeamFormatter {
	private static XMLTeamFormatter singletonInstance;
	/**
	 * 获取本类的单例，若无，则构造一个
	 * @return 本类的单例
	 */
	public static XMLTeamFormatter getSingletonInstance() {
		if(singletonInstance==null)
		{
			singletonInstance=new XMLTeamFormatter();
		}
		return singletonInstance;
	}
	/**
	 * private构造函数，防止被外部访问
	 */
	private XMLTeamFormatter() {
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
		result.append("<Team teamId=\"").append(team.getTeamId()).append("\" teamName=\"").append(team.getTeamName()).append("\" department=\"").append(team.getDepartment()).append("\">\n");
		result.append(new CreatorFormatter().formatXML(team.getCreator()));
		result.append("	<StudentList>").append("\n");
		for(Student student:team.getStudentList())
		{
			result.append(new StudentFormatter().formatXML(student));
		}
		result.append("	</StudentList>").append("\n");
		result.append("	<TeacherList>").append("\n");
		for(Teacher teacher:team.getTeacherList())
		{
			result.append(new TeacherFormatter().formatXML(teacher));
		}
		result.append("	</TeacherList>").append("\n");
		result.append("</Team>").append("\n");
		return result.toString();
	}


}
