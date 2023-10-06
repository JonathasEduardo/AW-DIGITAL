package com.awdigital.awDigital.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.io.Serializable;
import java.time.LocalDateTime;


public class StandardError implements Serializable {

    private static final long SerialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy - H:mm:ss")
    private LocalDateTime timestemp;
    private Integer status;
    private String erro;
    private String path;

    public StandardError(LocalDateTime timestemp, Integer status, String erro, String path) {
        this.timestemp = timestemp;
        this.status = status;
        this.erro = erro;
        this.path = path;
    }

    public StandardError() {
    }

    public LocalDateTime getTimestemp() {
        return timestemp;
    }

    public void setTimestemp(LocalDateTime timestemp) {
        this.timestemp = timestemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
