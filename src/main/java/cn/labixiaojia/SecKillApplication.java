package cn.labixiaojia;

import cn.labixiaojia.seckill.tb.TBSecKill;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 历河川
 * @date 2024/05/08
 * @description 自动秒杀启动类
 */
@SpringBootApplication
public class SecKillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecKillApplication.class, args);
        start();
    }

    /**
     * 启动秒杀
     */
    private static void start(){
        new TBSecKill().start();
    }

}