package com.blumar.agendamento;

import com.blumar.agendamento.entities.*;
import com.blumar.agendamento.entities.enums.RoomType;
import com.blumar.agendamento.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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





		//SpringApplication.run(AgendamentoApplication.class, args);
		SpringApplication app = new SpringApplication(AgendamentoApplication.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		inicializaDB();
	}

	private void inicializaDB() throws Exception {
		Hotel hotel1 = createAndSaveHotel("Hotel A", "City X", 123456789, 987654321L);
		Hotel hotel2 = createAndSaveHotel("Hotel B", "City Y", 987654321, 123456789L);


		Quarto room1A = createAndSaveQuarto(RoomType.INDIVIDUAL, 101, hotel1);
		Quarto room2A = createAndSaveQuarto(RoomType.FAMILIAR, 102, hotel1);
		Quarto room3A = createAndSaveQuarto(RoomType.CASAL, 103, hotel1);


		Quarto room1B = createAndSaveQuarto(RoomType.PRESIDENCIAL, 201, hotel2);
		Quarto room2B = createAndSaveQuarto(RoomType.CASAL, 202, hotel2);


		Cliente cliente1 = new Cliente("John Doe",3012122123L,30,false,"",0,0);

		Cliente cliente2 = new Cliente("Alice Smith",456789123L,25,
			true,"Bob Smith",789123456L,30);

		Cliente cliente = new Cliente("John Doe",4012122123L,30,false,"",0,0);

		clienteService.saveCliente(cliente1);
		clienteService.saveCliente( cliente2);
		clienteService.saveCliente( cliente);


		Pedido pedido = new Pedido(cliente);

		pedidoService.savePedido(pedido);

		Reserva reservaA =new Reserva(3,room1A,pedido,cliente);

		Reserva reservaB =new Reserva(3,room1B,pedido,cliente);


		reservaService.saveReserva(reservaA);
		reservaService.saveReserva(reservaB);
	}
	private Hotel createAndSaveHotel(String name, String location, int cnpj, Long contact) {
		Hotel hotel = new Hotel();
		hotel.setNome(name);
		hotel.setUbicacao(location);
		hotel.setCnpj(cnpj);
		hotel.setContato(contact);
		hotel = hotelService.saveHotel(hotel); // Save hotel and get managed entity
		return hotel;
	}
	private Quarto createAndSaveQuarto(RoomType type, int number, Hotel hotel) {
		Quarto room = new Quarto(type,number,hotel);
		hotel.addRoom(room);
		quartoService.saveQuarto(room); // Save room
		return room;
	}

}
