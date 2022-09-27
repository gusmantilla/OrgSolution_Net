package com.OrgSolutionNet.Proyecto.Repositories;

import com.OrgSolutionNet.Proyecto.Entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

}
