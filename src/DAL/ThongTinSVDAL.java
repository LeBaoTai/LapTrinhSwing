package DAL;

import DTO.ThongTinSVDTO;

import java.sql.*;
import java.util.ArrayList;

public class ThongTinSVDAL {
    public ArrayList<ThongTinSVDTO> getData() throws SQLException {
        String sql = "Select * from tblthongtinsv";
        try (
                Connection conn = new DatabaseAccess().getConn();
                Statement stm = conn.createStatement()
        ) {
            try (ResultSet rs = stm.executeQuery(sql)) {
                ArrayList<ThongTinSVDTO> listThongTinSV = new ArrayList<>();
                while (rs.next()) {
                    ThongTinSVDTO thongTinSVDTO = new ThongTinSVDTO();

                    thongTinSVDTO.set__msMssv(rs.getString("msMssv"));
                    thongTinSVDTO.set__msHoTen(rs.getString("msHoTen"));
                    thongTinSVDTO.set__msLop(rs.getString("msLop"));
                    thongTinSVDTO.set__msKhoa(rs.getString("msKhoa"));
                    listThongTinSV.add(thongTinSVDTO);
                }
                return listThongTinSV;
            }
        }
    }

    public boolean insertData(ThongTinSVDTO thongTin) throws Exception{
        String sql = "INSERT INTO tblthongtinsv(`msMssv`, `msHoTen`, `msLop`, `msKhoa`) " +
                "VALUES(?, ?, ?, ?)";
        try (Connection conn = new DatabaseAccess().getConn()) {
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, thongTin.get__msMssv());
                statement.setString(2, thongTin.get__msHoTen());
                statement.setString(3, thongTin.get__msLop());;
                statement.setString(4, thongTin.get__msKhoa());

                boolean result = statement.executeUpdate() > 0;
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public boolean deleteData(String mssv) throws Exception{
        String sql = "DELETE FROM tblthongtinsv WHERE msMssv=?";
        try (Connection conn = new DatabaseAccess().getConn()) {
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, mssv);
                boolean result = statement.executeUpdate() > 0;
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean updateData(String data, String mssv, int column) throws Exception{
        String sql = null;
        if (column == 0 ) {
            sql = "UPDATE `tblthongtinsv` SET `msMssv`=? WHERE msMssv=?";
        } else if (column == 1) {
            sql = "UPDATE `tblthongtinsv` SET `msHoTen`=? WHERE msMssv=?";
        } else if (column == 2) {
            sql = "UPDATE `tblthongtinsv` SET `msLop`=? WHERE msMssv=?";
        } else if (column == 3) {
            sql = "UPDATE `tblthongtinsv` SET `msKhoa`=? WHERE msMssv=?";
        }

        try (Connection conn = new DatabaseAccess().getConn()) {
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, data);
                statement.setString(2, mssv);
                boolean result = statement.executeUpdate() > 0;
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
