package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);

    }

    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        client.updateBeer(UUID.randomUUID(), beerDto);

    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    //go code below
    @Test
    void testGetCustomerById() {
        // given customer dto
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        // assert customer dto not null
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        // given new customer dto with name Bud
        CustomerDto customerDto =  CustomerDto.builder().name("Bud").build();
        URI customerUri = client.saveNewCustomer(customerDto);
        assertNotNull(customerUri);
        System.out.println(customerUri);
    }


    @Test
    void testUpdateCustomer() {
        // given new customer dto with name Sam
        CustomerDto customerDto =  CustomerDto.builder().name("Sam").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        // given customer dto
        client.deleteCustomer(UUID.randomUUID());
    }



}