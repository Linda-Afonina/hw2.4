import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {

        String login = "linda";
        String password = "1234L";
        String confirmPassword = "1234";

        try {
            register(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void register(String login, String password, String confirmPassword) {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Логин должен содержать не более 20 символов");
        }
        for (int i = 0; i < login.length(); i++) {
            if (login.charAt(i) != '_' && !Character.isLetterOrDigit(login.charAt(i))) {
                throw new WrongLoginException("Логин может содержать только латинские буквы, цифры и знак подчеркивания.");
            }
        }
        if (password == null || password.length() > 20) {
            throw new WrongPasswordException("Пароль должен содержать не более 20 символов");
        }
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) != '_' && !Character.isLetterOrDigit(password.charAt(i))) {
                throw new WrongPasswordException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания.");
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать.");
        }
    }

}

