package com.coffeeandcookies.queproponenmdq;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;

import com.coffeeandcookies.queproponenmdq.adaptadores.AdaptadorCandidatos;
import com.coffeeandcookies.queproponenmdq.objetos.Candidato;

public class MainActivity extends Activity
{

	private GridView grid_candidatos;
	ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
	CheckBox checkBox1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setUI();
		setCandidatos(1);

	}

	@Override
	protected void onResume()
	{
		setList();
		super.onResume();
	}

	void setUI()
	{
		grid_candidatos = (GridView) findViewById(R.id.grid_candidatos);
		checkBox1  = (CheckBox) findViewById(R.id.checkBox1);
		checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if (isChecked)
				setCandidatos(1);
				else
				setCandidatos(0);
				
				setList();
			}
		});
	}

	void setCandidatos(int seleccion)
	{
		candidatos.clear();
		String[] candidatos_res = getResources().getStringArray(R.array.nombres);
		String[] links_res = getResources().getStringArray(R.array.links);
		String[] partidos_res = getResources().getStringArray(R.array.partidos);
		String[] imagenes_res = getResources().getStringArray(R.array.imagenes);
		int[] paso_res = getResources().getIntArray(R.array.paso);
		for (int i = 0; i < candidatos_res.length; i++)
		{
			String nombre = candidatos_res[i];
			String partido = partidos_res[i];
			String link = links_res[i];
			String imagen = imagenes_res[i];
			int paso_aux = paso_res[i];
			Drawable imagen_d = getResources().getDrawable(getResources().getIdentifier(imagen, "drawable", getPackageName()));
			Candidato oCandidato =  new Candidato(imagen_d, nombre, partido, link); 
			if (paso_aux == seleccion)
			candidatos.add(oCandidato);			
		}
	}

	void setList()
	{
		AdaptadorCandidatos adapter = new AdaptadorCandidatos(getApplicationContext(), candidatos);
		Collections.shuffle(candidatos);
		grid_candidatos.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case R.id.action_facebok:
			Intent intent;
			try
			{
				getPackageManager().getPackageInfo("com.facebook.katana", 0);
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1426674787639743"));
			}
			catch (Exception e)
			{
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/PartidodelaRedMDQ"));
			}

			startActivity(intent);

			return true;
		case R.id.action_mail:

			try
			{
				getPackageManager().getPackageInfo("com.google.android.gm", 0);
				Intent intent_mail = new Intent(Intent.ACTION_SEND);

				String[] strTo = { "hola@partidodelaredmdq.org" };

				intent_mail.putExtra(Intent.EXTRA_EMAIL, strTo);
				intent_mail.putExtra(Intent.EXTRA_SUBJECT, "Contacto");

				intent_mail.setType("message/rfc822");

				intent_mail.setPackage("com.google.android.gm");

				startActivity(intent_mail);
			}
			catch (Exception e)
			{
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"));
				startActivity(intent);
			}

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
