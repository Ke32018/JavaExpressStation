package 快递e栈.Main;

import 快递e栈.bean.Express;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ServerClient {
    public static void main(String[] args) throws IOException {
        ServerSocket sever = new ServerSocket(34765);
        System.out.println("服务器启动完毕");
        while(true){
            Socket socket = sever.accept();
            System.out.println("一个线程已连接客户端");
            new Thread(){
                @Override
                public void run() {
                        try {
                            OutputStream os = socket.getOutputStream();
                            FileOutputStream fos = new FileOutputStream("data.txt");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            }.start();
        }
    }
}
