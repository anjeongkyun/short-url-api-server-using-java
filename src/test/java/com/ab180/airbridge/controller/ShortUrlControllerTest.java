package com.ab180.airbridge.controller;

import com.ab180.airbridge.dto.ShortUrlRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShortUrlControllerTest {

    public MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void ShortUrl_생성_POST_테스트() throws Exception {
        //given
        ShortUrlRequestDto shortUrlRequestDto =
                ShortUrlRequestDto
                        .builder()
                        .url("https://www.airbridge.io")
                        .build();

        String json = new ObjectMapper().writeValueAsString(shortUrlRequestDto);
        System.out.println(json);

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/short-links")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void ShortUrl_조회_GET_테스트() throws Exception {

        String urlStr =  "https://airbridge.io";

        mockMvc.perform(get("/short-links/Spk")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(handler().handlerType(ShortUrlController.class))
                .andDo(MockMvcResultHandlers.print());

    }
}