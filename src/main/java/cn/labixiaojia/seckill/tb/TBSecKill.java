package cn.labixiaojia.seckill.tb;

import cn.labixiaojia.enumerate.GlobalUrlEnum;
import cn.labixiaojia.seckill.AbstractSecKill;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

/**
 * 淘宝秒杀
 * @ author 历河川
 * @ date 2024-05-08
 */
public class TBSecKill extends AbstractSecKill {

    private static ChromeDriver chromeDriver;

    @Override
    public void secKill() {
        chromeDriver = new ChromeDriver();
        // 获取淘宝登录地址
        chromeDriver.get(GlobalUrlEnum.TB_LOGIN_URL.getUrl());
        List<WebElement> userElements;
        // 循环校验是否登录
        do {
            // 获取登录的用户标签,该标签只有在用户登录成功之后才会有
            // 用该标签来确定是成功登录
            userElements = chromeDriver.findElementsByClassName("site-nav-user");
        } while (userElements.isEmpty());

        try {
            // 休眠2s,等待页面加载完全
            Thread.sleep(1000);
            // 从购物车中选择物品
            cart();
            // 结算
            chromeDriver.findElementByClassName("btn-area").click();
            // 滚动到底部
            chromeDriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            // 提交订单
            chromeDriver.findElementByClassName("go-btn").click();
            // 10秒之后关闭网页
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {
        } finally {
            // 关闭网页
            chromeDriver.quit();
        }
    }

    private void cart() throws InterruptedException {
        // 获取购物车class标签并点击跳转到购物车页面
        chromeDriver.findElementByClassName("member-cart").click();
        // 切换到购物车的窗口
        changeWindow();
        Thread.sleep(1000);
        while (true) {
            if (LocalDateTime.now().isAfter(LocalDateTime.parse(shoppingTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))) {
                // 获取购物车中全选的checkbox
                WebElement cartCheckAllElement = chromeDriver.findElementByClassName("cart").findElements(By.className("cart-checkbox")).get(0);
                // 触发全选的点击事件
                cartCheckAllElement.click();
                break;
            }
        }
    }

    private void changeWindow() {
        // 获取当前打开的窗口
        String currentWindow = chromeDriver.getWindowHandle();
        // 获取所有打开的窗口
        Set<String> windowSet = chromeDriver.getWindowHandles();
        // 遍历所有窗口,找到新打开的窗口
        for (String windowHandle : windowSet) {
            if (!windowHandle.equals(currentWindow)) {
                // 切换到新打开的窗口
                chromeDriver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
