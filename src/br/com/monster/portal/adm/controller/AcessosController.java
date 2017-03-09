package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Acessos;
import br.com.monster.portal.modelDao.AcessosDao;
@Transactional
@Controller
public class AcessosController {
	

		@Autowired
		AcessosDao dao;
		
		/*

		 |==================================|
		 |				Métodos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("CreateAcessos")
		public String create(@Valid Acessos acessos, BindingResult result) {
			
			if(result.hasErrors()) {
			    return "forward:Marketing";
			} else {
				dao.create(acessos);
				return "redirect:Marketing";
			}
			
		}

		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("UpdateAcessos")
		public String update(@Valid Acessos acessos, BindingResult result) {

			if(result.hasErrors()) {
			    return "forward:Marketing";
			} else {
				dao.update(acessos);
				return "redirect:Marketing";
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 */
		
		@RequestMapping("DeleteAcessos")
		public String delete(Acessos acessos) {
		  dao.delete(acessos);
		  return "redirect:Marketing";
		}
}
