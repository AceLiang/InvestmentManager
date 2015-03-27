package com.app.client.investment;

import com.app.client.investment.utils.PhotoHelper;
import com.opensource.librarys.circleimageview.CircleImageView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity implements OnClickListener{
	
	
	private Button btnLogin ;
	private CircleImageView btnTakePhoto ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
		
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnTakePhoto = (CircleImageView) findViewById(R.id.btnTakePhoto);
		btnLogin.setOnClickListener(this);
		btnTakePhoto.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnLogin:
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			break;
		case R.id.btnTakePhoto:
			PhotoHelper photoHelper = new PhotoHelper() ;
			photoHelper.showSelectPhotoDialog(this);
			break ;

		default:
			break;
		}
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		
		if(resultCode == RESULT_OK){
			
			
			if (requestCode == PhotoHelper.SELECT_PICTURE) {
				Uri photoUriGallery = data.getData() ;
//				Log.i("showSelectPhotoDialog", "œ‡≤·:" + photoUriGallery.toString());
				new PhotoHelper().cropImageUri(this, photoUriGallery, 400, 400, PhotoHelper.CROP_PHOTO);
				
			}else if (requestCode == PhotoHelper.SELECT_CAMER) {
				Uri photoUriCamera = data.getData() ;
//				Log.i("showSelectPhotoDialog", "≈ƒ’’:" + photoUriCamera.toString());
				new PhotoHelper().cropImageUri(this, photoUriCamera, 400, 400, PhotoHelper.CROP_PHOTO);
			}else if (requestCode == PhotoHelper.CROP_PHOTO) {
				Uri photoUriTouxiang = data.getData();
//				Log.i("showSelectPhotoDialog", "≤√ºÙ∫Û:" + photoUriTouxiang.toString());
//				Bitmap bitmap = new PhotoHelper().decodeUriAsBitmap(this, photoUriTouxiang);
				btnTakePhoto.setImageURI(photoUriTouxiang);
//				btnTakePhoto.setImageBitmap(bitmap);
			}
		}
	}

}
