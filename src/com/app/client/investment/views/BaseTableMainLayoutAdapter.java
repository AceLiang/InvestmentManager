package com.app.client.investment.views;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.RelativeLayout.LayoutParams;

public abstract class BaseTableMainLayoutAdapter {

	protected String headers[];
	int headerCellsWidth[];
	
	private IonCellClickListener cellClickListener ;
	
	private IonChildCellClickListener childCellClickListener ;

	public void setChildCellClickListener(
			IonChildCellClickListener childCellClickListener) {
		this.childCellClickListener = childCellClickListener;
	}

	public void setCellClickListener(IonCellClickListener cellClickListener) {
		this.cellClickListener = cellClickListener;
	}

	public int[] getHeaderCellsWidth() {
		if (headerCellsWidth == null) {
			headerCellsWidth = new int[headers.length];
		}
		return headerCellsWidth;
	}

	protected Context context;
	
	private List<TableRow> tableRowsC = new ArrayList<TableRow>();
	private List<TableRow> tableRowsD = new ArrayList<TableRow>();

	List<Boolean> groupStates = new ArrayList<Boolean>();
	/******
	 * return fix column
	 * 
	 * @return
	 */
	public abstract int getFixHeaderColumn();

	/****
	 * ªÒ»°headerView
	 * 
	 * @return
	 */
	public abstract View getHeaderCellView(int index, String label);

	public abstract View getCellView(int index, Object data);
	
	public abstract View getChildCellView(int index, Object data);

	public abstract int getCount();

	public abstract Object getItem(int position);
	
	public abstract int getChildCount(int position);
	
	
	public abstract Object getChildItem(int position , int index);
	
	
	public abstract int getGroupIndex (int row , int column , Object data) ;
	
	
	public interface IonCellClickListener {
		public void onCellClickListener(int column , int row , View view , boolean isChildView , Object data);
	}
	
	public interface IonChildCellClickListener {
		public void onChildCellClickListener(int parentIndex , int column , int row , View view);
	}

	// generate table row of table A
	public TableRow componentATableRow() {

		TableRow componentATableRow = new TableRow(this.context);

		TableRow.LayoutParams params = new TableRow.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//		params.setMargins(2, 0, 0, 0);

		int fixColumn = getFixHeaderColumn();
		for (int i = 0; i < fixColumn; i++) {
			View view = getHeaderCellView(i, this.headers[i]);
			if (i == 0) {
			} else {
				view.setLayoutParams(params);
			}
			componentATableRow.addView(view);
		}

		return componentATableRow;
	}

	// generate table row of table B
	public TableRow componentBTableRow() {

		TableRow componentBTableRow = new TableRow(context);
		int headerFieldCount = this.headers.length;

		TableRow.LayoutParams params = new TableRow.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//		params.setMargins(2, 0, 0, 0);

		int fixColumn = getFixHeaderColumn();

		for (int x = 0; x < (headerFieldCount - fixColumn); x++) {
			int index = x + fixColumn;
			View view = this.getHeaderCellView(index, this.headers[index]);
			view.setLayoutParams(params);
			componentBTableRow.addView(view);
		}

		return componentBTableRow;
	}

	// generate table row of table C and table D
	public void generateTableC_AndTable_D(TableLayout tableC, TableLayout tableD) {

		int size = getCount();

		for (int i = 0; i < size; i++) {
			Object object = getItem(i);

			TableRow tableRowForTableC = this.tableRowForTableC(i , object , false);
			TableRow taleRowForTableD = this.taleRowForTableD(i , object , false );

			tableC.addView(tableRowForTableC);
			tableD.addView(taleRowForTableD);
			
			tableRowsC.add(tableRowForTableC);
			tableRowsD.add(taleRowForTableD);
			
			
			groupStates.add(false);
			int childCount = getChildCount(i);
			
			for(int j = 0 ; j < childCount ; j ++){
				object = getChildItem(i, j);
				
				tableRowForTableC = this.tableRowForTableC(j ,object , true);
				taleRowForTableD = this.taleRowForTableD( j , object , true);
				
				if (tableRowForTableC.getChildCount() > 0 && taleRowForTableD.getChildCount() > 0) {
					
					tableC.addView(tableRowForTableC);
					tableD.addView(taleRowForTableD);
					
					tableRowsC.add(tableRowForTableC);
					tableRowsD.add(taleRowForTableD);
					
					tableRowForTableC.setVisibility(View.GONE);
					taleRowForTableD.setVisibility(View.GONE);
					
				}
				
			}
			
			
		}
	}
	
	

	private TableRow tableRowForTableC(int position ,Object data , boolean isChildrenView) {

		TableRow tableRowForTableC = new TableRow(this.context);
		int fixHeader = getFixHeaderColumn();

		for (int i = 0; i < fixHeader; i++) {
			TableRow.LayoutParams params = null;
			params = new TableRow.LayoutParams(this.headerCellsWidth[i],
					LayoutParams.MATCH_PARENT);
//			if (i == 0) {
//				params.setMargins(0, 2, 0, 0);
//			} else {
//				params.setMargins(2, 2, 0, 0);
//			}
			View view = null ;
			
			if (isChildrenView == false) {
				view = getCellView(i, data);
			}else {
				view = getChildCellView(i, data);
			}
			if (view != null) {
				tableRowForTableC.addView(view, params);
				view.setTag(0);
//				view.setOnClickListener(this);
			}
			
			view.setOnClickListener(new CellClickListener(position , isChildrenView , data));
		}

		return tableRowForTableC;
	}

	private TableRow taleRowForTableD(int position ,Object data, boolean isChildrenView) {
		TableRow taleRowForTableD = new TableRow(this.context);

		int fixSize = getFixHeaderColumn();
		int loopCount = headers.length - fixSize;

		for (int x = 0; x < loopCount; x++) {
			TableRow.LayoutParams params = new TableRow.LayoutParams(
					headerCellsWidth[x + fixSize], LayoutParams.MATCH_PARENT);
//			params.setMargins(2, 2, 0, 0);

			View view = null ;
			
			if (isChildrenView == false) {
				view = getCellView(x + fixSize, data);
			}else {
				view = getChildCellView(x + fixSize, data);
			}
			
			if (view != null) {
				taleRowForTableD.addView(view, params);
				view.setTag(fixSize);
//				view.setOnClickListener(this);
			}
			
			view.setOnClickListener(new CellClickListener(position , isChildrenView , data));
			
		}

		return taleRowForTableD;
	}

	
	public boolean getGroupState(int groupIndex){
		return groupStates.get(groupIndex);
	}
	
	public void	setGroupState(int groupIndex , boolean result){
		groupStates.set(groupIndex, result);
	}
	
	
	
	
	public void expand(int start , int end) {
		
		for(int i = start ; i <= end; i ++){
			tableRowsC.get(i).setVisibility(View.VISIBLE);
			tableRowsD.get(i).setVisibility(View.VISIBLE);
		}
	}
	
	public void collapse(int start , int end){
		for(int i = start ; i <= end; i ++){
			tableRowsC.get(i).setVisibility(View.GONE);
			tableRowsD.get(i).setVisibility(View.GONE);
		}
	}
	
	public Drawable getDrawable(int id){
		return context.getResources().getDrawable(id);
	}
	
	
	public class CellClickListener implements OnClickListener {

		int position = 0 ;
		
		boolean isChildView = false ;
		
		Object data ;
		
		public CellClickListener(int position , boolean isChildView , Object data) {
			// TODO Auto-generated constructor stub
			this.position = position ;
			this.isChildView = isChildView ;
			this.data = data ;
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(cellClickListener != null){
				int offsize = (Integer) v.getTag() ;
				TableRow tableRow = (TableRow) v.getParent() ;
//				TableLayout tableLayout = (TableLayout) tableRow.getParent() ;
				int column = - 1;
				int row = -1;
				
				for(int i = 0 ; i < tableRow.getChildCount(); i ++){
					if(v == tableRow.getChildAt(i)){
						column = i ;
						column = column +offsize ;
					}
				}
				
				row = position ;
				cellClickListener.onCellClickListener(column, row, v , isChildView , data);
			}
		}
		
	}
}
