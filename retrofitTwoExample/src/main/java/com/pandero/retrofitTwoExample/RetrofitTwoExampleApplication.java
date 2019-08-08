package com.pandero.retrofitTwoExample;

import com.pandero.retrofitTwoExample.retrofit.GetData;
import com.pandero.retrofitTwoExample.retrofit.RetroUsers;
import com.pandero.retrofitTwoExample.retrofit.RetrofitClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class RetrofitTwoExampleApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RetrofitTwoExampleApplication.class, args);

        //Create a handler for the RetrofitInstance interface//
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
        Call<List<RetroUsers>> call = service.getAllUsers();

        //Execute the request asynchronously//
        List<RetroUsers> users = call.execute().body();

        for (RetroUsers user : users) {
            System.out.println(user.getUser());

        }


    }

}
