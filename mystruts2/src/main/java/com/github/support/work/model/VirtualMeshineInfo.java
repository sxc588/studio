package com.github.support.work.model;

public class VirtualMeshineInfo {
    private String instance;

    private String ip;

    private String pass;

    private String pass2;

    private String stage;

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance == null ? null : instance.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2 == null ? null : pass2.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }
}