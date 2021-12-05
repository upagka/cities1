package vip.daur.cities.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import vip.daur.cities.R;
import vip.daur.cities.domain.City;
import vip.daur.cities.domain.InMemoryCitiesRepository;
import vip.daur.cities.ui.detail.CityDetailsActivity;
import vip.daur.cities.ui.detail.CityDetailsFragment;

public class CitiesListFragment extends Fragment implements CitiesListView {

    private LinearLayout citiesContainer;

    private CitiesListPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new CitiesListPresenter(this, new InMemoryCitiesRepository());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        citiesContainer = view.findViewById(R.id.cities_container);

        presenter.refresh();
    }

    @Override
    public void showCities(List<City> cities) {

        for (City city : cities) {
            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_city, citiesContainer, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(requireContext(), CityDetailsActivity.class);
                    intent.putExtra(CityDetailsActivity.EXTRA_CITY, city);
                    startActivity(intent);

                }
            });

            TextView cityTitle = itemView.findViewById(R.id.city_title);
            cityTitle.setText(city.getTitle());

            citiesContainer.addView(itemView);
        }

    }
}
