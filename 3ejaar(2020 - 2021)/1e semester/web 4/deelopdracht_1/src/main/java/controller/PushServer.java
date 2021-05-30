package controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/echo")
public class PushServer {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + "has opened a connection");
        try{
            session.getBasicRemote().sendText("Here put the history of previously added data");
        } catch (IOException e){
            e.printStackTrace();
        }
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("message" + session.getId());
        sendMessageToAll(message);

    }

    @OnClose
    public void onClose(Session session){
        System.out.println("chat" + session.getId() + " has ended");
        sessions.remove(session);
    }

    private void sendMessageToAll(String message){
        for(Session s: sessions){
            try{
                s.getBasicRemote().sendText(message);
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
