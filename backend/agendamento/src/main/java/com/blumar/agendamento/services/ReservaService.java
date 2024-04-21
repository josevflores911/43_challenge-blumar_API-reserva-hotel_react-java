package com.blumar.agendamento.services;



import com.blumar.agendamento.entities.*;
import com.blumar.agendamento.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private QuartoRepository quartoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ReservaRepository reservaRepository;


    @Transactional
    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> findAll(){return   reservaRepository.findAll(); }

    public Optional<NotaFiscal> createReserva(ReservaDTO reservaDTO) throws Exception {

        List<Quarto> quartosDisponivel=quartoRepository.findByTypeAndDisponivel(reservaDTO.tipoQUarto,true).stream()
                .filter(e->e.getHotel().getCnpj()==reservaDTO.cnpjHotel).toList();

        Hotel hotel = hotelRepository.findByCnpj(reservaDTO.cnpjHotel).orElseThrow(()->new Exception("Hotel not found"));

        NotaFiscal notafiscal= null;

        Optional<NotaFiscal> nota= Optional.empty();

        if(!quartosDisponivel.isEmpty()){
            Quarto quartoAleatorio =quartosDisponivel.stream().findAny().get();
            Cliente cliente = new Cliente(reservaDTO.nome,reservaDTO.cpf,reservaDTO.idade,
                    reservaDTO.temAcompanhante,reservaDTO.nomeAcompanhante,reservaDTO.cpfAcompanhante,reservaDTO.idadeAcompanhante);
            Pedido pedido = new Pedido(cliente);

            Duration duracao = Duration.between(reservaDTO.entrada, reservaDTO.salida);
            int noites =(int)duracao.toDays();
//            if (duracao.toHours() % 24 != 0) {
//                noites++;
//            }

            Reserva reserva=new Reserva(noites,quartoAleatorio,pedido,cliente);

            clienteRepository.save(cliente);
            pedidoRepository.save(pedido);
            reservaRepository.save(reserva);

            notafiscal= new NotaFiscal(cliente,hotel,quartoAleatorio,reserva);
            nota =Optional.ofNullable(notafiscal);
        }else{
            throw new Exception("Quarto no disponivel ");
        }

        return nota;
    }
}