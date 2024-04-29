package app.xlog.ggbond;

import app.xlog.ggbond.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@RestController
@SpringBootApplication
public class App {
    private Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/verify")
    public Result<String> verify(String token) {
        logger.atInfo().log("token: {}", token);
        if (token.equals("success")) {
            logger.atInfo().log("请求成功");
            return Result.buildResult(Result.Status.OK, "success");
        } else {
            return Result.buildResult(Result.Status.ERROR);
        }
    }
}
