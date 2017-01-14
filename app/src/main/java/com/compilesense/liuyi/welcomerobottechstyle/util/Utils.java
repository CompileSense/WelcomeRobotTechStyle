package com.compilesense.liuyi.welcomerobottechstyle.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.compilesense.liuyi.welcomerobottechstyle.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by shenjingyuan002 on 16/9/26.
 */

public class Utils {
    static public int calculateInSampleSize(String imagePath, ImageView imageView){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);

        int scrWidth   = options.outWidth;
        int scrHeight  = options.outHeight;
        int viewWidth  = imageView.getMaxWidth();
        int viewHeight = imageView.getMaxHeight();
        int inSampleSize = 1;

        if (scrHeight > viewHeight || scrWidth > viewWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) scrHeight / (float) viewHeight);
            final int widthRatio = Math.round((float) scrWidth / (float) viewWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    static public int dp2px(int dp,Context context){
        DisplayMetrics metric = context.getResources().getDisplayMetrics();
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）
        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
        Log.d("dp2px","densityDpi:"+densityDpi);
        Log.d("dp2px","dp:"+dp);
        return dp*(densityDpi/160);
    }

    static public int calculateInSampleSize(Context context, int imageRes, ImageView imageView){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(),imageRes, options);

        int scrWidth   = options.outWidth;
        int scrHeight  = options.outHeight;
        int viewWidth  = imageView.getMaxWidth();
        int viewHeight = imageView.getMaxHeight();
        int inSampleSize = 1;

        if (scrHeight > viewHeight || scrWidth > viewWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) scrHeight / (float) viewHeight);
            final int widthRatio = Math.round((float) scrWidth / (float) viewWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        if (imageRes == R.drawable.weather_bg){
            Log.d("Utils","scrWidth:"+scrWidth);
            Log.d("Utils","viewWidth:"+viewWidth);
            Log.d("Utils","sampleSize:"+inSampleSize);
        }

        return inSampleSize;
    }

    public static Bitmap bitmapIntoImageView(Context context,ImageView imageView,int resId){
        int sampleSize = Utils.calculateInSampleSize(context, resId, imageView);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),resId,options);
        imageView.setImageBitmap(bitmap);
        return bitmap;
    }

    public static Bitmap bitmapIntoImageView(Context context,ImageView imageView,int resId,int inSampleSize){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),resId,options);
        imageView.setImageBitmap(bitmap);
        return bitmap;
    }

    public static String saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "FaceImage");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getPath())));

        return file.getPath();
    }

    public static String saveImageToGalleryWithoutNotify(Context context, Bitmap bmp) {
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "prismaImage");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file.getPath();
    }

    public static String string2jsonString(String s){

        s = s.replace("\\","");
        int length = s.length();
        s = s.substring(1,length -1);

        int a = s.indexOf("[");
        int b = s.indexOf("]");

        if (a != -1 && b != -1){
            String r;
            if (s.charAt(a - 1) == '\"'){
                String aa = s.substring(0, a - 1 );
                String bb = s.substring(a, b + 1);
                String cc = s.substring(b + 2);
                r = aa + bb + cc;
                return r;
            }
        }
        return s;
    }

    public static Bitmap getBitmapFromAssets(Context context){
        try {
            AssetManager assetManager = context.getAssets();
            InputStream is = assetManager.open("wlh.jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] bitmap2ByteArray(Bitmap bitmap){
        ByteArrayOutputStream bStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bStream);
        return bStream.toByteArray();
    }

    public static byte[] uri2ByteArray(Uri uri, Context context)throws IOException {
        // this dynamically extends to take the bytes you read
        InputStream inputStream = context.getContentResolver().openInputStream(uri);
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        // this is storage overwritten on each iteration with bytes
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        // we need to know how may bytes were read to write them to the byteBuffer
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        // and then we can return your byte array.
        return byteBuffer.toByteArray();
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof NinePatchDrawable) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        } else {
            return null;
        }
    }


    static public String getMac() {
        String macSerial = null;
        String str = "";

        try {
            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str;) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (IOException ex) {
            // 赋予默认值
            ex.printStackTrace();
        }
        return macSerial;
    }
}
