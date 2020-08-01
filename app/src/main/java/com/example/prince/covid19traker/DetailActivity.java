package com.example.prince.covid19traker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class DetailActivity extends AppCompatActivity {

    private int positionCountry;
    TextView  tvCountry1, tvCases1,  tvRecovered1, tvCritical1, tvActive1, tvTodayCases1, tvTotalDeath1, tvTodayDeath1;
    SimpleArcLoader simpleArcLoader1;
    ScrollView scrollView1;
    PieChart pieChart1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        tvCountry1 = findViewById(R.id.tvCountry1);
        tvCases1 = findViewById(R.id.tvCases1);
        tvRecovered1 = findViewById(R.id.tvRecovered1);
        tvCritical1 = findViewById(R.id.tvCritical1);
        tvActive1 = findViewById(R.id.tvActive1);
        tvTodayCases1 = findViewById(R.id.tvTodayCases1);
        tvTotalDeath1 = findViewById(R.id.tvTotalDeathes1);
        tvTodayDeath1 = findViewById(R.id.tvTodayDeaths1);

        simpleArcLoader1 = findViewById(R.id.loader1);
        scrollView1 = findViewById(R.id.scrollStats1);
        pieChart1 = findViewById(R.id.piechart1);

        tvCountry1.setText(AffectedCountries.countryModelsList.get(positionCountry).getCountry());
        tvCases1.setText(AffectedCountries.countryModelsList.get(positionCountry).getCases());
        tvRecovered1.setText(AffectedCountries.countryModelsList.get(positionCountry).getRecovered());
        tvCritical1.setText(AffectedCountries.countryModelsList.get(positionCountry).getCritical());
        tvActive1.setText(AffectedCountries.countryModelsList.get(positionCountry).getActiveCases());
        tvTodayCases1.setText(AffectedCountries.countryModelsList.get(positionCountry).getTodayCases());
        tvTotalDeath1.setText(AffectedCountries.countryModelsList.get(positionCountry).getDeaths());
        tvTodayDeath1.setText(AffectedCountries.countryModelsList.get(positionCountry).getTodayDeaths());

        pieChart1.addPieSlice(new PieModel("Recovered", Integer.parseInt(tvRecovered1.getText().toString()), Color.parseColor("#66BB6A")));
        pieChart1.addPieSlice(new PieModel("Deaths", Integer.parseInt(tvTotalDeath1.getText().toString()), Color.parseColor("#EF5350")));
        pieChart1.addPieSlice(new PieModel("Active", Integer.parseInt(tvActive1.getText().toString()), Color.parseColor("#29B6F6")));
        pieChart1.startAnimation();
        simpleArcLoader1.stop();
        simpleArcLoader1.setVisibility(View.GONE);
        scrollView1.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}