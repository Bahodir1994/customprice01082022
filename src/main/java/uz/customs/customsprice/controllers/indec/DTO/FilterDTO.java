package uz.customs.customsprice.controllers.indec.DTO;

import lombok.Data;

@Data
public class FilterDTO {

    private String status;
    private String appDateStart;
    private String appDateEnd;
    private String appNum;
    private String locationId;
    private String personFio;
    private String sellerOrg;
    private String orignOrg;
    private String senderOrg;
    private int page = 0  ;
    private int size = 10;
    private String selectedBar;
    private String sortedInspector;
    private String inDecStarts;
    private String inDecEnds;
    private String inDecEndDateStarts;
    private String inDecEndDateEnds;
    private String statusPay;
    private String inDecNum;
    private String termsNm;
    private String appIdForHistory;
    private String stId;
    private String index;
    private String doubleRollbackCommentTextarea;
    private String statusGetSaveRollbackType;
    private String id;

    public FilterDTO() {
    }

    public FilterDTO(String status, String appDateStart, String appDateEnd, String appNum, String locationId, String personFio, String sellerOrg, String orignOrg, String senderOrg, int page, int size, String selectedBar, String sortedInspector, String inDecStarts, String inDecEnds, String inDecEndDateStarts, String inDecEndDateEnds, String statusPay, String inDecNum, String termsNm, String appIdForHistory, String stId, String index, String doubleRollbackCommentTextarea, String statusGetSaveRollbackType, String id) {
        this.status = status;
        this.appDateStart = appDateStart;
        this.appDateEnd = appDateEnd;
        this.appNum = appNum;
        this.locationId = locationId;
        this.personFio = personFio;
        this.sellerOrg = sellerOrg;
        this.orignOrg = orignOrg;
        this.senderOrg = senderOrg;
        this.page = page;
        this.size = size;
        this.selectedBar = selectedBar;
        this.sortedInspector = sortedInspector;
        this.inDecStarts = inDecStarts;
        this.inDecEnds = inDecEnds;
        this.inDecEndDateStarts = inDecEndDateStarts;
        this.inDecEndDateEnds = inDecEndDateEnds;
        this.statusPay = statusPay;
        this.inDecNum = inDecNum;
        this.termsNm = termsNm;
        this.appIdForHistory = appIdForHistory;
        this.stId = stId;
        this.index = index;
        this.doubleRollbackCommentTextarea = doubleRollbackCommentTextarea;
        this.statusGetSaveRollbackType = statusGetSaveRollbackType;
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppDateStart() {
        return appDateStart;
    }

    public void setAppDateStart(String appDateStart) {
        this.appDateStart = appDateStart;
    }

    public String getAppDateEnd() {
        return appDateEnd;
    }

    public void setAppDateEnd(String appDateEnd) {
        this.appDateEnd = appDateEnd;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getPersonFio() {
        return personFio;
    }

    public void setPersonFio(String personFio) {
        this.personFio = personFio;
    }

    public String getSellerOrg() {
        return sellerOrg;
    }

    public void setSellerOrg(String sellerOrg) {
        this.sellerOrg = sellerOrg;
    }

    public String getOrignOrg() {
        return orignOrg;
    }

    public void setOrignOrg(String orignOrg) {
        this.orignOrg = orignOrg;
    }

    public String getSenderOrg() {
        return senderOrg;
    }

    public void setSenderOrg(String senderOrg) {
        this.senderOrg = senderOrg;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSelectedBar() {
        return selectedBar;
    }

    public void setSelectedBar(String selectedBar) {
        this.selectedBar = selectedBar;
    }

    public String getSortedInspector() {
        return sortedInspector;
    }

    public void setSortedInspector(String sortedInspector) {
        this.sortedInspector = sortedInspector;
    }

    public String getInDecStarts() {
        return inDecStarts;
    }

    public void setInDecStarts(String inDecStarts) {
        this.inDecStarts = inDecStarts;
    }

    public String getInDecEnds() {
        return inDecEnds;
    }

    public void setInDecEnds(String inDecEnds) {
        this.inDecEnds = inDecEnds;
    }

    public String getInDecEndDateStarts() {
        return inDecEndDateStarts;
    }

    public void setInDecEndDateStarts(String inDecEndDateStarts) {
        this.inDecEndDateStarts = inDecEndDateStarts;
    }

    public String getInDecEndDateEnds() {
        return inDecEndDateEnds;
    }

    public void setInDecEndDateEnds(String inDecEndDateEnds) {
        this.inDecEndDateEnds = inDecEndDateEnds;
    }

    public String getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(String statusPay) {
        this.statusPay = statusPay;
    }

    public String getInDecNum() {
        return inDecNum;
    }

    public void setInDecNum(String inDecNum) {
        this.inDecNum = inDecNum;
    }

    public String getTermsNm() {
        return termsNm;
    }

    public void setTermsNm(String termsNm) {
        this.termsNm = termsNm;
    }

    public String getAppIdForHistory() {
        return appIdForHistory;
    }

    public void setAppIdForHistory(String appIdForHistory) {
        this.appIdForHistory = appIdForHistory;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getDoubleRollbackCommentTextarea() {
        return doubleRollbackCommentTextarea;
    }

    public void setDoubleRollbackCommentTextarea(String doubleRollbackCommentTextarea) {
        this.doubleRollbackCommentTextarea = doubleRollbackCommentTextarea;
    }

    public String getStatusGetSaveRollbackType() {
        return statusGetSaveRollbackType;
    }

    public void setStatusGetSaveRollbackType(String statusGetSaveRollbackType) {
        this.statusGetSaveRollbackType = statusGetSaveRollbackType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
