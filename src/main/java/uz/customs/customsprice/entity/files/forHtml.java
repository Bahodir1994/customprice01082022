package uz.customs.customsprice.entity.files;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "FOR_HTML")
public class forHtml {
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

    @Column(name = "tableb1", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb1;

    @Column(name = "tableb2", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb2;

    @Column(name = "tableb3", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb3;

    @Column(name = "tableb4", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb4;

    @Column(name = "tableb5", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb5;

    @Column(name = "tableb6", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb6;

    @Column(name = "tableb7", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb7;

    @Column(name = "tableb8", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb8;

    @Column(name = "tableb9", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb9;

    @Column(name = "tableb10", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb10;

    @Column(name = "tableb11", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb11;

    @Column(name = "tableb12", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb12;

    @Column(name = "tableb13", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb13;

    @Column(name = "tableb14", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb14;

    @Column(name = "tableb15", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb15;

    @Column(name = "tableb16", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb16;

    @Column(name = "tableb17", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb17;

    @Column(name = "tableb18", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb18;

    @Column(name = "tableb19", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb19;

    @Column(name = "tableb20", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb20;

    @Column(name = "tableb21", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb21;

    @Column(name = "tableb22", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableb22;

    @Column(name = "name7", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name7;

    @Column(name = "name8", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name8;

    @Column(name = "name9", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name9;

    @Column(name = "tablei1", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tablei1;

    @Column(name = "tablei2", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tablei2;

    @Column(name = "tablei3", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tablei3;

    @Column(name = "tablei4", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tablei4;

    @Column(name = "tablei5", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tablei5;

    @Column(name = "tablei6", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tablei6;

    @Column(name = "tablei7", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tablei7;

    @Column(name = "name10", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name10;

    @Column(name = "name11", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name11;

    @Column(name = "tableu1", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableu1;

    @Column(name = "tableu2", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableu2;

    @Column(name = "tableu3", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableu3;

    @Column(name = "tableu4", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String tableu4;

    @Column(name = "name12", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name12;

    @Column(name = "name13", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name13;

    @Column(name = "name13_1", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String name13_1;

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

    @Column(name = "zapas5", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas5;

    @Column(name = "zapas6", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas6;

    @Column(name = "zapas7", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas7;

    @Column(name = "zapas8", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas8;

    @Column(name = "zapas9", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas9;

    @Column(name = "zapas10", columnDefinition = " VARCHAR(400) CCSID 1208")
    private String zapas10;

    public forHtml() {
    }

    public forHtml(String id, String title, String title2, String name1, String name2, String name3, String name4, String name5, String name6, String tableb1, String tableb2, String tableb3, String tableb4, String tableb5, String tableb6, String tableb7, String tableb8, String tableb9, String tableb10, String tableb11, String tableb12, String tableb13, String tableb14, String tableb15, String tableb16, String tableb17, String tableb18, String tableb19, String tableb20, String tableb21, String tableb22, String name7, String name8, String name9, String tablei1, String tablei2, String tablei3, String tablei4, String tablei5, String tablei6, String tablei7, String name10, String name11, String tableu1, String tableu2, String tableu3, String tableu4, String name12, String name13, String name13_1, String comment1, String comment2, String zapas1, String zapas2, String zapas3, String zapas4, String zapas5, String zapas6, String zapas7, String zapas8, String zapas9, String zapas10) {
        this.id = id;
        this.title = title;
        this.title2 = title2;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;
        this.name6 = name6;
        this.tableb1 = tableb1;
        this.tableb2 = tableb2;
        this.tableb3 = tableb3;
        this.tableb4 = tableb4;
        this.tableb5 = tableb5;
        this.tableb6 = tableb6;
        this.tableb7 = tableb7;
        this.tableb8 = tableb8;
        this.tableb9 = tableb9;
        this.tableb10 = tableb10;
        this.tableb11 = tableb11;
        this.tableb12 = tableb12;
        this.tableb13 = tableb13;
        this.tableb14 = tableb14;
        this.tableb15 = tableb15;
        this.tableb16 = tableb16;
        this.tableb17 = tableb17;
        this.tableb18 = tableb18;
        this.tableb19 = tableb19;
        this.tableb20 = tableb20;
        this.tableb21 = tableb21;
        this.tableb22 = tableb22;
        this.name7 = name7;
        this.name8 = name8;
        this.name9 = name9;
        this.tablei1 = tablei1;
        this.tablei2 = tablei2;
        this.tablei3 = tablei3;
        this.tablei4 = tablei4;
        this.tablei5 = tablei5;
        this.tablei6 = tablei6;
        this.tablei7 = tablei7;
        this.name10 = name10;
        this.name11 = name11;
        this.tableu1 = tableu1;
        this.tableu2 = tableu2;
        this.tableu3 = tableu3;
        this.tableu4 = tableu4;
        this.name12 = name12;
        this.name13 = name13;
        this.name13_1 = name13_1;
        this.comment1 = comment1;
        this.comment2 = comment2;
        this.zapas1 = zapas1;
        this.zapas2 = zapas2;
        this.zapas3 = zapas3;
        this.zapas4 = zapas4;
        this.zapas5 = zapas5;
        this.zapas6 = zapas6;
        this.zapas7 = zapas7;
        this.zapas8 = zapas8;
        this.zapas9 = zapas9;
        this.zapas10 = zapas10;
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

    public String getTableb1() {
        return tableb1;
    }

    public void setTableb1(String tableb1) {
        this.tableb1 = tableb1;
    }

    public String getTableb2() {
        return tableb2;
    }

    public void setTableb2(String tableb2) {
        this.tableb2 = tableb2;
    }

    public String getTableb3() {
        return tableb3;
    }

    public void setTableb3(String tableb3) {
        this.tableb3 = tableb3;
    }

    public String getTableb4() {
        return tableb4;
    }

    public void setTableb4(String tableb4) {
        this.tableb4 = tableb4;
    }

    public String getTableb5() {
        return tableb5;
    }

    public void setTableb5(String tableb5) {
        this.tableb5 = tableb5;
    }

    public String getTableb6() {
        return tableb6;
    }

    public void setTableb6(String tableb6) {
        this.tableb6 = tableb6;
    }

    public String getTableb7() {
        return tableb7;
    }

    public void setTableb7(String tableb7) {
        this.tableb7 = tableb7;
    }

    public String getTableb8() {
        return tableb8;
    }

    public void setTableb8(String tableb8) {
        this.tableb8 = tableb8;
    }

    public String getTableb9() {
        return tableb9;
    }

    public void setTableb9(String tableb9) {
        this.tableb9 = tableb9;
    }

    public String getTableb10() {
        return tableb10;
    }

    public void setTableb10(String tableb10) {
        this.tableb10 = tableb10;
    }

    public String getTableb11() {
        return tableb11;
    }

    public void setTableb11(String tableb11) {
        this.tableb11 = tableb11;
    }

    public String getTableb12() {
        return tableb12;
    }

    public void setTableb12(String tableb12) {
        this.tableb12 = tableb12;
    }

    public String getTableb13() {
        return tableb13;
    }

    public void setTableb13(String tableb13) {
        this.tableb13 = tableb13;
    }

    public String getTableb14() {
        return tableb14;
    }

    public void setTableb14(String tableb14) {
        this.tableb14 = tableb14;
    }

    public String getTableb15() {
        return tableb15;
    }

    public void setTableb15(String tableb15) {
        this.tableb15 = tableb15;
    }

    public String getTableb16() {
        return tableb16;
    }

    public void setTableb16(String tableb16) {
        this.tableb16 = tableb16;
    }

    public String getTableb17() {
        return tableb17;
    }

    public void setTableb17(String tableb17) {
        this.tableb17 = tableb17;
    }

    public String getTableb18() {
        return tableb18;
    }

    public void setTableb18(String tableb18) {
        this.tableb18 = tableb18;
    }

    public String getTableb19() {
        return tableb19;
    }

    public void setTableb19(String tableb19) {
        this.tableb19 = tableb19;
    }

    public String getTableb20() {
        return tableb20;
    }

    public void setTableb20(String tableb20) {
        this.tableb20 = tableb20;
    }

    public String getTableb21() {
        return tableb21;
    }

    public void setTableb21(String tableb21) {
        this.tableb21 = tableb21;
    }

    public String getTableb22() {
        return tableb22;
    }

    public void setTableb22(String tableb22) {
        this.tableb22 = tableb22;
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

    public String getTablei1() {
        return tablei1;
    }

    public void setTablei1(String tablei1) {
        this.tablei1 = tablei1;
    }

    public String getTablei2() {
        return tablei2;
    }

    public void setTablei2(String tablei2) {
        this.tablei2 = tablei2;
    }

    public String getTablei3() {
        return tablei3;
    }

    public void setTablei3(String tablei3) {
        this.tablei3 = tablei3;
    }

    public String getTablei4() {
        return tablei4;
    }

    public void setTablei4(String tablei4) {
        this.tablei4 = tablei4;
    }

    public String getTablei5() {
        return tablei5;
    }

    public void setTablei5(String tablei5) {
        this.tablei5 = tablei5;
    }

    public String getTablei6() {
        return tablei6;
    }

    public void setTablei6(String tablei6) {
        this.tablei6 = tablei6;
    }

    public String getTablei7() {
        return tablei7;
    }

    public void setTablei7(String tablei7) {
        this.tablei7 = tablei7;
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

    public String getTableu1() {
        return tableu1;
    }

    public void setTableu1(String tableu1) {
        this.tableu1 = tableu1;
    }

    public String getTableu2() {
        return tableu2;
    }

    public void setTableu2(String tableu2) {
        this.tableu2 = tableu2;
    }

    public String getTableu3() {
        return tableu3;
    }

    public void setTableu3(String tableu3) {
        this.tableu3 = tableu3;
    }

    public String getTableu4() {
        return tableu4;
    }

    public void setTableu4(String tableu4) {
        this.tableu4 = tableu4;
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

    public String getName13_1() {
        return name13_1;
    }

    public void setName13_1(String name13_1) {
        this.name13_1 = name13_1;
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

    public String getZapas5() {
        return zapas5;
    }

    public void setZapas5(String zapas5) {
        this.zapas5 = zapas5;
    }

    public String getZapas6() {
        return zapas6;
    }

    public void setZapas6(String zapas6) {
        this.zapas6 = zapas6;
    }

    public String getZapas7() {
        return zapas7;
    }

    public void setZapas7(String zapas7) {
        this.zapas7 = zapas7;
    }

    public String getZapas8() {
        return zapas8;
    }

    public void setZapas8(String zapas8) {
        this.zapas8 = zapas8;
    }

    public String getZapas9() {
        return zapas9;
    }

    public void setZapas9(String zapas9) {
        this.zapas9 = zapas9;
    }

    public String getZapas10() {
        return zapas10;
    }

    public void setZapas10(String zapas10) {
        this.zapas10 = zapas10;
    }
}
