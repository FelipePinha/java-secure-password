package dev.pinha.secure_password.controller;

import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import tools.jackson.databind.ObjectMapper;
import dev.pinha.secure_password.dto.PasswordRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deve retornar código 204 quando a senha for válida")
    void shouldReturn204WhenPasswordIsValid() throws Exception {

        PasswordRequest request = new PasswordRequest("ValidPass123!");

        mockMvc.perform(MockMvcRequestBuilders.post("/validate-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @DisplayName("Deve retornar código 400 e uma mensagem de erro dizendo que o valor mínimo é 8 caracteres")
    void shouldReturnMinimumLengthErrorMessage() throws Exception {

        PasswordRequest request = new PasswordRequest("Ab123!");

        mockMvc.perform(MockMvcRequestBuilders.post("/validate-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                        .andExpect(MockMvcResultMatchers.status().isBadRequest())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    @DisplayName("Deve retornar código 400 e uma mensagem de erro dizendo que é necessário uma letra maiúscula")
    void shouldReturnUppercaseLetterErrorMessage() throws Exception {

        PasswordRequest request = new PasswordRequest("ab1235678!");

        mockMvc.perform(MockMvcRequestBuilders.post("/validate-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("A senha deve conter pelo menos uma letra maiúsculua"));
    }

    @Test
    @DisplayName("Deve retornar código 400 e uma mensagem de erro dizendo que é necessário uma letra minúscula")
    void shouldReturnLowercaseLetterErrorMessage() throws Exception {

        PasswordRequest request = new PasswordRequest("AB1235678!");

        mockMvc.perform(MockMvcRequestBuilders.post("/validate-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("A senha deve conter pelo menos uma letra minúscula"));
    }

    @Test
    @DisplayName("Deve retornar código 400 e uma mensagem de erro dizendo que é necessário uma caractere especial")
    void shouldReturnSpecialCharacterErrorMessage() throws Exception {

        PasswordRequest request = new PasswordRequest("Ab1235678");

        mockMvc.perform(MockMvcRequestBuilders.post("/validate-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("A senha deve conter pelo menos um caracter especial"));
    }
}
