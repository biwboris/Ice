package client;

import pocket.ToClient;
import pocket.ToClientType;

public class ServerListener implements Runnable{
    public void run() {
        while (true) {
            try {
                ToClient pock = (ToClient) Client.getOis().readObject();
                if (pock.getT() == ToClientType.GAME) {
                    for (int i = 0; i < pock.getObjs().size(); ++i) {
                        Client.getQueue().offer(pock.getObjs().get(i));
                    }
                }
                else if (pock.getT() == ToClientType.INIT) {
                    // get map
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
