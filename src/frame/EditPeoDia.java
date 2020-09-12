package frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entities.*;

public class EditPeoDia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	// 默认是“取消"
	private boolean retValue = false;

	/**
	 * Create the dialog.
	 */
	public EditPeoDia(JFrame window,int d) {
		setTitle("人员编辑框");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(230, 150, 340, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			text1 = new JTextField();
			text1.setBounds(111, 10, 136, 21);
			contentPanel.add(text1);
			text1.setColumns(10);
		}
		{
			text2 = new JTextField();
			text2.setBounds(111, 52, 136, 21);
			contentPanel.add(text2);
			text2.setColumns(10);
		}
		{
			text3 = new JTextField();
			text3.setBounds(111, 92, 136, 21);
			contentPanel.add(text3);
			text3.setColumns(10);
		}
		{
			JLabel label1 = new JLabel("编号");
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setBounds(34, 13, 67, 18);
			contentPanel.add(label1);
		}
		{
			JLabel label2 = new JLabel("姓名");
			label2.setHorizontalAlignment(SwingConstants.CENTER);
			label2.setBounds(34, 55, 67, 18);
			contentPanel.add(label2);
		}
		{
			JLabel label3 = new JLabel();
			label3.setHorizontalAlignment(SwingConstants.CENTER);
			label3.setBounds(34, 95, 67, 18);
			if(d==1) label3.setText("密码");
			else label3.setText("电话");
			contentPanel.add(label3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确认");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (checkValid (d))
						{
							retValue = true; // 设置对话框 的返回值
							setVisible(false);// MyDialog.this.setVisible(false)
						}
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	// 返回值为 true : 表示用户点了"确定"
	// 返回值为 false : 表示用户叉掉了窗口，或者点了”取消"
	public boolean exec()
		{
		// 显示窗口 ( 阻塞 ，直接对话框窗口被关闭)
		this.setVisible(true);
		return retValue;
		}
	
	
	private boolean checkValid(int x) {
		switch(x)
		{
		case 1:{
			Manager m = getMValue();
			if(m.getid().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "编号不得为空!");
				return false;
			}
			if(m.getname().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "姓名不得为空!");
				return false;
			}
			if(m.getPassword().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "密码不得为空!");
				return false;
			}
			
			return true;
		}
		case 2:{
			Provider p=getPValue();
			if(p.getid().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "编号不得为空!");
				return false;
			}
			if(p.getname().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "姓名不得为空!");
				return false;
			}
			
			return true;
		}
		case 3:{
			Client c=getCValue();
			if(c.getid().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "编号不得为空!");
				return false;
			}
			if(c.getname().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "姓名不得为空!");
				return false;
			}
			
			return true;
		}
		default: return true;
		}
	}
	
//添加时需要
	public Client getCValue() {
		Client c =new Client();
		c.setid(text1.getText().trim());
		c.setname(text2.getText().trim());
		c.setphone(text3.getText().trim());
		return c;
	}

	public Provider getPValue() {
		Provider p =new Provider();
		p.setid(text1.getText().trim());
		p.setname(text2.getText().trim());
		p.setphone(text3.getText().trim());
		return p;
	}

	public Manager getMValue()
	{
		Manager m = new Manager();
		m.setID(text1.getText().trim());
		m.setName(text2.getText().trim());
		m.setPassword(text3.getText().trim());
		return m;
	}
	
//设置初始值、编号不允许再编辑
	public void setMValue(Manager m)
	{
		text1.setEditable(false); 
		text1.setText(m.getid());
		text2.setText(m.getname());
		text3.setText(m.getPassword());
	}
	public void setPValue(Provider p)
	{
		text1.setEditable(false);
		text1.setText(p.getid());
		text2.setText(p.getname());
		text3.setText(p.getphone());
	}
	public void setCValue(Client c)
	{
		text1.setEditable(false);
		text1.setText(c.getid());
		text2.setText(c.getname());
		text3.setText(c.getphone());
	}
}
