package com.T2.LP2_T2_SOTELO_CARLOS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.T2.LP2_T2_SOTELO_CARLOS.model.OrdenCompra;
import com.T2.LP2_T2_SOTELO_CARLOS.service.OrdenCompraService;
import com.T2.LP2_T2_SOTELO_CARLOS.service.ProveedorService;
import com.T2.LP2_T2_SOTELO_CARLOS.service.RubroService;
import com.T2.LP2_T2_SOTELO_CARLOS.util.Alert;



@Controller
@RequestMapping("orden")
public class OrdenCompraController {

	@Autowired
	private OrdenCompraService serOrden;
	
	@Autowired
	private ProveedorService serProve;
	
	@Autowired
	private RubroService serRubro;
	
	@GetMapping("listado")
	public String listado(Model model ) {
		model.addAttribute("lstOrden", serOrden.getAll());
		return "orden/listado";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedor" , serProve.getAll());
		model.addAttribute("orden", new OrdenCompra());
		return "orden/nuevo";
	}
	
	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompra oc,Model model, RedirectAttributes flash) {
		
		var response = serOrden.create(oc);
		
		if(!response.success) {
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje));
			model.addAttribute("lstOrden", serOrden.getAll());
			model.addAttribute("lstProveedor", serProve.getAll());
			return "orden/nuevo";
		}
		
		flash.addFlashAttribute("toast", Alert.sweetToast(response.mensaje, "success", 5000));
		return "redirect:/orden/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("lstOrden", serOrden.getAll());
		model.addAttribute("lstProveedor", serProve.getAll());
		model.addAttribute("orden", serOrden.getOne(id));
		return "orden/edicion";
	}
	
	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompra oc,Model model, RedirectAttributes flash) {
		
		var response = serOrden.update(oc);
		
		if(!response.success) {
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje));
			model.addAttribute("lstOrden", serOrden.getAll());
			model.addAttribute("lstProveedor", serProve.getAll());
			return "orden/nuevo";
		}
		
		flash.addFlashAttribute("toast", Alert.sweetToast(response.mensaje, "success", 5000));
		return "redirect:/orden/listado";
	}
	
	
	
}
