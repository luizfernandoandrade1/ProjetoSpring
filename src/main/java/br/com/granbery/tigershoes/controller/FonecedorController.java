package br.com.granbery.tigershoes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.granbery.tigershoes.dao.FornecedorDAO;
import br.com.granbery.tigershoes.enums.TipoCliente;
import br.com.granbery.tigershoes.model.Cliente;
import br.com.granbery.tigershoes.model.Endereco;
import br.com.granbery.tigershoes.model.Fornecedor;

@Controller
public class FonecedorController {

	@RequestMapping("/cadastrarFornecedor")
	public ModelAndView cadastrarFornecedor(Cliente cliente, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("fornecedor/cadastrar-fornecedor");
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if(cliente==null) {
			mv.addObject("tipoCliente", TipoCliente.EXTERNO);
			return mv;
			
		} else {	
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());
			return mv;			
			
		}
		
	}
	
	@RequestMapping("/salvarFornecedor")
	public ModelAndView salvarFornecedor(Fornecedor fornecedor, Endereco endereco, Cliente cliente, HttpServletRequest request) {
		String message = "Fornecedor Cadastrado com Sucesso!";
		ModelAndView mv; 
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		
		if (!verificaEnderecoFornecedor(endereco).isEmpty()) {
			message = verificaEnderecoFornecedor(endereco);
			mv = new ModelAndView("fornecedor/falha-cadastrar-fornecedor");
			mv.addObject("message", message);
			mv.addObject("cliente", cliente);
			return mv;
		}
		
		if (fornecedor.getNome().isEmpty()) {
			message = "Preencha o nome do Fornecedor";
			mv = new ModelAndView("fornecedor/falha-cadastrar-fornecedor");
			mv.addObject("message", message);
			mv.addObject("cliente", cliente);
			return mv;
		}
		
		if(cliente==null) {
			mv = new ModelAndView("cliente/login-cliente");
			return mv;
			
		} else {
			mv = new ModelAndView("fornecedor/sucesso-cadastro-fornecedor");
			fornecedor.setEndereco(endereco);
			endereco.setFornecedor(fornecedor);
			
			FornecedorDAO.getInstance().persist(fornecedor);
			
			mv.addObject("message", message);
			mv.addObject("cliente", cliente);
			mv.addObject("tipoCliente", cliente.getTipoClienteString());	
			return mv;
		}
		
	}
	
	private String verificaEnderecoFornecedor(Endereco endereco) {
	
		if (endereco.getRua().isEmpty()) {
			return "Preencha o campo Rua";
		}
		else if (endereco.getCidade().isEmpty()) {
			return "Preencha o campo Cidade";
		}
		else if (endereco.getEstado().isEmpty()) {
			return "Preencha o campo Estado";
		}
		else if (endereco.getCep().isEmpty()) {
			return "Preencha o campo CEP";
		}
		else if (endereco.getPais().isEmpty()) {
			return "Preencha o campo País";
		}
		
		return "";
	}
}
