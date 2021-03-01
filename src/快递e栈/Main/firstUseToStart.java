package 快递e栈.Main;

import 快递e栈.Dao.ExpressDao;
import 快递e栈.bean.Express;

import java.io.*;
import java.util.HashSet;
import java.util.Properties;

public class firstUseToStart {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExpressDao dao = new ExpressDao();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
        oos.writeObject(dao.printAll());
        oos.close();
/*
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
        HashSet<Express> set = (HashSet<Express>) ois.readObject();
        System.out.println(set);*/
    }
}
