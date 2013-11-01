package com.example.tp_android_hw;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class Task extends AsyncTask<String, Void, Bitmap> 
{
        private ImageView imageView;
        
        
        public Task(ImageView imageView)
        {
                this.imageView = imageView;
        }
        
        @Override
        protected Bitmap doInBackground(String... urls) 
        {
                String url = "";
        if( urls.length > 0 ){
                url = urls[0];                            
        }

        InputStream input = null;
        try {
               URL urlConn = new URL(url);
               HttpURLConnection conn = (HttpURLConnection)urlConn.openConnection();
               conn.setConnectTimeout(10000);
               conn.setReadTimeout(10000);
               conn.setInstanceFollowRedirects(true);
               input = conn.getInputStream();
        }
        catch (MalformedURLException e) {
                   e.printStackTrace();
        }
        catch (IOException e) {
                e.printStackTrace();
        }
        catch (Exception e){
                e.printStackTrace();
        }
        
        return BitmapFactory.decodeStream(input);
        }
        
        @Override
    protected void onPostExecute(Bitmap result) {
         super.onPostExecute(result);
         System.out.println("onPostExecute");
         imageView.setImageBitmap(result);
    }
        
}