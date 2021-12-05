package vip.daur.cities.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vip.daur.cities.R;
import vip.daur.cities.domain.City;

public class CityDetailsFragment extends Fragment {

    private static final String ARG_CITY = "ARG_CITY";

    public static CityDetailsFragment newInstance(City city) {
        CityDetailsFragment fragment = new CityDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    public CityDetailsFragment(){
        super(R.layout.fragment_city_details);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        City city = requireArguments().getParcelable(ARG_CITY);

        TextView cityTitle = view.findViewById(R.id.details_city_title);
        cityTitle.setText(city.getTitle());

        ImageView cityImage = view.findViewById(R.id.details_city_image);
        cityImage.setImageResource(city.getImage());

    }
}
