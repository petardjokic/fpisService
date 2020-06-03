package fon.is.fpis.service.impl;

import static fon.is.fpis.domain.WorkerPosition.WORKER;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fon.is.fpis.dao.InternalCheckPlanRepository;
import fon.is.fpis.dao.WorkerRepository;
import fon.is.fpis.domain.InternalCheckPlan;
import fon.is.fpis.service.InternalCheckPlanService;

@Service
public class InternalCheckPlanServiceImpl implements InternalCheckPlanService {

	private InternalCheckPlanRepository planRepo;

	public InternalCheckPlanServiceImpl(InternalCheckPlanRepository planRepo, WorkerRepository workerRepo) {
		this.planRepo = planRepo;
//		Worker worker1 = Worker.builder().firstName("Worker1").lastName("Plan").position(WORKER).build();
//		Worker worker2 = Worker.builder().firstName("Worker2").lastName("Plan").position(WORKER).build();
//		workerRepo.save(worker1);
//		workerRepo.save(worker2);
//		
//		planRepo.save(InternalCheckPlan.builder().date(LocalDate.now()).checkSubject("Sub").description("Desc").sender(worker1).receiver(worker2).build());
	}

	@Override
	public Optional<InternalCheckPlan> getInternalCheckPlanById(Long id) {
		Optional<InternalCheckPlan> plan = planRepo.findById(id);
		Optional.ofNullable(plan)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Plan with ID %s does not exist", id)));
		return plan;
	}

	@Override
	public List<InternalCheckPlan> getAllInternalCheckPlans() {
		return planRepo.findAll();
	}

	@Override
	@Transactional
	public InternalCheckPlan saveInternalCheckPlan(InternalCheckPlan plan) {
		return planRepo.saveAndFlush(plan);
	}

	@Override
	public void deleteInternalCheckPlanById(Long id) {
		planRepo.deleteById(id);
	}

}
