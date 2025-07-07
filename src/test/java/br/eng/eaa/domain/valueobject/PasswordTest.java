package br.eng.eaa.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    @DisplayName("Verificar senha válida.")
    void validarSenhaCorreta(){
        String senhaValida = "MinhaSenhaForte1!";
        Password password = new Password(senhaValida);
        assertNotNull(password);
        assertNotNull(password.toString());
        System.out.println("Senha válida: " + password.toString());
    }
    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando a senha menor que 8 caracteres.")
    void validarSenhaCorretaMenorQueOitoCaracteres() {
        String senha = "Abcd1!!";
        assertThrows(IllegalArgumentException.class, () -> new Password(senha));
    }
    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando a senha o nome for vazio.")
    void validarSenhaVazio() {
        String senha = "";
        assertThrows(IllegalArgumentException.class, () -> new Password(senha));
    }
    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando a senha conter espaços em branco.")
    void validarSenhaEspacoEmBranco() {
        String senha = "   ";
        assertThrows(IllegalArgumentException.class, () -> new Password(senha));
    }
    @Test
    @DisplayName("Deve retornar IllegalArgumentException para senha sem caractere maiúsculo.")
    void shouldReturnFalseForNoUpperCase() {
        String senha = "minhasenha1!";
        assertThrows(IllegalArgumentException.class, () -> new Password(senha));
    }
    @Test
    @DisplayName("Deve retornar IllegalArgumentException para senha sem letra minúscula")
    void shouldReturnFalseForNoLowerCase() {
        String senha = "MINHASENHA1!";
        assertThrows(IllegalArgumentException.class, () -> new Password(senha));
    }
    @Test
    @DisplayName("Deve retornar false para senha sem caractere especial")
    void shouldReturnFalseForNoSpecialCharacter() {
        String senha = "MinhaSenhaForte1";
        assertThrows(IllegalArgumentException.class, () -> new Password(senha));
    }
    @Test
    @DisplayName("Deve retornar false para senha sem número")
    void shouldReturnFalseForNoNumber() {
        String senha = "MinhaSenhaForte!";
        assertThrows(IllegalArgumentException.class, () -> new Password(senha));
    }
    @Test
    @DisplayName("Deve retornar IllegalArgumentException para senha nula")
    void shouldReturnFalseForNullPassword() {
        String senha = null;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Password(senha));
        assertEquals("Senha inválida, tente novamente!", thrown.getMessage());
    }
    @Test
    @DisplayName("Deve retornar IllegalArgumentException para senha vazia")
    void shouldReturnFalseForEmptyPassword() {
        String senha = "";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Password(senha));
        assertEquals("Senha inválida, tente novamente!", thrown.getMessage());
    }
    @Test
    @DisplayName("Deve retornar IllegalArgumentException para senha em branco")
    void shouldReturnFalseForBlankPassword() {
        String senha = " ";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Password(senha));
        assertEquals("Senha inválida, tente novamente!", thrown.getMessage());
    }

}
