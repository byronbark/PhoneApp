package com.globallabs.pots;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Telephone {
    
    private @Id @GeneratedValue int id;
    private String username;
    private Status status;

    /**
     * Contructor of the telephone entity
     * @param username the username attached to the telephone
     */
    public Telephone(String username){
        this.username = username;
    }

    /**
     * Getter for the Id field
     * @return the identifier of the phone
     */
    public int getId() {
        return id;
    }
    
    /**
     * Getter for the status
     * @return the status of the phone
     */
    public Status getStatus() {
    	return status;
    }
    
    /**
     * Set a new status to the phone
     * @param newStatus
     */
    public void setStatus(final Status newStatus) {
    	this.status = newStatus;
    }
    
    /**
     * Getter for the Username field
     * @return the username attached to the phone
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for the Username field
     * @param username the username attached to the telephone
     */
    public void setUsername(String username) {
        this.username = username;
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
        return Objects.equals(this.id, telephone.id);
    }

    /**
     * String representation of the object
     */
    @Override
    public String toString() {
        return "Telephone{" + "id=" + this.id + ", username=" + this.username + "}";
    }
}
