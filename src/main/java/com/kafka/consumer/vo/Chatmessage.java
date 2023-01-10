package com.kafka.consumer.vo;

import java.util.ArrayList;

import java.util.HashMap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Chatmessage {

    private String sender;
    private String context;
}
 