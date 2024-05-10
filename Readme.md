# 淘宝购物车秒杀
### 1: 下载ChromeDriver
#### 1.1: 确定Chrome浏览器版本号
打开Chrome浏览器,在地址栏输入 chrome://version/ 并回车
记下"版本"一栏显示的版本号,例如版本123.0.6312.59
#### 1.2: 下载对应版本的ChromeDriver
访问 https://googlechromelabs.github.io/chrome-for-testing/
根据Chrome版本下载对应的ChromeDriver,例如https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.58/win64/chromedriver-win64.zip （没有对应版本，版本相近就行）

### 2：配置ChromeDriver
修改AbstractSecKill类中的System.setProperty,将/Users/xiaojiazz/Downloads/chromedriver-mac-x64/chromedriver改成你自己下载的ChromeDriver所在的位置
```java
        // mac
        System.setProperty("webdriver.chrome.driver", "/Users/xiaojiazz/Downloads/chromedriver-mac-x64/chromedriver");
        // win
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
```
### 3: 修改秒杀时间
修改AbstractSecKill类中的shoppingTime为开始秒杀的时间
### 4：运行代码
运行代码之后会自动打开Chrome浏览器,手动登录

## 免责声名
本开源项目（以下简称“本项目”）为自由、开放、共享的非赢利性项目，由开发者（以下简称“我们”）所创建并维护。我们不对使用本项目产生的任何后果承担任何责任。
1. 本项目的代码仅供参考学习，不保证其准确性、完整性或实用性。开发者不承担因使用本项目引发的任何直接或间接损失或损害的法律责任。
2. 本项目中可能包含第三方组件或库，这些组件或库的使用可能受到其他许可证的限制。使用者应该自行了解并遵守相关许可证的规定，并对因使用这些组件或库而引发的任何法律责任自负。

3. 本项目中可能包含链接到其他网站或资源的链接。这些链接仅供参考。
   我们不对这些网站或资源的可用性、准确性、完整性、合法性或任何其他方面的信息负责。使用者应该自行决定是否信任这些链接，并对因使用这些链接而引发的任何法律责任自负。
4. 我们保留随时更改本免责声明的权利。使用者应该定期查看本免责声明，以了解任何变更。如果使用者继续使用本项目，则视为同意遵守新的免责声明。

<br>
<br>



