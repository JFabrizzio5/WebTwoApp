package com.example.dkfood;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    private WebSettings myWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = findViewById(R.id.web1);
        myWebSettings = myWebView.getSettings();
        myWebSettings.setJavaScriptEnabled(true);
        myWebSettings.setDomStorageEnabled(true);

        //myWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //Descomentar esta linea en caso de querer usar el cache
        myWebView.clearCache(true); //Activar esta linea para limpiar el cache de la app

        myWebSettings.setDatabaseEnabled(true);
        myWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        //Configurar el modo de visualización de escritorio
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3";
        myWebSettings.setUserAgentString(userAgent);

        //Carga Url
        myWebView.loadUrl(""); //Cambiar por URL local o por la URL del servidor en el cual se esta hosteando
    


        myWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {

        //Verificar si se puede retroceder en la historia del WebView
        if (myWebView.canGoBack()) {
            myWebView.goBack(); // Retroceder a la página anterior
            myWebView.clearCache(true); //Limpia el cache al ir hacia atras en la app para evitar bugs si el servidor local lo actualizas en atomatico
        } else {
            super.onBackPressed(); // Si no hay historial, llamar al método por defecto
        }
    }
}
