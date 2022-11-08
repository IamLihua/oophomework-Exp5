
/**
 * @author 李承骐-2021302959
 * 实现了{@code UserFormatter<Student>}，将{@link Student}类中的信息转化为下列中的一种
 * <p>1.纯文本</p>
 * <p>2.XML</p>
 * <p>3.HTML</p>
 *
 */
public class StudentFormatter implements UserFormatter<Student> {

	/**
	 * 按照指定的格式将{@link Student}类转化为纯文本
	 */
	@Override
	public String formatPlainText(Student student) {
		if(student==null)
		{
			return null;
		}
		String result=
				"		student {\n"
				+ "			id : "+student.getId()+"\n"
				+ "			name : "+student.getName()+"\n"
				+ "			phoneNo : "+student.getPhoneNo()+"\n"
				+ "			email : "+student.getEmail()+"\n"
				+ "			studentNo : "+student.getStudentNo()+"\n"
				+ "			gender : "+student.getGender()+"\n"
				+ "			grade : "+student.getGrade()+"\n"
				+ "			department : "+student.getDepartment()+"\n"
				+ "		}\n";
		return result;
	}
	
	/**
	 * 按照指定的格式将{@link Student}类转化为XML
	 */
	@Override
	public String formatXML(Student student) {
		String result="		<Student id=\""+student.getId()+
				" name=\""+student.getName()+
				" phoneNo=\""+student.getPhoneNo()+
				" email=\""+student.getEmail()+
				" studentNo=\""+student.getStudentNo()+
				" gender=\""+student.getGender()+
				" grade=\""+student.getGrade()+
				" department=\""+student.getDepartment()+"/>\n";
		return result;
	}
	
	/**
	 * 按照指定的格式将{@link Student}类转化为HTML
	 */
	@Override
	public String formatHTML(Student student) {
		String result="			"+student.getId()+" "+student.getName()+" "+student.getPhoneNo()+" "+student.getEmail()
		+" "+student.getStudentNo()+" "+student.getGender()+" "+student.getGrade()+" "+student.getDepartment()+"<br>\n";
		return result;
	}

}
