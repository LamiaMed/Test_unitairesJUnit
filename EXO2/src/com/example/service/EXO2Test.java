package com.example.service;

import com.example.model.City;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class EXO2Test {
    City city=new City(1,"Alger",123,"capital");
    DatabaseConnection datab =new DatabaseConnection("sa","","org.h2.Driver","jdbc:h2:mem:test") ;
    Connection conn = datab.connect();


    @Test
    public void addCity() {
        datab.createDb(conn);
        assertEquals(1,new DatabaseService().addCity(conn, city));

    }

    @Test
    public void getCity() {
        datab.createDb(conn);
        new DatabaseService().addCity(conn, city);
        assertEquals(city.getIdCity(),new DatabaseService().getCity(conn, 1).getIdCity());
        assertEquals(city.getTouristNumber(),new DatabaseService().getCity(conn, 1).getTouristNumber());
        assertEquals(city.getName(),new DatabaseService().getCity(conn, 1).getName());
        assertEquals(city.getDescription(),new DatabaseService().getCity(conn, 1).getDescription());
    }
}