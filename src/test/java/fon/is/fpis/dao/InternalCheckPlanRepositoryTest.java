package fon.is.fpis.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fon.is.fpis.dao.InternalCheckPlanRepository;
import fon.is.fpis.dao.WorkerRepository;
import fon.is.fpis.domain.InternalCheckPlan;
import fon.is.fpis.domain.Worker;
import fon.is.fpis.domain.WorkerPosition;

class InternalCheckPlanRepositoryTest extends BasicSpringTest{
	
	@Autowired
	InternalCheckPlanRepository planRepo;
	
	@Autowired
	WorkerRepository workerRepo;

	@Test
	void test() {
		Worker worker1 = Worker.builder().firstName("Rad").lastName("Wer").position(WorkerPosition.UNKNOWN).build();
		Worker worker2 = Worker.builder().firstName("L").lastName("Skal").position(WorkerPosition.UNKNOWN).build();
		workerRepo.save(worker1);
		workerRepo.save(worker2);
		
		InternalCheckPlan plan1 = InternalCheckPlan.builder().date(LocalDate.now()).checkSubject("mocco").sender(worker1).receiver(worker2).build();
		planRepo.save(plan1);
		InternalCheckPlan plan2 = planRepo.findById(plan1.getId()).get();
		assertEquals(plan1.getId(), plan2.getId());
		assertEquals(plan1.getDate(), plan2.getDate());
		assertEquals(plan1.getCheckSubject(), plan2.getCheckSubject());
		assertEquals(plan1.getSender().getId(), plan2.getSender().getId());
		assertEquals(plan1.getSender().getFirstName(), plan2.getSender().getFirstName());
		assertEquals(plan1.getSender().getLastName(), plan2.getSender().getLastName());
		assertEquals(plan1.getSender().getPosition(), plan2.getSender().getPosition());
		assertEquals(plan1.getReceiver().getId(), plan2.getReceiver().getId());
		assertEquals(plan1.getReceiver().getFirstName(), plan2.getReceiver().getFirstName());
		assertEquals(plan1.getReceiver().getLastName(), plan2.getReceiver().getLastName());
		assertEquals(plan1.getReceiver().getPosition(), plan2.getReceiver().getPosition());
//		assertEquals(plan1.getSender(), plan2.getSender());
	}

}
