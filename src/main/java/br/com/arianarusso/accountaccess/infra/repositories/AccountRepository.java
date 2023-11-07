package br.com.arianarusso.accountaccess.infra.repositories;

import br.com.arianarusso.accountaccess.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
