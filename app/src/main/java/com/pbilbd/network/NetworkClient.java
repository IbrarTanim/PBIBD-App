package com.pbilbd.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pbilbd.constants.BaseConstants;

import java.security.SecureRandom;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    //use volatile to make all the write before using instance variable
    private static volatile Retrofit retrofit = null;
    private static NetworkInterface networkInterface;

    //Gson builder to convert json
    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    //check unsafe client
    public static OkHttpClient.Builder getUnsafeOkHttpClient() {

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //create singleton instance
    public static Retrofit getClient() {

        if (retrofit == null){

            synchronized (NetworkClient.class){

                if (retrofit == null){

                    retrofit = new Retrofit.Builder()
                            .baseUrl(BaseConstants.DEV_BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(getUnsafeOkHttpClient().build())
                            .build();

                }

            }

        }

        return retrofit;
    }


    //get Retrofit service
    public static NetworkInterface getNetworkService(){
        return networkInterface = NetworkClient.getClient().create(NetworkInterface.class);
    }
}
