/**
 * @author 李承骐-2021302959
 * 实现了{@code UserFormatter<Teacher>}，将{@link Teacher}类中的信息转化为下列中的一种
 * <p>1.纯文本</p>
 * <p>2.XML</p>
 * <p>3.HTML</p>
 *
 */
public class TeacherFormatter implements UserFormatter<Teacher> {
	/**
	 * 按照指定的格式将{@link Teacher}类转化为纯文本
	 */
	@Override
	public String formatPlainText(Teacher teacher) {
		if(teacher==null)
		{
			return null;
		}
		String result=
		"		student {\n"
		+ "			id : "+teacher.getId()+"\n"
		+ "			name : "+teacher.getName()+"\n"
		+ "			phoneNo : "+teacher.getPhoneNo()+"\n"
		+ "			email : "+teacher.getEmail()+"\n"
		+ "			teacherNo : "+teacher.getTeacherNo()+"\n"
		+ "			department : "+teacher.getDepartment()+"\n"
		+ "		}\n";
		return result;
	}
	/**
	 * 按照指定的格式将{@link Teacher}类转化为XML
	 */
	@Override
	public String formatXML(Teacher teacher) {
		String result="		<Teacher id=\""+teacher.getId()+
				" name=\""+teacher.getName()+
				" phoneNo=\""+teacher.getPhoneNo()+
				" email=\""+teacher.getEmail()+
				" teacherNo=\""+teacher.getTeacherNo()+
				" department=\""+teacher.getDepartment()+"/>\n";
		return result;
	}
	/**
	 * 按照指定的格式将{@link Teacher}类转化为HTML
	 */
	@Override
	public String formatHTML(Teacher teacher) {
		String result="			"+teacher.getId()+" "+teacher.getName()+" "+teacher.getPhoneNo()+" "
				+teacher.getEmail()+" "+teacher.getTeacherNo()+" "+teacher.getDepartment()+"<br>\n";
		return result;
	}

}
