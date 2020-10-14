package fi.berg.valjakko.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.berg.valjakko.domain.Dog;
import fi.berg.valjakko.domain.DogRepository;
import fi.berg.valjakko.domain.KennelRepository;

@Controller
public class DogController {
	
	@Autowired
	private DogRepository repository;
	
	@Autowired
	private KennelRepository krepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/doglist")
	public String returnAllDogs(Model model) {
		model.addAttribute("dogs", repository.findAll());
		return "doglist";
	}
	
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteDog(@PathVariable("id") Long dogId, Model model) {
		repository.deleteById(dogId);
		return "redirect:../doglist";
	}
	
	@GetMapping("/add")
	public String addNewDog(Model model) {
		model.addAttribute("dog", new Dog());
		model.addAttribute("kennels", krepository.findAll());
		return "addDog";
	}
	
	@GetMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editDog(@PathVariable("id") Long dogId, Model model) {
		model.addAttribute("dog", repository.findById(dogId));
		model.addAttribute("kennels", krepository.findAll());
		return "editDog";	
	}
	
	@PostMapping("/save")
	public String save(@Valid Dog dog, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
		return "addDog";
		}
		model.addAttribute("dog", dog);
		repository.save(dog);
		return "redirect:doglist";
	}
}
