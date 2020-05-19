package fon.is.fpis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fon.is.fpis.domain.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
