package fon.is.fpis.stateful;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fon.is.fpis.domain.Product;
import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.domain.StorageWarantItem;
import fon.is.fpis.service.ProductService;
import fon.is.fpis.service.StorageFinalProductWarrantService;
import fon.is.fpis.service.impl.dto.InfoMessage;
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

	@RequestMapping(path = "warrants")
	public String getWarrant(Model model) {
		
		StorageFinalProductWarrant warrant = new StorageFinalProductWarrant();
		StorageWarantItem item = new StorageWarantItem();

		model.addAttribute("dto", new WarrantDto(warrant, item));
		model.addAttribute("message", InfoMessage.builder().show(false).build());
		return "warrant";
	}

	@RequestMapping(path = "warrants", params = { "findWarrant" })
	public String getWarrantbyId(WarrantDto war, Model model) {
		
		log.info("WARRANT ID: {}", war.getWarrant().getId());
		StorageFinalProductWarrant warrant = warrantService.getById(war.getWarrant().getId())
				.orElse(new StorageFinalProductWarrant());
		StorageWarantItem item = new StorageWarantItem();
		InfoMessage message = InfoMessage.builder().show(false).build();
		if (warrant.getId() == null) {
			message = InfoMessage.builder().show(true).value("Warrant does not exist").type("danger").build();
		}
		model.addAttribute("dto", new WarrantDto(warrant, item));
		model.addAttribute("message", message);
		return "warrant";
	}

	@RequestMapping(path = "warrants", params = { "findItem" })
	public String getItemByOrderNumber(WarrantDto war, Model model) {
		log.info("ITEM ORDER NUMBER: {}", war.getItem().getOrderNumber());
		log.info("DTO DATA: {}", war);
		StorageWarantItem item = findItem(war);
		InfoMessage message = InfoMessage.builder().show(false).build();
		if (item != null) {
			war.setItem(item);
		} else {
			message = InfoMessage.builder().show(true).value("Item dont exist!").type("danger").build();
		}
		model.addAttribute("dto", war);
		model.addAttribute("message", message);
		return "warrant";
	}

	@RequestMapping(path = "warrants", params = { "addItem" })
	public String addItem(WarrantDto war, Model model) {
		log.info("Add item envoked");
		boolean alreadyExist = doesItemNumberAlreadyExist(war);
		InfoMessage message;
		if (!alreadyExist) {
			war.getItem().setProduct(productService.getById(war.getItem().getProduct().getId()));
			war.getWarrant().getItems().add(war.getItem());
			war.setItem(new StorageWarantItem());
			message = InfoMessage.builder().show(true).value("Item added!").type("success").build();
		} else {
			message = InfoMessage.builder().show(true).value("Item with that order number already exist!")
					.type("danger").build();
		}
		model.addAttribute("dto", war);
		model.addAttribute("message", message);
		return "warrant";
	}

	@RequestMapping(path = "warrants", params = { "changeItem" })
	public String changeItem(WarrantDto war, Model model) {
		log.info("Change item envoked: {}", war.getItem());
		StorageWarantItem item = findItem(war);
		InfoMessage message;
		if (item != null) {
			log.info("Change item old: {}", war.getItem());
			log.info("Change item new: {}", war.getItem());
			change(item, war.getItem());
			war.setItem(new StorageWarantItem());
			message = InfoMessage.builder().show(true).value("Item changed!").type("success").build();
		} else {
			log.info("Change item failed: Item dont exist");
			message = InfoMessage.builder().show(true).value("Item dont exist!").type("danger").build();
		}

		model.addAttribute("dto", war);
		model.addAttribute("message", message);
		return "warrant";
	}

	@RequestMapping(path = "warrants", params = { "deleteItem" })
	public String deleteItem(WarrantDto war, Model model) {
		log.info("delete item envoked");
		List<StorageWarantItem> items = war.getWarrant().getItems().stream()
				.filter(item -> !item.getOrderNumber().equals(war.getItem().getOrderNumber()))
				.collect(Collectors.toList());
		InfoMessage message;
		if (war.getWarrant().getItems().size() != items.size()) {
			war.getWarrant().setItems(items);
			war.setItem(new StorageWarantItem());
			message = InfoMessage.builder().show(true).value("Item deleted!").type("success").build();
		} else {
			log.info("Delete item failed: Item dont exist");
			message = InfoMessage.builder().show(true).value("Item dont exist!").type("danger").build();
		}
		model.addAttribute("dto", war);
		model.addAttribute("message", message);
		return "warrant";
	}

	@RequestMapping(path = "warrants", params = { "saveWarrant" })
	public String saveWarrant(WarrantDto war, Model model) {
		log.info("Save warrant envoked");
		warrantService.save(war.getWarrant());
		StorageFinalProductWarrant warrant = new StorageFinalProductWarrant();
		StorageWarantItem item = new StorageWarantItem();
		model.addAttribute("dto", new WarrantDto(warrant, item));
		model.addAttribute("message", InfoMessage.builder().show(true).value("Warrant saved!").type("success").build());
		return "warrant";
	}

	private void change(StorageWarantItem oldObj, StorageWarantItem newObj) {
		oldObj.setNote(newObj.getNote());
		oldObj.setAmount(newObj.getAmount());
		oldObj.setProduct(productService.getById(newObj.getProduct().getId()));
	}

	private StorageWarantItem findItem(WarrantDto dto) {
		return dto.getWarrant().getItems().stream()
				.filter(item -> item.getOrderNumber().equals(dto.getItem().getOrderNumber())).findAny().orElse(null);
	}

	private boolean doesItemNumberAlreadyExist(WarrantDto war) {
		return war.getWarrant().getItems().stream()
				.anyMatch(item -> item.getOrderNumber().equals(war.getItem().getOrderNumber()));
	}

	@ModelAttribute("allProducts")
	public List<Product> allProducts() {
		return productService.getAll();
	}
}
