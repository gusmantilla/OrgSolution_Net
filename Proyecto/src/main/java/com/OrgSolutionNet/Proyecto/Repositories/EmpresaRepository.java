package com.OrgSolutionNet.Proyecto.Repositories;

import com.OrgSolutionNet.Proyecto.Entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
