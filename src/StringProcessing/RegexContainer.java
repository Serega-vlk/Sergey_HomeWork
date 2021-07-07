package StringProcessing;

public interface RegexContainer {
    String ALL_NAMES_PATTERN = "^[А-ЯA-Z][a-zа-я]+$";
    String TELEPHONE_PATTERN = "^\\+\\d{12}$";
    String TELEPHONE_PATTERN2 = "\\d{10}$";
    String EMAIL_PATTERN = "^\\w+@\\D+\\.\\D{2,}$";
    String NICKNAME_PATTERN = "^@\\w{4,10}$";
    String BIRTHDAY_PATTERN = "^\\d{2}\\.\\d{2}\\.\\d{4}$";
}
