package io.github.kalinchan.javaee.arquillian;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

public class PhraseBuilder {
    
    private Map<String, String> templates;

    public String buildPhrase(String id, Object... args) {
        return MessageFormat.format(templates.get(id), args);
    }

    @PostConstruct
    public void init(){
        templates = new HashMap<String, String>();
        templates.put("hello", "Hello, {0}!");
    }
}