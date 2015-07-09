package com.coffeeandcookies.queproponenmdq.objetos;

import android.graphics.drawable.Drawable;

public class Candidato
{
	Drawable imagen_perfil;
	String nombre;
	String partido;
	String URL;
	public Drawable getImagen_perfil()
	{
		return imagen_perfil;
	}
	public void setImagen_perfil(Drawable imagen_perfil)
	{
		this.imagen_perfil = imagen_perfil;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getPartido()
	{
		return partido;
	}
	public void setPartido(String partido)
	{
		this.partido = partido;
	}
	public String getURL()
	{
		return URL;
	}
	public void setURL(String uRL)
	{
		URL = uRL;
	}
	public Candidato(Drawable imagen_perfil, String nombre, String partido, String uRL)
	{
		super();
		this.imagen_perfil = imagen_perfil;
		this.nombre = nombre;
		this.partido = partido;
		URL = uRL;
	}
	
	
}
