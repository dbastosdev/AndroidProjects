package api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import model.USDBRL;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MoneyService {
    // Requisição de trecho complemento da URL base

    @GET("2021/9/16/")
    Call<USDBRL> callMoney();

    // Poderia ser criados outros médotos e interfaces para chamar outras informações da API

}


