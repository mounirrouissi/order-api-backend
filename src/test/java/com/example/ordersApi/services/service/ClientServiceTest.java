package com.example.ordersApi.services.service;

import com.example.ordersApi.models.Client;
import com.example.ordersApi.repositories.ClientRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class ClientServiceTest {
@Autowired
private ClientRepo clientRepo;
    @Autowired
    private ClientService clientServicel;
    private Client client,client1;

    @BeforeEach
    void setUp() {
        //Given
        client = new Client(123L,"234", "Client1", "", LocalDate.now(), "address x", "Tunis", 124654L, "+43546436", "+43546436", "34235235", "cdf@gmail.com", Set.of());
        client1 = new Client("234", "Client2", "", LocalDate.now(), "address x", "Tunis", 124654L, "+43546436", "+43546436", "34235235", "cdf@gmail.com");
    }
    @Test
    void getAllClients() {

        //Given
        this.clientRepo.saveAll(List.of(client,client1));
        //When
        var allClients = this.clientServicel.getAllClients();
        assertThat(allClients.size()).isNotEqualTo(2);
        //Then


    }

    @Test
    void getClient() {
    }

    @Test
    void addClient() {
        //given
        var given = this.clientRepo.save(client);
        //when
        var when = this.clientServicel.getClient(1L);
    //then
        then(when.getCode().equalsIgnoreCase(given.getCode()));
    }

    @Test
    void removeClient() {
    }
}