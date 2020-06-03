package fon.is.fpis.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fon.is.fpis.domain.Worker;
import fon.is.fpis.domain.WorkerPosition;


class WorkerRepositoryTest extends BasicSpringTest {
	
	@Autowired
	WorkerRepository workerRepo;
	
	//@Test
	void test() {
		Worker worker1 = Worker.builder().firstName("Petar").lastName("Djokic").position(WorkerPosition.UNKNOWN).build();
		workerRepo.save(worker1);
		Worker worker2 = workerRepo.findById(worker1.getId()).get();
		assertEquals(worker1.getId(), worker2.getId());
		assertEquals(worker1.getFirstName(), worker2.getFirstName());
		assertEquals(worker1.getLastName(), worker2.getLastName());
		assertEquals(worker1.getPosition(), worker2.getPosition());
	}

}
