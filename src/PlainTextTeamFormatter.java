
/**
 * @author 李承骐-2021302959
 * 实现了{@link TeamFormatter}接口，并运用了单例模式
 * <p>{@link Team}格式化为纯文本</p>
 */
public class PlainTextTeamFormatter implements TeamFormatter {
	private static PlainTextTeamFormatter singletonInstance;
	
	/**
	 * 获取本类的单例，若无，则构造一个
	 * @return 本类的单例
	 */
	public static PlainTextTeamFormatter getSingletonInstance() {
		if(singletonInstance==null)
		{
			singletonInstance=new PlainTextTeamFormatter();
		}
		return singletonInstance;
	}
	
	/**
	 * private构造函数，防止被外部访问
	 */
	private PlainTextTeamFormatter() {
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
		String tmp=
				"Team {\n"
				+ "	teamId : "+team.getTeamId()+"\n"
				+ "	teamName : "+team.getTeamName()+"\n"
				+ "	department : "+team.getDepartment()+"\n"
				+ new CreatorFormatter().formatPlainText(team.getCreator())
				+"	studentList {\n";
		StringBuilder result=new StringBuilder(tmp);
		for(Student student:team.getStudentList())
		{
			result.append(new StudentFormatter().formatPlainText(student));
		}
		result.append("	}\n	teacherList {\n");
		for(int i=0;i<team.getTeacherList().size();i++)
		{
			result.append(new TeacherFormatter().formatPlainText(team.getTeacherList().get(i)));
		}
		result.append("	}\n}");
		return result.toString();
	}

}
