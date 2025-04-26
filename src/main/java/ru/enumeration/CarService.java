package ru.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Cтатус Toyota: " + toyota);
        System.out.println("Cтатус Volvo: " + volvo);

        Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);

        System.out.println("Заказ-наряд №" + order.getNumber() + " на автомобиль " + order.getCar()
                + ", статус ремонта: " + order.getStatus().getInfo() + ", подробности: "
                + order.getStatus().getMessage());

        Status[] statuses = Status.values();
        for (Status status : statuses) {
            System.out.println("Название статуса: " + status.name() + ", Порядковый номер статуса: " + status.ordinal());
        }

        String accepted = "ACCEPTED";
        Status status = Status.valueOf(accepted);
        switch (status) {
            case ACCEPTED -> System.out.println("Статус: автомобиль принят на СТО");
            case IN_WORK -> System.out.println("Статус: автомобиль в работе");
            case WAITING -> System.out.println("Статус: Автомобиль ожидает запчасти");
            case FINISHED -> System.out.println("Статус: Все работы завершены");
        }

    }
}
