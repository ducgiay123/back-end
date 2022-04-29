package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
public class Person {
    private final UUID id ;
    private final String name;
    private final float money;
    private final String location;
    private final float saving ;
    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("money") float money, @JsonProperty("location") String location,@JsonProperty("saving") float saving){
        this.id = id ;
        this.name = name;
        this.money = money;
        this.location = location;
        this.saving = saving;
    }
    public Person( String name,  float money, String location){
        this.id = UUID.randomUUID();
        this.name = name;
        this.money = money;
        this.location = location;
        this.saving = (float) (money*1.1);
    }


    public float getSaving() {
        return (float) (money*1.1);
    }


    public String getLocation() {
        return location;
    }

    public float getMoney() {
        return money;
    }

    public UUID getID(){
        return id;
    }
    public String getName(){
        return name;
    }
}

