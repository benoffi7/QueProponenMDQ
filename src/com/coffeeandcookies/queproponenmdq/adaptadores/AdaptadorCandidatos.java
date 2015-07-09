package com.coffeeandcookies.queproponenmdq.adaptadores;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coffeeandcookies.queproponenmdq.R;
import com.coffeeandcookies.queproponenmdq.WebviewActivity;
import com.coffeeandcookies.queproponenmdq.objetos.Candidato;

public class AdaptadorCandidatos extends BaseAdapter
{
	private ArrayList<Candidato> candidatos;

	private LayoutInflater mInflater;

	public AdaptadorCandidatos(Context context, ArrayList<Candidato> Candidatos)
	{
		candidatos = Candidatos;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount()
	{
		return candidatos.size();
	}

	public Candidato getItem(int position)
	{
		return candidatos.get(position);
	}

	public long getItemId(int position)
	{
		return position;
	}

	static class ViewHolder
	{
		TextView text_nombre;
		TextView text_partido;
		ImageView image_candidato;
		RelativeLayout ll_row;
	}

	public View getView(final int position, View convertView, ViewGroup parent)
	{
		final Candidato item = getItem(position);
		ViewHolder holder;
		if (convertView == null)
		{
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.row_candidato, parent, false);
			holder.text_nombre = (TextView) convertView.findViewById(R.id.text_nombre);
			holder.text_partido = (TextView) convertView.findViewById(R.id.text_partido);
			holder.image_candidato = (ImageView) convertView.findViewById(R.id.image_candidato);
			holder.ll_row = (RelativeLayout) convertView.findViewById(R.id.ll_row);

			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		holder.text_nombre.setText(item.getNombre());
		holder.text_partido.setText(item.getPartido());
		holder.image_candidato.setImageDrawable(getItem(position).getImagen_perfil());
		holder.ll_row.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				if (isOnline())
				{
					Intent intent = new Intent(mInflater.getContext(), WebviewActivity.class);
					intent.putExtra("URL", getItem(position).getURL());
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mInflater.getContext().startActivity(intent);	
				}
				else
				{
					Toast.makeText(mInflater.getContext(), "No dispone de una conexión para realizar esta consulta", Toast.LENGTH_SHORT).show();
				}
				

			}
		});
		return convertView;

	}

	public boolean isOnline()
	{
		ConnectivityManager cm = (ConnectivityManager) mInflater.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		return netInfo != null && netInfo.isConnectedOrConnecting();
	}	
}