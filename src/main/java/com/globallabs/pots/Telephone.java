package com.globallabs.pots;

import java.util.Objects;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Telephone {
    
    private @Id @GeneratedValue Long id;
    private int number;

    Telephone(){
        this.number = generateNumber();
    }

    /**
     * Getter for the Id field
     * @return the identifier of the phone
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter for the number
     * @return the telephone number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Compare to telephone to see if they are the same
     * 
     * @param o The object to compare
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Telephone)) {
            return false;
        }
        Telephone telephone = (Telephone)o;
        return Objects.equals(this.id, telephone.id) && Objects.equals(this.number, telephone.number);
    }

    /**
     * String representation of the object
     */
    @Override
    public String toString() {
        return "Telephone{" + "id=" + this.id + "}";
    }

    /**
     * Generates a random number for the phone
     * @return an integer of 7 digits
     */
    private int generateNumber() {
        Random rnd = new Random();
        return 1000000 + rnd.nextInt(9000000);
    }
}
