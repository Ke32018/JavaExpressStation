package 快递e栈.net;

import 快递e栈.Dao.ExpressDao;
import 快递e栈.bean.Express;

import javax.sound.sampled.Port;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {
    private static final int PORT = 10086;
    private ExpressDao dao = new ExpressDao();
    private ServerSocket server;

    public static void main(String[] args) {
        Server s = new Server();
        s.start();
    }

    public void start() {
        //start用于打开服务器并新开线程等待客户端连接
        new Thread(() -> {
            //lambda用法
            try {
                server = new ServerSocket(PORT);
                System.out.println("（服务器）：服务器已启动，端口：" + PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                new Thread(() -> {
                    System.out.println("线程"+Thread.currentThread().getName()+"为您服务");
                    try {
                        Socket client = server.accept();
                        System.out.println("（服务器）：客户端" + Thread.currentThread().getName() + "已连接");
                        //新建方法处理客户端请求
                        requestHandler(client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }).start();
    }

    private void requestHandler(Socket client) throws IOException {
        InputStream in;
        ObjectInputStream objIn = null;
        OutputStream out;
        ObjectOutputStream objOut = null;

        try {
            in = client.getInputStream();
            objIn = new ObjectInputStream(in);
            out = client.getOutputStream();
            objOut = new ObjectOutputStream(out);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objIn != null) objIn.close();
                if (objOut != null) objOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String flag = objIn.readUTF();
        if ("findAll".equals(flag)) {
            HashSet<Express> data = dao.printAll();
            objOut.writeObject(
                    (data != null || !data.isEmpty()) ? data : "没有数据被存储"
            );
        }
    }
}
