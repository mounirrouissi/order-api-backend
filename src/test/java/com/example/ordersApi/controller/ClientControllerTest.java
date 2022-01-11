package com.example.ordersApi.controller;

import com.example.ordersApi.controller.exceptions.ClientNotFoundException;
import com.example.ordersApi.models.Client;
import com.example.ordersApi.repositories.ClientRepo;
import com.example.ordersApi.services.service.ClientService;
import com.example.ordersApi.services.serviceImpl.ClientServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.StreamSupport.stream;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @MockBean
    private ClientServiceImpl service;
    @MockBean
    private ClientRepo repo;
    @Autowired
    private MockMvc mockMvc;
    private Client client,client1;

    @BeforeEach
    void setUp() {
        //Given
         client = new Client("234", "Client1", "", LocalDate.now(), "address x", "Tunis", 124654L, "+43546436", "+43546436", "34235235", "cdf@gmail.com");
        client1 = new Client("234", "Client2", "", LocalDate.now(), "address x", "Tunis", 124654L, "+43546436", "+43546436", "34235235", "cdf@gmail.com");
    }

    @Test
    void getAllClients() throws Exception {


  //given
given(this.service.getAllClients()).willReturn((List.of(client,client1)));

        //When //Then
        this.mockMvc.perform(get("http://localhost:8082/api/v1/clients"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.*",hasSize(2)))
                    .andExpect(jsonPath("$[1].nom").value("Client2"))
        ;
    }
    @Test
    void getWorngStudent_WillThrlow404() throws Exception {
        //Given
        given(this.service.getClient(500L)).willThrow(ClientNotFoundException.class);

        //When
        this.mockMvc.perform(get("http://localhost:8082/api/v1/clients/500"))
                    .andExpect(status().isNotFound());

        //Then
    }

//TODO :add testing for remove and add methods
/*    @Test
    void removeClient() throws Exception {
*//*
        //Given
//        given(this.service.getAllClients()).willReturn((List.of(client,client1)));
        var response = this.mockMvc.perform(get("http://localhost:8082/api/v1/clients").contentType("apolication/json"));

        var id= JsonPath.parse(response.get)
        //When
        this.mockMvc.perform(delete("http://localhost:8082/api/v1/clients/1",1L))
                .andDo(print())
.andExpect(status().isOk());
        //Then
*//*

    }*/
}