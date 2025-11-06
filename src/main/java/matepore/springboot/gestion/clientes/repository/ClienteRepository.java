package matepore.springboot.gestion.clientes.repository;

import matepore.springboot.gestion.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
