package com.petshopapp.controllers;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseRest {
    protected Map<String, String> getStatus(String message) {
        Map<String, String> map = new HashMap<>();
        map.put("mensagem", message);
        return map;
    }
}
