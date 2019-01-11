package com.mahendracandi.spring5mvccontentnegotiatingviewresolver.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pizza")
public class Pizza {
    private String name;
    private String flavour;
    private List<String> toppings;

    public Pizza(){}

    public Pizza(String name, String flavour, List<String> toppings) {
        this.name = name;
        this.flavour = flavour;
        this.toppings = toppings;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getFlavour() {
        return flavour;
    }

    @XmlElement
    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public List<String> getToppings() {
        return toppings;
    }

    @XmlElement
    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", flavour='" + flavour + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
