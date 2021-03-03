package 快递e栈.Main;

import 快递e栈.Dao.ExpressDao;
import 快递e栈.View.Views;
import 快递e栈.bean.Express;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;


public class Main {

    static Views view = new Views();
    static ExpressDao dao = new ExpressDao();
    static {
        eMenu.dao = dao;
        cMenu.dao = dao;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1",34765);
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
        HashSet<Express> set = (HashSet<Express>) ois.readObject();
        dao.setAka(set);
        p:while(true){

            int c = view.menu();
            if(c == 1){
                int eChoose = view.eMenu();
                eMenu.choose(eChoose);
            }else if(c==2){
                int code = view.cMenu();
                cMenu.get(code);
            }else{
                view.bye();
                break;
            }
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
        oos.writeObject(dao.printAll());
        oos.close();
    }


}
