package DbServlets;

import Models.UserModel;

public interface UserInterface {
    public boolean registerUser(UserModel u);
    public boolean login(String user_name, String password);
}