package ar.com.nextel.nexus.model;

import java.util.ArrayList;
import java.util.List;

public class Data {

	private List<C> rows = new ArrayList<>();
	private List<ColsData> cols = new ArrayList<>();

	public List<ColsData> getCols() {
		return cols;
	}

	public void setCols(List<ColsData> cols) {
		this.cols = cols;
	}

	public void addColsData(ColsData colsData) {
		cols.add(colsData);
	}

	public List<C> getRows() {
		return rows;
	}

	public void setRows(List<C> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "rows:" + rows;
	}

	public void addC(C c) {
		rows.add(c);
	}

}
