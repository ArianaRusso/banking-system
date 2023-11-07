package br.com.arianarusso.accountaccess.infra.repositories;

import br.com.arianarusso.accountaccess.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
