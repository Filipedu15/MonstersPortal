package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Relatorios;
import br.com.monster.portal.modelDao.RelatoriosDao;

@Transactional
@Controller
public class RelatoriosController {
	

		@Autowired
		RelatoriosDao dao;
		
		/*

		 |==================================|
		 |				Métodos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Createrelatorios")
		public String create(@Valid Relatorios relatorios, BindingResult result) {
			
			if(result.hasErrors()) {
			    return "forward:Funcionario";
			} else {
				dao.create(relatorios);
				return "redirect:Funcionario";
			}
			
		}

		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("Admin/Updaterelatorios")
		public String update(@Valid Relatorios relatorios, BindingResult result) {

			if(result.hasErrors()) {
			    return "forward:Funcionario";
			} else {
				dao.update(relatorios);
				return "redirect:Funcionario";
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Deleterelatorios")
		public String delete(Relatorios relatorios) {
		  dao.delete(relatorios);
		  return "redirect:Funcionario";
		}


}
