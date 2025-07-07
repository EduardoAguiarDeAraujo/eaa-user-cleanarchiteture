package br.eng.eaa.domain.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {


    @Test
    @DisplayName("Deve retornar um usuário válido")
    public void createUserValido() {

        User user = new User("Eduardo", "MInhaSenhaForte1#");

        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals("Eduardo", user.getName());
        assertEquals("MInhaSenhaForte1#", user.getPassword().toString());
        assertEquals("MInhaSenhaForte1#", user.getPassword().getValue());
        assertNotNull(user.getPassword());

        System.out.println("ID: %d - %s  " + user.getId() + " - " + user.getName());
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com nome nulo")
    public void createUserInvalido() {
        String nameInvalid = null;
        assertThrows(IllegalArgumentException.class, () -> new User(nameInvalid, "MInhaSenhaForte1"));
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com nome vazio")
    public void createUserWithNameVazio() {
        String nameInvalid = "";
        assertThrows(IllegalArgumentException.class, () -> new User(nameInvalid, "MInhaSenhaForte1"));
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com nome nulo")
    public void createUserWithNameNulo() {
        String nameInvalid = null;
        assertThrows(IllegalArgumentException.class, () -> new User(nameInvalid, "MInhaSenhaForte1"));
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com senha nula")
    public void createUserWithPasswordNulo() {
        String passwordInvalid = null;
        assertThrows(IllegalArgumentException.class, () -> new User("Eduardo", passwordInvalid));
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com senha vazia")
    public void createUserWithPasswordVazio() {
        String passwordInvalid = "";
        assertThrows(IllegalArgumentException.class, () -> new User("Eduardo", passwordInvalid));
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com senha inválida")
    public void createUserWithPasswordInvalida() {
        String passwordInvalid = "12345";
        assertThrows(IllegalArgumentException.class, () -> new User("Eduardo", passwordInvalid));
    }
    @Test
    @DisplayName("Deve retornar um string quando chamar toString()")
    public void toStringTest() {
        User user = new User("Eduardo", "MInhaSenhaForte1#");
        String expected = "User{name='Eduardo', id=" + user.getId() + '}';
        assertEquals(expected, user.toString());

        System.out.printf("toString: %s", user.toString());
    }
    @Test
    @DisplayName("Deve retornar um hashCode válido")
    public void hashCodeTest() {
        User user1 = new User("Eduardo", "MInhaSenhaForte1#");
        User user2 = new User(user1.getId(), "Eduardo");

        assertEquals(user1.hashCode(), user2.hashCode(), "Hash codes should be equal for users with same ID");
        System.out.printf("HashCode: %d - %d%n", user1.hashCode(), user2.hashCode());
    }
    @Test
    @DisplayName("Deve retornar true quando comparar dois usuários com o mesmo ID")
    public void equalsTest() {
        User user1 = new User("Eduardo", "MInhaSenhaForte1#");
        User user2 = new User(user1.getId(), "Eduardo");

        assertTrue(user1.equals(user2), "Users with the same ID should be equal");
        System.out.printf("Equals: %b%n", user1.equals(user2));
    }
    @Test
    @DisplayName("Deve retornar false quando comparar dois usuários com IDs diferentes")
    public void equalsTestComIdDiferente() {
        User user1 = new User("Eduardo", "MInhaSenhaForte1#");
        User user2 = new User("Katia", "MInhaSenhaForte1#");
        assertFalse(user1.equals(user2), "Users with different IDs should not be equal");
    }
    @Test
    @DisplayName("Deve retornar false quando comparar um usuário com null")
    public void equalsTestComNull() {
        User user = new User("Eduardo", "MInhaSenhaForte1#");
        assertFalse(user.equals(null), "User should not be equal to null");
        System.out.printf("Equals com null: %b%n", user.equals(null));
    }
    @Test
    @DisplayName("Deve retornar false quando comparar um usuário com um objeto de tipo diferente")
    public void equalsTestComObjetoDiferente() {
        User user = new User("Eduardo", "MInhaSenhaForte1#");
        String differentTypeObject = "This is not a User";
        assertFalse(user.equals(differentTypeObject), "User should not be equal to an object of a different type");
        System.out.printf("Equals com objeto diferente: %b%n", user.equals(differentTypeObject));
    }
    @Test
    @DisplayName("Deve retornar false quando comparar um usuário com um objeto nulo")
    public void equalsTestComObjetoNulo() {
        User user = new User("Eduardo", "MInhaSenhaForte1#");
        Object nullObject = null;
        assertFalse(user.equals(nullObject), "User should not be equal to a null object");
        System.out.printf("Equals com objeto nulo: %b%n", user.equals(nullObject));
    }
}