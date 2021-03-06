package cosamv.example.dojo.mapapplication03;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //　シドニーに緯度経度を設定して、そこにマーカーを設置
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //日本のどこかに緯度経度を設定して、そこにマーカーを設置
        LatLng Hokkaido = new LatLng(43.793646, 146.744130);
        mMap.addMarker(new MarkerOptions().position(Hokkaido).title("色丹島"));
        //北米のどこかの緯度経度を設定して、そこにマーカーを設置
        LatLng CathedralRock = new LatLng(34.819977, -111.793061);
        mMap.addMarker(new MarkerOptions().position(CathedralRock).title("CathedralRock"));
        //カメラの位置とズーム設定
        LatLng center = new LatLng(10.582792, -162.405480);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center,2));
//        //線を引く
//        PolylineOptions line = new PolylineOptions()
//                //色、太さ、測地戦
//                .color(Color.RED)
//                .width(10)
//                .geodesic(true);
//        line.add(Hokkaido);
//        line.add(CathedralRock);
//
//        mMap.addPolyline(line);

//        //３地点を結ぶ半透明を描く
//        PolygonOptions options = new PolygonOptions()
//                .geodesic(true);
//        options.add(sydney,Hokkaido,CathedralRock);
//
//        //線色
//        options.strokeColor(Color.argb(0,00,20,70));
//        //線幅
//        options.strokeWidth(5);
//        //塗り色
//        options.fillColor(Color.argb(100,20,70,50));
//        mMap.addPolygon(options);

        //３地点を中心とする半透明の円を描く(３つの円が重なるように大きさを調整)

        CircleOptions circle = new CircleOptions();
        circle.center(sydney);
        circle.radius(10000);


        
        mMap.addCircle(circle);






    }
}
