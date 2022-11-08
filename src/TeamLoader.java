import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TeamLoader {
	private String filePath;
	private ArrayList<Team> teamList=new ArrayList<Team>();

	public TeamLoader(String filePath) {
		super();
		this.filePath = filePath;
	}
	
	public ArrayList<Team> loadTeam()
	{
		File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if(tempString.length()==0)
                {
                	continue;
                }
                String[] inputStrings=tempString.split("_");
                String teamId=inputStrings[1];
                String teamName=inputStrings[2];
                String department=inputStrings[3];
                Team team=null;
                Student creator=null;
                Student student=null;
                Teacher teacher=null;
                for(int i=0;i<inputStrings.length;i++)
                {
                	if(inputStrings[i].equals("Creator"))
                	{
                		Boolean gender=true;
                		if(inputStrings[i+6].equals("男"))
                		{
                			gender=false;
                		}
                		creator=new Student(inputStrings[i+1],inputStrings[i+2],inputStrings[i+3],inputStrings[i+4],inputStrings[i+5],gender,inputStrings[i+7],inputStrings[i+8]);
                		team=new Team(teamId, teamName, department, creator);
                		
                	}
                	if(inputStrings[i].equals("Student"))
                	{
                		Boolean gender=true;
                		if(inputStrings[i+6].equals("男"))
                		{
                			gender=false;
                		}
                		student=new Student(inputStrings[i+1],inputStrings[i+2],inputStrings[i+3],inputStrings[i+4],inputStrings[i+5],gender,inputStrings[i+7],inputStrings[i+8]);
                		team.addStudent(student);
                	}
                	if(inputStrings[i].equals("Teacher"))
                	{
                		
                		teacher=new Teacher(inputStrings[i+1],inputStrings[i+2],inputStrings[i+3],inputStrings[i+4],inputStrings[i+5],inputStrings[i+6]);
                		team.addTeacher(teacher);
                	}
                }
                teamList.add(team);
            }
            reader.close();
        } catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog( null,"please check if the file path is correct!");
        	
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	JOptionPane.showMessageDialog( null,"please check if the file content is correct!");
			e.printStackTrace();
		}

		return teamList;
	}
}
