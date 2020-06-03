package org.jby.studyenglish;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import androidx.fragment.app.Fragment;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.EdgeDetail;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

public class LevelFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_level, container, false);

        DecoView arcView = (DecoView)rootView.findViewById(R.id.dynamicArcView);

        // Create background track
        arcView.addSeries(new SeriesItem.Builder(Color.argb(255, 218, 218, 218))
                .setRange(0, 100, 100)
                .setInitialVisibility(true)
                .setLineWidth(32f)
                .build());
        //Create data series track
        SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(255, 64, 196, 0))
                .setRange(0, 100, 0)
                .setInitialVisibility(false)
                .setLineWidth(32f)
                .addEdgeDetail(new EdgeDetail(EdgeDetail.EdgeType.EDGE_OUTER, Color.parseColor("#22000000"), 0.4f))
                .setSeriesLabel(new SeriesLabel.Builder("Percent %.0f%%").build())
                .setInterpolator(new OvershootInterpolator())
                .setShowPointWhenEmpty(false)
                .setCapRounded(false)
                .setInset(new PointF(32f, 32f))
                .setDrawAsPoint(false)
                .setSpinClockwise(true)
                .setSpinDuration(6000)
                .setChartStyle(SeriesItem.ChartStyle.STYLE_DONUT)
                .build();
        int series1Index = arcView.addSeries(seriesItem1);

        //데이터 계열에 애니메이션을 적용하는 이벤트 추가
        arcView.addEvent(new DecoEvent.Builder(DecoEvent.EventType.EVENT_SHOW, true)
                .setDelay(1000)
                .setDuration(1000)
                .build());
        arcView.addEvent(new DecoEvent.Builder(25).setIndex(series1Index).setDelay(3000).build());
        arcView.addEvent(new DecoEvent.Builder(50).setIndex(series1Index).setDelay(6000).setColor(Color.parseColor("#FFB5B2FF")).build());
        arcView.addEvent(new DecoEvent.Builder(100).setIndex(series1Index).setDelay(9000).setColor(Color.parseColor("#FFFAED7D")).build());

        arcView.configureAngles(360, 0);
        return rootView;
    }
}
