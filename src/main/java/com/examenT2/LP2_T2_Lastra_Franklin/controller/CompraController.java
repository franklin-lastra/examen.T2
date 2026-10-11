package com.examenT2.LP2_T2_Lastra_Franklin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_Lastra_Franklin.model.OrdenCompraLastraFranklin;
import com.examenT2.LP2_T2_Lastra_Franklin.service.CompraService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("compra")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;


    @GetMapping("listadoLastraFranklin")
    public String listadoLastraFranklin(Model model) {
        model.addAttribute("lstOrdenes", compraService.getAllOrdenesDesc());
        return "compra/listadoLastraFranklin"; // Corregida la ruta a tu carpeta física real
    }


    @GetMapping("nuevoLastraFranklin")
    public String nuevoLastraFranklin(Model model) {
       
        model.addAttribute("lstproveedores", compraService.getAllProveedores());
        model.addAttribute("ordenCompra", new OrdenCompraLastraFranklin());
        return "compra/nuevoLastraFranklin";
    }


    @PostMapping("registrar")
    public String registrar(@ModelAttribute OrdenCompraLastraFranklin orden, RedirectAttributes flash) {
        var response = compraService.registrar(orden);
        
        var mensaje = String.format("Orden de Compra Nro. %d registrada con éxito.", response.getNroOrden());
        flash.addFlashAttribute("alert", com.examenT2.LP2_T2_Lastra_Franklin.util.Alert.sweetToast(mensaje, "success", 5000));
        
        return "redirect:/compra/listadoLastraFranklin";
    }


    @GetMapping("edicion/{id}")
    public String edicion(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("lstProveedores", compraService.getAllProveedores());
        model.addAttribute("ordenCompra", compraService.getOne(id));
        return "compra/edicionLastraFranklin"; // Corregida la ruta a tu carpeta física real
    }


    @PostMapping("actualizar")
    public String actualizar(@ModelAttribute OrdenCompraLastraFranklin orden, RedirectAttributes flash) {
        compraService.update(orden);
        
        var mensaje = String.format("Orden de Compra Nro. %d actualizada correctamente.", orden.getNroOrden());
        flash.addFlashAttribute("alert", com.examenT2.LP2_T2_Lastra_Franklin.util.Alert.sweetToast(mensaje, "success", 5000));
        return "redirect:/compra/listadoLastraFranklin";
    }
}