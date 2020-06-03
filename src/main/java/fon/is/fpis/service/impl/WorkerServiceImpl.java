package fon.is.fpis.service.impl;

import org.springframework.stereotype.Service;

import fon.is.fpis.dao.WorkerRepository;
import fon.is.fpis.domain.Worker;
import static  fon.is.fpis.domain.WorkerPosition.*;

import java.util.List;

import fon.is.fpis.service.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService{
	
	private WorkerRepository workerRepo;
	
	public WorkerServiceImpl(WorkerRepository workerRepo) {
		this.workerRepo = workerRepo;
//		this.workerRepo.save(Worker.builder().firstName("Worker1").lastName("Hard1").position(WORKER).build());
//		this.workerRepo.save(Worker.builder().firstName("Worker2").lastName("Hard2").position(WORKER).build());
//		this.workerRepo.save(Worker.builder().firstName("Worker3").lastName("Hard3").position(WORKER).build());
	}

	@Override
	public List<Worker> getAll() {
		return workerRepo.findAll();
	}
	
}
