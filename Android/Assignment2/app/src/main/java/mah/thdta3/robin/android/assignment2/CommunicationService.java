package mah.thdta3.robin.android.assignment2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class CommunicationService extends Service {

    private RunOnThread thread;
    private int port = 7117;
    private String ip = "195.178.227.53";

    private Buffer<String> buffer;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Receive receive;
    private InetAddress address;
    private Socket socket;
    private Exception exception;



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        thread = new RunOnThread();
        buffer = new Buffer<>();
        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new LocalService();
    }

    public class LocalService extends Binder {

        public CommunicationService getService(){
            return CommunicationService.this;
        }

    }


    public void connect(){
        Log.d("tracking", " In CommunicationService, starting connection");
        thread.start();
        thread.execute(new Connect());
        Log.d("tracking"," Finished with Connect");
    }

    public void disconnect(){
        thread.execute(new Disconnect());
    }

    public void sendInformation(JSONObject jsonObject){
        thread.execute(new Send(jsonObject));
    }

    public String receiveInformation() throws InterruptedException{
        return buffer.get();
    }

    public Exception getException(){
        Exception result = exception;
        exception = null;
        return result;
    }


    private class Receive extends Thread{
        @Override
        public void run() {
            String result;
            try{
                while(receive != null){
                    result = inputStream.readUTF();
                    Log.d("RECIEVED FOLLOWING", result);
                    buffer.put(result);
                }
            }catch(Exception e){
                receive = null;
            }
        }
    }

    private class Connect implements Runnable{

        @Override
        public void run() {
            try{
                address = InetAddress.getByName(ip);
                Log.d("tracking","Address: " + address);
                socket = new Socket(ip, port);
                Log.d("tracking"," we did it?");
                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.flush();
                buffer.put("CONNECTED");
                receive = new Receive();
                receive.start();
            }catch (Exception e){
                exception = e;
                Log.d("tracking", e.toString());
                buffer.put("EXCEPTION");
            }
        }
    }

    private class Disconnect implements Runnable{
        @Override
        public void run() {
            try{
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
                if(socket != null)
                    socket.close();
                thread.stop();
                buffer.put("CLOSED");
                //Log.d("DISCONNECT", "DISCONNECTED");
            }catch(IOException e){
                exception = e;
                buffer.put("EXCEPTION");
            }
        }
    }

    private class Send implements Runnable{
        private JSONObject jsonObject;

        public Send(JSONObject jsonObject){
            this.jsonObject = jsonObject;
        }
        @Override
        public void run() {

            Log.d("JSONOBJECT", "" + jsonObject.toString());
            try {
                outputStream.writeUTF(jsonObject.toString());
                outputStream.flush();
            }catch(IOException e){
                exception = e;
                buffer.put("EXCEPTION");
            }
        }
    }
}
