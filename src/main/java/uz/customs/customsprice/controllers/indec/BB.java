package uz.customs.customsprice.controllers.indec;

import java.util.List;

public class BB {
    private List<ResponseObject> listObject;

    public BB() {
    }

    public BB(List<ResponseObject> listObject) {

        this.listObject = listObject;
    }

    public List<ResponseObject> getListObject() {
        return listObject;
    }

    public void setListObject(List<ResponseObject> listObject) {
        this.listObject = listObject;
    }
}
