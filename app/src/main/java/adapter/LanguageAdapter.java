package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.List;

import model.Language;

public class LanguageAdapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Language> listLanguage;
    private int positionSelected = -1;

    // Constructor
    public LanguageAdapter(Context context, int idLayout, List<Language> listLanguage) {
        this.context = context;
        this.idLayout = idLayout;
        this.listLanguage = listLanguage;
    }

    @Override
    public int getCount() {
        if(listLanguage.size() != 0 && !listLanguage.isEmpty()) {
            return listLanguage.size();
        }

        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }

        // TextView --> UI
        TextView tvLanguageName = (TextView) view.findViewById(R.id.tvLanguageName);
        ImageView imgView = view.findViewById(R.id.logo);
        final LinearLayout linearLayout = view.findViewById(R.id.idLinearLayout);
        final Language language = listLanguage.get(i);

        if(listLanguage != null && !listLanguage.isEmpty()) {
            // TextView
            tvLanguageName.setText(language.getName());
            int idLanguage = language.getId();
            switch (idLanguage) {
                case 1:
                    imgView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 2:
                    imgView.setImageResource(R.drawable.do_choi_dang_mo_hinh);
                    break;
                case 3:
                    imgView.setImageResource(R.drawable.ga_bo_toi);
                    break;
                case 4:
                    imgView.setImageResource(R.drawable.lanh_dao_gian_don);
                    break;
                case 5:
                    imgView.setImageResource(R.drawable.xa_can_cau);
                    break;
                case 6:
                    imgView.setImageResource(R.drawable.hieu_long_con_tre);
                    break;
                default:
                    break;
            }
        }

        // Click event
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, language.getName(), Toast.LENGTH_SHORT).show();
                positionSelected = i;
                notifyDataSetChanged();
            }
        });

        if(positionSelected == i) {
            linearLayout.setBackgroundColor(Color.BLUE);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }

        return view;
    }
}
