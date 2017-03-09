package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.modelDao.CategoriaDao;
@Transactional
@Controller
public class CategoriaController {
	

		@Autowired
		CategoriaDao dao;
		
		/*

		 |==================================|
		 |				Métodos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/CreateCategoria")
		public String create(@Valid Categoria categoria, BindingResult result) {
			
			if(result.hasErrors()) {
			    return "forward:Categoria";
			} else {
				dao.create(categoria);
				return "redirect:Categoria";
			}
			
		}

		/*
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Categoria")
		public String Read(Model model) {
			model.addAttribute("categorias", dao.Read());
			return "admin/Produto/categoria";
		}

		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("Admin/UpdateCategoria")
		public String update(@Valid Categoria categoria, BindingResult result) {

			if(result.hasErrors()) {
			    return "forward:Categoria";
			} else {
				dao.update(categoria);
				return "redirect:Categoria";
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/DeleteCategoria")
		public String delete(Categoria categoria) {
		  dao.delete(categoria);
		  return "redirect:Categoria";
		}
		
}
