package br.com.granbery.tigershoes.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses(value = {
		TesteCliente.class,
		TesteFornecedor.class,
		TesteProduto.class,
		TestePedido.class
})
public class TesteSequencial {

}
