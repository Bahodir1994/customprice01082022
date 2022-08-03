package uz.customs.customsprice.controllers.api.apps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;



public class IndecAPIDto {


            private String id;
            private String instime;
            private String insuser;
            private String isdeleted;
            private String updtime;
            private String upduser;
            private String app_num;
            private String app_date;
            private String customer_country_nm;
            private String customer_country;
            private String location_id;
            private String location_nm;
            private String org_name;
            private String person_addr;
            private String person_fio;
            private String person_mail;
            private String person_phone;
            private String person_pin;
            private String person_position;
            private String person_tin;
            private String seller_org;
            private String sender_country;
            private String sender_country_nm;
            private String sender_org;
            private String status;
            private String terms_nm;
            private String terms_addr;
            private String trans_exp;
            private String status_nm;
            private String inspector_id;
            private String inspector_name;
            private String comment;
            private String cmdtId;
            /****************/
            private String inDEcId;
            private String inDecInstime;
            private String inDecInsuser;
            private String inDecIsdeleted;
            private String inDecUpdtime;
            private String inDecUpduser;
            private String comment_marks;
            private String customs_payments;
            private String customs_preference;
            private String hs_code;
            private String hs_name;
            private String in_dec_basis;
            private String in_dec_date;
            private String in_dec_location;
            private String in_dec_location_nm;
            private String in_dec_num;
            private String method;
            private String method_nm;
            private String origin_country;
            private String origin_country_nm;
            private String person_id;
            private String inDecStatus;
            private String inDecStatus_nm;
            private String in_dec_end_date;
            private String IN_DEC_USR_ENDED_DATE;
            private String COMMENT_ENDED;
            private String END_ACTIV;
            private String importer_nm;
            private String importer_tin;

    public IndecAPIDto() {
    }

    public IndecAPIDto(String id, String instime, String insuser, String isdeleted, String updtime, String upduser, String app_num, String app_date, String customer_country_nm, String customer_country, String location_id, String location_nm, String org_name, String person_addr, String person_fio, String person_mail, String person_phone, String person_pin, String person_position, String person_tin, String seller_org, String sender_country, String sender_country_nm, String sender_org, String status, String terms_nm, String terms_addr, String trans_exp, String status_nm, String inspector_id, String inspector_name, String comment, String cmdtId, String inDEcId, String inDecInstime, String inDecInsuser, String inDecIsdeleted, String inDecUpdtime, String inDecUpduser, String comment_marks, String customs_payments, String customs_preference, String hs_code, String hs_name, String in_dec_basis, String in_dec_date, String in_dec_location, String in_dec_location_nm, String in_dec_num, String method, String method_nm, String origin_country, String origin_country_nm, String person_id, String inDecStatus, String inDecStatus_nm, String in_dec_end_date, String IN_DEC_USR_ENDED_DATE, String COMMENT_ENDED, String END_ACTIV, String importer_nm, String importer_tin) {
        this.id = id;
        this.instime = instime;
        this.insuser = insuser;
        this.isdeleted = isdeleted;
        this.updtime = updtime;
        this.upduser = upduser;
        this.app_num = app_num;
        this.app_date = app_date;
        this.customer_country_nm = customer_country_nm;
        this.customer_country = customer_country;
        this.location_id = location_id;
        this.location_nm = location_nm;
        this.org_name = org_name;
        this.person_addr = person_addr;
        this.person_fio = person_fio;
        this.person_mail = person_mail;
        this.person_phone = person_phone;
        this.person_pin = person_pin;
        this.person_position = person_position;
        this.person_tin = person_tin;
        this.seller_org = seller_org;
        this.sender_country = sender_country;
        this.sender_country_nm = sender_country_nm;
        this.sender_org = sender_org;
        this.status = status;
        this.terms_nm = terms_nm;
        this.terms_addr = terms_addr;
        this.trans_exp = trans_exp;
        this.status_nm = status_nm;
        this.inspector_id = inspector_id;
        this.inspector_name = inspector_name;
        this.comment = comment;
        this.cmdtId = cmdtId;
        this.inDEcId = inDEcId;
        this.inDecInstime = inDecInstime;
        this.inDecInsuser = inDecInsuser;
        this.inDecIsdeleted = inDecIsdeleted;
        this.inDecUpdtime = inDecUpdtime;
        this.inDecUpduser = inDecUpduser;
        this.comment_marks = comment_marks;
        this.customs_payments = customs_payments;
        this.customs_preference = customs_preference;
        this.hs_code = hs_code;
        this.hs_name = hs_name;
        this.in_dec_basis = in_dec_basis;
        this.in_dec_date = in_dec_date;
        this.in_dec_location = in_dec_location;
        this.in_dec_location_nm = in_dec_location_nm;
        this.in_dec_num = in_dec_num;
        this.method = method;
        this.method_nm = method_nm;
        this.origin_country = origin_country;
        this.origin_country_nm = origin_country_nm;
        this.person_id = person_id;
        this.inDecStatus = inDecStatus;
        this.inDecStatus_nm = inDecStatus_nm;
        this.in_dec_end_date = in_dec_end_date;
        this.IN_DEC_USR_ENDED_DATE = IN_DEC_USR_ENDED_DATE;
        this.COMMENT_ENDED = COMMENT_ENDED;
        this.END_ACTIV = END_ACTIV;
        this.importer_nm = importer_nm;
        this.importer_tin = importer_tin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstime() {
        return instime;
    }

    public void setInstime(String instime) {
        this.instime = instime;
    }

    public String getInsuser() {
        return insuser;
    }

    public void setInsuser(String insuser) {
        this.insuser = insuser;
    }

    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getUpdtime() {
        return updtime;
    }

    public void setUpdtime(String updtime) {
        this.updtime = updtime;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getApp_num() {
        return app_num;
    }

    public void setApp_num(String app_num) {
        this.app_num = app_num;
    }

    public String getApp_date() {
        return app_date;
    }

    public void setApp_date(String app_date) {
        this.app_date = app_date;
    }

    public String getCustomer_country_nm() {
        return customer_country_nm;
    }

    public void setCustomer_country_nm(String customer_country_nm) {
        this.customer_country_nm = customer_country_nm;
    }

    public String getCustomer_country() {
        return customer_country;
    }

    public void setCustomer_country(String customer_country) {
        this.customer_country = customer_country;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getLocation_nm() {
        return location_nm;
    }

    public void setLocation_nm(String location_nm) {
        this.location_nm = location_nm;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getPerson_addr() {
        return person_addr;
    }

    public void setPerson_addr(String person_addr) {
        this.person_addr = person_addr;
    }

    public String getPerson_fio() {
        return person_fio;
    }

    public void setPerson_fio(String person_fio) {
        this.person_fio = person_fio;
    }

    public String getPerson_mail() {
        return person_mail;
    }

    public void setPerson_mail(String person_mail) {
        this.person_mail = person_mail;
    }

    public String getPerson_phone() {
        return person_phone;
    }

    public void setPerson_phone(String person_phone) {
        this.person_phone = person_phone;
    }

    public String getPerson_pin() {
        return person_pin;
    }

    public void setPerson_pin(String person_pin) {
        this.person_pin = person_pin;
    }

    public String getPerson_position() {
        return person_position;
    }

    public void setPerson_position(String person_position) {
        this.person_position = person_position;
    }

    public String getPerson_tin() {
        return person_tin;
    }

    public void setPerson_tin(String person_tin) {
        this.person_tin = person_tin;
    }

    public String getSeller_org() {
        return seller_org;
    }

    public void setSeller_org(String seller_org) {
        this.seller_org = seller_org;
    }

    public String getSender_country() {
        return sender_country;
    }

    public void setSender_country(String sender_country) {
        this.sender_country = sender_country;
    }

    public String getSender_country_nm() {
        return sender_country_nm;
    }

    public void setSender_country_nm(String sender_country_nm) {
        this.sender_country_nm = sender_country_nm;
    }

    public String getSender_org() {
        return sender_org;
    }

    public void setSender_org(String sender_org) {
        this.sender_org = sender_org;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTerms_nm() {
        return terms_nm;
    }

    public void setTerms_nm(String terms_nm) {
        this.terms_nm = terms_nm;
    }

    public String getTerms_addr() {
        return terms_addr;
    }

    public void setTerms_addr(String terms_addr) {
        this.terms_addr = terms_addr;
    }

    public String getTrans_exp() {
        return trans_exp;
    }

    public void setTrans_exp(String trans_exp) {
        this.trans_exp = trans_exp;
    }

    public String getStatus_nm() {
        return status_nm;
    }

    public void setStatus_nm(String status_nm) {
        this.status_nm = status_nm;
    }

    public String getInspector_id() {
        return inspector_id;
    }

    public void setInspector_id(String inspector_id) {
        this.inspector_id = inspector_id;
    }

    public String getInspector_name() {
        return inspector_name;
    }

    public void setInspector_name(String inspector_name) {
        this.inspector_name = inspector_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCmdtId() {
        return cmdtId;
    }

    public void setCmdtId(String cmdtId) {
        this.cmdtId = cmdtId;
    }

    public String getInDEcId() {
        return inDEcId;
    }

    public void setInDEcId(String inDEcId) {
        this.inDEcId = inDEcId;
    }

    public String getInDecInstime() {
        return inDecInstime;
    }

    public void setInDecInstime(String inDecInstime) {
        this.inDecInstime = inDecInstime;
    }

    public String getInDecInsuser() {
        return inDecInsuser;
    }

    public void setInDecInsuser(String inDecInsuser) {
        this.inDecInsuser = inDecInsuser;
    }

    public String getInDecIsdeleted() {
        return inDecIsdeleted;
    }

    public void setInDecIsdeleted(String inDecIsdeleted) {
        this.inDecIsdeleted = inDecIsdeleted;
    }

    public String getInDecUpdtime() {
        return inDecUpdtime;
    }

    public void setInDecUpdtime(String inDecUpdtime) {
        this.inDecUpdtime = inDecUpdtime;
    }

    public String getInDecUpduser() {
        return inDecUpduser;
    }

    public void setInDecUpduser(String inDecUpduser) {
        this.inDecUpduser = inDecUpduser;
    }

    public String getComment_marks() {
        return comment_marks;
    }

    public void setComment_marks(String comment_marks) {
        this.comment_marks = comment_marks;
    }

    public String getCustoms_payments() {
        return customs_payments;
    }

    public void setCustoms_payments(String customs_payments) {
        this.customs_payments = customs_payments;
    }

    public String getCustoms_preference() {
        return customs_preference;
    }

    public void setCustoms_preference(String customs_preference) {
        this.customs_preference = customs_preference;
    }

    public String getHs_code() {
        return hs_code;
    }

    public void setHs_code(String hs_code) {
        this.hs_code = hs_code;
    }

    public String getHs_name() {
        return hs_name;
    }

    public void setHs_name(String hs_name) {
        this.hs_name = hs_name;
    }

    public String getIn_dec_basis() {
        return in_dec_basis;
    }

    public void setIn_dec_basis(String in_dec_basis) {
        this.in_dec_basis = in_dec_basis;
    }

    public String getIn_dec_date() {
        return in_dec_date;
    }

    public void setIn_dec_date(String in_dec_date) {
        this.in_dec_date = in_dec_date;
    }

    public String getIn_dec_location() {
        return in_dec_location;
    }

    public void setIn_dec_location(String in_dec_location) {
        this.in_dec_location = in_dec_location;
    }

    public String getIn_dec_location_nm() {
        return in_dec_location_nm;
    }

    public void setIn_dec_location_nm(String in_dec_location_nm) {
        this.in_dec_location_nm = in_dec_location_nm;
    }

    public String getIn_dec_num() {
        return in_dec_num;
    }

    public void setIn_dec_num(String in_dec_num) {
        this.in_dec_num = in_dec_num;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod_nm() {
        return method_nm;
    }

    public void setMethod_nm(String method_nm) {
        this.method_nm = method_nm;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getOrigin_country_nm() {
        return origin_country_nm;
    }

    public void setOrigin_country_nm(String origin_country_nm) {
        this.origin_country_nm = origin_country_nm;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getInDecStatus() {
        return inDecStatus;
    }

    public void setInDecStatus(String inDecStatus) {
        this.inDecStatus = inDecStatus;
    }

    public String getInDecStatus_nm() {
        return inDecStatus_nm;
    }

    public void setInDecStatus_nm(String inDecStatus_nm) {
        this.inDecStatus_nm = inDecStatus_nm;
    }

    public String getIn_dec_end_date() {
        return in_dec_end_date;
    }

    public void setIn_dec_end_date(String in_dec_end_date) {
        this.in_dec_end_date = in_dec_end_date;
    }

    public String getIN_DEC_USR_ENDED_DATE() {
        return IN_DEC_USR_ENDED_DATE;
    }

    public void setIN_DEC_USR_ENDED_DATE(String IN_DEC_USR_ENDED_DATE) {
        this.IN_DEC_USR_ENDED_DATE = IN_DEC_USR_ENDED_DATE;
    }

    public String getCOMMENT_ENDED() {
        return COMMENT_ENDED;
    }

    public void setCOMMENT_ENDED(String COMMENT_ENDED) {
        this.COMMENT_ENDED = COMMENT_ENDED;
    }

    public String getEND_ACTIV() {
        return END_ACTIV;
    }

    public void setEND_ACTIV(String END_ACTIV) {
        this.END_ACTIV = END_ACTIV;
    }

    public String getImporter_nm() {
        return importer_nm;
    }

    public void setImporter_nm(String importer_nm) {
        this.importer_nm = importer_nm;
    }

    public String getImporter_tin() {
        return importer_tin;
    }

    public void setImporter_tin(String importer_tin) {
        this.importer_tin = importer_tin;
    }


}
