package org.acme.quickstart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.*;

@Path("/randomname")
public class RandomNameGenerator {

    //Credit to https://www.ssa.gov/oact/babynames/decades/century.html for name list
    //Used top 25 for boys and top 25 for girls
    String[] names = {
            "James", "Mary", "John", "Patricia", "Robert",
            "Jennifer", "Michael", "Linda", "William", "Elizabeth",
            "David", "Barbara", "Richard", "Susan", "Joseph",
            "Jessica", "Thomas", "Sarah", "Charles", "Karen",
            "Christopher", "Nancy", "Daniel", "Margaret", "Matthew",
            "Lisa", "Anthony", "Betty", "Donald", "Dorothy",
            "Mark", "Sandra", "Paul", "Ashley", "Steven",
            "Kimberly", "Andrew", "Donna", "Kenneth", "Emily",
            "Joshua", "Michelle", "George", "Carol", "Kevin",
            "Amanda", "Brian", "Melissa", "Edward", "Deborah"
    };

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return names[(int)(Math.random() * names.length)];
    }
}