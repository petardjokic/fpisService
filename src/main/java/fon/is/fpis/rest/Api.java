package fon.is.fpis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fon.is.fpis.domain.InternalCheckPlan;
import fon.is.fpis.service.InternalCheckPlanService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "api")
@CrossOrigin
@Slf4j
public class Api {
	
	@Autowired
	private InternalCheckPlanService planService;
	
	@GetMapping(path = "internal-check-plan/{id}")
	public InternalCheckPlan getInternalCheckPlanById(@PathVariable Long id) {
		log.info("Request get plan with ID: {}", id);
		return planService.getInternalCheckPlanById(id);
	}
	
	@GetMapping(path = "internal-check-plan")
	public List<InternalCheckPlan> getAllInternalCheckPlans() {
		log.info("Request get all plans");
		return planService.getAllInternalCheckPlans();
	}
	
	@PostMapping(path = "internal-check-plan")
	public InternalCheckPlan saveAllInternalCheckPlans(@RequestBody InternalCheckPlan plan) {
		log.info("Request save plan: {}", plan);
		return planService.saveInternalCheckPlan(plan);
	}
	
	@DeleteMapping(path = "internal-check-plan")
	public void deleteInternalCheckPlanById(@PathVariable Long id) {
		log.info("Request delete plan with ID: {}", id);
		planService.deleteInternalCheckPlanById(id);
	}

}
