package Utils;

import java.util.regex.Pattern;

public class ValidadorEmail {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean ehEmailValido(String email){
        try{
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("O email não pode ser nulo ou vazio.");
            }
            java.util.regex.Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        } catch (Error e){
            throw new Error("Não foi possivel verificar o email em questão");
        }
    }
}
