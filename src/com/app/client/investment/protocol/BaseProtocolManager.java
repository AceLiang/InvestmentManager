package com.app.client.investment.protocol;

import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import android.support.v4.util.LruCache;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageContainer;

public class BaseProtocolManager {
	
	private static final int DEFAULT_MAX_IMAGE_CACHE_SIZE = 20 ;
	
	private RequestQueue queue ;
	
	private ImageLoader imageLoader ;

	

	private Context context ;
	
	public BaseProtocolManager(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context ;
		initRequestQueue();
		
		
		
		imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
			
			private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(DEFAULT_MAX_IMAGE_CACHE_SIZE);
			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				cache.put(url, bitmap);
			}
			
			@Override
			public Bitmap getBitmap(String url) {
				return cache.get(url);
			}
		});
	}

	private void initRequestQueue() {
		// TODO Auto-generated method stub
		HttpStack stack = null ;
		// If the device is running a version >= Gingerbread...
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
		    // ...use HttpURLConnection for stack.
			stack = new HurlStack() ;
		} else {
		    // ...use AndroidHttpClient for stack.
			String userAgent = "volley/0";
	        try {
	            String packageName = context.getPackageName();
	            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
	            userAgent = packageName + "/" + info.versionCode;
	        } catch (NameNotFoundException e) {
	        }
			stack = new HttpClientStack(AndroidHttpClient.newInstance(userAgent));
		}
		
		// Instantiate the cache
		Cache cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024); // 1MB cap
		// Set up the network as the HTTP client.
		Network network = new BasicNetwork(stack);
		
		// Instantiate the RequestQueue with the cache and network.
		queue = new RequestQueue(cache, network);
		// Start the queue
		queue.start();
	}
	
	
	public RequestQueue getQueue() {
		return queue;
	}
	
	public ImageLoader getImageLoader() {
		return imageLoader;
	}
	
	
	public void cancelAll(Object tag) {
		queue.cancelAll(tag);
	}

	
	
	public void addRequest(Request request) {
		queue.add(request);
	}
	
	
	public void addRequestBlock(Request request) {
		if (IsNetworkAvailable()) {
			queue.add(request);
		}else {
			//µ¯³ö¶Ô»°¿ò
		}
	}
	
	
	public boolean IsNetworkAvailable() {
		ConnectivityManager connManager = (ConnectivityManager) context
			    .getSystemService(Context.CONNECTIVITY_SERVICE);
		
		NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
		
		if (networkInfo == null) {
			return false ;
		}else {
			boolean ret =networkInfo.isConnected();
			return ret ;
		}
	}
	
}
