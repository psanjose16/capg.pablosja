package com.example.demobatch.models;

import lombok.Data;

@Data
public class Persona {
	private long id;
	private String nombre, correo, ip;

	public Persona(long id, String nombre, String correo, String ip) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.ip = ip;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", ip=" + ip + ", hashCode()="
				+ hashCode() + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getCorreo()=" + getCorreo()
				+ ", getIp()=" + getIp() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	
}

