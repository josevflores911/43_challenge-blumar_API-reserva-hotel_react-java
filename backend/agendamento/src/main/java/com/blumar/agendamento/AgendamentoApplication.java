package com.blumar.agendamento;

import com.blumar.agendamento.entities.*;
import com.blumar.agendamento.entities.enums.RoomType;
import com.blumar.agendamento.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AgendamentoApplication implements CommandLineRunner {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private QuartoService quartoService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private ReservaService reservaService;

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// Create and save Hotel instances
		Hotel hotel1 = createAndSaveHotel("Hotel A", "City X", 123456789, 987654321);
		Hotel hotel2 = createAndSaveHotel("Hotel B", "City Y", 987654321, 123456789);

		// Create and save rooms for Hotel A
		Quarto room1A = createAndSaveQuarto(RoomType.INDIVIDUAL, 101, hotel1);
		Quarto room2A = createAndSaveQuarto(RoomType.FAMILIAR, 102, hotel1);

		// Create and save rooms for Hotel B
		Quarto room1B = createAndSaveQuarto(RoomType.PRESIDENCIAL, 201, hotel2);
		Quarto room2B = createAndSaveQuarto(RoomType.CASAL, 202, hotel2);

		Cliente cliente1 = new Cliente();
		cliente1.setNome("John Doe");
		cliente1.setIdade(30);
		cliente1.setCpf(123456789);
		cliente1.setTemAcompanhante(false); // No accompanying person for this client
		clienteService.saveCliente(cliente1);

		// Create and save the second client with an accompanying person
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Alice Smith");
		cliente2.setIdade(25);
		cliente2.setCpf(456789123);
		cliente2.setTemAcompanhante(true); // This client has an accompanying person
		cliente2.setNomeAcompanhante("Bob Smith");
		cliente2.setIdadeAcompanhante(30);
		cliente2.setCpfAcompanhante(789123456);
		clienteService.saveCliente(cliente2);



		// Assuming you have a ClienteService that provides CRUD operations for Cliente entities
		Cliente cliente = new Cliente();
		cliente.setNome("John Doe");
		cliente.setIdade(30);
		cliente.setCpf(123456789);
		cliente.setTemAcompanhante(false); // No accompanying person for this client
		clienteService.saveCliente(cliente); // Save the new Cliente

		Pedido pedido = new Pedido();
		pedido.setValorTotal(100);
		pedido.setCliente(cliente);

		pedidoService.savePedido(pedido);

		Reserva reservaA =new Reserva();
		reservaA.setDataSaida(LocalDateTime.now().plusDays(3));
		reservaA.setValorUnitario(150);
		reservaA.setCantidadNoites(3);

		reservaA.setQuarto(room2A);
		reservaA.setPedido(pedido);
		reservaA.setCliente(cliente);

		reservaService.saveReserva(reservaA);

	}

	private Hotel createAndSaveHotel(String name, String location, int cnpj, int contact) {
		Hotel hotel = new Hotel();
		hotel.setName(name);
		hotel.setUbicacion(location);
		hotel.setCnpj(cnpj);
		hotel.setContacto(contact);
		hotel = hotelService.saveHotel(hotel); // Save hotel and get managed entity
		return hotel;
	}

	private Quarto createAndSaveQuarto(RoomType type, int number, Hotel hotel) {
		Quarto room = new Quarto();
		room.setType(type);
		room.setNumero(number);
		room.setHotel(hotel);
		quartoService.saveQuarto(room); // Save room
		return room;
	}

}
