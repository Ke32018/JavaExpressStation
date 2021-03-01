package 快递e栈.Main;

import 快递e栈.Dao.ExpressDao;
import 快递e栈.View.Views;
import 快递e栈.bean.Express;

public class cMenu {
    static Views view = new Views();
    static ExpressDao dao;

    public static void get(int code){
        Express e = dao.findExpressByCode(code);
        try {

        view.printExpress(e);
        dao.getFromSet(e);
        } catch (NullPointerException NullEx) {
            System.out.println("NullPointerException：没有找到快递");
        }
    }
}
