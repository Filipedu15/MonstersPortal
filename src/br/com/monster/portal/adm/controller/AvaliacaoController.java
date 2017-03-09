package br.com.monster.portal.adm.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Avaliacao;
import br.com.monster.portal.modelDao.AvaliacaoDao;

@Transactional
@Controller
public class AvaliacaoController {
	

		@Autowired
		AvaliacaoDao dao;
		
		/*

		 |==================================|
		 |				Métodos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("CreateAvaliacao")
		public String create(@Valid Avaliacao avaliacao, BindingResult result) {
			
			if(result.hasErrors()) {
			    return "forward:Produto";
			} else {
				dao.create(avaliacao);
				return "redirect:Produto";
			}
			
		}

		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("Admin/UpdateAvaliacao")
		public String update(@Valid Avaliacao avaliacao, BindingResult result) {

			if(result.hasErrors()) {
			    return "forward:Produto";
			} else {
				dao.update(avaliacao);
				return "redirect:Produto";
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/DeleteAvaliacao")
		public String delete(Avaliacao avaliacao) {
		  dao.delete(avaliacao);
		  return "redirect:Produto";
		}
}
