package pl.altkom;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener {
  private static int activeSessions = 0;

    public static int getActiveSessions() {
        return activeSessions;
    }
  
  public void sessionCreated(HttpSessionEvent e) {
    activeSessions++;
  }
  public void sessionDestroyed(HttpSessionEvent e) {
    activeSessions--;
  }
}
