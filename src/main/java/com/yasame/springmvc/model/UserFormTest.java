package com.yasame.springmvc.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserFormTest {

    @Test
    void testSetAndGetId() {
        UserForm userForm = new UserForm();
        userForm.setId(1);
        assertEquals(1, userForm.getId());
    }

    @Test
    void testSetAndGetDesignation() {
        UserForm userForm = new UserForm();
        userForm.setDesignation("Laptop");
        assertEquals("Laptop", userForm.getDesignation());
    }

    @Test
    void testSetAndGetPrixUnitaire() {
        UserForm userForm = new UserForm();
        userForm.setPrixUnitaire(500.0f);
        assertEquals(500.0f, userForm.getPrixUnitaire());
    }

    @Test
    void testSetAndGetQuantite() {
        UserForm userForm = new UserForm();
        userForm.setQuantite(10);
        assertEquals(10, userForm.getQuantite());
    }

    @Test
    void testSetAndGetCategorie() {
        UserForm userForm = new UserForm();
        userForm.setCategorie("Smartphone");
        assertEquals("Smartphone", userForm.getCategorie());
    }

    @Test
    void testSetAndGetDescription() {
        UserForm userForm = new UserForm();
        userForm.setDescription("A high-end smartphone.");
        assertEquals("A high-end smartphone.", userForm.getDescription());
    }

    @Test
    void testSetAndGetOrigine() {
        UserForm userForm = new UserForm();
        userForm.setOrigine("Importé");
        assertEquals("Importé", userForm.getOrigine());
    }
}

