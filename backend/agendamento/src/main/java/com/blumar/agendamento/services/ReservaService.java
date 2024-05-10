package com.blumar.agendamento.services;



import com.blumar.agendamento.entities.*;
import com.blumar.agendamento.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final HotelRepository hotelRepository;
    private final QuartoRepository quartoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;
    private final ReservaRepository reservaRepository;
    private final CalculoDePrecios calculoDePrecios;

    @Autowired
    public ReservaService(CalculoDePrecios calculoDePrecios, ReservaRepository reservaRepository, HotelRepository hotelRepository, QuartoRepository quartoRepository, ClienteRepository clienteRepository, PedidoRepository pedidoRepository, ReservaRepository reservaRepository1) {
        this.calculoDePrecios = calculoDePrecios;
        this.hotelRepository = hotelRepository;
        this.quartoRepository = quartoRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
        this.reservaRepository = reservaRepository1;
    }


    @Transactional
    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> findAll(){return   reservaRepository.findAll(); }

    public NotaFiscalDTO createReserva(ReservaDTO reservaDTO) throws Exception {

        NotaFiscalDTO notafiscal;
        Optional<NotaFiscalDTO> nota;

        List<Quarto> quartosDisponivel=quartoRepository.findByTypeAndDisponivel(reservaDTO.tipoQuarto,true)
                .stream()
                .filter(e->e.getHotel().getCnpj()==reservaDTO.cnpjHotel).toList();

        Hotel hotel = hotelRepository.findByCnpj(reservaDTO.cnpjHotel).orElseThrow(()->new Exception("Hotel not found"));

        if(!quartosDisponivel.isEmpty()){
            Quarto quartoAleatorio =quartosDisponivel.stream().findAny().get();
            Cliente cliente = new Cliente(reservaDTO.nome,reservaDTO.cpf,reservaDTO.idade,
                    reservaDTO.temAcompanhante,reservaDTO.nomeAcompanhante,reservaDTO.cpfAcompanhante,reservaDTO.idadeAcompanhante);
            Pedido pedido = new Pedido(cliente);

            Duration duracao = Duration.between(reservaDTO.entrada, reservaDTO.salida);
            int noites =(int)duracao.toDays();
            if (duracao.toHours() % 24 != 0) {
                noites++;
            }

            Reserva reserva = new Reserva(noites, quartoAleatorio, pedido, cliente);

            reserva.setValorTotalReserva(calculoDePrecios.calculoValorTotal(noites, cliente.isTemAcompanhante(), cliente.getIdadeAcompanhante()));
            reserva.setQuarto(quartoAleatorio);
            reserva.getQuarto().setDisponivel(false);

            pedido.addReserva(reserva);
            cliente.addReserva(reserva);

            clienteRepository.save(cliente);
            pedidoRepository.save(pedido);
            reservaRepository.save(reserva);

            notafiscal= new NotaFiscalDTO(cliente,hotel,quartoAleatorio,reserva);

            return notafiscal;
        }else{
            throw new Exception("Quarto no disponivel ");
        }

    }

    public List<Reserva> findReservasByClientCPF(long cpf){
        return reservaRepository.findByClienteCpf(cpf);
    }

    public List<Reserva> findReservasByClient(Cliente cliente){
        return reservaRepository.findByCliente(cliente);
    }
}