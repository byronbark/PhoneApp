package com.globallabs.pots;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that have the necessary functions to make
 * database operations
 */
interface TelephoneRepository extends JpaRepository<Telephone, Long>{
    
}
