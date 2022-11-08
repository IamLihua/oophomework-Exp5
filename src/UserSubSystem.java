
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 用户子系统类
 *
 * @author "ChenJing"
 * @version 1.0
 *
 */
public class UserSubSystem {
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	//Team->ArrayList<Team>
	private ArrayList<Team> teamList;
	
	private TeamFormatter teamFormatter;

	/**
	 * Initialize instance variable team
	 */
	private UserSubSystem() {
		
	}

	/**
	 * Starts the application
	 *
	 * @param args 控制台传参
	 * @throws IOException 过程中的IO异常
	 */
	public static void main(String[] args) throws IOException {
		UserSubSystem userSubSystem = new UserSubSystem();
		userSubSystem.run();
	}

	/**
	 * Present the user with a menu of options and execute the selected task
	 *
	 * @throws IOException
	 */
	private void run() throws IOException {
		// TODO:
		SystemGUI sys=new SystemGUI(this);
		sys.init();
	}

	/**
	 * Change the current formatter by updating the instance variable teamFormatter
	 * with the object specified in the parameter formatter
	 *
	 * @param formatter
	 */
	public void setTeamFormatter(TeamFormatter formatter) {
		teamFormatter=formatter;
	}

	public ArrayList<Team> getTeamList() {
		return teamList;
	}

	public TeamFormatter getTeamFormatter() {
		return teamFormatter;
	}

	/**
	 * Display a menu of options and verifies the user's choice
	 *
	 * @return
	 * @throws IOException
	 */
	private int getChoice() throws IOException {
		//TODO 通过点击按钮确定选择 还要确定下拉框的选择
		int input;
		do {
			try {
				stdOut.println();
				stdOut.print("[0] Quit\n" + "[1] Display team (Plain Text)\n" + "[2] Display team (HTML)\n"
						+ "[3] Display team (XML)\n" + "choice> ");
				stdOut.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 3 >= input) {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}

	/**
	 * Initialize the team object
	 */
	public void loadTeam() {
		//TODO 从dat中加载数据
		this.teamList=new TeamLoader("team.dat").loadTeam();
	}

	/**
	 * Display the team information in the standard output using the method
	 * teamFormatter.formatTeam() to obtain the team information in the current
	 * format
	 */
	private void displayTeam() {
		//TODO 将teamFormatter.formatTeam(team)加载到文本框中
		
	}

}
