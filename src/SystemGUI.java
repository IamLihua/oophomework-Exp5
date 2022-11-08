import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SystemGUI {
	private Frame frame;
	private TextArea teamInfoShower;
	private Button button_load;
	private JComboBox<String> comboBox_teamChooser;
	private Button button_txt;
	private Button button_HTML;
	private Button button_XML;
	private UserSubSystem sys;
	public SystemGUI(UserSubSystem sys) {
		super();
		this.sys = sys;
		frame = new Frame("UserSubSystem");
		Panel p_north = new Panel();
		frame.setLayout(new BorderLayout());
		frame.add(p_north,BorderLayout.NORTH);
		p_north.setLayout(new GridLayout(2,1));
		teamInfoShower=new TextArea();
		frame.add(teamInfoShower,BorderLayout.CENTER);
		Panel p_menu=new Panel();
		Panel p_buttonField=new Panel();
		p_north.add(p_menu);
		p_north.add(p_buttonField);
		p_menu.setLayout(new GridLayout(1,4));
		p_buttonField.setLayout(new GridLayout(1,3));
		button_load=new Button("Load Data");
		comboBox_teamChooser=new JComboBox<>();
		
		JLabel blank1=new JLabel();
		JLabel blank2=new JLabel();
		p_menu.add(button_load);
		p_menu.add(blank1);
		p_menu.add(blank2);
		p_menu.add(comboBox_teamChooser);
		
		button_txt =new Button("Display Team by Plain Text");
		button_txt.setEnabled(false);
		button_HTML=new Button("Display Team by HTML");
		button_HTML.setEnabled(false);
		button_XML=new Button("Display Team by XML");
		button_XML.setEnabled(false);
		
		p_buttonField.add(button_txt);
		p_buttonField.add(button_HTML);
		p_buttonField.add(button_XML);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void init()
	{
		// 关闭按钮
		frame.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(1);
            }
		});
		
		// txt formatter选择按钮
		button_txt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys.setTeamFormatter(PlainTextTeamFormatter.getSingletonInstance());
				showTeamInfo();
				System.out.println("txt formatter selected");
			}
		});
		button_txt.setFont(new Font("console",3,12));
		button_txt.setForeground(Color.black);
		//button_txt.setBackground(Color.orange);
		
		// HTML formatter选择按钮
		button_HTML.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys.setTeamFormatter(HTMLTeamFormatter.getSingletonInstance());
				showTeamInfo();
				System.out.println("HTML formatter selected");
			}
		});
		button_HTML.setFont(new Font("console",3,12));
		button_HTML.setForeground(Color.black);
		//button_HTML.setBackground(Color.gray);
		
		// XML formatter选择按钮
		button_XML.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys.setTeamFormatter(XMLTeamFormatter.getSingletonInstance());
				showTeamInfo();
				System.out.println("XML formatter selected");
			}
		});
		button_XML.setFont(new Font("console",3,12));
		button_XML.setForeground(Color.black);


		
		// load data按钮
		button_load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys.loadTeam();
				if(sys.getTeamList().isEmpty())
				{
					teamInfoShower.setText("please check the content or file path of the dat!");
					return;
				}
				button_HTML.setEnabled(true);
				button_XML.setEnabled(true);
				button_txt.setEnabled(true);
				ArrayList<Team> teams=sys.getTeamList();
				for(Team team:teams)
				{
					comboBox_teamChooser.addItem(team.getTeamId());
				}
				button_load.setEnabled(false);
 				System.out.println("load data");
			}
		});
		button_load.setBackground(Color.lightGray);
		button_load.setFont(new Font("console",1,12));
		
		comboBox_teamChooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showTeamInfo();
				
			}
		});
		comboBox_teamChooser.setForeground(Color.red);
		teamInfoShower.setFont(new Font("console",1,10));
		//teamInfoShower.setForeground(Color.red);
	}
	
	private void showTeamInfo()
	{
		if(this.sys.getTeamFormatter()==null)
		{
			return;
		}
		Team selectedTeam=this.sys.getTeamList().get(comboBox_teamChooser.getSelectedIndex());
		String txt=this.sys.getTeamFormatter().formatTeam(selectedTeam);
		this.teamInfoShower.setText(txt);
	}
}
