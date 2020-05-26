package fon.is.fpis.stateful;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fon.is.fpis.domain.Product;
import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.domain.StorageWarantItem;
import fon.is.fpis.service.ProductService;
import fon.is.fpis.service.StorageFinalProductWarrantService;
import fon.is.fpis.stateful.dto.WarrantDto;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(path = "view")
@Slf4j
public class WarrantController {
	
	@Autowired
	private StorageFinalProductWarrantService warrantService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(path = {"warrants","warrants/{id}", "warrants/{id}/{orderNumber}"})
	public String getWarrant(@PathVariable(required = false) Long id, @PathVariable(required = false) Integer orderNumber, Model model) {
//		StorageFinalProductWarrant warrant = id == null ? new StorageFinalProductWarrant() : warrantService.getById(id);
//		StorageWarantItem item = orderNumber == null ? new StorageWarantItem() : findItem(warrant, orderNumber);
		StorageFinalProductWarrant warrant = new StorageFinalProductWarrant();
		StorageWarantItem item = new StorageWarantItem();
		model.addAttribute("dto", new WarrantDto(warrant, item));
		return "warrant";
	}
	
	@RequestMapping(path = "warrants", params={"findWarrant"})
	public String getWarrantbyId(WarrantDto war, Model model) {
		log.info("WARRANT ID: {}", war.getWarrant().getId());
		StorageFinalProductWarrant warrant = warrantService.getById(war.getWarrant().getId());
		StorageWarantItem item = new StorageWarantItem();
		model.addAttribute("dto", new WarrantDto(warrant, item));
		return "warrant";
	}
	
	@RequestMapping(path = "warrants", params={"findItem"})
	public String getItemByOrderNumber(WarrantDto war, Model model) {
		log.info("ITEM ORDER NUMBER: {}", war.getItem().getOrderNumber());
		log.info("DTO DATA: {}", war);
		StorageWarantItem item = findItem(war);
		war.setItem(item);
		model.addAttribute("dto", war);
		return "warrant";
	}
	
	@RequestMapping(path = "warrants", params={"addItem"})
	public String addItem(WarrantDto war, Model model) {
		log.info("Add item envoked");
		Integer nextOrderNum = war.getWarrant().getItems().stream().mapToInt(v -> v.getOrderNumber()).max().orElseGet(() -> 0) + 1;
		log.info("Order num: {}", nextOrderNum);
		war.getItem().setOrderNumber(nextOrderNum);
		war.getItem().setProduct(productService.getById(war.getItem().getProduct().getId()));
		war.getWarrant().getItems().add(war.getItem());
		war.setItem(new StorageWarantItem());
		model.addAttribute("dto", war);
		return "warrant";
	}
	
	@RequestMapping(path = "warrants", params={"changeItem"})
	public String changeItem(WarrantDto war, Model model) {
		log.info("Change item envoked: {}", war.getItem());
		StorageWarantItem item = findItem(war);
		change(item, war.getItem());
		war.setItem(new StorageWarantItem());
		model.addAttribute("dto", war);
		return "warrant";
	}
	
	@RequestMapping(path = "warrants", params={"deleteItem"})
	public String deleteItem(WarrantDto war, Model model) {
		log.info("delete item envoked");
		List<StorageWarantItem> items = war.getWarrant().getItems().stream().filter(item -> !item.getOrderNumber().equals(war.getItem().getOrderNumber())).collect(Collectors.toList());
		war.getWarrant().setItems(items);
		war.setItem(new StorageWarantItem());
		model.addAttribute("dto", war);
		return "warrant";
	}
	
	@RequestMapping(path = "warrants", params={"saveWarrant"})
	public String saveWarrant(WarrantDto war, Model model) {
		log.info("Save warrant envoked");
		warrantService.save(war.getWarrant());
		StorageFinalProductWarrant warrant = new StorageFinalProductWarrant();
		StorageWarantItem item = new StorageWarantItem();
		model.addAttribute("dto", new WarrantDto(warrant, item));
		return "warrant";
	}
	
	private void change(StorageWarantItem oldObj, StorageWarantItem newObj) {
		oldObj.setNote(newObj.getNote());
		oldObj.setAmount(newObj.getAmount());
		oldObj.setProduct(productService.getById(newObj.getProduct().getId()));
	}

	private StorageWarantItem findItem(WarrantDto dto) {
		return dto.getWarrant().getItems().stream()
				.filter(item -> item.getOrderNumber().equals(dto.getItem().getOrderNumber()))
				.findAny()
				.get();
	}

	@ModelAttribute("allProducts")
	public List<Product> allProducts() {
		return productService.getAll();
	}
}
