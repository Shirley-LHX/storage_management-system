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
	public Compan(int d) {    //0-表示商品信息，1-表示盘库信息
		this.setSize(825, 461);
		setLayout(null);
		scrollPane.setBounds(0, 0, 825, 461);
		add(scrollPane);
		if(d==0) {
		tablemodel.addColumn("商品编号");
		tablemodel.addColumn("供应商编号");
		tablemodel.addColumn("客户编号");
		tablemodel.addColumn("商品名称");
		tablemodel.addColumn("商品类型");
		tablemodel.addColumn("商品进价");
		tablemodel.addColumn("商品售价");
		tablemodel.addColumn("商品总库存");
		}
		else if(d==1)
		{
			tablemodel.addColumn("商品编号");
			tablemodel.addColumn("商品名称");
			tablemodel.addColumn("商品进价");
			tablemodel.addColumn("总入库数量");
			tablemodel.addColumn("商品售价");
			tablemodel.addColumn("总出库数量");
			tablemodel.addColumn("商品剩余");
			tablemodel.addColumn("商品利润");
		}
		
		table.setModel(tablemodel);
		scrollPane.setViewportView(table);
	}
	
	//添加一行
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
	
	
//获取一行
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
	
	
//更新一行
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
	
	//刷新表格
	public void clear()
	{
		tablemodel.setRowCount(0); // 清空
	}

}
