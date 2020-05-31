package testcase01.Junit5DemoTest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LoginAndBuyTest {
    public static HashMap<String,Object>dataMap=new HashMap<String,Object>();
    @Test
    void loginTest(){
        dataMap.put("login","登录成功");
    }
    @Nested
    class  payTest{
        @Test
        void  payTest(){
            if(null!=dataMap.get("buy")){
                System.out.println("正在支付，请等待");
                System.out.println(dataMap.get("buy"));
            }else {
                System.out.println("你还没有购买课程把" );
            }
        }
    }

    @Nested
    class BuyTest{

        @Test
        void buyTest(){
           if(dataMap.get("login").equals("登录成功")) {
               System.out.println("登录成功，可以购买东西了" );
               dataMap.put("buy","购买课程");
           }else{
               System.out.println("没有登录成功哦！");
           }
        }
    }
}
