package com.blumar.agendamento.entities.enums;

public enum RoomType {
    INDIVIDUAL("Individual", 100, 120),
    CASAL("Casal", 130, 150),
    FAMILIAR("Familiar", 160, 180),
    PRESIDENCIAL("Presidencial", 0, 0); // Assuming price for Presidencial room is not defined

    private final String description;
    private final int weekdayPrice;
    private final int weekendPrice;

    RoomType(String description, int weekdayPrice, int weekendPrice) {
        this.description = description;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getWeekdayPrice() {
        return weekdayPrice;
    }

    public int getWeekendPrice() {
        return weekendPrice;
    }

    public int getPriceForDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return weekendPrice;
        } else {
            return weekdayPrice;
        }
    }
}

// public enum RoomType {
//     INDIVIDUAL,CASAL,FAMILIAR,PRESIDENCIAL;
// }
