package br.com.arianarusso.accountaccess.infra.repositories;

import br.com.arianarusso.accountaccess.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
