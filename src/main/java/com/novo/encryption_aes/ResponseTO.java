
    
package com.novo.encryption_aes;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author rcasañas
 * @version 1.0
 * @since 14-nov-2012
 */

@XmlRootElement(name = "ResponseTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class ResponseTO  {

    private String rc;
    private String msg;
    private String timeStamp;
    private String className;
    private String bean;
    private String logAcceso;
    private String token;
    private String idOperation;
    private String keyUpdate;
    private String validacionFechaExp;
    private Object listaAux; 
    private String transactionDate;

    public ResponseTO() {
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
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

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public String getKeyUpdate() {
        return keyUpdate;
    }

    public void setKeyUpdate(String keyUpdate) {
        this.keyUpdate = keyUpdate;
    }

    public String getValidacionFechaExp() {
        return validacionFechaExp;
    }

    public void setValidacionFechaExp(String validacionFechaExp) {
        this.validacionFechaExp = validacionFechaExp;
    }

    public Object getListaAux() {
        return listaAux;
    }

    public void setListaAux(Object listaAux) {
        this.listaAux = listaAux;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
    
   

   

}
