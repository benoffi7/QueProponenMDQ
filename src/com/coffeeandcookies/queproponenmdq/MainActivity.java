package com.coffeeandcookies.queproponenmdq;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import com.coffeeandcookies.queproponenmdq.adaptadores.AdaptadorCandidatos;
import com.coffeeandcookies.queproponenmdq.objetos.Candidato;

public class MainActivity extends Activity
{

	private GridView grid_candidatos;
	ArrayList<Candidato> candidatos = new ArrayList<Candidato>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setUI();
		setCandidatos();

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
	}

	void setCandidatos()
	{
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_ali), "Fernando Ali", "MAR",
				"http://queproponen.com.ar/buenosaires/#candidato/Fernando-Ali"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_vilma), "Vilma Baragiola", "Cambiemos",
				"http://queproponen.com.ar/buenosaires/#candidato/Vilma-Baragiola"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_arroyo), "Carlos Arroyo", "Cambiemos",
				"http://queproponen.com.ar/buenosaires/#candidato/Carlos-Arroyo"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_alicia), "Alicia Reyley", "Frente Popular",
				"http://queproponen.com.ar/buenosaires/#candidato/Alicia-Reyley"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_ale), "Alejandro Martínez", "FIT",
				"http://queproponen.com.ar/buenosaires/#candidato/-Alejandro-Martínez"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_vicini), "Gustavo Vicini", "FIT",
				"http://queproponen.com.ar/buenosaires/#candidato/Gustavo-Vicini"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_marcos), "Marcos Pascuan", "Nuevo Más",
				"http://queproponen.com.ar/buenosaires/#candidato/Marcos-Pascuan"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_maria), "Maria Lynch", "ACF",
				"http://queproponen.com.ar/buenosaires/#candidato/-Maria-Lynch"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_ricardo), "Ricardo Elorza", "ACF",
				"http://queproponen.com.ar/buenosaires/#candidato/Ricardo-Elorza-"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.ic_launcher), "Luis Sanchez", "Todos por Buenos Aires",
				"http://queproponen.com.ar/buenosaires/#candidato/Luis-Sanchez"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_alvaro), "Álvaro Fanproyen", "UNA",
				"http://queproponen.com.ar/buenosaires/#candidato/Álvaro-Fanproyen"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_lucas), "Lucas Fiorini", "UNA",
				"http://queproponen.com.ar/buenosaires/#candidato/-Lucas-Fiorini"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_pulti), "Gustavo Pulti", "Frente Marplatense",
				"http://queproponen.com.ar/buenosaires/#candidato/Gustavo-Pulti"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_adriana), "Adriana Merelas", "Patria Grande",
				"http://queproponen.com.ar/buenosaires/#candidato/Adriana-Merelas"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_pablo), "Pablo Farías", "Frente Progresista",
				"http://queproponen.com.ar/buenosaires/#candidato/Pablo-Farías"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_guille), "Guillermo Schütrumpf", "Frente Progresista",
				"http://queproponen.com.ar/buenosaires/#candidato/Guillermo-Schütrumpf"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.cand_alb), "Alberto Rodríguez", "Frente Progresista",
				"http://queproponen.com.ar/buenosaires/#candidato/Alberto-Rodríguez"));
		candidatos.add(new Candidato(getResources().getDrawable(R.drawable.ic_launcher), "Oscar Hugo De Noia", "MATJ",
				"http://queproponen.com.ar/buenosaires/#candidato/Oscar-Hugo-De-Noia"));
		

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
