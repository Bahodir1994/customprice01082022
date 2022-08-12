package uz.customs.customsprice.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "FOR_HTML_ROLLBACK_TEMPLATE")
public class ForHtmlRollbackTemplate {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "title", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title;

    @Column(name = "title2", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title2;

    @Column(name = "title3", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title3;

    @Column(name = "title4", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title4;

    @Column(name = "title5", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title5;

    @Column(name = "title6", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title6;

    @Column(name = "title7", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title7;

    @Column(name = "title8", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title8;

    @Column(name = "title9", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title9;

    @Column(name = "title10", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title10;

    @Column(name = "title11", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title11;

    @Column(name = "title12", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title12;

    @Column(name = "title13", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title13;

    @Column(name = "title14", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title14;

    @Column(name = "title15", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title15;

    @Column(name = "title16", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title16;

    @Column(name = "title17", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title17;

    @Column(name = "title18", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title18;

    @Column(name = "title19", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title19;

    @Column(name = "title20", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title20;

    @Column(name = "title21", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title21;

    public ForHtmlRollbackTemplate() {
    }

    public ForHtmlRollbackTemplate(String id, String title, String title2, String title3, String title4, String title5, String title6, String title7, String title8, String title9, String title10, String title11, String title12, String title13, String title14, String title15, String title16, String title17, String title18, String title19, String title20, String title21) {
        this.id = id;
        this.title = title;
        this.title2 = title2;
        this.title3 = title3;
        this.title4 = title4;
        this.title5 = title5;
        this.title6 = title6;
        this.title7 = title7;
        this.title8 = title8;
        this.title9 = title9;
        this.title10 = title10;
        this.title11 = title11;
        this.title12 = title12;
        this.title13 = title13;
        this.title14 = title14;
        this.title15 = title15;
        this.title16 = title16;
        this.title17 = title17;
        this.title18 = title18;
        this.title19 = title19;
        this.title20 = title20;
        this.title21 = title21;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getTitle4() {
        return title4;
    }

    public void setTitle4(String title4) {
        this.title4 = title4;
    }

    public String getTitle5() {
        return title5;
    }

    public void setTitle5(String title5) {
        this.title5 = title5;
    }

    public String getTitle6() {
        return title6;
    }

    public void setTitle6(String title6) {
        this.title6 = title6;
    }

    public String getTitle7() {
        return title7;
    }

    public void setTitle7(String title7) {
        this.title7 = title7;
    }

    public String getTitle8() {
        return title8;
    }

    public void setTitle8(String title8) {
        this.title8 = title8;
    }

    public String getTitle9() {
        return title9;
    }

    public void setTitle9(String title9) {
        this.title9 = title9;
    }

    public String getTitle10() {
        return title10;
    }

    public void setTitle10(String title10) {
        this.title10 = title10;
    }

    public String getTitle11() {
        return title11;
    }

    public void setTitle11(String title11) {
        this.title11 = title11;
    }

    public String getTitle12() {
        return title12;
    }

    public void setTitle12(String title12) {
        this.title12 = title12;
    }

    public String getTitle13() {
        return title13;
    }

    public void setTitle13(String title13) {
        this.title13 = title13;
    }

    public String getTitle14() {
        return title14;
    }

    public void setTitle14(String title14) {
        this.title14 = title14;
    }

    public String getTitle15() {
        return title15;
    }

    public void setTitle15(String title15) {
        this.title15 = title15;
    }

    public String getTitle16() {
        return title16;
    }

    public void setTitle16(String title16) {
        this.title16 = title16;
    }

    public String getTitle17() {
        return title17;
    }

    public void setTitle17(String title17) {
        this.title17 = title17;
    }

    public String getTitle18() {
        return title18;
    }

    public void setTitle18(String title18) {
        this.title18 = title18;
    }

    public String getTitle19() {
        return title19;
    }

    public void setTitle19(String title19) {
        this.title19 = title19;
    }

    public String getTitle20() {
        return title20;
    }

    public void setTitle20(String title20) {
        this.title20 = title20;
    }

    public String getTitle21() {
        return title21;
    }

    public void setTitle21(String title21) {
        this.title21 = title21;
    }
}

