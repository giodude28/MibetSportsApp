package io.giodude.mibet.Model;

public class CasinoModel {

    String cname;
    String cdesc;
    Integer cimage;

    public CasinoModel(String cname, String cdesc, Integer cimage) {
        this.cname = cname;
        this.cdesc = cdesc;
        this.cimage = cimage;
    }

    public String getCname() {
        return cname;
    }

    public String getCdesc() {
        return cdesc;
    }

    public Integer getCimage() {
        return cimage;
    }
}
