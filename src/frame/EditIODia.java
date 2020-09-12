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
import sqlTools.InputTools;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EditIODia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
// 默认是“取消"
	private boolean retValue = false;
	/**
	 * Create the dialog.  6-入库，7-出库
	 */
	public EditIODia(JFrame window,int d) {
		setBounds(230, 150, 357, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	//设置文本框
		text1 = new JTextField();
		text1.setBounds(138, 10, 136, 28);
		contentPanel.add(text1);
		text1.setColumns(10);
		text2 = new JTextField();
		text2.setBounds(138, 61, 136, 28);
		contentPanel.add(text2);
		text2.setColumns(10);
		text3 = new JTextField();
		text3.setColumns(10);
		text3.setBounds(138, 114, 136, 28);
		contentPanel.add(text3);
		text4 = new JTextField();
		text4.setColumns(10);
		text4.setBounds(138, 165, 136, 28);
		contentPanel.add(text4);
		text5 = new JTextField();
		text5.setColumns(10);
		text5.setBounds(138, 213, 136, 28);
		contentPanel.add(text5);
			
			
		JLabel label1 = new JLabel();
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(23, 10, 82, 26);
		JLabel label2 = new JLabel();
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(23, 63, 82, 22);
		JLabel label3 = new JLabel();
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(23, 116, 82, 22);
		JLabel label4 = new JLabel();
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setBounds(23, 167, 82, 22);
		JLabel label5 = new JLabel();
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setBounds(23, 215, 82, 22);
		if(d==6)
		{
			this.setTitle("入库编辑框");
			label1.setText("商品编号");
			label2.setText("供应商编号");
			label3.setText("商品进价");
			label4.setText("入库数量");
			label5.setText("入库时间");
		}
		else if(d==7)
		{
			this.setTitle("出库编辑框");
			label1.setText("商品编号");
			label2.setText("客户编号");
			label3.setText("商品售价");
			label4.setText("出库数量");
			label5.setText("出库时间");
		}
		contentPanel.add(label1);
		contentPanel.add(label2);
		contentPanel.add(label3);
		contentPanel.add(label4);
		contentPanel.add(label5);
			
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("确认");
			okButton.addActionListener((e)->{
				if (checkValid (d))
				{
					retValue = true; // 设置对话框 的返回值
					setVisible(false);// MyDialog.this.setVisible(false)
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
		
		
	/**
	 * 点击后返回当前时间
	 */
		text5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTime();
			}
		});
		
		text2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getId(d);
			}
		});

		text3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getPrice(d);
			}

		});
	}
	
	// 返回值为 true : 表示用户点了"确定"
		// 返回值为 false : 表示用户叉掉了窗口，或者点了”取消"
	public boolean exec()
		{
		// 显示窗口 ( 阻塞 ，直接对话框窗口被关闭)
		this.setVisible(true);
		return retValue;
		}
	
	private boolean checkValid(int d){
		switch(d)
		{
		case 6:{
			Input m = getInValue();
			if(m.getprovider_id().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "供应商编号不得为空!");
				return false;
			}
			if(m.getcommodities_id().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "商品编号不得为空!");
				return false;
			}
			
			return true;
		}
		case 7:{
			Output p=getOutValue();
			int x=0;
			List<Commodities> m=CommoditiesTools.Search(p.getcommodities_id());
			for(Commodities i:m)
			{
				x=i.getremain();
			}
			if(p.getclient_id().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "客户编号不得为空!");
				return false;
			}
			if(p.getcommodities_id().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "商品编号不得为空!");
				return false;
			}
			if(p.getOutputQuantities()>x)
			{
				JOptionPane.showMessageDialog(this, "库存不足！");
				return false;
			}
			
			return true;
		}
		default: return true;
		}
	}

	
//获取输入
	public Input getInValue() {
		Input c =new Input();
		c.setcommodities_id(text1.getText().trim());
		c.setprovider_id(text2.getText().trim());
		c.setmoney(Double.parseDouble(text3.getText().trim()));
		c.setquantities(Integer.parseInt(text4.getText().trim()));
		c.setInputTime(text5.getText().trim());
		return c;
	}
	public Output getOutValue() {
		Output c =new Output();
		c.setcommodities_id(text1.getText().trim());
		c.setclient_id(text2.getText().trim());
		c.setmoney(Double.parseDouble(text3.getText().trim()));
		c.setquantities(Integer.parseInt(text4.getText().trim()));
		c.setOutputTime(text5.getText().trim());
		return c;
	}
	
//设置初始值、编号不允许再编辑
	public void setInValue(Input c)
	{
		text1.setEditable(false); 
		text2.setEditable(false); 
		text5.setEditable(false); 
		text1.setText(c.getcommodities_id());
		text2.setText(c.getprovider_id());
		text3.setText(String.valueOf(c.getInputMoney()));
		text4.setText(String.valueOf(c.getInputQuantities()));
		text5.setText(String.valueOf(c.getInputTime()));
	}
	public void setOutValue(Output c)
	{
		text1.setEditable(false); 
		text2.setEditable(false); 
		text5.setEditable(false); 
		text1.setText(c.getcommodities_id());
		text2.setText(c.getclient_id());
		text3.setText(String.valueOf(c.getOutputMoney()));
		text4.setText(String.valueOf(c.getOutputQuantities()));
		text5.setText(String.valueOf(c.getOutputTime()));
	}
	
	
//点击第五个框返回时间
	private void getTime()
	{
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String timestr=sdf.format(new Date());
		text5.setText(timestr);
	}
	
//点击第二个框返回供应商或客户编号
	private void getId(int d)
	{
		switch(d)
		{
		case 6:{
			String pi=null;
			String id=text1.getText().trim();
			List<Commodities> c=CommoditiesTools.Search(id);
			for(Commodities i:c)
			{
				pi=i.getcpid();
			}
			text2.setText(pi);
			break;
		}
		case 7:{
			String pi=null;
			String id=text1.getText().trim();
			List<Commodities> c=CommoditiesTools.Search(id);
			for(Commodities i:c)
			{
				pi=i.getccid();
			}
			text2.setText(pi);
			break;
		}
		}
	}

	private void getPrice(int d) {
		switch(d)
		{
		case 6:{
			double p=0;
			String id=text1.getText().trim();
			List<Commodities> c=CommoditiesTools.Search(id);
			for(Commodities i:c)
			{
				p=i.getinmoney();
			}
			text3.setText(String.valueOf(p));
			break;
		}
		case 7:{
			double p=0;
			String id=text1.getText().trim();
			List<Commodities> c=CommoditiesTools.Search(id);
			for(Commodities i:c)
			{
				p=i.getoutmoney();
			}
			text3.setText(String.valueOf(p));
			break;
		}
		}
		
	}
}

