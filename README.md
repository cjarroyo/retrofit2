# retrofit2
comprendiendo retrofit2<br>

fuente: https://www.androidauthority.com/retrofit-android-tutorial-906928/<br>

caso no sincronizado<br>
 public static Retrofit getRetrofitInstance(final String uri) {<br>
**cuando es local y el necesitas ingresar por https**
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();<br>
        OkHttpClient okHttpClient = builder.hostnameVerifier(new HostnameVerifier() {<br>
            @Override<br>
            public boolean verify(String s, SSLSession sslSession) {<br>
                return true;<br>
            }<br>
        }).build();<br>
<br><br>
**invocando a retrofit no sincronizado, lo mas simple**
        if (retrofit == null) {<br>
            retrofit = new retrofit2.Retrofit.Builder().<br>
                    baseUrl(uri).<br>
                    addConverterFactory(ScalarsConverterFactory.create()).<br>
                    client(okHttpClient).<br>
                    build();<br>
        }<br>
        return retrofit;<br>
    }<br>
