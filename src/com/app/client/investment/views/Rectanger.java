package com.app.client.investment.views;

import android.graphics.Rect;
import android.view.View;

public class Rectanger implements Cloneable{

	int newLeft ;
	int newWidth ;


	private Rect rect ;
	
	public void setRect(Rect rect) {
		this.rect = rect;
	}

	private View view ;
	
	
	private int id ;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Rectanger() {
		// TODO Auto-generated constructor stub
	}
	public Rectanger(Rect rect , View view  , int id) {
		// TODO Auto-generated constructor stub
		this.rect = rect ;
		newLeft = this.rect.left ;
		newWidth = this.rect.right - this.rect.left ;
		this.view = view ;
		this.id = id;
	}
	public int getNewLeft() {
		return newLeft;
	}

	public void setNewLeft(int newLeft) {
		this.newLeft = newLeft;
		int offset = rect.left - newLeft ;
		rect.left = newLeft ;
		rect.right = rect.right - offset ;
		view.postInvalidate();
	}
	
	
	public int getNewWidth() {
		return newWidth;
	}
	public void setNewWidth(int newWidth) {
		this.newWidth = newWidth;
		this.rect.right = this.rect.left + newWidth;
		view.postInvalidate();
	}
	
	public int getId() {
		return id;
	}
	public Rect getRect() {
		return rect;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		Rectanger rectanger = (Rectanger) super.clone() ;
		Rect rect = new Rect(rectanger.getRect());
		rectanger.rect = rect ;
		return rectanger;
	}
	
	
	
	
}
