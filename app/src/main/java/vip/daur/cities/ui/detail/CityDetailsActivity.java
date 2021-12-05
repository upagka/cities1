package vip.daur.cities.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import vip.daur.cities.R;
import vip.daur.cities.domain.City;

public class CityDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_CITY = "EXTRA_CITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

        FragmentManager fm = getSupportFragmentManager();

        City city = getIntent().getParcelableExtra(EXTRA_CITY);

        fm.beginTransaction()
                .replace(R.id.container, CityDetailsFragment.newInstance(city))
                .commit();
    }
}