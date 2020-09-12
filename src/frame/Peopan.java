package frame;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.*;
import sqlTools.*;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Peopan extends JPanel {
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
	 * d��ʾ1-����Ա 2-��Ӧ�� 3-�ͻ�
	 */
	public Peopan(String str,int d) {
		this.setSize(825, 461);
		setLayout(null);
		scrollPane.setBounds(0, 0, 825, 461);
		add(scrollPane);
		
		tablemodel.addColumn("���");
		tablemodel.addColumn("����");
		tablemodel.addColumn(str);
		table.setModel(tablemodel);
		scrollPane.setViewportView(table);
}

/**
 * ���һ�С�����д�ɾ�̬���� tablemodule��ɾ�̬�Ļ�����ôtable��ʾ�Ͳ�������
 * @param m
 */
	public void addMTableRow(Manager m) {
		Vector<Object> rowData = new Vector<>();
		rowData.add(m.getid());
		rowData.add(m.getname());
		rowData.add(m.getPassword());		
		tablemodel.addRow( rowData ); // ���һ��
	}
	public void addPTableRow(Provider p) {
		Vector<Object> rowData = new Vector<>();
		rowData.add(p.getid());
		rowData.add(p.getname());
		rowData.add(p.getphone());		
		tablemodel.addRow( rowData ); // ���һ��
	}
	public void addCTableRow(Client c) {
		Vector<Object> rowData = new Vector<>();
		rowData.add(c.getid());
		rowData.add(c.getname());
		rowData.add(c.getphone());		
		tablemodel.addRow( rowData ); // ���һ��
	}
	
/**
 * ��ȡһ��	
 */
	public Manager getMTableRow(int row) {
		Manager m=new Manager();
		m.setID((String)tablemodel.getValueAt(row, 0));
		m.setName((String)tablemodel.getValueAt(row, 1));
		m.setPassword(((String)tablemodel.getValueAt(row, 2)));
		return m;
	}
	public Provider getPTableRow(int row) {
		Provider p=new Provider();
		p.setid((String)tablemodel.getValueAt(row, 0));
		p.setname((String)tablemodel.getValueAt(row, 1));
		p.setphone(((String)tablemodel.getValueAt(row, 2)));
		return p;
	}
	public Client getCTableRow(int row) {
		Client c=new Client();
		c.setid((String)tablemodel.getValueAt(row, 0));
		c.setname((String)tablemodel.getValueAt(row, 1));
		c.setphone(((String)tablemodel.getValueAt(row, 2)));
		return c;
	}
	
	/**
	 * ����model����
	 */
	public void setMTableRow(Manager m, int row)
	{
		tablemodel.setValueAt(m.getid(), row, 0);
		tablemodel.setValueAt(m.getname(), row, 1);
		tablemodel.setValueAt(m.getPassword(), row, 2);
	}
	
	public void setPTableRow(Provider P, int row)
	{
		tablemodel.setValueAt(P.getid(), row, 0);
		tablemodel.setValueAt(P.getname(), row, 1);
		tablemodel.setValueAt(P.getphone(), row, 2);
	}
	
	public void setCTableRow(Client c, int row)
	{
		tablemodel.setValueAt(c.getid(), row, 0);
		tablemodel.setValueAt(c.getname(), row, 1);
		tablemodel.setValueAt(c.getphone(), row, 2);
	}
	/**
	 * ˢ�±�� �����
	 */
	public void clear()
	{
		tablemodel.setRowCount(0); // ���
	}
}