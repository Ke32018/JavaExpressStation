package 快递e栈.Main;

import 快递e栈.Dao.ExpressDao;
import 快递e栈.View.Views;
import 快递e栈.bean.Express;

public class eMenu {
    static Views view = new Views();
    static ExpressDao dao;


    public static void choose(int ch){
//        p: while(true){

            switch (ch) {
                case 1://添加
                    Express e = view.insert();
                    int code;
                    do {

                        code = dao.generateCode();

                    } while (isDuplicate(code));
                    dao.addToSet(e, code);
                    view.printExpress(e);
                    break;
                case 2://删除 删除和修改都用了在这个类中的isNotFound方法处理异常
                    String id2 = view.idAsk();
                    boolean ch2 = view.deleteAsk(id2);
                    if (ch2) {
                        Express e2 = dao.findExpress(id2);
                        if(isNotFound(e2)) break;
                        dao.deleteFromSet(e2);
                    }
                    break;
                case 3://修改
                    String id3 = view.idAsk();
                    Express e3 = dao.findExpress(id3);
                    if(isNotFound(e3)) break;
                    Express e31 = dao.getBack(e3);
                    view.update(e3);
                    dao.deleteFromSet(e31);
                    dao.update(e3);
                    view.printExpress(e3);
                    break;
                case 4://打印所有
                     dao.printAllFromSet();
                    break;
                case 0:
                    break;


                default:
                    throw new IllegalStateException("Unexpected value: " + ch);
            }

//        }
    }

    public static boolean isDuplicate(int code){
        Express e = new Express();
        e.setCode(code);
        if(e.equals(dao.findExpressByCode(code))){
            return true;
        }
        return false;
    }


    public static void printNotFound(){
        System.out.println("未查询到相应快递信息");
    }

    public static boolean isNotFound(Express e){
        if(e == null){
            printNotFound();
            return true;
        }
        return false;
    }
}
