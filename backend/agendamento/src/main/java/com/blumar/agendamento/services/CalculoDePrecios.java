package com.blumar.agendamento.services;

import com.blumar.agendamento.entities.Quarto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CalculoDePrecios {

    public int calculoValorTotal(int noites, boolean temAcompanhante, int idadeAcompanhante) {
        int valorTotalReserva = 0; // Initialize the total reservation cost

        for (int i = 0; i < noites; i++) {
            var dayOfWeek = LocalDateTime.now().plusDays(i).getDayOfWeek();

            switch (dayOfWeek) {
                case MONDAY, THURSDAY, WEDNESDAY, TUESDAY:
                    if (temAcompanhante) {
                        if (idadeAcompanhante >= 18) {
                            valorTotalReserva += 130;
                        } else {
                            valorTotalReserva += 160;
                        }
                    } else {
                        valorTotalReserva += 100;
                    }
                    break;

                case FRIDAY, SATURDAY, SUNDAY:
                    if (temAcompanhante ) {
                        if (idadeAcompanhante >= 18) {
                            valorTotalReserva += 150;
                        } else {
                            valorTotalReserva += 180;
                        }
                    } else {
                        valorTotalReserva += 120;
                    }
                    break;
            }
        }

        return valorTotalReserva;
    }


}
