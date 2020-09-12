package frame;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Check;
import entities.Commodities;
import entities.Manager;

public class Compan extends JPanel {
	public JTable table= new JTable(){
		@Override
		public boolean isCellEditable(int row, int column)
		{
			return false;
		}			
	};
	JScrollPane scrollPane = new JScrollPane();
	public DefaultTableModel tablemodel=new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public Compan(int d) {    //0-��ʾ��Ʒ��Ϣ��1-��ʾ�̿���Ϣ
		this.setSize(825, 461);
		setLayout(null);
		scrollPane.setBounds(0, 0, 825, 461);
		add(scrollPane);
		if(d==0) {
		tablemodel.addColumn("��Ʒ���");
		tablemodel.addColumn("��Ӧ�̱��");
		tablemodel.addColumn("�ͻ����");
		tablemodel.addColumn("��Ʒ����");
		tablemodel.addColumn("��Ʒ����");
		tablemodel.addColumn("��Ʒ����");
		tablemodel.addColumn("��Ʒ�ۼ�");
		tablemodel.addColumn("��Ʒ�ܿ��");
		}
		else if(d==1)
		{
			tablemodel.addColumn("��Ʒ���");
			tablemodel.addColumn("��Ʒ����");
			tablemodel.addColumn("��Ʒ����");
			tablemodel.addColumn("���������");
			tablemodel.addColumn("��Ʒ�ۼ�");
			tablemodel.addColumn("�ܳ�������");
			tablemodel.addColumn("��Ʒʣ��");
			tablemodel.addColumn("��Ʒ����");
		}
		
		table.setModel(tablemodel);
		scrollPane.setViewportView(table);
	}
	
	//���һ��
	public void addCoTableRow(Commodities c) {
		Vector<Object> rowData = new Vector<>();
		rowData.add(c.getid());
		rowData.add(c.getcpid());
		rowData.add(c.getccid());
		rowData.add(c.getname());
		rowData.add(c.gettype());
		rowData.add(c.getinmoney());
		rowData.add(c.getoutmoney());
		rowData.add(c.getremain());
		tablemodel.addRow( rowData );
	}
	public void addChTableRow(Check c) {
		Vector<Object> rowData = new Vector<>();
		rowData.add(c.getid());
		rowData.add(c.getname());
		rowData.add(c.getinmoney());
		rowData.add(c.getinquantities());
		rowData.add(c.getoutmoney());
		rowData.add(c.getoutquantities());
		rowData.add(c.getremain());
		rowData.add(c.getprofit());
		tablemodel.addRow( rowData );
	}
	
	
//��ȡһ��
	public Commodities getCoTableRow(int row) {
		Commodities c=new Commodities();
		c.setid((String)tablemodel.getValueAt(row, 0));
		c.setcpid((String)tablemodel.getValueAt(row, 1));
		c.setccid((String)tablemodel.getValueAt(row, 2));
		c.setname((String)tablemodel.getValueAt(row, 3));
		c.settype((String)tablemodel.getValueAt(row, 4));
		c.setInmoney((Double)tablemodel.getValueAt(row, 5));
		c.setOutmoney((Double)tablemodel.getValueAt(row, 6));
		c.setremain(((Integer)tablemodel.getValueAt(row, 7)));
		return c;
	}
	public Check getChTableRow(int row) {
		Check c=new Check();
		c.setid((String)tablemodel.getValueAt(row, 0));
		c.setname((String)tablemodel.getValueAt(row, 1));
		c.setinmon((Double)tablemodel.getValueAt(row, 2));
		c.setinquan((Integer)tablemodel.getValueAt(row, 3));
		c.setoutmon((Double)tablemodel.getValueAt(row, 4));
		c.setoutquan((Integer)tablemodel.getValueAt(row, 5));
		c.setremain(((Integer)tablemodel.getValueAt(row, 6)));
		c.setprofit((Double)tablemodel.getValueAt(row, 7));
		return c;
	}
	
	
//����һ��
	public void setCoTableRow(Commodities c, int row)
	{
		tablemodel.setValueAt(c.getid(), row, 0);
		tablemodel.setValueAt(c.getcpid(), row, 1);
		tablemodel.setValueAt(c.getccid(), row, 2);
		tablemodel.setValueAt(c.getname(), row, 3);
		tablemodel.setValueAt(c.gettype(), row, 4);
		tablemodel.setValueAt(c.getinmoney(), row, 5);
		tablemodel.setValueAt(c.getoutmoney(), row, 6);
		tablemodel.setValueAt(c.getremain(), row, 7);
	}
	
	public void setChTableRow(Check c, int row)
	{
		tablemodel.setValueAt(c.getid(), row, 0);
		tablemodel.setValueAt(c.getname(), row, 1);
		tablemodel.setValueAt(c.getinmoney(), row, 2);
		tablemodel.setValueAt(c.getinquantities(), row, 3);
		tablemodel.setValueAt(c.getoutmoney(), row, 4);
		tablemodel.setValueAt(c.getoutquantities(), row, 5);
		tablemodel.setValueAt(c.getremain(), row, 6);
		tablemodel.setValueAt(c.getprofit(), row, 7);
	}
	
	//ˢ�±��
	public void clear()
	{
		tablemodel.setRowCount(0); // ���
	}

}
