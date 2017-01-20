//package com.compilesense.liuyi.welcomerobottechstyle.view;
//
//import android.animation.Animator;
//import android.animation.ObjectAnimator;
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.BitmapShader;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.PorterDuff;
//import android.graphics.Rect;
//import android.util.AttributeSet;
//import android.widget.ImageView;
//
//import com.compilesense.liuyi.welcomerobottechstyle.R;
//
///**
// * Created by shenjingyuan002 on 2017/1/17.
// */
//
//public class VisitorHeaderView extends ImageView {
//    private final static int FACE_SIZE = 204;
//
//    private Bitmap faceBitmap = null;
//    private Bitmap decorateBitmap,decorateBitmap2;
//    private Bitmap fd,dd;
//    private Paint mPaint = new Paint(),mDecoPaint = new Paint();
//    private Rect rectSrc = new Rect(),rectDst = new Rect();
//    private ValueAnimator mAnimator;
//    BitmapShader faceShader,decorateShader;
//
//    public VisitorHeaderView(Context context) {
//        super(context);
//    }
//
//    public VisitorHeaderView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public VisitorHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        if (faceBitmap == null || faceBitmap.isRecycled()){
//            return;
//        }
//        drawFace(canvas);
//    }
//
//    public void setBitmap(Bitmap bitmap){
//        if (faceBitmap!=null && !faceBitmap.isRecycled()){
//            faceBitmap.recycle();
//        }
//        if (fd!=null && !fd.isRecycled()){
//            fd.recycle();
//        }
//        bitmap =  Bitmap.createScaledBitmap(bitmap, FACE_SIZE, FACE_SIZE, false);
//        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
//        int x = (bitmap.getWidth() - size) / 2;
//        int y = (bitmap.getHeight() - size) / 2;
//        float r = size / 2f;
//        faceBitmap= Bitmap.createBitmap(bitmap, x, y, size, size);
//        faceShader = new BitmapShader(faceBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
//        mPaint.setShader(faceShader);
//        mPaint.setAntiAlias(true);
//        fd = Bitmap.createBitmap(faceBitmap.getWidth(),faceBitmap.getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas faceCanvas = new Canvas(fd);
//        faceCanvas.drawCircle(r,r,r, mPaint);
//
//        //处理装饰
//        if (dd == null || dd.isRecycled()){
//            calculateInSampleSizeAndLoad();
//            decorateShader = new BitmapShader(decorateBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
//            mDecoPaint.setAlpha(200);
//            mDecoPaint.setShader(decorateShader);
//            mDecoPaint.setAntiAlias(true);
//            dd = Bitmap.createBitmap(decorateBitmap.getWidth(),decorateBitmap.getHeight(), Bitmap.Config.ARGB_8888);
//            Canvas decoCanvas = new Canvas(dd);
//            decoCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
//            decoCanvas.drawCircle(r,r,r, mDecoPaint);
//        }
//
//        if (decorateBitmap2 == null || decorateBitmap2.isRecycled()){
//            Bitmap cache = BitmapFactory.decodeResource(getResources(), R.drawable.face_decorate_outside);
//            decorateBitmap2 = Bitmap.createScaledBitmap(cache,363,362,false);
//            mDecoPaint2.setAntiAlias(true);
//        }
//        this.invalidate();
//    }
//
//    private void calculateInSampleSizeAndLoad(){
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        int scrWidth,scrHeight,dstWidth,dstHeight;
//        BitmapFactory.decodeResource(getResources(),R.drawable.face_decorate, options);
//        scrWidth   = options.outWidth;
//        scrHeight  = options.outHeight;
//        dstWidth  = FACE_SIZE;
//        dstHeight = FACE_SIZE;
//
//        int inSampleSize = 1;
//        if (scrHeight > dstHeight || scrWidth > dstWidth) {
//            // 计算出实际宽高和目标宽高的比率
//            final int heightRatio = Math.round((float) scrHeight / (float) dstHeight);
//            final int widthRatio = Math.round((float) scrWidth / (float) dstWidth);
//            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
//            // 一定都会大于等于目标的宽和高。
//            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
//        }
//        BitmapFactory.Options options1 = new BitmapFactory.Options();
//        options1.inSampleSize = inSampleSize;
//        Bitmap cache = BitmapFactory.decodeResource(getResources(),R.drawable.face_decorate,options1);
//        decorateBitmap = Bitmap.createScaledBitmap(cache, dstWidth, dstHeight, false);
//        cache.recycle();
//    }
//
//    void drawFace(Canvas canvas){
//        int size = Math.min(faceBitmap.getWidth(), faceBitmap.getHeight());
//        float r = size / 2f;
//        canvas.drawBitmap(decorateBitmap2,0,0,null);
//
//        rectSrc.set(0,0,fd.getWidth(),fd.getHeight());
//        int viewWith = getWidth();
//        int viewHeight = getHeight();
//        int cy = (int) (0.48*viewHeight);
//        int cx = (int) (0.52*viewWith);
//        rectDst.set(cx-fd.getWidth()/2,cy-fd.getHeight()/2,fd.getWidth()+fd.getWidth()/2,fd.getHeight()+fd.getHeight()/2 -fd.getHeight()/12 );
//        canvas.drawBitmap(fd,rectSrc,rectDst,null);
//        canvas.drawBitmap(dd,rectSrc,rectDst,null);
//    }
//}
