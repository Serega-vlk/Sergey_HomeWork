package StringProcessing;

public interface RegexContainer {
    String NAME_PATTERN = "^[А-ЯA-Z][a-zа-я]+$";
    String SURNAME_PATTERN = "^[А-ЯA-Z][a-zа-я]+$";
    String MIDDLE_NAME_PATTERN = "^[А-ЯA-Z][a-zа-я]+$";
    String TELEPHONE_PATTERN = "^\\+\\d{12}$";
    String TELEPHONE_PATTERN2 = "\\d{10}$";
    String EMAIL_PATTERN = "^\\w+@\\D+\\.\\D{2,}$";
    String NICKNAME_PATTERN = "^@\\w{4,10}$";
}
