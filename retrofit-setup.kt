// Setup Retrofit in your project

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSetup {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                .baseUrl("https://example.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }
}