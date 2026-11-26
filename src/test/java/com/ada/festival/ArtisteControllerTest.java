package com.ada.festival;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc 
class ArtisteControllerTest {
    @Autowired 
    private MockMvc mockMvc;

    @Test
    void nameFilterReturnsKryptik() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/artistes?nom=kryptik"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].jour").value("samedi"));
    }

    @Test
    void nameFilterReturns404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/artistes?nom=kryptok"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // @Test
    // void unknownNameReturns404() throws Exception {
    //     mockMvc.perform(get("/heroes?name=gimli"))
    //             .andExpect(status().isNotFound())
    //             .andExpect(jsonPath("$.error").value("Aucun héros ne correspond à votre recherche"));
    // }
}