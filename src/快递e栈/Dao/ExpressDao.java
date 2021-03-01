package 快递e栈.Dao;

import 快递e栈.bean.Express;

import java.util.HashSet;
import java.util.Random;

public class ExpressDao {
    HashSet<Express> aka = new HashSet<>(100);
    private int size;

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
     * 删除集合中的物品
     * @param e 要删除的快递对象
     */

    public void deleteFromSet(Express e){
        boolean flag = aka.remove(e);
        if(flag){
            System.out.println("删除快递成功");
        }else{
            System.out.println("删除快递失败");
        }
    }


    /**
     * 从集合中找到对象并返回
     * @param id
     * @return
     */
    public Express findExpress(String id){
        for(Express ex: aka){
            if(ex.getId().equals(id)){
                return ex;
            }
        }
        return null;
    }


    /**
     * 通过取件码在集合中找快递
     * @param code
     * @return
     */
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
     * 用户取出快递并删除
     * @param e
     */
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


    /**
     * 打印所有快递信息
     */
    public void printAllFromSet(){
        for(Express e: aka){
            System.out.println(e);
        }
    }


    /**
     * 获得快递备份数据
     * @param e
     * @return
     */
    public Express getBack(Express e){
        return e;
    }


    /**
     * 更新快递信息
     * @param e
     */
    public void update(Express e){
        if(aka.contains(e)){
            //contains是利用什么对比的？
            System.out.println("id重复，请重新添加");
        }else{
            aka.add(e);
        }
    }


    public boolean judgeDuplicat(Express e) {
        if(aka.isEmpty()) return false;
        for(Express ex:aka){
            if(ex.getId().equals(e.getId())){
                return true;
            }
        }
        return false;
    }
}
