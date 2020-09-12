package frame;

import java.util.Date;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Commodities;
import entities.Input;
import entities.Output;

public class IOpan extends JPanel {
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
	public IOpan(boolean d) {
		this.setSize(825, 461);
		setLayout(null);
		scrollPane.setBounds(0, 0, 825, 461);
		add(scrollPane);
		
		if(d) //true -���  false -����
		{
			tablemodel.addColumn("��Ʒ���");
			tablemodel.addColumn("��Ӧ�̱��");
			tablemodel.addColumn("��Ʒ����");
			tablemodel.addColumn("�������");
			tablemodel.addColumn("���ʱ��");
		}
		else
		{
			tablemodel.addColumn("��Ʒ���");
			tablemodel.addColumn("�ͻ����");
			tablemodel.addColumn("��Ʒ�ۼ�");
			tablemodel.addColumn("��������");
			tablemodel.addColumn("����ʱ��");
		}
		
		table.setModel(tablemodel);
		scrollPane.setViewportView(table);
	}
	
	
	//���һ��
	public void addITableRow(Input i) {
		Vector<Object> rowData = new Vector<>();
		rowData.add(i.getcommodities_id());
		rowData.add(i.getprovider_id());
		rowData.add(i.getInputMoney());
		rowData.add(i.getInputQuantities());
		rowData.add(i.getInputTime());
		tablemodel.addRow( rowData ); // ���һ��
	}
	public void addOTableRow(Output o) {
		Vector<Object> rowData = new Vector<>();
		rowData.add(o.getcommodities_id());
		rowData.add(o.getclient_id());
		rowData.add(o.getOutputMoney());
		rowData.add(o.getOutputQuantities());
		rowData.add(o.getOutputTime());
		tablemodel.addRow( rowData ); // ���һ��
	}
	
	//��ȡһ��
	public Input getITableRow(int row) {
		Input i=new Input();
		i.setcommodities_id((String)tablemodel.getValueAt(row, 0));
		i.setprovider_id((String)tablemodel.getValueAt(row, 1));
		i.setmoney((Double)tablemodel.getValueAt(row, 2));
		i.setquantities((Integer)tablemodel.getValueAt(row, 3));
		i.setInputTime(((String)tablemodel.getValueAt(row, 4)));
		return i;
	}
	public Output getOTableRow(int row) {
		Output o=new Output();
		o.setcommodities_id((String)tablemodel.getValueAt(row, 0));
		o.setclient_id((String)tablemodel.getValueAt(row, 1));
		o.setmoney((Double)tablemodel.getValueAt(row, 2));
		o.setquantities((Integer)tablemodel.getValueAt(row, 3));
		o.setOutputTime(((String)tablemodel.getValueAt(row, 4)));
		return o;
	}
	
	//����һ��
	public void setITableRow(Input i, int row)
	{
		tablemodel.setValueAt(i.getcommodities_id(), row, 0);
		tablemodel.setValueAt(i.getprovider_id(), row, 1);
		tablemodel.setValueAt(i.getInputMoney(), row, 2);
		tablemodel.setValueAt(i.getInputQuantities(), row,3);
		tablemodel.setValueAt(i.getInputTime(), row, 4);
	}
	public void setOTableRow(Output o, int row)
	{
		tablemodel.setValueAt(o.getcommodities_id(), row, 0);
		tablemodel.setValueAt(o.getclient_id(), row, 1);
		tablemodel.setValueAt(o.getOutputMoney(), row, 2);
		tablemodel.setValueAt(o.getOutputQuantities(), row,3);
		tablemodel.setValueAt(o.getOutputTime(), row, 4);
	}
	
	//ˢ�±��
	public void clear()
	{
		tablemodel.setRowCount(0); // ���
	}

}
