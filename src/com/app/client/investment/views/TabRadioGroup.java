package com.app.client.investment.views;

import java.util.ArrayList;
import java.util.List;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TabRadioGroup extends RadioGroup implements OnCheckedChangeListener , AnimatorListener{
	
	
	public static final int DELAY = 500 ;
	//default arg
	
	private Paint rectPaint;
	
	
	private List<Rectanger> rectangers = new ArrayList<Rectanger>();
	
	
	private Rectanger currentRectanger ;
	private Rectanger targetRectanget ;
	
	
	
	
	
	private OnCheckedChangeListener changeListener ;


	public TabRadioGroup(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initTab();
	}

	public TabRadioGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initTab();
	}

	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		if (isInEditMode() ) {
			return;
		}
		if (targetRectanget == null) {
			return ;
		}
		
		
		if (currentRectanger != null) {
			canvas.drawRect(currentRectanger.getRect(), rectPaint);
		}
		
	}
	
	private void updateView(int id , boolean isInit) {
		
		
		for(int i = 0 ; i < rectangers.size() ; i ++){
			Rectanger rectanger = rectangers.get(i);
			if (id == rectanger.getId()) {
				
				targetRectanget = rectanger ;
				break ;
			}
		}
		
		
		if (isInit) {
			try {
				currentRectanger = (Rectanger) targetRectanget.clone() ;
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			invalidate();
		}else {
			moveToTarget();
		}
		
		
	}
	
	
	
	
	private void initTab(){
		setWillNotDraw (false);
		rectPaint = new Paint();
		rectPaint.setAntiAlias(true);
		rectPaint.setStyle(Style.FILL);
		rectPaint.setColor(Color.BLACK);
		getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

			@SuppressWarnings("deprecation")
			@SuppressLint("NewApi")
			@Override
			public void onGlobalLayout() {

				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
					getViewTreeObserver().removeGlobalOnLayoutListener(this);
				} else {
					getViewTreeObserver().removeOnGlobalLayoutListener(this);
				}
				
				int id = getCheckedRadioButtonId();
				

				int tabCount = getChildCount();
				for(int i =  0; i < tabCount ; i ++){
					View childView = getChildAt(i);
					
					Rect rect = new Rect();
					childView.getHitRect(rect);
					rect.top = rect.top + rect.bottom ;
					rect.bottom = getHeight() ;
					Rectanger rectanger = new Rectanger(rect, TabRadioGroup.this , childView.getId());
					rectangers.add(rectanger);
					
				}
				
				if (id != 0 ) {
					updateView(id , true);
				}
				
			}
		});
		
		setOnCheckedChangeListener(this);
	}
	
	
	
	public void setTabColor(int color) {
		rectPaint.setColor(color);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		updateView(checkedId , false);
		
		if (changeListener != null) {
			changeListener.onCheckedChanged(group, checkedId);
		}
	}
	
	public void moveToTarget(){
		
		
		if (currentRectanger == null || targetRectanget == null) {
			return ;
		}
		ObjectAnimator animatorPosition = ObjectAnimator.ofInt(currentRectanger, "newLeft", targetRectanget.getNewLeft());
		
		ObjectAnimator animatorWidth = ObjectAnimator.ofInt(currentRectanger, "newWidth", targetRectanget.getRect().right - targetRectanget.getRect().left);
//		animator2.setInterpolator(new BounceInterpolator());
		
//		animator2.setDuration(1000);
//		animator2.start();
		AnimatorSet set = new AnimatorSet();
		set.addListener(this);
		set.play(animatorPosition).with(animatorWidth);
		set.setDuration(DELAY);
		set.start();
	}

	@Override
	public void onAnimationStart(Animator animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationEnd(Animator animation) {
		// TODO Auto-generated method stub
		currentRectanger.setId(targetRectanget.getId());
		currentRectanger.setRect(new Rect(targetRectanget.getRect()));
	}

	@Override
	public void onAnimationCancel(Animator animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationRepeat(Animator animation) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void setChangeListener(OnCheckedChangeListener changeListener) {
		this.changeListener = changeListener;
	}
}
