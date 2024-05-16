package websocket.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import websocket.test.dto.JoinDTO;
import websocket.test.dto.MessageDTO;

@Controller
@Slf4j
public class MainController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public MessageDTO greeting(JoinDTO message) throws Exception {
        Thread.sleep(1000); // simulated delay
        log.info(message.getName());
        return new MessageDTO("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!") ;
    }
}
