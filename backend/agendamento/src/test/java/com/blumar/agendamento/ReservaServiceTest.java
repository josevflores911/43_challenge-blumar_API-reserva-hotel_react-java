package com.blumar.agendamento;

import com.blumar.agendamento.entities.*;
import com.blumar.agendamento.entities.enums.RoomType;
import com.blumar.agendamento.repositories.*;
import com.blumar.agendamento.services.CalculoDePrecios;
import com.blumar.agendamento.services.ReservaService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
//public class ReservaServiceTest {
//
//	@Mock
//	private ReservaRepository reservaRepository;
//
//	@Mock
//	private HotelRepository hotelRepository;
//
//	@Mock
//	private QuartoRepository quartoRepository;
//
//	@Mock
//	private ClienteRepository clienteRepository;
//
//	@Mock
//	private PedidoRepository pedidoRepository;
//
//	@Mock
//	private CalculoDePrecios calculoDePrecios;
//
//	@InjectMocks
//	private ReservaService reservaService;
//
//	// Initialize test data if needed
//
//	@Before
//	public void setup() {
//		MockitoAnnotations.openMocks(this);
//		// Set up mock behavior if necessary
//	}
//
//
//		// Test saving a reservation
//		@Test
//		public void testSaveReserva() {
//			Reserva reserva = new Reserva(); // Create a test reservation
//			when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);
//
//			Reserva savedReserva = reservaService.saveReserva(reserva);
//
//			assertNotNull(savedReserva);
//			// Add more assertions as needed
//		}
//
//		// Test creating a reservation based on DTO
//		@Test
//		public void testCreateReserva() throws Exception {
//			// Set up necessary DTO and mock behavior
//			ReservaDTO reservaDTO = new ReservaDTO(); // Set up DTO data
//			when(quartoRepository.findByTypeAndDisponivel(RoomType.valueOf(anyString()), anyBoolean())).thenReturn(List.of(new Quarto()));
//			when(hotelRepository.findByCnpj(anyLong())).thenReturn(Optional.of(new Hotel()));
//			when(calculoDePrecios.calculoValorTotal(anyInt(), anyBoolean(), anyInt())).thenReturn(100);
//
//			NotaFiscalDTO notaFiscalDTO = reservaService.createReserva(reservaDTO);
//
//			assertNotNull(notaFiscalDTO);
//			// Add more assertions as needed
//		}
//
//		// Test finding reservations by client CPF
//		@Test
//		public void testFindReservasByClientCPF() {
//			long cpf = 123456789; // Set up test CPF
//			when(reservaRepository.findByClienteCpf(cpf)).thenReturn(List.of(new Reserva()));
//
//			List<Reserva> reservas = reservaService.findReservasByClientCPF(cpf);
//
//			assertFalse(reservas.isEmpty());
//			// Add more assertions as needed
//		}
//
//		// Test finding reservations by client
//		@Test
//		public void testFindReservasByClient() {
//			Cliente cliente = new Cliente(); // Set up test client
//			when(reservaRepository.findByCliente(any(Cliente.class))).thenReturn(List.of(new Reserva()));
//
//			List<Reserva> reservas = reservaService.findReservasByClient(cliente);
//
//			assertFalse(reservas.isEmpty());
//			// Add more assertions as needed
//		}
//	}
