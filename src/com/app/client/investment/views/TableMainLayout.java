package com.app.client.investment.views;

import com.app.client.investment.manager.TableMainLayoutAdapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

//https://www.codeofaninja.com/2013/08/android-scroll-table-fixed-header-column.html
public class TableMainLayout extends RelativeLayout {

	private Context context;

	TableLayout tableA;
	TableLayout tableB;
	TableLayout tableC;
	TableLayout tableD;

	HorizontalScrollView horizontalScrollViewB;
	HorizontalScrollView horizontalScrollViewD;

	ScrollView scrollViewC;
	ScrollView scrollViewD;

	BaseTableMainLayoutAdapter adapter;

	public TableMainLayout(Context context) {
		super(context);
		this.context = context;
		init();
	}

	public TableMainLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context = context;
		init();
	}

	public TableMainLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
		init();
	}

	private void init() {
		// initialize the main components (TableLayouts, HorizontalScrollView,
		// ScrollView)
		this.initComponents();
		this.setComponentsId();
		this.setScrollViewAndHorizontalScrollViewTag();

		// no need to assemble component A, since it is just a table
		this.horizontalScrollViewB.addView(this.tableB);

		this.scrollViewC.addView(this.tableC);

		this.scrollViewD.addView(this.horizontalScrollViewD);
		this.horizontalScrollViewD.addView(this.tableD);

		this.addComponentToMainLayout();

		 this.setBackgroundColor(Color.WHITE);
	}

	// initalized components
	private void initComponents() {

		this.tableA = new TableLayout(this.context);
		this.tableB = new TableLayout(this.context);
		this.tableC = new TableLayout(this.context);
		this.tableD = new TableLayout(this.context);

		this.horizontalScrollViewB = new MyHorizontalScrollView(this.context);
		this.horizontalScrollViewD = new MyHorizontalScrollView(this.context);

		this.scrollViewC = new MyScrollView(this.context);
		this.scrollViewD = new MyScrollView(this.context);

		// this.tableA.setBackgroundColor(Color.GREEN);
		// this.horizontalScrollViewB.setBackgroundColor(Color.LTGRAY);

	}

	// set essential component IDs
	private void setComponentsId() {
		this.tableA.setId(1);
		this.horizontalScrollViewB.setId(2);
		this.scrollViewC.setId(3);
		this.scrollViewD.setId(4);
	}

	// set tags for some horizontal and vertical scroll view
	private void setScrollViewAndHorizontalScrollViewTag() {

		this.horizontalScrollViewB.setTag("horizontal scroll view b");
		this.horizontalScrollViewD.setTag("horizontal scroll view d");

		this.scrollViewC.setTag("scroll view c");
		this.scrollViewD.setTag("scroll view d");
	}

	// we add the components here in our TableMainLayout
	private void addComponentToMainLayout() {

		// RelativeLayout params were very useful here
		// the addRule method is the key to arrange the components properly
		RelativeLayout.LayoutParams componentB_Params = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		componentB_Params.addRule(RelativeLayout.RIGHT_OF, this.tableA.getId());

		RelativeLayout.LayoutParams componentC_Params = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		componentC_Params.addRule(RelativeLayout.BELOW, this.tableA.getId());

		RelativeLayout.LayoutParams componentD_Params = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		componentD_Params.addRule(RelativeLayout.RIGHT_OF,
				this.scrollViewC.getId());
		componentD_Params.addRule(RelativeLayout.BELOW,
				this.horizontalScrollViewB.getId());

		// 'this' is a relative layout,
		// we extend this table layout as relative layout as seen during the
		// creation of this class
		this.addView(this.tableA);
		this.addView(this.horizontalScrollViewB, componentB_Params);
		this.addView(this.scrollViewC, componentC_Params);
		this.addView(this.scrollViewD, componentD_Params);

	}

	public BaseTableMainLayoutAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(BaseTableMainLayoutAdapter adapter) {
		this.adapter = adapter;
		// ÒÆ³ýÍ·²¿
		tableA.removeAllViews();
		tableB.removeAllViews();
		// ÒÆ³ýÄÚÈÝ
		tableC.removeAllViews();
		tableD.removeAllViews();

		addTableRowToTableA();
		addTableRowToTableB();

		resizeHeaderHeight();

		getTableRowHeaderCellWidth(adapter.getHeaderCellsWidth());

		adapter.generateTableC_AndTable_D(tableC, tableD);

		resizeBodyTableRowHeight();
	}

	private void addTableRowToTableA() {
		this.tableA.addView(this.adapter.componentATableRow());
	}

	private void addTableRowToTableB() {
		this.tableB.addView(this.adapter.componentBTableRow());
	}

	// resizing TableRow height starts here
	void resizeHeaderHeight() {

		TableRow productNameHeaderTableRow = (TableRow) this.tableA
				.getChildAt(0);
		TableRow productInfoTableRow = (TableRow) this.tableB.getChildAt(0);

		int rowAHeight = this.viewHeight(productNameHeaderTableRow);
		int rowBHeight = this.viewHeight(productInfoTableRow);

		TableRow tableRow = rowAHeight < rowBHeight ? productNameHeaderTableRow
				: productInfoTableRow;
		int finalHeight = rowAHeight > rowBHeight ? rowAHeight : rowBHeight;

		this.matchLayoutHeight(tableRow, finalHeight);
	}

	// read a view's height
	private int viewHeight(View view) {
		view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
		return view.getMeasuredHeight();
	}

	// read a view's width
	private int viewWidth(View view) {
		view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
		return view.getMeasuredWidth();
	}

	// match all height in a table row
	// to make a standard TableRow height
	private void matchLayoutHeight(TableRow tableRow, int height) {

		int tableRowChildCount = tableRow.getChildCount();

		// if a TableRow has only 1 child
		if (tableRow.getChildCount() == 1) {

			View view = tableRow.getChildAt(0);
			TableRow.LayoutParams params = (TableRow.LayoutParams) view
					.getLayoutParams();
			params.height = height - (params.bottomMargin + params.topMargin);

			return;
		}

		// if a TableRow has more than 1 child
		for (int x = 0; x < tableRowChildCount; x++) {

			View view = tableRow.getChildAt(x);

			TableRow.LayoutParams params = (TableRow.LayoutParams) view
					.getLayoutParams();

			if (!isTheHeighestLayout(tableRow, x)) {
				params.height = height
						- (params.bottomMargin + params.topMargin);
				return;
			}
		}

	}

	// check if the view has the highest height in a TableRow
	private boolean isTheHeighestLayout(TableRow tableRow, int layoutPosition) {

		int tableRowChildCount = tableRow.getChildCount();
		int heighestViewPosition = -1;
		int viewHeight = 0;

		for (int x = 0; x < tableRowChildCount; x++) {
			View view = tableRow.getChildAt(x);
			int height = this.viewHeight(view);

			if (viewHeight < height) {
				heighestViewPosition = x;
				viewHeight = height;
			}
		}

		return heighestViewPosition == layoutPosition;
	}

	void getTableRowHeaderCellWidth(int headerCellsWidth[]) {

		// just seeing some header cell width
		for (int x = 0; x < headerCellsWidth.length; x++) {
			Log.v("TableMainLayout.java", headerCellsWidth[x] + "");
		}

		int tableAChildCount = ((TableRow) this.tableA.getChildAt(0))
				.getChildCount();
		int tableBChildCount = ((TableRow) this.tableB.getChildAt(0))
				.getChildCount();

		for (int x = 0; x < (tableAChildCount + tableBChildCount); x++) {
			if (x < tableAChildCount) {
				headerCellsWidth[x] = this.viewWidth(((TableRow) this.tableA
						.getChildAt(0)).getChildAt(x));
			} else {
				headerCellsWidth[x] = this.viewWidth(((TableRow) this.tableB
						.getChildAt(0)).getChildAt(x - tableAChildCount));
			}

		}
	}

	// resize body table row height
	void resizeBodyTableRowHeight() {

		int tableC_ChildCount = this.tableC.getChildCount();

		for (int x = 0; x < tableC_ChildCount; x++) {

			TableRow productNameHeaderTableRow = (TableRow) this.tableC
					.getChildAt(x);
			TableRow productInfoTableRow = (TableRow) this.tableD.getChildAt(x);

			int rowAHeight = this.viewHeight(productNameHeaderTableRow);
			int rowBHeight = this.viewHeight(productInfoTableRow);

			TableRow tableRow = rowAHeight < rowBHeight ? productNameHeaderTableRow
					: productInfoTableRow;
			int finalHeight = rowAHeight > rowBHeight ? rowAHeight : rowBHeight;

			this.matchLayoutHeight(tableRow, finalHeight);
		}

	}
	
	

	// horizontal scroll view custom class
	class MyHorizontalScrollView extends HorizontalScrollView {

		public MyHorizontalScrollView(Context context) {
			super(context);
		}

		@Override
		protected void onScrollChanged(int l, int t, int oldl, int oldt) {
			String tag = (String) this.getTag();

			if (tag.equalsIgnoreCase("horizontal scroll view b")) {
				horizontalScrollViewD.scrollTo(l, 0);
			} else {
				horizontalScrollViewB.scrollTo(l, 0);
			}
		}

	}

	// scroll view custom class
	class MyScrollView extends ScrollView {

		public MyScrollView(Context context) {
			super(context);
		}

		@Override
		protected void onScrollChanged(int l, int t, int oldl, int oldt) {

			String tag = (String) this.getTag();

			if (tag.equalsIgnoreCase("scroll view c")) {
				scrollViewD.scrollTo(0, t);
			} else {
				scrollViewC.scrollTo(0, t);
			}
		}
	}

}
