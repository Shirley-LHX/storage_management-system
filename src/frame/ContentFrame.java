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
	
	//���ò˵���
	JMenuBar menuBar = new JMenuBar();
	JMenu Start = new JMenu("��ʼ");
	JMenuItem help = new JMenuItem("����");
	JMenuItem end = new JMenuItem("�˳�");
	JMenu PeoManage = new JMenu("��Ա����");
	JMenuItem man = new JMenuItem("����Ա");
	JMenuItem pro = new JMenuItem("��Ӧ��");
	JMenuItem cli = new JMenuItem("�ͻ�");
	JMenu ComManage = new JMenu("��Ʒ����");
	JMenuItem com = new JMenuItem("��Ʒ��Ϣ");
	JMenuItem in = new JMenuItem("�����Ϣ");
	JMenuItem out = new JMenuItem("������Ϣ");
	JMenuItem chec = new JMenuItem("�̵���Ϣ");
	JPanel cards = new JPanel();
	Peopan people1 = new Peopan("����",1);
	Peopan people2 = new Peopan("�绰",2);
	Peopan people3 =new Peopan("�绰", 3);
	Compan commo = new Compan(0);
	Compan che=new Compan(1);
	IOpan inp=new IOpan(true);
	IOpan outp=new IOpan(false);
	JPanel he = new JPanel();
	private final JButton addButton = new JButton("\u6DFB\u52A0");
	private final JButton delButton = new JButton("\u5220\u9664");
	JButton seButton = new JButton("\u67E5\u8BE2");
	JButton altButton = new JButton("\u4FEE\u6539");
	JButton profit=new JButton("����ӯ������");
	private JTextField searchField;
	
	int ctrl=1;  //������¼��Ƭmodule
	private final JTextPane txtpnGb = new JTextPane();
	
	
	/**
	 * Create the frame.
	 */
	public ContentFrame() {
		setTitle("������ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 100, 849, 533);
		setJMenuBar(menuBar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false); //�������
		
		//��Ӳ˵���
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
		//���찴ť
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
		
		//���쿨Ƭ����
		cards.setLayout(new CardLayout());
		contentPane.add(cards);
		cards.add(people1,"����Ա����");
		cards.add(people2,"��Ӧ�̹���");
		cards.add(people3,"�ͻ�����");
		cards.add(commo,"��Ʒ����");
		cards.add(inp,"������");
		cards.add(outp,"�������");
		cards.add(che,"�̿����");
		cards.add(he,"����");
		he.setLayout(null);
		txtpnGb.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));
		txtpnGb.setEditable(false);
		txtpnGb.setText("                \u6B22\u8FCE\u6765\u5230\u5E93\u5B58\u7BA1\u7406\u7CFB\u7EDF\uFF01\r\n\r\n\u5728\u4F7F\u7528\u65F6\u60A8\u9700\u8981\u6CE8\u610F\u4E00\u4E0B\u51E0\u70B9\uFF1A\r\n       1.\u5F53\u6DFB\u52A0\u5546\u54C1\u4FE1\u606F\u65F6\uFF0C\u9700\u8981\u6DFB\u52A0\u76D8\u70B9\u4FE1\u606F\u5E76\u5C06\u5176\u603B\u5165\u5E93\u3001\u603B\u51FA\u5E93\u6570\u91CF\u521D\u59CB\u5316\u4E3A0\u3002\r\n       2.\u5F53\u8FDB\u5165\u7F16\u8F91\u6846\u65F6\uFF0C\u7531\u4E8E\u57FA\u7840\u5C5E\u6027\u88AB\u5546\u54C1\u5B9A\u5236\uFF0C\u8FD8\u6709\u5165\u5E93\u51FA\u5E93\u65F6\u95F4\u90FD\u662F\u83B7\u53D6\u5F53\u5929\u65F6\u95F4\u3002\u5219\u5F88\u591A\u6587\u672C\u6846\u70B9\u51FB\u4EE5\u4E0B\u6846\u5C31\u4F1A\u663E\u793A\u51FA\u6570\u636E\uFF0C\u6CE8\u610F\u6709\u65F6\u70B9\u51FB\u4E0D\u7075\u654F\uFF0C\u591A\u70B9\u51E0\u6B21\u3002");
		txtpnGb.setBounds(136, 59, 535, 247);
		
		he.add(txtpnGb);
		
		// ��ʼ����
		CardLayout c=(CardLayout)cards.getLayout();
		c.show(cards, "����");
		
		//�������
		addButton.addActionListener((e)->{
			if(ctrl<=3)
				PeoOnAdd(ctrl);
			else if(ctrl>3&&ctrl<=5)
				ComOnAdd(ctrl);
			else if(ctrl>5&&ctrl<=7)
				IoOnAdd(ctrl);
		});
		
		//�޸�����
		altButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnAlter(ctrl);
			}
		});
		
		//ɾ������
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnDelete(ctrl);
			}
		});
		
		//��ѯ
		seButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnSearch(ctrl);
			}
		});
		
	/**
	 * 
	 * �л�panel ctrl����¼���ĸ�panel
	 */
		man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl=1;
				CardLayout cl=(CardLayout)cards.getLayout();
				cl.show(cards, "����Ա����");
			    fillTable(ctrl);
			    profit.setEnabled(false);
			}
		});
		pro.addActionListener((e)->{
			ctrl=2;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "��Ӧ�̹���");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		cli.addActionListener((e)->{
			ctrl=3;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "�ͻ�����");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		
		com.addActionListener((e)->{
			ctrl=4;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "��Ʒ����");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		
		in.addActionListener((e)->{
			ctrl=6;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "������");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		
		out.addActionListener((e)->{
			ctrl=7;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "�������");
			fillTable(ctrl);
			profit.setEnabled(false);
		});
		
		chec.addActionListener((e)->{
			ctrl=5;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "�̿����");
			fillTable(ctrl);
			profit.setBounds(700, 35, 83, 23);
			contentPane.add(profit);
			profit.setEnabled(true);
		});
		
		help.addActionListener((e)->{
			ctrl=8;
			CardLayout cl=(CardLayout)cards.getLayout();
			cl.show(cards, "����");
		});
		
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);  //�˳�����
			}
		});
		profit.addActionListener((e)->{
			Countprofit();
		});
	}



/**
 * 
 * ��ӹ���  ��Ҫ��Ӹı�model Ҫ���ģ̬
 */
//��Ա
	private void PeoOnAdd(int d) {
		EditPeoDia dlg=new EditPeoDia(this,d);
		dlg.setModal(true);  //����
		if( dlg.exec() )  //ע���break
		{
			switch(d)
			{
			case 1:
			{
				Manager m =dlg.getMValue();
				ManagerTools.AddMan(m);
				people1.addMTableRow(m);	// ��ӵ� tableModel
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
//��Ʒ���̵�
	private void ComOnAdd(int d) {
		EditComDia dlg=new EditComDia(this,d);
		dlg.setModal(true);  //����
		if( dlg.exec() )  //ע���break
		{
			switch(d)
			{
			case 4:
			{
				Commodities c =dlg.getCoValue();
				CommoditiesTools.AddCom(c);
				commo.addCoTableRow(c);	// ��ӵ� tableModel
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
//���������
	private void IoOnAdd(int d) {
		EditIODia dlg=new EditIODia(this,d);
		dlg.setModal(true);  //����
		if( dlg.exec() )  //ע���break
		{
			switch(d)
			{
			case 6:
			{
				Input c;
				c = dlg.getInValue();
				InputTools.AddInRecord(c);
				inp.addITableRow(c);	// ��ӵ� tableModel
			//������Ʒ�еĿ��
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
			//������Ʒ�еĿ��
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
 * �޸����� 
 */
	private void OnAlter(int d) {
		switch(d)
		{
		case 1:{
		int[] rows = people1.table.getSelectedRows();
		if(rows.length == 0)return;
		int row = rows[0];  // ֻ�༭ѡ�еĵ�һ��
		Manager m = people1.getMTableRow(row);
		EditPeoDia dlg=new EditPeoDia(this, d);
		dlg.setModal(true);  //����
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
		int row = rows[0]; // ֻ�༭ѡ�еĵ�һ��
		Provider p = people2.getPTableRow(row);
		EditPeoDia dlg=new EditPeoDia(this, d);
		dlg.setModal(true);  //����
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
		int row = rows[0]; // ֻ�༭ѡ�еĵ�һ��
		Client p = people3.getCTableRow(row);
		EditPeoDia dlg=new EditPeoDia(this, d);
		dlg.setModal(true);  //����
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
			int row = rows[0]; // ֻ�༭ѡ�еĵ�һ��
			Commodities p = commo.getCoTableRow(row);
			EditComDia dlg=new EditComDia(this, d);
			dlg.setModal(true);  //����
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
			int row = rows[0]; // ֻ�༭ѡ�еĵ�һ��
			Check p = che.getChTableRow(row);
			EditComDia dlg=new EditComDia(this, d);
			dlg.setModal(true);  //����
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
			int row = rows[0]; // ֻ�༭ѡ�еĵ�һ��
			Input p = inp.getITableRow(row);
			int r=p.getInputQuantities();
			
			EditIODia dlg=new EditIODia(this, d);
			dlg.setModal(true);  //����
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
			int row = rows[0]; // ֻ�༭ѡ�еĵ�һ��
			Output p = outp.getOTableRow(row);
			int r=p.getOutputQuantities();
			
			EditIODia dlg=new EditIODia(this, d);
			dlg.setModal(true);  //����
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
 * ɾ������
 */
	private void OnDelete(int d) {
		switch(d)
		{
		case 1:{
			// ��ȡѡ�е��е�����
			int[] rows = people1.table.getSelectedRows();
			if(rows.length == 0)return;
			// �����Ի���ȷ��
			int select = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ��ɾ��?", "ȷ��", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0�Ű�ť��'ȷ��'��ť
			// ���ɣ��Ӻ���ǰɾ��
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String id = (String)people1.tablemodel.getValueAt(row, 0);
				ManagerTools.DeleteMan(id);
				// ��tableModel��ɾ��������¼
				people1.tablemodel.removeRow(row);
			}
			break;
		}
		case 2:{
			// ��ȡѡ�е��е�����
			int[] rows = people2.table.getSelectedRows();
			if(rows.length == 0)return;
			// �����Ի���ȷ��
			int select = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ��ɾ��?", "ȷ��", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0�Ű�ť��'ȷ��'��ť
			// ���ɣ��Ӻ���ǰɾ��
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String id = (String)people2.tablemodel.getValueAt(row, 0);
				InputTools.DeleteInRecord2(id);
				ProviderTools.DeletePro(id);  //ɾ����Ӧ��ʱ������¼ͬʱ�ܵ�Ӱ��
				// ��tableModel��ɾ��������¼
				people2.tablemodel.removeRow( row);
			}
			break;
		}
		case 3:{
			// ��ȡѡ�е��е�����
			int[] rows = people3.table.getSelectedRows();
			if(rows.length == 0)return;
			// �����Ի���ȷ��
			int select = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ��ɾ��?", "ȷ��", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0�Ű�ť��'ȷ��'��ť
			// ���ɣ��Ӻ���ǰɾ��
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String id = (String)people3.tablemodel.getValueAt(row, 0);
				OutputTools.DeleteOutRecord2(id);  //ɾ���ͻ�ʱ�������¼ͬʱ�ܵ�Ӱ��
				ClientTools.DeleteCli(id);
				// ��tableModel��ɾ��������¼
				people3.tablemodel.removeRow( row);
			}
			break;
		}
		case 4:{
			// ��ȡѡ�е��е�����
			int[] rows = commo.table.getSelectedRows();
			if(rows.length == 0)return;
			// �����Ի���ȷ��
			int select = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ��ɾ��?", "ȷ��", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0�Ű�ť��'ȷ��'��ť
			// ���ɣ��Ӻ���ǰɾ��
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String cid = (String)commo.tablemodel.getValueAt(row, 0);
				CheckTools.DeleteChec(cid);  //��Ʒ��ɾ�� ��ô������⡢���⡢�̿��¼Ҳ����ɾ��
				InputTools.DeleteInRecord(cid);
				OutputTools.DeleteOutRecord(cid);
				CommoditiesTools.DeleteCom(cid);
				// ��tableModel��ɾ��������¼
				commo.tablemodel.removeRow( row);
			}
			break;
		}
		case 5:{
			// ��ȡѡ�е��е�����
			int[] rows = che.table.getSelectedRows();
			if(rows.length == 0)return;
			// �����Ի���ȷ��
			int select = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ��ɾ��?", "ȷ��", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0�Ű�ť��'ȷ��'��ť
			// ���ɣ��Ӻ���ǰɾ��
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String id = (String)che.tablemodel.getValueAt(row, 0);
				CheckTools.DeleteChec(id);
				// ��tableModel��ɾ��������¼
				che.tablemodel.removeRow( row);
			}
			break;
		}
		case 6:{
			// ��ȡѡ�е��е�����
			int[] rows = inp.table.getSelectedRows();
			if(rows.length == 0)return;
			// �����Ի���ȷ��
			int select = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ��ɾ��?", "ȷ��", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0�Ű�ť��'ȷ��'��ť
			// ���ɣ��Ӻ���ǰɾ��
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String cid = (String)inp.tablemodel.getValueAt(row, 0);
				String t = (String)inp.tablemodel.getValueAt(row, 4);
				InputTools.DeleteInRecord(t, cid);
				// ��tableModel��ɾ��������¼
				inp.tablemodel.removeRow( row);
			}
			break;
		}
		case 7:{
			// ��ȡѡ�е��е�����
			int[] rows = outp.table.getSelectedRows();
			if(rows.length == 0)return;
			// �����Ի���ȷ��
			int select = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ��ɾ��?", "ȷ��", JOptionPane.YES_NO_OPTION);
			if(select != 0) return; // 0�Ű�ť��'ȷ��'��ť
			// ���ɣ��Ӻ���ǰɾ��
			for(int i= rows.length-1; i>=0; i--)
			{
				int row = rows[i];
				String cid = (String)outp.tablemodel.getValueAt(row, 0);
				String t = (String)outp.tablemodel.getValueAt(row, 4);
				OutputTools.DeleteOutRecord(t, cid);
				// ��tableModel��ɾ��������¼
				outp.tablemodel.removeRow( row);
			}
			break;
		}
		}
			
	}
	
/**
 * 
 * ��ѯ����
 */
	private void OnSearch(int d) {
		// ��ȡ�û�����Ĺ�������
		String str = searchField.getText().trim();
		switch(d) {
		case 1:{
			if(str.length() == 0) // ��������Ϊ��     --������Ҫ��ѯʱ������������ѯ
			{
				// �ָ�ԭʼ����
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
			// �ѷ��������ļ�¼��ʾ�ڱ����
			people1.clear();
			ManagerTools mt=new ManagerTools();
			List<Manager> m=mt.AllManager();
			for(Manager man : m)
			{
				// ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1
				if(man.getname().indexOf(str)>=0)
				{
					people1.addMTableRow(man);
					ManagerTools.Searchname_Man(str);
				}
			}
			// ������������ť����
			this.addButton.setEnabled(false);
			break;
		}
		case 2:{
			if(str.length() == 0) // ��������Ϊ��     --������Ҫ��ѯʱ������������ѯ
			{
				// �ָ�ԭʼ����
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
			// �ѷ��������ļ�¼��ʾ�ڱ����
			people2.clear();
			ProviderTools pt=new ProviderTools();
			List<Provider> p=pt.AllProvider();
			for(Provider man : p)
			{
				// ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1
				if(man.getname().indexOf(str)>=0)
				{
					people2.addPTableRow(man);
					ProviderTools.Searchname_Pro(str);
				}
			}
			// ������������ť����
			this.addButton.setEnabled(false);
			break;
		}
		case 3:{
			if(str.length() == 0) // ��������Ϊ��     --������Ҫ��ѯʱ������������ѯ
			{
				// �ָ�ԭʼ����
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
			// �ѷ��������ļ�¼��ʾ�ڱ����
			people3.clear();
			ClientTools ct=new ClientTools();
			List<Client> c=ct.AllClient();
			for(Client man : c)
			{
				// ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1
				if(man.getname().indexOf(str)>=0)
				{
					people3.addCTableRow(man);
					ClientTools.Searchname_Cli(str);
				}
			}
			// ������������ť����
			this.addButton.setEnabled(false);
			break;
		}
		case 4:{
			if(str.length() == 0) // ��������Ϊ��     --������Ҫ��ѯʱ������������ѯ
			{
				// �ָ�ԭʼ����
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
			// �ѷ��������ļ�¼��ʾ�ڱ����
			commo.clear();
			CommoditiesTools ct=new CommoditiesTools();
			List<Commodities> c=ct.AllCommodities();
			for(Commodities man : c)
			{
				if(isNumeric(str)) {
					// ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1
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
			// ������������ť����
			this.addButton.setEnabled(false);
			break;
		}
		case 5:{
			if(str.length() == 0) // ��������Ϊ��     --������Ҫ��ѯʱ������������ѯ
			{
				// �ָ�ԭʼ����
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
			// �ѷ��������ļ�¼��ʾ�ڱ����
			che.clear();
			CheckTools ct=new CheckTools();
			List<Check> c=ct.AllCheck();
			for(Check man : c)
			{
				if(isNumeric(str)) {
					// ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1
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
			// ������������ť����
			this.addButton.setEnabled(false);
			break;
		}
		case 6:{
			if(str.length() == 0) // ��������Ϊ��     --������Ҫ��ѯʱ������������ѯ
			{
				// �ָ�ԭʼ����
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
			// �ѷ��������ļ�¼��ʾ�ڱ����
			inp.clear();
			InputTools ct=new InputTools();
			List<Input> c=ct.AllIn();
			for(Input man : c)
			{
				// ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1
				if(man.getcommodities_id().indexOf(str)>=0)
				{
					inp.addITableRow(man);
					InputTools.SearchIn(str);
				}
			}
			// ������������ť����
				this.addButton.setEnabled(false);
				break;
			}
		case 7:{
			if(str.length() == 0) // ��������Ϊ��     --������Ҫ��ѯʱ������������ѯ
			{
				// �ָ�ԭʼ����
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
			// �ѷ��������ļ�¼��ʾ�ڱ����
			outp.clear();
			OutputTools ct=new OutputTools();
			List<Output> c=ct.AllOut();
			for(Output man : c)
			{
				// ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1
				if(man.getcommodities_id().indexOf(str)>=0)
				{
					outp.addOTableRow(man);
					OutputTools.SearchOut(str);
				}
			}
			// ������������ť����
			this.addButton.setEnabled(false);
			break;
		}
		}
	}
		
	
	
//��书��
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

//����ӯ������ ��ӯ�����
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
		JOptionPane.showMessageDialog(this, "  ӯ��������"+pro+"\n  ����������"+unpro);
	}
	
//�ж����������Ʒ��Ż�����Ʒ���ơ�������ʽ
	public boolean isNumeric(String str){ 
	   Pattern pattern = Pattern.compile("[0-9]*"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   }
	   return true; 
	}
}
