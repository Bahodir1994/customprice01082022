package uz.customs.customsprice.entity.files;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "FOR_HTML_CANCELLED")
public class forHtmlCancelled {
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

    public forHtmlCancelled() {
    }

    public forHtmlCancelled(String id, String title, String title2, String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9, String name10, String name11, String name12, String name13, String comment1, String comment2, String zapas1, String zapas2, String zapas3, String zapas4) {
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
}

