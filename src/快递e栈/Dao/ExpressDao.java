package 快递e栈.Dao;

import 快递e栈.bean.Express;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class ExpressDao {
    private Express[][] ark = new Express[10][10];
    HashSet<Express> aka = new HashSet<>(100);
    private int size;

    /**
     * 初始化快递柜，每个格子的初始值为null， 也可以通过这个新建一个初始快递柜的备份？
     * @return ark 10*10 二维快递对象数组
     */
    public Express[][] init(){
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                ark[i][j] = null;
            }
        }
        System.out.println("初始化完毕");
        return ark;
    }

    /**
     * 随机存储到快递柜中的一个位置
     */
    public void add(Express e, int code){
        if(size==100){
            System.out.println("柜子已存满");
            return;
        }
        int x = -1;
        int y = -1;
        e.setCode(code);
        Random r = new Random();
        p:while(true){
            x = r.nextInt(10);
            y = r.nextInt(10);

            if(ark[x][y] == null){
                size++;
                ark[x][y] = e;
                System.out.println("添加成功");

            }else{
                break p;
            }
            break;
        }
    }

    /**
     * 将快递对象添加到集合中
     * @param e
     * @param code
     */
    public void addToSet(Express e, int code){
        e.setCode(code);
        aka.add(e);
        System.out.println("添加成功");
    }

    /**
     * 随机生成6位取件码
     * @return
     */
    public int generateCode(){
        Random r = new Random();
        int code = r.nextInt(899999)+100000;
        return code;
    }



    /**
     * 删除快递柜中的物品
     * @param e 要删除的快递对象
     */
    public void delete(Express e){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(ark[i][j] != null){

                    if(e.equals(ark[i][j])){
                        ark[i][j] = null;
                    }
                }
            }
        }
        System.out.println("删除成功");
    }


    public void deleteFromSet(Express e){
        boolean flag = aka.remove(e);
        if(flag){
            System.out.println("删除快递成功");
        }else{
            System.out.println("删除快递失败");
        }
    }

    public void delSet(Express e){

        System.out.println(aka.remove(e));
    }

    /**
     * 从集合中找到对象并返回（貌似是副本）
     * @param id
     * @return
     */
    public Express findExpress(String id){
        Express e = new Express();
        e.setId(id);
        for(Express ex: aka){
            if(ex.getId().equals(id)){
                return ex;
            }
        }
        return null;
    }




    public Express findExpressByCode(int code){
        Express e = new Express();
        e.setCode(code);
        for(Express ex: aka){
            if(ex.getCode()==code){
                return ex;
            }
        }
        return null;
    }


    /**
     * 通过输入的快递单号找到快递对象
     * @param id 快递单号
     * @return 快递对象
     */

    public Express findByNumber(String id){
        /**
         * 如果通过id直接查询，String无法与快递柜中的空对象直接比较，空对象没有getId方法
         */
        Express e = new Express();
        e.setId(id);
        return getExpress(e);
    }


    /**
     * 通过取件码找到快递对象
     * @param code 取件码
     * @return 快递对象
     */
        public Express findByCode(int code){
            for(int i=0; i<10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(ark[i][j] != null){
                        if(ark[i][j].getCode() == code){
                            return ark[i][j];
                        }
                    }

                }
            }
            //System.out.println("查无此件");
            return null;
        }


    /**
     * 通过快递对象在二维数组中找到对象
     * @param e
     * @return
     */
    private Express getExpress(Express e) {
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(e.equals(ark[i][j])){
                    System.out.println("找到快递");
                    return ark[i][j];
                }

            }
        }
        System.out.println("查无此件");
        return null;
    }


    /**
     * 用户取出快递并删除
     * @param e
     */
    public void get(Express e){
        System.out.println("正在取出快递");

        delete(e);
    }

    public void getFromSet(Express e){
        boolean flag = aka.remove(e);
        if(flag){
            System.out.println("取出快递成功");
        }else{
            System.out.println("取出快递失败");
        }
    }


    /**
     * 取出快递柜数据
     * @return :集合数据
     */
    public HashSet<Express> printAll(){
        return aka;
    }

    /**
     * 把快递柜再放进去
     * @param aka1
     */
    public void setAka(HashSet<Express> aka1){
        aka = aka1;
    }

    public void printAllFromSet(){
        for(Express e: aka){
            System.out.println(e);
        }
    }

    public Express getBack(Express e){
        return e;
    }
    public void update(Express e){
        if(aka.contains(e)){
            //contains是利用什么对比的？
            System.out.println("id重复，请重新添加");
        }else{
            aka.add(e);
        }
    }


}
