package 快递e栈.View;

import 快递e栈.bean.Express;

import java.util.Scanner;

public class Views {
    Scanner input = new Scanner(System.in);

    /**
     * 主菜单视图，进入系统时即会显示
     * @return 用于选择身份的整数
     */
    public int menu(){
        System.out.println("**欢迎使用快递e栈系统**");
        System.out.println("请输入数字选择你的身份或者其他按键退出");
        System.out.println("1. 快递员；2. 用户");

        String ch = input.nextLine();
        int chi = -1;
        try{
        chi = Integer.parseInt(ch);
        }catch (NumberFormatException e){

        }
        return chi;

    }

    /**
     * 快递员子菜单视图
     * @return 使用功能序号
     */
    public int eMenu(){
        System.out.println("请输入数字选择你要使用的功能");
        System.out.println("1. 快递录入");
        System.out.println("2. 删除快递");
        System.out.println("3. 修改快递");
        System.out.println("4. 查询快递");
        System.out.println("0. 返回上一级");

        String ch = input.nextLine();
        int chi = -1;
        try{
            chi = Integer.parseInt(ch);
        }catch (NumberFormatException e){
            System.out.println("输入的不是数字");
            return eMenu();
        }
        if(chi<0 || chi >4) {
            System.out.println("数字范围错误");
            return eMenu();
        }
        return chi;
    }

    /**
     * 用户子菜单视图
     * @return 用户输入的取件码
     */
    public int cMenu(){
        System.out.println("请输入取件码");
        System.out.println("");

        String ch = input.nextLine();
        int chi = -1;
        try{
            chi = Integer.parseInt(ch);
        }catch (NumberFormatException e){
            System.out.println("请输入正确的取件码格式");
            return cMenu();
        }
        return chi;
    }

    /**
     * 输入快递公司和单号
     * @return 返回拥有单号和公司的Express对象。
     */
    public Express insert(){
        System.out.println("请输入快递单号");
        String id = input.nextLine();
        System.out.println("请输入快递公司");
        String company = input.nextLine();
        Express e = new Express();
        e.setId(id);
        e.setCompany(company);


        return e;
    }

    /**
     * 提示用户输入快递单号
     * @return 快递单号
     */
    public String idAsk(){
        System.out.println("请输入要操作的快递单号");
        String id = input.nextLine();
        // if(id == ) 不要想着在view中实现非视图和接受输入的内容

        return id;
    }

    /**
     * 显示快递信息
     * @param e
     */
    public void printExpress(Express e){
        System.out.println("快递单号："+e.getId()+"\n快递公司："+e.getCompany()+"\n取件码："+e.getCode());
    }

    /**
     * 更新快递信息
     * @param e：需要更新的快递对象。
     */
    public void update(Express e){
        System.out.println("请输入新的快递单号");
        String id = input.nextLine();
        System.out.println("请输入新的快递公司");
        String company = input.nextLine();
        e.setId(id);
        e.setCompany(company);
    }

    /**
     * 我的逻辑要被撕裂了。。
     * 询问是否删除
     * @return 布尔对象，用于选择是或否
     */
    public boolean deleteAsk(String id){
        System.out.println("是否确认删除快递？ \n Y/N(或者任意非Y字符）");
        String s = input.nextLine();
        boolean choose ;
        choose = s.equals("Y") || s.equals("y");
        return choose;
    }

//    public void deleteSuccess(){
//        System.out.println("删除成功");
//    }


    /**
     * 遍历所有快递，打印信息
     * @param es 二维快递对象数组。
     */
    public void printAll(Express[][] es){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(es[i][j] != null){
                    System.out.printf("第%d排，第%d列：\n",i,j);
                    printExpress(es[i][j]);
                }
            }
        }
    }


    public void bye(){
        System.out.println("欢迎下次使用");
    }


    public void printDuplicate() {
        System.out.println("存在重复快递，请重新输入");
    }
}
