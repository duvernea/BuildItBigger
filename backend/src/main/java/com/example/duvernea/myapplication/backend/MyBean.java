package com.example.duvernea.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String setup;
    private String punchline;

    public String getSetup() {
        return setup;
    }
    public String getPunchline()
    {
        return punchline;
    }

    public void setSetup(String data) {
        setup = data;
    }
    public void setPunchline(String data) {punchline = data;}
}