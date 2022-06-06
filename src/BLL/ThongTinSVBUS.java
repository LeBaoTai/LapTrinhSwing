package BLL;

import DAL.ThongTinSVDAL;
import DTO.ThongTinSVDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ThongTinSVBUS {
    private String __msMssv;
    private String __msHoTen;
    private String __msLop;
    private String __msKhoa;

    public ThongTinSVBUS(String mssv) {
        this.__msMssv = mssv;
    }
    public ThongTinSVBUS(String mssv, String hoten, String lop, String khoa) {
        this.__msMssv = mssv;
        this.__msHoTen = hoten;
        this.__msLop = lop;
        this.__msKhoa = khoa;
    }

    public boolean checkThongTin() {
        try {
            ArrayList<ThongTinSVDTO> listThongTin = new ThongTinSVDAL().getData();
            for (ThongTinSVDTO thongTinSVDTO: listThongTin) {
                if (thongTinSVDTO.get__msMssv().equals(this.__msMssv)){
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
