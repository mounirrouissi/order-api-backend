package com.example.ordersApi.repositories;

import com.example.ordersApi.models.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Tag("Client test")
class ClientRepoTest {
    @Autowired
    private ClientRepo clientRepo;
    private Client client,client1;
    @Autowired
    private TestEntityManager testEntityManager;
    @BeforeEach
    void setUp() {
        //Given
        client = new Client(123L,"234", "Client1", "", LocalDate.now(), "address x", "Tunis", 124654L, "+43546436", "+43546436", "34235235", "cdf@gmail.com", Set.of());
        client1 = new Client("23456", "Client2", "", LocalDate.now(), "address x", "Tunis", 124654L, "+43546436", "+43546436", "34235235", "cdf@gmail.com");

    }

    @Test
    void name() {
        //Given
        Client saved = testEntityManager.persist(client1);
//When
//        this.clientRepo.save(client);
        //When
        var clientRetrieved = this.clientRepo.getClientByCode("23456");
        //Then
        System.out.println("client ="+clientRetrieved);
        assertThat(clientRetrieved.getVille()).isEqualTo("Tunis");
    }
}