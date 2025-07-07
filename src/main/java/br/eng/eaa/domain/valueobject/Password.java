package br.eng.eaa.domain.valueobject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private String password;

    public Password(String password){
        if (password == null){
            throw new IllegalArgumentException("Senha inválida, tente novamente!");
        }
        if(!isValid(password) || password.isEmpty())  {
            throw new IllegalArgumentException("Senha inválida, tente novamente!");
        }
        this.password = password;
    }

    /**
     * Valida uma senha com as seguintes regras:
     * - Mínimo de 8 caracteres.
     * - Contém pelo menos uma letra maiúscula.
     * - Contém pelo menos uma letra minúscula.
     * - Contém pelo menos um número.
     * - Contém pelo menos um caractere especial (!@#$%^&*()_+-=[]{}|;:',.<>?).
     */
    private boolean isValid(String password){

        // Mínimo de 8 caracteres
        if (password.length() < 8) {
            return false;
        }
        // Pelo menos uma letra maiúscula
        Pattern upperCasePattern = Pattern.compile(".*[A-Z].*");
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        if (!upperCaseMatcher.matches()) {
            return false;
        }
        // Pelo menos uma letra minúscula
        Pattern lowerCasePattern = Pattern.compile(".*[a-z].*");
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        if (!lowerCaseMatcher.matches()) {
            return false;
        }
        // Pelo menos um número
        Pattern digitPattern = Pattern.compile(".*[\\d].*");
//        Pattern digitPattern = Pattern.compile(".*[0-9].*");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.matches()) {
            return false;
        }
        // Pelo menos um caractere especial.
        // Os caracteres especiais são escapados com \\ para que sejam interpretados literalmente.
        Pattern specialCharPattern = Pattern.compile(".*[!@#$%^&*()_+\\-=\\[\\]\\{}|;:'\",.<>/?].*");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.matches()) {
            return false;
        }
        // Se todas as regras forem atendidas, a senha é válida
        return true;
    }

    @Override
    public String toString() {
        return this.password;
    }
}
