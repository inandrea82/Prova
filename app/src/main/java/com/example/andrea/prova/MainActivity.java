package com.example.andrea.prova;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.andrea.prova.RPCParser.Parser;
import com.example.andrea.prova.marprotocol.autenticazione.Accedi;
import com.example.andrea.prova.marprotocol.autenticazione.AccediRequest;
import com.example.andrea.prova.marprotocol.autenticazione.AccediResponse;
import com.example.andrea.prova.marprotocol.palina.Previsioni;
import com.example.andrea.prova.marprotocol.palina.PrevisioniRequest;
import com.example.andrea.prova.marprotocol.palina.PrevisioniResponse;


public class MainActivity extends Activity {

    ListView listView;
    TextView textView;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView);
        String android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter =
//            new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
            new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);



        final RequestQueue queue = Volley.newRequestQueue(this);
        final Accedi aa = Accedi.CreateAccedi(
                new AccediRequest("GYJGzRGzatAJW5HMsOij_s25_FvloLim", android_id),
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                },
                new Response.Listener<AccediResponse>() {
                    @Override
                    public void onResponse(AccediResponse accediResponse) {
                        final AccediResponse r = accediResponse;
                        token = r.getToken();
                        textView.setText(token);
                        final Previsioni pp = new Previsioni(
                                new PrevisioniRequest(token, 73681, "it"),
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError volleyError) {

                                    }
                                },
                                new Response.Listener<PrevisioniResponse>() {
                                    @Override
                                    public void onResponse(PrevisioniResponse previsioniResponse) {

                                    }
                                }
                        );
                        queue.add(pp);
                    }
                });

        queue.add(aa);
        try {
            Parser p = new Parser();
        }
        catch(Exception e)
        {}

        //String tok = aa.Send().getToken();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
