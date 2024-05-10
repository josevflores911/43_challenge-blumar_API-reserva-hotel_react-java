package com.blumar.agendamento;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.repositories.ClienteRepository;
import com.blumar.agendamento.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClientServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCliente() {
        // Create a new Cliente instance
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("John Doe");

        // Mock the repository's save method
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        // Call the service method to save the Cliente
        clienteService.saveCliente(cliente);

        // Verify that the save method of repository was called exactly once with any Cliente object
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    public void testFindAll() {
        // Create some sample Cliente objects
        Cliente cliente1 = new Cliente();
        cliente1.setCpf(12345678900L);
        cliente1.setNome("John Doe");

        Cliente cliente2 = new Cliente();
        cliente2.setCpf(98765432100L);
        cliente2.setNome("Jane Smith");

        // Mock the repository's findAll method to return a list of Cliente objects
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        // Call the service method to retrieve all Cliente objects
        List<Cliente> clientes = clienteService.findAll();

        // Verify that the findAll method of repository was called exactly once
        verify(clienteRepository, times(1)).findAll();

        // Verify that the returned list contains exactly two Cliente objects
        assertEquals(2, clientes.size());
        // You can add more assertions to validate the contents of the returned list
    }
}

