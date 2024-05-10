import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {

        try {
            register("linda", "1234l", "1234");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void register(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Логин должен содержать не более 20 символов");
        }
        for (int i = 0; i < login.length(); i++) {
            char l = login.charAt(i);
            if (l != '_' || !Character.isLetterOrDigit(l)) {
                throw new WrongLoginException("Логин может содержать только латинские буквы, цифры и знак подчеркивания.");
            }
        }
        if (password == null || password.length() > 20) {
            throw new WrongPasswordException("Пароль должен содержать не более 20 символов");
        }
        for (int i = 0; i < password.length(); i++) {
            char p1 = password.charAt(i);
            char p2 = confirmPassword.charAt(i);
            if (p1 != '_' || !Character.isLetterOrDigit(p1) || p1 != p2) {
                throw new WrongPasswordException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания.");
            }
        }
    }

}

