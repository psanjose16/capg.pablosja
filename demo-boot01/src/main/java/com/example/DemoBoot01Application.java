package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.ioc.Configuracion;
import com.example.ioc.Repositorio;
import com.example.ioc.Servicio;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.ioc")
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
//	@Autowired //(required = false)
//	Servicio srv;
	
	@Autowired //(required = false)
//	@Qualifier("verdad")
	Repositorio repo1;
	@Autowired //(required = false)
//	@Qualifier("mentira")
	Repositorio repo2;
//	@Autowired //(required = false)
//	Repositorio repo;

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada");
		//Servicio srv = new Servicio(new Repositorio(new Configuracion()));
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

//		srv.guardar();
//		repo.guardar();
		repo1.guardar();
		repo2.guardar();
	}
	
//	@Bean
//  	CommandLineRunner demo() {
//		return (args) -> {
//			System.err.println("Aplicacion arrancadaaaaaaaaaaaaaa");
//		};
//	}

}