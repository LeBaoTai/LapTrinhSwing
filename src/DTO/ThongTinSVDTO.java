package DTO;

public class ThongTinSVDTO {
    private String __msMssv;
    private String __msHoTen;
    private String __msLop;
    private String __msKhoa;

    public static int countSV = 0;

    public ThongTinSVDTO() {

    }

    public ThongTinSVDTO(String mssv, String hoten, String lop, String khoa) {
        this.__msMssv = mssv;
        this.__msHoTen = hoten;
        this.__msLop = lop;
        this.__msKhoa = khoa;
    }

    public void set__msMssv(String __msMssv) {
        this.__msMssv = __msMssv;
    }

    public String get__msMssv() {
        return __msMssv;
    }

    public void set__msKhoa(String __msKhoa) {
        this.__msKhoa = __msKhoa;
    }

    public String get__msKhoa() {
        return __msKhoa;
    }

    public void set__msHoTen(String __msHoTen) {
        this.__msHoTen = __msHoTen;
    }

    public String get__msHoTen() {
        return __msHoTen;
    }

    public void set__msLop(String __msLop) {
        this.__msLop = __msLop;
    }

    public String get__msLop() {
        return __msLop;
    }

    @Override
    public String toString() {
        return __msMssv + " " + __msHoTen + " " + __msLop + " " + __msKhoa;
    }
}
