package register.model;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class RegisterTableModel extends AbstractTableModel {

	private RegisterManager registerManager;
	
	public RegisterTableModel(RegisterManager registerManager) {
		super();
		this.registerManager = registerManager;
		update();
	}

	public void update() {
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return registerManager.getEntryPropertiesCount();
	}

	@Override
	public int getRowCount() {
		return registerManager.getRegisterSize();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return registerManager.getValueAt(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return registerManager.getPropertyName(column);
	}
}