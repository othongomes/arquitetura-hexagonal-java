package br.com.boletojuros11.adapter.datasource.database.repository;

import br.com.boletojuros11.adapter.datasource.database.entity.BoletoCalculadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoCalculadoRepository extends JpaRepository<BoletoCalculadoEntity, Long> {
}
