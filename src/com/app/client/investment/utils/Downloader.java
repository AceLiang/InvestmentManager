package com.app.client.investment.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import android.os.AsyncTask;
import android.util.Log;

public class Downloader {

	public static final int STATE_WAITE = 0 ;
	public static final int STATE_SUCCESS = 1 ;
	public static final int STATE_FAILD = 2 ;
	public static final int STATE_Start = 3 ;
	public static final int STATE_CANCEL = 4 ;
	public static final int STATE_PAUSE = 5 ;
	
	
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE = 1;

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
        }
    };

    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(128);

    /**
     * An {@link Executor} that can be used to execute tasks in parallel.
     */
    public static final Executor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
	
	public interface IDownLoadListener {
		public void updateProgress(int taskId , int progress);

		public void downloadSuccess(int taskId ,File targetFile);

		public void downloadFailed(int taskId , int state);
	}

	String urlFile;

	File targetFile;
	
	
	
	
	private int taskId = 0;
	
	

	private int state = STATE_WAITE;


	private IDownLoadListener downLoadListener;
	private DownloadTask downloadTask;
	private int timeout = 30 * 1000 ;
	
	private String pathCache ;

	public Downloader(String url, File targetFile,
			IDownLoadListener downLoadListener) {
		this.urlFile = url;
		this.targetFile = targetFile;
		this.downLoadListener = downLoadListener;
		pathCache = targetFile.getAbsolutePath() + ".temp";
	}
	
	
	public Downloader(String url, String targetFilePath,
			IDownLoadListener downLoadListener) {
		this.urlFile = url;
		targetFile = new File(targetFilePath);
		this.downLoadListener = downLoadListener;
		pathCache = targetFile.getAbsolutePath() + ".temp";
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public void cancel() {
		if (downloadTask != null) {
			downloadTask.cancel(true);
			
			state = STATE_CANCEL ;
		}
	}
	
	
	
	public void pause() {
		if (downloadTask != null) {
			downloadTask.cancel(true);
			state = STATE_PAUSE ;
		}
	}

	public void start() {
		
		if (state != STATE_Start) {
			initState();
			downloadTask = new DownloadTask();
			downloadTask.executeOnExecutor(THREAD_POOL_EXECUTOR , null);
		}
	}

	private void initState() {
		// TODO Auto-generated method stub
		state = STATE_WAITE;
	}

	public int getState() {
		return state;
	}
	private class DownloadTask extends AsyncTask<Void, Integer, Integer> {

		@Override
		protected Integer doInBackground(Void... params) {
			try {
				state = STATE_Start;
				URL url = new URL(urlFile);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setRequestProperty("Accept-Encoding", "identity");
				connection.setRequestMethod("GET");
				connection.setDoOutput(false);

				connection.connect();
				
				File caheFile = new File(pathCache);
				RandomAccessFile randomAccessFile = new RandomAccessFile(caheFile, "rwd");
				if (caheFile.exists()) {
					randomAccessFile.seek(caheFile.length());
				}
				
//				FileOutputStream fileOutputStream = new FileOutputStream(
//						targetFile);
				InputStream inputStream = connection.getInputStream();

//				long totalSize = connection.getContentLength();
				long totalSize = readFileSize(connection);
				long downloadedSize = randomAccessFile.getFilePointer();

				byte[] buffer = new byte[1024];
				int len = 0;
				while (isCancelled() == false && (len = readInputStreamWithTimeout(inputStream, buffer, timeout)) > 0 && totalSize > -1) {
//					fileOutputStream.write(buffer, 0, len);
					randomAccessFile.write(buffer, 0, len);
					downloadedSize = downloadedSize + len;

					int progress = (int) (100 * downloadedSize / totalSize) ;
					publishProgress(progress);
				}

				randomAccessFile.close();
				inputStream.close();
				connection.disconnect();
				if(totalSize != -1 ){
					if(downloadedSize == totalSize){
						
						File fileCache = new File(pathCache);
						fileCache.renameTo(targetFile);
						state = STATE_SUCCESS;
					}else{
						state = STATE_FAILD;
					}
					
				}else{
					state = STATE_FAILD;
				}
				
				
				if (state == STATE_CANCEL) {
					caheFile.delete();
				}
				

			} catch (MalformedURLException e) {
				e.printStackTrace();
				state = STATE_FAILD;
			} catch (IOException e) {
				e.printStackTrace();
				state = STATE_FAILD;
			}

			return state;
		}
		
		
		

		@Override
		protected void onProgressUpdate(Integer... progress) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(progress);
			downLoadListener.updateProgress(taskId , progress[0]);
		}


		@Override
		protected void onCancelled(Integer result) {
			// TODO Auto-generated method stub
			super.onCancelled(result);
			downLoadListener.downloadFailed(taskId ,result);
		}
		
		@Override
		protected void onPostExecute(Integer result) {
			// TODO Auto-generated method stub
			
			switch (result) {
			case STATE_SUCCESS:
				downLoadListener.downloadSuccess(taskId ,targetFile);
				break;

			default:
				downLoadListener.downloadFailed(taskId , result);
				break;
			}
		}


		/********
		 * @author Mattliang@apjcorp.com
		 * @version 1.0
		 * @date Dec 9, 2014
		 * 说明：读取文件大小。如果需要下载的文件大于2GB，就会
		 * 导致整数溢出。getContentLength返回的就是int。整数溢出
		 * @param connection
		 * @return
		 */
		private long readFileSize(HttpURLConnection connection) {
			long fileSize = -1 ;
			int responseCode = 0;
			try {
				responseCode = connection.getResponseCode();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	        if (responseCode >= 400) {
	 
	            Log.i("", "Web服务器响应错误!");
	 
	            return fileSize;
	 
	        }
	 
			Map<String, List<String>> map = connection.getHeaderFields();

			if (map != null) {
				Set<String> set = map.keySet();

				for (String key : set) {
//					System.out.println(key + " " + connection.getHeaderField(key));

					if (key != null && key.equals("Content-Length")) {
						System.out.println("文件大小ContentLength:"
								+ connection.getContentLength());

						fileSize = Long.parseLong(connection.getHeaderField(key));

						break;
					}
				}
			}
			
	        
	 
	        return fileSize;
		}

		public int readInputStreamWithTimeout(InputStream is, byte[] b,
				int timeoutMillis) throws IOException {
			int bufferOffset = 0;
			long maxTimeMillis = System.currentTimeMillis() + timeoutMillis;
			while (System.currentTimeMillis() < maxTimeMillis
					&& bufferOffset < b.length) {
				int readLength = java.lang.Math.min(is.available(), b.length
						- bufferOffset);
				// can alternatively use bufferedReader, guarded by isReady():
				int readResult = is.read(b, bufferOffset, readLength);
				if (readResult == -1)
					break;
				bufferOffset += readResult;
			}
			return bufferOffset;
		}

	}
}
