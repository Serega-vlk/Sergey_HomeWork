package StringProcessing;

import java.util.ArrayList;

public class Model {
    private final ArrayList<User> users;

    public Model(){
        this.users = new ArrayList<>();
    }

    /**
     * Метод добовляет нового пользователя в список.
     * @param p пользователь которого нужно добавить
     */
    public void addPerson(User p) throws InvalidUsernameException{
        if (isUsernameExist(p)){
            throw new InvalidUsernameException(String.format("User with nickname %s already exist.", p.getNickname()));
        }
        this.users.add(p);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Метод проверяет есть ли в списке users пользоватнль с таким никнеймом.
     * @param user никнейм для проверки
     * @return
     * true, если пользователь с таким никнеймом существует
     * false, если никнейм уникален
     */
    private boolean isUsernameExist(User user){
        for (User u : users){
            if (u.getNickname().equals(user.getNickname())){
                return true;
            }
        }
        return false;
    }
}
