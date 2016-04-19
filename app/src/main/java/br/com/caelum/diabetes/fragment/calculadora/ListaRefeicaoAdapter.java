package br.com.caelum.diabetes.fragment.calculadora;

import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.caelum.diabetes.R;
import br.com.caelum.diabetes.extras.PickerDialog;
import br.com.caelum.diabetes.model.Refeicao;

public class ListaRefeicaoAdapter extends BaseAdapter{
	private List<Refeicao> refeicoes;
	private Activity activity;

	public ListaRefeicaoAdapter(List<Refeicao> refeicoes, Activity activity) {
		this.refeicoes = refeicoes;
		this.activity = activity;
	}
	
	@Override
	public int getCount() {
		return refeicoes.size();
	}
	
	@Override
	public Object getItem(int pos) {
		return refeicoes.get(pos);
	}
	
	@Override
	public long getItemId(int pos) {
		return refeicoes.get(pos).getId();
	}
	
	@Override
	public View getView(int pos, View view, ViewGroup viewGroup) {
		LayoutInflater inflater = activity.getLayoutInflater();
		View item = inflater.inflate(R.layout.item_refeicao, null);
		
		Refeicao refeicao = refeicoes.get(pos);
		
		TextView campoTipoRefeicao = (TextView) item.findViewById(R.id.refeicao_tipo_refeicao);
		campoTipoRefeicao.setText(refeicao.getTipoRefeicao().getText());
		TextView campoTotalCho= (TextView) item.findViewById(R.id.refeicao_total_cho);
		campoTotalCho.setText(refeicao.getTotalCHO()+"g CHO");
		
		TextView campoDia = (TextView) item.findViewById(R.id.refeicao_dia);
		Calendar data = refeicao.getData();
		campoDia.setText(PickerDialog.getParseDate(data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH), data.get(Calendar.YEAR)));

        ImageView imagem = (ImageView) item.findViewById(R.id.refeicao_imagem);
        switch (refeicao.getTipoRefeicao()) {
            case CAFE_DA_MANHA:
                imagem.setImageResource(R.drawable.refeicao_cafe_da_manha);
                break;
            case LANCHE_DA_MANHA:
                imagem.setImageResource(R.drawable.refeicao_lanche_da_manha);
                break;
            case ALMOCO:
                imagem.setImageResource(R.drawable.refeicao_almoco);
                break;
            case LANCHE_DA_TARDE:
                imagem.setImageResource(R.drawable.refeicao_lanche_da_tarde);
                break;
            case JANTAR:
                imagem.setImageResource(R.drawable.refeicao_jantar);
                break;
            case CEIA:
                imagem.setImageResource(R.drawable.refeicao_ceia);
                break;
        }

        return item;
	}
}
