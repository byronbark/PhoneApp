package com.globallabs.pots;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Telephone {
    
    private @Id int id;
    
    private Status status;
    
    public Telephone(final int id){
    	this.id = id;
    	this.status = Status.OFF_CALL;
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
        return "Telephone{" + "id=" + this.id + "}";
    }
}
