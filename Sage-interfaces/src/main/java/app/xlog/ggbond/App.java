package app.xlog.ggbond;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> verify(String token) {
        logger.atInfo().log("token: {}", token);
        if (token.equals("success")) {
            logger.atInfo().log("请求成功");
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(403).body("forbidden");
        }
    }

    @GetMapping("/aftersuccess")
    public String aftersuccess() {
        return "验证通过，可以访问网站";
    }
}
