/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novo.encryption_aes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
//import org.apache.log4j.MDC;

/**
 * REPRESENTA UN OBJETO DE REQUEST DE SERVICIO DONDE className: es el nombre de la clase Model Object que necesita el
 * servicio como entrada bean: es un String JSON con la representacion del Model Object del tipo indicado en className
 * logAcceso: es un String JSON con la representacion del Objeto LogAccesoTO que se implementa para las auditorias
 *
 * @author JBRAVO
 */
public class RequestTO {

    private final static String SID = "sid";
    private final static String USERNAME = "username";
    private String idOperation;
    private String className;
    private String bean;
    private String logAcceso;
    private String token;
//    private LogAccesoTO logAccesoObject;
    private String pais;
    private String country;
    private String keyId;
    private String tipoServicio;
    private String signo;
    private Map<String, String> filters;

    public RequestTO() {
    }

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    public String getLogAcceso() {
        return logAcceso;
    }

    public void setLogAcceso(String logAcceso) {
        this.logAcceso = logAcceso;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, String> filters) {
        this.filters = filters;
    }

    

}
