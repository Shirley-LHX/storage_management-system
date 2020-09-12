package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.*;
import sqlTools.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;

public class ContentFrame extends JFrame {

	private JPanel contentPane=new JPanel();
	
	//设置菜单栏
	JMenuBar menuBar = new JMenuBar();
	JMenu Start = new JMenu("开始");
	JMenuItem help = new JMenuItem("帮助");
	JMenuItem end = new JMenuItem("退出");
	JMenu PeoManage = new JMenu("人员管理");
	JMenuItem man = new JMenuItem("管理员");
	JMenuItem pro = new JMenuItem("供应商");
	JMenuItem cli = new JMenuItem("客户");
	JMenu ComManage = new JMenu("商品管理");
	JMenuItem com = new JMenuItem("商品信息");
	JMenuItem in = new JMenuItem("入库信息");
	JMenuItem out = new JMenuItem("出库信息");
	JMenuItem chec = new JMenuItem("盘点信息");
	JPanel cards = new JPanel();
	Peopan people1 = new Peopan("密码",1);
	Peopan people2 = new Peopan("电话",2);
	Peopan people3 =new Peopan("电话", 3);
	Compan commo = new Compan(0);
	Compan che=new Compan(1);
	IOpan inp=new IOpan(true);
	IOpan outp=new IOpan(false);
	JPanel he = new JPanel();
	private final JButton addButton = new JButton("\u6DFB\u52A0");
	private final JButton delButton = new JButton("\u5220\u9664");
	JButton seButton = new JButton("\u67E5\u8BE2");
	JButton altButton = new JButton("\u4FEE\u6539");
	JButton profit=new JButton("计算盈亏数量");
	private JTextField searchField;
	
	int ctrl=1;  //用来记录卡片module
	private final JTextPane txtpnGb = new JTextPane();
	
	
	/**
	 * Create the frame.
	 */
	public ContentFrame() {
		setTitle("库存管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 100, 849, 533);
		setJMenuBar(menuBar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false); //不可最大化
		
		//添加菜单栏
		menuBar.add(Start);
		Start.add(help);
		Start.add(end);
		menuBar.add(PeoManage);
		PeoManage.add(man);
		PeoManage.add(pro);
		PeoManage.add(cli);
		menuBar.add(ComManage);
		ComManage.add(com);
		ComManage.add(in);
		ComManage.add(out);
		ComManage.add(chec);
		contentPane.setLayout(null);
		cards.setBounds(5, 103, 825, 365);
		//构造按钮
		addButton.setBounds(22, 35, 83, 23);
		contentPane.add(addButton);
		delButton.setBounds(213, 35, 83, 23);
		contentPane.add(delButton);
		searchField = new JTextField();
		searchField.setBounds(358, 36, 219, 22);
		contentPane.add(searchField);
		searchField.setColumns(10);
		seButton.setBounds(604, 35, 83, 23);
		contentPane.add(seButton);
		altButton.setBounds(117, 35, 83, 23);
		contentPane.add(altButton);
		
		//构造卡片布局
		cards.setLayout(new CardLayout());
		contentPane.add(cards);
		cards.add(people1,"管理员管理");
		cards.add(people2,"供应商管理");
		cards.add(people3,"客户管理");
		cards.add(commo,"商品管理");
		cards.add(inp,"入库管理");
		cards.add(outp,"出库管理");
		cards.add(che,"盘库管理");
		cards.add(he,"帮助");
		he.setLayout(null);
		txtpnGb.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		txtpnGb.setEditable(false);
		txtpnGb.setText("                \u6B22\u8FCE\u6765\u5230\u5E93\u5B58\u7BA1\u7406\u7CFB\u7EDF\uFF01\r\n\r\n\u5728\u4F7F\u7528\u65F6\u60A8\u9700\u8981\u6CE8\u610F\u4E00\u4E0B\u51E0\u70B9\uFF1A\r\n       1.\u5F53\u6DFB\u52A0\u5546\u54C1\u4FE1\u606F\u65F6\uFF0C\u9700\u8981\u6DFB\u52A0\u76D8\u70B9\u4FE1\u606F\u5E76\u5C06\u5176\u603B\u5165\u5E93\u3001\u603B\u51FA\u5E93\u6570\u91CF\u521D\u59CB\u5316\u4E3A0\u3002\r\n       2.\u5F53\u8FDB\u5165\u7F16\u8F91\u6846\u65F6\uFF0C\u7531\u4E8E\u57FA\u7840\u5C5E\u6027\u88AB\u5546\u54C1\u5B9A\u5236\uFF0C\u8FD8\u6709\u5165\u5E93\u51FA\u5E93\u65F6\u95F4\u90FD\u662F\u83B7\u53D6\u5F53\u5929\u65F6\u95F4\u3002\u5219\u5F88\u591A\u6587\u672C\u6846\u70B9\u51FB\u4EE5\u4E0B\u6846\u5C31\u4F1A\u663E\u793A\u51FA\u6570\u636E\uFF0C\u6CE8\u610F\u6709\u65F6\u70B9\u51FB\u4E0D\u7075\u654F\uFF0C\u591A\u70B9\u51E0\u6B21\u3002");
		txtpnGb.setBounds(136, 59, 535, 247);
		
		he.add(txtpnGb);
		
		// 初始界面
		CardLayout c=(CardLayout)cards.getLayout();
		c.show(cards, "帮助");
		
		//添加数据
		addButton.addActionListener((e)->{
			if(ctrl<=3)
				PeoOnAdd(ctrl);
			else if(ctrl>3&&ctrl<=5)
				ComOnAdd(ctrl);
			else if(ctrl>5&&ctrl<=7)
				IoOnAdd(ctrl);
		});
		
		//修改数据
		altButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnAlter(ctrl);
			}
		});
		
		//删除数据
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnDelete(ctrl);
			}
		});
		
		//查询
		seButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnSearch(ctrl);
			}
		});
		
	/**
	 * 
	 * 切换panel ctrl来记录是哪个panel
	 */
		man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl=1;
				CardLayout cl=(CardLayout)cards.getLayout();
				cl.show(cards, "管理员管理");
			    fillTable(ctrl);
			    profit.setEnabled(false);
			}
		});
		pro.addActionListener((e)->{
			ctrl=2;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "供应商管理");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		cli.addActionListener((e)->{
			ctrl=3;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "客户管理");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		
		com.addActionListener((e)->{
			ctrl=4;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "商品管理");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		
		in.addActionListener((e)->{
			ctrl=6;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "入库管理");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		
		out.addActionListener((e)->{
			ctrl=7;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "出库管理");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		
		chec.addActionListener((e)->{
			ctrl=5;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "盘库管理");
			fillTable(ctrl);
			profit.setBounds(700, 35, 83, 23);
			contentPane.add(profit);
			profit.setEnabled(true);
		});
		
		help.addActionListener((e)->{
			ctrl=8;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "帮助");
		});
		
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);  //退出程序
			}
		});
		profit.addActionListener((e)->{
			Countprofit();
		});
	}



/**
 * 
 * 添加功能  想要添加改变model 要变成模态
 */
//人员
	private void PeoOnAdd(int d) {
		EditPeoDia dlg=new EditPeoDia(this,d);
		dlg.setModal(true);  //阻塞
		if( dlg.exec() )  //注意加break
		{
			switch(d)
			{
			case 1:
			{
				Manager m =dlg.getMValue();
				ManagerTools.AddMan(m);
				people1.addMTableRow(m);	// 添加到 tableModel
				break;
			}
			case 2:
			{
				Provider p=dlg.getPValue();
				ProviderTools.AddPro(p);
				people2.addPTableRow(p);
				break;
			}
			case 3:
			{
				Client c=dlg.getCValue();
				ClientTools.AddCli(c);
				people3.addCTableRow(c);
				break;
			}
			}
		}
		
	}
//商品及盘点
	private void ComOnAdd(int d) {
		EditComDia dlg=new EditComDia(this,d);
		dlg.setModal(true);  //阻塞
		if( dlg.exec() )  //注意加break
		{
			switch(d)
			{
			case 4:
			{
				Commodities c =dlg.getCoValue();
				CommoditiesTools.AddCom(c);
				commo.addCoTableRow(c);	// 添加到 tableModel
				break;
			}
			case 5:
			{
				Check c=dlg.getChValue();
				CheckTools.AddChec(c);
				che.addChTableRow(c);
				break;
			}
			}
		}
	}
//入库出库添加
	private void IoOnAdd(int d) {
		EditIODia dlg=new EditIODia(this,d);
		dlg.setModal(true);  //阻塞
		if( dlg.exec() )  //注意加break
		{
			switch(d)
			{
			case 6:
			{
				Input c;
				c = dlg.getInValue();
				InputTools.AddInRecord(c);
				inp.addITableRow(c);	// 添加到 tableModel
			//更改商品中的库存
				List<Commodities> m=CommoditiesTools.Search(c.getcommodities_id());
				for(Commodities i:m)
				{
					i.ChangeRemain(1, c.getInputQuantities());
					CommoditiesTools.AlterRemain(i.getid(), i.getremain());
				}
				List<Check> n=CheckTools.Search(c.getcommodities_id());
				for(Check i:n)
				{
					i.ChangeRemain(1, c.getInputQuantities());
					CheckTools.AlterQuan(d,i.getid(), i.getinquantities());
					CheckTools.AlterRemain(i.getid(), i.getremain());
					CheckTools.AlterProfit(i.getid());
				}
				break;
			}
			case 7:
			{
				Output c;
				c = dlg.getOutValue();
				OutputTools.AddOutRecord(c);
				outp.addOTableRow(c);
			//更改商品中的库存
				List<Commodities> m=CommoditiesTools.Search(c.getcommodities_id());
				for(Commodities i:m)
				{
					i.ChangeRemain(0, c.getOutputQuantities());
					CommoditiesTools.AlterRemain(i.getid(), i.getremain());
				}
				List<Check> n=CheckTools.Search(c.getcommodities_id());
				for(Check i:n)
				{
					i.ChangeRemain(0, c.getOutputQuantities());
					CheckTools.AlterQuan(d,i.getid(),i.getoutquantities());
					CheckTools.AlterRemain(i.getid(), i.getremain());
					CheckTools.AlterProfit(i.getid());
				}
				break;
			}
			}
		}
	}

/**
 * 
 * 修改数据 
 */
	private void OnAlter(int d) {
		switch(d)
		{
		case 1:{
		int[] rows = people1.table.getSelectedRows();
		if(rows.length == 0)return;
		int row = rows[0];  // 只编辑选中的第一行
		Manager m = people1.getMTableRow(row);
		EditPeoDia dlg=new EditPeoDia(this, d);
		dlg.setModal(true);  //阻塞
		dlg.setMValue(m);
		if( dlg.exec())
		{
			Manager man=dlg.getMValue();
			ManagerTools.UpdateMan(man);
			people1.setMTableRow(man,row);
		}
		break;
		}
		case 2:{
		int[] rows = people2.table.getSelectedRows();
		if(rows.length == 0)return;
		int row = rows[0]; // 只编辑选中的第一行
		Provider p = people2.getPTableRow(row);
		EditPeoDia dlg=new EditPeoDia(this, d);
		dlg.setModal(true);  //阻塞
		dlg.setPValue(p);
		if( dlg.exec())
		{
			Provider man=dlg.getPValue();
			ProviderTools.UpdatePro(man);
			people2.setPTableRow(man,row);
		}
		break;
		}
		case 3:{
		int[] rows = people3.table.getSelectedRows();
		if(rows.length == 0)return;
		int row = rows[0]; // 只编辑选中的第一行
		Client p = people3.getCTableRow(row);
		EditPeoDia dlg=new EditPeoDia(this, d);
		dlg.setModal(true);  //阻塞
		dlg.setCValue(p);
		if( dlg.exec())
		{
			Client man=dlg.getCValue();
			ClientTools.UpdateCli(man);
			people3.setCTableRow(man,row);
		}
		break;
		}
		case 4:{
			int[] rows = commo.table.getSelectedRows();
			if(rows.length == 0)return;
			int row = rows[0]; // 只编辑选中的第一行
			Commodities p = commo.getCoTableRow(row);
			EditComDia dlg=new EditComDia(this, d);
			dlg.setModal(true);  //阻塞
			dlg.setCoValue(p);
			if( dlg.exec())
			{
				Commodities man=dlg.getCoValue();
				CommoditiesTools.UpdateCom(man);
				CheckTools.UpdateChec(man);
				InputTools.UpdateIn(man);
				OutputTools.UpdateOut(man);
				commo.setCoTableRow(man,row);
			}
			break;
			}
		case 5:{
			int[] rows = che.table.getSelectedRows();
			if(rows.length == 0)return;
			int row = rows[0]; // 只编辑选中的第一行
			Check p = che.getChTableRow(row);
			EditComDia dlg=new EditComDia(this, d);
			dlg.setModal(true);  //阻塞
			dlg.setChValue(p);
			if( dlg.exec())
			{
				Check man=dlg.getChValue();
				CheckTools.UpdateChec(man);
				che.setChTableRow(man,row);
			}
			break;
			}
		case 6:{
			int[] rows = inp.table.getSelectedRows();
			if(rows.length == 0)return;
			int row = rows[0]; // 只编辑选中的第一行
			Input p = inp.getITableRow(row);
			int r=p.getInputQuantities();
			
			EditIODia dlg=new EditIODia(this, d);
			dlg.setModal(true);  //阻塞
			dlg.setInValue(p);
			if( dlg.exec())
			{
				int q;
				Input man;
				man = dlg.getInValue();
				if(man.getInputQuantities()==r) q=0;
				else q=man.getInputQuantities()-r;
				InputTools.AlterInRecord(man);
				CommoditiesTools.UpdateCom(d, man.getcommodities_id(), man.getInputMoney(), q);
				CheckTools.UpdateChec(d,man.getcommodities_id(),man.getInputMoney(),q);
				CheckTools.AlterProfit(man.getcommodities_id());
				inp.setITableRow(man,row);
			}
			break;
		}
		case 7:{
			int[] rows = outp.table.getSelectedRows();
			if(rows.length == 0)return;
			int row = rows[0]; // 只编辑选中的第一行
			Output p = outp.getOTableRow(row);
			int r=p.getOutputQuantities();
			
			EditIODia dlg=new EditIODia(this, d);
			dlg.setModal(true);  //阻塞
			dlg.setOutValue(p);
			if( dlg.exec())
			{
				int q;
				Output man;
				man = dlg.getOutValue();
				if(man.getOutputQuantities()==r) q=0;
				else q=r-man.getOutputQuantities();
				OutputTools.AlterOutRecord(man);
				CommoditiesTools.UpdateCom(d, man.getcommodities_id(), man.getOutputMoney(), q);
				CheckTools.UpdateChec(d,man.getcommodities_id(),man.getOutputMoney(),q);
				CheckTools.AlterProfit(man.getcommodities_id());
				outp.setOTableRow(man,row);
			}
			break;
		}
		}
	}


/**
 * 
 * 删除数据
 */
	private void OnDelete(int d) {
		switch(d)
		{
		case 1:{
			// 获取选中的行的索引
			int[] rows = people1.table.getSelectedRows();
			if(rows.length == 0)return;
			// 弹出对话框确认
			int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0号按钮是'确定'按钮
			// 技巧：从后往前删除
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String id = (String)people1.tablemodel.getValueAt(row, 0);
				ManagerTools.DeleteMan(id);
				// 从tableModel中删除该条记录
				people1.tablemodel.removeRow(row);
			}
			break;
		}
		case 2:{
			// 获取选中的行的索引
			int[] rows = people2.table.getSelectedRows();
			if(rows.length == 0)return;
			// 弹出对话框确认
			int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0号按钮是'确定'按钮
			// 技巧：从后往前删除
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String id = (String)people2.tablemodel.getValueAt(row, 0);
				InputTools.DeleteInRecord2(id);
				ProviderTools.DeletePro(id);  //删除供应商时，入库记录同时受到影响
				// 从tableModel中删除该条记录
				people2.tablemodel.removeRow( row);
			}
			break;
		}
		case 3:{
			// 获取选中的行的索引
			int[] rows = people3.table.getSelectedRows();
			if(rows.length == 0)return;
			// 弹出对话框确认
			int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0号按钮是'确定'按钮
			// 技巧：从后往前删除
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String id = (String)people3.tablemodel.getValueAt(row, 0);
				OutputTools.DeleteOutRecord2(id);  //删除客户时，出库记录同时受到影响
				ClientTools.DeleteCli(id);
				// 从tableModel中删除该条记录
				people3.tablemodel.removeRow( row);
			}
			break;
		}
		case 4:{
			// 获取选中的行的索引
			int[] rows = commo.table.getSelectedRows();
			if(rows.length == 0)return;
			// 弹出对话框确认
			int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0号按钮是'确定'按钮
			// 技巧：从后往前删除
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String cid = (String)commo.tablemodel.getValueAt(row, 0);
				CheckTools.DeleteChec(cid);  //商品被删除 那么他的入库、出库、盘库记录也随着删除
				InputTools.DeleteInRecord(cid);
				OutputTools.DeleteOutRecord(cid);
				CommoditiesTools.DeleteCom(cid);
				// 从tableModel中删除该条记录
				commo.tablemodel.removeRow( row);
			}
			break;
		}
		case 5:{
			// 获取选中的行的索引
			int[] rows = che.table.getSelectedRows();
			if(rows.length == 0)return;
			// 弹出对话框确认
			int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0号按钮是'确定'按钮
			// 技巧：从后往前删除
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String id = (String)che.tablemodel.getValueAt(row, 0);
				CheckTools.DeleteChec(id);
				// 从tableModel中删除该条记录
				che.tablemodel.removeRow( row);
			}
			break;
		}
		case 6:{
			// 获取选中的行的索引
			int[] rows = inp.table.getSelectedRows();
			if(rows.length == 0)return;
			// 弹出对话框确认
			int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0号按钮是'确定'按钮
			// 技巧：从后往前删除
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String cid = (String)inp.tablemodel.getValueAt(row, 0);
				String t = (String)inp.tablemodel.getValueAt(row, 4);
				InputTools.DeleteInRecord(t, cid);
				// 从tableModel中删除该条记录
				inp.tablemodel.removeRow( row);
			}
			break;
		}
		case 7:{
			// 获取选中的行的索引
			int[] rows = outp.table.getSelectedRows();
			if(rows.length == 0)return;
			// 弹出对话框确认
			int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0号按钮是'确定'按钮
			// 技巧：从后往前删除
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String cid = (String)outp.tablemodel.getValueAt(row, 0);
				String t = (String)outp.tablemodel.getValueAt(row, 4);
				OutputTools.DeleteOutRecord(t, cid);
				// 从tableModel中删除该条记录
				outp.tablemodel.removeRow( row);
			}
			break;
		}
		}
			
	}
	
/**
 * 
 * 查询功能
 */
	private void OnSearch(int d) {
		// 获取用户输入的过滤条件
		String str = searchField.getText().trim();
		switch(d) {
		case 1:{
			if(str.length() == 0) // 过滤条件为空     --当不需要查询时清空输入框点击查询
			{
				// 恢复原始数据
				people1.clear();
				ManagerTools mt=new ManagerTools();
				List<Manager> m=mt.AllManager();
				for(Manager man : m)
				{
					people1.addMTableRow(man);
				}		
				this.addButton.setEnabled(true);		
				return;
			}
			// 把符合条件的记录显示在表格里
			people1.clear();
			ManagerTools mt=new ManagerTools();
			List<Manager> m=mt.AllManager();
			for(Manager man : m)
			{
				// 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
				if(man.getname().indexOf(str)>=0)
				{
					people1.addMTableRow(man);
					ManagerTools.Searchname_Man(str);
				}
			}
			// 把其他操作按钮禁用
			this.addButton.setEnabled(false);
			break;
		}
		case 2:{
			if(str.length() == 0) // 过滤条件为空     --当不需要查询时清空输入框点击查询
			{
				// 恢复原始数据
				people2.clear();
				ProviderTools pt=new ProviderTools();
				List<Provider> p=pt.AllProvider();
				for(Provider man : p)
				{
					people2.addPTableRow(man);
				}		
				this.addButton.setEnabled(true);		
				return;
			}
			// 把符合条件的记录显示在表格里
			people2.clear();
			ProviderTools pt=new ProviderTools();
			List<Provider> p=pt.AllProvider();
			for(Provider man : p)
			{
				// 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
				if(man.getname().indexOf(str)>=0)
				{
					people2.addPTableRow(man);
					ProviderTools.Searchname_Pro(str);
				}
			}
			// 把其他操作按钮禁用
			this.addButton.setEnabled(false);
			break;
		}
		case 3:{
			if(str.length() == 0) // 过滤条件为空     --当不需要查询时清空输入框点击查询
			{
				// 恢复原始数据
				people3.clear();
				ClientTools ct=new ClientTools();
				List<Client> c=ct.AllClient();
				for(Client man : c)
				{
					people3.addCTableRow(man);
				}		
				this.addButton.setEnabled(true);		
				return;
			}
			// 把符合条件的记录显示在表格里
			people3.clear();
			ClientTools ct=new ClientTools();
			List<Client> c=ct.AllClient();
			for(Client man : c)
			{
				// 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
				if(man.getname().indexOf(str)>=0)
				{
					people3.addCTableRow(man);
					ClientTools.Searchname_Cli(str);
				}
			}
			// 把其他操作按钮禁用
			this.addButton.setEnabled(false);
			break;
		}
		case 4:{
			if(str.length() == 0) // 过滤条件为空     --当不需要查询时清空输入框点击查询
			{
				// 恢复原始数据
				commo.clear();
				CommoditiesTools ct=new CommoditiesTools();
				List<Commodities> c=ct.AllCommodities();
				for(Commodities man : c)
				{
					commo.addCoTableRow(man);
				}		
				this.addButton.setEnabled(true);		
				return;
			}
			// 把符合条件的记录显示在表格里
			commo.clear();
			CommoditiesTools ct=new CommoditiesTools();
			List<Commodities> c=ct.AllCommodities();
			for(Commodities man : c)
			{
				if(isNumeric(str)) {
					// 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
					if(man.getid().indexOf(str)>=0)
					{
						commo.addCoTableRow(man);
						CommoditiesTools.Searchname_Com(str);
					}
				}
				else {
					if(man.getname().indexOf(str)>=0)
					{
						commo.addCoTableRow(man);
						CommoditiesTools.Searchid_Com(str);
					}
				}
			}
			// 把其他操作按钮禁用
			this.addButton.setEnabled(false);
			break;
		}
		case 5:{
			if(str.length() == 0) // 过滤条件为空     --当不需要查询时清空输入框点击查询
			{
				// 恢复原始数据
				che.clear();
				CheckTools ct=new CheckTools();
				List<Check> c=ct.AllCheck();
				for(Check man : c)
				{
					che.addChTableRow(man);
				}		
				this.addButton.setEnabled(true);		
				return;
			}
			// 把符合条件的记录显示在表格里
			che.clear();
			CheckTools ct=new CheckTools();
			List<Check> c=ct.AllCheck();
			for(Check man : c)
			{
				if(isNumeric(str)) {
					// 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
					if(man.getid().indexOf(str)>=0)
					{
						che.addChTableRow(man);
						CheckTools.Searchname_Chec(str);
					}
				}
				else {
					if(man.getname().indexOf(str)>=0)
					{
						che.addChTableRow(man);
						CheckTools.Searchid_Chec(str);
					}
				}
			}
			// 把其他操作按钮禁用
			this.addButton.setEnabled(false);
			break;
		}
		case 6:{
			if(str.length() == 0) // 过滤条件为空     --当不需要查询时清空输入框点击查询
			{
				// 恢复原始数据
				inp.clear();
				InputTools ct=new InputTools();
				List<Input> c=ct.AllIn();
				for(Input man : c)
				{
					inp.addITableRow(man);
				}		
				this.addButton.setEnabled(true);		
				return;
			}
			// 把符合条件的记录显示在表格里
			inp.clear();
			InputTools ct=new InputTools();
			List<Input> c=ct.AllIn();
			for(Input man : c)
			{
				// 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
				if(man.getcommodities_id().indexOf(str)>=0)
				{
					inp.addITableRow(man);
					InputTools.SearchIn(str);
				}
			}
			// 把其他操作按钮禁用
				this.addButton.setEnabled(false);
				break;
			}
		case 7:{
			if(str.length() == 0) // 过滤条件为空     --当不需要查询时清空输入框点击查询
			{
				// 恢复原始数据
				outp.clear();
				OutputTools ct=new OutputTools();
				List<Output> c=ct.AllOut();
				for(Output man : c)
				{
					outp.addOTableRow(man);
				}		
				this.addButton.setEnabled(true);		
				return;
			}
			// 把符合条件的记录显示在表格里
			outp.clear();
			OutputTools ct=new OutputTools();
			List<Output> c=ct.AllOut();
			for(Output man : c)
			{
				// 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
				if(man.getcommodities_id().indexOf(str)>=0)
				{
					outp.addOTableRow(man);
					OutputTools.SearchOut(str);
				}
			}
			// 把其他操作按钮禁用
			this.addButton.setEnabled(false);
			break;
		}
		}
	}
		
	
	
//填充功能
	public void fillTable(int d)
	{
		switch(d) {
		case 1:{
			ManagerTools mt=new ManagerTools();
			List<Manager> m=mt.AllManager();
			int x=m.size();
			people1.clear();
			for(int i=0;i<x;i++)
			{
				people1.addMTableRow(m.get(i));
			}
			break;
			}
		case 2:{
			ProviderTools pt=new ProviderTools();
			List<Provider> p=pt.AllProvider();
			int x=p.size();
			people2.clear();
			for(int i=0;i<x;i++)
			{
				people2.addPTableRow(p.get(i));
			}
			break;
		}
		case 3:{
			ClientTools ct=new ClientTools();
			List<Client> c=ct.AllClient();
			int x=c.size();
			people3.clear();
			for(int i=0;i<x;i++)
			{
				people3.addCTableRow(c.get(i));
			}
			break;
		}
		case 4:{
			CommoditiesTools ct=new CommoditiesTools();
			List<Commodities> c=ct.AllCommodities();
			int x=c.size();
			commo.clear();
			for(int i=0;i<x;i++)
			{
				commo.addCoTableRow(c.get(i));
			}
			break;
		}
		case 5:{
			CheckTools ct=new CheckTools();
			List<Check> c=ct.AllCheck();
			int x=c.size();
			che.clear();
			for(int i=0;i<x;i++)
			{
				che.addChTableRow(c.get(i));
			}
			break;
		}
		case 6:{
			InputTools ct=new InputTools();
			List<Input> c=ct.AllIn();
			int x=c.size();
			inp.clear();
			for(int i=0;i<x;i++)
			{
				inp.addITableRow(c.get(i));
			}
			break;
		}
		case 7:{
			OutputTools ct=new OutputTools();
			List<Output> c=ct.AllOut();
			int x=c.size();
			outp.clear();
			for(int i=0;i<x;i++)
			{
				outp.addOTableRow(c.get(i));
			}
			break;
		}
		}
	}

//计算盈余数量 不盈利算亏
	private void Countprofit() {
		int pro=0;
		int unpro=0;
		CheckTools ch=new CheckTools();
		List<Check> c=ch.AllCheck();
		for(Check i:c)
		{
			if(i.getprofit()>0) pro++;
			else unpro++;
		}
		JOptionPane.showMessageDialog(this, "  盈利数量："+pro+"\n  亏损数量："+unpro);
	}
	
//判断输入的是商品编号还是商品名称、正则表达式
	public boolean isNumeric(String str){ 
	   Pattern pattern = Pattern.compile("[0-9]*"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   }
	   return true; 
	}
}
