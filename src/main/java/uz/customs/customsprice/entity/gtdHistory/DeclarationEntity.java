package uz.customs.customsprice.entity.gtdHistory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DECLARATION", schema = "ASOD", catalog = "")
public class DeclarationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "NUMBER")
    private String number;
    @Basic
    @Column(name = "G1A")
    private String g1A;
    @Basic
    @Column(name = "G1B")
    private String g1B;
    @Basic
    @Column(name = "G1C")
    private String g1C;
    @Basic
    @Column(name = "G2CODE1")
    private String g2Code1;
    @Basic
    @Column(name = "G2NAME")
    private String g2Name;
    @Basic
    @Column(name = "G2ADDRESS")
    private String g2Address;
    @Basic
    @Column(name = "G2ADD")
    private String g2Add;
    @Basic
    @Column(name = "G2CODE2")
    private String g2Code2;
    @Basic
    @Column(name = "G2PASPNO")
    private String g2Paspno;
    @Basic
    @Column(name = "G2PASPDATE")
    private Date g2Paspdate;
    @Basic
    @Column(name = "G2PASPDEF")
    private String g2Paspdef;
    @Basic
    @Column(name = "G2DATE")
    private Date g2Date;
    @Basic
    @Column(name = "G3B")
    private Integer g3B;
    @Basic
    @Column(name = "G4")
    private Integer g4;
    @Basic
    @Column(name = "G5")
    private Integer g5;
    @Basic
    @Column(name = "G6")
    private Integer g6;
    @Basic
    @Column(name = "G7A")
    private String g7A;
    @Basic
    @Column(name = "G7B")
    private Date g7B;
    @Basic
    @Column(name = "G7C")
    private String g7C;
    @Basic
    @Column(name = "G8CODE1")
    private String g8Code1;
    @Basic
    @Column(name = "G8NAME")
    private String g8Name;
    @Basic
    @Column(name = "G8ADDRESS")
    private String g8Address;
    @Basic
    @Column(name = "G8ADD")
    private String g8Add;
    @Basic
    @Column(name = "G8CODE2")
    private String g8Code2;
    @Basic
    @Column(name = "G8PASPNO")
    private String g8Paspno;
    @Basic
    @Column(name = "G8PASPDATE")
    private Date g8Paspdate;
    @Basic
    @Column(name = "G8PASPDEF")
    private String g8Paspdef;
    @Basic
    @Column(name = "G8DATE")
    private Date g8Date;
    @Basic
    @Column(name = "G9CODE1")
    private String g9Code1;
    @Basic
    @Column(name = "G9NAME")
    private String g9Name;
    @Basic
    @Column(name = "G9ADDRESS")
    private String g9Address;
    @Basic
    @Column(name = "G9CODE2")
    private String g9Code2;
    @Basic
    @Column(name = "G9DATE")
    private Date g9Date;
    @Basic
    @Column(name = "G11")
    private String g11;
    @Basic
    @Column(name = "G12")
    private BigDecimal g12;
    @Basic
    @Column(name = "G13")
    private BigDecimal g13;
    @Basic
    @Column(name = "G14CODE1")
    private String g14Code1;
    @Basic
    @Column(name = "G14NAME")
    private String g14Name;
    @Basic
    @Column(name = "G14ADDRESS")
    private String g14Address;
    @Basic
    @Column(name = "G14CODE2")
    private String g14Code2;
    @Basic
    @Column(name = "G14DATE")
    private Date g14Date;
    @Basic
    @Column(name = "G15")
    private String g15;
    @Basic
    @Column(name = "G16")
    private String g16;
    @Basic
    @Column(name = "G17")
    private String g17;
    @Basic
    @Column(name = "G18COUNT")
    private Integer g18Count;
    @Basic
    @Column(name = "G18CODE2")
    private String g18Code2;
    @Basic
    @Column(name = "G19")
    private Integer g19;
    @Basic
    @Column(name = "G20A")
    private String g20A;
    @Basic
    @Column(name = "G20B")
    private String g20B;
    @Basic
    @Column(name = "G20NAME")
    private String g20Name;
    @Basic
    @Column(name = "G20FR")
    private String g20Fr;
    @Basic
    @Column(name = "G21COUNT")
    private Integer g21Count;
    @Basic
    @Column(name = "G21CODE2")
    private String g21Code2;
    @Basic
    @Column(name = "G22A")
    private String g22A;
    @Basic
    @Column(name = "G22B")
    private BigDecimal g22B;
    @Basic
    @Column(name = "G23")
    private BigDecimal g23;
    @Basic
    @Column(name = "G23SCALE")
    private BigDecimal g23Scale;
    @Basic
    @Column(name = "G24A")
    private String g24A;
    @Basic
    @Column(name = "G24B")
    private String g24B;
    @Basic
    @Column(name = "G25")
    private String g25;
    @Basic
    @Column(name = "G26")
    private String g26;
    @Basic
    @Column(name = "G28_1A")
    private String g281A;
    @Basic
    @Column(name = "G28_1B")
    private String g281B;
    @Basic
    @Column(name = "G28_2")
    private String g282;
    @Basic
    @Column(name = "G28_3")
    private String g283;
    @Basic
    @Column(name = "G28_4")
    private String g284;
    @Basic
    @Column(name = "G28_41")
    private String g2841;
    @Basic
    @Column(name = "G28_5")
    private String g285;
    @Basic
    @Column(name = "G28_51")
    private String g2851;
    @Basic
    @Column(name = "G29")
    private String g29;
    @Basic
    @Column(name = "G48")
    private Date g48;
    @Basic
    @Column(name = "G49NAME")
    private String g49Name;
    @Basic
    @Column(name = "G49DATE")
    private Date g49Date;
    @Basic
    @Column(name = "G50")
    private String g50;
    @Basic
    @Column(name = "G50B")
    private String g50B;
    @Basic
    @Column(name = "G53")
    private String g53;
    @Basic
    @Column(name = "G53NO")
    private String g53No;
    @Basic
    @Column(name = "G53DATE")
    private Date g53Date;
    @Basic
    @Column(name = "G53CODE")
    private String g53Code;
    @Basic
    @Column(name = "G54PLACE")
    private String g54Place;
    @Basic
    @Column(name = "G54DATE")
    private Date g54Date;
    @Basic
    @Column(name = "G54PHONE")
    private String g54Phone;
    @Basic
    @Column(name = "GACODE")
    private String gacode;
    @Basic
    @Column(name = "GANAME")
    private String ganame;
    @Basic
    @Column(name = "GAADDRESS")
    private String gaaddress;
    @Basic
    @Column(name = "GAACCOUNT1")
    private String gaaccount1;
    @Basic
    @Column(name = "GAMFO1")
    private String gamfo1;
    @Basic
    @Column(name = "GAACCOUNT2")
    private String gaaccount2;
    @Basic
    @Column(name = "GAMFO2")
    private String gamfo2;
    @Basic
    @Column(name = "GC1BANKOKPO")
    private String gc1Bankokpo;
    @Basic
    @Column(name = "GC1INN")
    private String gc1Inn;
    @Basic
    @Column(name = "GC1YEAR")
    private String gc1Year;
    @Basic
    @Column(name = "GC1KNTCODE")
    private String gc1Kntcode;
    @Basic
    @Column(name = "GC1KNTNO")
    private String gc1Kntno;
    @Basic
    @Column(name = "GC2RGNCODE")
    private String gc2Rgncode;
    @Basic
    @Column(name = "GC2KNTNO")
    private String gc2Kntno;
    @Basic
    @Column(name = "GC2DATE")
    private Date gc2Date;
    @Basic
    @Column(name = "GC3DATE")
    private Date gc3Date;
    @Basic
    @Column(name = "GC3TRANTYPE")
    private String gc3Trantype;
    @Basic
    @Column(name = "GC4PASPNO")
    private String gc4Paspno;
    @Basic
    @Column(name = "GC4DATE")
    private Date gc4Date;
    @Basic
    @Column(name = "GDA")
    private String gda;
    @Basic
    @Column(name = "GDB")
    private Date gdb;
    @Basic
    @Column(name = "OWNER_ID")
    private String ownerId;
    @Basic
    @Column(name = "ADMIN_ID")
    private String adminId;
    @Basic
    @Column(name = "STATUS")
    private Integer status;
    @Basic
    @Column(name = "PARTYID")
    private String partyid;
    @Basic
    @Column(name = "EURORATE")
    private BigDecimal eurorate;
    @Basic
    @Column(name = "G54REGCODE")
    private String g54Regcode;
    @Basic
    @Column(name = "GC2KNTTYPE")
    private String gc2Knttype;
    @Basic
    @Column(name = "G10")
    private String g10;
    @Basic
    @Column(name = "G27")
    private String g27;
    @Basic
    @Column(name = "G30")
    private String g30;
    @Basic
    @Column(name = "G51")
    private String g51;
    @Basic
    @Column(name = "G52")
    private String g52;
    @Basic
    @Column(name = "G20DATE")
    private Date g20Date;
    @Basic
    @Column(name = "GDVIPDATE")
    private Date gdvipdate;
    @Basic
    @Column(name = "GDVIPSTAMP")
    private String gdvipstamp;
    @Basic
    @Column(name = "INSTIME")
    private Timestamp instime;
    @Basic
    @Column(name = "UPDTIME")
    private Timestamp updtime;
    @Basic
    @Column(name = "FLAG_E")
    private Short flagE;
    @Basic
    @Column(name = "REGTIME")
    private Timestamp regtime;
    @Basic
    @Column(name = "REGOFRTIME")
    private Timestamp regofrtime;
    @Basic
    @Column(name = "REGDATE")
    private Date regdate;
    @Basic
    @Column(name = "OFRDATE")
    private Date ofrdate;
    @Basic
    @Column(name = "G28_1C")
    private String g281C;
    @Basic
    @Column(name = "GC3EXPFLAG")
    private String gc3Expflag;
    @Basic
    @Column(name = "G53POST")
    private String g53Post;
    @Basic
    @Column(name = "GC2CSTCODE")
    private String gc2Cstcode;
    @Basic
    @Column(name = "FLAG_R")
    private String flagR;
    @Basic
    @Column(name = "POSTPUNKT")
    private String postpunkt;
    @Basic
    @Column(name = "NUM")
    private Integer num;
    @Basic
    @Column(name = "GC1BANKINN")
    private String gc1Bankinn;
    @Basic
    @Column(name = "G2NAMEEXP")
    private String g2Nameexp;
    @Basic
    @Column(name = "G2CODE1EXP")
    private String g2Code1Exp;
    @Basic
    @Column(name = "G2CODE2EXP")
    private String g2Code2Exp;
    @Basic
    @Column(name = "G8NAMEIMP")
    private String g8Nameimp;
    @Basic
    @Column(name = "G8CODE1IMP")
    private String g8Code1Imp;
    @Basic
    @Column(name = "G8CODE2IMP")
    private String g8Code2Imp;
    @Basic
    @Column(name = "G20STRANA1")
    private String g20Strana1;
    @Basic
    @Column(name = "G20STRANA2")
    private String g20Strana2;
    @Basic
    @Column(name = "G28_1D")
    private String g281D;
    @Basic
    @Column(name = "G30POST")
    private String g30Post;
    @Basic
    @Column(name = "G50DOC")
    private String g50Doc;
    @Basic
    @Column(name = "G54NAME")
    private String g54Name;
    @Basic
    @Column(name = "G54NUMBER")
    private String g54Number;
    @Basic
    @Column(name = "G54MAIL")
    private String g54Mail;
    @Basic
    @Column(name = "G54DOC")
    private String g54Doc;
    @Basic
    @Column(name = "RETURN_FLAG")
    private Short returnFlag;
    @Basic
    @Column(name = "G30LNO")
    private String g30Lno;
    @Basic
    @Column(name = "G30DATE")
    private Date g30Date;
    @Basic
    @Column(name = "G50DATE")
    private Date g50Date;
    @Basic
    @Column(name = "G2REGION")
    private String g2Region;
    @Basic
    @Column(name = "G8REGION")
    private String g8Region;
    @Basic
    @Column(name = "G9REGION")
    private String g9Region;
    @Basic
    @Column(name = "G11B")
    private String g11B;
    @Basic
    @Column(name = "G20K")
    private String g20K;
    @Basic
    @Column(name = "G50INN")
    private String g50Inn;
    @Basic
    @Column(name = "G2PHONE")
    private String g2Phone;
    @Basic
    @Column(name = "G8PHONE")
    private String g8Phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getG1A() {
        return g1A;
    }

    public void setG1A(String g1A) {
        this.g1A = g1A;
    }

    public String getG1B() {
        return g1B;
    }

    public void setG1B(String g1B) {
        this.g1B = g1B;
    }

    public String getG1C() {
        return g1C;
    }

    public void setG1C(String g1C) {
        this.g1C = g1C;
    }

    public String getG2Code1() {
        return g2Code1;
    }

    public void setG2Code1(String g2Code1) {
        this.g2Code1 = g2Code1;
    }

    public String getG2Name() {
        return g2Name;
    }

    public void setG2Name(String g2Name) {
        this.g2Name = g2Name;
    }

    public String getG2Address() {
        return g2Address;
    }

    public void setG2Address(String g2Address) {
        this.g2Address = g2Address;
    }

    public String getG2Add() {
        return g2Add;
    }

    public void setG2Add(String g2Add) {
        this.g2Add = g2Add;
    }

    public String getG2Code2() {
        return g2Code2;
    }

    public void setG2Code2(String g2Code2) {
        this.g2Code2 = g2Code2;
    }

    public String getG2Paspno() {
        return g2Paspno;
    }

    public void setG2Paspno(String g2Paspno) {
        this.g2Paspno = g2Paspno;
    }

    public Date getG2Paspdate() {
        return g2Paspdate;
    }

    public void setG2Paspdate(Date g2Paspdate) {
        this.g2Paspdate = g2Paspdate;
    }

    public String getG2Paspdef() {
        return g2Paspdef;
    }

    public void setG2Paspdef(String g2Paspdef) {
        this.g2Paspdef = g2Paspdef;
    }

    public Date getG2Date() {
        return g2Date;
    }

    public void setG2Date(Date g2Date) {
        this.g2Date = g2Date;
    }

    public Integer getG3B() {
        return g3B;
    }

    public void setG3B(Integer g3B) {
        this.g3B = g3B;
    }

    public Integer getG4() {
        return g4;
    }

    public void setG4(Integer g4) {
        this.g4 = g4;
    }

    public Integer getG5() {
        return g5;
    }

    public void setG5(Integer g5) {
        this.g5 = g5;
    }

    public Integer getG6() {
        return g6;
    }

    public void setG6(Integer g6) {
        this.g6 = g6;
    }

    public String getG7A() {
        return g7A;
    }

    public void setG7A(String g7A) {
        this.g7A = g7A;
    }

    public Date getG7B() {
        return g7B;
    }

    public void setG7B(Date g7B) {
        this.g7B = g7B;
    }

    public String getG7C() {
        return g7C;
    }

    public void setG7C(String g7C) {
        this.g7C = g7C;
    }

    public String getG8Code1() {
        return g8Code1;
    }

    public void setG8Code1(String g8Code1) {
        this.g8Code1 = g8Code1;
    }

    public String getG8Name() {
        return g8Name;
    }

    public void setG8Name(String g8Name) {
        this.g8Name = g8Name;
    }

    public String getG8Address() {
        return g8Address;
    }

    public void setG8Address(String g8Address) {
        this.g8Address = g8Address;
    }

    public String getG8Add() {
        return g8Add;
    }

    public void setG8Add(String g8Add) {
        this.g8Add = g8Add;
    }

    public String getG8Code2() {
        return g8Code2;
    }

    public void setG8Code2(String g8Code2) {
        this.g8Code2 = g8Code2;
    }

    public String getG8Paspno() {
        return g8Paspno;
    }

    public void setG8Paspno(String g8Paspno) {
        this.g8Paspno = g8Paspno;
    }

    public Date getG8Paspdate() {
        return g8Paspdate;
    }

    public void setG8Paspdate(Date g8Paspdate) {
        this.g8Paspdate = g8Paspdate;
    }

    public String getG8Paspdef() {
        return g8Paspdef;
    }

    public void setG8Paspdef(String g8Paspdef) {
        this.g8Paspdef = g8Paspdef;
    }

    public Date getG8Date() {
        return g8Date;
    }

    public void setG8Date(Date g8Date) {
        this.g8Date = g8Date;
    }

    public String getG9Code1() {
        return g9Code1;
    }

    public void setG9Code1(String g9Code1) {
        this.g9Code1 = g9Code1;
    }

    public String getG9Name() {
        return g9Name;
    }

    public void setG9Name(String g9Name) {
        this.g9Name = g9Name;
    }

    public String getG9Address() {
        return g9Address;
    }

    public void setG9Address(String g9Address) {
        this.g9Address = g9Address;
    }

    public String getG9Code2() {
        return g9Code2;
    }

    public void setG9Code2(String g9Code2) {
        this.g9Code2 = g9Code2;
    }

    public Date getG9Date() {
        return g9Date;
    }

    public void setG9Date(Date g9Date) {
        this.g9Date = g9Date;
    }

    public String getG11() {
        return g11;
    }

    public void setG11(String g11) {
        this.g11 = g11;
    }

    public BigDecimal getG12() {
        return g12;
    }

    public void setG12(BigDecimal g12) {
        this.g12 = g12;
    }

    public BigDecimal getG13() {
        return g13;
    }

    public void setG13(BigDecimal g13) {
        this.g13 = g13;
    }

    public String getG14Code1() {
        return g14Code1;
    }

    public void setG14Code1(String g14Code1) {
        this.g14Code1 = g14Code1;
    }

    public String getG14Name() {
        return g14Name;
    }

    public void setG14Name(String g14Name) {
        this.g14Name = g14Name;
    }

    public String getG14Address() {
        return g14Address;
    }

    public void setG14Address(String g14Address) {
        this.g14Address = g14Address;
    }

    public String getG14Code2() {
        return g14Code2;
    }

    public void setG14Code2(String g14Code2) {
        this.g14Code2 = g14Code2;
    }

    public Date getG14Date() {
        return g14Date;
    }

    public void setG14Date(Date g14Date) {
        this.g14Date = g14Date;
    }

    public String getG15() {
        return g15;
    }

    public void setG15(String g15) {
        this.g15 = g15;
    }

    public String getG16() {
        return g16;
    }

    public void setG16(String g16) {
        this.g16 = g16;
    }

    public String getG17() {
        return g17;
    }

    public void setG17(String g17) {
        this.g17 = g17;
    }

    public Integer getG18Count() {
        return g18Count;
    }

    public void setG18Count(Integer g18Count) {
        this.g18Count = g18Count;
    }

    public String getG18Code2() {
        return g18Code2;
    }

    public void setG18Code2(String g18Code2) {
        this.g18Code2 = g18Code2;
    }

    public Integer getG19() {
        return g19;
    }

    public void setG19(Integer g19) {
        this.g19 = g19;
    }

    public String getG20A() {
        return g20A;
    }

    public void setG20A(String g20A) {
        this.g20A = g20A;
    }

    public String getG20B() {
        return g20B;
    }

    public void setG20B(String g20B) {
        this.g20B = g20B;
    }

    public String getG20Name() {
        return g20Name;
    }

    public void setG20Name(String g20Name) {
        this.g20Name = g20Name;
    }

    public String getG20Fr() {
        return g20Fr;
    }

    public void setG20Fr(String g20Fr) {
        this.g20Fr = g20Fr;
    }

    public Integer getG21Count() {
        return g21Count;
    }

    public void setG21Count(Integer g21Count) {
        this.g21Count = g21Count;
    }

    public String getG21Code2() {
        return g21Code2;
    }

    public void setG21Code2(String g21Code2) {
        this.g21Code2 = g21Code2;
    }

    public String getG22A() {
        return g22A;
    }

    public void setG22A(String g22A) {
        this.g22A = g22A;
    }

    public BigDecimal getG22B() {
        return g22B;
    }

    public void setG22B(BigDecimal g22B) {
        this.g22B = g22B;
    }

    public BigDecimal getG23() {
        return g23;
    }

    public void setG23(BigDecimal g23) {
        this.g23 = g23;
    }

    public BigDecimal getG23Scale() {
        return g23Scale;
    }

    public void setG23Scale(BigDecimal g23Scale) {
        this.g23Scale = g23Scale;
    }

    public String getG24A() {
        return g24A;
    }

    public void setG24A(String g24A) {
        this.g24A = g24A;
    }

    public String getG24B() {
        return g24B;
    }

    public void setG24B(String g24B) {
        this.g24B = g24B;
    }

    public String getG25() {
        return g25;
    }

    public void setG25(String g25) {
        this.g25 = g25;
    }

    public String getG26() {
        return g26;
    }

    public void setG26(String g26) {
        this.g26 = g26;
    }

    public String getG281A() {
        return g281A;
    }

    public void setG281A(String g281A) {
        this.g281A = g281A;
    }

    public String getG281B() {
        return g281B;
    }

    public void setG281B(String g281B) {
        this.g281B = g281B;
    }

    public String getG282() {
        return g282;
    }

    public void setG282(String g282) {
        this.g282 = g282;
    }

    public String getG283() {
        return g283;
    }

    public void setG283(String g283) {
        this.g283 = g283;
    }

    public String getG284() {
        return g284;
    }

    public void setG284(String g284) {
        this.g284 = g284;
    }

    public String getG2841() {
        return g2841;
    }

    public void setG2841(String g2841) {
        this.g2841 = g2841;
    }

    public String getG285() {
        return g285;
    }

    public void setG285(String g285) {
        this.g285 = g285;
    }

    public String getG2851() {
        return g2851;
    }

    public void setG2851(String g2851) {
        this.g2851 = g2851;
    }

    public String getG29() {
        return g29;
    }

    public void setG29(String g29) {
        this.g29 = g29;
    }

    public Date getG48() {
        return g48;
    }

    public void setG48(Date g48) {
        this.g48 = g48;
    }

    public String getG49Name() {
        return g49Name;
    }

    public void setG49Name(String g49Name) {
        this.g49Name = g49Name;
    }

    public Date getG49Date() {
        return g49Date;
    }

    public void setG49Date(Date g49Date) {
        this.g49Date = g49Date;
    }

    public String getG50() {
        return g50;
    }

    public void setG50(String g50) {
        this.g50 = g50;
    }

    public String getG50B() {
        return g50B;
    }

    public void setG50B(String g50B) {
        this.g50B = g50B;
    }

    public String getG53() {
        return g53;
    }

    public void setG53(String g53) {
        this.g53 = g53;
    }

    public String getG53No() {
        return g53No;
    }

    public void setG53No(String g53No) {
        this.g53No = g53No;
    }

    public Date getG53Date() {
        return g53Date;
    }

    public void setG53Date(Date g53Date) {
        this.g53Date = g53Date;
    }

    public String getG53Code() {
        return g53Code;
    }

    public void setG53Code(String g53Code) {
        this.g53Code = g53Code;
    }

    public String getG54Place() {
        return g54Place;
    }

    public void setG54Place(String g54Place) {
        this.g54Place = g54Place;
    }

    public Date getG54Date() {
        return g54Date;
    }

    public void setG54Date(Date g54Date) {
        this.g54Date = g54Date;
    }

    public String getG54Phone() {
        return g54Phone;
    }

    public void setG54Phone(String g54Phone) {
        this.g54Phone = g54Phone;
    }

    public String getGacode() {
        return gacode;
    }

    public void setGacode(String gacode) {
        this.gacode = gacode;
    }

    public String getGaname() {
        return ganame;
    }

    public void setGaname(String ganame) {
        this.ganame = ganame;
    }

    public String getGaaddress() {
        return gaaddress;
    }

    public void setGaaddress(String gaaddress) {
        this.gaaddress = gaaddress;
    }

    public String getGaaccount1() {
        return gaaccount1;
    }

    public void setGaaccount1(String gaaccount1) {
        this.gaaccount1 = gaaccount1;
    }

    public String getGamfo1() {
        return gamfo1;
    }

    public void setGamfo1(String gamfo1) {
        this.gamfo1 = gamfo1;
    }

    public String getGaaccount2() {
        return gaaccount2;
    }

    public void setGaaccount2(String gaaccount2) {
        this.gaaccount2 = gaaccount2;
    }

    public String getGamfo2() {
        return gamfo2;
    }

    public void setGamfo2(String gamfo2) {
        this.gamfo2 = gamfo2;
    }

    public String getGc1Bankokpo() {
        return gc1Bankokpo;
    }

    public void setGc1Bankokpo(String gc1Bankokpo) {
        this.gc1Bankokpo = gc1Bankokpo;
    }

    public String getGc1Inn() {
        return gc1Inn;
    }

    public void setGc1Inn(String gc1Inn) {
        this.gc1Inn = gc1Inn;
    }

    public String getGc1Year() {
        return gc1Year;
    }

    public void setGc1Year(String gc1Year) {
        this.gc1Year = gc1Year;
    }

    public String getGc1Kntcode() {
        return gc1Kntcode;
    }

    public void setGc1Kntcode(String gc1Kntcode) {
        this.gc1Kntcode = gc1Kntcode;
    }

    public String getGc1Kntno() {
        return gc1Kntno;
    }

    public void setGc1Kntno(String gc1Kntno) {
        this.gc1Kntno = gc1Kntno;
    }

    public String getGc2Rgncode() {
        return gc2Rgncode;
    }

    public void setGc2Rgncode(String gc2Rgncode) {
        this.gc2Rgncode = gc2Rgncode;
    }

    public String getGc2Kntno() {
        return gc2Kntno;
    }

    public void setGc2Kntno(String gc2Kntno) {
        this.gc2Kntno = gc2Kntno;
    }

    public Date getGc2Date() {
        return gc2Date;
    }

    public void setGc2Date(Date gc2Date) {
        this.gc2Date = gc2Date;
    }

    public Date getGc3Date() {
        return gc3Date;
    }

    public void setGc3Date(Date gc3Date) {
        this.gc3Date = gc3Date;
    }

    public String getGc3Trantype() {
        return gc3Trantype;
    }

    public void setGc3Trantype(String gc3Trantype) {
        this.gc3Trantype = gc3Trantype;
    }

    public String getGc4Paspno() {
        return gc4Paspno;
    }

    public void setGc4Paspno(String gc4Paspno) {
        this.gc4Paspno = gc4Paspno;
    }

    public Date getGc4Date() {
        return gc4Date;
    }

    public void setGc4Date(Date gc4Date) {
        this.gc4Date = gc4Date;
    }

    public String getGda() {
        return gda;
    }

    public void setGda(String gda) {
        this.gda = gda;
    }

    public Date getGdb() {
        return gdb;
    }

    public void setGdb(Date gdb) {
        this.gdb = gdb;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPartyid() {
        return partyid;
    }

    public void setPartyid(String partyid) {
        this.partyid = partyid;
    }

    public BigDecimal getEurorate() {
        return eurorate;
    }

    public void setEurorate(BigDecimal eurorate) {
        this.eurorate = eurorate;
    }

    public String getG54Regcode() {
        return g54Regcode;
    }

    public void setG54Regcode(String g54Regcode) {
        this.g54Regcode = g54Regcode;
    }

    public String getGc2Knttype() {
        return gc2Knttype;
    }

    public void setGc2Knttype(String gc2Knttype) {
        this.gc2Knttype = gc2Knttype;
    }

    public String getG10() {
        return g10;
    }

    public void setG10(String g10) {
        this.g10 = g10;
    }

    public String getG27() {
        return g27;
    }

    public void setG27(String g27) {
        this.g27 = g27;
    }

    public String getG30() {
        return g30;
    }

    public void setG30(String g30) {
        this.g30 = g30;
    }

    public String getG51() {
        return g51;
    }

    public void setG51(String g51) {
        this.g51 = g51;
    }

    public String getG52() {
        return g52;
    }

    public void setG52(String g52) {
        this.g52 = g52;
    }

    public Date getG20Date() {
        return g20Date;
    }

    public void setG20Date(Date g20Date) {
        this.g20Date = g20Date;
    }

    public Date getGdvipdate() {
        return gdvipdate;
    }

    public void setGdvipdate(Date gdvipdate) {
        this.gdvipdate = gdvipdate;
    }

    public String getGdvipstamp() {
        return gdvipstamp;
    }

    public void setGdvipstamp(String gdvipstamp) {
        this.gdvipstamp = gdvipstamp;
    }

    public Timestamp getInstime() {
        return instime;
    }

    public void setInstime(Timestamp instime) {
        this.instime = instime;
    }

    public Timestamp getUpdtime() {
        return updtime;
    }

    public void setUpdtime(Timestamp updtime) {
        this.updtime = updtime;
    }

    public Short getFlagE() {
        return flagE;
    }

    public void setFlagE(Short flagE) {
        this.flagE = flagE;
    }

    public Timestamp getRegtime() {
        return regtime;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }

    public Timestamp getRegofrtime() {
        return regofrtime;
    }

    public void setRegofrtime(Timestamp regofrtime) {
        this.regofrtime = regofrtime;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Date getOfrdate() {
        return ofrdate;
    }

    public void setOfrdate(Date ofrdate) {
        this.ofrdate = ofrdate;
    }

    public String getG281C() {
        return g281C;
    }

    public void setG281C(String g281C) {
        this.g281C = g281C;
    }

    public String getGc3Expflag() {
        return gc3Expflag;
    }

    public void setGc3Expflag(String gc3Expflag) {
        this.gc3Expflag = gc3Expflag;
    }

    public String getG53Post() {
        return g53Post;
    }

    public void setG53Post(String g53Post) {
        this.g53Post = g53Post;
    }

    public String getGc2Cstcode() {
        return gc2Cstcode;
    }

    public void setGc2Cstcode(String gc2Cstcode) {
        this.gc2Cstcode = gc2Cstcode;
    }

    public String getFlagR() {
        return flagR;
    }

    public void setFlagR(String flagR) {
        this.flagR = flagR;
    }

    public String getPostpunkt() {
        return postpunkt;
    }

    public void setPostpunkt(String postpunkt) {
        this.postpunkt = postpunkt;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getGc1Bankinn() {
        return gc1Bankinn;
    }

    public void setGc1Bankinn(String gc1Bankinn) {
        this.gc1Bankinn = gc1Bankinn;
    }

    public String getG2Nameexp() {
        return g2Nameexp;
    }

    public void setG2Nameexp(String g2Nameexp) {
        this.g2Nameexp = g2Nameexp;
    }

    public String getG2Code1Exp() {
        return g2Code1Exp;
    }

    public void setG2Code1Exp(String g2Code1Exp) {
        this.g2Code1Exp = g2Code1Exp;
    }

    public String getG2Code2Exp() {
        return g2Code2Exp;
    }

    public void setG2Code2Exp(String g2Code2Exp) {
        this.g2Code2Exp = g2Code2Exp;
    }

    public String getG8Nameimp() {
        return g8Nameimp;
    }

    public void setG8Nameimp(String g8Nameimp) {
        this.g8Nameimp = g8Nameimp;
    }

    public String getG8Code1Imp() {
        return g8Code1Imp;
    }

    public void setG8Code1Imp(String g8Code1Imp) {
        this.g8Code1Imp = g8Code1Imp;
    }

    public String getG8Code2Imp() {
        return g8Code2Imp;
    }

    public void setG8Code2Imp(String g8Code2Imp) {
        this.g8Code2Imp = g8Code2Imp;
    }

    public String getG20Strana1() {
        return g20Strana1;
    }

    public void setG20Strana1(String g20Strana1) {
        this.g20Strana1 = g20Strana1;
    }

    public String getG20Strana2() {
        return g20Strana2;
    }

    public void setG20Strana2(String g20Strana2) {
        this.g20Strana2 = g20Strana2;
    }

    public String getG281D() {
        return g281D;
    }

    public void setG281D(String g281D) {
        this.g281D = g281D;
    }

    public String getG30Post() {
        return g30Post;
    }

    public void setG30Post(String g30Post) {
        this.g30Post = g30Post;
    }

    public String getG50Doc() {
        return g50Doc;
    }

    public void setG50Doc(String g50Doc) {
        this.g50Doc = g50Doc;
    }

    public String getG54Name() {
        return g54Name;
    }

    public void setG54Name(String g54Name) {
        this.g54Name = g54Name;
    }

    public String getG54Number() {
        return g54Number;
    }

    public void setG54Number(String g54Number) {
        this.g54Number = g54Number;
    }

    public String getG54Mail() {
        return g54Mail;
    }

    public void setG54Mail(String g54Mail) {
        this.g54Mail = g54Mail;
    }

    public String getG54Doc() {
        return g54Doc;
    }

    public void setG54Doc(String g54Doc) {
        this.g54Doc = g54Doc;
    }

    public Short getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(Short returnFlag) {
        this.returnFlag = returnFlag;
    }

    public String getG30Lno() {
        return g30Lno;
    }

    public void setG30Lno(String g30Lno) {
        this.g30Lno = g30Lno;
    }

    public Date getG30Date() {
        return g30Date;
    }

    public void setG30Date(Date g30Date) {
        this.g30Date = g30Date;
    }

    public Date getG50Date() {
        return g50Date;
    }

    public void setG50Date(Date g50Date) {
        this.g50Date = g50Date;
    }

    public String getG2Region() {
        return g2Region;
    }

    public void setG2Region(String g2Region) {
        this.g2Region = g2Region;
    }

    public String getG8Region() {
        return g8Region;
    }

    public void setG8Region(String g8Region) {
        this.g8Region = g8Region;
    }

    public String getG9Region() {
        return g9Region;
    }

    public void setG9Region(String g9Region) {
        this.g9Region = g9Region;
    }

    public String getG11B() {
        return g11B;
    }

    public void setG11B(String g11B) {
        this.g11B = g11B;
    }

    public String getG20K() {
        return g20K;
    }

    public void setG20K(String g20K) {
        this.g20K = g20K;
    }

    public String getG50Inn() {
        return g50Inn;
    }

    public void setG50Inn(String g50Inn) {
        this.g50Inn = g50Inn;
    }

    public String getG2Phone() {
        return g2Phone;
    }

    public void setG2Phone(String g2Phone) {
        this.g2Phone = g2Phone;
    }

    public String getG8Phone() {
        return g8Phone;
    }

    public void setG8Phone(String g8Phone) {
        this.g8Phone = g8Phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationEntity that = (DeclarationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(g1A, that.g1A) && Objects.equals(g1B, that.g1B) && Objects.equals(g1C, that.g1C) && Objects.equals(g2Code1, that.g2Code1) && Objects.equals(g2Name, that.g2Name) && Objects.equals(g2Address, that.g2Address) && Objects.equals(g2Add, that.g2Add) && Objects.equals(g2Code2, that.g2Code2) && Objects.equals(g2Paspno, that.g2Paspno) && Objects.equals(g2Paspdate, that.g2Paspdate) && Objects.equals(g2Paspdef, that.g2Paspdef) && Objects.equals(g2Date, that.g2Date) && Objects.equals(g3B, that.g3B) && Objects.equals(g4, that.g4) && Objects.equals(g5, that.g5) && Objects.equals(g6, that.g6) && Objects.equals(g7A, that.g7A) && Objects.equals(g7B, that.g7B) && Objects.equals(g7C, that.g7C) && Objects.equals(g8Code1, that.g8Code1) && Objects.equals(g8Name, that.g8Name) && Objects.equals(g8Address, that.g8Address) && Objects.equals(g8Add, that.g8Add) && Objects.equals(g8Code2, that.g8Code2) && Objects.equals(g8Paspno, that.g8Paspno) && Objects.equals(g8Paspdate, that.g8Paspdate) && Objects.equals(g8Paspdef, that.g8Paspdef) && Objects.equals(g8Date, that.g8Date) && Objects.equals(g9Code1, that.g9Code1) && Objects.equals(g9Name, that.g9Name) && Objects.equals(g9Address, that.g9Address) && Objects.equals(g9Code2, that.g9Code2) && Objects.equals(g9Date, that.g9Date) && Objects.equals(g11, that.g11) && Objects.equals(g12, that.g12) && Objects.equals(g13, that.g13) && Objects.equals(g14Code1, that.g14Code1) && Objects.equals(g14Name, that.g14Name) && Objects.equals(g14Address, that.g14Address) && Objects.equals(g14Code2, that.g14Code2) && Objects.equals(g14Date, that.g14Date) && Objects.equals(g15, that.g15) && Objects.equals(g16, that.g16) && Objects.equals(g17, that.g17) && Objects.equals(g18Count, that.g18Count) && Objects.equals(g18Code2, that.g18Code2) && Objects.equals(g19, that.g19) && Objects.equals(g20A, that.g20A) && Objects.equals(g20B, that.g20B) && Objects.equals(g20Name, that.g20Name) && Objects.equals(g20Fr, that.g20Fr) && Objects.equals(g21Count, that.g21Count) && Objects.equals(g21Code2, that.g21Code2) && Objects.equals(g22A, that.g22A) && Objects.equals(g22B, that.g22B) && Objects.equals(g23, that.g23) && Objects.equals(g23Scale, that.g23Scale) && Objects.equals(g24A, that.g24A) && Objects.equals(g24B, that.g24B) && Objects.equals(g25, that.g25) && Objects.equals(g26, that.g26) && Objects.equals(g281A, that.g281A) && Objects.equals(g281B, that.g281B) && Objects.equals(g282, that.g282) && Objects.equals(g283, that.g283) && Objects.equals(g284, that.g284) && Objects.equals(g2841, that.g2841) && Objects.equals(g285, that.g285) && Objects.equals(g2851, that.g2851) && Objects.equals(g29, that.g29) && Objects.equals(g48, that.g48) && Objects.equals(g49Name, that.g49Name) && Objects.equals(g49Date, that.g49Date) && Objects.equals(g50, that.g50) && Objects.equals(g50B, that.g50B) && Objects.equals(g53, that.g53) && Objects.equals(g53No, that.g53No) && Objects.equals(g53Date, that.g53Date) && Objects.equals(g53Code, that.g53Code) && Objects.equals(g54Place, that.g54Place) && Objects.equals(g54Date, that.g54Date) && Objects.equals(g54Phone, that.g54Phone) && Objects.equals(gacode, that.gacode) && Objects.equals(ganame, that.ganame) && Objects.equals(gaaddress, that.gaaddress) && Objects.equals(gaaccount1, that.gaaccount1) && Objects.equals(gamfo1, that.gamfo1) && Objects.equals(gaaccount2, that.gaaccount2) && Objects.equals(gamfo2, that.gamfo2) && Objects.equals(gc1Bankokpo, that.gc1Bankokpo) && Objects.equals(gc1Inn, that.gc1Inn) && Objects.equals(gc1Year, that.gc1Year) && Objects.equals(gc1Kntcode, that.gc1Kntcode) && Objects.equals(gc1Kntno, that.gc1Kntno) && Objects.equals(gc2Rgncode, that.gc2Rgncode) && Objects.equals(gc2Kntno, that.gc2Kntno) && Objects.equals(gc2Date, that.gc2Date) && Objects.equals(gc3Date, that.gc3Date) && Objects.equals(gc3Trantype, that.gc3Trantype) && Objects.equals(gc4Paspno, that.gc4Paspno) && Objects.equals(gc4Date, that.gc4Date) && Objects.equals(gda, that.gda) && Objects.equals(gdb, that.gdb) && Objects.equals(ownerId, that.ownerId) && Objects.equals(adminId, that.adminId) && Objects.equals(status, that.status) && Objects.equals(partyid, that.partyid) && Objects.equals(eurorate, that.eurorate) && Objects.equals(g54Regcode, that.g54Regcode) && Objects.equals(gc2Knttype, that.gc2Knttype) && Objects.equals(g10, that.g10) && Objects.equals(g27, that.g27) && Objects.equals(g30, that.g30) && Objects.equals(g51, that.g51) && Objects.equals(g52, that.g52) && Objects.equals(g20Date, that.g20Date) && Objects.equals(gdvipdate, that.gdvipdate) && Objects.equals(gdvipstamp, that.gdvipstamp) && Objects.equals(instime, that.instime) && Objects.equals(updtime, that.updtime) && Objects.equals(flagE, that.flagE) && Objects.equals(regtime, that.regtime) && Objects.equals(regofrtime, that.regofrtime) && Objects.equals(regdate, that.regdate) && Objects.equals(ofrdate, that.ofrdate) && Objects.equals(g281C, that.g281C) && Objects.equals(gc3Expflag, that.gc3Expflag) && Objects.equals(g53Post, that.g53Post) && Objects.equals(gc2Cstcode, that.gc2Cstcode) && Objects.equals(flagR, that.flagR) && Objects.equals(postpunkt, that.postpunkt) && Objects.equals(num, that.num) && Objects.equals(gc1Bankinn, that.gc1Bankinn) && Objects.equals(g2Nameexp, that.g2Nameexp) && Objects.equals(g2Code1Exp, that.g2Code1Exp) && Objects.equals(g2Code2Exp, that.g2Code2Exp) && Objects.equals(g8Nameimp, that.g8Nameimp) && Objects.equals(g8Code1Imp, that.g8Code1Imp) && Objects.equals(g8Code2Imp, that.g8Code2Imp) && Objects.equals(g20Strana1, that.g20Strana1) && Objects.equals(g20Strana2, that.g20Strana2) && Objects.equals(g281D, that.g281D) && Objects.equals(g30Post, that.g30Post) && Objects.equals(g50Doc, that.g50Doc) && Objects.equals(g54Name, that.g54Name) && Objects.equals(g54Number, that.g54Number) && Objects.equals(g54Mail, that.g54Mail) && Objects.equals(g54Doc, that.g54Doc) && Objects.equals(returnFlag, that.returnFlag) && Objects.equals(g30Lno, that.g30Lno) && Objects.equals(g30Date, that.g30Date) && Objects.equals(g50Date, that.g50Date) && Objects.equals(g2Region, that.g2Region) && Objects.equals(g8Region, that.g8Region) && Objects.equals(g9Region, that.g9Region) && Objects.equals(g11B, that.g11B) && Objects.equals(g20K, that.g20K) && Objects.equals(g50Inn, that.g50Inn) && Objects.equals(g2Phone, that.g2Phone) && Objects.equals(g8Phone, that.g8Phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, g1A, g1B, g1C, g2Code1, g2Name, g2Address, g2Add, g2Code2, g2Paspno, g2Paspdate, g2Paspdef, g2Date, g3B, g4, g5, g6, g7A, g7B, g7C, g8Code1, g8Name, g8Address, g8Add, g8Code2, g8Paspno, g8Paspdate, g8Paspdef, g8Date, g9Code1, g9Name, g9Address, g9Code2, g9Date, g11, g12, g13, g14Code1, g14Name, g14Address, g14Code2, g14Date, g15, g16, g17, g18Count, g18Code2, g19, g20A, g20B, g20Name, g20Fr, g21Count, g21Code2, g22A, g22B, g23, g23Scale, g24A, g24B, g25, g26, g281A, g281B, g282, g283, g284, g2841, g285, g2851, g29, g48, g49Name, g49Date, g50, g50B, g53, g53No, g53Date, g53Code, g54Place, g54Date, g54Phone, gacode, ganame, gaaddress, gaaccount1, gamfo1, gaaccount2, gamfo2, gc1Bankokpo, gc1Inn, gc1Year, gc1Kntcode, gc1Kntno, gc2Rgncode, gc2Kntno, gc2Date, gc3Date, gc3Trantype, gc4Paspno, gc4Date, gda, gdb, ownerId, adminId, status, partyid, eurorate, g54Regcode, gc2Knttype, g10, g27, g30, g51, g52, g20Date, gdvipdate, gdvipstamp, instime, updtime, flagE, regtime, regofrtime, regdate, ofrdate, g281C, gc3Expflag, g53Post, gc2Cstcode, flagR, postpunkt, num, gc1Bankinn, g2Nameexp, g2Code1Exp, g2Code2Exp, g8Nameimp, g8Code1Imp, g8Code2Imp, g20Strana1, g20Strana2, g281D, g30Post, g50Doc, g54Name, g54Number, g54Mail, g54Doc, returnFlag, g30Lno, g30Date, g50Date, g2Region, g8Region, g9Region, g11B, g20K, g50Inn, g2Phone, g8Phone);
    }
}
