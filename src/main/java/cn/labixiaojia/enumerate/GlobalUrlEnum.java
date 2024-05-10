package cn.labixiaojia.enumerate;

import lombok.Getter;

/**
 * 全局登录地址枚举类
 */
@Getter
public enum GlobalUrlEnum {

    /**
     *  淘宝登录地址
     */
    TB_LOGIN_URL("https://login.taobao.com/member/login.jhtml?f=top&redirectURL=http%3A%2F%2Fwww.taobao.com%2F/");

    private final String url;

    GlobalUrlEnum(String url) {
        this.url = url;
    }

}
