package StringProcessing;

public class User {
    private String name;
    private String surname;
    private String middleName;
    private String telephone;
    private String email;
    private String nickname;

    public User(String[] args){
        this.name = args[0];
        this.surname = args[1];
        this.middleName = args[2];
        this.telephone = args[3];
        this.email = args[4];
        this.nickname = args[5];
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

