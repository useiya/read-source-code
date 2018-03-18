package cc.seiya.spring;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author libo
 * @date 2018/3/18  22:46
 */
@Slf4j(topic="test2Logger")
public class Log4j2Test {
    //配置文件中logger的名字
    public static void log() {
        log.info("log1---------");
    }

    public static void log2() {
        log.info("log2++++++++++");
    }

    public static void main(String[] args) {
        log();
        log2();

    }

}
