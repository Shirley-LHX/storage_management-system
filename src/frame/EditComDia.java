package frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.*;
import sqlTools.CommoditiesTools;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class EditComDia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
	private JTextField text6;
	private JTextField text7;
	private JTextField text8;
// Ĭ���ǡ�ȡ��"
	private boolean retValue = false;

	/**
	 * Create the dialog. 4-��Ʒ��5-�̿�
	 */
	public EditComDia(JFrame window,int d) { 
		setBounds(230, 150, 358, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	//�����ı��༭��
		text1 = new JTextField();
		text1.setBounds(135, 14, 151, 21);
		text1.setColumns(10);
		text2 = new JTextField();
		text2.setBounds(135, 45, 151, 21);
		text2.setColumns(10);
		text3 = new JTextField();
		text3.setBounds(135, 76, 151, 21);
		text3.setColumns(10);
		text4 = new JTextField();
		text4.setBounds(135, 107, 151, 21);
		text4.setColumns(10);
		text5 = new JTextField();
		text5.setColumns(10);
		text5.setBounds(135, 138, 151, 21);
		text6 = new JTextField();
		text6.setColumns(10);
		text6.setBounds(135, 169, 151, 21);
		text7 = new JTextField();
		text7.setColumns(10);
		text7.setBounds(135, 200, 151, 21);
		text8 = new JTextField();
		text8.setColumns(10);
		text8.setBounds(135, 231, 151, 21);
		contentPanel.add(text1);
		contentPanel.add(text2);
		contentPanel.add(text3);
		contentPanel.add(text4);
		contentPanel.add(text5);
		contentPanel.add(text6);
		contentPanel.add(text7);
		contentPanel.add(text8);
		
	//���ñ�ǩ
		JLabel label1 = new JLabel();
		label1.setBounds(42, 14, 75, 21);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label2 = new JLabel();
		label2.setBounds(42, 45, 75, 21);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label3 = new JLabel();
		label3.setBounds(42, 76, 75, 21);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label4 = new JLabel();
		label4.setBounds(42, 107, 75, 21);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label5 = new JLabel();
		label5.setBounds(42, 138, 75, 21);
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label6 = new JLabel();
		label6.setBounds(42, 169, 75, 21);
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label7 = new JLabel();
		label7.setBounds(42, 200, 75, 21);
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label8 = new JLabel();
		label8.setBounds(42, 231, 75, 21);
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		if(d==4)
		{
			this.setTitle("��Ʒ�༭��");
			label1.setText("��Ʒ���");
			label2.setText("��Ӧ�̱��");
			label3.setText("�ͻ����");
			label4.setText("��Ʒ����");
			label5.setText("��Ʒ����");
			label6.setText("��Ʒ����");
			label7.setText("��Ʒ�ۼ�");
			label8.setText("��Ʒ�ܿ��");
		}
		else if(d==5)
		{
			this.setTitle("�̿�༭��");
			label1.setText("��Ʒ���");
			label2.setText("��Ʒ����");
			label3.setText("��Ʒ����");
			label4.setText("���������");
			label5.setText("��Ʒ�ۼ�");
			label6.setText("�ܳ�������");
			label7.setText("��Ʒʣ��");
			label8.setText("��Ʒ����");
		}
		contentPanel.add(label1);
		contentPanel.add(label2);
		contentPanel.add(label3);
		contentPanel.add(label4);
		contentPanel.add(label5);
		contentPanel.add(label6);
		contentPanel.add(label7);
		contentPanel.add(label8);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("ȷ��");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkValid (d))
					{
						retValue = true; // ���öԻ��� �ķ���ֵ
						setVisible(false);// MyDialog.this.setVisible(false)
					}
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("ȡ��");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
		
		if(d==5)
		{

			text2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String pi=null;
					String id=text1.getText().trim();
					List<Commodities> c=CommoditiesTools.Search(id);
					for(Commodities i:c)
					{
						pi=i.getname();
					}
					text2.setText(pi);
				}
			});
			text3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					double p=0;
					String id=text1.getText().trim();
					List<Commodities> c=CommoditiesTools.Search(id);
					for(Commodities i:c)
					{
						p=i.getinmoney();
					}
					text3.setText(String.valueOf(p));
				}
			});
			text5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					double p=0;
					String id=text1.getText().trim();
					List<Commodities> c=CommoditiesTools.Search(id);
					for(Commodities i:c)
					{
						p=i.getoutmoney();
					}
					text5.setText(String.valueOf(p));
				}
			});
			text7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int p=0;
					String id=text1.getText().trim();
					List<Commodities> c=CommoditiesTools.Search(id);
					for(Commodities i:c)
					{
						p=i.getremain();
					}
					text7.setText(String.valueOf(p));
				}
			});
			text8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					double p=0;
					String id=text1.getText().trim();
					int in=Integer.parseInt(text4.getText().trim());
					int ou=Integer.parseInt(text6.getText().trim());
					List<Commodities> c=CommoditiesTools.Search(id);
					for(Commodities i:c)
					{
						p=i.getoutmoney()*ou-i.getinmoney()*in;
					}
					text8.setText(String.valueOf(p));
				}
			});
		}
		
	}
	
	// ����ֵΪ true : ��ʾ�û�����"ȷ��"
	// ����ֵΪ false : ��ʾ�û�����˴��ڣ����ߵ��ˡ�ȡ��"
	public boolean exec()
		{
		// ��ʾ���� ( ���� ��ֱ�ӶԻ��򴰿ڱ��ر�)
		this.setVisible(true);
		return retValue;
		}
	
	private boolean checkValid(int d) {
		switch(d)
		{
		case 4:{
			Commodities m = getCoValue();
			if(m.getid().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "��Ʒ��Ų���Ϊ��!");
				return false;
			}
			if(m.getname().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "��Ʒ������Ϊ��!");
				return false;
			}
			if(m.getcpid().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "��Ӧ�̲���Ϊ��!");
				return false;
			}
			if(m.getccid().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "�ͻ�����Ϊ��!");
				return false;
			}
			
			return true;
		}
		case 5:{
			Check p=getChValue();
			if(p.getid().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "��Ų���Ϊ��!");
				return false;
			}
			if(p.getname().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "��������Ϊ��!");
				return false;
			}
			
			return true;
		}
		default: return true;
		}
	}
	
	
//���ʱ��Ҫ
	public Commodities getCoValue() {
		Commodities c =new Commodities();
		c.setid(text1.getText().trim());
		c.setcpid(text2.getText().trim());
		c.setccid(text3.getText().trim());
		c.setname(text4.getText().trim());
		c.settype(text5.getText().trim());
		c.setInmoney(Double.parseDouble(text6.getText().trim()));
		c.setOutmoney(Double.parseDouble(text7.getText().trim()));
		c.setremain(Integer.parseInt(text8.getText().trim()));
		return c;
	}
	
	public Check getChValue() {
		Check c =new Check();
		c.setid(text1.getText().trim());
		c.setname(text2.getText().trim());
		c.setinmon(Double.parseDouble(text3.getText().trim()));
		c.setinquan(Integer.parseInt(text4.getText().trim()));
		c.setoutmon(Double.parseDouble(text5.getText().trim()));
		c.setoutquan(Integer.parseInt(text6.getText().trim()));
		c.setremain(Integer.parseInt(text7.getText().trim()));
		c.setprofit(Double.parseDouble(text8.getText().trim()));
		return c;
	}
	
//���ó�ʼֵ����Ų������ٱ༭
	public void setCoValue(Commodities c)
	{
		text1.setEditable(false); 
		text2.setEditable(false); 
		text3.setEditable(false); 
		text1.setText(c.getid());
		text2.setText(c.getcpid());
		text3.setText(c.getccid());
		text4.setText(c.getname());
		text5.setText(c.gettype());
		text6.setText(String.valueOf(c.getinmoney()));
		text7.setText(String.valueOf(c.getoutmoney()));
		text8.setText(String.valueOf(c.getremain()));
	}
	public void setChValue(Check c)
	{
		text1.setEditable(false);
		text2.setEditable(false);
		text3.setEditable(false);
		text5.setEditable(false);
		text1.setText(c.getid());
		text2.setText(c.getname());
		text3.setText(String.valueOf(c.getinmoney()));
		text4.setText(String.valueOf(c.getinquantities()));
		text5.setText(String.valueOf(c.getoutmoney()));
		text6.setText(String.valueOf(c.getoutquantities()));
		text7.setText(String.valueOf(c.getremain()));
		text8.setText(String.valueOf(c.getprofit()));
	}
}
