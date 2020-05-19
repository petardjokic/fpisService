package fon.is.fpis.service.impl;

import static fon.is.fpis.domain.WorkerPosition.WORKER;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fon.is.fpis.dao.InternalCheckPlanRepository;
import fon.is.fpis.dao.ProductRepository;
import fon.is.fpis.dao.WorkerRepository;
import fon.is.fpis.domain.InternalCheckPlan;
import fon.is.fpis.domain.Worker;
import fon.is.fpis.service.InternalCheckPlanService;
import fon.is.fpis.service.dto.InternalCheckPlanSearchRequest;
import fon.is.fpis.service.dto.InternalCheckPlanSearchResponse;

@Service
public class InternalCheckPlanServiceImpl implements InternalCheckPlanService {

	private InternalCheckPlanRepository planRepo;

	public InternalCheckPlanServiceImpl(InternalCheckPlanRepository planRepo, WorkerRepository workerRepo) {
		this.planRepo = planRepo;
		Worker worker1 = Worker.builder().firstName("Worker1").lastName("Plan").position(WORKER).build();
		Worker worker2 = Worker.builder().firstName("Worker2").lastName("Plan").position(WORKER).build();
		workerRepo.save(worker1);
		workerRepo.save(worker2);
		
		planRepo.save(InternalCheckPlan.builder().date(LocalDate.now()).checkSubject("Sub").description("Desc").sender(worker1).receiver(worker2).build());
	}

	@Override
	public InternalCheckPlan getInternalCheckPlanById(Long id) {
		Optional<InternalCheckPlan> plan = planRepo.findById(id);
		Optional.ofNullable(plan)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Plan with ID %s does not exist", id)));
		return plan.get();
	}

	@Override
	public List<InternalCheckPlan> getAllInternalCheckPlans() {
		return planRepo.findAll();
	}

	@Override
	public InternalCheckPlanSearchResponse searchInternalCheckPlans(InternalCheckPlanSearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalCheckPlan saveInternalCheckPlan(InternalCheckPlan plan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteInternalCheckPlanById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
