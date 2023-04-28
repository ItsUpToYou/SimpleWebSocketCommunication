package org.example;


import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/app")
public class ChatServerEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("--- server Connected: "  + session.getId());
    }

    @OnMessage
    public void onMessage(String msg, Session session) throws IOException {
        System.out.println("--- SERVER: Received Message: " + msg );
        session.getBasicRemote().sendText("I got your message: " + msg);
        if (msg.equals("quit")) {
            try {
                session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Bye!"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return msg;
    }
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("--- Session: " + session.getId());
        System.out.println("--- Closing because : " + closeReason);
    }

}
