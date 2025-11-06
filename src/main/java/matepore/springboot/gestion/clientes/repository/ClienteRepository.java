package matepore.springboot.gestion.clientes.repository;

import matepore.springboot.gestion.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio JPA para la entidad Cliente
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
