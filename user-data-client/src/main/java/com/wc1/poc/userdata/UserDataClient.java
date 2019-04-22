package com.wc1.poc.userdata;

import com.wc1.poc.userdata.dto.UserDataDto;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@PropertySource(value = "file:application.properties", ignoreResourceNotFound = true)
@Component
public class UserDataClient {
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${user.data.url:http://localhost:8080}")
    private String url;

    public UserDataDto getUser(int id) {
        ResponseEntity<String> response =
                restTemplate.getForEntity(String.format("%s%s%s", url, "/user/", id), String.class);
        JSONObject jsonObject = new JSONObject(response.getBody());

        return new UserDataDto((String)jsonObject.get("firstName"), (String)jsonObject.get("lastName"));
    }

}
