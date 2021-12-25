package com.example.exercice1devops;
import com.example.exercice1devops.controller.ClientController;
import com.example.exercice1devops.entity.Adress;
import com.example.exercice1devops.entity.Client;
import com.example.exercice1devops.repository.IClientRepository;
import  com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();
    @Mock
    private IClientRepository clientRepository;
    @InjectMocks
    private ClientController clientController;
    Client client1 = new Client(1L,"abdelkalek","Guedri","abdelkalek@gmail.com","50888555",new Adress(15L,"med15","monstir","5100","tunisie"));
    Client client2= new Client(2L,"saleh","Guedri","saleh@gmail.com","50888555",new Adress(15L,"med15","monstir","5100","tunisie"));
    Client client3 = new Client(3L,"ali","Guedri","ali@gmail.com","50888555",new Adress(15L,"med15","monstir","5100","tunisie"));
    Client client4 = new Client(4L,"med","Guedri","med@gmail.com","50888555",new Adress(15L,"med15","monstir","5100","tunisie"));

    @Before
    public void SetUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }
    @Test
    public void createdClient_success() throws Exception {
        Client b =  Client
                .builder()
                .id(4L)
                .nom("abdelkalek")
                .prenom("Guedri")
                .email("abdelkalek@gmail.com")
                .tel("5000555")
                .build();
        String content = objectWriter.writeValueAsString(b);
        Mockito.when(clientRepository.save(b)).thenReturn(b);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
       mockMvc.perform(mockRequest)
               .andExpect(status().isOk())
              .andExpect(jsonPath("$.nom", is("abdelkalek")));
    }
}
