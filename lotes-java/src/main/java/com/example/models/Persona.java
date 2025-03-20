package com.example.models;

import lombok.Data;

@Data
public class Persona {
	public Persona(long id, String nombre, String correo, String ip) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.ip = ip;
	}
	public Persona(long id, String nombre, String correo, String ip) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.ip = ip;
	}
	private long id;
	private String nombre, correo, ip;
	// Ctor(), Get/Set, toString(), …
}

