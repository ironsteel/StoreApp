/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package storeapp.session;

/**
 *
 * @author dalev
 */
public class UserSessionManager {

    private static UserSessionManager instance = null;

    private String userName;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    private boolean isManager;


     public static UserSessionManager getSingleton() {
        if(instance == null) {
            instance = new UserSessionManager();
            return instance;
        }
        return instance;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    

}
