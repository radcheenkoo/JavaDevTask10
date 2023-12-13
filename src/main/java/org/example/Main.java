package org.example;

import org.example.crud.services.ClientCrudService;
import org.example.crud.services.PlanetCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;

public class Main {

    public static void main(String[] args) {

        // Тестування ClientCrudService
        ClientCrudService clientService = new ClientCrudService();

        // Додавання нового клієнта
        Client newClient = new Client();
        newClient.setName("John Doe");
        clientService.create(newClient);

        // Отримання клієнта за ідентифікатором
        Client retrievedClient = clientService.getById(newClient.getId());
        System.out.println("Retrieved Client: " + retrievedClient.getName());

        // Зміна імені клієнта та оновлення в базі даних
        retrievedClient.setName("Updated Name");
        clientService.update(retrievedClient);
        System.out.println("Updated Client: " + retrievedClient.getName());

        // Видалення клієнта
        clientService.deleteById(retrievedClient.getId());
        System.out.println("Client deleted");

        Client client = new Client();
        client.setName("dima");
        System.out.println(clientService.create(client));

        System.out.println(clientService.getById(1053));


        // Тестування PlanetCrudService
        PlanetCrudService planetService = new PlanetCrudService();

        // Додавання нової планети
        Planet newPlanet = new Planet();
        newPlanet.setName("Earth");
        newPlanet.setId("EARTH");
        planetService.create(newPlanet);

        // Отримання планети за ідентифікатором
        Planet retrievedPlanet = planetService.getById(newPlanet.getId());
        System.out.println("Retrieved Planet: " + retrievedPlanet.getName());

        // Зміна імені планети та оновлення в базі даних
        retrievedPlanet.setName("Updated Planet");
        planetService.update(retrievedPlanet);
        System.out.println("Updated Planet: " + retrievedPlanet.getName());

        // Видалення планети
        planetService.deleteById(retrievedPlanet.getId());
        System.out.println("Planet deleted");


    }
}
