package lesson7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Белый", "Lada");

        String carFromJson = objectMapper.writeValueAsString(car);
        System.out.println(carFromJson);

        Car car1 = objectMapper.readValue(carFromJson, Car.class);
        System.out.println(car1);

        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("Black", "Mercedes"),
                new Car("Red", "Renault")));
        System.out.println(carList);
        String carListAsJson = objectMapper.writeValueAsString(carList);
        System.out.println(carListAsJson);

        List<Car> carListFromJson = objectMapper.readValue(carListAsJson, new TypeReference<ArrayList<Car>>() {});
        System.out.println(carListFromJson);

        String jsonCarAfterUpdate = "{\"color\":\"Белый\",\"type\":\"Lada\",\"year\":\"Lada\"}";
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car carAfterUpdate = objectMapper.readValue(jsonCarAfterUpdate, Car.class);
        System.out.println(carAfterUpdate);

        String jsonCarAfterRefactoring = "{\"color\":\"Белый\",\"model\":\"Lada\"}";
        Car carFromJsonAfterRefactoring = objectMapper.readValue(jsonCarAfterRefactoring, Car.class);
        System.out.println(carFromJsonAfterRefactoring);

        //objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        //objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        String carJsonWithRootValue = objectMapper.writeValueAsString(car);
        System.out.println(carJsonWithRootValue);

        Car car2 = objectMapper.readValue(carJsonWithRootValue, Car.class);
        System.out.println(car2);

        Car carWithSeat = new Car("Yellow", "Peugeot");
        carWithSeat.setSeat(new Seat(5));

        String carWithSeatJson = objectMapper.writeValueAsString(carWithSeat);
        System.out.println(carWithSeatJson);

        Car carFromJsonWithSeat = objectMapper.readValue(carWithSeatJson, Car.class);
        System.out.println(carFromJsonWithSeat);
    }
}