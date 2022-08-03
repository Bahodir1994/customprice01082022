package uz.customs.customsprice.entity.files;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "FOR_HTML_CANCELLED")
public class ForHtmlCancelled {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "title", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title;

    @Column(name = "title2", columnDefinition = "VARCHAR(800) CCSID 1208")
    private String title2;

    @Column(name = "name1", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name1;

    @Column(name = "name2", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name2;

    @Column(name = "name3", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name3;

    @Column(name = "name4", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name4;

    @Column(name = "name5", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name5;

    @Column(name = "name6", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name6;

    @Column(name = "name7", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name7;

    @Column(name = "name8", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name8;

    @Column(name = "name9", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name9;

    @Column(name = "name10", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name10;

    @Column(name = "name11", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name11;

    @Column(name = "name12", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name12;

    @Column(name = "name13", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name13;

    @Column(name = "comment1", columnDefinition = " VARCHAR(800) CCSID 1208")
    private String comment1;

    @Column(name = "comment2", columnDefinition = " VARCHAR(800) CCSID 1208")
    private String comment2;

    @Column(name = "zapas1", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas1;

    @Column(name = "zapas2", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas2;

    @Column(name = "zapas3", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas3;

    @Column(name = "zapas4", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas4;

    /************************************************************************************************************/


    @Column(name = "apps1", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps1;

    @Column(name = "apps2", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps2;

    @Column(name = "apps3", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps3;

    @Column(name = "apps4", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps4;

    @Column(name = "apps5", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps5;

    @Column(name = "apps6", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps6;

    @Column(name = "apps7", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps7;

    @Column(name = "apps8", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps8;

    @Column(name = "apps9", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps9;

    @Column(name = "apps10", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps10;

    @Column(name = "apps11", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps11;

    @Column(name = "apps12", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps12;

    @Column(name = "apps13", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps13;

    @Column(name = "apps14", columnDefinition = " VARCHAR(600) CCSID 1208")
    private String apps14;

    @Column(name = "apps15", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps15;

    @Column(name = "apps16", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps16;

    @Column(name = "apps17", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps17;

    @Column(name = "apps18", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps18;

    @Column(name = "apps19", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps19;

    @Column(name = "apps20", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps20;

    @Column(name = "apps21", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps21;

    @Column(name = "apps22", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps22;

    @Column(name = "apps23", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps23;

    @Column(name = "apps24", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps24;

    @Column(name = "apps25", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps25;

    @Column(name = "apps26", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps26;

    @Column(name = "apps27", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps27;

    @Column(name = "apps28", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps28;

    @Column(name = "apps29", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps29;

    @Column(name = "apps30", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String apps30;

    public ForHtmlCancelled() {
    }

    public ForHtmlCancelled(String id, String title, String title2, String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9, String name10, String name11, String name12, String name13, String comment1, String comment2, String zapas1, String zapas2, String zapas3, String zapas4, String apps1, String apps2, String apps3, String apps4, String apps5, String apps6, String apps7, String apps8, String apps9, String apps10, String apps11, String apps12, String apps13, String apps14, String apps15, String apps16, String apps17, String apps18, String apps19, String apps20, String apps21, String apps22, String apps23, String apps24, String apps25, String apps26, String apps27, String apps28, String apps29, String apps30) {
        this.id = id;
        this.title = title;
        this.title2 = title2;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;
        this.name6 = name6;
        this.name7 = name7;
        this.name8 = name8;
        this.name9 = name9;
        this.name10 = name10;
        this.name11 = name11;
        this.name12 = name12;
        this.name13 = name13;
        this.comment1 = comment1;
        this.comment2 = comment2;
        this.zapas1 = zapas1;
        this.zapas2 = zapas2;
        this.zapas3 = zapas3;
        this.zapas4 = zapas4;
        this.apps1 = apps1;
        this.apps2 = apps2;
        this.apps3 = apps3;
        this.apps4 = apps4;
        this.apps5 = apps5;
        this.apps6 = apps6;
        this.apps7 = apps7;
        this.apps8 = apps8;
        this.apps9 = apps9;
        this.apps10 = apps10;
        this.apps11 = apps11;
        this.apps12 = apps12;
        this.apps13 = apps13;
        this.apps14 = apps14;
        this.apps15 = apps15;
        this.apps16 = apps16;
        this.apps17 = apps17;
        this.apps18 = apps18;
        this.apps19 = apps19;
        this.apps20 = apps20;
        this.apps21 = apps21;
        this.apps22 = apps22;
        this.apps23 = apps23;
        this.apps24 = apps24;
        this.apps25 = apps25;
        this.apps26 = apps26;
        this.apps27 = apps27;
        this.apps28 = apps28;
        this.apps29 = apps29;
        this.apps30 = apps30;
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

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6;
    }

    public String getName7() {
        return name7;
    }

    public void setName7(String name7) {
        this.name7 = name7;
    }

    public String getName8() {
        return name8;
    }

    public void setName8(String name8) {
        this.name8 = name8;
    }

    public String getName9() {
        return name9;
    }

    public void setName9(String name9) {
        this.name9 = name9;
    }

    public String getName10() {
        return name10;
    }

    public void setName10(String name10) {
        this.name10 = name10;
    }

    public String getName11() {
        return name11;
    }

    public void setName11(String name11) {
        this.name11 = name11;
    }

    public String getName12() {
        return name12;
    }

    public void setName12(String name12) {
        this.name12 = name12;
    }

    public String getName13() {
        return name13;
    }

    public void setName13(String name13) {
        this.name13 = name13;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public String getZapas1() {
        return zapas1;
    }

    public void setZapas1(String zapas1) {
        this.zapas1 = zapas1;
    }

    public String getZapas2() {
        return zapas2;
    }

    public void setZapas2(String zapas2) {
        this.zapas2 = zapas2;
    }

    public String getZapas3() {
        return zapas3;
    }

    public void setZapas3(String zapas3) {
        this.zapas3 = zapas3;
    }

    public String getZapas4() {
        return zapas4;
    }

    public void setZapas4(String zapas4) {
        this.zapas4 = zapas4;
    }

    public String getApps1() {
        return apps1;
    }

    public void setApps1(String apps1) {
        this.apps1 = apps1;
    }

    public String getApps2() {
        return apps2;
    }

    public void setApps2(String apps2) {
        this.apps2 = apps2;
    }

    public String getApps3() {
        return apps3;
    }

    public void setApps3(String apps3) {
        this.apps3 = apps3;
    }

    public String getApps4() {
        return apps4;
    }

    public void setApps4(String apps4) {
        this.apps4 = apps4;
    }

    public String getApps5() {
        return apps5;
    }

    public void setApps5(String apps5) {
        this.apps5 = apps5;
    }

    public String getApps6() {
        return apps6;
    }

    public void setApps6(String apps6) {
        this.apps6 = apps6;
    }

    public String getApps7() {
        return apps7;
    }

    public void setApps7(String apps7) {
        this.apps7 = apps7;
    }

    public String getApps8() {
        return apps8;
    }

    public void setApps8(String apps8) {
        this.apps8 = apps8;
    }

    public String getApps9() {
        return apps9;
    }

    public void setApps9(String apps9) {
        this.apps9 = apps9;
    }

    public String getApps10() {
        return apps10;
    }

    public void setApps10(String apps10) {
        this.apps10 = apps10;
    }

    public String getApps11() {
        return apps11;
    }

    public void setApps11(String apps11) {
        this.apps11 = apps11;
    }

    public String getApps12() {
        return apps12;
    }

    public void setApps12(String apps12) {
        this.apps12 = apps12;
    }

    public String getApps13() {
        return apps13;
    }

    public void setApps13(String apps13) {
        this.apps13 = apps13;
    }

    public String getApps14() {
        return apps14;
    }

    public void setApps14(String apps14) {
        this.apps14 = apps14;
    }

    public String getApps15() {
        return apps15;
    }

    public void setApps15(String apps15) {
        this.apps15 = apps15;
    }

    public String getApps16() {
        return apps16;
    }

    public void setApps16(String apps16) {
        this.apps16 = apps16;
    }

    public String getApps17() {
        return apps17;
    }

    public void setApps17(String apps17) {
        this.apps17 = apps17;
    }

    public String getApps18() {
        return apps18;
    }

    public void setApps18(String apps18) {
        this.apps18 = apps18;
    }

    public String getApps19() {
        return apps19;
    }

    public void setApps19(String apps19) {
        this.apps19 = apps19;
    }

    public String getApps20() {
        return apps20;
    }

    public void setApps20(String apps20) {
        this.apps20 = apps20;
    }

    public String getApps21() {
        return apps21;
    }

    public void setApps21(String apps21) {
        this.apps21 = apps21;
    }

    public String getApps22() {
        return apps22;
    }

    public void setApps22(String apps22) {
        this.apps22 = apps22;
    }

    public String getApps23() {
        return apps23;
    }

    public void setApps23(String apps23) {
        this.apps23 = apps23;
    }

    public String getApps24() {
        return apps24;
    }

    public void setApps24(String apps24) {
        this.apps24 = apps24;
    }

    public String getApps25() {
        return apps25;
    }

    public void setApps25(String apps25) {
        this.apps25 = apps25;
    }

    public String getApps26() {
        return apps26;
    }

    public void setApps26(String apps26) {
        this.apps26 = apps26;
    }

    public String getApps27() {
        return apps27;
    }

    public void setApps27(String apps27) {
        this.apps27 = apps27;
    }

    public String getApps28() {
        return apps28;
    }

    public void setApps28(String apps28) {
        this.apps28 = apps28;
    }

    public String getApps29() {
        return apps29;
    }

    public void setApps29(String apps29) {
        this.apps29 = apps29;
    }

    public String getApps30() {
        return apps30;
    }

    public void setApps30(String apps30) {
        this.apps30 = apps30;
    }
}

