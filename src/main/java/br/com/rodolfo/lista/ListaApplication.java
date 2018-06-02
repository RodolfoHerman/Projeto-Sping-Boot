package br.com.rodolfo.lista;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



//A anotação 'SpringBootApplication' é responsável por configurar a aplicação SPRING
@SpringBootApplication
public class ListaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaApplication.class, args);
	}


	// @Bean
	// public LocaleResolver localeResolver () {
	// 	return (new FixedLocaleResolver (new Locale ("pt", "BR")));
	// }



	//Versões mais novas do framework essa configuração é realizada no arquivo 'appication.properties'
	//A anotação 'Bean' informa que o método (data source) deve ser gerenciado pelo SPRING
	// @Bean
	// public DataSource dataSource() {
		
	// 	DriverManagerDataSource dataSource = new DriverManagerDataSource();

	// 	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	// 	dataSource.setUrl("jdbc:mysql://localhost:3306/lista");
	// 	dataSource.setUsername("root");
	// 	dataSource.setPassword("root");

	// 	return dataSource;
	// }
}
