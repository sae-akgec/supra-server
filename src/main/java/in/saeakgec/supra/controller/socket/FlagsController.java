package in.saeakgec.supra.controller.socket;

import in.saeakgec.supra.model.GFlags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.HtmlUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class FlagsController  {

    @MessageMapping("/flags")
    @SendTo("/server/flags")
    public GFlags greeting(GFlags message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("Hello, " + message.getRedFlag() + "!");
        return new GFlags("Hello");
    }
}