package br.eng.eaa.domain.valueobject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private String value;

    public Password(String password){
        if (password == null){
            throw new IllegalArgumentException("Senha inválida, tente novamente!");
        }
        if(!isValid(password))  {
            throw new IllegalArgumentException("Senha inválida, tente novamente!");
        }
        if(password.isEmpty())  {
            throw new IllegalArgumentException("Senha inválida, tente novamente!");
        }
        this.value = password;
    }

    public String getValue() {
        return value;
    }

    private boolean isValid(String password){

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
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.matches()) {
            return false;
        }
        // Pelo menos um caractere especial.Os caracteres especiais são escapados com \\ para que sejam interpretados literalmente.
        Pattern specialCharPattern = Pattern.compile(".*[!@#$%^&*()_+\\-=\\[\\]\\{}|;:'\",.<>/?].*");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.matches()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
