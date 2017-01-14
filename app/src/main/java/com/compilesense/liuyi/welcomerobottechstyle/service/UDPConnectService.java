package com.compilesense.liuyi.welcomerobottechstyle.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.compilesense.liuyi.welcomerobottechstyle.javabean.UISettingBean;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.VisitorsInfoBean;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;

public class UDPConnectService extends Service {
    private static final String TAG = "UDPConnectService";
    private DatagramSocket socket;
    // UDP广播IP和PORT
    public static final String SERVER_IP_TEST = "192.168.0.62";
    public static final int SERVER_PORT_TEST = 11000;

    public static final String KEY_SERVICE_IP = "ip";
    public static final String KEY_SERVICE_PORT = "port";
    private String serviceIp;
    private int servicePort;
    private String mMacString;
    private byte[] mMacBuffer;
    private InetAddress serverAddress;
//    private WifiManager.MulticastLock lock;
    private boolean receiving = false;
    
    private TimerTask mHeartBeatTask = null;
    private Timer mHeartBeatTimer;
    class HeartBeatTask extends TimerTask {
        @Override
        public void run() {
            DatagramPacket packet = new DatagramPacket(mMacBuffer,
                    mMacBuffer.length,
                    serverAddress,
                    servicePort);
            try {
                socket.send(packet);
//                Log.d(TAG,"发送UDP心跳广播,address:"+serverAddress+",servicePort:"+servicePort);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private TimerTask mTestTimerTask = new TimerTask() {
        @Override
        public void run() {
            InetAddress local = null;
            try {
                local = InetAddress.getByName("localhost"); // 本机测试
                Log.d(TAG,"test:"+"已找到本地监听端");
                String test = UISettingBean.testJsonString;
                test = test.trim();
                byte[] buffer = test.getBytes();
                DatagramSocket socket = new DatagramSocket();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, local, SERVER_PORT_TEST);
                socket.send(packet);
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private TimerTask mTestTimerTask2 = new TimerTask() {
        @Override
        public void run() {
            InetAddress local = null;
            try {
                Thread.sleep(2000);
                local = InetAddress.getByName("localhost"); // 本机测试
                Log.d(TAG,"test:"+"已找到本地监听端");
                String test = VisitorsInfoBean.testJsonString1;
                test = test.trim();
                byte[] buffer = test.getBytes();
                DatagramSocket socket = new DatagramSocket();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, local, SERVER_PORT_TEST);
                socket.send(packet);
                Log.e(TAG,"发送测试广播1");
                socket.close();

                Thread.sleep(1000);
                test = VisitorsInfoBean.testJsonString2;
                test = test.trim();
                buffer = test.getBytes();
                DatagramSocket socket2 = new DatagramSocket();
                DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length, local, SERVER_PORT_TEST);
                socket2.send(packet2);
                Log.e(TAG,"发送测试广播2");
                socket2.close();

                Thread.sleep(1000);
                test = VisitorsInfoBean.testJsonString3;
                test = test.trim();
                buffer = test.getBytes();
                DatagramSocket socket3 = new DatagramSocket();
                DatagramPacket packet3 = new DatagramPacket(buffer, buffer.length, local, SERVER_PORT_TEST);
                socket3.send(packet3);
                Log.e(TAG,"发送测试广播3");
                socket3.close();

                Thread.sleep(1000);
                test = VisitorsInfoBean.testJsonString3;
                test = test.trim();
                buffer = test.getBytes();
                DatagramSocket socket4 = new DatagramSocket();
                DatagramPacket packet4 = new DatagramPacket(buffer, buffer.length, local, SERVER_PORT_TEST);
                socket4.send(packet4);
                Log.e(TAG,"发送测试广播4");
                socket4.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private Thread mConnectWorkerThread;
    private ConnectWorker mConnectWorker;
    private class ConnectWorker implements Runnable{
        @Override
        public void run() {
            try {
                serverAddress = InetAddress.getByName(serviceIp);
                System.out.println("Client: Start connecting\n");
//                socket = new DatagramSocket(servicePort);
                socket = new DatagramSocket(servicePort);

            } catch (Exception e) {
                e.printStackTrace();
            }

            Log.d(TAG,"启动心跳");
            mHeartBeatTimer = new Timer();
            mHeartBeatTask = new HeartBeatTask();
            mHeartBeatTimer.schedule(mHeartBeatTask, 1000, 6*1000);

//            Timer testT = new Timer();
//            testT.schedule(mTestTimerTask, 2000);
//            Timer timerT2 = new Timer();
//            timerT2.schedule(mTestTimerTask2, 1000, 1500);

            // 接收UDP广播，有的手机不支持
            while (receiving) {
                byte[] data = new byte[1024*1024];
                DatagramPacket recpacket = new DatagramPacket(data, data.length);
                try {
//                    lock.acquire();
                    socket.receive(recpacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String recString = new String(recpacket.getData(),0,recpacket.getLength());
                recString = recString.trim();
                Log.d(TAG,"收到广播:" + recString);
                System.out.println("Server: IP " + recpacket.getAddress() + "’\n");

                boolean handleResult = handleDataFromService(recString, new DataHandleListener(){
                    @Override
                    public void visitors(VisitorsInfoBean visitorsInfoBean,String visitorsInfoBeanJsonString) {
                        if (visitorsInfoBean == null){
                            return;
                        }
                        Log.d(TAG,"visitor发送广播");
//                        String id = visitorsInfoBean.getMessage().getVisitors().get(0).getPersonId();
                        sendData2Activity(visitorsInfoBeanJsonString);
                    }

                    @Override
                    public void uiSettings(UISettingBean uiSettingBean, String uiSettingBeanJsonString){
                        if (uiSettingBean == null){
                            return;
                        }
                        Log.d(TAG,"uiSetting发送广播");
                        sendData2Activity(uiSettingBeanJsonString, 0);
                    }
                });
                if (!handleResult){
                    Log.e(TAG,"无法处理的数据格式");
                }

                //释放 lock
//                lock.release();
            }
        }
    }

    public UDPConnectService() {
        mConnectWorker = new ConnectWorker();
        mMacString = Utils.getMac();
        mMacBuffer = mMacString.getBytes();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //有的机器没有打开UDP,可以通过 WifiManager 打开
//        WifiManager manager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
//        lock = manager.createMulticastLock("test wifi");

        if (intent != null){
            serviceIp = intent.getStringExtra(KEY_SERVICE_IP);
            servicePort = intent.getIntExtra(KEY_SERVICE_PORT,-1);
        }else {
            Log.e(TAG,"intent == null");
        }

        if (serviceIp == null || servicePort == -1){
            serviceIp = SERVER_IP_TEST;
            servicePort = SERVER_PORT_TEST;
        }

        if (serviceIp.equals("") || servicePort == 0){
            serviceIp = SERVER_IP_TEST;
            servicePort = SERVER_PORT_TEST;
        }

        Log.d(TAG,"UDP连接参数 IP:"+serviceIp+",Port:"+servicePort);
        receiving = true;

        if (mConnectWorkerThread == null){
            mConnectWorkerThread = new Thread(mConnectWorker);
            mConnectWorkerThread.start();
        }

        Log.e(TAG,"后台服务开启");
        return START_STICKY;//服务被销毁后自动启动
    }

    interface DataHandleListener {
        void visitors(VisitorsInfoBean visitorsInfoBean, String visitorsInfoBeanJsonString);
        void uiSettings(UISettingBean uiSettingBean, String uiSettingBeanJsonSting);//因为数据通过 intent 传播也需要序列化,这里就直接传递jsonString.
    }

    private boolean handleDataFromService(String data, DataHandleListener listener){
        Log.d(TAG,"DataFromService:" + data);
        Gson gson = new Gson();
        VisitorsInfoBean visitorsInfoBean = null;
        UISettingBean uiSettingBean = null;

        try {
            visitorsInfoBean = gson.fromJson(data, VisitorsInfoBean.class);
            if (visitorsInfoBean.getAction() == 1){
                listener.visitors(visitorsInfoBean, data);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            uiSettingBean = gson.fromJson(data, UISettingBean.class);
            if (visitorsInfoBean.getAction() == 2){
                listener.uiSettings(uiSettingBean, data);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        socket.close();
    }

    private void sendData2Activity(String params, int i){
//        Intent intent = new Intent();
//        intent.setAction(MainActivity.VisitorArriveBroadcastReceiver.ACTION);
//        intent.putExtra(MainActivity.VisitorArriveBroadcastReceiver.KEY_UI_UPDATA, params);
//        sendBroadcast(intent);
    }

    private void sendData2Activity(String personInfoJson){
//        Intent intent = new Intent();
//        intent.setAction(MainActivity.VisitorArriveBroadcastReceiver.ACTION);
//        intent.putExtra(MainActivity.VisitorArriveBroadcastReceiver.KEY_PERSON_INFO, personInfoJson);
//        sendBroadcast(intent);
    }

//    class VisitorArriveBean {
//        public int cation;
//        public List<VisitorBean> visitors;
//    }
//    class VisitorBean{
//        String personId;
//    }

}
