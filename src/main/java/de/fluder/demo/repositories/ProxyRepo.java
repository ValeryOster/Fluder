package de.fluder.demo.repositories;

import de.fluder.demo.entity.Proxy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProxyRepo extends JpaRepository<Proxy, Long> {
}
