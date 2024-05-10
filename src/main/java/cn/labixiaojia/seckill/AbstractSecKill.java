package cn.labixiaojia.seckill;

public abstract class AbstractSecKill {

    public static final String shoppingTime = "2024-05-08 22:08:00";

    public void start(){
        setDriver();
        secKill();
    }

    public abstract void secKill();

    /**
     * 设置chrome驱动
     */
    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
    }

}
