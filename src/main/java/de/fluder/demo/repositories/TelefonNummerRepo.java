package de.fluder.demo.repositories;

import de.fluder.demo.entity.TelefonNummer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonNummerRepo extends JpaRepository<TelefonNummer, Long> {
}
