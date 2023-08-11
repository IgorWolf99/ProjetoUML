package com.igorwolf.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igorwolf.cursomc.entities.Categoria;
import com.igorwolf.cursomc.entities.Cliente;
import com.igorwolf.cursomc.entities.Endereco;
import com.igorwolf.cursomc.entities.ItemPedido;
import com.igorwolf.cursomc.entities.PagBoleto;
import com.igorwolf.cursomc.entities.PagCartao;
import com.igorwolf.cursomc.entities.Pedido;
import com.igorwolf.cursomc.entities.Produto;
import com.igorwolf.cursomc.entities.enums.StatusPagamento;
import com.igorwolf.cursomc.entities.enums.TipoPessoa;
import com.igorwolf.cursomc.repositories.CategoriaRepository;
import com.igorwolf.cursomc.repositories.ClienteRepository;
import com.igorwolf.cursomc.repositories.EnderecoRepository;
import com.igorwolf.cursomc.repositories.ItemPedidoRepository;
import com.igorwolf.cursomc.repositories.PagamentoRepository;
import com.igorwolf.cursomc.repositories.PedidoRepository;
import com.igorwolf.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));


		Cliente cli1 = new Cliente(null, "Mario Andrade", "MarioAndrade@gmail.com", "890.478.960-44",TipoPessoa.PESSOAFISICA);
		Endereco end1 = new Endereco(null, "Rio Grande do Sul", "Porto Alegre", "Rua Flores", "99804-200", "Andradas", "896", "Casa", cli1);
		Endereco end2 = new Endereco(null, "Rio Grande do Sul", "Porto Alegre", "Av Castelo Branco", "91324-240", "Cristovão", "331", "Apartamento", cli1);
		
		cli1.getTelefones().addAll(Arrays.asList("(51) 99834-1204","(51) 3421-4567"));
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("15/06/2022 16:30"), cli1, end2);
		Pedido ped2 = new Pedido(null, sdf.parse("12/04/2022 12:00"), cli1, end1 );

		PagCartao pag1 = new PagCartao(null, StatusPagamento.QUITADO, ped1, 4);
		ped1.setPagamento(pag1);

		PagBoleto pag2 = new PagBoleto(null, StatusPagamento.PENDENTE, ped2, null, sdf.parse("15/04/2022 00:00"));
		ped2.setPagamento(pag2);

		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
		
		ItemPedido itemPed1 = new ItemPedido(ped1,p1,1,0.0,2000.0);
		ItemPedido itemPed2 = new ItemPedido(ped1,p3,2,0.0,80.0);
		ItemPedido itemPed3 = new ItemPedido(ped2,p2,1,100.0,800.0);

		ped1.getItens().addAll(Arrays.asList(itemPed1,itemPed2));
		ped2.getItens().addAll(Arrays.asList(itemPed3));

		p1.getItens().addAll(Arrays.asList(itemPed1));
		p2.getItens().addAll(Arrays.asList(itemPed3));
		p3.getItens().addAll(Arrays.asList(itemPed2));
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPed1,itemPed2,itemPed3));
	}
}
